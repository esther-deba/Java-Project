
import java.io.*;
import java.util.*;


public class Client extends Personne {

    public Client(){}
    
    public Client(String nom, String prenom, String num, String adresse, Magasin magasin) {
     super(nom, prenom, num, adresse);
     this.magasin = magasin;
    }

    
    public Magasin magasin;

    
    public Vector<Commande> listCommandes = new Vector<Commande>();

}