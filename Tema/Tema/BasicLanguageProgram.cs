public class BasicLanguageInterpreter : BasicLanguageBaseVisitor<object>
{
    private readonly Dictionary<string, object> symbolTable = new Dictionary<string, object>();
    private readonly Dictionary<string, Func<List<object>, object>> functionTable = new Dictionary<string, Func<List<object>, object>>();
    private List<string> tokenList = new List<string>();

    public string TokenList { get; private set; } = "";
    public string GlobalVariables { get; private set; } = "";
    public string Functions { get; private set; } = "";
    public string ControlStructures { get; private set; } = "";

    // Constructor: Register functions
    public BasicLanguageInterpreter()
    {
        functionTable["addIntegers"] = args =>
        {
            int first = (int)args[0];
            int second = (int)args[1];
            return first + second;
        };

        functionTable["divideIntegers"] = args =>
        {
            int first = (int)args[0];
            int second = (int)args[1];
            if (second == 0)
            {
                return 0; // Return 0 if dividing by zero
            }
            return first / second;
        };
    }

    // Visit method for program to collect tokens and save them to a file
    public override object VisitProgram(BasicLanguageParser.ProgramContext context)
    {
        foreach (var child in context.children)
        {
            string token = child.GetText();
            tokenList.Add(token);
        }

        foreach (var child in context.children)
        {
            Visit(child);
        }

        File.WriteAllLines("tokens.txt", tokenList);
        return null;
    }

    public override object VisitGlobalDeclaration(BasicLanguageParser.GlobalDeclarationContext context)
    {
        var type = context.type().GetText();
        var id = context.ID().GetText();

        // Evaluăm expresia și obținem valoarea corectă
        object value = context.expr() != null ? Visit(context.expr()) : null;

        // Adăugăm variabila în symbolTable
        symbolTable[id] = value;

        if (value is double || value is float)
        {
            GlobalVariables += $"{type} {id} = {value:F2};\n"; // Formatarea valorii de tip double
        }
        else
        {
            GlobalVariables += $"{type} {id} = {value};\n";
        }

        return base.VisitGlobalDeclaration(context);
    }

    public override object VisitFunctionDecl(BasicLanguageParser.FunctionDeclContext context)
    {
        string funcName = context.ID().GetText();
        List<string> paramNames = context.parameters()?.parameter()
            .Select(p => p.ID().GetText())
            .ToList() ?? new List<string>();

        functionTable[funcName] = (args) =>
        {
            // Create a new symbol table for the function
            var localSymbols = new Dictionary<string, object>();
            for (int i = 0; i < paramNames.Count; i++)
            {
                localSymbols[paramNames[i]] = args[i];
            }

            // Evaluate the function's block (body)
            Visit(context.block());

            return null;
        };

        return null;
    }

    public override object VisitExpr(BasicLanguageParser.ExprContext context)
    {
        // Handle literals, variables, and expressions

        if (context.literal() != null)
        {
            return Visit(context.literal());
        }

        if (context.ID() != null)
        {
            string varName = context.ID().GetText();

            // Check if variable exists
            if (symbolTable.ContainsKey(varName))
            {
                return symbolTable[varName];
            }
            else
            {
                throw new Exception($"Undefined variable: {varName}");
            }
        }

        // Handle arithmetic operations (binary expressions)
        if (context.children.Count == 3)
        {
            object left = Visit(context.expr(0));
            string op = context.children[1].GetText();
            object right = Visit(context.expr(1));

            // Check types before performing operations
            if (left == null || right == null)
            {
                throw new Exception("Cannot perform operations with null values.");
            }

            switch (op)
            {
                case "+":
                    CheckTypeCompatibility(left, right, "int");
                    return (int)left + (int)right;

                case "-":
                    CheckTypeCompatibility(left, right, "int");
                    return (int)left - (int)right;

                case "*":
                    CheckTypeCompatibility(left, right, "int");
                    return (int)left * (int)right;

                case "/":
                    CheckTypeCompatibility(left, right, "int");
                    if ((int)right == 0)
                    {
                        throw new Exception("Division by zero.");
                    }
                    return (int)left / (int)right;

                case "%":
                    CheckTypeCompatibility(left, right, "int");
                    return (int)left % (int)right;

                case "<":
                    CheckTypeCompatibility(left, right, "int");
                    return (int)left < (int)right;

                case ">":
                    CheckTypeCompatibility(left, right, "int");
                    return (int)left > (int)right;

                case "==":
                    return left.Equals(right);

                case "!=":
                    return !left.Equals(right);
            }
        }

        // Handle logical operations (AND, OR)
        if (context.children.Count == 3 && context.AND() != null)
        {
            object left = Visit(context.expr(0));
            object right = Visit(context.expr(1));
            CheckTypeCompatibility(left, right, "bool");
            return (bool)left && (bool)right;
        }

        if (context.children.Count == 3 && context.OR() != null)
        {
            object left = Visit(context.expr(0));
            object right = Visit(context.expr(1));
            CheckTypeCompatibility(left, right, "bool");
            return (bool)left || (bool)right;
        }

        // Handle unary operators
        if (context.children.Count == 2)
        {
            string op = context.children[0].GetText();
            object operand = Visit(context.expr(0));
            if (op == "!")
            {
                if (operand == null)
                {
                    throw new Exception("Cannot negate a null value.");
                }
                return !(bool)operand;
            }
        }

        return null;
    }

    public override object VisitIfStatement(BasicLanguageParser.IfStatementContext context)
    {
        bool condition = (bool)Visit(context.expr()); // Evaluăm condiția

        if (condition)
        {
            Visit(context.statement(0)); // Executăm prima ramură
        }
        else if (context.statement(1) != null)
        {
            Visit(context.statement(1)); // Executăm ramura else, dacă există
        }

        return null;
    }


    public override object VisitForStatement(BasicLanguageParser.ForStatementContext context)
    {
        // Inițializare
        if (context.forInit() != null)
        {
            Visit(context.forInit());
        }

        // Condiție și corp
        while (context.forCondition() == null || (bool)Visit(context.forCondition()))
        {
            Visit(context.statement()); // Executăm corpul ciclului

            // Increment
            if (context.forIncrement() != null)
            {
                Visit(context.forIncrement());
            }
        }

        return null;
    }

    public override object VisitWhileStatement(BasicLanguageParser.WhileStatementContext context)
    {
        // Evaluăm condiția
        while ((bool)Visit(context.expr()))
        {
            // Executăm corpul ciclului
            Visit(context.statement());
        }

        return null;
    }



    public override object VisitLiteral(BasicLanguageParser.LiteralContext context)
    {
        if (context.NUMBER() != null)
        {
            string text = context.NUMBER().GetText();

            // Verifică dacă este un număr cu zecimale (double)
            if (text.Contains("."))
            {
                // Încearcă să parsezi numărul ca double
                if (double.TryParse(text, out double doubleValue))
                {
                    return doubleValue;
                }
                else
                {
                    throw new FormatException($"Invalid float or double format: {text}");
                }
            }

            // Dacă nu este un număr cu zecimale, atunci e un integer
            return int.Parse(text);
        }

        if (context.STRING_LITERAL() != null)
        {
            return context.STRING_LITERAL().GetText().Trim('"'); // Îndepărtează ghilimelele
        }

        return null;
    }

    public override object VisitFunctionCall(BasicLanguageParser.FunctionCallContext context)
    {
        string funcName = context.ID().GetText();
        var args = context.arguments()?.expr().Select(e => Visit(e)).ToList() ?? new List<object>();

        if (!functionTable.ContainsKey(funcName))
        {
            throw new Exception($"Undefined function: {funcName}");
        }

        return functionTable[funcName](args);
    }

    // Method to save variables to a file
    public void SaveVariablesToFile()
    {
        var variableLines = symbolTable.Select(kv => $"{kv.Key} = {kv.Value}").ToList();

        // Debug: Log to console what is being written to file
        Console.WriteLine("Saving variables to file:");
        foreach (var line in variableLines)
        {
            Console.WriteLine(line);
        }

        File.WriteAllLines("variables.txt", variableLines);
    }

    // Method to save functions to a file
    public void SaveFunctionsToFile()
    {
        var functionLines = functionTable.Select(kv =>
        {
            var paramList = kv.Value.Method.GetParameters()
                .Select(p => p.Name).ToList();
            return $"{kv.Key}({string.Join(", ", paramList)})";
        }).ToList();
        File.WriteAllLines("functions.txt", functionLines);
    }

    // Helper method to check type compatibility
    private void CheckTypeCompatibility(object left, object right, string expectedType)
    {
        if (left.GetType().Name != expectedType || right.GetType().Name != expectedType)
        {
            throw new Exception($"Incompatible types: {left.GetType().Name} and {right.GetType().Name}. Expected: {expectedType}.");
        }
    }
}
