grammar Little;

@header {
package org.aldous.little;
}

COMMENT: '#' ~('\n'|'\r')* -> skip;
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines

// literals
INT_LIT: '-'?[0-9]+;
CHAR_LIT: '\'' [\u0000-\uFFFF] '\'';
STR_LIT: '"' ~('\n'|'\r')* '"';

// keywords
LOOP : 'loop';
TRUE: 'true';
FALSE: 'false';
PRINT: 'print';
GETC: 'getc';
DEF: 'def';
COPY: 'copy';
IF: 'if';
ELIF: 'elif';
ELSE: 'else';

// tokens
PLUS: '+';
MINUS: '-';
ASTERISK: '*';
SLASH: '/';
LPAREN: '(';
RPAREN: ')';
LSPAREN: '[';
RSPAREN: ']';
LCPAREN: '{';
RCPAREN: '}';
COMMA: ',';
SEMIC: ';';
COLON: ':';
EQ: '=';
LARROW: '<-';
RARROW: '->';
DOLLAR: '$';
EXCL: '!';
GT: '>';
AMP: '&';
VBAR: '|';

// ids
VARIABLE_ID : [a-z][A-Za-z0-9]*;

file: line+;
line: statement SEMIC;

elseStmt: ELSE LCPAREN (statement SEMIC)+ RCPAREN;

statement: DEF VARIABLE_ID (LSPAREN size=INT_LIT RSPAREN)? #varDec
        | VARIABLE_ID LARROW expression #varAss
        | VARIABLE_ID LSPAREN index=expression RSPAREN LARROW value=expression #arrayAss
        | LOOP expression LCPAREN (statement SEMIC)+ RCPAREN #loop
        | IF ifc=expression LCPAREN (statement SEMIC)+ RCPAREN elseStmt? #if
        | PRINT expression #print
        | COPY expression RARROW VARIABLE_ID #copy
        ;

expression: VARIABLE_ID # variableReference
   | left=expression ASTERISK right=expression #multiplication
   | left=expression SLASH right=expression #division
   | left=expression MINUS right=expression #subtraction
   | left=expression PLUS right=expression #addition
   | left=expression EQ EQ right=expression #equals
   | left=expression GT right=expression #greater
   | left=expression AMP AMP right=expression #and
   | left=expression VBAR VBAR right=expression #or
   | INT_LIT #intLiteral
   | CHAR_LIT #charLiteral
   | STR_LIT #stringLiteral
   | LPAREN expression RPAREN # paren
   | VARIABLE_ID LSPAREN expression RSPAREN # arrayRef
   | GETC LPAREN RPAREN #getc
   | EXCL expression #not
   ;