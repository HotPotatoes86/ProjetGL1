%{
#include <iostream>
#include "stdio.h"

extern int yylex();

void yyerror(const char* msg){
	std::cerr << "ERROR : " << msg << std::endl;
}

int powI(int x, int y){
	int res=x;
	for (int i=0; i<y-1; i++){
		res *= x;
	}
	return res;
}		

%}

%union {
    int p;
    char* s;
};

%type<p> expr CNUM
%type<s> ID

/*declarations : %token (lexeme), %start (axiome, optionnel sinon 1ere regle)*/
%token FUNC CNUM PLUS MOINS FOIS DIV PAROUV PARFER POW DOLLAR

%left PLUS MOINS	
%left FOIS DIV
%right PUISS

%start S

%%



%%

/*compilation bison -d fichier.yy*/
