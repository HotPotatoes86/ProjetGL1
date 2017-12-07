%{
extern int yylex();

/*void yyerror(const char* msg){
	std::cerr << "ERROR : " << msg << std::endl;
}

int powI(int x, int y){
	int res=x;
	for (int i=0; i<y-1; i++){
		res *= x;
	}
	return res;
}*/		

%}

%union {
    int p;
    char* s;
};

%type<p> operation NUM
%type<s> NAME

%token NAME NUM PLUS MOINS FOIS DIV PAROUV PARFER POW PIPE COMMA

%left PLUS MINUS	
%left TIMES DIVIDE
%right POW

%start S

%%

S : cellule S {}
  | {}
  ;
  
cellule : NAME PIPE operation {}

operation : operation PLUS operation 	{ $$ = $1 + $3; }
		  | operation MINUS operation 	{$$ = $1 - $3;}
		  | operation DIVIDE operation 	{$$ = $1 / $3;}
		  | operation TIMES operation 	{$$ = $1 * $3;}
		  | NAME PAROUV argument PARFER{}
		  | PAROUV operation PARFER 	{$$ = $2;}
		  | NUM 						{$$ = $1;}
		  ;

argument : operation COMMA argument {}
         | operation 				{}
         |							{}
         ;					

%%

/*compilation bison -d -java fichier.yy*/
