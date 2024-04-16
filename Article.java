import java.io.*;
import java.util.*;


public class Article {
    public Article(String nom, String taille, String couleur, double prix) {
        this.nom = nom;
        this.taille = taille;
        this.couleur = couleur;
        this.prix = prix;
    }
    public String nom;
    public String taille;
    public String couleur;
    public double prix;
    
    public Vector<LigneStock> listStock = new Vector<LigneStock>();
    public Vector<LigneCommande> listLigneCmd = new Vector<LigneCommande>();

    public void ajouteLigneCommande (LigneCommande ligneCommande){
        listLigneCmd.add(ligneCommande);
    }

    public void ajouteLigneStock(LigneStock ligneStock){
        listStock.add(ligneStock);
    }


}