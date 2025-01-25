# NOTE:

### **Hamza:** Le 10/01/2025:

Pour l'instant la méthode initialiserPlateau() fait son travail comme il faut, elle parcourt le plateau (Tableau 2D) et creer une instance de Tuile dans chaque case.

Et la méthode display aussi affiche bien le plateau avec les tailles passées en paramètres.

- **Rendu Pour 10*10:**
```bash
Plateau généré :
M M M M M M M M M M 
M M M M M M M M M M 
M M M M M M M M M M 
M M M M M M M M M M 
M M M M M M M M M M 
M M M M M M M M M M 
M M M M M M M M M M 
M M M M M M M M M M 
M M M M M M M M M M 
M M M M M M M M M M 
```

- **Rendu Pour 5*10:**

```bash
Plateau généré :
M M M M M 
M M M M M 
M M M M M 
M M M M M 
M M M M M 
M M M M M 
M M M M M 
M M M M M 
M M M M M 
M M M M M 
```
Après implémentation de la méthode genererTuiles(), l'affichage devient comme suit:

- **Premier rendu Pour 10*10:**
```bash
Plateau généré :
M M C F M M M M C M 
M C M M P M M M M M 
C M M M F P M M M M 
M M M M F M P M M M 
M M M F M M M M M M 
M M P M M M M M M M 
M F M F M M M M C P 
M M M M M M C P M M 
F M M P C M M C M M 
M F M M M C M M M M 
```
- **Deuxième rendu Pour 10*10: _(qui montre que la géneration des coordonnées et types de tuile non Mer se fait aléatoirement)_**
```bash
Plateau généré :
P M M M C M M M M C 
M P M P M M F M M F 
C P M M M C C M M M 
M M M M M M M M M C 
P M M M M M M M M M 
M M M M M M M M M C 
M C M M C M M M M M 
M M M M F F M M M P 
M C M M M M M M M M 
P M F M M P P M M M 
```

Il va falloir maintenant implémenter la deuxième contrainte de tout les tuiles non Mer doivent avoir en moins une tuile adjacente qui n’est
pas de type mer

- **Après modification du display le rendu pour 20*10 devient comme suit:**
```bash
Plateau généré :
      0     1     2     3     4     5     6     7     8     9    10    11    12    13    14    15    16    17    18    19  
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 0 |  M  |  M  |  M  |  M  |  M  |  M  |  M  |  M  |  M  |  M  |  M  |  P  |  M  |  P  |  M  |  M  |  M  |  M  |  M  |  M  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 1 |  M  |  M  |  M  |  M  |  M  |  M  |  M  |  C  |  C  |  M  |  M  |  M  |  P  |  M  |  M  |  P  |  M  |  M  |  M  |  C  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 2 |  C  |  M  |  M  |  M  |  M  |  P  |  M  |  M  |  M  |  M  |  M  |  M  |  M  |  P  |  F  |  M  |  M  |  M  |  M  |  M  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 3 |  M  |  P  |  M  |  M  |  M  |  M  |  M  |  P  |  M  |  C  |  M  |  M  |  C  |  C  |  P  |  M  |  M  |  M  |  M  |  M  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 4 |  M  |  M  |  M  |  M  |  C  |  M  |  P  |  P  |  P  |  M  |  C  |  M  |  M  |  M  |  M  |  C  |  M  |  M  |  M  |  M  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 5 |  M  |  M  |  M  |  F  |  M  |  C  |  M  |  M  |  M  |  M  |  M  |  M  |  C  |  C  |  M  |  M  |  M  |  M  |  P  |  M  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 6 |  M  |  M  |  P  |  M  |  M  |  M  |  F  |  M  |  M  |  M  |  M  |  M  |  M  |  M  |  M  |  M  |  M  |  M  |  M  |  C  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 7 |  M  |  M  |  M  |  M  |  M  |  P  |  M  |  M  |  F  |  P  |  C  |  M  |  M  |  M  |  M  |  M  |  M  |  M  |  M  |  M  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 8 |  P  |  M  |  M  |  C  |  F  |  M  |  M  |  M  |  M  |  F  |  M  |  M  |  M  |  M  |  M  |  C  |  M  |  P  |  M  |  F  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 9 |  M  |  P  |  M  |  P  |  C  |  M  |  F  |  F  |  M  |  M  |  M  |  C  |  M  |  M  |  M  |  M  |  M  |  C  |  M  |  M  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
```

- **Dernière mis à jour du display le rendu pour 20*10 devient comme suit:**

