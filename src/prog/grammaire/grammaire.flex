package prog;

%%

%byaccj

%{
  private Parser yyparser;

  public Yylex(java.io.Reader r, Parser yyparser) {
    this(r);
    this.yyparser = yyparser;
  }
%}

Digit = [0-9]
Letter = [a-zA-Z]

%%

"@"{Letter}+{Digit}*	{yyparser.yylval = new ParserVal(yytext()); 
							return Parser.REF;}
"+"						{return Parser.PLUS;}
"-"						{return Parser.MINUS;}
"*"						{return Parser.TIMES;}
"/"						{return Parser.DIVIDE;}
"mod"					{return Parser.MOD;}
"^"						{return Parser.POW;}
	
"<"						{return Parser.INF;}
">"						{return Parser.SUP;}
"="						{return Parser.EQ;}
"!="					{return Parser.DIFF;}
"<="					{return Parser.INFEQ;}
">="					{return Parser.SUPEQ;}
	
"("						{return Parser.PAROUV;}
")"						{return Parser.PARFER;}
","						{return Parser.COMMA;}
"|"						{return Parser.PIPE;}
"\""					{return Parser.QUOTE;}

"if"					{return Parser.IF;}
"then"					{return Parser.THEN;}
"else"					{return Parser.ELSE;}

"or"					{return Parser.OR;}
"and"					{return Parser.AND;}
"xor"					{return Parser.XOR;}
"not"					{return Parser.NOT;}

"sin"					{return Parser.SIN;}
"asin"					{return Parser.ASIN;}
"cos"					{return Parser.COS;}
"acos"					{return Parser.ACOS;}
"tan"					{return Parser.TAN;}
"atan"					{return Parser.ATAN;}
"todegree"				{return Parser.TODEGREE;}
"toradian"				{return Parser.TORADIAN;}
"ln"					{return Parser.LN;}
"min"					{return Parser.MINIMUM;}
"max"					{return Parser.MAXIMUM;}
"abs"					{return Parser.ABS;}
"pow"					{return Parser.POW;}
"round"					{return Parser.ROUND;}
"sqrt"					{return Parser.SQRT;}
"tonum"					{return Parser.TONUM;}
"len"					{return Parser.LEN;}
"concat"				{return Parser.CONCAT;}
"tostring"				{return Parser.TOSTRING;}
"substr"					{return Parser.SUBSTR;}
"true"|"false"			{yyparser.yylval = new ParserVal(Boolean.parseBoolean(yytext()));
							return Parser.BOOLEAN;}
	
{Digit}+				{yyparser.yylval = new ParserVal(Integer.parseInt(yytext())); 
							return Parser.INT;}

{Digit}+"."{Digit}+		{yyparser.yylval = new ParserVal(Double.parseDouble(yytext())); 
							return Parser.DOUBLE;}

{Letter}*				{yyparser.yylval = new ParserVal(yytext()); 
							return Parser.STRING;}

[^]|\n|\t  				{}/* ignore all whitespace */
