
import java.io.*;
import java.util.*;


public class Magasin {

   
    public Magasin(String nom ) {
        this.nom = nom ;
    }

  
    public String nom;

   
    public Vector<Depot> depots = new Vector<Depot>();

    
    public Vector<Client> listClients = new Vector<Client>();

    
    public Vector<Vendeur> listVendeurs = new Vector<Vendeur>();

}