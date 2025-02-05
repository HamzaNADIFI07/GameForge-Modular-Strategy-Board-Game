# Variables
JC = javac
JFLAGS = -g -source 11 -target 11
SRCDIR = src
BINDIR = classes
JARDIR = jar
MAINCLASS = Main
JARFILE = $(JARDIR)/PlateauGame.jar

# Recherche tous les fichiers source .java dans le répertoire src
SOURCES := $(shell find $(SRCDIR) -name '*.java')
# Définir les fichiers .class à partir des fichiers .java
CLASSES := $(SOURCES:$(SRCDIR)/%.java=$(BINDIR)/%.class)

# Cible par défaut, génère le fichier JAR
default: $(JARFILE)

# Compilation des fichiers Java en fichiers .class
$(BINDIR)/%.class: $(SRCDIR)/%.java
	@mkdir -p $(BINDIR)
	$(JC) $(JFLAGS) -d $(BINDIR) -cp $(SRCDIR) $<

# Création du fichier JAR
$(JARFILE): $(CLASSES)
	@mkdir -p $(JARDIR)
	jar cvfe $(JARFILE) $(MAINCLASS) -C $(BINDIR) .

# Exécution du JAR avec des arguments passés via make
run: $(JARFILE)
	@echo "Exécution du programme avec les arguments : $(ARGS)"
	java -jar $(JARFILE) $(ARGS)

# Nettoyage des fichiers générés
clean:
	rm -rf $(BINDIR) $(JARDIR)

# Supprimer uniquement les fichiers .class compilés
cls:
	rm -rf $(BINDIR)

# Générer la documentation Java
doc:
	@mkdir -p doc
	javadoc -d doc $(SOURCES)

# Récupérer les arguments x et y
ARGS := $(addprefix -D,$(patsubst x=%,x=%,$(wordlist 2, $(words $(MAKECMDGOALS)), $(MAKECMDGOALS)))))

.PHONY: clean cls doc run
