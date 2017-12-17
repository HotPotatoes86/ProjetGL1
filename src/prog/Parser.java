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






//#line 1 "grammaire.y"

package prog;

import prog.methods.*;
import prog.results.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
//#line 26 "Parser.java"




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
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    0,    1,    1,    1,    1,    1,    1,    1,    1,
    1,    1,    1,    1,    6,    6,    6,    6,    6,    6,
    6,    6,    6,    6,    6,    6,    6,    6,    6,    6,
    6,    6,    6,    6,    6,    2,    3,    4,    4,    5,
    5,    5,    5,    5,    5,    5,    5,    5,    5,
};
final static short yylen[] = {                            2,
    1,    6,    3,    3,    3,    3,    3,    1,    1,    1,
    1,    1,    3,    3,    2,    2,    2,    2,    2,    2,
    2,    2,    2,    2,    2,    2,    2,    2,    2,    2,
    2,    2,    2,    2,    2,    3,    3,    1,    3,    3,
    3,    3,    3,    3,    3,    3,    3,    3,    3,
};
final static short yydefred[] = {                         0,
   10,    9,   12,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   11,    0,    0,
    8,    0,   28,    0,    0,    0,    0,    0,    0,   15,
   16,   17,   18,   19,   20,   21,   24,   25,   26,   22,
   23,   27,   29,   30,   31,   32,   33,   34,   35,    0,
    0,    0,    0,    0,    0,    0,   14,   13,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    6,    5,    7,    0,   37,   43,    0,
    0,    0,    0,    0,    0,    0,    0,   40,    0,   36,
   39,    0,    0,
};
final static short yydgoto[] = {                         29,
   37,   40,   33,   66,   38,   31,
};
final static short yysindex[] = {                      -178,
    0,    0,    0, -267, -130, -234,  -82, -247, -247, -247,
 -247, -247, -247, -247, -267, -267, -267, -247, -247, -247,
 -247, -247, -247, -247, -267, -247, -267,    0,    0,   -4,
    0, -130,    0, -243, -252,  -82,  -19, -196, -130,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0, -130,
 -130, -130, -130, -130, -248, -245,    0,    0, -216,  -27,
 -130, -130, -130, -130, -130, -130, -130,  -82,  -82,  -82,
 -171, -260, -260,    0,    0,    0, -130,    0,    0,   -4,
   -4,   -4,   -4,   -4,   -4, -253, -250,    0, -250,    0,
    0, -130,   -4,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   33,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0, -238,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    1,   24,    0,    0,    0,    0,    0,    0, -142,
 -129,  -94,  -81,   34,   40,    0, -244,    0,   46,    0,
    0,    0,   50,
};
final static short yygindex[] = {                         0,
    2,  215,   44,  -47,  -36,    0,
};
final static int YYTABLESIZE=329;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         70,
    3,   30,   62,   63,   64,   32,   34,   60,   61,   62,
   63,   64,   60,   61,   62,   63,   64,   60,   61,   62,
   63,   64,   35,    4,   68,   39,  102,   87,   88,   41,
   67,   79,    1,   65,   41,   38,   41,   69,   41,  101,
   81,   97,   98,   99,   60,   61,   62,   63,   64,    2,
   71,   72,   73,   74,   75,   76,    0,   67,   47,   48,
   49,   82,   83,   84,   85,   86,    0,    0,   57,    0,
   59,    0,   90,   91,   92,   93,   94,   95,   96,    1,
    2,    3,   77,    0,   78,   79,   80,    4,   65,   60,
   61,   62,   63,   64,    5,    0,    0,    0,    6,    7,
    0,    0,  100,  103,    0,    0,    8,    9,   10,   11,
   12,   13,   14,   15,   16,   17,   18,   19,   20,   21,
   22,   23,   24,   25,   26,   27,   28,    1,    2,    3,
    0,   44,    0,    0,    0,    4,   44,    0,   44,   44,
   44,    0,    5,    0,   45,    0,    6,    0,    0,   45,
    0,   45,   45,   45,    8,    9,   10,   11,   12,   13,
   14,   15,   16,   17,   18,   19,   20,   21,   22,   23,
   24,   25,   26,   27,   28,    1,    2,    3,    0,   46,
    0,    0,    0,    4,   46,    0,   46,   46,   46,    0,
   36,    0,   47,    0,    6,    0,    0,   47,    0,   47,
   47,   47,    8,    9,   10,   11,   12,   13,   14,   15,
   16,   17,   18,   19,   20,   21,   22,   23,   24,   25,
   26,   27,   28,   41,   42,   43,   44,   45,   46,    0,
    0,    0,   50,   51,   52,   53,   54,   55,   56,    0,
   58,   60,   61,   62,   63,   64,   89,   71,   72,   73,
   74,   75,   76,   78,   79,   80,   60,   61,   62,   63,
   64,    3,    3,    0,    0,    0,    0,    3,    3,    3,
    3,    3,    3,    0,    3,    0,    3,    0,    0,    3,
    3,    3,    3,    3,    4,    4,    0,    0,    0,    0,
    4,    4,    4,    4,    4,    4,    0,    4,    0,    4,
    0,    0,    4,    4,    4,    4,    4,   48,    0,    0,
    0,    0,   48,   49,   48,   48,   48,    0,   49,   42,
   49,   49,   49,    0,   42,    0,   42,    0,   42,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         36,
    0,    0,  263,  264,  265,  273,    5,  261,  262,  263,
  264,  265,  261,  262,  263,  264,  265,  261,  262,  263,
  264,  265,  257,    0,  277,  273,  280,  276,  274,  274,
  274,  282,    0,   32,  279,  274,  281,   36,  283,   87,
   39,   78,   79,   80,  261,  262,  263,  264,  265,    0,
  267,  268,  269,  270,  271,  272,   -1,  274,   15,   16,
   17,   60,   61,   62,   63,   64,   -1,   -1,   25,   -1,
   27,   -1,   71,   72,   73,   74,   75,   76,   77,  258,
  259,  260,  279,   -1,  281,  282,  283,  266,   87,  261,
  262,  263,  264,  265,  273,   -1,   -1,   -1,  277,  278,
   -1,   -1,  274,  102,   -1,   -1,  285,  286,  287,  288,
  289,  290,  291,  292,  293,  294,  295,  296,  297,  298,
  299,  300,  301,  302,  303,  304,  305,  258,  259,  260,
   -1,  274,   -1,   -1,   -1,  266,  279,   -1,  281,  282,
  283,   -1,  273,   -1,  274,   -1,  277,   -1,   -1,  279,
   -1,  281,  282,  283,  285,  286,  287,  288,  289,  290,
  291,  292,  293,  294,  295,  296,  297,  298,  299,  300,
  301,  302,  303,  304,  305,  258,  259,  260,   -1,  274,
   -1,   -1,   -1,  266,  279,   -1,  281,  282,  283,   -1,
  273,   -1,  274,   -1,  277,   -1,   -1,  279,   -1,  281,
  282,  283,  285,  286,  287,  288,  289,  290,  291,  292,
  293,  294,  295,  296,  297,  298,  299,  300,  301,  302,
  303,  304,  305,    9,   10,   11,   12,   13,   14,   -1,
   -1,   -1,   18,   19,   20,   21,   22,   23,   24,   -1,
   26,  261,  262,  263,  264,  265,  274,  267,  268,  269,
  270,  271,  272,  281,  282,  283,  261,  262,  263,  264,
  265,  261,  262,   -1,   -1,   -1,   -1,  267,  268,  269,
  270,  271,  272,   -1,  274,   -1,  276,   -1,   -1,  279,
  280,  281,  282,  283,  261,  262,   -1,   -1,   -1,   -1,
  267,  268,  269,  270,  271,  272,   -1,  274,   -1,  276,
   -1,   -1,  279,  280,  281,  282,  283,  274,   -1,   -1,
   -1,   -1,  279,  274,  281,  282,  283,   -1,  279,  274,
  281,  282,  283,   -1,  279,   -1,  281,   -1,  283,
};
}
final static short YYFINAL=29;
final static short YYMAXTOKEN=305;
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
"REF",
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
"operation : method",
"operation : DOUBLE",
"operation : INT",
"operation : REF",
"operation : BOOLEAN",
"operation : QUOTE STRING QUOTE",
"operation : PAROUV operation PARFER",
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
"method : POW manyArgument",
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
"listArgument : operation COMMA listArgument",
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

