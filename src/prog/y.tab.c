/* original parser id follows */
/* yysccsid[] = "@(#)yaccpar	1.9 (Berkeley) 02/21/93" */
/* (use YYMAJOR/YYMINOR for ifdefs dependent on parser version) */

#define YYBYACC 1
#define YYMAJOR 1
#define YYMINOR 9
#define YYPATCH 20140715

#define YYEMPTY        (-1)
#define yyclearin      (yychar = YYEMPTY)
#define yyerrok        (yyerrflag = 0)
#define YYRECOVERING() (yyerrflag != 0)
#define YYENOMEM       (-2)
#define YYEOF          0
#define YYPREFIX "yy"

#define YYPURE 0

#line 2 "grammaire.y"
  import java.io.*;
  import java.util.ArrayList;
  import java.util.List;
#line 25 "y.tab.c"

/* compatibility with bison */
#ifdef YYPARSE_PARAM
/* compatibility with FreeBSD */
# ifdef YYPARSE_PARAM_TYPE
#  define YYPARSE_DECL() yyparse(YYPARSE_PARAM_TYPE YYPARSE_PARAM)
# else
#  define YYPARSE_DECL() yyparse(void *YYPARSE_PARAM)
# endif
#else
# define YYPARSE_DECL() yyparse(void)
#endif

/* Parameters sent to lex. */
#ifdef YYLEX_PARAM
# define YYLEX_DECL() yylex(void *YYLEX_PARAM)
# define YYLEX yylex(YYLEX_PARAM)
#else
# define YYLEX_DECL() yylex(void)
# define YYLEX yylex()
#endif

/* Parameters sent to yyerror. */
#ifndef YYERROR_DECL
#define YYERROR_DECL() yyerror(const char *s)
#endif
#ifndef YYERROR_CALL
#define YYERROR_CALL(msg) yyerror(msg)
#endif

extern int YYPARSE_DECL();

