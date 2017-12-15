%{
  package prog.grammaire;
  import prog.methods;
  import java.io.*;
  import java.util.ArrayList;
  import java.util.List;
%}


%token NAME NUM BOOLEAN PLUS MINUS TIMES DIVIDE MOD POW INF SUP EQ DIFF PAROUV PARFER PIPE COMMA QUOTE IF THEN ELSE OR AND XOR NOT SIN COS TAN MINIMUM MAXIMUM MOY SQRT REF

%type<dval> operation NUM oneArgument
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
	| method						{funcArgs.clear();
									$$ = func.getResultat();}
	| NUM	 			{$$ = new ResultatDouble($1);}
	| PAROUV operation PARFER 	{$$ = $2;}
	;

method : SIN oneArgument		{ func = new Sinus($2);}
	| COS oneArgument				{ func = new Cosinus($2);}
	| TAN oneArgument			{ func = new Tangente($2);}
	| MINIMUM manyArgument		{ func = new Minimum($2);}
	| MAXIMUM manyArgument		{ func = new Maximum($2);}
	| MOY manyArgument			{ func = new Moyenne($2);}
	| SQRT oneArgument			{ func = new Sqrt($2);}
	;

oneArgument : PAROUV operation PARFER		{funcArgs.add($2);
												$$ = funcArgs;}
	;

manyArgument : PAROUV listArgument PARFER
	;

listArgument : operation {funcArgs.add($1);}
	| operation COMMA listArgument {funcArgs.add($1);}
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
