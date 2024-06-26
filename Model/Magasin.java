package Model;

import java.io.*;
import java.util.*;


public class Magasin extends Observable{

    public Magasin(String nom ) {
        this.nom = nom ;
    }

    public String nom;

    public Vector<Depot> depots = new Vector<Depot>();
    public Vector<Client> listClients = new Vector<Client>();
    public Vector<Vendeur> listVendeurs = new Vector<Vendeur>();

    public void ajouteClient(Client client){
        listClients.add(client);
        this.setChanged();
        this.notifyObservers(client);
    }

    public void supprimerClient(Client client){
        listClients.removeIf(element -> (element.nom.equals(client.nom) && element.prenom.equals(client.prenom)));
        this.setChanged();
        this.notifyObservers(client);
    }

    public void ajouteVendeur(Vendeur vendeur){
        listVendeurs.add(vendeur);
        this.setChanged();
        this.notifyObservers(vendeur);
    }

    public void supprimerVendeur(Vendeur vendeur){
        listClients.removeIf(element -> element.nom.equals(vendeur.nom) && element.prenom.equals((vendeur.prenom)));
        this.setChanged();
        this.notifyObservers(vendeur);
    }

    public void ajouteStock(Depot depot){
        depots.add(depot);
    }

    public LigneStock rechercherLigneStock(String nom){
        for(int i=0; i<depots.size(); i++){
            for(int j=0; j<depots.get(i).listLigneStock.size(); j++){
                if(depots.get(i).listLigneStock.get(j).article.nom.equals(nom)){
                    return depots.get(i).listLigneStock.get(j);
                }
            }
        }
        return null;
    }

    public Client rechercherClient(String nom){
        for(int i=0; i<listClients.size();i++){
            if(listClients.get(i).nom.equals(nom)){
                return listClients.get(i);
            }
        }
        return null;
    }
    
    public Client rechercherClient(String nom,String prenom){
        for(int i=0; i<listClients.size();i++){
            if(listClients.get(i).nom.equals(nom) && listClients.get(i).prenom.equals(prenom)){
                return listClients.get(i);
            }
        }
        return null;
    }

    public Vendeur rechercherVendeur(String nom){
        for(int i=0; i<listVendeurs.size();i++){
            if(listVendeurs.get(i).nom.equals(nom)){
                return listVendeurs.get(i);
            }
        }
        return null;
    }

    public Vendeur rechercherVendeur(String nom, String prenom){
        for(int i=0; i<listVendeurs.size();i++){
            if(listVendeurs.get(i).nom.equals(nom) && listVendeurs.get(i).prenom.equals(prenom)){
                return listVendeurs.get(i);
            }
        }
        return null;
    }
    
    public double chiffreAffaireClient(String nom){
        return rechercherClient(nom).chiffreAffaireClient();
    }

    public double chiffreAffaireVendeur(String nom){
        return rechercherVendeur(nom).chiffreAffaireVendeur();
    }

    public double chiffreAffaireTotal(){
        double somme=0;
        for(int i=0; i<listClients.size();i++){
            somme += listClients.get(i).chiffreAffaireClient();
        }
        return somme;
    }

    public Vector<Article> listesArticlesVendus(){
        Vector<Article> lesArticles = new Vector<Article>();
        for(int i=0; i<listClients.size();i++){
            Vector<Article> v = listClients.get(i).listesArticleCommandesClient();
            for(int j=0; j<v.size();j++){
                if(!(lesArticles.contains(v.get(j)))){
                    lesArticles.add(v.get(j));
                }
            }
        }
        return lesArticles;
    }

    public int qteVenduArticle(String nom){
        int qte=0;
        for(int i=0; i<listClients.size(); i++){
            qte += listClients.get(i).qteArticleCommandeClient(nom);
        }
        return qte;
    }

    public int qteTotalVendue(){
        int qteTotal=0;
        for(int i=0; i<listClients.size(); i++){
            qteTotal += listClients.get(i).qteTotalArticleCommandeClient();
        }
        return qteTotal;
    }

    public Article articleLePlusAcheter(){
        Vector<Article> vec = this.listesArticlesVendus();
        Article articleMax = vec.get(0);
        int nbrMax = qteVenduArticle(articleMax.nom);
        for(int i=1; i<vec.size(); i++){
            if(nbrMax<qteVenduArticle(vec.get(i).nom))
            articleMax = vec.get(i);
            nbrMax = qteVenduArticle(vec.get(i).nom);
        }
        return articleMax;
    }
    
    public void ajouteStock(Depot depot, Article article, int quantite) {
        LigneStock ligneStockExistante = rechercherLigneStock(article.nom);
        if (ligneStockExistante != null) {
            ligneStockExistante.qte += quantite;
            this.setChanged();
            this.notifyObservers(ligneStockExistante);
        } else {
            depot.ajouteLigneStock(new LigneStock(quantite, depot, article));
        }
    }


}