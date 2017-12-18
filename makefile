SOURCE=ParseurFormule.java ParseurRef.java Yylex.java

all: ParseurFormule.java ParseurRef.java Yylex.java

ParseurFormule.java: src/prog/grammaire/grammaire.y
	byaccj -J -Jclass=Parser -Jpackage=prog $<

ParseurRef.java: src/prog/grammaire/grammaireExtractRef.y
	byaccj -J -Jclass=ParserExtract -Jpackage=prog $<
	
Yylex.java : src/prog/grammaire/grammaire.flex
	jflex -d src/prog/ $<