```bash
Plateau généré :
      0     1     2     3     4     5     6     7     8     9    10    11    12    13    14    15    16    17    18    19  
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 0 | Me  | Me  | Me  | Me  |  P  | Me  | Me  | Me  | Me  |  F  |  C  | Me  | Me  | Me  | Me  |  F  | Me  | Me  | Me  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 1 |  C  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  |  C  | Me  | Me  | Me  |  C  | Me  | Me  | Me  |  C  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 2 | Me  | Me  | Me  | Me  | Mo  | Me  | Me  | Me  | Mo  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  |  C  | Me  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 3 | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  |  P  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 4 | Me  | Me  |  C  | Me  | Me  |  P  | Me  | Mo  | Me  |  C  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  |  F  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 5 | Me  | Me  |  C  | Me  | Me  | Me  |  P  | Me  |  C  | Me  | Mo  | Me  | Me  |  F  |  C  | Me  | Me  | Me  |  F  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 6 |  F  | Me  | Me  | Me  |  C  |  F  | Me  | Me  | Me  | Me  |  F  | Me  | Me  | Mo  |  F  | Mo  | Me  |  P  |  C  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 7 | Me  |  P  |  P  | Me  | Me  | Mo  | Mo  |  F  | Me  |  C  | Me  |  C  |  F  |  P  | Me  |  P  |  C  | Mo  | Mo  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 8 | Mo  |  C  |  C  | Me  |  C  | Me  | Me  | Mo  | Me  | Me  | Me  | Me  | Mo  |  C  |  P  | Mo  |  C  | Mo  | Me  | Mo  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 9 | Me  | Me  | Me  |  C  | Me  | Me  | Me  | Me  |  P  | Me  | Me  |  P  |  P  |  C  |  F  | Me  | Mo  |  F  | Me  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
```

### **Hamza** Le 14/01/2024
L'implémentation de l'algorithme de création du Plateau avec les contrainte de proportion 1/3 - 2/3 ainsi que la contrainte d'adjacence est terminée.

- **Après dernière mis à jour le rendu pour 20*10 devient comme suit:**
```bash
      0     1     2     3     4     5     6     7     8     9    10    11    12    13    14    15    16    17    18    19  
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 0 | Me  |  F  |  C  |  F  | Mo  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Mo  | Me  |  P  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 1 | Me  |  P  | Me  | Me  | Mo  |  C  |  F  |  C  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  |  P  | Mo  | Me  |  F  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 2 | Me  |  F  | Me  | Me  | Me  | Me  | Me  | Mo  |  F  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 3 | Me  | Mo  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Mo  |  P  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 4 | Me  | Me  |  F  |  C  |  P  | Me  | Me  | Me  | Me  | Me  |  F  | Me  |  P  | Me  | Me  | Me  | Me  | Me  | Me  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 5 | Me  | Me  | Me  | Me  |  C  | Me  |  F  | Me  |  P  | Mo  |  P  | Me  |  C  | Me  | Me  | Mo  |  C  | Me  | Me  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 6 | Me  | Me  | Me  |  P  |  P  | Me  |  P  |  F  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Mo  |  C  | Me  | Me  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 7 | Me  | Me  | Me  | Me  | Me  | Me  | Me  |  C  | Mo  | Me  | Mo  | Me  | Me  | Me  |  P  | Me  | Me  | Me  | Me  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 8 | Me  |  P  |  P  | Me  | Me  | Me  | Me  |  C  | Me  |  F  |  C  | Me  | Me  | Me  |  C  | Me  | Me  | Me  | Me  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 9 | Me  |  P  | Me  |  F  |  C  |  C  | Me  | Me  | Me  | Me  | Mo  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
   ```

- **Rendu Pour 10*10:**
```bash
Plateau généré :
      0     1     2     3     4     5     6     7     8     9  
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 0 | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 1 | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 2 | Me  | Me  | Me  |  C  |  P  |  P  | Mo  | Me  | Me  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 3 |  C  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 4 | Mo  | Me  | Me  | Me  | Mo  |  P  |  C  |  F  | Me  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 5 | Me  | Me  |  P  |  P  | Me  | Me  |  P  | Me  | Me  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 6 | Me  | Me  |  F  |  P  | Mo  | Me  | Me  |  P  |  C  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 7 | Me  | Me  | Me  | Mo  | Me  |  F  | Me  | Me  | Mo  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 8 |  F  |  P  | Me  | Me  |  P  |  P  | Me  | Me  | Mo  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 9 | Me  | Mo  | Me  | Me  | Me  |  F  | Me  | Me  | Me  | Me  |
   +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
```
On peut constater sur les rendus qu'on a aucune tuile non Mer toute seul et que le nombre de tuiles non Mer et toujours inférieur ou égale 1/3 du nombres totale des tuiles.

### **Hamza** Le 20/01/2024
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
### **Hamza** Le 25/01/2024

En pensant à la modélisation des batiments, je pense qu'on a deux manière pour modéliser les camps et les exploitations, soit on mets camp et exploitation comme attribut boolean initialisé à False à la class armées et ferme et on les met à jour à True dès que le joueur le souhaite en verifiant les conditions nécessaires pour creer un camp et une exploitaion.

Soit on crée une class Camp et Exploitation dès que le joueur souhaite creer un Camp ou une Exploitation on cree une instance de l'objet souhaité et on le remplace à la place de l'instance de armée ou ferme.

