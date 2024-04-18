
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

    public void ajouteCommande(Commande commande){
        listCommandes.add(commande);
    }

    public double chiffreAffaireClient(){
        double somme = 0;
        for(int i=0; i<listCommandes.size(); i++){
            somme += listCommandes.get(i).getPrice();
        }
        return somme;
    }

    public int qteArticleCommandeClient(String nom){
        int nbr = 0;
        for(int i=0; i<listCommandes.size(); i++){
            for(int j=0; j<listCommandes.get(i).listeLigneCmd.size(); j++){
                if(listCommandes.get(i).listeLigneCmd.get(j).article.nom.equals(nom)){
                    nbr += listCommandes.get(i).listeLigneCmd.get(j).qte;
                }
            }
        }
        return nbr;
    }

    public int qteTotalArticleCommandeClient(){
        int nbrTotal = 0;
        for(int i=0; i<listCommandes.size(); i++){
            for(int j=0; j<listCommandes.get(i).listeLigneCmd.size(); j++){
                nbrTotal += listCommandes.get(i).listeLigneCmd.get(j).qte;
            }
        }
        return nbrTotal;
    }

    public Vector<Article> listesArticleCommandesClient(){
        Vector<Article> newVec = new Vector<Article>();
        for(int i=0; i<listCommandes.size(); i++){
            for(int j=0; j<listCommandes.get(i).listeLigneCmd.size(); j++){
                if(!(newVec.contains(listCommandes.get(i).listeLigneCmd.get(j).article))){
                    newVec.add(listCommandes.get(i).listeLigneCmd.get(j).article);
                }
            }
        }
        return newVec;   
    }

    public Article articleLePlusAcheterClient(){
        Vector<Article> vec = listesArticleCommandesClient();
        Article articleMax = vec.get(0);
        int nbrMax = qteArticleCommandeClient(articleMax.nom);
        for(int i=1; i<vec.size(); i++){
            if(nbrMax<qteArticleCommandeClient(vec.get(i).nom)){
                articleMax = vec.get(i);
                nbrMax = qteArticleCommandeClient(vec.get(i).nom);
            }
        }
        return articleMax;
    }

}