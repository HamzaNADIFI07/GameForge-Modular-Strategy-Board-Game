SRC = src
CLASS = classes
JAR_NAME = Livrable2.jar
MAIN_CLASS = game.Demeter.Livrable3demeter
DOCS = docs
TEST_CLASS = test_classes
TEST_SRC = tests
JUNIT_JAR = lib/junit-platform-console-standalone-1.10.0.jar

SRC_FILES = $(shell find $(SRC) -name "*.java")
TEST_FILES = $(shell find $(TEST_SRC) -name "*.java")

all: compile jar run_jar

javadoc:
	mkdir -p $(DOCS)
	javadoc -d $(DOCS) $(SRC_FILES)

compile:
	mkdir -p $(CLASS)
	javac -d $(CLASS) $(SRC_FILES)

jar: compile
	jar cfe $(JAR_NAME) $(MAIN_CLASS) -C $(CLASS) .

run_jar:
	java -jar $(JAR_NAME)

test: compile_tests run_tests

compile_tests:
	mkdir -p $(TEST_CLASS)
	javac -cp "$(CLASS):$(JUNIT_JAR)" -d $(TEST_CLASS) $(TEST_FILES)

run_tests:
	java -jar $(JUNIT_JAR) --class-path "$(TEST_CLASS):$(CLASS)" --scan-classpath

clean:
	rm -rf $(CLASS) $(JAR_NAME) $(DOCS) $(TEST_CLASS)
