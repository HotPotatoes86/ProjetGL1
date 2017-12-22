//### This file created by BYACC 1.8(/Java extension  1.15)
//### Java capabilities added 7 Jan 97, Bob Jamison
//### Updated : 27 Nov 97  -- Bob Jamison, Joe Nieten
//###           01 Jan 98  -- Bob Jamison -- fixed generic semantic constructor
//###           01 Jun 99  -- Bob Jamison -- added Runnable support
//###           06 Aug 00  -- Bob Jamison -- made state variables class-global
//###           03 Jan 01  -- Bob Jamison -- improved flags, tracing
//###           16 May 01  -- Bob Jamison -- added custom stack sizing
//###           04 Mar 02  -- Yuval Oren  -- improved java performance, added options
//###           14 Mar 02  -- Tomas Hurka -- -d support, static initializer workaround
//### Please send bug reports to tom@hukatronic.cz
//### static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";



package prog;



//#line 1 "prog/grammaire/grammaire.y"


import prog.methods.*;
import prog.results.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
//#line 25 "Parser.java"




public class Parser
{

boolean yydebug;        //do I want debug output?
int yynerrs;            //number of errors so far
int yyerrflag;          //was there an error?
int yychar;             //the current working character

//########## MESSAGES ##########
//###############################################################
// method: debug
//###############################################################
void debug(String msg)
{
  if (yydebug)
    System.out.println(msg);
}

//########## STATE STACK ##########
final static int YYSTACKSIZE = 500;  //maximum stack size
int statestk[] = new int[YYSTACKSIZE]; //state stack
int stateptr;
int stateptrmax;                     //highest index of stackptr
int statemax;                        //state when highest index reached
//###############################################################
// methods: state stack push,pop,drop,peek
//###############################################################
final void state_push(int state)
{
  try {
		stateptr++;
		statestk[stateptr]=state;
	 }
	 catch (ArrayIndexOutOfBoundsException e) {
     int oldsize = statestk.length;
     int newsize = oldsize * 2;
     int[] newstack = new int[newsize];
     System.arraycopy(statestk,0,newstack,0,oldsize);
     statestk = newstack;
     statestk[stateptr]=state;
  }
}
final int state_pop()
{
  return statestk[stateptr--];
}
final void state_drop(int cnt)
{
  stateptr -= cnt; 
}
final int state_peek(int relative)
{
  return statestk[stateptr-relative];
}
//###############################################################
// method: init_stacks : allocate and prepare stacks
//###############################################################
final boolean init_stacks()
{
  stateptr = -1;
  val_init();
  return true;
}
//###############################################################
// method: dump_stacks : show n levels of the stacks
//###############################################################
void dump_stacks(int count)
{
int i;
  System.out.println("=index==state====value=     s:"+stateptr+"  v:"+valptr);
  for (i=0;i<count;i++)
    System.out.println(" "+i+"    "+statestk[i]+"      "+valstk[i]);
  System.out.println("======================");
}


//########## SEMANTIC VALUES ##########
//public class ParserVal is defined in ParserVal.java


String   yytext;//user variable to return contextual strings
ParserVal yyval; //used to return semantic vals from action routines
ParserVal yylval;//the 'lval' (result) I got from yylex()
ParserVal valstk[];
int valptr;
//###############################################################
// methods: value stack push,pop,drop,peek.
//###############################################################
void val_init()
{
  valstk=new ParserVal[YYSTACKSIZE];
  yyval=new ParserVal();
  yylval=new ParserVal();
  valptr=-1;
}
void val_push(ParserVal val)
{
  if (valptr>=YYSTACKSIZE)
    return;
  valstk[++valptr]=val;
}
ParserVal val_pop()
{
  if (valptr<0)
    return new ParserVal();
  return valstk[valptr--];
}
void val_drop(int cnt)
{
int ptr;
  ptr=valptr-cnt;
  if (ptr<0)
    return;
  valptr = ptr;
}
ParserVal val_peek(int relative)
{
int ptr;
  ptr=valptr-relative;
  if (ptr<0)
    return new ParserVal();
  return valstk[ptr];
}
final ParserVal dup_yyval(ParserVal val)
{
  ParserVal dup = new ParserVal();
  dup.ival = val.ival;
  dup.dval = val.dval;
  dup.sval = val.sval;
  dup.obj = val.obj;
  return dup;
}
//#### end semantic value section ####
public final static short STRING=257;
public final static short INT=258;
public final static short DOUBLE=259;
public final static short BOOLEAN=260;
public final static short PLUS=261;
public final static short MINUS=262;
public final static short TIMES=263;
public final static short DIVIDE=264;
public final static short MOD=265;
public final static short POW=266;
public final static short INF=267;
public final static short SUP=268;
public final static short EQ=269;
public final static short DIFF=270;
public final static short INFEQ=271;
public final static short SUPEQ=272;
public final static short PAROUV=273;
public final static short PARFER=274;
public final static short PIPE=275;
public final static short COMMA=276;
public final static short QUOTE=277;
public final static short IF=278;
public final static short THEN=279;
public final static short ELSE=280;
public final static short OR=281;
public final static short AND=282;
public final static short XOR=283;
public final static short NOT=284;
public final static short LN=285;
public final static short SIN=286;
public final static short ASIN=287;
public final static short COS=288;
public final static short ACOS=289;
public final static short TAN=290;
public final static short ATAN=291;
public final static short MINIMUM=292;
public final static short MAXIMUM=293;
public final static short MOY=294;
public final static short TODEGREE=295;
public final static short TORADIAN=296;
public final static short ABS=297;
public final static short ROUND=298;
public final static short SQRT=299;
public final static short TONUM=300;
public final static short LEN=301;
public final static short CONCAT=302;
public final static short TOSTRING=303;
public final static short SUBSTR=304;
public final static short REF=305;
public final static short POWER=306;
public final static short UNKNOWN=307;
public final static short NEG=308;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    0,    1,    1,    1,    1,    1,    1,    1,    1,
    1,    1,    1,    1,    1,    1,    1,    1,    4,    4,
    4,    4,    4,    4,    4,    4,    4,    4,    4,    4,
    4,    4,    4,    4,    4,    4,    4,    4,    4,    2,
    5,    6,    6,    3,    3,    3,    3,    3,    3,    3,
    3,    3,    3,
};
final static short yylen[] = {                            2,
    1,    6,    3,    3,    3,    3,    3,    3,    1,    2,
    1,    2,    1,    1,    1,    1,    3,    1,    2,    2,
    2,    2,    2,    2,    2,    2,    2,    2,    2,    2,
    2,    2,    2,    2,    2,    2,    2,    2,    2,    3,
    3,    1,    3,    3,    3,    3,    3,    3,    3,    3,
    3,    3,    3,
};
final static short yydefred[] = {                         0,
   16,   13,   11,   15,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   14,    0,   18,
    0,    0,    9,   12,   10,    0,    0,    0,    0,    0,
   19,   20,   21,   22,   23,   24,   25,    0,   28,   29,
   30,   26,   27,   31,   33,   34,   35,   36,   37,   38,
   39,   32,    0,    0,    0,    0,    0,    0,   17,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   47,    0,    0,    0,    0,    0,    0,    0,    0,   44,
    0,   40,   41,    0,    0,    0,    0,
};
final static short yydgoto[] = {                         31,
   38,   41,   39,   33,   49,   84,
};
final static short yysindex[] = {                      -168,
    0,    0,    0,    0, -247, -117,  -66, -254, -254, -254,
 -254, -254, -254, -254, -250, -250, -250, -254, -254, -254,
 -254, -254, -254, -254, -250, -254, -250,    0, -250,    0,
    0,   -6,    0,    0,    0, -166,  -66,  -19, -266, -117,
    0,    0,    0,    0,    0,    0,    0, -117,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0, -117, -117, -117, -117, -117, -117,    0, -236,
  -69, -117, -117, -117, -117, -117, -117, -117,  -66,  -66,
  -66, -115,   -6, -237, -100, -100, -226, -226, -226, -226,
    0,   -6,   -6,   -6,   -6,   -6,   -6, -259, -241,    0,
 -241,    0,    0, -117, -117,   -6,   -6,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   46,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0, -219,    0,   93,  116,    1,   24,   47,   70,
    0, -121,  -79,  -73,  126,  132,  138,    0, -172,    0,
  144,    0,    0,    0,    0, -209,   68,
};
final static short yygindex[] = {                         0,
    8,   40,  -37,    0,   -7,    0,
};
final static int YYTABLESIZE=427;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         71,
    6,   63,   64,   65,   66,   67,   68,   32,   50,   51,
   34,   35,   78,   36,   79,   80,   81,   59,   40,   61,
  105,   62,   48,    5,   63,   64,   65,   66,   67,   68,
   72,   73,   74,   75,   76,   77,  103,   69,  104,   68,
   80,   99,  100,  101,   70,    1,    7,   82,   42,   43,
   44,   45,   46,   47,   42,   83,   42,   52,   53,   54,
   55,   56,   57,   58,   43,   60,   43,    2,    0,    8,
   85,   86,   87,   88,   89,   90,    0,    0,    0,   92,
   93,   94,   95,   96,   97,   98,    0,    0,    1,    2,
    3,    4,    3,    5,   63,   64,   65,   66,   67,   68,
    0,   45,    0,    0,    6,    0,   45,   69,   45,    7,
   45,  106,  107,    0,    0,    4,    8,    9,   10,   11,
   12,   13,   14,   15,   16,   17,   18,   19,   20,   21,
   22,   23,   24,   25,   26,   27,   28,   29,   30,    1,
    2,    3,    4,    0,    5,   63,   64,   65,   66,   67,
   68,    0,   48,    0,    0,    6,    0,   48,  102,   48,
   48,   48,   65,   66,   67,   68,    0,    8,    9,   10,
   11,   12,   13,   14,   15,   16,   17,   18,   19,   20,
   21,   22,   23,   24,   25,   26,   27,   28,   29,   30,
    1,    2,    3,    4,   49,    5,    0,    0,    0,   49,
   50,   49,   49,   49,   91,   50,   37,   50,   50,   50,
    0,   79,   80,   81,    0,    0,    0,    0,    8,    9,
   10,   11,   12,   13,   14,   15,   16,   17,   18,   19,
   20,   21,   22,   23,   24,   25,   26,   27,   28,   29,
   30,   63,   64,   65,   66,   67,   68,   72,   73,   74,
   75,   76,   77,    0,   63,   64,   65,   66,   67,   68,
    0,    6,    6,    6,    6,    6,    0,    6,    6,    6,
    6,    6,    6,    0,    6,    0,    6,    0,    0,    6,
    6,    6,    6,    6,    5,    5,    5,    5,    5,    0,
    5,    5,    5,    5,    5,    5,    0,    5,    0,    5,
    0,    0,    5,    5,    5,    5,    5,    7,    7,    7,
    7,    7,    0,    7,    7,    7,    7,    7,    7,    0,
    7,    0,    7,    0,    0,    7,    7,    7,    7,    7,
    8,    8,    8,    8,    8,    0,    8,    8,    8,    8,
    8,    8,    0,    8,    0,    8,    0,    0,    8,    8,
    8,    8,    8,    3,    3,    0,    0,    0,    0,    3,
    3,    3,    3,    3,    3,    0,    3,    0,    3,    0,
    0,    3,    3,    3,    3,    3,    4,    4,    0,    0,
    0,    0,    4,    4,    4,    4,    4,    4,    0,    4,
    0,    4,    0,    0,    4,    4,    4,    4,    4,   51,
    0,    0,    0,    0,   51,   52,   51,   51,   51,    0,
   52,   53,   52,   52,   52,    0,   53,   46,   53,   53,
   53,    0,   46,    0,   46,    0,   46,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         37,
    0,  261,  262,  263,  264,  265,  266,    0,   16,   17,
  258,  259,  279,    6,  281,  282,  283,   25,  273,   27,
  280,   29,  273,    0,  261,  262,  263,  264,  265,  266,
  267,  268,  269,  270,  271,  272,  274,  274,  276,  266,
  282,   79,   80,   81,   37,    0,    0,   40,    9,   10,
   11,   12,   13,   14,  274,   48,  276,   18,   19,   20,
   21,   22,   23,   24,  274,   26,  276,    0,   -1,    0,
   63,   64,   65,   66,   67,   68,   -1,   -1,   -1,   72,
   73,   74,   75,   76,   77,   78,   -1,   -1,  257,  258,
  259,  260,    0,  262,  261,  262,  263,  264,  265,  266,
   -1,  274,   -1,   -1,  273,   -1,  279,  274,  281,  278,
  283,  104,  105,   -1,   -1,    0,  285,  286,  287,  288,
  289,  290,  291,  292,  293,  294,  295,  296,  297,  298,
  299,  300,  301,  302,  303,  304,  305,  306,  307,  257,
  258,  259,  260,   -1,  262,  261,  262,  263,  264,  265,
  266,   -1,  274,   -1,   -1,  273,   -1,  279,  274,  281,
  282,  283,  263,  264,  265,  266,   -1,  285,  286,  287,
  288,  289,  290,  291,  292,  293,  294,  295,  296,  297,
  298,  299,  300,  301,  302,  303,  304,  305,  306,  307,
  257,  258,  259,  260,  274,  262,   -1,   -1,   -1,  279,
  274,  281,  282,  283,  274,  279,  273,  281,  282,  283,
   -1,  281,  282,  283,   -1,   -1,   -1,   -1,  285,  286,
  287,  288,  289,  290,  291,  292,  293,  294,  295,  296,
  297,  298,  299,  300,  301,  302,  303,  304,  305,  306,
  307,  261,  262,  263,  264,  265,  266,  267,  268,  269,
  270,  271,  272,   -1,  261,  262,  263,  264,  265,  266,
   -1,  261,  262,  263,  264,  265,   -1,  267,  268,  269,
  270,  271,  272,   -1,  274,   -1,  276,   -1,   -1,  279,
  280,  281,  282,  283,  261,  262,  263,  264,  265,   -1,
  267,  268,  269,  270,  271,  272,   -1,  274,   -1,  276,
   -1,   -1,  279,  280,  281,  282,  283,  261,  262,  263,
  264,  265,   -1,  267,  268,  269,  270,  271,  272,   -1,
  274,   -1,  276,   -1,   -1,  279,  280,  281,  282,  283,
  261,  262,  263,  264,  265,   -1,  267,  268,  269,  270,
  271,  272,   -1,  274,   -1,  276,   -1,   -1,  279,  280,
  281,  282,  283,  261,  262,   -1,   -1,   -1,   -1,  267,
  268,  269,  270,  271,  272,   -1,  274,   -1,  276,   -1,
   -1,  279,  280,  281,  282,  283,  261,  262,   -1,   -1,
   -1,   -1,  267,  268,  269,  270,  271,  272,   -1,  274,
   -1,  276,   -1,   -1,  279,  280,  281,  282,  283,  274,
   -1,   -1,   -1,   -1,  279,  274,  281,  282,  283,   -1,
  279,  274,  281,  282,  283,   -1,  279,  274,  281,  282,
  283,   -1,  279,   -1,  281,   -1,  283,
};
}
final static short YYFINAL=31;
final static short YYMAXTOKEN=308;
final static String yyname[] = {
"end-of-file",null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,"STRING","INT","DOUBLE","BOOLEAN","PLUS","MINUS","TIMES",
"DIVIDE","MOD","POW","INF","SUP","EQ","DIFF","INFEQ","SUPEQ","PAROUV","PARFER",
"PIPE","COMMA","QUOTE","IF","THEN","ELSE","OR","AND","XOR","NOT","LN","SIN",
"ASIN","COS","ACOS","TAN","ATAN","MINIMUM","MAXIMUM","MOY","TODEGREE",
"TORADIAN","ABS","ROUND","SQRT","TONUM","LEN","CONCAT","TOSTRING","SUBSTR",
"REF","POWER","UNKNOWN","NEG",
};
final static String yyrule[] = {
"$accept : axiome",
"axiome : operation",
"axiome : IF condition THEN operation ELSE operation",
"operation : operation PLUS operation",
"operation : operation MINUS operation",
"operation : operation DIVIDE operation",
"operation : operation TIMES operation",
"operation : operation MOD operation",
"operation : operation POW operation",
"operation : method",
"operation : MINUS DOUBLE",
"operation : DOUBLE",
"operation : MINUS INT",
"operation : INT",
"operation : REF",
"operation : BOOLEAN",
"operation : STRING",
"operation : PAROUV operation PARFER",
"operation : UNKNOWN",
"method : LN oneArgument",
"method : SIN oneArgument",
"method : ASIN oneArgument",
"method : COS oneArgument",
"method : ACOS oneArgument",
"method : TAN oneArgument",
"method : ATAN oneArgument",
"method : TODEGREE oneArgument",
"method : TORADIAN oneArgument",
"method : MINIMUM manyArgument",
"method : MAXIMUM manyArgument",
"method : MOY manyArgument",
"method : ABS oneArgument",
"method : POWER manyArgument",
"method : ROUND oneArgument",
"method : SQRT oneArgument",
"method : TONUM oneArgument",
"method : LEN oneArgument",
"method : CONCAT manyArgument",
"method : TOSTRING oneArgument",
"method : SUBSTR manyArgument",
"oneArgument : PAROUV operation PARFER",
"manyArgument : PAROUV listArgument PARFER",
"listArgument : operation",
"listArgument : listArgument COMMA operation",
"condition : condition AND condition",
"condition : condition OR condition",
"condition : condition XOR condition",
"condition : PAROUV condition PARFER",
"condition : operation INF operation",
"condition : operation SUP operation",
"condition : operation EQ operation",
"condition : operation DIFF operation",
"condition : operation INFEQ operation",
"condition : operation SUPEQ operation",
};