//#line 108 "grammaire.y"


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

private static List<Resultat> funcArgs = new ArrayList<>();
public static Resultat resultat; 
private static Conteneur conteneur; /*utilisé pour extraire le resultat d'une référence*/

public static Resultat formuleToResultat(String formule, Conteneur conteneur) throws IOException, Exception {
	resultat = new ResultatErreur();
	Parser.conteneur = conteneur;
	Parser yyparser;
	yyparser = new Parser(new StringReader(formule));

	yyparser.yyparse();
	
	return resultat;
}
//#line 404 "Parser.java"
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
//#line 31 "grammaire.y"
{resultat = val_peek(0).rval;}
break;
case 2:
//#line 32 "grammaire.y"
{ 
										if(val_peek(4).bval){
											resultat = val_peek(2).rval;
										}else{
											resultat = val_peek(0).rval;
										};}
break;
case 3:
//#line 40 "grammaire.y"
{yyval.rval = val_peek(2).rval.addition(val_peek(0).rval);}
break;
case 4:
//#line 41 "grammaire.y"
{yyval.rval = val_peek(2).rval.soustraction(val_peek(0).rval);}
break;
case 5:
//#line 42 "grammaire.y"
{yyval.rval = val_peek(2).rval.division(val_peek(0).rval);}
break;
case 6:
//#line 43 "grammaire.y"
{yyval.rval = val_peek(2).rval.multiplication(val_peek(0).rval);}
break;
case 7:
//#line 44 "grammaire.y"
{yyval.rval = val_peek(2).rval.modulo(val_peek(0).rval);}
break;
case 8:
//#line 45 "grammaire.y"
{yyval.rval = val_peek(0).fval.getResultat();
											funcArgs.clear();}
