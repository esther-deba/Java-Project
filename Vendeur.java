
import java.io.*;
import java.util.*;


public class Vendeur extends Personne {

    public Vendeur(){}

    public Vendeur(String nom, String prenom, String num, String adresse, Magasin magasin) {
        super(nom, prenom, num, adresse);
        this.magasin = magasin;
    }

    
    public Vector<Commande> listCommandes = new Vector<Commande>();

    public Magasin magasin;

}