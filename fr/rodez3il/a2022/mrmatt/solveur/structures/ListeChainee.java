/**
 * ListeChainee.java
 */
package fr.rodez3il.a2022.mrmatt.solveur.structures;

/**
 * classe liste chainee
 * @author Axel Baranowski
 * @param <T>
 */
public class ListeChainee<T> implements Liste<T> {

    // taille de la liste
    private int taille;

    // Maillon principal
    Maillon maillonPrincipal;

    // Maillon tampon
    Maillon maillonTampon;

    /**
     * Classe maillon pour la création d'éléments
     * pour la liste chainée
     */
    public class Maillon {
        // donnee du maillon
        T donnee;

        // création d'un maillon suivant pour créer une chaine
        Maillon suivant;

        /**
         * Constructeur de maillon
         * @param donnee à initialiser
         * @param suivant, maillon à ajouter
         */
        Maillon(T donnee, Maillon suivant) {
            this.donnee = donnee;
            this.suivant = suivant;
        }
    }

    /**
     * Constructeur de ListeChainee
     */
    public ListeChainee() {
        maillonTampon = null;
        maillonPrincipal = null;
        taille = 0;
    }

    /**
     * Ajoute un maillon dans la liste à la fin de la liste
     * Initialise le maillon suivant à null
     *
     * @param element (element à ajouter dans la liste de maillon)
     */
    @Override
    public void ajouter(T element) {
        if (maillonPrincipal == null) {
            maillonTampon = new Maillon(element, null);
            maillonPrincipal = maillonTampon;
        } else {
            maillonTampon = maillonPrincipal;
            while(maillonTampon.suivant != null) {
                maillonTampon = maillonTampon.suivant;
            }
            maillonTampon.suivant = new Maillon(element, null);
            maillonTampon = maillonTampon.suivant;
        }
        taille++;
    }

    /**
     * Si le maillon est null return true
     * Sinon false
     */
    @Override
    public boolean estVide() {
        return (maillonTampon == null);
    }

    /**
     * retourne la taille du maillon
     */
    @Override
    public int taille() {
        return taille;
    }

    /**
     * Supprime le maillon à l'indice i.
     * Décale toute la liste des maillons pour raccorder la suite du maillon *
     * supprimé.
     *
     * @param i (indice de la liste à supprimer)
     */
    @Override
    public T enlever(int i) {
        Maillon maillonEnlever = null;
        if (i < 0 || i >= taille) {
            return null;
        }

        maillonTampon = maillonPrincipal;

        if(i == 0) {
            maillonEnlever = maillonTampon;
            maillonPrincipal = maillonTampon.suivant;
            maillonTampon = maillonPrincipal;
            return maillonEnlever.donnee;
        }

        for(int j = 0; j < i - 1; i++) {
            maillonTampon = maillonTampon.suivant;
        }

        maillonEnlever = maillonTampon.suivant;
        maillonTampon.suivant = maillonEnlever.suivant;
        taille--;
        return maillonEnlever.donnee;
    }

    /**
     * Retourne le maillon à l'indice i
     *
     * @param i (indice à retourner)
     */
    @Override
    public T element(int i) {
        if (i < 0 || i >= taille) {
            return null;
        }

        Maillon currentMaillon = maillonPrincipal;
        for (int j = 0; j < i; j++) {
            currentMaillon = currentMaillon.suivant;
        }
        return currentMaillon.donnee;
    }

    /**
     * Vérifie si le maillon est contenu dans la liste ou non
     * return true si il est dans la liste
     * sinon false
     *
     * @param e (maillon à chercher)
     */
    @Override
    public boolean contient(T e) {
        Maillon maillonContient = maillonPrincipal;
        while (maillonContient.suivant != null) {
            if (maillonContient.donnee.equals(e)) {
                return true;
            }
            maillonContient = maillonContient.suivant;
        }
        return false;
    }
}
