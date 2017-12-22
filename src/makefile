NAME = Projet
CC = javac
CFLAGS = -cp .:lib/mysql-connector-java-5.1.45-bin.jar:lib/sqlite-jdbc-3.21.0.jar:lib/sqlite-jdbc-3.8.11.2.jar
SOURCE = Calcul.java Conteneur.java SaveManager.java ParserExtract.java Parser.java ParserVal.java YyExtractRef.java Yylex.java
SOURCE_METHODS = Absolute.java Acosinus.java Asinus.java Atangente.java Concat.java \
Cosinus.java Fonction.java Len.java Ln.java Maximum.java Minimum.java Moyenne.java \
Pow.java Round.java Sinus.java Sqrt.java Substring.java Tangente.java ToDegree.java \
ToNum.java ToRadian.java ToString.java
SOURCE_RESULTS = ResultatBoolean.java ResultatDouble.java ResultatErreur.java \
ResultatInteger.java Resultat.java ResultatString.java
OBJECT = $(SOURCE:.java=.class)
OBJECT_METHODS = $(SOURCE_METHODS:.java=.class)
OBJECT_RESULTS = $(SOURCE_RESULTS:.java=.class)
BIN = bin
SRC = prog
RES = results
FNC = methods
DOC = Doc

.PHONY : all, clean, grammaire, clean_grammaire, doc, clean_doc, re, archive, test, test_calcul, test_cellule, test_conteneur, test_saveManager

all : $(BIN) $(addprefix $(BIN)/$(SRC)/, $(OBJECT)) $(addprefix $(BIN)/$(SRC)/$(RES)/, $(OBJECT_RESULTS)) $(addprefix $(BIN)/$(SRC)/$(FNC)/, $(OBJECT_METHODS)) $(BIN)/Main.class

$(BIN)/$(SRC)/%.class:$(SRC)/%.java
	@echo "compilation du fichier $^"
	@$(CC) -d $(BIN) $^ $(CFLAGS)

$(BIN)/$(SRC)/$(RES)/%.class:$(SRC)/$(RES)/%.java 
	@echo "compilation du fichier $^"
	@$(CC) -d $(BIN)/ $^ $(CFLAGS)


$(BIN)/$(SRC)/$(FNC)/%.class:$(SRC)/$(FNC)/%.java
	@echo "compilation du fichier $^"
	@$(CC) -d $(BIN)/ $^ $(CFLAGS)

$(BIN)/Main.class:Main.java
	@echo "compilation du fichier $^"
	@$(CC) -d $(BIN)/ $^ $(CFLAGS)

$(DOC):
	@echo "création du répertoire $(DOC)/"
	@mkdir $(DOC)/

$(BIN):
	@echo "creation du répertoire $(BIN) et de ses sous répertoires"
	@mkdir $(BIN)/

grammaire:
	@echo "compilation de la grammaire"
	@byaccj -J -Jclass=Parser -Jpackage=prog $(SRC)/grammaire/grammaire.y
	@mv Parser.java $(SRC)/.
	@rm -f ParserVal.java
	@byaccj -J -Jclass=ParserExtract -Jpackage=prog $(SRC)/grammaire/grammaireExtractRef.y
	@mv ParserExtract.java $(SRC)/.
	@rm -f ParserExtractVal.java
	@sed -i 's/ParserExtractVal/ParserVal/g' $(SRC)/ParserExtract.java
	@jflex -d $(SRC) $(SRC)/grammaire/grammaireExtractRef.flex >/dev/null
	@jflex -d $(SRC) $(SRC)/grammaire/grammaire.flex >/dev/null
	@echo "grammaire compilé"



clean :
	@echo "suppression du répertoire $(BIN)/"
	@/bin/rm -rf $(BIN)

clean_grammaire :
	@echo "suppression des fichier Yylex.java, Yylex.java~, YyExtractRef.java, YyExtractRef.java~, Parser.java et ParserExtract.java"
	@/bin/rm -f $(SRC)/Yylex.java
	@/bin/rm -f $(SRC)/Yylex.java~
	@/bin/rm -f $(SRC)/YyExtractRef.java
	@/bin/rm -f $(SRC)/YyExtractRef.java~
	@/bin/rm -f $(SRC)/Parser.java
	@/bin/rm -f $(SRC)/ParserExtract.java

doc : $(DOC)
	@echo "génération de la doc"
	@doxygen Doxyfile
	@echo "doc généré"

clean_doc :
	@echo "suppression du répertoire $(DOC)"
	@/bin/rm -rf $(DOC)

re : fclean all

archive : fclean clean_doc
	@/bin/rm -rf $(ARCHIVE)
	@mkdir $(ARCHIVE)
	@rsync -r --exclude=$(ARCHIVE) --exclude=$(ARCHIVE)$(EXTENSION) * $(ARCHIVE)/
	zip -r $(ARCHIVE)$(EXTENSION) $(ARCHIVE)
	@/bin/rm -rf $(ARCHIVE)

#test#
test:test_calcul test_cellule test_conteneur test_saveManager

test_cellule: $(BIN)
	@echo "test cellule"
	@javac -d $(BIN)/ -cp .:test/lib/junit.jar test/CelluleTest.java
	@java -cp .:test/lib/junit.jar:hamcrest-core.jar:$(BIN) org.junit.runner.JUnitCore test.CelluleTest

test_calcul:$(BIN)
	@echo "test calcul"
	@javac -d $(BIN)/ -cp .:test/lib/junit.jar test/CalculTest.java
	@java -cp .:test/lib/junit.jar:hamcrest-core.jar:$(BIN) org.junit.runner.JUnitCore test.CalculTest

test_conteneur:$(BIN)
	@echo "test conteneur"
	@javac -d $(BIN)/ -cp .:test/lib/junit.jar test/ConteneurTest.java
	@java -cp .:test/lib/junit.jar:hamcrest-core.jar:$(BIN) org.junit.runner.JUnitCore test.ConteneurTest

test_saveManager:$(BIN)
	@echo "test SaveManager"
	@javac -d $(BIN)/ -cp .:test/lib/junit.jar test/SaveManagerTest.java
	@java -cp .:test/lib/junit.jar:hamcrest-core.jar:$(BIN) org.junit.runner.JUnitCore test.SaveManagerTest



