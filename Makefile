SRC = src
CLASS = classes
JAR_DEMETER = ./jar/demeter.jar
JAR_ARES = ./jar/ares.jar
MAIN_DEMETER = main.livrable4.Livrable4_Demeter
MAIN_ARES = main.livrable4.Livrable4_Ares
DOCS = docs
TEST_CLASS = test_classes
TEST_SRC = tests
JUNIT_JAR = lib/junit-platform-console-standalone-1.10.0.jar

SRC_FILES = $(shell find $(SRC) -name "*.java")
TEST_FILES = $(shell find $(TEST_SRC) -name "*.java")

all: cls demeter.jar ares.jar

doc:
	mkdir -p $(DOCS)
	javadoc -d $(DOCS) $(SRC_FILES)

cls:
	mkdir -p $(CLASS)
	javac -d $(CLASS) $(SRC_FILES)

demeter.jar: cls
	jar cfe $(JAR_DEMETER) $(MAIN_DEMETER) -C $(CLASS) .

ares.jar: cls
	jar cfe $(JAR_ARES) $(MAIN_ARES) -C $(CLASS) .

run_demeter:
	java -jar $(JAR_DEMETER)

run_ares:
	java -jar $(JAR_ARES)

test: compile_tests run_tests

compile_tests:
	mkdir -p $(TEST_CLASS)
	javac -cp "$(CLASS):$(JUNIT_JAR)" -d $(TEST_CLASS) $(TEST_FILES)

run_tests:
	java -jar $(JUNIT_JAR) --class-path "$(TEST_CLASS):$(CLASS)" --scan-classpath

clean:
	rm -rf $(CLASS) $(JAR_DEMETER) $(JAR_ARES) $(DOCS) $(TEST_CLASS)
