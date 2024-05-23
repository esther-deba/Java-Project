package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.*;

import Model.Vendeur;
import Model.Magasin;

public class GestionVendeur extends JFrame{
	  JLabel titre = new JLabel("Ajouter / Supprimer un vendeur");
	  JLabel nomL = new JLabel("Nom vendeur         : ");
	  JTextField nomTF = new JTextField("",10);
	  JLabel prenomL = new JLabel("Prenom vendeur    : ");
	  JTextField prenomTF = new JTextField("",10);
	  JLabel numL = new JLabel("Tel vendeur             : ");
	  JTextField numTF = new JTextField("",10);
	  JLabel adresseL = new JLabel("Adresse vendeur   : ");
	  JTextField adresseTF = new JTextField("",10);
	  JPanel nordPanel = new JPanel();
	  JPanel westPanel = new JPanel();
	  
	  JButton ajoutP = new JButton("Ajouter");
	  JButton suppP = new JButton("Supprimer");
	  
	  Magasin magasin;
	  Vector<Vendeur> listeVendeurs = new Vector<Vendeur>();
	  
	  public GestionVendeur(Magasin m) {
		  this.setTitle("Gestion de Vendeurs");
		  this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		  this.setPreferredSize(new Dimension(750,350));
		  this.setResizable(false);
		  
		  magasin =m;
		  
		  getContentPane().setLayout(new BorderLayout());
		  titre.setHorizontalAlignment(SwingConstants.CENTER);
		  getContentPane().add(nordPanel, BorderLayout.NORTH);
		  nordPanel.add(titre);
		  getContentPane().add(westPanel, BorderLayout.WEST);
		  
		  JPanel nomPanel = new JPanel();
		  JPanel prenomPanel = new JPanel();
		  JPanel numPanel = new JPanel();
		  JPanel adressePanel = new JPanel();
		  
		  nomPanel.setLayout(new FlowLayout());
		  nomPanel.add(nomL);
		  nomPanel.add(nomTF);
		  
		  prenomPanel.setLayout(new FlowLayout());
		  prenomPanel.add(prenomL);
		  prenomPanel.add(prenomTF);
		  
		  numPanel.setLayout(new FlowLayout());
		  numPanel.add(numL);
		  numPanel.add(numTF);
		  
		  adressePanel.setLayout(new FlowLayout());
		  adressePanel.add(adresseL);
		  adressePanel.add(adresseTF);
		  
		  
		  westPanel.setLayout(new GridLayout(6,1,5,5));
		  westPanel.add(nomPanel);
		  westPanel.add(prenomPanel);
		  westPanel.add(numPanel);
		  westPanel.add(adressePanel);
		  westPanel.add(ajoutP);
		  westPanel.add(suppP);
		  
		  
		  Vector<String> colonnes = new Vector<String>();
		  colonnes.add("Nom");
		  colonnes.add("Prenom");
		  colonnes.add("Numero");
		  colonnes.add("Adresse");
		  
		  Vector<Vector<Object>> données = new Vector<Vector<Object>>();
	        for(int i=0; i<listeVendeurs.size();i++){
	            Vector<Object> o = new Vector<Object>();
	            o.add(listeVendeurs.get(i).nom);
	            o.add(listeVendeurs.get(i).prenom);
	            o.add(listeVendeurs.get(i).num);
	            o.add(listeVendeurs.get(i).adresse);
	            données.add(o);
	        }
	        
	        
	        JTable tableVendeurs = new JTable(données, colonnes);
	        magasin.addObserver( new JTableObserver(tableVendeurs) );
	        JScrollPane scrollPane = new JScrollPane(tableVendeurs);
	        tableVendeurs.setDefaultEditor(Object.class,null);
	        tableVendeurs.getColumnModel().getColumn(0).setPreferredWidth(55);
	        tableVendeurs.getColumnModel().getColumn(1).setPreferredWidth(55);
	        tableVendeurs.getColumnModel().getColumn(2).setPreferredWidth(60);
	        
	        getContentPane().add(scrollPane,BorderLayout.CENTER);
	        
	        JTextField[] tabJTF = new JTextField[3];
	        tabJTF[0] = nomTF;
	        tabJTF[1] = prenomTF;
	        tabJTF[2] = numTF;
	        
	        //LISTERNER
	        
	        this.setVisible(true);
									this.pack();
		  
	  }
	  

}

