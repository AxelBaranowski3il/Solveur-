package fr.rodez3il.a2022.mrmatt.solveur.structures;

public class DictionnaireChaine<C, V> implements Dictionnaire<C, V> {

    public class Entree<C, V>{
        private C cle;
        private V valeur;

        public Entree (C cle, V valeur){
            this.cle = cle;
            this.valeur = valeur;
        }

        public C getCle() {
            return cle;
        }

        public V getValeur() {
            return valeur;
        }

        public void setCle(C cle) {
            this.cle = cle;
        }

        public void setValeur(V valeur) {
            this.valeur = valeur;
        }
    }
    private ListeChainee<Entree> listeChainee = new ListeChainee<>();


    @Override
    public void inserer(C cle, V valeur) {

    }

    @Override
    public boolean contient(C cle) {
        return false;
    }

    @Override
    public V valeur(C cle) {
        return null;
    }
}