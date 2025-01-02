grammar BasicLanguage;

// Lexer rules
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

// Parser rules
program: (function | declaration)* EOF;
function: type ID LPAREN parameters? RPAREN block;
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
	| expr SEMICOLON;
ifStatement: IF LPAREN expr RPAREN block (ELSE block)?;
forStatement:
	FOR LPAREN expr? SEMICOLON expr? SEMICOLON expr? RPAREN block;
whileStatement: WHILE LPAREN expr RPAREN block;
returnStatement: RETURN expr? SEMICOLON;
expr:
	expr (PLUS | MINUS | STAR | SLASH | MOD) expr
	| expr (LT | GT | LE | GE | EQ | NE) expr
	| expr (AND | OR) expr
	| NOT expr
	| ID (
		ASSIGN
		| PLUS_ASSIGN
		| MINUS_ASSIGN
		| STAR_ASSIGN
		| SLASH_ASSIGN
		| MOD_ASSIGN
	) expr
	| ID INCREMENT
	| ID DECREMENT
	| LPAREN expr RPAREN
	| NUMBER
	| STRING_LITERAL
	| ID;

// Types
type: INT | FLOAT | DOUBLE | STRING | VOID;