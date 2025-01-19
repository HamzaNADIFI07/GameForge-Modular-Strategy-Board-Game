SRC = src
CLASS = classes
JAR_NAME = L2S4-Projet-2025.jar
MAIN_CLASS = Main

SRC_FILES = $(shell find $(SRC) -name "*.java")

all: compile jar run_jar

compile:
	mkdir -p $(CLASS)
	javac -d $(CLASS) $(SRC_FILES)

jar: compile
	jar cfe $(JAR_NAME) $(MAIN_CLASS) -C $(CLASS) .

run_jar:
	java -jar $(JAR_NAME)

clean:
	rm -rf $(CLASS) $(JAR_NAME)
