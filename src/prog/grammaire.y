%{
  import java.io.*;
  import java.util.ArrayList;
  import java.util.List;
%}

%token NAME NUM PLUS MOINS FOIS DIV POW PAROUV PARFER PIPE COMMA

%type<val> operation NUM argument axiome
%type<sval> NAME

%union {
    Arbre val;
    String sval;
};

%left PLUS MINUS	
%left TIMES DIVIDE
%right POW


%%

axiome : operation axiome		{return $1;}
	   | {}
	   ;

operation : operation PLUS operation{$$ = new Valeur($1.getResultat() + $3.getResultat());}
	| operation MINUS operation 	{$$ = new Valeur($1.getResultat() - $3.getResultat());}
	| operation DIVIDE operation 	{$$ = new Valeur($1.getResultat() / $3.getResultat());}
	| operation TIMES operation 	{$$ = new Valeur($1.getResultat() * $3.getResultat());}
	| NAME PAROUV argument PARFER	{funcArgs.clear();
									$$ = new Operation($1,funcArgs);}
	| NUM	 						{$$ = $1;}
	| PAROUV operation PARFER 		{$$ = $2;}

argument : operation COMMA argument {funcArgs.add($1);}
         | operation 				{funcArgs.add($1);}
         |							{}
         ;					

	

%%

private Yylex lexer;

private int yylex () {
    	int yyl_return = -1;
    	try {
      		yylval = new ParserVal(0);
      		yyl_return = lexer.yylex();
	}
	catch (IOException e) {
		System.err.println("IO error :"+e);
	}
	return yyl_return;
}


public void yyerror (String error) {
	System.err.println ("Error: " + error);
}


public Parser(Reader r) {
	lexer = new Yylex(r, this);
}


static boolean interactive;
static Operation func;
static List<Arbre> funcArgs = new ArrayList<>();

public static void main(String args[]) throws IOException {

	Parser yyparser;
	yyparser = new Parser(new InputStreamReader(System.in));

	yyparser.yyparse();
}


/*compilation : byaccj -J grammaire.y*/
