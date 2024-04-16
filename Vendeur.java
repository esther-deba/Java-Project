
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

    public void ajouteCommande(Commande commande){
        listCommandes.add(commande);
    }
    public double chiffreAffaireVendeur(){
        double somme = 0;
        for(int i=0; i<listCommandes.size(); i++){
            somme += listCommandes.get(i).getPrice();
        }
        return somme;
    }
    public int nbrProduitsVendus(){
        int nbr = 0;
        for(int i=0; i<listCommandes.size(); i++){
            nbr += listCommandes.get(i).listeLigneCmd.size();
        }
        return nbr;
    }

}