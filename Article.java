import java.io.*;
import java.util.*;


public class Article {

    public Article(String nom, double prix, String description) {
        this.nom = nom;
        this.prix = prix;
        this.description = description;
    }
    public String nom;
    public double prix;
    public String description;
    
    public Vector<LigneStock> listStock = new Vector<LigneStock>();
    public Vector<LigneCommande> listLigneCmd = new Vector<LigneCommande>();

    public void ajouteLigneCommande (LigneCommande ligneCommande){
        listLigneCmd.add(ligneCommande);
    }

    public void ajouteLigneStock(LigneStock ligneStock){
        listStock.add(ligneStock);
    }


}