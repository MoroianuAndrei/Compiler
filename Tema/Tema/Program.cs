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

        // Save the results to files
        interpreter.SaveVariablesToFile();
        interpreter.SaveFunctionsToFile();

        Console.WriteLine("Program executed. Results saved to files.");
    }
}


public class BasicLanguageVisitor : BasicLanguageBaseVisitor<object>
{
    private readonly Dictionary<string, object> symbolTable = new Dictionary<string, object>(); // Asigură-te că există această declarație
    public string TokenList { get; private set; } = "";
    public string GlobalVariables { get; private set; } = "";
    public string Functions { get; private set; } = "";
    public string ControlStructures { get; private set; } = "";

    public override object VisitDeclaration(BasicLanguageParser.DeclarationContext context)
    {
        string varName = context.ID().GetText();
        object value = context.expr() != null ? Visit(context.expr()) : null;

        // Add the variable to symbolTable
        symbolTable[varName] = value;

        // For global variable declarations, we also add to GlobalVariables string
        string type = context.type().GetText();
        if (value is double || value is float)
        {
            GlobalVariables += $"{type} {varName} = {value:F2};\n"; // Formatting the double value
        }
        else
        {
            GlobalVariables += $"{type} {varName} = {value};\n";
        }

        return null;
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