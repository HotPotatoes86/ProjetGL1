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






//#line 2 "grammaire.y"
  import java.io.*;
  import java.util.ArrayList;
  import java.util.List;
//#line 21 "Parser.java"




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
public final static short PLUS=257;
public final static short MOINS=258;
public final static short FOIS=259;
public final static short DIV=260;
public final static short MOD=261;
public final static short POW=262;
public final static short PAROUV=263;
public final static short PARFER=264;
public final static short PIPE=265;
public final static short COMMA=266;
public final static short INF=267;
public final static short SUP=268;
public final static short EQ=269;
public final static short DIFF=270;
public final static short IF=271;
public final static short THEN=272;
public final static short ELSE=273;
public final static short AND=274;
public final static short OR=275;
public final static short NOT=276;
public final static short XOR=277;
public final static short QUOTE=278;
public final static short BOOLEAN=279;
public final static short NUM=280;
public final static short NAME=281;
public final static short MINUS=282;
public final static short TIMES=283;
public final static short DIVIDE=284;
public final static short NEG=285;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    0,    2,    2,    2,    2,    2,    2,    2,    2,
    2,    2,    2,    2,    2,    1,    1,    1,    3,    4,
    4,    4,    4,    4,    5,    5,    5,    5,    5,
};
final static short yylen[] = {                            2,
    1,    0,    3,    3,    3,    3,    3,    3,    4,    2,
    1,    3,    3,    1,    1,    3,    1,    0,    6,    1,
    3,    3,    3,    4,    3,    3,    3,    3,    2,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,   14,   11,    0,    0,    0,   15,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   12,    0,    0,   29,    0,    0,
    0,    0,    0,    0,    0,    0,   13,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   23,   22,   21,    9,    0,   24,    0,   16,
    0,
};
final static short yydgoto[] = {                          8,
   38,   14,   10,   15,   16,
};
final static short yysindex[] = {                      -106,
 -106, -106, -137, -277,    0,    0, -252,    0, -153,    0,
 -256, -169, -131, -183, -260, -272, -262, -106, -106, -106,
 -106, -106, -106, -106,    0, -112, -112,    0, -106, -106,
 -106, -106, -106, -137, -137, -137,    0, -243, -159, -203,
 -256, -256, -203, -256, -256, -214, -242, -153, -153, -153,
 -153, -238,    0,    0,    0,    0, -106,    0, -106,    0,
 -153,
};
final static short yyrindex[] = {                        33,
    0,    0,    0,    0,    0,    0,    0,    0,   36,    0,
    1,    0,    0,    0,    0, -230,    0, -213,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0, -212,  118,
   25,   49,  137,   73,   97,    0,    0, -257,  -94,  -88,
  -82,    0,    0,    0,    0,    0, -213,    0,    0,    0,
  154,
};
final static short yygindex[] = {                         0,
    6,    8,    0,   26,  -13,
};
final static int YYTABLESIZE=431;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         28,
   10,   34,   35,   17,   36,   21,   25,    9,   11,   12,
   18,   33,   47,   28,   25,   37,   25,   25,   19,   25,
   56,   58,   20,   21,    7,   39,   40,   41,   42,   43,
   44,   45,    2,   46,   59,    1,   48,   49,   50,   51,
   52,   20,   19,   22,   23,   24,   20,   21,    8,   25,
   18,   17,   29,   30,   31,   32,    0,   20,   21,   53,
   54,   55,   60,    0,   39,    0,   61,   22,   23,   24,
    0,    0,    6,   19,    0,    0,    0,   20,   21,   23,
   24,    0,    0,   29,   30,   31,   32,   19,    0,    0,
    0,   20,   21,    0,   25,    0,    5,   19,   22,   23,
   24,   20,   21,   19,    0,    0,   57,   20,   21,    0,
    0,    0,   22,   23,   24,    0,    0,    3,    0,    0,
    1,    0,   22,   23,   24,    2,    1,    0,   22,   23,
   24,   26,    0,    3,    0,    0,    4,    0,   13,    3,
    4,    5,    6,    7,   27,    1,    4,    5,    6,    7,
    2,    1,    0,   19,    0,    0,    2,    0,    3,    0,
    0,    0,    0,   27,    3,    4,    5,    6,    7,   26,
    0,    4,    5,    6,    7,   27,    0,   26,    0,   26,
   26,   28,   26,   27,    0,   27,   27,    0,   27,   28,
    0,   28,   28,    0,   28,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   10,    0,    0,
    0,   10,    0,    0,   10,    0,   10,   10,   10,   10,
   10,    0,   10,   10,   10,   10,    0,   10,    0,    0,
    0,    7,   10,   10,   10,    7,    0,    0,    7,    0,
    7,    7,    7,    7,    7,    0,    7,    7,    7,    7,
    0,    7,    0,    0,    0,    8,    7,    7,    7,    8,
    0,    0,    8,    0,    8,    8,    8,    8,    8,    0,
    8,    8,    8,    8,    0,    8,    0,    0,    0,    6,
    8,    8,    8,    6,    0,    0,    6,    0,    6,    6,
    6,    6,    6,    0,    6,    6,    6,    6,    0,    6,
    0,    0,    0,    5,    6,    6,    6,    5,    0,    0,
    5,    0,    5,    5,    5,    5,    5,    0,    5,    5,
    5,    5,    0,    5,    3,    0,    0,    0,    5,    5,
    5,    3,    0,    3,    3,    3,    3,    3,    0,    3,
    3,    3,    3,    4,    3,    0,    0,    0,    0,    3,
    4,    0,    4,    4,    4,    4,    4,    0,    4,    4,
    4,    4,    0,    4,    0,    0,    0,   19,    4,   19,
   19,   19,   19,   19,    0,   19,   19,   19,   19,    0,
   19,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         13,
    0,  274,  275,  281,  277,  262,  264,    0,    1,    2,
  263,  272,   26,   27,  272,  278,  274,  275,  257,  277,
  264,  264,  261,  262,    0,   18,   19,   20,   21,   22,
   23,   24,    0,   26,  273,    0,   29,   30,   31,   32,
   33,  272,  257,  282,  283,  284,  261,  262,    0,  264,
  264,  264,  267,  268,  269,  270,   -1,  261,  262,   34,
   35,   36,   57,   -1,   57,   -1,   59,  282,  283,  284,
   -1,   -1,    0,  257,   -1,   -1,   -1,  261,  262,  283,
  284,   -1,   -1,  267,  268,  269,  270,  257,   -1,   -1,
   -1,  261,  262,   -1,  264,   -1,    0,  257,  282,  283,
  284,  261,  262,  257,   -1,   -1,  266,  261,  262,   -1,
   -1,   -1,  282,  283,  284,   -1,   -1,    0,   -1,   -1,
  258,   -1,  282,  283,  284,  263,  258,   -1,  282,  283,
  284,  263,   -1,  271,   -1,   -1,    0,   -1,  276,  271,
  278,  279,  280,  281,  276,  258,  278,  279,  280,  281,
  263,  258,   -1,    0,   -1,   -1,  263,   -1,  271,   -1,
   -1,   -1,   -1,  276,  271,  278,  279,  280,  281,  264,
   -1,  278,  279,  280,  281,  264,   -1,  272,   -1,  274,
  275,  264,  277,  272,   -1,  274,  275,   -1,  277,  272,
   -1,  274,  275,   -1,  277,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
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
  274,  275,   -1,  277,   -1,   -1,   -1,  264,  282,  266,
  267,  268,  269,  270,   -1,  272,  273,  274,  275,   -1,
  277,
};
}
final static short YYFINAL=8;
final static short YYMAXTOKEN=285;
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
null,null,null,"PLUS","MOINS","FOIS","DIV","MOD","POW","PAROUV","PARFER","PIPE",
"COMMA","INF","SUP","EQ","DIFF","IF","THEN","ELSE","AND","OR","NOT","XOR",
"QUOTE","BOOLEAN","NUM","NAME","MINUS","TIMES","DIVIDE","NEG",
};
final static String yyrule[] = {
"$accept : axiome",
"axiome : operation",
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
"operation : condition",
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

//#line 68 "grammaire.y"

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
//#line 350 "Parser.java"
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
//#line 23 "grammaire.y"
{res = new Arbre(val_peek(0).Arbre);}
break;
case 2:
//#line 24 "grammaire.y"
{}
break;
case 3:
//#line 27 "grammaire.y"
{yyval.Arbre = new Valeur(val_peek(2).Arbre.getResultat() + val_peek(0).Arbre.getResultat());}
break;
case 4:
//#line 28 "grammaire.y"
{yyval.Arbre = new Valeur(val_peek(2).Arbre.getResultat() - val_peek(0).Arbre.getResultat());}
break;
case 5:
//#line 29 "grammaire.y"
{yyval.Arbre = new Valeur(val_peek(2).Arbre.getResultat() / val_peek(0).Arbre.getResultat());}
break;
case 6:
//#line 30 "grammaire.y"
{yyval.Arbre = new Valeur(val_peek(2).Arbre.getResultat() * val_peek(0).Arbre.getResultat());}
break;
case 7:
//#line 31 "grammaire.y"
{yyval.Arbre = new Valeur(val_peek(2).Arbre.getResultat() mod val_peek(0).Arbre.getResultat());}
break;
case 8:
//#line 32 "grammaire.y"
{yyval.Arbre = new Valeur(Math.pow(val_peek(2).Arbre,val_peek(0).Arbre));}
break;
case 9:
//#line 33 "grammaire.y"
{funcArgs.clear();
		  								yyval.Arbre = new Operation(val_peek(3).String,funcArgs);}
break;
case 10:
//#line 35 "grammaire.y"
{yyval.Arbre=-val_peek(0).Arbre;}
break;
case 11:
//#line 36 "grammaire.y"
{yyval.Arbre = new Valeur(val_peek(0).double);}
break;
case 12:
//#line 37 "grammaire.y"
{yyval.Arbre = val_peek(1).Arbre;}
break;
case 13:
//#line 38 "grammaire.y"
{yyval.Arbre = new Valeur(val_peek(1).String);}
break;
case 14:
//#line 39 "grammaire.y"
{yyval.Arbre = new Valeur(val_peek(0).boolean);}
break;
case 15:
//#line 40 "grammaire.y"
{yyval.Arbre = val_peek(0).Arbre;}
break;
case 16:
//#line 43 "grammaire.y"
{funcArgs.add(val_peek(2).Arbre);}
break;
case 17:
//#line 44 "grammaire.y"
{funcArgs.add(val_peek(0).Arbre);}
break;
case 18:
//#line 45 "grammaire.y"
{}
break;
case 19:
//#line 49 "grammaire.y"
{if (val_peek(4).boolean){yyval.Arbre = val_peek(2).Arbre; } else {yyval.Arbre = val_peek(0).Arbre;}}
break;
case 20:
//#line 52 "grammaire.y"
{}
break;
case 21:
//#line 53 "grammaire.y"
{}
break;
case 22:
//#line 54 "grammaire.y"
{}
break;
case 23:
//#line 55 "grammaire.y"
{}
break;
case 24:
//#line 56 "grammaire.y"
{}
break;
case 25:
//#line 59 "grammaire.y"
{}
break;
case 26:
//#line 60 "grammaire.y"
{}
break;
case 27:
//#line 61 "grammaire.y"
{}
break;
case 28:
//#line 62 "grammaire.y"
{}
break;
case 29:
//#line 63 "grammaire.y"
{}
break;
//#line 616 "Parser.java"
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
