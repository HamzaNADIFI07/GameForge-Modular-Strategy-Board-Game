SRC = src
CLASS = classes
JAR_DEMETER = LivrableDemeter.jar
JAR_ARES = LivrableAres.jar
MAIN_DEMETER = game.Demeter.Livrable3demeter
MAIN_ARES = game.Ares.Livrable3ares
DOCS = docs
TEST_CLASS = test_classes
TEST_SRC = tests
JUNIT_JAR = lib/junit-platform-console-standalone-1.10.0.jar

SRC_FILES = $(shell find $(SRC) -name "*.java")
TEST_FILES = $(shell find $(TEST_SRC) -name "*.java")

all: compile jar_demeter jar_ares

javadoc:
	mkdir -p $(DOCS)
	javadoc -d $(DOCS) $(SRC_FILES)

compile:
	mkdir -p $(CLASS)
	javac -d $(CLASS) $(SRC_FILES)

jar_demeter: compile
	jar cfe $(JAR_DEMETER) $(MAIN_DEMETER) -C $(CLASS) .

jar_ares: compile
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
