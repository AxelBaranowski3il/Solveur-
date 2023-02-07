package fr.rodez3il.a2022.mrmatt.solveur.structures;

public class ListeChainee<T> implements Liste<T> {

    class Maillon {
        private T donnee;
        private Maillon suivant;

        public Maillon(T donnee, Maillon suivant){
            this.donnee = donnee;
            this.suivant = suivant;
        }
    }

    private Maillon maillon;

    private int nbMaillon;

    public ListeChainee(Maillon maillon){
        this.maillon = maillon;
        nbMaillon = 0;
    }

    @Override
    public void ajouter(T element) {
        while (maillon.suivant != null){
            maillon = maillon.suivant;
            nbMaillon++;
        }
        maillon.suivant = new Maillon(element, null);
    }

    @Override
    public boolean estVide() {
        return maillon.donnee == null;
    }

    @Override
    public int taille() {
        int i = 0;
        while (maillon.suivant != null)
            i++;
        return i;
    }

    @Override
    public T enlever(int i) {
        return null;
    }

    @Override
    public T element(int i) {
        Maillon resMaill = maillon;
        int a = 0;
        if (i < 0 || i > nbMaillon)
            return null;
        while (a < i){
            resMaill = resMaill.suivant;
        }
        return resMaill.donnee;
    }

    @Override
    public boolean contient(T e) {
        boolean condition = false;
        Maillon resMaill = maillon;
        while (resMaill.suivant != null && !condition){
            condition = resMaill.donnee.equals(e);
            resMaill = resMaill.suivant;
        }
        return condition;
    }
}

