grammar BasicLanguage;

@parser::members {
    // Symbol tables for tracking declarations
    private HashSet<string> globalVars = new HashSet<string>();
    private HashSet<string> functions = new HashSet<string>();
    private Dictionary<string, HashSet<string>> functionLocalVars = new Dictionary<string, HashSet<string>>();
    
    // Track current scope
    private string currentFunction = "";
    private bool isInFunction = false;
        private Dictionary<string, int> globalVarValues = new Dictionary<string, int>();
    private Dictionary<string, int> localVarValues = new Dictionary<string, int>();

    // Evaluate expressions
    private int EvaluateExpr(string varName, int newValue) {
        if (isInFunction) {
            if (localVarValues.ContainsKey(varName)) {
                localVarValues[varName] = newValue;
            } else if (globalVarValues.ContainsKey(varName)) {
                globalVarValues[varName] = newValue;
            }
        } else {
            if (globalVarValues.ContainsKey(varName)) {
                globalVarValues[varName] = newValue;
            }
        }
        return newValue;
    }

    // Get variable value
    private int GetVarValue(string varName, int line) {
        if (isInFunction && localVarValues.ContainsKey(varName)) {
            return localVarValues[varName];
        } else if (globalVarValues.ContainsKey(varName)) {
            return globalVarValues[varName];
        }
        Console.WriteLine($"Error: Variable '{varName}' used without being initialized at line {line}");
        return 0;
    }

    // Assign variable
    private void AssignVar(string varName, int value, int line) {
        if (VarExists(varName)) {
            EvaluateExpr(varName, value);
        } else {
            Console.WriteLine($"Error: Variable '{varName}' is not declared at line {line}");
        }
    }
    // Helper method to check if a variable exists in current scope
    private bool VarExistsInCurrentScope(string varName) {
        if (isInFunction) {
            return functionLocalVars[currentFunction].Contains(varName);
        }
        return false;
    }
    
    // Helper method to check if a variable exists (either local or global)
    private bool VarExists(string varName) {
        if (isInFunction) {
            return functionLocalVars[currentFunction].Contains(varName) || globalVars.Contains(varName);
        }
        return globalVars.Contains(varName);
    }
    
    // Helper method to declare a variable
    private void DeclareVar(string varName, int line) {
        if (isInFunction) {
            if (VarExistsInCurrentScope(varName)) {
                Console.WriteLine($"Error: Duplicate local variable '{varName}' in function '{currentFunction}' at line {line}");
            } else {
                functionLocalVars[currentFunction].Add(varName);
            }
        } else {
            if (globalVars.Contains(varName)) {
                Console.WriteLine($"Error: Duplicate global variable '{varName}' at line {line}");
            } else {
                globalVars.Add(varName);
            }
        }
    }
    
    // Helper method to check for duplicate functions
    private void DeclareFunction(string funcName, int line) {
        if (functions.Contains(funcName)) {
            Console.WriteLine($"Error: Duplicate function declaration '{funcName}' at line {line}");
        } else {
            functions.Add(funcName);
            functionLocalVars[funcName] = new HashSet<string>();
        }
    }
    
    // Helper method to validate variable use
    private void ValidateVarUse(string varName, int line) {
        if (!VarExists(varName)) {
            Console.WriteLine($"Error: Variable '{varName}' used before declaration at line {line}");
        }
    }
    
    // Helper method to validate function call
    private void ValidateFunctionCall(string funcName, int line) {
        if (!functions.Contains(funcName)) {
            Console.WriteLine($"Error: Function '{funcName}' called before declaration at line {line}");
        }
    }
    
    // Helper method to enter a function scope
    private void EnterFunction(string funcName) {
        currentFunction = funcName;
        isInFunction = true;
        if (!functionLocalVars.ContainsKey(funcName)) {
            functionLocalVars[funcName] = new HashSet<string>();
        }
    }
    
    // Helper method to exit function scope
    private void ExitFunction() {
        currentFunction = "";
        isInFunction = false;
    }
}

