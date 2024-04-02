
import java.io.*;
import java.util.*;

/**
 * 
 */
public class Commande {

    /**
     * Default constructor
     */
    public Commande() {
    }

    /**
     * 
     */
    public Date date;

    /**
     * 
     */
    public Vendeur vendeur;

    /**
     * 
     */
    public Client client;

    /**
     * 
     */
    public Vector<LigneCommande> listLigneCmd = new Vector<LigneCommande>();

}