//#line 119 "prog/grammaire/grammaire.y"


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
private static List<Resultat> funcArgs = new ArrayList<>(); /* utilise pour les fonctions a plusieurs arguments */
public static Resultat resultat; /* Resultat renvoye par le parser a la fin de l'analyse */
private static Conteneur conteneur; /*utilise pour extraire le resultat d'une reference*/

public static Resultat formuleToResultat(String formule, Conteneur conteneur) throws IOException, Exception {
    resultat =new ResultatErreur();
	Parser.conteneur = conteneur;
	Parser yyparser;
	yyparser = new Parser(new StringReader(formule));

	yyparser.yyparse();
	
	return resultat;
}
//#line 433 "Parser.java"
//###############################################################
// method: yylexdebug : check lexer state
//###############################################################
void yylexdebug(int state,int ch)
{
String s=null;
  if (ch < 0) ch=0;
  if (ch <= YYMAXTOKEN) //check index bounds
     s = yyname[ch];    //now get it
  if (s==null)
    s = "illegal-symbol";
  debug("state "+state+", reading "+ch+" ("+s+")");
}





//The following are now global, to aid in error reporting
int yyn;       //next next thing to do
int yym;       //
int yystate;   //current parsing state from state table
String yys;    //current token string


//###############################################################
// method: yyparse : parse input and execute indicated items
//###############################################################
int yyparse()
{
boolean doaction;
  init_stacks();
  yynerrs = 0;
  yyerrflag = 0;
  yychar = -1;          //impossible char forces a read
  yystate=0;            //initial state
  state_push(yystate);  //save it
  val_push(yylval);     //save empty value
  while (true) //until parsing is done, either correctly, or w/error
    {
    doaction=true;
    if (yydebug) debug("loop"); 
    //#### NEXT ACTION (from reduction table)
    for (yyn=yydefred[yystate];yyn==0;yyn=yydefred[yystate])
      {
      if (yydebug) debug("yyn:"+yyn+"  state:"+yystate+"  yychar:"+yychar);
      if (yychar < 0)      //we want a char?
        {
        yychar = yylex();  //get next token
        if (yydebug) debug(" next yychar:"+yychar);
        //#### ERROR CHECK ####
        if (yychar < 0)    //it it didn't work/error
          {
          yychar = 0;      //change it to default string (no -1!)
          if (yydebug)
            yylexdebug(yystate,yychar);
          }
        }//yychar<0
      yyn = yysindex[yystate];  //get amount to shift by (shift index)
      if ((yyn != 0) && (yyn += yychar) >= 0 &&
          yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
        {
        if (yydebug)
          debug("state "+yystate+", shifting to state "+yytable[yyn]);
        //#### NEXT STATE ####
        yystate = yytable[yyn];//we are in a new state
        state_push(yystate);   //save it
        val_push(yylval);      //push our lval as the input for next rule
        yychar = -1;           //since we have 'eaten' a token, say we need another
        if (yyerrflag > 0)     //have we recovered an error?
           --yyerrflag;        //give ourselves credit
        doaction=false;        //but don't process yet
        break;   //quit the yyn=0 loop
        }

    yyn = yyrindex[yystate];  //reduce
    if ((yyn !=0 ) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
      {   //we reduced!
      if (yydebug) debug("reduce");
      yyn = yytable[yyn];
      doaction=true; //get ready to execute
      break;         //drop down to actions
      }
    else //ERROR RECOVERY
      {
      if (yyerrflag==0)
        {
        yyerror("syntax error");
        yynerrs++;
        }
      if (yyerrflag < 3) //low error count?
        {
        yyerrflag = 3;
        while (true)   //do until break
          {
          if (stateptr<0)   //check for under & overflow here
            {
            yyerror("stack underflow. aborting...");  //note lower case 's'
            return 1;
            }
          yyn = yysindex[state_peek(0)];
          if ((yyn != 0) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
            if (yydebug)
              debug("state "+state_peek(0)+", error recovery shifting to state "+yytable[yyn]+" ");
            yystate = yytable[yyn];
            state_push(yystate);
            val_push(yylval);
            doaction=false;
            break;
            }
          else
            {
            if (yydebug)
              debug("error recovery discarding state "+state_peek(0)+" ");
            if (stateptr<0)   //check for under & overflow here
              {
              yyerror("Stack underflow. aborting...");  //capital 'S'
              return 1;
              }
            state_pop();
            val_pop();
            }
          }
        }
      else            //discard this token
        {
        if (yychar == 0)
          return 1; //yyabort
        if (yydebug)
          {
          yys = null;
          if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
          if (yys == null) yys = "illegal-symbol";
          debug("state "+yystate+", error recovery discards token "+yychar+" ("+yys+")");
          }
        yychar = -1;  //read another
        }
      }//end error recovery
    }//yyn=0 loop
    if (!doaction)   //any reason not to proceed?
      continue;      //skip action
    yym = yylen[yyn];          //get count of terminals on rhs
    if (yydebug)
      debug("state "+yystate+", reducing "+yym+" by rule "+yyn+" ("+yyrule[yyn]+")");
    if (yym>0)                 //if count of rhs not 'nil'
      yyval = val_peek(yym-1); //get current semantic value
    yyval = dup_yyval(yyval); //duplicate yyval if ParserVal is used as semantic value
    switch(yyn)
      {
//########## USER-SUPPLIED ACTIONS ##########
case 1:
//#line 30 "prog/grammaire/grammaire.y"
{resultat = val_peek(0).rval;}
break;
case 2:
//#line 31 "prog/grammaire/grammaire.y"
{ 
										if(val_peek(4).bval){
											resultat = val_peek(2).rval;
										}else{
											resultat = val_peek(0).rval;
										};}
break;
case 3:
//#line 40 "prog/grammaire/grammaire.y"
{yyval.rval = val_peek(2).rval.addition(val_peek(0).rval);}
break;
case 4:
//#line 41 "prog/grammaire/grammaire.y"
{yyval.rval = val_peek(2).rval.soustraction(val_peek(0).rval);}
break;
case 5:
//#line 42 "prog/grammaire/grammaire.y"
{yyval.rval = val_peek(2).rval.division(val_peek(0).rval);}
break;
case 6:
//#line 43 "prog/grammaire/grammaire.y"
{yyval.rval = val_peek(2).rval.multiplication(val_peek(0).rval);}
break;
case 7:
//#line 44 "prog/grammaire/grammaire.y"
{yyval.rval = val_peek(2).rval.modulo(val_peek(0).rval);}
break;
case 8:
//#line 45 "prog/grammaire/grammaire.y"
{funcArgs.add(val_peek(2).rval);
											funcArgs.add(val_peek(0).rval);
											Pow tmp = new Pow(funcArgs);
											yyval.rval = tmp.getResultat();
											funcArgs.clear();}
break;
case 9:
//#line 50 "prog/grammaire/grammaire.y"
{yyval.rval = val_peek(0).fval.getResultat();
											funcArgs.clear();}
break;
case 10:
//#line 52 "prog/grammaire/grammaire.y"
{yyval.rval = new ResultatDouble(-val_peek(0).dval);}
break;
case 11:
//#line 53 "prog/grammaire/grammaire.y"
{yyval.rval = new ResultatDouble(val_peek(0).dval);}
break;
case 12:
//#line 54 "prog/grammaire/grammaire.y"
{yyval.rval = new ResultatInteger(-val_peek(0).ival);}
break;
case 13:
//#line 55 "prog/grammaire/grammaire.y"
{yyval.rval = new ResultatInteger(val_peek(0).ival);}
break;
case 14:
//#line 56 "prog/grammaire/grammaire.y"
{Cellule cellRef = conteneur.getCellule(val_peek(0).sval.substring(1));
											if (cellRef==null){
												yyval.rval = new ResultatErreur();
											}else{
												yyval.rval = cellRef.getResultat();
											}}
break;
case 15:
//#line 63 "prog/grammaire/grammaire.y"
{yyval.rval = new ResultatBoolean(val_peek(0).bval);}
break;
case 16:
//#line 64 "prog/grammaire/grammaire.y"
{yyval.rval = new ResultatString(val_peek(0).sval);}
break;
case 17:
//#line 65 "prog/grammaire/grammaire.y"
{yyval.rval = val_peek(1).rval;}
break;
case 18:
//#line 66 "prog/grammaire/grammaire.y"
{yyval.rval = new ResultatErreur();}
break;
case 19:
//#line 70 "prog/grammaire/grammaire.y"
{ yyval.fval = new Ln(val_peek(0).rval);}
break;
case 20:
//#line 71 "prog/grammaire/grammaire.y"
{ yyval.fval = new Sinus(val_peek(0).rval);}
break;
case 21:
//#line 72 "prog/grammaire/grammaire.y"
{ yyval.fval = new Asinus(val_peek(0).rval);}
break;
case 22:
//#line 73 "prog/grammaire/grammaire.y"
{ yyval.fval = new Cosinus(val_peek(0).rval);}
break;
case 23:
//#line 74 "prog/grammaire/grammaire.y"
{ yyval.fval = new Acosinus(val_peek(0).rval);}
break;
case 24:
//#line 75 "prog/grammaire/grammaire.y"
{ yyval.fval = new Tangente(val_peek(0).rval);}
break;
case 25:
//#line 76 "prog/grammaire/grammaire.y"
{ yyval.fval = new Atangente(val_peek(0).rval);}
break;
case 26:
//#line 77 "prog/grammaire/grammaire.y"
{ yyval.fval = new ToDegree(val_peek(0).rval);}
break;
case 27:
//#line 78 "prog/grammaire/grammaire.y"
{ yyval.fval = new ToRadian(val_peek(0).rval);}
break;
case 28:
//#line 79 "prog/grammaire/grammaire.y"
{ yyval.fval = new Minimum(funcArgs);}
break;
case 29:
//#line 80 "prog/grammaire/grammaire.y"
{ yyval.fval = new Maximum(funcArgs);}
break;
case 30:
//#line 81 "prog/grammaire/grammaire.y"
{ yyval.fval = new Moyenne(funcArgs);}
break;
case 31:
//#line 82 "prog/grammaire/grammaire.y"
{ yyval.fval = new Absolute(val_peek(0).rval);}
break;
case 32:
//#line 83 "prog/grammaire/grammaire.y"
{ yyval.fval = new Pow(funcArgs);}
break;
case 33:
//#line 84 "prog/grammaire/grammaire.y"
{ yyval.fval = new Round(val_peek(0).rval);}
break;
case 34:
//#line 85 "prog/grammaire/grammaire.y"
{ yyval.fval = new Sqrt(val_peek(0).rval);}
break;
case 35:
//#line 86 "prog/grammaire/grammaire.y"
{ yyval.fval = new ToNum(val_peek(0).rval);}
break;
case 36:
//#line 87 "prog/grammaire/grammaire.y"
{ yyval.fval = new Len(val_peek(0).rval);}
break;
case 37:
//#line 88 "prog/grammaire/grammaire.y"
{ yyval.fval = new Concat(funcArgs);}
break;
case 38:
//#line 89 "prog/grammaire/grammaire.y"
{ yyval.fval = new ToString(val_peek(0).rval);}
break;
case 39:
//#line 90 "prog/grammaire/grammaire.y"
{ yyval.fval = new Substring(funcArgs);}
break;
case 40:
//#line 94 "prog/grammaire/grammaire.y"
{yyval.rval = val_peek(1).rval;}
break;
case 41:
//#line 98 "prog/grammaire/grammaire.y"
{}
break;
case 42:
//#line 101 "prog/grammaire/grammaire.y"
{funcArgs.add(val_peek(0).rval);}
break;
case 43:
//#line 102 "prog/grammaire/grammaire.y"
{funcArgs.add(val_peek(0).rval);}
break;
case 44:
//#line 106 "prog/grammaire/grammaire.y"
{yyval.bval = val_peek(2).bval && val_peek(0).bval;}
break;
case 45:
//#line 107 "prog/grammaire/grammaire.y"
{yyval.bval = val_peek(2).bval || val_peek(0).bval;}
break;
case 46:
//#line 108 "prog/grammaire/grammaire.y"
{yyval.bval = val_peek(2).bval^val_peek(0).bval;}
break;
case 47:
//#line 109 "prog/grammaire/grammaire.y"
{yyval.bval = val_peek(1).bval;}
break;
case 48:
//#line 110 "prog/grammaire/grammaire.y"
{yyval.bval = val_peek(2).rval.estInferieur(val_peek(0).rval);}
break;
case 49:
//#line 111 "prog/grammaire/grammaire.y"
{yyval.bval = val_peek(2).rval.estSuperieur(val_peek(0).rval);}
break;
case 50:
//#line 112 "prog/grammaire/grammaire.y"
{yyval.bval = val_peek(2).rval.estEgal(val_peek(0).rval);}
break;
case 51:
//#line 113 "prog/grammaire/grammaire.y"
{yyval.bval = val_peek(2).rval.estDifferent(val_peek(0).rval);}
break;
case 52:
//#line 114 "prog/grammaire/grammaire.y"
{yyval.bval = val_peek(2).rval.estInferieurOuEgal(val_peek(0).rval);}
break;
case 53:
//#line 115 "prog/grammaire/grammaire.y"
{yyval.bval = val_peek(2).rval.estSuperieurOuEgal(val_peek(0).rval);}
break;
//#line 809 "Parser.java"
//########## END OF USER-SUPPLIED ACTIONS ##########
    }//switch
    //#### Now let's reduce... ####
    if (yydebug) debug("reduce");
    state_drop(yym);             //we just reduced yylen states
    yystate = state_peek(0);     //get new state
    val_drop(yym);               //corresponding value drop
    yym = yylhs[yyn];            //select next TERMINAL(on lhs)
    if (yystate == 0 && yym == 0)//done? 'rest' state and at first TERMINAL
      {
      if (yydebug) debug("After reduction, shifting from state 0 to state "+YYFINAL+"");
      yystate = YYFINAL;         //explicitly say we're done
      state_push(YYFINAL);       //and save it
      val_push(yyval);           //also save the semantic value of parsing
      if (yychar < 0)            //we want another character?
        {
        yychar = yylex();        //get next character
        if (yychar<0) yychar=0;  //clean, if necessary
        if (yydebug)
          yylexdebug(yystate,yychar);
        }
      if (yychar == 0)          //Good exit (if lex returns 0 ;-)
         break;                 //quit the loop--all DONE
      }//if yystate
    else                        //else not done yet
      {                         //get next state and push, for next yydefred[]
      yyn = yygindex[yym];      //find out where to go
      if ((yyn != 0) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn]; //get new state
      else
        yystate = yydgoto[yym]; //else go to new defred
      if (yydebug) debug("after reduction, shifting from state "+state_peek(0)+" to state "+yystate+"");
      state_push(yystate);     //going again, so push state & val...
      val_push(yyval);         //for next action
      }
    }//main loop
  return 0;//yyaccept!!
}
//## end of method parse() ######################################



//## run() --- for Thread #######################################
/**
 * A default run method, used for operating this parser
 * object in the background.  It is intended for extending Thread
 * or implementing Runnable.  Turn off with -Jnorun .
 */
public void run()
{
  yyparse();
}
//## end of method run() ########################################



//## Constructors ###############################################
/**
 * Default constructor.  Turn off with -Jnoconstruct .

 */
public Parser()
{
  //nothing to do
}


/**
 * Create a parser, setting the debug to true or false.
 * @param debugMe true for debugging, false for no debug.
 */
public Parser(boolean debugMe)
{
  yydebug=debugMe;
}
//###############################################################



}
//################### END OF CLASS ##############################
