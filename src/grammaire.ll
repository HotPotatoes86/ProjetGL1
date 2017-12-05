%{
#include "calc.tab.hh"
#include <string.h>
%}


%%

"+"							{return PLUS;}
"-"							{return MINUS;}
"*"							{return TIMES;}
"/"							{return DIVIDE;}
"^"							{return POW;}
"("							{return PAROUV;}
")"							{return PARFER;}
"$"							{return DOLLAR;}
[0-9]+("."[0-9]+)?			{yylval.p = atof(yytext); return CNUM;}
[a-zA-Z]+					{yylval.s = strdup(yytext); return FUNC;}
.|\n|\t 						/* ignore all whitespace */

%%
