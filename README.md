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

### Atteinte des objectifs

### Difficultés restant à résoudre

## Livrable 3

### Atteinte des objectifs

### Difficultés restant à résoudre

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

### Ce qui a été réalisé

### Difficultés rencontrées

### Objectifs pour la semaine

## Semaine 7

### Ce qui a été réalisé

### Difficultés rencontrées

### Objectifs pour la semaine

## Semaine 8

### Ce qui a été réalisé

### Difficultés rencontrées

### Objectifs pour la semaine

## Semaine 9

### Ce qui a été réalisé

### Difficultés rencontrées

### Objectifs pour la semaine

## Semaine 10

### Ce qui a été réalisé

### Difficultés rencontrées

### Objectifs pour la semaine

## Semaine 11

### Ce qui a été réalisé

### Difficultés rencontrées

### Objectifs pour la semaine

## Semaine 12

### Ce qui a été réalisé

### Difficultés rencontrées

### Objectifs pour finaliser le projet