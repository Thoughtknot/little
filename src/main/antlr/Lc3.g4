grammar Lc3;

@header {
package org.aldous.little.assembler;
}

NEWLINE: '\n';
WS : [ \t\r]+ -> skip ; // skip spaces, tabs, newlines

// literals
INT_LIT: [0-9]+;
INT_DEC_LIT: '#''-'?[0-9]+;
INT_HEX_LIT: 'x''-'?[0-9A-F]+;
STR_LIT: '"' ~('\n'|'\r')* '"';

// keywords
ORIG : '.ORIG';
END: '.END';
FILL: '.FILL';
BLKW: '.BLKW';
STRINGZ: '.STRINGZ';

BR: 'BR';
LDI: 'LDI';
LD: 'LD';
LDR: 'LDR';
LEA: 'LEA';
STI: 'STI';
STR: 'STR';
ST: 'ST';
JMP: 'JMP';
JSR: 'JSR';
JSRR: 'JSRR';
RET: 'RET';
ADD: 'ADD';
AND: 'AND';
NOT: 'NOT';
HALT: 'HALT';
IN: 'IN';
OUT: 'OUT';
GETC: 'GETC';
PUTS: 'PUTS';
REGISTER: 'R'[0-7];

// tokens
COMMA: ',';
LABEL: [_A-Z]+;

file: (statement NEWLINE)+;

statement: label=LABEL? innerStatement;

innerStatement:
        ORIG INT_HEX_LIT #orig
        | ADD dr=REGISTER COMMA left=REGISTER COMMA right=(REGISTER | INT_DEC_LIT) #add
        | AND dr=REGISTER COMMA left=REGISTER COMMA right=(REGISTER | INT_DEC_LIT) #and
        | NOT dr=REGISTER COMMA value=REGISTER #not
        | JMP baser=REGISTER #jmp
        | BR n='n'? z='z'? p='p'? LABEL #br
        | RET #ret
        | JSR LABEL #jsr
        | #label
        | JSRR REGISTER #jsrr
        | LD dr=REGISTER COMMA LABEL #ld
        | LDI dr=REGISTER COMMA LABEL #ldi
        | LDR dr=REGISTER COMMA baser=REGISTER COMMA offset=INT_DEC_LIT #ldr
        | LEA dr=REGISTER COMMA LABEL #lea
        | ST sr=REGISTER COMMA LABEL #st
        | STI sr=REGISTER COMMA LABEL #sti
        | STR sr=REGISTER COMMA br=REGISTER COMMA offset=INT_DEC_LIT #str
        | FILL val=(INT_DEC_LIT | INT_HEX_LIT) #fill
        | STRINGZ STR_LIT #stringz
        | BLKW INT_LIT #blkw
        | PUTS #puts
        | GETC #getc
        | OUT #out
        | HALT #halt
        | END #end;