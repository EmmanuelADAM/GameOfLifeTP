#Jeu de la Vie

aide à la réalisation du TP sur le jeu de la vie.

Le Jeu de la Vie (proposé par Conway 1970), contient dans une matrice se trouvent des cellules, actives ou inactives.

Le Jeu de la vie consiste à faire évoluer sur un grille un ensemble cellules selon les règles suivantes :

 - Si une cellule active est entourée de moins de 2 cellules :
    - elle manque de contact et se désactive.
 - Si une cellule active est entourée de plus de 3 cellules : 
    - elle est en milieu surpeuplé et se désactive.
 - Si une cellule inactive est entourée de 3 cellules, alors elle s’active.
 - Dans les autres cas, la cellule garde son état.

Le TP utilise la librairie [JavaFX](https://openjfx.io/).

Ces codes contiennent une solution à l'étape 1 du TP. 
  - La classe application/JeuDeLaVie.java est la classe principale qui contient la partie graphique.
  - Les classes modele/Matrice et modele/Cellule représente le modèle.
