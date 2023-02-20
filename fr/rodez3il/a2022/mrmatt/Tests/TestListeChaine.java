package fr.rodez3il.a2022.mrmatt.Tests;

import fr.rodez3il.a2022.mrmatt.solveur.structures.*;

public class TestListeChaine {
    public static void main(String[] args){
        ListeChainee liste = new ListeChainee<>();

        System.out.println(liste.estVide()?"V-Le test est VRAI, la liste est bien vide.":"F-Le test est FAUX, la liste est vide.");
        liste.ajouter(3);
        liste.ajouter(7);
        System.out.println(liste.taille()==2?"V-Le test est VRAI, la liste contient bien 2 éléments.":"F-Le test est FAUX, la liste contient 2 éléments.");
        System.out.println(liste.contient(3)?"V-Le test est VRAI, la liste contient bien 3.":"F-Le test est FAUX, la liste contient 3.");
        System.out.println(liste.contient(7)?"V-Le test est VRAI, la liste contient bien 7.":"F-Le test est FAUX, la liste contient 7.");
        liste.enlever(1);
        System.out.println(!liste.contient(7)?"V-Le test est VRAI, la liste ne contient plus 7.":"F-Le test est FAUX, la liste ne contient plus 7.");
    }
}