break;
case 9:
//#line 47 "grammaire.y"
{yyval.rval = new ResultatDouble(val_peek(0).dval);}
break;
case 10:
//#line 48 "grammaire.y"
{yyval.rval = new ResultatInteger(val_peek(0).ival);}
break;
case 11:
//#line 49 "grammaire.y"
{Cellule cellRef = conteneur.getCellule(val_peek(0).sval.substring(1));
											if (cellRef==null){
												yyval.rval = new ResultatErreur();
											}else{
												yyval.rval = cellRef.getResultat();
											}}
break;
case 12:
//#line 56 "grammaire.y"
{yyval.rval = new ResultatBoolean(val_peek(0).bval);}
break;
case 13:
//#line 57 "grammaire.y"
{yyval.rval = new ResultatString(val_peek(1).sval);}
break;
case 14:
//#line 58 "grammaire.y"
{yyval.rval = val_peek(1).rval;}
break;
case 15:
//#line 61 "grammaire.y"
{ yyval.fval = new Ln(val_peek(0).rval);}
break;
case 16:
//#line 62 "grammaire.y"
{ yyval.fval = new Sinus(val_peek(0).rval);}
break;
case 17:
//#line 63 "grammaire.y"
{ yyval.fval = new Asinus(val_peek(0).rval);}
break;
case 18:
//#line 64 "grammaire.y"
{ yyval.fval = new Cosinus(val_peek(0).rval);}
break;
case 19:
//#line 65 "grammaire.y"
{ yyval.fval = new Acosinus(val_peek(0).rval);}
break;
case 20:
//#line 66 "grammaire.y"
{ yyval.fval = new Tangente(val_peek(0).rval);}
break;
case 21:
//#line 67 "grammaire.y"
{ yyval.fval = new Atangente(val_peek(0).rval);}
break;
case 22:
//#line 68 "grammaire.y"
{ yyval.fval = new ToDegree(val_peek(0).rval);}
break;
case 23:
//#line 69 "grammaire.y"
{ yyval.fval = new ToRadian(val_peek(0).rval);}
break;
case 24:
//#line 70 "grammaire.y"
{ yyval.fval = new Minimum(funcArgs);}
break;
case 25:
//#line 71 "grammaire.y"
{ yyval.fval = new Maximum(funcArgs);}
break;
case 26:
//#line 72 "grammaire.y"
{ yyval.fval = new Moyenne(funcArgs);}
break;
case 27:
//#line 73 "grammaire.y"
{ yyval.fval = new Absolute(val_peek(0).rval);}
break;
case 28:
//#line 74 "grammaire.y"
{ yyval.fval = new Pow(val_peek(0).lval);}
break;
case 29:
//#line 75 "grammaire.y"
{ yyval.fval = new Round(val_peek(0).rval);}
break;
case 30:
//#line 76 "grammaire.y"
{ yyval.fval = new Sqrt(val_peek(0).rval);}
break;
case 31:
//#line 77 "grammaire.y"
{ yyval.fval = new ToNum(val_peek(0).rval);}
break;
case 32:
//#line 78 "grammaire.y"
{ yyval.fval = new Len(val_peek(0).rval);}
break;
case 33:
//#line 79 "grammaire.y"
{ yyval.fval = new Concat(val_peek(0).lval);}
break;
case 34:
//#line 80 "grammaire.y"
{ yyval.fval = new ToString(val_peek(0).rval);}
break;
case 35:
//#line 81 "grammaire.y"
{ yyval.fval = new Substring(val_peek(0).lval);}
break;
case 36:
//#line 84 "grammaire.y"
{yyval.rval = val_peek(1).rval;}
break;
case 37:
//#line 87 "grammaire.y"
{yyval.lval = val_peek(1).lval;}
break;
case 38:
//#line 90 "grammaire.y"
{funcArgs.add(val_peek(0).rval);
										yyval.lval = funcArgs;}
