# TP Java n<sup>o</sup> 2

## Les principes du concept d'objet - Amélioration de la calculette (2)

### Objectif
Mettre en oeuvre les notions d'**encapsulation**, de **communication** entre objets et d''**héritage** par amélioration de la calculette.

## Pré-requis
Chapitre - Les principes du concept d'objet

### Travail demandé
**La Calculette Syntaxique (2)**  
On se propose de reprendre la calculette du TP précédent en dégageant la notion d'opération et plus particulièrement d'opération mathématique. Nous souhaitons réaliser une classe `Calculette` utilisant une classe `OperationMathematique` chargée de la gestion des opérations, en particulier de leur analyse. La superclasse `Operation` est, pour sa part, chargée du stockage des opérations, qu'elles soient mathématiques ou non. En utilisant le diagramme de classes suivant, ainsi que de la documentation générée pour les classes `Operation`, `OperationMathematique` et `Calculette`, réaliser une calculette fonctionnellement identique à celle du TP précédent.

<figure class="center">![Diagramme de classes](_2_classes.png)

<figcaption class="small">Fig 2.1 : Diagramme de classes de la Calculette</figcaption>

</figure>

### Conditions
*   JDK 1.5
*   Système d'exploitation GNU/Linux ou Ms-Windows
*   L'outil de modélisation/génération de code : [ArgoUML](http://argouml-fr.tigris.org/)
*   Le fichier `Lecture.class` permettant la lecture clavier et sa documentation. Les fichiers `Operation.class`, `OperationMathematique.class`, `Calculette.class` et leurs documentations respectives, ainsi que le fichier de test `Essai.class` [[tp_02.zip](_data/teaching/programmation/java/tpjava/tp_02.zip)]

### Critères d'évaluation
*   Qualité et organisation des documents rendus (codes sources, fichier LISEZMOI, etc.)
*   Autonomie