#define PLUS 257
#define MOINS 258
#define FOIS 259
#define DIV 260
#define MOD 261
#define POW 262
#define PAROUV 263
#define PARFER 264
#define PIPE 265
#define COMMA 266
#define INF 267
#define SUP 268
#define EQ 269
#define DIFF 270
#define IF 271
#define THEN 272
#define ELSE 273
#define AND 274
#define OR 275
#define NOT 276
#define XOR 277
#define QUOTE 278
#define BOOLEAN 279
#define NUM 280
#define NAME 281
#define MINUS 282
#define TIMES 283
#define DIVIDE 284
#define NEG 285
#define YYERRCODE 256
typedef short YYINT;
static const YYINT yylhs[] = {                           -1,
    0,    0,    0,    2,    2,    2,    2,    2,    2,    2,
    2,    2,    2,    2,    2,    1,    1,    1,    3,    4,
    4,    4,    4,    4,    5,    5,    5,    5,    5,
};
static const YYINT yylen[] = {                            2,
    1,    1,    0,    3,    3,    3,    3,    3,    3,    4,
    2,    1,    3,    3,    1,    3,    1,    0,    6,    1,
    3,    3,    3,    4,    3,    3,    3,    3,    2,
};
static const YYINT yydefred[] = {                         0,
    0,    0,    0,    0,   15,   12,    0,    0,    0,    2,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   13,    0,    0,   29,    0,    0,
    0,    0,    0,    0,    0,    0,   14,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   23,   22,   21,   10,    0,   24,    0,   16,
    0,
};
static const YYINT yydgoto[] = {                          8,
   38,   14,   10,   15,   16,
};
static const YYINT yysindex[] = {                      -137,
 -100, -100, -131, -277,    0,    0, -252,    0, -153,    0,
 -256, -169, -125, -183, -260, -272, -262, -100, -100, -100,
 -100, -100, -100, -100,    0, -106, -106,    0, -100, -100,
 -100, -100, -100, -131, -131, -131,    0, -243, -159, -203,
 -256, -256, -203, -256, -256, -214, -242, -153, -153, -153,
 -153, -238,    0,    0,    0,    0, -100,    0, -100,    0,
 -153,
};
static const YYINT yyrindex[] = {                        33,
    0,    0,    0,    0,    0,    0,    0,    0,   36,    0,
    1,    0,    0,    0,    0, -230,    0, -213,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0, -212,  118,
   25,   49,  137,   73,   97,    0,    0, -257,  -88,  -82,
  -76,    0,    0,    0,    0,    0, -213,    0,    0,    0,
   57,
};
static const YYINT yygindex[] = {                         0,
    6,    8,    0,   26,  -13,
};
#define YYTABLESIZE 419
static const YYINT yytable[] = {                         28,
   11,   34,   35,   17,   36,   21,   25,    9,   11,   12,
   18,   33,   47,   28,   25,   37,   25,   25,   19,   25,
   56,   58,   20,   21,    8,   39,   40,   41,   42,   43,
   44,   45,    3,   46,   59,    1,   48,   49,   50,   51,
   52,   20,   19,   22,   23,   24,   20,   21,    9,   25,
   18,   17,   29,   30,   31,   32,   19,   20,   21,   53,
   54,   55,   60,    0,   39,    0,   61,   22,   23,   24,
    0,    0,    7,   19,    0,    0,    0,   20,   21,   23,
   24,    0,    0,   29,   30,   31,   32,   19,    0,    0,
    0,   20,   21,    0,   25,    0,    6,   19,   22,   23,
   24,   20,   21,   19,    0,    0,   57,   20,   21,    0,
    0,    0,   22,   23,   24,    0,    0,    4,    0,    0,
    1,    0,   22,   23,   24,    2,    1,    0,   22,   23,
   24,    2,    1,    3,    0,    0,    5,   26,    0,    0,
    4,    5,    6,    7,   13,    0,    4,    5,    6,    7,
   27,    1,    4,    5,    6,    7,    2,    1,    0,    0,
    0,    0,    2,    0,    0,    0,    0,    0,    0,   27,
    0,    4,    5,    6,    7,   26,    0,    4,    5,    6,
    7,   27,    0,   26,    0,   26,   26,   28,   26,   27,
    0,   27,   27,    0,   27,   28,    0,   28,   28,    0,
   28,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   11,    0,    0,
    0,   11,    0,    0,   11,    0,   11,   11,   11,   11,
   11,    0,   11,   11,   11,   11,    0,   11,    0,    0,
    0,    8,   11,   11,   11,    8,    0,    0,    8,    0,
    8,    8,    8,    8,    8,    0,    8,    8,    8,    8,
    0,    8,    0,    0,    0,    9,    8,    8,    8,    9,
    0,    0,    9,    0,    9,    9,    9,    9,    9,    0,
    9,    9,    9,    9,    0,    9,    0,    0,    0,    7,
    9,    9,    9,    7,    0,    0,    7,    0,    7,    7,
    7,    7,    7,    0,    7,    7,    7,    7,    0,    7,
    0,    0,    0,    6,    7,    7,    7,    6,    0,    0,
    6,    0,    6,    6,    6,    6,    6,    0,    6,    6,
    6,    6,    0,    6,    4,    0,    0,    0,    6,    6,
    6,    4,    0,    4,    4,    4,    4,    4,    0,    4,
    4,    4,    4,    5,    4,    0,    0,    0,    0,    4,
    5,    0,    5,    5,    5,    5,    5,    0,    5,    5,
    5,    5,    0,    5,    0,    0,    0,    0,    5,
};
static const YYINT yycheck[] = {                         13,
    0,  274,  275,  281,  277,  262,  264,    0,    1,    2,
  263,  272,   26,   27,  272,  278,  274,  275,  257,  277,
  264,  264,  261,  262,    0,   18,   19,   20,   21,   22,
   23,   24,    0,   26,  273,    0,   29,   30,   31,   32,
   33,  272,  257,  282,  283,  284,  261,  262,    0,  264,
  264,  264,  267,  268,  269,  270,    0,  261,  262,   34,
   35,   36,   57,   -1,   57,   -1,   59,  282,  283,  284,
   -1,   -1,    0,  257,   -1,   -1,   -1,  261,  262,  283,
  284,   -1,   -1,  267,  268,  269,  270,  257,   -1,   -1,
   -1,  261,  262,   -1,  264,   -1,    0,  257,  282,  283,
  284,  261,  262,  257,   -1,   -1,  266,  261,  262,   -1,
   -1,   -1,  282,  283,  284,   -1,   -1,    0,   -1,   -1,
  258,   -1,  282,  283,  284,  263,  258,   -1,  282,  283,
  284,  263,  258,  271,   -1,   -1,    0,  263,   -1,   -1,
  278,  279,  280,  281,  276,   -1,  278,  279,  280,  281,
  276,  258,  278,  279,  280,  281,  263,  258,   -1,   -1,
   -1,   -1,  263,   -1,   -1,   -1,   -1,   -1,   -1,  276,
   -1,  278,  279,  280,  281,  264,   -1,  278,  279,  280,
  281,  264,   -1,  272,   -1,  274,  275,  264,  277,  272,
   -1,  274,  275,   -1,  277,  272,   -1,  274,  275,   -1,
  277,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  257,   -1,   -1,
   -1,  261,   -1,   -1,  264,   -1,  266,  267,  268,  269,
  270,   -1,  272,  273,  274,  275,   -1,  277,   -1,   -1,
   -1,  257,  282,  283,  284,  261,   -1,   -1,  264,   -1,
  266,  267,  268,  269,  270,   -1,  272,  273,  274,  275,
   -1,  277,   -1,   -1,   -1,  257,  282,  283,  284,  261,
   -1,   -1,  264,   -1,  266,  267,  268,  269,  270,   -1,
  272,  273,  274,  275,   -1,  277,   -1,   -1,   -1,  257,
  282,  283,  284,  261,   -1,   -1,  264,   -1,  266,  267,
  268,  269,  270,   -1,  272,  273,  274,  275,   -1,  277,
   -1,   -1,   -1,  257,  282,  283,  284,  261,   -1,   -1,
  264,   -1,  266,  267,  268,  269,  270,   -1,  272,  273,
  274,  275,   -1,  277,  257,   -1,   -1,   -1,  282,  283,
  284,  264,   -1,  266,  267,  268,  269,  270,   -1,  272,
  273,  274,  275,  257,  277,   -1,   -1,   -1,   -1,  282,
  264,   -1,  266,  267,  268,  269,  270,   -1,  272,  273,
  274,  275,   -1,  277,   -1,   -1,   -1,   -1,  282,
};
#define YYFINAL 8
#ifndef YYDEBUG
#define YYDEBUG 0
#endif
#define YYMAXTOKEN 285
#define YYUNDFTOKEN 293
#define YYTRANSLATE(a) ((a) > YYMAXTOKEN ? YYUNDFTOKEN : (a))
#if YYDEBUG
static const char *const yyname[] = {

"end-of-file",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,"PLUS","MOINS","FOIS","DIV","MOD",
"POW","PAROUV","PARFER","PIPE","COMMA","INF","SUP","EQ","DIFF","IF","THEN",
"ELSE","AND","OR","NOT","XOR","QUOTE","BOOLEAN","NUM","NAME","MINUS","TIMES",
"DIVIDE","NEG",0,0,0,0,0,0,0,"illegal-symbol",
};
static const char *const yyrule[] = {
"$accept : axiome",
"axiome : operation",
"axiome : condition",
"axiome :",
"operation : operation PLUS operation",
"operation : operation MINUS operation",
"operation : operation DIVIDE operation",
"operation : operation TIMES operation",
"operation : operation MOD operation",
"operation : operation POW operation",
"operation : NAME PAROUV argument PARFER",
"operation : MOINS operation",
"operation : NUM",
"operation : PAROUV operation PARFER",
"operation : QUOTE NAME QUOTE",
"operation : BOOLEAN",
"argument : operation COMMA argument",
"argument : operation",
"argument :",
"condition : IF test THEN operation ELSE operation",
"test : test2",
"test : test2 XOR test",
"test : test2 OR test",
"test : test2 AND test",
"test : NOT PAROUV test2 PARFER",
"test2 : operation INF operation",
"test2 : operation SUP operation",
"test2 : operation EQ operation",
"test2 : operation DIFF operation",
"test2 : NOT test2",

};
#endif

