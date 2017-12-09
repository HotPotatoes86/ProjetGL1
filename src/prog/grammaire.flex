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
NL  = \n | \r | \r\n

%%

"+"					{return Parser.PLUS;}
"-"					{return Parser.MINUS;}
"*"					{return Parser.TIMES;}
"/"					{return Parser.DIVIDE;}
"^"					{return Parser.POW;}
"("					{return Parser.PAROUV;}
")"					{return Parser.PARFER;}
","					{return Parser.COMMA;}
"|"					{return Parser.PIPE;}
{Digit}+("."{Digit}+)?	{yyparser.yylval = new ParserVal(Double.parseDouble(yytext())); 
						return Parser.NUM;}
{Letter}+				{return Parser.NAME;}
[ \t]+					{}
{NL}					{}
