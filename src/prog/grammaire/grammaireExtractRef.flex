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

%%

"@"{Letter}+{Digit}+				{yyparser.yylval = new ParserVal(yytext()); 
							return ParserExtract.REF;}

[^]|\n|\t|.  				{}/* ignore all whitespace */



