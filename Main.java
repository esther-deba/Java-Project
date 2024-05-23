import Model.*;
import View.*;
public class Main {
  public static void main(String[] args) {
    Magasin m = new Magasin("nom");
		// Depot d = new Depot(m,"ad");
		  Menu menu = new Menu(m);
	  // GestionProduit p = new GestionProduit(d);
		// GestionClient c = new GestionClient(m);
  }
}
