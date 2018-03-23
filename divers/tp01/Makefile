JAVAC=javac
JFLAGS=-g
RM=rm

all: Telegramme.class EcritDouble.class Troncature.class

Telegramme.class: Telegramme.java
	$(JAVAC) $(JFLAGS) $^

EcritDouble.class: EcritDouble.java
	$(JAVAC) $(JFLAGS) $^

Troncature.class: Troncature.java
	$(JAVAC) $(JFLAGS) $^

doc:
	javadoc *.java
	
clean:
	$(RM) *.class