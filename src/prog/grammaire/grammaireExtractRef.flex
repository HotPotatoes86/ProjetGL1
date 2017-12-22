package prog;

%%

%byaccj
%class YyExtractRef

%{
  private ParserExtract yyparser;

  public YyExtractRef(java.io.Reader r, ParserExtract yyparser) {
    this(r);
    this.yyparser = yyparser;
  }
%}

Digit = [0-9]
Letter = [a-zA-Z]
Symbole = "+"|"-"|"/"|"*"|"@"|"("|")"|","|">"|"<"|"="|"!"|"\""|"^"|"%"|" "
Symbole2 = "+"|"-"|"/"|"*"|"("|")"|","|">"|"<"|"="|"!"|"\""|"^"|"%"|" "

%%

"@"{Letter}({Letter}|{Digit})*	{yyparser.yylval = new ParserVal(yytext()); 
									return ParserExtract.REF;}

"|"								{return ParserExtract.PIPE;}

{Letter}({Letter}|{Digit}|"_")*	{yyparser.yylval = new ParserVal(yytext()); 
									return ParserExtract.NAME;}

({Letter}|{Digit}|{Symbole2})* 	{yyparser.yylval = new ParserVal(yytext()); 
									return ParserExtract.FORM;}
							
"|"({Letter}|{Digit}|{Symbole})*	{yyparser.yylval = new ParserVal(yytext()); 
									return ParserExtract.FORMULE;}	

[^]|\t|\n  						{} /* ignore all whitespace */



