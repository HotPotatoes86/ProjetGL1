%{

import prog.methods.*;
import prog.results.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
%}


%token STRING INT DOUBLE BOOLEAN PLUS MINUS TIMES DIVIDE MOD POW INF SUP EQ DIFF INFEQ SUPEQ PAROUV PARFER PIPE COMMA QUOTE IF THEN ELSE OR AND XOR NOT LN SIN ASIN COS ACOS TAN ATAN MINIMUM MAXIMUM MOY TODEGREE TORADIAN ABS ROUND SQRT TONUM LEN CONCAT TOSTRING SUBSTR REF POWER

%type<ival>	INT 						/*Type Int*/
%type<dval> DOUBLE						/*Type Double*/
%type<rval> operation oneArgument axiome/*Type Resultat*/
%type<bval> condition BOOLEAN 			/*Type Boolean*/
%type<sval> STRING REF					/*Type String*/

%type<fval> LN SIN ASIN COS ACOS TAN ATAN MINIMUM MAXIMUM MOY TODEGREE TORADIAN ABS ROUND SQRT TONUM LEN CONCAT TOSTRING SUBSTR POWER method /*Type Fonction*/

%left OR XOR
%left AND SUP
%left PLUS MINUS	
%left TIMES DIVIDE MOD
%left NEG
%right POW

%%

axiome :  operation			{resultat = $1;}
	   | IF condition THEN operation ELSE operation { 
										if($2){
											resultat = $4;
										}else{
											resultat = $6;
										};}
		;

operation : operation PLUS operation	{$$ = $1.addition($3);}
	| operation MINUS operation			{$$ = $1.soustraction($3);}
	| operation DIVIDE operation		{$$ = $1.division($3);}
	| operation TIMES operation			{$$ = $1.multiplication($3);}
	| operation MOD operation			{$$ = $1.modulo($3);}
	| operation POW operation			{funcArgs.add($1);
											funcArgs.add($3);
											Pow tmp = new Pow(funcArgs);
											$$ = tmp.getResultat();
											funcArgs.clear();}
	| method							{$$ = $1.getResultat();
											funcArgs.clear();}
	| MINUS DOUBLE	%prec NEG			{$$ = new ResultatDouble(-$2);}
	| DOUBLE							{$$ = new ResultatDouble($1);}
	| MINUS INT %prec NEG 				{$$ = new ResultatInteger(-$2);}
	| INT 								{$$ = new ResultatInteger($1);}
	| REF								{Cellule cellRef = conteneur.getCellule($1.substring(1));
											if (cellRef==null){
												$$ = new ResultatErreur();
											}else{
												$$ = cellRef.getResultat();
											}}
	/*| PAROUV condition PARFER			{$$ = new ResultatBoolean($2);}*/
	| BOOLEAN 							{$$ = new ResultatBoolean($1);}
	| STRING							{$$ = new ResultatString($1);}
	| PAROUV operation PARFER			{$$ = $2;}
	;

method : LN oneArgument		{ $$ = new Ln($2);}
	| SIN oneArgument		{ $$ = new Sinus($2);}
	| ASIN oneArgument		{ $$ = new Asinus($2);}
	| COS oneArgument			{ $$ = new Cosinus($2);}
	| ACOS oneArgument			{ $$ = new Acosinus($2);}
	| TAN oneArgument			{ $$ = new Tangente($2);}
	| ATAN oneArgument			{ $$ = new Atangente($2);}
	| TODEGREE oneArgument		{ $$ = new ToDegree($2);}
	| TORADIAN oneArgument		{ $$ = new ToRadian($2);}
	| MINIMUM manyArgument		{ $$ = new Minimum(funcArgs);}
	| MAXIMUM manyArgument		{ $$ = new Maximum(funcArgs);}
	| MOY manyArgument			{ $$ = new Moyenne(funcArgs);}
	| ABS oneArgument			{ $$ = new Absolute($2);}
	| POWER manyArgument		{ $$ = new Pow(funcArgs);}
	| ROUND oneArgument			{ $$ = new Round($2);}
	| SQRT oneArgument			{ $$ = new Sqrt($2);}
	| TONUM oneArgument			{ $$ = new ToNum($2);}
	| LEN oneArgument			{ $$ = new Len($2);}
	| CONCAT manyArgument		{ $$ = new Concat(funcArgs);}
	| TOSTRING oneArgument		{ $$ = new ToString($2);}
	| SUBSTR manyArgument		{ $$ = new Substring(funcArgs);}
	;

oneArgument : PAROUV operation PARFER		{$$ = $2;}
			;

manyArgument : PAROUV listArgument PARFER 	{}
			;

listArgument : operation			{funcArgs.add($1);}
	| listArgument COMMA operation	{funcArgs.add($3);}
	;

condition : condition AND condition {$$ = $1 && $3;}
	|condition OR condition			{$$ = $1 || $3;}
	|condition XOR condition		{$$ = $1^$3;}
	|PAROUV condition PARFER		{$$ = $2;}
	|operation INF operation		{$$ = $1.estInferieur($3);}
	|operation SUP operation		{$$ = $1.estSuperieur($3);}
	|operation EQ operation			{$$ = $1.estEgal($3);}
	|operation DIFF operation		{$$ = $1.estDifferent($3);}
	|operation INFEQ operation		{$$ = $1.estInferieurOuEgal($3);}
	|operation SUPEQ operation		{$$ = $1.estSuperieurOuEgal($3);}
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
	//System.err.println ("Error: " + error);
}


public Parser(Reader r) {
	lexer = new Yylex(r, this);
}


private static boolean interactive;
private static List<Resultat> funcArgs = new ArrayList<>();
public static Resultat resultat; 
private static Conteneur conteneur; /*utilisé pour extraire le resultat d'une référence*/

public static Resultat formuleToResultat(String formule, Conteneur conteneur) throws IOException, Exception {
        resultat =new ResultatErreur();
		Parser.conteneur = conteneur;
	Parser yyparser;
	yyparser = new Parser(new StringReader(formule));

	yyparser.yyparse();
	
	return resultat;
}
