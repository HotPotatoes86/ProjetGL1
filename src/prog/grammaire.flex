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

"+"						{return Parser.PLUS;}
"-"						{return Parser.MINUS;}
"*"						{return Parser.TIMES;}
"/"						{return Parser.DIVIDE;}
"mod"					{return Parser.MOD;}
"^"						{return Parser.POW;}
	
"<"						{return Parser.INF;}
">"						{return Parser.SUP}
"="						{return Parser.EQ;}
"!="					{return Parser.DIFF;}
	
"("						{return Parser.PAROUV;}
")"						{return Parser.PARFER;}
","						{return Parser.COMMA;}
"|"						{return Parser.PIPE;}
"\""					{return Parser.QUOTE;}

"if"					{return Parser.IF};
"then"					{return Parser.THEN};
"else"					{return Parser.ELSE};

"or"					{return Parser.OR};
"and"					{return Parser.AND};
"xor"					{return Parser.XOR};
"not"					{return Parser.NOT};

"true"|"false"				{yylval.val = new ParserVal(Boolean.parseBoolean(yytext));
							return Parser.BOOLEAN;}
	
{Digit}+("."{Digit}+)?		{yyparser.yylval = new ParserVal(Double.parseDouble(yytext())); 
							return Parser.NUM;}

{Letter}+					{yyparser.yylval = new ParserVal(yytext()); 
							return Parser.NAME;}

.|\n|\t  				/* ignore all whitespace */

%%