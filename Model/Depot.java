package Model;

import java.io.*;
import java.util.*;
//OBSERVABLE
public class Depot {

    public Depot(Magasin magasin, String adresse ) {
        this.magasin = magasin;
        this.adresse = adresse ;
    }

    public String adresse;
    public Magasin magasin;

    public Vector<LigneStock> listLigneStock = new Vector<LigneStock>();

    public void ajouteLigneStock(LigneStock ligneStock){
        listLigneStock.add(ligneStock);
        //OBSERVABLE
    }

    public void supprimerLigneStock(LigneStock ligneStock){
        listLigneStock.removeIf(element -> element.article.nom == ligneStock.article.nom);
        //OBSERVABLE
    }

    public LigneStock rechercherLigneStock(String nom){
        for(int i=0; i<listLigneStock.size();i++){
            if(listLigneStock.get(i).article.nom == nom ){
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

    public void modifierQuantiteStock(Article art, int q){
        rechercherLigneStock(art).qte = q;
    }
}