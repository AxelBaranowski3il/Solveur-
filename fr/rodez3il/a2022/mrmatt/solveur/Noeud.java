package fr.rodez3il.a2022.mrmatt.solveur;

import fr.rodez3il.a2022.mrmatt.solveur.structures.*;
import fr.rodez3il.a2022.mrmatt.sources.*;

public class Noeud {
    private DictionnaireChaine dicoChaine;
    private Niveau etatNiveau;
    private Object[] fils;
    private Commande[] commandesASuivre;

    public Noeud(DictionnaireChaine dicoChaine, Niveau etatNiveau, Object[] fils, Commande[] commandesASuivre){
        this.dicoChaine = dicoChaine;
        this.etatNiveau = etatNiveau;
        this.fils = fils;
        this.commandesASuivre = commandesASuivre;
    }


}
