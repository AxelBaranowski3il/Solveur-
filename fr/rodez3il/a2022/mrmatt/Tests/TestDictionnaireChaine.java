/**
 * TestDictionnaireChainee.java
 */
package fr.rodez3il.a2022.mrmatt.Tests;

import fr.rodez3il.a2022.mrmatt.solveur.structures.DictionnaireChaine;

/**
 * Classe de test concernant la classe dictionnaireChainee
 * Tests :
 * - insérer
 * - contient
 * - valeur
 */
public class TestDictionnaireChaine {
    public static void main(String[] args) {
        DictionnaireChaine<Integer, Integer> dico = new DictionnaireChaine<>();

        dico.inserer(3, 5);
        dico.inserer(7, 4);
        System.out.println(dico.contient(3) ? "V-Le test est VRAI, le dictionnaire contient bien 3." : "F-Le test est FAUX, le dictionnaire contient 3.");
        System.out.println(dico.contient(7) ? "V-Le test est VRAI, le dictionnaire contient bien 7." : "F-Le test est FAUX, le dictionnaire contient 7.");
        System.out.println(dico.valeur(3) == 5? "V-Le test est VRAI, le dictionnaire avec la cle 3 contient bien la valeur 5." : "F-Le test est FAUX, le dictionnaire avec la cle 3 contient la valeur 5.");
        System.out.println(dico.valeur(7) == 4? "V-Le test est VRAI, le dictionnaire avec la cle 7 contient bien la valeur 4." : "F-Le test est FAUX, le dictionnaire avec la cle 7 contient la valeur 4.");
    }
}
