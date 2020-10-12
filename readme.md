# Jeu de la Vie

### Aide à la réalisation du TP sur le jeu de la vie.

Le Jeu de la Vie (proposé par Conway 1970), contient dans une matrice se trouvent des cellules, actives ou inactives.

Le Jeu de la vie consiste à faire évoluer sur un grille un ensemble cellules selon les règles suivantes :

 - Si une cellule active est entourée de moins de 2 cellules :
    - elle manque de contact et se désactive.
 - Si une cellule active est entourée de plus de 3 cellules : 
    - elle est en milieu surpeuplé et se désactive.
 - Si une cellule inactive est entourée de 3 cellules, alors elle s’active.
 - Dans les autres cas, la cellule garde son état.

Le TP utilise la librairie [JavaFX](https://openjfx.io/). Il suffit de télécharger la librairie si vous ne la possédez pas déjà et de la joindre à votre projet sous votre IDE (de préférence IntelliJ).

Ces codes contiennent une solution à l'étape 1 du TP. 
  - La classe application/JeuDeLaVie.java est la classe principale qui contient la partie graphique.
  - Les classes modele/Matrice et modele/Cellule représente le modèle.

Vous trouverez dans la classe JeuDeLaVie.java deux lignes permettant de capter les événements souris et clavier : 
 - `scene.setOnKeyTyped(e->System.out.println(e));`
 - `scene.setOnMouseClicked(e-> System.out.println(e));`
 
 Ceci vous permettra de résoudre l'étape 2 du TP : 
  - 2. Interactivité : Ajouter des interactions :
    - l’appui sur ’p’ met en pause la simulation
    - l’appui sur ’d’ démarre la simulation
    - l’appui sur ’e’ efface tout
    - ’l’appui sur ’h’ active des cellules aléatoirement
    - un clic souris sur la zone de simulation active.desactive des cellules
    
 Egalement, dans la classe Cellule.java se trouve une variable `enTransition` ainsi que 4 couleurs qui permettent de résoudre l'étape 3 du TP : 
   - 3. Ralentissez la croissance : ajouter des étapes afin de voir l’évolution des cellules au ralenti :
    - les cellules actives sont en vert clair
    - les cellules qui se désactivent et seraient désactivés au top suivant sont en vert
    - les cellules qui se réactivent et seraient actives au top suivant sont en vert sombre
    - les cellules inactives sont en vert noir.
