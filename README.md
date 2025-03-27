# l2s4-projet-2025

Vous devez *forker* ce projet dans votre espace de travail Gitlab (bouton `Fork`) et vidéo sur le [portail](https://www.fil.univ-lille.fr/portail/index.php?dipl=L&sem=S4&ue=Projet&label=Documents)
Un unique fork doit être réalisé par équipe.

Une fois cela réalisé, supprimer ces premières lignes et remplissez les noms des membres de votre équipe.
N'oubliez pas d'ajouter les autres membres de votre équipe aux membres du projet, ainsi que votre enseignant·e (statut Maintainer).

# Equipe

- Ahmed SYLLA
- Anas CHEBBI
- Hamza NADIFI

# Sujet

[Le sujet 2025](https://www.fil.univ-lille.fr/~varre/portail/l2s4-projet/sujet2025.pdf)

# Livrables

Les paragraphes concernant les livrables doivent être rempli avant la date de rendu du livrable. A chaque fois on décrira l'état du projet par rapport aux objectifs du livrable. Il est attendu un texte de plusieurs lignes qui explique la modélisation choisie, et/ou les algorithmes choisis et/ou les modifications apportées à la modélisation du livrable précédent.

Un lien vers une image de l'UML doit être fourni (une photo d'un diagramme UML fait à la main est suffisant).

## UML
https://lucid.app/lucidchart/7054f712-50b3-4e10-b6b1-dec0da30ec03/edit?viewport_loc=-11%2C-11%2C2219%2C1048%2C0_0&invitationId=inv_59b50eb4-21e7-436e-b32d-8b2cb42cb428

## Livrable 1
- Commande pour creer uniquement le Jar:
```bash
Make jar
```
- Commande pour exécuter  uniquement le Jar:
```bash
Make run_jar
```
- Commandes pour compiler et exécuter via le Jar(afficher le Plateau):
```bash
Make
```
- Commandes pour supprimer les fichier compilés et le Jar:
```bash
Make clean
```
### Atteinte des objectifs

Pour le premier livrable, nous avons travaillé sur la **modélisation du plateau de jeu** et la **gestion des tuiles** et des **ressources**.

Les objectifs atteints :

1. Structure du plateau :

- Création de la classe `Plateau` permettant de représenter le plateau de jeu sous la forme d'une grille de dimensions personnalisées à la creation du plateau.
- Mise en place d'une méthode d'initialisation du plateau où toutes les tuiles sont de type Mer par défaut.
- Ajout d'une méthode pour **générer aléatoirement les tuiles** du plateau tout en respectant les contraintes spécifiées dans le sujet :
    - Au moins 2/3 des tuiles doivent être de type `Mer`.
    - Les tuiles non Mer doivent être adjacentes à au moins une autre tuile non Mer.

2. Gestion des types de tuiles et des ressources:

- Création des classes spécifiques pour les différents types de tuiles : `Champ`, `Foret`, `Montagne`, `Paturage`, et `Mer`.
- Chaque type de tuile est associé à une ressource spécifique via une énumération `enumRessource`.

3. Affichage du plateau :

- Mise en place d'une méthode `display` dans la classe `Plateau` permettant un affichage visuel du plateau de jeu dans la console.
- Les tuiles sont représentées par leurs initiales (ou par les deux premières lettres pour éviter les ambiguïtés).

4. La classe **Main**:

- Création d'une classe `Main` pour tester l'initialisation, la génération des tuiles, et l'affichage du plateau.

5. Organisation et structure du projet :

- Organisation des fichiers sources dans des packages distincts (`plateau`, `tuile`, `type_tuile`,`ressource`,`batiment`).
- Mise en place d'un Makefile pour la compilation, l'exécution, et la génération d'un fichier `L2S4-Projet-2025.jar` exécutable.
- Implémentation des tests pour les méthodes des classes Plateau et Tuile, afin de valider leur bon fonctionnement et leur conformité avec les contraintes du sujet.

### Difficultés restant à résoudre

## Livrable 2

- Commande pour génerer la JavaDoc:

```bash
Make javadoc
```

- Commande pour creer uniquement le Jar:

```bash
Make jar
```

- Commande pour exécuter  uniquement le Jar:

```bash
Make run_jar
```

- Commandes pour compiler et exécuter via le Jar(afficher le Plateau):

```bash
Make
```

- Commandes pour compiler et exécuter les tests unitaires:

```bash
Make test
```

- Commandes pour supprimer les fichier compilés et le Jar et la JavaDoc:

```bash
Make clean
```

### Atteinte des objectifs

Pour le deuxième livrable, nous avons travaillé sur la **modélisation des batiments** 

Les objectifs atteints :

1. Modélisation des différents types de **Batiment**:

    - Une classe abstraite `Batiment`, qui représente une instance du **Batiment** et regroupe plusieurs attributs comme `type`, `dimension`et `tuile` et plusieurs méthodes comme `getType()`, `getDimension()` , et `getCout()`.

    - Une classe `Port`, `Ferme`, `Exploitation`, `Camp`, `Armee` , qui héritent de la class `Batiment` et qui contient un attribut `cout`, et une méthode `peutEtreConstruit`, et qui permet de vérifier si la tuile où on veut construire ce batiment respecte les conditions nécessaires.

2. Un programme principal (nommé `Livrable2.java`):

    - Ce programme principal permet de:
        - Créer un plateau aléatoire dont la taille **(largeur x hauteur)** est fournie en argument sur la ligne de commande et affiche sa représentation avec une condition du fait que le plateau sera de largueur minimale **10** et de hauteur minimale **10**.
        - Créer 5 batiments (`Port`,`Ferme`,`Exploitation`,`Camp`,`Armee`), tout en respectant les conditions de construction de chaque type de batiment.
        - Afficher le plateau de jeu dans le terminale grace à la méthode `display`
        - Afficher l'emplacement de chaque batiment installé.
        - Afficher le coût de construction de chaque batiment.
        - Afficher les ressources récoltées pour l'ensemble des tuiles possédant un bâtiment.
        - Afficher le plateau de jeu dans une fenêtre Swing.

3. Une class `PlateauSwing`:

    - Cette class nous a permet de :
        - Afficher le plateau de jeu sous forme graphique, en représentant chaque tuile par une couleur spécifique selon son type.
        - Afficher la première lettre du bâtiment placé sur chaque tuile contenant un batiment.

4. Tests unitaires:

    - Implémentation des tests pour les méthodes des classes `Batiment`, `Port`, `Ferme`, `Exploitation`, `Camp`, `Armee`, afin de valider leur bon fonctionnement et leur conformité avec les contraintes du sujet.

Résultats obtenus après éxecution de la commande `make test`:
```bash
╷
├─ JUnit Jupiter ✔
│  ├─ FermeTest ✔
│  │  ├─ testFermeCout() ✔
│  │  ├─ testForetCreation() ✔
│  │  └─ testFermePeutEtreConstruit() ✔
│  ├─ ArmeeTest ✔
│  │  ├─ testArmeeCout() ✔
│  │  └─ testArmeeCreation() ✔
│  ├─ PaturageTest ✔
│  │  └─ testPaturageConstructor() ✔
│  ├─ ChampTest ✔
│  │  └─ testChampConstructor() ✔
│  ├─ MerTest ✔
│  │  └─ testMerConstructor() ✔
│  ├─ CampTest ✔
│  │  ├─ testCampPeutEtreConstruit() ✔
│  │  └─ testCampCreation() ✔
│  ├─ PlateauTest ✔
│  │  ├─ testGenererTuiles() ✔
│  │  └─ testPlateauInitialiseAvecMer() ✔
│  ├─ TuileTest ✔
│  │  ├─ testGetAdjacents() ✔
│  │  ├─ testGetType() ✔
│  │  └─ testSetAdjacents() ✔
│  ├─ ExploitationTest ✔
│  │  ├─ testExploitationCout() ✔
│  │  └─ testExploitationCreation() ✔
│  ├─ BatimentTest ✔
│  │  ├─ testGetTuile() ✔
│  │  ├─ testGetCout() ✔
│  │  ├─ testGetDimension() ✔
│  │  └─ testSetDimension() ✔
│  ├─ MontagneTest ✔
│  │  └─ testMontagneConstructor() ✔
│  ├─ PortTest ✔
│  │  ├─ testPortCreation() ✔
│  │  ├─ testPortPeutEtreConstruit() ✔
│  │  └─ testPortCout() ✔
│  └─ ForetTest ✔
│     └─ testForetConstructor() ✔
├─ JUnit Vintage ✔
└─ JUnit Platform Suite ✔

Test run finished after 45 ms
[        16 containers found      ]
[         0 containers skipped    ]
[        16 containers started    ]
[         0 containers aborted    ]
[        16 containers successful ]
[         0 containers failed     ]
[        26 tests found           ]
[         0 tests skipped         ]
[        26 tests started         ]
[         0 tests aborted         ]
[        26 tests successful      ]
[         0 tests failed          ]
```
5. Organisation et structure du projet :

- Organisation des fichiers sources dans des packages distincts (`batiment`, `type_batiment`).
- Modification du Makefile pour la compilation et l'éxcution des tests, la géneration de la `javaDoc` et la génération d'un fichier `Livrable2.jar` exécutable.

Résultats obtenus après éxecution de la commande `make`:

```bash
hamzanadifi@MacBook-Pro-de-Hamza l2s4-projet-2025 % make
mkdir -p classes
javac -d classes src/plateau/Plateau.java src/ressource/Ressource.java src/batiment/type_batiment/Exploitation.java src/batiment/type_batiment/Port.java src/batiment/type_batiment/Camp.java src/batiment/type_batiment/Armee.java src/batiment/type_batiment/Ferme.java src/batiment/Batiment.java src/tuile/type_tuile/Montagne.java src/tuile/type_tuile/Champ.java src/tuile/type_tuile/Mer.java src/tuile/type_tuile/Paturage.java src/tuile/type_tuile/Foret.java src/tuile/Tuile.java src/main/PlateauSwing.java src/main/Main.java src/main/Livrable2.java
jar cfe Livrable2.jar main.Livrable2 -C classes .
java -jar Livrable2.jar
Entrez la largeur du plateau: 10
Entrez la hauteur du plateau: 10
      0     1     2     3     4     5     6     7     8     9  
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 0 | Me  | Me  | Me  | Me  | Me  |  F  |  F  |  C  | Me  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 1 | Mo  | Me  | Me  | Me  | Me  | Mo  | Me  |  C  | Me  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 2 |  C  | Me  | Me  | Me  | Me  |  F  |  P  | Me  | Me  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 3 | Me  | Me  | Me  | Me  | Mo  | Me  | Me  | Me  | Me  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 4 | Me  | Me  | Me  | Me  |  F  | Me  | Me  | Me  | Me  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 5 | Me  | Me  | Me  | Me  | Me  | Me  |  F  |  F  |  F  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 6 |  F  | Me  | Me  | Me  | Me  | Me  |  C  |  F  |  P  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 7 | Mo  | Me  | Me  | Me  | Me  | Me  | Me  |  F  |  F  |  C  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 8 | Me  | Me  | Me  | Me  | Me  | Me  | Me  |  P  |  P  |  P  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 9 | Me  | Me  | Me  | Me  | Me  | Me  | Me  |  C  | Me  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
Port placé sur M(0, 1)
Ferme placée sur C(0, 2)
Armée placée sur F(0, 6) avec 5 guerriers
Camp placé sur M(0, 7)
Exploitation placée sur P(6, 2)

Coût des bâtiments :
Port: {Moutons=2, Bois=1}
Ferme: {Bois=1, Minerai=1}
Exploitation: {Moutons=1, Bois=2, Ble=1}
Armée: {Moutons=1, Bois=1, Ble=1}
Camp: {Bois=2, Minerai=3}

Ressources récoltées par les bâtiments placés :
Tuile (0, 1) produit : 1 Minerai
Tuile (0, 2) produit : 1 Ble
Tuile (0, 6) produit : 1 Bois
Tuile (0, 7) produit : 2 Minerai
Tuile (6, 2) produit : 2 Moutons
```
Fenêtre Swing affichée:

![fenêtreSwing10x10](./images/Livrable2-fenêtreSwing10x10.png)

### Difficultés restant à résoudre

## Livrable 3

- Commande pour génerer la JavaDoc:

```bash
Make javadoc
```

- Commande pour compiler tous les fichiers Java situés dans le dossier src:

```bash
make compile	
```

- Génère le fichier JAR nommé LivrableDemeter.jar exécutable pour la classe Livrable3Demeter:

```bash
make jar_demeter	
```

- Génère le fichier JAR nommé LivrableAres.jar exécutable pour la classe Livrable3Ares:

```bash
make jar_ares
```

- Commande pour exécuter  uniquement le Jar nommé LivrableDemeter.jar:

```bash
make run_demeter
```

- Commande pour exécuter  uniquement le Jar nommé LivrableAres.jar:

```bash
make run_ares
```

- Commandes pour compiler et génèrer les deux JARs (LivrableDemeter.jar et LivrableAres.jar):

```bash
Make
```

- Commandes pour compiler et exécuter les tests unitaires:

```bash
Make test
```

- Commandes pour supprimer les fichier compilés et le Jar et la JavaDoc:

```bash
Make clean
```

### Atteinte des objectifs

Pour le troixième livrable, nous avons travaillé sur la **modélisation des actions** 

Les objectifs atteints :

1. Modélisation des différentes **Actions**:

  - Implémentation d'une classe abstraite `Game`, et qui permet de modéliser les méthodes communes entre les deux jeux **Demeter** et **Ares** est des attributs commme `currentPlayer` qui permet de stocker l'information du joueur qui doit jouer (On en aura besoin dans le livrable 4 pour la gestion des tours), `players` la liste des joueurs qui vont jouer pendant cette partie, `plateau` l'instance du plateau de jeu et qui se crée directement avec la création du jeu avec en paramètre les coordonnées **x** et **y** qu'on aura obtenu au début du jeu avec la fonctionnalité **scanner**, `isGameActive`ce boolean permet le stocker l'information de l'état du jeu dont aura besoin dans le livrable 4 pour définir les règles de fin de jeu.

  - Implémentation de deux classe `Demeter` et `Ares` et qui héritent tout les deux de la classe `Game`, chacune de ces deux classes contient un attribut `action` et qui est de type `Action_Demeter` pour la classe `Demeter` et `Action_Ares` pour la classe `Ares`.
  Ce choix de définir deux classes distincts `Demeter` et `Ares`, est dû au fait qu'on voudrais limiter l'accès au diffèrentes action pour que dans le jeu Demeter, on aura pas l'accès au action de Ares et vice-versa, ainsi qu'on y en aura besoin lorsqu'on aura à définir des règles de début ou fin du jeu.

  - Implémentation de deux classe `Action_Demeter` et `Action_Ares` et qui permettent de modéliser les differentes actions nécessaires pour le déroulement du jeu.

  - Implémentation d'une classe `Player`, qui représente l'instance d'un joueur, avec plusieurs attributs qui stockent les informations dont aura besoins pour vérifier les conditions d'execution d'action, comme `name` qui permettera un affichage intuitif de la trace de l'évolution du jeu, `ressource` qui permet de stocker dans une hashmap les ressources dans le stock du joueurs avec leur quantité et cette attribut nous servira pour vérifier les conditions de présence de ressources nécessaires pour effectuer l'action en question ainsi que des méthodes getters et setters pour modifier ces quantités de ressource après l'éxecution de l'action, et d'autres attributs aussi nécessaires pour le déroulement du jeu.

2. Deux programme principal (nommé `Livrable3Demeter.java` et `Livrable3Ares.java`):

  - Le premier programme principal `Livrable3Demeter.java` permet de:

    - Construit une ferme
    - Fait évoluer une ferme en une exploitation
    - Construit un port
    - Échange 3 ressources contre une
    - Échange 2 ressources contre une grâce à son port
    - Achète un voleur

  - Le deuxième programme principal `Livrable3Ares.java` permet de:

    - construit une armée avec 1 guerrier
    - ajoute des guerriers à son armée pour arriver à 5
    - fait évoluer son armée en un camp
    - achète 5 guerriers
    - construit un port
    - échange 3 ressources contre une
    - achète une arme secrète

  - Et dans ces deux cas, nous avons rajouter l'option d'intercation avec l'utilisateur avec la fonctionnalité **scanner** qui permet une interaction écrite via le terminale avec une gestion d'erreurs de type de réponses saisie ainsi qu'au erreurs liée au choix non proposés.

  - Et enfin dans les deux cas , on a affiché à chaque fois les ressources du joueur, y compris après la dernière action, avec un affichage du plateau via le terminale au début du scénario du livrable et un deuxième affichage du plateau de jeu sous forme graphique à la fin du scénario.

3. Tests unitaires:

    - Implémentation des tests pour les méthodes des classes `Player`, `Action_Ares`, `Action_Demeter` afin de valider leur bon fonctionnement et leur conformité avec les contraintes du sujet.

Résultats obtenus après éxecution de la commande `make test`:

```bash
╷
├─ JUnit Jupiter ✔
│  ├─ FermeTest ✔
│  │  ├─ testFermeCout() ✔
│  │  └─ testForetCreation() ✔
│  ├─ ArmeeTest ✔
│  │  ├─ testArmeeCout() ✔
│  │  └─ testArmeeCreation() ✔
│  ├─ PaturageTest ✔
│  │  └─ testPaturageConstructor() ✔
│  ├─ ChampTest ✔
│  │  └─ testChampConstructor() ✔
│  ├─ MerTest ✔
│  │  └─ testMerConstructor() ✔
│  ├─ Livrable3demeterTest ✔
│  │  └─ testDemeterMainSequence() ✘ expected: <true> but was: <false>
│  ├─ CampTest ✔
│  │  ├─ testCampPeutEtreConstruit() ✔
│  │  └─ testCampCreation() ✔
│  ├─ PlayerTest ✔
│  │  ├─ testHasResources() ✔
│  │  ├─ testAddWarriors() ✔
│  │  ├─ testUseResources() ✔
│  │  ├─ testHasPort() ✘ Cannot invoke "tuile.Tuile.setBatiment(batiment.Batiment)" because "<parameter3>" is null
│  │  └─ testInitialResources() ✔
│  ├─ PlateauTest ✔
│  │  ├─ testGenererTuiles() ✘ Le nombre de tuiles Mer doit être d'au moins 2/3 du nombre total de tuiles. ==> expected: <true> but was: <false>
│  │  └─ testPlateauInitialiseAvecMer() ✘ Tous les éléments du plateau doivent être des tuiles de type Mer au début. ==> expected: <true> but was: <false>
│  ├─ InteractiveListChooserTest ✔
│  │  ├─ testEmptyInputReturnsRandom() ✔
│  │  ├─ testEmptyListThrowsException() ✔
│  │  └─ testValidChoice() ✔
│  ├─ Livrable3demeterTest ✔
│  │  └─ testDemeterMainSequence() ✘ expected: <true> but was: <false>
│  ├─ Action_DemeterTest ✔
│  │  ├─ testConstruireExploitation() ✘ Cannot invoke "game.Player.hasResources(ressource.Ressource, int)" because "<local4>" is null
│  │  ├─ testConstruirePort() ✘ Cannot invoke "game.Player.hasResources(ressource.Ressource, int)" because "<local4>" is null
│  │  └─ testConstruireFerme() ✘ Cannot invoke "game.Player.hasResources(ressource.Ressource, int)" because "<local4>" is null
│  ├─ TuileTest ✔
│  │  ├─ testGetAdjacents() ✔
│  │  ├─ testGetType() ✔
│  │  └─ testSetAdjacents() ✔
│  ├─ Livrable3AresTest ✔
│  │  └─ testScenarioCompletAres() ✘ Cannot invoke "batiment.type_batiment.Armee.getNbGuerriers()" because "<local6>" is null
│  ├─ ExploitationTest ✔
│  │  ├─ testExploitationCout() ✔
│  │  └─ testExploitationCreation() ✔
│  ├─ BatimentTest ✔
│  │  ├─ testGetTuile() ✔
│  │  ├─ testGetCout() ✔
│  │  ├─ testGetDimension() ✔
│  │  └─ testSetDimension() ✔
│  ├─ Action_DemeterTest ✔
│  │  ├─ testConstruireExploitation() ✘ Cannot invoke "game.Player.hasResources(ressource.Ressource, int)" because "<local4>" is null
│  │  ├─ testConstruirePort() ✘ Cannot invoke "game.Player.hasResources(ressource.Ressource, int)" because "<local4>" is null
│  │  └─ testConstruireFerme() ✘ Cannot invoke "game.Player.hasResources(ressource.Ressource, int)" because "<local4>" is null
│  ├─ MontagneTest ✔
│  │  └─ testMontagneConstructor() ✔
│  ├─ PortTest ✔
│  │  ├─ testPortCreation() ✔
│  │  ├─ testPortPeutEtreConstruit() ✔
│  │  └─ testPortCout() ✔
│  └─ ForetTest ✔
│     └─ testForetConstructor() ✔
├─ JUnit Vintage ✔
└─ JUnit Platform Suite ✔
Test run finished after 95 ms
[        23 containers found      ]
[         0 containers skipped    ]
[        23 containers started    ]
[         0 containers aborted    ]
[        23 containers successful ]
[         0 containers failed     ]
[        42 tests found           ]
[         0 tests skipped         ]
[        42 tests started         ]
[         0 tests aborted         ]
[        30 tests successful      ]
[        12 tests failed          ]
```

4. Organisation et structure du projet :

- Organisation des fichiers sources dans des packages distincts (`game`, `ares`, `demeter`).
- Modification du Makefile pour la compilation et l'éxcution des tests, la géneration de la `javaDoc` et la génération de deux fichier exécutable `Livrable3Demeter.jar` et `Livrable3Ares.jar`.

Résultats obtenus après éxecution de la commande `make run_demeter `:

```bash
Entrez la largeur du plateau: 10


Entrez la hauteur du plateau: 10
 -----------------
----- DEMETER -----
 -----------------


      0     1     2     3     4     5     6     7     8     9  
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 0 | Mo  |  F  |  C  |  P  | Me  | Me  | Me  | Me  |  F  |  P  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 1 | Me  | Me  | Me  | Me  | Me  |  F  | Me  |  F  | Me  |  P  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 2 | Me  | Me  | Me  | Me  | Me  |  F  | Me  | Mo  | Me  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 3 | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 4 | Me  | Me  | Mo  | Me  | Me  | Me  | Me  | Me  | Me  |  P  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 5 |  F  | Mo  |  F  | Me  | Me  | Me  | Mo  |  F  |  F  |  P  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 6 | Me  | Me  | Me  | Me  | Me  | Me  | Mo  | Me  | Me  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 7 | Me  | Me  | Me  | Me  | Me  | Me  |  P  | Me  | Me  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 8 | Me  | Me  | Mo  | Me  | Me  |  C  | Mo  | Me  | Me  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 9 | Me  | Mo  |  C  | Me  | Me  | Me  | Me  | Me  | Me  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
----> Leon [ {Minerai=10, Moutons=10, Ble=10, Bois=10} ] veut construire une ferme.

Où installer une ferme ?
Entrez la coordonnée X: 2

Entrez la la coordonnée Y: 9
Leon{Minerai=9, Moutons=10, Ble=10, Bois=9} a construit une ferme sur C( 2 , 9 )


----> Leon [ {Minerai=9, Moutons=10, Ble=10, Bois=9} ] veut remplacer une ferme par une exploitation.

quelle ferme transformer en exploitation ?

1: [1: Ferme sur C( 2 , 9 )]

Quelle ferme transformer en exploitation ? 1
Leon{Minerai=9, Moutons=9, Ble=9, Bois=7} a construit une exploitation sur C( 2 , 9 )


----> Leon [ {Minerai=9, Moutons=9, Ble=9, Bois=7} ] veut construire un port.

Où installer le port ?

Entrez la coordonnée X: 7

Entrez la la coordonnée Y: 5

Leon{Minerai=9, Moutons=7, Ble=9, Bois=6} a construit un port sur F( 7 , 5 )


----> Leon [ {Minerai=9, Moutons=7, Ble=9, Bois=6} ] veut échanger des ressources sans se servir du port.

Ressources disponibles: {Minerai=9, Moutons=7, Ble=9, Bois=6}

Choisit une ressource à échanger: 
1: Moutons
2: Minerai
3: Blé
4: Bois


Leon{Minerai=10, Moutons=7, Ble=6, Bois=6} a échangé 3 Ble contre 1 Minerai

Ressources de Leon: {Minerai=10, Moutons=7, Ble=6, Bois=6}


----> Leon [ {Minerai=10, Moutons=7, Ble=6, Bois=6} ] veut échanger des ressources grâce à son port.

Ressources disponibles: {Minerai=10, Moutons=7, Ble=6, Bois=6}

Choisit une ressource à échanger: 
1: Moutons
2: Minerai
3: Blé
4: Bois

Leon{Minerai=10, Moutons=7, Ble=6, Bois=5} a échangé 2 Bois contre 1 Bois

Ressources de Leon: {Minerai=10, Moutons=7, Ble=6, Bois=5}


----> Leon [ {Minerai=10, Moutons=7, Ble=6, Bois=5} ] veut acheter un voleur.

Leon{Minerai=9, Moutons=7, Ble=5, Bois=4} dispose maintenant d'une arme secrète.


----> Leon [ {Minerai=9, Moutons=7, Ble=5, Bois=4} ].
{Minerai=9, Moutons=7, Ble=5, Bois=4}


----> liste des bâtiments en sa possession
[1: Ferme sur C( 2 , 9 ), 2: Port sur F( 7 , 5 )]


----> liste des tuiles occupées
[C( 2 , 9 ), F( 7 , 5 )]
```

Fenêtre Swing affichée:

![fenêtreSwing10x10](./images/Livrable3Demeter-fenêtreSwing10x10.png)

Résultats obtenus après éxecution de la commande `make run_ares `:

```bash
Entrez la largeur du plateau: 10
Entrez la hauteur du plateau: 10
 ----------------- 
-----   ARES  -----
 ----------------- 
      0     1     2     3     4     5     6     7     8     9  
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 0 | Me  |  C  |  P  | Me  | Me  | Me  | Me  | Me  | Me  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 1 |  C  |  C  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 2 | Me  | Me  |  F  | Me  | Me  | Me  | Me  | Me  | Me  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 3 |  C  |  F  |  F  | Me  | Me  | Me  | Me  | Me  | Me  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 4 | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 5 | Me  | Me  | Me  | Me  | Me  |  C  |  C  |  F  | Me  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 6 | Me  | Me  | Mo  | Me  | Me  | Me  | Mo  | Me  | Me  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 7 | Me  | Me  |  P  | Me  | Me  | Me  | Me  | Me  | Me  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 8 | Me  | Me  | Mo  | Me  | Mo  | Me  |  C  | Me  | Me  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 9 | Me  | Me  |  C  |  P  | Mo  |  C  | Mo  | Me  | Me  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+

----> Leon: {Minerai=10, Moutons=10, Ble=10, Bois=10} (30 warriors) veut construire une armée

Où installer une armée ?

Entrez la coordonnée X: 2

Entrez la la coordonnée Y: 9

Entrez le nombre de guerriers que vous voulez déployer 3

Leon{Minerai=10, Moutons=9, Ble=9, Bois=9} (27) a construit une armée sur C( 2 , 9 ) (3 warriors) en déployant 3 guérriers.


----> Leon: {Minerai=10, Moutons=9, Ble=9, Bois=9} (27 warriors) ajoute des guerriers à son armée pour arriver à 5

où déployer un guerrier ?

1: [1: Armee sur C( 2 , 9 ) (3 warriors)]

Indice de l'armée: 1

Leon{Minerai=10, Moutons=9, Ble=9, Bois=9} (26 warriors) a déployé 1 guérriers dans l'armée C( 2 , 9 ) (4 warriors)

où déployer un guerrier ?

1: [1: Armee sur C( 2 , 9 ) (4 warriors)]

Indice de l'armée: 1

Leon{Minerai=10, Moutons=9, Ble=9, Bois=9} (25 warriors) a déployé 1 guérriers dans l'armée C( 2 , 9 ) (5 warriors)


----> Leon: {Minerai=10, Moutons=9, Ble=9, Bois=9} (25 warriors) veut remplacer son armée par un camp

Quelle armée transformer en camp ?

1: [1: Armee sur C( 2 , 9 ) (5 warriors)]

Indice de l'armée: 1

Leon{Minerai=7, Moutons=9, Ble=9, Bois=7} (25) a construit un camp sur C( 2 , 9 ) (5 warriors)


----> Leon: {Minerai=7, Moutons=9, Ble=9, Bois=7} (25 warriors) achète 5 guerriers

Leon{Minerai=6, Moutons=7, Ble=7, Bois=7} (30 warriors) a acheté 5 guerriers


----> Leon: {Minerai=6, Moutons=7, Ble=7, Bois=7} (30 warriors) veut construire un port.

Où installer le port ?

Entrez la coordonnée X: 1

Entrez la la coordonnée Y: 0

Leon{Minerai=6, Moutons=5, Ble=7, Bois=6} a construit un port sur C( 1 , 0 )


----> Leon: {Minerai=6, Moutons=5, Ble=7, Bois=6} (30 warriors) échange des ressources.

Ressources disponibles: {Minerai=6, Moutons=5, Ble=7, Bois=6}

Choisit une ressource à échanger: 
1: Moutons
2: Minerai
3: Blé
4: Bois

Leon{Minerai=6, Moutons=5, Ble=7, Bois=4} a échangé 3 Bois contre 1 Bois

Ressources de Leon: {Minerai=6, Moutons=5, Ble=7, Bois=4}


----> Leon: {Minerai=6, Moutons=5, Ble=7, Bois=4} (30 warriors) achète une arme secrète.

Leon{Minerai=5, Moutons=5, Ble=7, Bois=3} (30 warriors) dispose maintenant d'une arme secrète

----> liste des bâtiments en sa possession

[1: Camp sur C( 2 , 9 ) (5 warriors), 2: Port sur C( 1 , 0 )]


----> liste des tuiles occupées

[C( 2 , 9 ) (5 warriors), C( 1 , 0 )]
```

Fenêtre Swing affichée:

![fenêtreSwing10x10](./images/Livrable3Ares-fenêtreSwing10x10.png)

discription de choix de modelisation :
Pour ce livrable, nous avons ajouté les classes Action_Demeter et Action_Ares afin de gérer les actions propres à chaque mode de jeu. On a choisi de séparer les logiques dans des classes différentes pour plus de clarté et pour respecter le principe de responsabilité unique. Le joueur interagit maintenant avec ces actions via des programmes principaux (Livrable3demeter et Livrable3ares) qui exécutent automatiquement une série d’actions demandées dans le sujet. Le code a été organisé en plusieurs packages (tuile, batiment, game...) pour faciliter la navigation. Le développement est bien avancé : toutes les fonctionnalités de base sont en place et les actions demandées dans le scénario sont fonctionnelles. On a aussi écrit des classes de tests pour valider certaines méthodes importantes

### Difficultés restant à résoudre

- Il y a encore des tests qui sont pas réussi.

- Des méthodes d'actions ont été implémenter dans la classe `Player`, doivent être migrer dans la classe `Action_Ares`.

## Livrable 4

### Atteinte des objectifs

### Difficultés restant à résoudre

# Journal de bord

Le journal de bord doit être rempli à la fin de chaque séance encadrée, et avant de quitter la salle. 

Pour chaque semaine on y trouvera :
- ce qui a été réalisé, les difficultés rencontrées et comment elles ont été surmontées (on attend du contenu, pas uniquement une phrase du type "tous les objectifs ont été atteints")
- la liste des objectifs à réaliser d'ici à la prochaine séance encadrée

## Semaine 1

### Ce qui a été réalisé
LePlateau ainsi que l'algorithme de création on été fait, une abstract class Tuile qui représente les tuiles ainsi que les types de tuile qui en héritent.
Une class Batiment ainsi qu'une class ressource ont été creer pour représenté les ressources et les batiments.
### Difficultés rencontrées
- Le display pour l'instant il marche et affiche bien le Plateau avec le type de chaque tuile mais après qu'on aura à afficher le nom du joueur dans la tuile ça va pas marché parce que y aura des décalages, donc à modifier après.

### Objectifs pour la semaine

- avancement sur l'uml
- création de la class Plateau
- création de la class Tuile
- création des class de Type de Tuile
- Implémentation de l'algorithme de création du plateau
## Semaine 2

### Ce qui a été réalisé
Après une réflexion sur le diagramme UML, nous avons conclu qu'il est nécessaire de créer
 une classe énumération (enum) pour représenter les différents types de ressources.
 Nous avons également modifié la classe Forêt afin qu'elle soit mieux compatible avec les autres classes

### Difficultés rencontrées
Pendant la séance, l'adaptation du reste du code du projet à cette classe d'énumération était floue, 
et le diagramme UML n'était pas à jour par rapport au reste du code
### Objectifs pour la semaine
Il s'agit de mettre à jour le diagramme UML, 
d'adapter la classe Ressource au reste du code, et d'intégrer efficacement la classe d'énumération
## Semaine 3

### Ce qui a été réalisé
Mise à jour du diagramme UML en tenant compte des modifications mise en place dans l'algorithme.
Reflexion sur la classe abstraite Batiment pour savoir s'il s'agit d'un heritage de tuile ou non ( cette reflexion sera peaufinée) dans le livrable 2.
Mise en place des methodes de test.

### Difficultés rencontrées

reflexion encore sur la representation de la classe 
abstrait Batiment 

### Objectifs pour la semaine
Mettre à jour le diagramme UML,
Créer les methodes de test

## Semaine 4

### Ce qui a été réalisé
-Capture d'écran de UML realise pour le livrable 1 et ajout dans le projet
-Reflexion sur comment générer le plateau avec des arguments entrés par l'utilisateur

### Difficultés rencontrées
- Plateau de taille standard, qui est problématique lorsque l'utilisateur voudra changer la taille pour des eventuels besoins.
-Ereur dans le test TestGenererTuile(de la classe plateau)
### Objectifs pour la semaine
- Reflexion sur la création des batiments pour les differents jeux
- Resolution des probèmes évoqués

## Semaine 5

### Ce qui a été réalisé
- Après avoir fait plusieurs modifications majeurs dans l'algorithme de création du plateau dans la classe `Plateau`, on choisit de revenir à l'ancienne approche qu'on avait avant en récupérant un ancienne commit contenant l'ancienne version de l'algorithme, on créer une nouvelle branche appelé `branche`, on a fusionner les deux branche `main` et `branche` en gardant que ce qui dans la branche `branche`.
- On a implémenter les deux classe `Exploitation` et `camp` héritant de `Batiment` avec :
    - Une méthode `getCout()` pour chacune des deux classes et permettant de récupérer le cout de constuction du batiment concerné.
    - Une méthode `peutEtreConstruit` pour chacune des deux classes et permettant de vérifier la contrainte du fait que une `exploitation`peut etre construite que dans une tuile contenant déjà une `Ferme` et un `camp` peut etre construite que dans une tuile contenant déjà une `Armee`.
### Difficultés rencontrées

### Objectifs pour la semaine

## Semaine 6
-Mettre à jour de UML
-Mettre à jour de l'algorithme tenant compte de l'ancien algorithme
-Créer du livrable 2 et des classe Exploitation, Armée, Camp
-Adaptater des classes Champ, Paturage, Foret, Montagne

### Ce qui a été réalisé
-mise à jour de UML
-mise à jopur de l'algorithme tenant compte de l'ancien algorithme
-création du livrable 2 et des classes Exploitation, Armée, Camp
-Adaptation des classes Champ, Patrurage, Foret, Montagne

### Difficultés rencontrées

### Objectifs pour la semaine
-créer une classe PlateauSwing
-Réaliser les methodes de test pour le livrable 2
-mettre à jour UML

## Semaine 7

### Ce qui a été réalisé
- Reflexions des deux approches differentes
- choix de l'une de nos approche en tenant compte de `Listchooser`
- Reflexion sur les differentes classes abstraites
- Reflexion sur des classes qui vont heriter de la classe abstraite Action
### Difficultés rencontrées
- choix d'une approche, car deux jeux differents
### Objectifs pour la semaine
- Création de la classe abstraite `Game`.
- Création de la classe `Ares`.
- Création de la classe `Demeter`.
- Création de la classe abstraite `Action`.
- Création des differentes classes représentant les actions des deux jeux et qui héritent de `Action`.
- Création de la classe `Player`.
- Réflexion sur l'implémentation des `Listchooser`.
- Réflexion sur l'adaptation des `Listechooser` avec les reste des classes des action (Limiter l'accès de chaque action dans le jeu associé).
- Mise à jour UMl
## Semaine 8

