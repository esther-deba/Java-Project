package Model;
import java.io.*;
import java.util.*;

public class Commande {

    public Commande(){}

    public Commande(Date date, Vendeur vendeur, Client client) {
        this.date = date;
        this.vendeur = vendeur;
        this.client = client;
    }
    public Date date;
    public Vendeur vendeur;
    public Client client;

    public Vector<LigneCommande> listeLigneCmd = new Vector<LigneCommande>();

    public void ajouteLigneCommande(LigneCommande ligneCommande){
        listeLigneCmd.add(ligneCommande);
    }
    
    public LigneCommande rechercherLigneCommande(Article art){
        for(int i=0; i<listeLigneCmd.size();i++){
            if(listeLigneCmd.get(i).article == art){return listeLigneCmd.get(i);}
        }
        return null;
    }

    public void modifierQuantiteLigneCommande(Article art, int quantite){
        if(rechercherLigneCommande(art) != null){
            rechercherLigneCommande(art).qte = quantite;
        }
    }

    public void supprimerLigneCommande(Article art){
        Vector<LigneCommande> newVect = new Vector<LigneCommande>();

        for(int i=0; i<listeLigneCmd.size(); i++){
            if(listeLigneCmd.get(i).article != art){
                newVect.add(listeLigneCmd.get(i));
            }
        }
        listeLigneCmd = newVect;
    }

    public double getPrice(){
        double somme = 0;
        for (int i = 0; i<listeLigneCmd.size(); i++) {
            somme += listeLigneCmd.get(i).getPrice();
        }
        return somme;
    }

}