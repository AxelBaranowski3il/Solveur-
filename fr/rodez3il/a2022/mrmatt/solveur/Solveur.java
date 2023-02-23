/**
 * Solveur.java
 */
package fr.rodez3il.a2022.mrmatt.solveur;

import fr.rodez3il.a2022.mrmatt.solveur.structures.DictionnaireChaine;
import fr.rodez3il.a2022.mrmatt.sources.Niveau;

import java.util.LinkedList;

/**
 * Classe solveur permettant de trouver la solution
 * au niveau si elle est disponible
 * @author Axel Baranowski
 */
public class Solveur {

	/**
	 * methode qui permet de trouver la solution d'un niveau
	 * @param niveau à analyser
	 * @return la solution si elle est existante ou null
	 */
	public static String trouverSolution(Niveau niveau) {
		DictionnaireChaine<String, Noeud> dict = new DictionnaireChaine<>();
		// Initialisation du Noeud sans commande
		Noeud initial = new Noeud(dict, niveau, new Noeud[4], "", false);
		dict.inserer(niveau.valeurChaine(), initial);

		// Déclaration des deux listes traités et à traiter
		LinkedList<Noeud> traites = new LinkedList<>();
		LinkedList<Noeud> aTraiter = new LinkedList<>();

		// On ajoute le premier Noeud initial à la liste à traiter
		aTraiter.add(initial);

		// chaine qui écrira la solution
		StringBuilder sb = new StringBuilder();
		// Tant que la liste aTraiter n'est pas vide
		while (!aTraiter.isEmpty()) {

			// le noeud courant est égal au premier élément de la liste qu'on supprime juste après
			Noeud courant = aTraiter.removeFirst();

			// On ajoute le noeud qui doit être traité
			traites.add(courant);

			// On calcule le fils
			courant.calculerFils();
			for (Noeud fils : courant.getFils()) {
				if (fils != null && !fils.getVisite()) {
					if (fils.getNiveau().estGagnant()) {
						return fils.getChaineCommande();
					}
					//fils.setVisite(true);
					aTraiter.add(fils);
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		String solution = trouverSolution(new Niveau("niveaux/1rocher.txt"));
		if (solution == null) {
			System.out.println("Pas de solution.");
		} else {
			System.out.println("Une solution est : " + solution);
		}
	}

}
