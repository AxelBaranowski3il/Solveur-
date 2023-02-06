package fr.rodez3il.a2022.mrmatt.solveur.structures;

import java.util.Arrays;

public class ListeTableau<E> implements Liste<E> {

    private Object[] tab;

    public ListeTableau(){
        tab = new Object[100];
    }

    @Override
    public void ajouter(E element) {
        if (tab[tab.length - 1] != null){
            Object [] resTab = tab;
            tab = new Object[tab.length*2];
            for(int i = 0; i < resTab.length; i++){
                tab [i] = resTab[i];
            }
        }
        for (int i = 0; i < tab.length; i++){
            if (tab[i] == null)
                tab[i] = element;
        }
    }

    @Override
    public boolean estVide() {
        return tab.length == 0;
    }

    @Override
    public int taille() {
        return tab.length;
    }

    @Override
    public E enlever(int i) {
        if ((0 > i && i > tab.length) || tab[i] == null)
            return null;
        tab[i] = null;
        for (int a = i+1; a < tab.length; a++){
            tab[a-1] = tab[a];
        }
        return (E)tab[i];
    }

    @Override
    public E element(int i) {
        if ((0 > i && i > tab.length) || tab[i] == null)
            return null;
        return (E)tab[i];
    }

    @Override
    public boolean contient(E e) {
        boolean condition = false;
        // TODO test avant d'appeler "equals"
        for (int i = 0; i < tab.length; i++){
            if (!condition && e.equals(tab[i]))
                condition = true;
        }
        return condition;
    }
}