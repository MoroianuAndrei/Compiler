using System;
using System.IO;
using Antlr4.Runtime;

class Program
{
    static void Main(string[] args)
    {
        // Citirea programului sursă
        string sourceFile = @"../../../program.txt";
        string sourceCode = File.ReadAllText(sourceFile);

        // Crearea lexer-ului și parser-ului
        AntlrInputStream inputStream = new AntlrInputStream(sourceCode);
        BasicLanguageLexer lexer = new BasicLanguageLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        BasicLanguageParser parser = new BasicLanguageParser(tokenStream);

        // Detectarea erorilor lexicale
        lexer.RemoveErrorListeners();
        lexer.AddErrorListener(new ConsoleErrorListener<int>());
        parser.RemoveErrorListeners();
        parser.AddErrorListener(new ConsoleErrorListener<IToken>());

        // Parsarea codului
        var tree = parser.program();

        // Procesarea AST-ului cu Visitor-ul
        var visitor = new BasicLanguageVisitor();
        visitor.Visit(tree);

        // Salvarea rezultatelor
        File.WriteAllText("tokens.txt", visitor.TokenList);
        File.WriteAllText("variables.txt", visitor.GlobalVariables);
        File.WriteAllText("functions.txt", visitor.Functions);
        File.WriteAllText("control_structures.txt", visitor.ControlStructures);

        Console.WriteLine("Procesare completă. Rezultatele au fost salvate în fișiere.");
    }
}

class BasicLanguageVisitor : BasicLanguageBaseVisitor<object>
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

    public override object VisitFunction(BasicLanguageParser.FunctionContext context)
    {
        var returnType = context.type().GetText();
        var functionName = context.ID().GetText();
        Functions += $"{returnType} {functionName}(...);\n";
        return base.VisitFunction(context);
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
