
import java.io.*;
import java.util.*;

public class Depot {

    public Depot(Magasin magasin, String adresse ) {
        this.magasin = magasin;
        this.adresse = adresse ;
    }

   
    public String adresse;

    public Magasin magasin;



    public Vector<LigneStock> listStock = new Vector<LigneStock>();

}