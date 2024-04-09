
import java.io.*;
import java.util.*;


public class Article {

   
    public Article() {
    }

   
    public String nom;

   
    public String taille;

    
    public String couleur;

  
   
    public float prix;

   
    public Vector<LigneStock> listStock = new Vector<LigneStock>();

   
    public Vector<LigneCommande> listLigneCmd = new Vector<LigneCommande>();

}