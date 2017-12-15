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

"@"{Letter}+{Digit}+	{yyparser.yylval = new ParserVal(yytext()); /*TODO changer la reconnaissance de la reference*/ 
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
"cos"					{return Parser.COS;}
"tan"					{return Parser.TAN;}
"min"					{return Parser.MINIMUM;}
"max"					{return Parser.MAXIMUM;}

"true"|"false"			{yyparser.yylval = new ParserVal(Boolean.parseBoolean(yytext()));
							return Parser.BOOLEAN;}
	
{Digit}+				{yyparser.yylval = new ParserVal(Integer.parseInt(yytext())); 
							return Parser.INT;}

{Digit}+"."{Digit}+		{yyparser.yylval = new ParserVal(Double.parseDouble(yytext())); 
							return Parser.DOUBLE;}

{Letter}*				{yyparser.yylval = new ParserVal(yytext()); 
							return Parser.STRING;}

[^]|\n|\t  				{}/* ignore all whitespace */
