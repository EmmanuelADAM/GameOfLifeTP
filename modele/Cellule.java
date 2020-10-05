package modele;

import application.JeuDeLaVie;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

/**
 * cette classe represente une cellule du jeu de la Vie
 * si la cellule est entouree du bon nombre de cellules alors elle vit,
 * sinon, en cas de sous population ou de sur population, elle meurt...
 *
 * @author Emmanuel Adam
 */
public class Cellule {
    /**
     * (facultatif) seuil a partir duquel la cellule meurt de sous population
     */
    static final int sousPopulation = 1;
    /**
     * (facultatif) seuil a partir duquel la cellule meurt de sur population
     */
    static final int surPopulation = 4;
    /**
     * (facultatif) seuil minimum a partir duquel la cellule vit
     */
    static final int minPopulationRegeneratrice = 3;
    /**
     * (facultatif) seuil maximum a partir duquel la cellule vit
     */
    static final int maxPopulationRegeneratrice = 3;
    // des couleurs
    static final public Color coulVersActive = Color.color(0.3, 0.3, 0.3);
    static final public Color coulActive = Color.color(1, 1, 1);
    static final public Color coulVersDesactive = Color.color(0.6, 0.6, 0.6);
    static final public Color coulDesactive = Color.color(0.1, 0, 0);

    /**
     * nature de la cellule
     */
    boolean etatPrecedent;
    /**
     * nature de la cellule
     */
    boolean vivante;
    /** nature de la cellule*/
    boolean etatSuivant;
    /**en transition, utilisee lorsque l'on veut utiliser les 4 couleurs de la cellule et non seulement les 2 etats binaires active, desactive*/
    boolean enTransition;

    /**
     * coordonnee de la cellule dans la grille
     */
    int x, y;

    /**
     * reference a la grille des cellules
     */
    Cellule[][] grille;


    /**
     * sa representation graphique associee
     */
    Circle circle;

    /**
     * constructeur par defaut, inutilise
     */
    public Cellule() {
    }

    /**
     * constructeur initialisant la grille, les coordonnees et la nature de la cellule
     */
    public Cellule(Cellule[][] grille, int x, int y, boolean vivante) {
        this.grille = grille;
        this.vivante = etatPrecedent = etatSuivant = vivante;
        enTransition = false;
        this.x = x;
        this.y = y;
    }

    /**
     * determine le prochain etat de la cellule en fonction des cellules voisines
     */
    void evoluer() {
        int taille = grille.length;
        int nbVivantes = 0;
        //compter le nb de cellules actives dans les 8 cases autours (la grille est considérée sphérique)
        for (int i = -1; i < 2; i++) {
            int xx = ((x + i) + taille) % taille; // si x+i=-1, xx=taille-1. si x+i=taille, xx=0
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) continue;
                int yy = ((y + j) + taille) % taille;
                if (grille[xx][yy].vivante) nbVivantes++;
            }
        }

        etatPrecedent = vivante;
        //verifie si la cellule doit se desactiver (en sous population, ou surpopulation)
        //on peut remplacer les constantes par des valeurs
        if (vivante && (nbVivantes <= sousPopulation || nbVivantes >= surPopulation)) {
            etatSuivant = false;
        } else
            //verifie si la cellule doit etre active ou reactivée (population idéale)
            //on peut remplacer les constantes par des valeurs
            if (nbVivantes >= minPopulationRegeneratrice && nbVivantes <= maxPopulationRegeneratrice) {
                etatSuivant = true;
            }
    }



    /**modifie la couleur de la représentation graphique associee selon l'etat*/
    public void switchColor() {
        Color c = null;
        if (vivante != etatSuivant)
        {
            if (etatSuivant) c = Cellule.coulActive;
            else c = Cellule.coulDesactive;
        }
        if(c!=null) circle.setFill(c);
    }

    /**change l etat courant vers l etat suivant*/
    public void avancer()
    {
        if(!enTransition) vivante = etatSuivant;
    }

    /**
     * @return la valeur de la variable vivante
     */
    public boolean isVivante() {
        return vivante;
    }


    /**
     * affecte un dessin à la cellule
     */
    public void setCircle(Circle circle) {
        this.circle = circle;
    }


}
