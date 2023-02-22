package fr.rodez3il.a2022.mrmatt.solveur;

import fr.rodez3il.a2022.mrmatt.solveur.structures.DictionnaireChaine;
import fr.rodez3il.a2022.mrmatt.sources.Commande;
import fr.rodez3il.a2022.mrmatt.sources.Niveau;
import fr.rodez3il.a2022.mrmatt.solveur.structures.ListeChainee;

public class Noeud {
    // Référence vers le dictionnaire des configurations connues
    private DictionnaireChaine<String, Noeud> dict;

    // Référence vers le niveau actuel
    private Niveau niveau;

    // indique si le noeud est déjà visité
    private boolean visite = false;

    private Noeud[] fils;

    // Enum des commandes possibles pour atteindre les configurations
    private Commande commande;

    private String chaineCommande;

    public Noeud(DictionnaireChaine<String, Noeud> dict, Niveau niveau, Noeud[] fils, String chaine, boolean visite) {
        this.dict = dict;
        this.niveau = niveau;
        this.visite = visite;
        this.fils = fils;
        this.chaineCommande = chaine;
    }

    /**
     * Accesseur de l'attribut visite
     *
     * @return visite
     */
    public boolean getVisite() {
        return this.visite;
    }

    /**
     * mutateur de l'attribut visite
     *
     * @return visite
     */
    public void setVisite(boolean newVisite) {
        this.visite = newVisite;
    }

    /**
     * Accesseur de l'attribut haut
     *
     * @return visite
     */
    public Niveau getNiveau() {
        return this.niveau;
    }

    /**
     * Accesseur de l'attribut Fils
     *
     * @return visite
     */
    public Noeud[] getFils() {
        return this.fils;
    }

    /**
     * Accesseur de l'attribut chaineCommande
     *
     * @return visite
     */
    public String getChaineCommande() {
        return this.chaineCommande;
    }

    /**
     * Redéfinition de la méthode equals
     *
     * @param otherObj l'objet à comparer avec le noeud
     * @return true si égal sinon false
     */
    public boolean equals(Object otherObj) {
        if (otherObj instanceof Noeud) {
            Noeud other = (Noeud) otherObj;
            return this.niveau.equals(other.niveau);
        }
        return false;
    }

    /**
     * Calcule les fils du Noeud pour toutes les directions
     * et déplacements possibles. Si oui Vérifie si le niveau est gagant
     * Ajoute au dictionnaire connue la chaine et ajoute un noeud au fils
     */
    public void calculerFils() {
        this.visite = true;
        for (Commande comm : Commande.values()) {
            if (niveau.deplacementPossible(comm)) {

                Niveau niveauTemp = niveau.copier();
                chaineCommande += comm.toString() + "\n";

                niveauTemp.deplacer(comm);

                if (niveau.estGagnant()) {
                    return;
                }

                Noeud newFils;
                String valeurChaine = niveauTemp.valeurChaine();

                if (dict.contient(valeurChaine)) {
                    newFils = dict.valeur(valeurChaine);
                } else {
                    newFils = new Noeud(dict, niveauTemp, new Noeud[4], chaineCommande, false);
                    dict.inserer(valeurChaine, newFils);
                }
                fils[comm.ordinal()] = newFils;
            }
        }
    }
}