int      yydebug;
int      yynerrs;

int      yyerrflag;
int      yychar;
YYSTYPE  yyval;
YYSTYPE  yylval;

/* define the initial stack-sizes */
#ifdef YYSTACKSIZE
#undef YYMAXDEPTH
#define YYMAXDEPTH  YYSTACKSIZE
#else
#ifdef YYMAXDEPTH
#define YYSTACKSIZE YYMAXDEPTH
#else
#define YYSTACKSIZE 10000
#define YYMAXDEPTH  10000
#endif
#endif

#define YYINITSTACKSIZE 200

typedef struct {
    unsigned stacksize;
    YYINT    *s_base;
    YYINT    *s_mark;
    YYINT    *s_last;
    YYSTYPE  *l_base;
    YYSTYPE  *l_mark;
} YYSTACKDATA;
/* variables for the parser stack */
static YYSTACKDATA yystack;
#line 66 "grammaire.y"

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
#line 340 "y.tab.c"

#if YYDEBUG
#include <stdio.h>		/* needed for printf */
#endif

#include <stdlib.h>	/* needed for malloc, etc */
#include <string.h>	/* needed for memset */

/* allocate initial stack or double stack size, up to YYMAXDEPTH */
static int yygrowstack(YYSTACKDATA *data)
{
    int i;
    unsigned newsize;
    YYINT *newss;
    YYSTYPE *newvs;

    if ((newsize = data->stacksize) == 0)
        newsize = YYINITSTACKSIZE;
    else if (newsize >= YYMAXDEPTH)
        return YYENOMEM;
    else if ((newsize *= 2) > YYMAXDEPTH)
        newsize = YYMAXDEPTH;

    i = (int) (data->s_mark - data->s_base);
    newss = (YYINT *)realloc(data->s_base, newsize * sizeof(*newss));
    if (newss == 0)
        return YYENOMEM;

    data->s_base = newss;
    data->s_mark = newss + i;

    newvs = (YYSTYPE *)realloc(data->l_base, newsize * sizeof(*newvs));
    if (newvs == 0)
        return YYENOMEM;

    data->l_base = newvs;
    data->l_mark = newvs + i;

    data->stacksize = newsize;
    data->s_last = data->s_base + newsize - 1;
    return 0;
}

