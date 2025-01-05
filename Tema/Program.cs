using System;
using System.IO;
using Antlr4.Runtime;

class Program
{
    static void Main(string[] args)
    {
        string sourceFile = @"../../../program.txt";
        string sourceCode = File.ReadAllText(sourceFile);

        // Create lexer and parser
        AntlrInputStream inputStream = new AntlrInputStream(sourceCode);
        BasicLanguageLexer lexer = new BasicLanguageLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        BasicLanguageParser parser = new BasicLanguageParser(tokenStream);

        // Parse the source code
        var tree = parser.program();

        // Interpret the code
        var interpreter = new BasicLanguageInterpreter();
        interpreter.Visit(tree);

        Console.WriteLine("Program executed.");
    }
}


public class BasicLanguageVisitor : BasicLanguageBaseVisitor<object>
{
    public string TokenList { get; private set; } = "";
    public string GlobalVariables { get; private set; } = "";
    public string Functions { get; private set; } = "";
    public string ControlStructures { get; private set; } = "";

    public override object VisitDeclaration(BasicLanguageParser.DeclarationContext context)
    {
        var type = context.type().GetText();
        var id = context.ID().GetText();
        var value = context.expr()?.GetText() ?? "null";
        GlobalVariables += $"{type} {id} = {value};\n";
        return base.VisitDeclaration(context);
    }

    public override object VisitFunctionDecl(BasicLanguageParser.FunctionDeclContext context)
    {
        var returnType = context.type().GetText();
        var functionName = context.ID().GetText();

        // Get parameters if they exist
        var parameters = context.parameters()?.parameter()
            .Select(p => $"{p.type().GetText()} {p.ID().GetText()}")
            .ToList() ?? new List<string>();

        var parameterString = string.Join(", ", parameters);
        Functions += $"{returnType} {functionName}({parameterString});\n";

        return base.VisitFunctionDecl(context);
    }

    public override object VisitIfStatement(BasicLanguageParser.IfStatementContext context)
    {
        var line = context.Start.Line;
        ControlStructures += $"if-statement on line {line}\n";
        return base.VisitIfStatement(context);
    }

    public override object VisitProgram(BasicLanguageParser.ProgramContext context)
    {
        TokenList = string.Join("\n", context.children?.Select(c => c.GetText()) ?? new string[0]);
        return base.VisitProgram(context);
    }
}