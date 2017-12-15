%{
  import java.io.*;
  import java.util.ArrayList;
  import java.util.List;
%}

%token REF

%type<sval> REF


%%
axiome : REF axiome 	{String reference = $1;
			Cellule cellule = conteneur.getCellule(reference.substring(1));
			conteneur.addCellule(cellule);}
	| REF 		{String reference = $1;
			Cellule cellule = conteneur.getCellule(reference.substring(1));
			conteneur.addCellule(cellule);}
	;

%%

private YyExtractRef lexer;

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


public ParserExtract(Reader r) {
	lexer = new YyExtractRef(r, this);
}

static List<Cellule> refs = new ArrayList<>();

static Conteneur conteneur;

public List<Cellule> extractRef(String formule, Conteneur conteneur) throws IOException, Exception {
	this.conteneur = conteneur;
	ParserExtract yyparser;
	yyparser = new ParserExtract(new StringReader(formule));

	yyparser.yyparse();
	
	return refs;
}


/*compilation : byaccj -J grammaire.y*/
