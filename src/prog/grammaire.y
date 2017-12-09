%{
  import java.io.*;
  import java.util.ArrayList;
  import java.util.List;
%}


%token NAME NUM PLUS MOINS FOIS DIV POW PAROUV PARFER PIPE COMMA SIN COS TAN MINIMUM MAXIMUM MOY SQRT

%type<dval> operation NUM argument
%type<Operation> SIN COS TAN MINIMUM MAXIMUM MOY SQRT NAME method

%left PLUS MINUS	
%left TIMES DIVIDE
%right POW


%%

/*S : cellule S 	{}
  | 		{}
  ;
*/  
/*cellule : NAME PIPE operation {}*/

axiome : axiome operation		{System.out.println("resultat : " + $2);}
	|
	;

operation : operation PLUS operation	{$$ = $1 + $3;}
	| operation MINUS operation 	{$$ = $1 - $3;}
	| operation DIVIDE operation 	{$$ = $1 / $3;}
	| operation TIMES operation 	{$$ = $1 * $3;}
	| method PAROUV argument PARFER	{func.setArgs(funcArgs);
					funcArgs.clear();
					$$ = func.getResultat();}
	| NUM	 			{$$ = $1;}
	| PAROUV operation PARFER 	{$$ = $2;}
	;

method : SIN 			{ func = new Operation("sinus", new Sinus());}
	| COS			{ func = new Operation("cosinus", new Cosinus());}
	| TAN			{ func = new Operation("tangente", new Tangente());}
	| MINIMUM		{ func = new Operation("minimum", new Minimum());}
	| MAXIMUM		{ func = new Operation("maximum", new Maximum());}
	| MOY			{ func = new Operation("moyenne", new Moyenne());}
	| SQRT			{ func = new Operation("sqrt", new Sqrt());}
	;

argument : operation COMMA argument 		{funcArgs.add($1);}
         | operation 				{funcArgs.add($1);}
         |					{}
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
static List<Double> funcArgs = new ArrayList<>();

public static void main(String args[]) throws IOException {

	Parser yyparser;
	yyparser = new Parser(new InputStreamReader(System.in));

	yyparser.yyparse();
}


/*compilation : byaccj -J grammaire.y*/
