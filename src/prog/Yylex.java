/* The following code was generated by JFlex 1.4.3 on 20/12/17 16:14 */

package prog;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 20/12/17 16:14 from the specification file
 * <tt>prog/grammaire/grammaire.flex</tt>
 */
class Yylex {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\0\1\0\26\0\1\17\1\24\5\0\1\20\1\21\1\6"+
    "\1\4\1\22\1\5\1\50\1\7\12\1\2\0\1\14\1\16\1\15"+
    "\1\0\1\3\32\2\3\0\1\13\2\0\1\36\1\43\1\40\1\12"+
    "\1\31\1\26\1\41\1\30\1\25\2\2\1\33\1\10\1\32\1\11"+
    "\1\44\1\47\1\35\1\34\1\27\1\46\1\2\1\45\1\37\1\42"+
    "\1\2\1\0\1\23\uff83\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\1\1\3\1\4\1\5\1\6"+
    "\2\1\1\7\1\10\1\11\1\12\1\1\1\13\1\14"+
    "\1\15\1\16\1\17\14\1\1\0\1\20\3\0\1\21"+
    "\1\22\1\23\1\24\1\0\1\25\1\26\10\0\1\27"+
    "\14\0\1\30\1\31\1\32\1\33\1\34\7\0\1\35"+
    "\1\0\1\36\1\37\1\40\4\0\1\41\2\0\1\42"+
    "\1\43\1\0\1\44\1\45\4\0\1\46\1\47\1\50"+
    "\1\0\1\51\1\0\1\52\1\53\1\54\2\0\1\55"+
    "\3\0\1\56\4\0\1\57\1\60\3\0\1\61\1\62"+
    "\1\63";