// Tokens
INT: 'int';
FLOAT: 'float';
DOUBLE: 'double';
STRING: 'string';
VOID: 'void';
IF: 'if';
ELSE: 'else';
FOR: 'for';
WHILE: 'while';
RETURN: 'return';
ID: [a-zA-Z_][a-zA-Z0-9_]*;
NUMBER: [0-9]+ ('.' [0-9]+)?;
STRING_LITERAL: '"' .*? '"';
PLUS: '+';
MINUS: '-';
STAR: '*';
SLASH: '/';
MOD: '%';
LT: '<';
GT: '>';
LE: '<=';
GE: '>=';
EQ: '==';
NE: '!=';
AND: '&&';
OR: '||';
NOT: '!';
ASSIGN: '=';
PLUS_ASSIGN: '+=';
MINUS_ASSIGN: '-=';
STAR_ASSIGN: '*=';
SLASH_ASSIGN: '/=';
MOD_ASSIGN: '%=';
INCREMENT: '++';
DECREMENT: '--';
LPAREN: '(';
RPAREN: ')';
LBRACE: '{';
RBRACE: '}';
COMMA: ',';
SEMICOLON: ';';
COMMENT: '//' ~[\r\n]* -> skip;
BLOCK_COMMENT: '/*' .*? '*/' -> skip;
WS: [ \t\r\n]+ -> skip;

// Modified Parser Rules
program: (functionDecl | globalDeclaration)* EOF;

functionDecl:
	type ID {
        DeclareFunction($ID.text, $ID.line);
        EnterFunction($ID.text);
    } LPAREN parameters? RPAREN (SEMICOLON | block) {
        ExitFunction();
    };

globalDeclaration:
	type ID {DeclareVar($ID.text, $ID.line);} (ASSIGN expr)? SEMICOLON;

parameters: parameter (COMMA parameter)*;
parameter: type ID {DeclareVar($ID.text, $ID.line);};

declaration:
	type ID {DeclareVar($ID.text, $ID.line);} (ASSIGN expr)? SEMICOLON;

block: LBRACE statement* RBRACE;

statement:
	ifStatement
	| forStatement
	| whileStatement
	| returnStatement
	| declaration
	| expressionStatement
	| block;

expressionStatement: expr SEMICOLON;

forStatement:
	FOR LPAREN forInit forCondition forIncrement RPAREN statement;

forInit: (
		type ID {DeclareVar($ID.text, $ID.line);} ASSIGN expr SEMICOLON
	)
	| (expr? SEMICOLON);

forCondition: expr? SEMICOLON;
forIncrement: expr?;

ifStatement: IF LPAREN expr RPAREN statement (ELSE statement)?;
whileStatement: WHILE LPAREN expr RPAREN statement;
returnStatement: RETURN expr? SEMICOLON;

expr:
	literal
	| ID {ValidateVarUse($ID.text, $ID.line);}
	| LPAREN expr RPAREN
	| expr (STAR | SLASH | MOD) expr
	| expr (PLUS | MINUS) expr
	| expr (LT | GT | LE | GE) expr
	| expr (EQ | NE) expr
	| expr AND expr
	| expr OR expr
	| NOT expr
	| ID {ValidateVarUse($ID.text, $ID.line);} (
		ASSIGN
		| PLUS_ASSIGN
		| MINUS_ASSIGN
		| STAR_ASSIGN
		| SLASH_ASSIGN
		| MOD_ASSIGN
	) expr
	| incrementExpr
	| functionCall;

incrementExpr:
	ID {ValidateVarUse($ID.text, $ID.line);} INCREMENT
	| ID {ValidateVarUse($ID.text, $ID.line);} DECREMENT
	| INCREMENT ID {ValidateVarUse($ID.text, $ID.line);}
	| DECREMENT ID {ValidateVarUse($ID.text, $ID.line);};

functionCall:
	ID {ValidateFunctionCall($ID.text, $ID.line);} LPAREN arguments? RPAREN;

arguments: expr (COMMA expr)*;
literal: NUMBER | STRING_LITERAL;
type: INT | FLOAT | DOUBLE | STRING | VOID;