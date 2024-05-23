package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Model.Magasin;

public class GestionVente extends JFrame{
	JLabel titre = new JLabel("Faites votre commande ");
	JLabel labelVendeurs = new JLabel("Vendeur :");
    JComboBox<String> listVendeurs;
    JLabel labelClients = new JLabel("Client :");
    JComboBox<String> listClients;
    JLabel labelProduits = new JLabel("Produit :");
    JList<String> listProduits;
    JSpinner quantite = new JSpinner(new SpinnerNumberModel(0,0,100,1));
    JButton ajoutV = new JButton("Ajouter au panier");
    JButton suppV = new JButton("Supprimer du panier");
    JButton validerV = new JButton("Valider le panier");
    JPanel nordPanel = new JPanel();
    JPanel ouestPanel = new JPanel();

    Magasin magasin;
    
    public GestionVente(Magasin m) {
    	this.setTitle("Gestion de ventes");
    	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(750,400));
        magasin = m;
        titre.setHorizontalAlignment(SwingConstants.CENTER);
        
        Vector<String> nomVendeurs = new Vector<String>();
        nomVendeurs.add("");
        for (int i =0;i<magasin.listVendeurs.size();i++){
            nomVendeurs.add(magasin.listVendeurs.get(i).nom);
        }
        listVendeurs = new JComboBox<>(nomVendeurs);
        listVendeurs.setPreferredSize(new Dimension(125,25));
        
        Vector<String> nomClients = new Vector<String>();
        nomClients.add("");
        for (int i =0;i<magasin.listClients.size();i++){
            nomClients.add(magasin.listClients.get(i).nom);
        }
        listClients = new JComboBox<>(nomClients);
        listClients.setPreferredSize(new Dimension(125,25));
        
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(nordPanel,BorderLayout.NORTH);
        nordPanel.add(titre);
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(labelVendeurs);
        p.add(listVendeurs);
        p.add(labelClients);
        p.add(listClients);
        nordPanel.add(p);
        
        nordPanel.setLayout(new GridLayout(3,1));
        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        p2.add(ajoutV);
        p2.add(suppV);
        p2.add(validerV);
        nordPanel.add(p2);
        ouestPanel.setBorder( new EmptyBorder(10,20,0,0 ) );
        
        Vector<String> nomProduits = new Vector<String>();
        for (int i =0;i<magasin.depots.get(0).listLigneStock.size();i++){
            nomProduits.add(magasin.depots.get(0).listLigneStock.get(i).article.nom);
        }
        listProduits = new JList<>(nomProduits);
        
        JPanel p1 = new JPanel();
        p1.add(listProduits);
        p1.add(quantite);
        p1.setLayout(new FlowLayout());
        
        getContentPane().add(ouestPanel, BorderLayout.WEST);
        ouestPanel.add(p1);
        ouestPanel.setLayout(new FlowLayout());
        
        Vector<String> colonnes = new Vector<String>();
        colonnes.add("Nom du produit");
        colonnes.add("Quantité");
        colonnes.add("Prix unitaire");
        colonnes.add("Prix total");
        
        Vector<Vector<Object>> données = new Vector<Vector<Object>>();
        JTable tableCommandes = new JTable(données, colonnes);
        JScrollPane scrollPane = new JScrollPane(tableCommandes);
        tableCommandes.setDefaultEditor(Object.class,null);
        
        getContentPane().add(scrollPane,BorderLayout.CENTER);
        
        //LISTENER
        this.pack();
        this.setVisible(true);
        
    }
}
