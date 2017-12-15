all: ParseurFormule.java ParseurRef.java Yylex.java

ParseurFormule.java: src/prog/grammaire/grammaire.y
	byaccj -J -Jclass=ParseurFormule -Jpackage=prog $<

ParseurRef.java: src/prog/grammaire/grammaireExtractRef.y
	byaccj -J -Jclass=ParseurRef -Jpackage=prog $<
	
Yylex.java : src/prog/grammaire/grammaire.flex
	jflex -d src/prog/ $<