#if YYPURE || defined(YY_NO_LEAKS)
static void yyfreestack(YYSTACKDATA *data)
{
    free(data->s_base);
    free(data->l_base);
    memset(data, 0, sizeof(*data));
}
#else
#define yyfreestack(data) /* nothing */
#endif

#define YYABORT  goto yyabort
#define YYREJECT goto yyabort
#define YYACCEPT goto yyaccept
#define YYERROR  goto yyerrlab

int
YYPARSE_DECL()
{
    int yym, yyn, yystate;
#if YYDEBUG
    const char *yys;

    if ((yys = getenv("YYDEBUG")) != 0)
    {
        yyn = *yys;
        if (yyn >= '0' && yyn <= '9')
            yydebug = yyn - '0';
    }
#endif

    yynerrs = 0;
    yyerrflag = 0;
    yychar = YYEMPTY;
    yystate = 0;

#if YYPURE
    memset(&yystack, 0, sizeof(yystack));
#endif

    if (yystack.s_base == NULL && yygrowstack(&yystack) == YYENOMEM) goto yyoverflow;
    yystack.s_mark = yystack.s_base;
    yystack.l_mark = yystack.l_base;
    yystate = 0;
    *yystack.s_mark = 0;

yyloop:
    if ((yyn = yydefred[yystate]) != 0) goto yyreduce;
    if (yychar < 0)
    {
        if ((yychar = YYLEX) < 0) yychar = YYEOF;
#if YYDEBUG
        if (yydebug)
        {
            yys = yyname[YYTRANSLATE(yychar)];
            printf("%sdebug: state %d, reading %d (%s)\n",
                    YYPREFIX, yystate, yychar, yys);
        }
#endif
    }
    if ((yyn = yysindex[yystate]) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
    {
#if YYDEBUG
        if (yydebug)
            printf("%sdebug: state %d, shifting to state %d\n",
                    YYPREFIX, yystate, yytable[yyn]);
#endif
        if (yystack.s_mark >= yystack.s_last && yygrowstack(&yystack) == YYENOMEM)
        {
            goto yyoverflow;
        }
        yystate = yytable[yyn];
        *++yystack.s_mark = yytable[yyn];
        *++yystack.l_mark = yylval;
        yychar = YYEMPTY;
        if (yyerrflag > 0)  --yyerrflag;
        goto yyloop;
    }
    if ((yyn = yyrindex[yystate]) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
    {
        yyn = yytable[yyn];
        goto yyreduce;
    }
    if (yyerrflag) goto yyinrecovery;

    YYERROR_CALL("syntax error");

    goto yyerrlab;

yyerrlab:
    ++yynerrs;

yyinrecovery:
    if (yyerrflag < 3)
    {
        yyerrflag = 3;
        for (;;)
        {
            if ((yyn = yysindex[*yystack.s_mark]) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
#if YYDEBUG
                if (yydebug)
                    printf("%sdebug: state %d, error recovery shifting\
 to state %d\n", YYPREFIX, *yystack.s_mark, yytable[yyn]);
#endif
                if (yystack.s_mark >= yystack.s_last && yygrowstack(&yystack) == YYENOMEM)
                {
                    goto yyoverflow;
                }
                yystate = yytable[yyn];
                *++yystack.s_mark = yytable[yyn];
                *++yystack.l_mark = yylval;
                goto yyloop;
            }
            else
            {
#if YYDEBUG
                if (yydebug)
                    printf("%sdebug: error recovery discarding state %d\n",
                            YYPREFIX, *yystack.s_mark);
#endif
                if (yystack.s_mark <= yystack.s_base) goto yyabort;
                --yystack.s_mark;
                --yystack.l_mark;
            }
        }
    }
    else
    {
        if (yychar == YYEOF) goto yyabort;
#if YYDEBUG
        if (yydebug)
        {
            yys = yyname[YYTRANSLATE(yychar)];
            printf("%sdebug: state %d, error recovery discards token %d (%s)\n",
                    YYPREFIX, yystate, yychar, yys);
        }
#endif
        yychar = YYEMPTY;
        goto yyloop;
    }

yyreduce:
#if YYDEBUG
    if (yydebug)
        printf("%sdebug: state %d, reducing by rule %d (%s)\n",
                YYPREFIX, yystate, yyn, yyrule[yyn]);
#endif
    yym = yylen[yyn];
    if (yym)
        yyval = yystack.l_mark[1-yym];
    else
        memset(&yyval, 0, sizeof yyval);
    switch (yyn)
    {
case 1:
#line 21 "grammaire.y"
	{res = new Arbre(yystack.l_mark[0].Arbre);}
break;
case 3:
#line 23 "grammaire.y"
	{}
break;
case 4:
#line 26 "grammaire.y"
	{yyval.Arbre = new Valeur(yystack.l_mark[-2].Arbre.getResultat() + yystack.l_mark[0].Arbre.getResultat());}
break;
case 5:
#line 27 "grammaire.y"
	{yyval.Arbre = new Valeur(yystack.l_mark[-2].Arbre.getResultat() - yystack.l_mark[0].Arbre.getResultat());}
break;
case 6:
#line 28 "grammaire.y"
	{yyval.Arbre = new Valeur(yystack.l_mark[-2].Arbre.getResultat() / yystack.l_mark[0].Arbre.getResultat());}
break;
case 7:
#line 29 "grammaire.y"
	{yyval.Arbre = new Valeur(yystack.l_mark[-2].Arbre.getResultat() * yystack.l_mark[0].Arbre.getResultat());}
break;
case 8:
#line 30 "grammaire.y"
	{yyval.Arbre = new Valeur(yystack.l_mark[-2].Arbre.getResultat() mod yystack.l_mark[0].Arbre.getResultat());}
break;
case 9:
#line 31 "grammaire.y"
	{yyval.Arbre = new Valeur(Math.pow(yystack.l_mark[-2].Arbre,yystack.l_mark[0].Arbre));}
break;
case 10:
#line 32 "grammaire.y"
	{funcArgs.clear();
		  								yyval.Arbre = new Operation(yystack.l_mark[-3].String,funcArgs);}
break;
case 11:
#line 34 "grammaire.y"
	{yyval.Arbre=-yystack.l_mark[0].Arbre;}
break;
case 12:
#line 35 "grammaire.y"
	{yyval.Arbre = new Valeur(yystack.l_mark[0].double);}
break;
case 13:
#line 36 "grammaire.y"
	{yyval.Arbre = yystack.l_mark[-1].Arbre;}
break;
case 14:
#line 37 "grammaire.y"
	{yyval.Arbre = new Valeur(yystack.l_mark[-1].String);}
break;
case 15:
#line 38 "grammaire.y"
	{yyval.Arbre = new Valeur(yystack.l_mark[0].boolean);}
break;
case 16:
#line 41 "grammaire.y"
	{funcArgs.add(yystack.l_mark[-2].Arbre);}
break;
case 17:
#line 42 "grammaire.y"
	{funcArgs.add(yystack.l_mark[0].Arbre);}
break;
case 18:
#line 43 "grammaire.y"
	{}
break;
case 20:
#line 50 "grammaire.y"
	{}
break;
case 21:
#line 51 "grammaire.y"
	{}
break;
case 22:
#line 52 "grammaire.y"
	{}
break;
case 23:
#line 53 "grammaire.y"
	{}
break;
case 24:
#line 54 "grammaire.y"
	{}
break;
case 25:
#line 57 "grammaire.y"
	{}
break;
case 26:
#line 58 "grammaire.y"
	{}
break;
case 27:
#line 59 "grammaire.y"
	{}
break;
case 28:
#line 60 "grammaire.y"
	{}
break;
case 29:
#line 61 "grammaire.y"
	{}
break;
#line 651 "y.tab.c"
    }
    yystack.s_mark -= yym;
    yystate = *yystack.s_mark;
    yystack.l_mark -= yym;
    yym = yylhs[yyn];
    if (yystate == 0 && yym == 0)
    {
#if YYDEBUG
        if (yydebug)
            printf("%sdebug: after reduction, shifting from state 0 to\
 state %d\n", YYPREFIX, YYFINAL);
#endif
        yystate = YYFINAL;
        *++yystack.s_mark = YYFINAL;
        *++yystack.l_mark = yyval;
        if (yychar < 0)
        {
            if ((yychar = YYLEX) < 0) yychar = YYEOF;
#if YYDEBUG
            if (yydebug)
            {
                yys = yyname[YYTRANSLATE(yychar)];
                printf("%sdebug: state %d, reading %d (%s)\n",
                        YYPREFIX, YYFINAL, yychar, yys);
            }
#endif
        }
        if (yychar == YYEOF) goto yyaccept;
        goto yyloop;
    }
    if ((yyn = yygindex[yym]) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn];
    else
        yystate = yydgoto[yym];
#if YYDEBUG
    if (yydebug)
        printf("%sdebug: after reduction, shifting from state %d \
to state %d\n", YYPREFIX, *yystack.s_mark, yystate);
#endif
    if (yystack.s_mark >= yystack.s_last && yygrowstack(&yystack) == YYENOMEM)
    {
        goto yyoverflow;
    }
    *++yystack.s_mark = (YYINT) yystate;
    *++yystack.l_mark = yyval;
    goto yyloop;

yyoverflow:
    YYERROR_CALL("yacc stack overflow");

yyabort:
    yyfreestack(&yystack);
    return (1);

yyaccept:
    yyfreestack(&yystack);
    return (0);
}
