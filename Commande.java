import java.io.*;
import java.util.*;

public class Commande {

    public Commande(Date date, Vendeur vendeur, Client client) {
        this.date = date;
        this.vendeur = vendeur;
        this.client = client;
    }
    public Date date;
    public Vendeur vendeur;
    public Client client;
}