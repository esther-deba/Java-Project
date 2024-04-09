import java.io.*;
import java.util.*;

public class LigneStock {

    public LigneStock(int qte, Depot depot, Article article) {
        this.qte = qte;
        this.depot = depot;
        this.article = article;
    }

    public int qte;
    public Depot depot;
    public Article article;

}