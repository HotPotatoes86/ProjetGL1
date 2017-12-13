%{
  import java.io.*;
  import java.util.ArrayList;
  import java.util.List;
%}

%token PLUS MOINS FOIS DIV MOD POW PAROUV PARFER PIPE COMMA INF SUP EQ DIFF IF THEN ELSE AND OR NOT XOR QUOTE
%token<boolean> BOOLEAN
%token<double> NUM
%token<String> NAME

%type<Arbre> argument axiome operation

%left PLUS MINUS	
%left TIMES DIVIDE MOD
%left NEG
%right POW

%%

axiome : operation	{res = new Arbre($1);}
	   | condition
	   | {}
	   ;

operation : operation PLUS Operation 	{$$ = new Valeur($1.getResultat() + $3.getResultat());}
	  	  | operation MINUS operation 	{$$ = new Valeur($1.getResultat() - $3.getResultat());}
		  | operation DIVIDE operation 	{$$ = new Valeur($1.getResultat() / $3.getResultat());}
		  | operation TIMES operation 	{$$ = new Valeur($1.getResultat() * $3.getResultat());}
		  | operation MOD operation 	{$$ = new Valeur($1.getResultat() mod $3.getResultat());}
		  | operation POW Operation    	{$$ = new Valeur(Math.pow($1,$3));}
		  | NAME PAROUV argument PARFER	{funcArgs.clear();
		  								$$ = new Operation($1,funcArgs);}
		  | MOINS operation %prec NEG  	{$$=-$2;}
		  | NUM	 						{$$ = new Valeur($1);}
		  | PAROUV operation PARFER 	{$$ = $2;}
		  |	QUOTE NAME QUOTE			{$$ = $2;}
		  | BOOLEAN 					{$$ = $2;}
		  ;

argument : operation COMMA argument {funcArgs.add($1);}
         | operation 				{funcArgs.add($1);}
         |							{}
         ;					

	
condition : IF test THEN operation ELSE operation
		  ;

test : test2			{}
	 | test2 XOR test 	{}
	 | test2 OR test 	{}
	 | test2 AND test 	{}
	 | NOT PAROUV test2 PARFER {}
	 ;

test2 : operation INF operation {}
	  | operation SUP operation {}
	  | operation EQ operation 	{} 
	  | operation DIFF operation{}
	  | NOT test2				{}
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
static Arbre res;
static List<Arbre> funcArgs = new ArrayList<>();
