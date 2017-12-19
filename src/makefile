NAME = Projet
CC = javac
CFLAGS = 
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

.PHONY : all, clean, fclean, doc, clean_doc, re

#all : $(BIN) $(TMP) $(BIN)/$(NAME)

#$(BIN)/$(NAME): $(addprefix $(TMP)/, $(OBJECT)) $(TMP)/Main.o
#	@$(CC) $(CFLAGS) $^ -o $@ -I $(INCLUDES)/
#	@echo "compilation effectuée"

#lib : $(TMP) $(LIB)
all : grammaire $(BIN) $(addprefix $(BIN)/$(SRC)/, $(OBJECT)) $(addprefix $(BIN)/$(SRC)/$(RES)/, $(OBJECT_RESULTS)) $(addprefix $(BIN)/$(SRC)/$(FNC)/, $(OBJECT_METHODS)) $(BIN)/Main.class

$(BIN)/$(SRC)/%.class:$(SRC)/%.java
	@echo "compilation du fichier $^"
	@$(CC) -d $(BIN) $^

$(BIN)/$(SRC)/$(RES)/%.class:$(SRC)/$(RES)/%.java 
	@echo "compilation du fichier $^"
	@$(CC) -d $(BIN)/ $^


$(BIN)/$(SRC)/$(FNC)/%.class:$(SRC)/$(FNC)/%.java
	@echo "compilation du fichier $^"
	@$(CC) -d $(BIN)/ $^

$(BIN)/Main.class:Main.java
	@echo "compilation du fichier $^"
	@$(CC) -d $(BIN)/ $^

$(DOC):
	@echo "création du répertoire $(DOC)/"
	@mkdir $(DOC)/
#$(BIN):
#	@echo "création du répertoire $(BIN)/"
#	@mkdir $(BIN)/

$(BIN):
	@echo "creation du répertoire $(BIN) et de ses sous répertoires"
	@mkdir $(BIN)/

grammaire:
	byaccj -J -Jclass=Parser -Jpackage=prog $(SRC)/grammaire/grammaire.y
	mv Parser.java $(SRC)/.
	rm -f ParserVal.java
	sed -i "s/package prog;/package prog;\nimport java.util.List;\nimport prog.methods.Fonction;\nimport prog.results.Resultat;/g" $(SRC)/ParserVal.java
	byaccj -J -Jclass=ParserExtract -Jpackage=prog $(SRC)/grammaire/grammaireExtractRef.y
	mv ParserExtract.java $(SRC)/.
	rm -f ParserExtractVal.java
	sed -i 's/ParserExtractVal/ParserVal/g' $(SRC)/ParserExtract.java
	jflex -d $(SRC) $(SRC)/grammaire/grammaireExtractRef.flex
#	sed -i 's/Yylex/YyExtractRef/g' $(SRC)/YyExtractRef.java
	jflex -d $(SRC) $(SRC)/grammaire/grammaire.flex




clean :
	@echo "suppression du répertoire $(BIN)/"
	@/bin/rm -rf $(BIN)

fclean : clean
	@echo "suppression des fichier Yylex.java, YyExtractRef.java, Parser.java et ParserExtract.java"
	@/bin/rm -f $(SRC)/Yylex.java
	@/bin/rm -f $(SRC)/YyExtractRef.java
	@/bin/rm -f $(SRC)/Parser.java
	@/bin/rm -f $(SRC)/ParserExtract.java
#	@echo "suppression de la lib $(LIB)"
#	@/bin/rm -f $(LIB)
#	@echo "suppression du répertoire $(BIN)/"
#	@/bin/rm -rf $(BIN)

doc : $(DOC)
	@echo "génération de la doc"
	@doxygen Doxyfile
	@echo "doc généré"

clean_doc :
	@echo "suppression du répertoire $(DOC)"
	@/bin/rm -rf $(DOC)

re : fclean all

.PHONY:archive
archive : fclean clean_doc
	@/bin/rm -rf $(ARCHIVE)
	@mkdir $(ARCHIVE)
	@rsync -r --exclude=$(ARCHIVE) --exclude=$(ARCHIVE)$(EXTENSION) * $(ARCHIVE)/
	zip -r $(ARCHIVE)$(EXTENSION) $(ARCHIVE)
	@/bin/rm -rf $(ARCHIVE)
