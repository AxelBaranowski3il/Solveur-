/**
 * DictionnaireChaine. java
 */
package fr.rodez3il.a2022.mrmatt.solveur.structures;

/**
 * La classe DictionnaireChaine<C,V> est celle qui va nous permettre de gérer
 * le dictionnaire
 * @param <C> La clé, ici, état du plateau
 * @param <V> La valeur, ici, configurations connues
 * @author Axel Baranowski
 */
public class DictionnaireChaine<C, V> implements Dictionnaire<C, V> {

    private ListeChainee<Entree<C, V>> liste = new ListeChainee();

    /**
     * Classe permettant de gérer les entrées
     */
    class Entree<C, V> {
        C cle;
        V valeur;

        public Entree(C cle, V valeur) {
            this.cle = cle;
            this.valeur = valeur;
        }

        public V getValeur() {
            return this.valeur;
        }

        public void setValeur(V newValeur) {
            this.valeur = newValeur;
        }
    }

    /**
     * Insère une clé et une Valeur au dictionnaire
     * @param cle à insérer
     * @param valeur à insérer
     */
    public void inserer(C cle, V valeur) {
        Entree<C,V> entree = verifierEntree(cle);
        if(entree != null) {
            entree.setValeur(valeur);
        } else {
            liste.ajouter(new Entree<>(cle, valeur));
        }
    }

    /**
     * Verifie si une clé est contenue dans le dictionnaire
     * @param cle à rechercher
     * @return true si contient sion false
     */
    public boolean contient(C cle) {
        return verifierEntree(cle) != null;
    }

    /**
     * Renvoie la valeur associée à la clé.
     * @param cle à associer à une valeur
     * @return null si la clé n'existe pas.
     */
    public V valeur(C cle) {
        Entree<C, V> entree = verifierEntree(cle);

        return entree != null ? entree.getValeur() : null;
    }

    /**
     * Verifie une entrée
     * @param cle à vérifier
     * @return NULL si la clé n'existe pas.
     */
    private Entree<C, V> verifierEntree(C cle) {
        for(int i = 0; i < liste.taille(); i++) {
            Entree<C, V> entree = liste.element(i);
            if(entree.cle.equals(cle)) {
                return entree;
            }
        }
        return null;
    }
}