### Ce qui a été réalisé
- Création des classes livrable3ares, livrable3demeter et actionAres
- 

### Difficultés rencontrées

### Objectifs pour la semaine
- Mise à jour de l'UML
- Codage des classes livrable3ares, livrable3demeter et actionsdemeter
- Creation des classes de test


## Semaine 9


### Ce qui a été réalisé
- Création de la classe listchooser et implementation
- Reflexion sur livrable3ares
- avancement dans le code de livrable3ares et player

### Difficultés rencontrées
- comment implementer listchooser

### Objectifs pour la semaine

## Semaine 10

### Ce qui a été réalisé
- Avancement dans la methode echangeresources dans la classe actionares
- Distinction des deux approches d'échange( avec ou sans port)

### Difficultés rencontrées
- Implementation de la methode attachNeighbours

### Objectifs pour la semaine
- Finir le livrable3

## Semaine 11

### Ce qui a été réalisé
- resolution du conflit
- implementation des restes de methodes dans player et ActionAres
- avancement dans UML

### Difficultés rencontrées
- Test non exécutable(génération des erreurs)
- le merge de code pour resoudre le conflit a pris du temps
### Objectifs pour la semaine
- Terminer UML
- remplir le readme avec les choix de modelisation
- exécution et complilation des classes de test

## Semaine 12

### Ce qui a été réalisé

### Difficultés rencontrées

### Objectifs pour finaliser le projet