
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
        //à VERIFIER !!!!!!!!!!!!!
        listLigneStock.removeIf(element -> (element.article.nom == ligneStock.article.nom && element.article.taille == ligneStock.article.taille && element.article.couleur == ligneStock.article.couleur));
    }

    public LigneStock rechercherLigneStock(String n, String t, String coul){
        for(int i=0; i<listLigneStock.size();i++){
            if(listLigneStock.get(i).article.nom == n && listLigneStock.get(i).article.taille == t && listLigneStock.get(i).article.couleur == coul){return listLigneStock.get(i);}
        }
        return null;
    }
    public void modifierQuantiteStock(Article art, int q){
        rechercherLigneStock(art.nom, art.taille, art.couleur).qte = q;
        //des que la commande est validée la valeur de qte doit décrementer
    }
}