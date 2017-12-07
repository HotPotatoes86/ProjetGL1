/*%{
#include "grammaire.tab.hh"
#include <string.h>
%}*/

%%

%%

"+"							{ return PLUS; }
"-"							{ return MINUS; }
"*"							{ return TIMES; }
"/"							{ return DIVIDE; }
"^"							{ return POW; }
"("							{ return PAROUV; }
")"							{ return PARFER; }
","							{ return COMMA; }
"|"							{ return PIPE; }
[0-9]+("."[0-9]+)?			{ yylval.p = atof(yytext); return NUM; }
[a-zA-Z]+					{ yylval.s = strdup(yytext); return NAME; }
[^]|\n|\t 					{}/* ignore all whitespace */
