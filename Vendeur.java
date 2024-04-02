
import java.io.*;
import java.util.*;

/**
 * 
 */
public class Vendeur extends Personne {

    /**
     * Default constructor
     */
    public Vendeur() {
    }

    /**
     * 
     */
    public Vector<Commande> listCommandes = new Vector<Commande>();

    /**
     * 
     */
    public Magasin magasin;

}