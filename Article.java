
import java.io.*;
import java.util.*;

/**
 * 
 */
public class Article {

    /**
     * Default constructor
     */
    public Article() {
    }

    /**
     * 
     */
    public String nom;

    /**
     * 
     */
    public String taille;

    /**
     * 
     */
    public String couleur;

    /**
     * 
     */
    public float prix;

    /**
     * 
     */
    public Vector<LigneStock> listStock = new Vector<LigneStock>();

    /**
     * 
     */
    public Vector<LigneCommande> listLigneCmd = new Vector<LigneCommande>();

}