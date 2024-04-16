import java.io.*;
import java.util.*;


public class LigneCommande {
    public LigneCommande(){}

    public LigneCommande(int qte, Commande commande, Article article) {
        this.qte = qte;
        this.commande = commande;
        this.article = article;
    }

    public int qte;
    public Commande commande;
    public Article article;

    public double getPrice(){
        return qte*article.prix;
    }

}