break;
case 39:
//#line 92 "grammaire.y"
{funcArgs.add(val_peek(2).rval);}
break;
case 40:
//#line 95 "grammaire.y"
{yyval.bval = val_peek(2).bval && val_peek(0).bval;}
break;
case 41:
//#line 96 "grammaire.y"
{yyval.bval = val_peek(2).bval || val_peek(0).bval;}
break;
case 42:
//#line 97 "grammaire.y"
{yyval.bval = val_peek(2).bval^val_peek(0).bval;}
break;
case 43:
//#line 98 "grammaire.y"
{yyval.bval = val_peek(1).bval;}
break;
case 44:
//#line 99 "grammaire.y"
{yyval.bval = val_peek(2).rval.estInferieur(val_peek(0).rval);}
break;
case 45:
//#line 100 "grammaire.y"
{yyval.bval = val_peek(2).rval.estSuperieur(val_peek(0).rval);}
break;
case 46:
//#line 101 "grammaire.y"
{yyval.bval = val_peek(2).rval.estEgal(val_peek(0).rval);}
break;
case 47:
//#line 102 "grammaire.y"
{yyval.bval = val_peek(2).rval.estDifferent(val_peek(0).rval);}
break;
case 48:
//#line 103 "grammaire.y"
{yyval.bval = val_peek(2).rval.estInferieurOuEgal(val_peek(0).rval);}
break;
case 49:
//#line 104 "grammaire.y"
{yyval.bval = val_peek(2).rval.estSuperieurOuEgal(val_peek(0).rval);}
break;
//#line 761 "Parser.java"
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
