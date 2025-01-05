grammar BasicLanguage;

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

program: (functionDecl | globalDeclaration)* EOF;

functionDecl:
	type ID LPAREN parameters? RPAREN (SEMICOLON | block);

globalDeclaration: type ID (ASSIGN expr)? SEMICOLON;

parameters: parameter (COMMA parameter)*;

parameter: type ID;

declaration: type ID (ASSIGN expr)? SEMICOLON;

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

forInit: type ID ASSIGN expr SEMICOLON | expr? SEMICOLON;

forCondition: expr? SEMICOLON;

forIncrement: expr?;

ifStatement: IF LPAREN expr RPAREN statement (ELSE statement)?;

whileStatement: WHILE LPAREN expr RPAREN statement;

returnStatement: RETURN expr? SEMICOLON;

expr:
	literal
	| ID
	| LPAREN expr RPAREN
	| expr (STAR | SLASH | MOD) expr
	| expr (PLUS | MINUS) expr
	| expr (LT | GT | LE | GE) expr
	| expr (EQ | NE) expr
	| expr AND expr
	| expr OR expr
	| NOT expr
	| ID (
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
	ID INCREMENT
	| ID DECREMENT
	| INCREMENT ID
	| DECREMENT ID;

functionCall: ID LPAREN arguments? RPAREN;

arguments: expr (COMMA expr)*;

literal: NUMBER | STRING_LITERAL;

type: INT | FLOAT | DOUBLE | STRING | VOID;