  private static int [] zzUnpackAction() {
    int [] result = new int[126];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\51\0\122\0\173\0\51\0\51\0\51\0\51"+
    "\0\244\0\315\0\51\0\366\0\u011f\0\51\0\u0148\0\51"+
    "\0\51\0\51\0\51\0\u0171\0\u019a\0\u01c3\0\u01ec\0\u0215"+
    "\0\u023e\0\u0267\0\u0290\0\u02b9\0\u02e2\0\u030b\0\u0334\0\u035d"+
    "\0\u0386\0\u03af\0\u03d8\0\u0401\0\u042a\0\51\0\51\0\51"+
    "\0\51\0\u0171\0\51\0\51\0\u0453\0\u047c\0\u04a5\0\u04ce"+
    "\0\u04f7\0\u0520\0\u0549\0\u0572\0\51\0\u059b\0\u05c4\0\u05ed"+
    "\0\u0616\0\u063f\0\u0668\0\u0691\0\u06ba\0\u06e3\0\u070c\0\u0735"+
    "\0\u075e\0\u0386\0\51\0\51\0\51\0\51\0\u0787\0\u07b0"+
    "\0\u07d9\0\u0802\0\u082b\0\u0854\0\u087d\0\51\0\u08a6\0\51"+
    "\0\51\0\51\0\u08cf\0\u08f8\0\u0921\0\u094a\0\51\0\u0973"+
    "\0\u099c\0\51\0\51\0\u09c5\0\51\0\51\0\u09ee\0\u0a17"+
    "\0\u0a40\0\u0a69\0\51\0\51\0\51\0\u0a92\0\51\0\u0abb"+
    "\0\51\0\51\0\51\0\u0ae4\0\u0b0d\0\51\0\u0b36\0\u0b5f"+
    "\0\u0b88\0\51\0\u0bb1\0\u0bda\0\u0c03\0\u0c2c\0\51\0\51"+
    "\0\u0c55\0\u0c7e\0\u0ca7\0\51\0\51\0\51";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[126];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\2\1\4\1\5\1\6\1\7\1\10"+
    "\1\11\1\12\1\2\1\13\1\14\1\15\1\16\1\17"+
    "\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27"+
    "\1\2\1\30\1\31\1\32\1\33\1\34\1\35\1\36"+
    "\1\37\3\2\1\40\4\2\52\0\1\3\46\0\1\41"+
    "\2\0\1\42\5\0\3\42\12\0\23\42\12\0\1\43"+
    "\13\0\1\44\10\0\1\45\47\0\1\46\31\0\1\47"+
    "\50\0\1\50\50\0\1\51\32\0\24\52\1\53\24\52"+
    "\26\0\1\54\60\0\1\55\23\0\1\56\16\0\1\57"+
    "\4\0\1\60\1\61\45\0\1\62\26\0\1\63\70\0"+
    "\1\64\1\65\43\0\1\66\20\0\1\67\1\70\12\0"+
    "\1\71\66\0\1\72\2\0\1\73\1\0\1\74\3\0"+
    "\1\75\2\0\1\76\16\0\1\77\50\0\1\100\50\0"+
    "\1\101\40\0\1\102\50\0\2\42\5\0\3\42\12\0"+
    "\23\42\13\0\1\103\27\0\1\104\40\0\1\105\55\0"+
    "\1\106\44\0\1\107\27\0\1\110\17\0\1\111\1\0"+
    "\1\112\1\113\44\0\1\114\65\0\1\115\34\0\1\116"+
    "\52\0\1\117\43\0\1\120\53\0\1\121\50\0\1\122"+
    "\61\0\1\123\42\0\1\124\61\0\1\125\40\0\1\126"+
    "\24\0\1\127\63\0\1\130\34\0\1\131\73\0\1\132"+
    "\51\0\1\133\45\0\1\134\1\0\1\135\61\0\1\136"+
    "\37\0\1\115\45\0\1\137\65\0\1\140\31\0\1\141"+
    "\57\0\1\142\44\0\1\143\47\0\1\144\50\0\1\145"+
    "\53\0\1\146\43\0\1\147\53\0\1\150\50\0\1\151"+
    "\50\0\1\152\52\0\1\153\54\0\1\154\51\0\1\155"+
    "\17\0\1\156\75\0\1\157\25\0\1\160\65\0\1\161"+
    "\33\0\1\162\74\0\1\163\47\0\1\164\40\0\1\165"+
    "\50\0\1\166\60\0\1\167\42\0\1\170\52\0\1\171"+
    "\51\0\1\172\54\0\1\173\43\0\1\174\60\0\1\175"+
    "\41\0\1\176\16\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3280];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\2\1\4\11\2\1\1\11\2\1\1\11"+
    "\1\1\4\11\15\1\1\0\1\1\3\0\4\11\1\0"+
    "\2\11\10\0\1\11\14\0\1\1\4\11\7\0\1\11"+
    "\1\0\3\11\4\0\1\11\2\0\2\11\1\0\2\11"+
    "\4\0\3\11\1\0\1\11\1\0\3\11\2\0\1\11"+
    "\3\0\1\11\4\0\2\11\3\0\3\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[126];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
  private Parser yyparser;

  public Yylex(java.io.Reader r, Parser yyparser) {
    this(r);
    this.yyparser = yyparser;
  }


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Yylex(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  Yylex(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 108) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public int yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 14: 
          { return Parser.PIPE;
          }
        case 52: break;
        case 45: 
          { return Parser.TONUM;
          }
        case 53: break;
        case 49: 
          { return Parser.TODEGREE;
          }
        case 54: break;
        case 26: 
          { return Parser.MOY;
          }
        case 55: break;
        case 33: 
          { return Parser.AND;
          }
        case 56: break;
        case 30: 
          { return Parser.NOT;
          }
        case 57: break;
        case 43: 
          { return Parser.ASIN;
          }
        case 58: break;
        case 4: 
          { return Parser.MINUS;
          }
        case 59: break;
        case 3: 
          { return Parser.PLUS;
          }
        case 60: break;
        case 29: 
          { return Parser.TAN;
          }
        case 61: break;
        case 20: 
          { return Parser.DIFF;
          }
        case 62: break;
        case 5: 
          { return Parser.TIMES;
          }
        case 63: break;
        case 11: 
          { return Parser.PAROUV;
          }
        case 64: break;
        case 44: 
          { return Parser.ACOS;
          }
        case 65: break;
        case 6: 
          { return Parser.DIVIDE;
          }
        case 66: break;
        case 19: 
          { return Parser.SUPEQ;
          }
        case 67: break;
        case 10: 
          { return Parser.EQ;
          }
        case 68: break;
        case 2: 
          { yyparser.yylval = new ParserVal(Integer.parseInt(yytext())); 
							return Parser.INT;
          }
        case 69: break;
        case 41: 
          { return Parser.SQRT;
          }
        case 70: break;
        case 31: 
          { return Parser.LEN;
          }
        case 71: break;
        case 50: 
          { return Parser.TOSTRING;
          }
        case 72: break;
        case 22: 
          { return Parser.IF;
          }
        case 73: break;
        case 27: 
          { return Parser.MINIMUM;
          }
        case 74: break;
        case 16: 
          { yyparser.yylval = new ParserVal(yytext()); 
							return Parser.REF;
          }
        case 75: break;
        case 42: 
          { return Parser.ATAN;
          }
        case 76: break;
        case 23: 
          { return Parser.LN;
          }
        case 77: break;
        case 21: 
          { yyparser.yylval = new ParserVal(yytext().substring(1, yytext().length() - 1)); 
							return Parser.STRING;
          }
        case 78: break;
        case 48: 
          { return Parser.CONCAT;
          }
        case 79: break;
        case 24: 
          { yyparser.yylval = new ParserVal(Double.parseDouble(yytext())); 
							return Parser.DOUBLE;
          }
        case 80: break;
        case 28: 
          { return Parser.MAXIMUM;
          }
        case 81: break;
        case 34: 
          { return Parser.ABS;
          }
        case 82: break;
        case 46: 
          { return Parser.ROUND;
          }
        case 83: break;
        case 12: 
          { return Parser.PARFER;
          }
        case 84: break;
        case 51: 
          { return Parser.TORADIAN;
          }
        case 85: break;
        case 13: 
          { return Parser.COMMA;
          }
        case 86: break;
        case 8: 
          { return Parser.INF;
          }
        case 87: break;
        case 9: 
          { return Parser.SUP;
          }
        case 88: break;
        case 32: 
          { return Parser.SIN;
          }
        case 89: break;
        case 17: 
          { return Parser.OR;
          }
        case 90: break;
        case 35: 
          { return Parser.XOR;
          }
        case 91: break;
        case 38: 
          { return Parser.THEN;
          }
        case 92: break;
        case 37: 
          { return Parser.POWER;
          }
        case 93: break;
        case 36: 
          { return Parser.COS;
          }
        case 94: break;
        case 25: 
          { return Parser.MOD;
          }
        case 95: break;
        case 18: 
          { return Parser.INFEQ;
          }
        case 96: break;
        case 40: 
          { return Parser.ELSE;
          }
        case 97: break;
        case 7: 
          { return Parser.POW;
          }
        case 98: break;
        case 47: 
          { return Parser.SUBSTR;
          }
        case 99: break;
        case 15: 
          { return Parser.QUOTE;
          }
        case 100: break;
        case 39: 
          { yyparser.yylval = new ParserVal(Boolean.parseBoolean(yytext()));
							return Parser.BOOLEAN;
          }
        case 101: break;
        case 1: 
          { 
          }
        case 102: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return 0; }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
