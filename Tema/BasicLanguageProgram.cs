using System;
using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime;

public class BasicLanguageInterpreter : BasicLanguageBaseVisitor<object>
{
    private readonly Dictionary<string, object> symbolTable = new Dictionary<string, object>();
    private readonly Dictionary<string, Func<List<object>, object>> functionTable = new Dictionary<string, Func<List<object>, object>>();

    public override object VisitProgram(BasicLanguageParser.ProgramContext context)
    {
        // Visit each statement in the program
        foreach (var child in context.children)
        {
            Visit(child);
        }
        return null;
    }

    public override object VisitGlobalDeclaration(BasicLanguageParser.GlobalDeclarationContext context)
    {
        // Global variable declaration
        string varName = context.ID().GetText();
        string type = context.type().GetText();
        object value = context.expr() != null ? (Visit(context.expr()) ?? 0) : null;

        symbolTable[varName] = value;
        return null;
    }

    public override object VisitFunctionDecl(BasicLanguageParser.FunctionDeclContext context)
    {
        // Function declaration
        string funcName = context.ID().GetText();
        List<string> paramNames = context.parameters()?.parameter()
            .Select(p => p.ID().GetText())
            .ToList() ?? new List<string>();

        functionTable[funcName] = (args) =>
        {
            var localSymbols = new Dictionary<string, object>();
            for (int i = 0; i < paramNames.Count; i++)
            {
                localSymbols[paramNames[i]] = args[i];
            }

            // Execute function body
            Visit(context.block());

            return null;
        };

        return null;
    }

    public override object VisitIfStatement(BasicLanguageParser.IfStatementContext context)
    {
        // If statement
        var condition = (bool)Visit(context.expr());
        if (condition)
        {
            Visit(context.statement(0));
        }
        else if (context.ELSE() != null)
        {
            Visit(context.statement(1));
        }
        return null;
    }

    public override object VisitForStatement(BasicLanguageParser.ForStatementContext context)
    {
        // For loop
        Visit(context.forInit());

        while ((bool)Visit(context.forCondition()))
        {
            Visit(context.statement());
            Visit(context.forIncrement());
        }
        return null;
    }

    public override object VisitWhileStatement(BasicLanguageParser.WhileStatementContext context)
    {
        // While loop
        while ((bool)Visit(context.expr()))
        {
            Visit(context.statement());
        }
        return null;
    }

    public override object VisitReturnStatement(BasicLanguageParser.ReturnStatementContext context)
    {
        // Return statement
        return Visit(context.expr());
    }

    public override object VisitDeclaration(BasicLanguageParser.DeclarationContext context)
    {
        // Variable declaration
        string varName = context.ID().GetText();
        object value = context.expr() != null ? Visit(context.expr()) : null;

        symbolTable[varName] = value;
        return null;
    }

    public override object VisitExpr(BasicLanguageParser.ExprContext context)
    {
        // Handle expressions: literals, variables, operators
        if (context.literal() != null)
        {
            return Visit(context.literal());
        }
        if (context.ID() != null)
        {
            return symbolTable[context.ID().GetText()];
        }

        // Handle arithmetic operations (binary expressions)
        if (context.children.Count == 3)
        {
            object left = Visit(context.expr(0));
            string op = context.children[1].GetText();
            object right = Visit(context.expr(1));

            switch (op)
            {
                case "+": return (double)left + (double)right;
                case "-": return (double)left - (double)right;
                case "*": return (double)left * (double)right;
                case "/": return (double)left / (double)right;
                case "%": return (double)left % (double)right;
                case "<": return (double)left < (double)right;
                case ">": return (double)left > (double)right;
                case "==": return left.Equals(right);
                case "!=": return !left.Equals(right);
            }
        }

        // Handle unary operators
        if (context.children.Count == 2)
        {
            string op = context.children[0].GetText();
            object operand = Visit(context.expr(0));
            if (op == "!")
            {
                return !(bool)operand;
            }
        }

        // Handle logical operators (AND, OR)
        if (context.children.Count == 3 && context.AND() != null)
        {
            object left = Visit(context.expr(0));
            object right = Visit(context.expr(1));
            return (bool)left && (bool)right;
        }

        if (context.children.Count == 3 && context.OR() != null)
        {
            object left = Visit(context.expr(0));
            object right = Visit(context.expr(1));
            return (bool)left || (bool)right;
        }

        return null;
    }

    public override object VisitLiteral(BasicLanguageParser.LiteralContext context)
    {
        // Handle literals: number or string
        if (context.NUMBER() != null)
        {
            return double.Parse(context.NUMBER().GetText());
        }
        if (context.STRING_LITERAL() != null)
        {
            return context.STRING_LITERAL().GetText().Trim('"');
        }
        return null;
    }

    public override object VisitFunctionCall(BasicLanguageParser.FunctionCallContext context)
    {
        // Function call
        string funcName = context.ID().GetText();
        var args = context.arguments()?.expr().Select(e => Visit(e)).ToList() ?? new List<object>();
        return functionTable[funcName](args);
    }
}
