%{
  package prog;
  import prog.methods.*;
  import java.io.*;
  import java.util.ArrayList;
  import java.util.List;
%}


%token NAME NUM BOOLEAN PLUS MINUS TIMES DIVIDE MOD POW INF SUP EQ DIFF PAROUV PARFER PIPE COMMA QUOTE IF THEN ELSE OR AND XOR NOT SIN COS TAN MINIMUM MAXIMUM MOY SQRT REF

%type<dval> operation NUM oneArgument
%type<sval> REF
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

axiome : axiome operation		{}
	|
	;

operation : operation PLUS operation	{}
	| operation MINUS operation			{}
	| operation DIVIDE operation		{}
	| operation TIMES operation			{}
	| method							{}
	| NUM								{}
	| REF								{System.out.println($1);}
	| PAROUV operation PARFER			{}
	;

method : SIN oneArgument				{}
	| COS oneArgument					{}
	| TAN oneArgument					{}
	| MINIMUM manyArgument				{}
	| MAXIMUM manyArgument				{}
	| MOY manyArgument					{}
	| SQRT oneArgument					{}
	;

oneArgument : PAROUV operation PARFER	{}
	;

manyArgument : PAROUV listArgument PARFER
	;

listArgument : operation				{}
	| operation COMMA listArgument		{}
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
