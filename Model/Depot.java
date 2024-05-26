package Model;

import java.io.*;
import java.util.*;

public class Depot extends Observable{

    public Depot(Magasin magasin, String adresse ) {
        this.magasin = magasin;
        this.adresse = adresse ;
    }

    public String adresse;
    public Magasin magasin;

    public Vector<LigneStock> listLigneStock = new Vector<LigneStock>();

    public void ajouteLigneStock(LigneStock ligneStock){
        listLigneStock.add(ligneStock);
        this.setChanged();
        this.notifyObservers(ligneStock);
    }

    public void supprimerLigneStock(LigneStock ligneStock){
    	
    	if (ligneStock != null && ligneStock.article != null) {
            listLigneStock.removeIf(element -> element != null && element.article != null && element.article.nom.equals(ligneStock.article.nom));}
        this.setChanged();
        this.notifyObservers(ligneStock);
    }

    public LigneStock rechercherLigneStock(String nom) {
        for (int i = 0; i < listLigneStock.size(); i++) {
            if (listLigneStock.get(i).article.nom.equals(nom)) {
                return listLigneStock.get(i);
            }
        }
        return null;
    }

    private LigneStock rechercherLigneStock(Article art) {
        // recherche un article à utiliser qu'à l'interieur de la classe !
        for( int i=0; i<listLigneStock.size();i++){
            if( listLigneStock.get(i).article == art ){
                return listLigneStock.get(i);
            }
        }
        return null;
    }
    
    public void ajouteOuRechargeLigneStock(Article article, int quantite) {
        LigneStock ligneStock = rechercherLigneStock(article.nom);
        if (ligneStock != null) {
            ligneStock.qte += quantite;
            this.setChanged();
            this.notifyObservers(ligneStock);
        } else {
            ajouteLigneStock(new LigneStock(quantite, this, article));
        }
    }
}