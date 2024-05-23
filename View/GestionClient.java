package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Model.Client;
import Model.Magasin;

public class GestionClient extends JFrame{
	  JLabel titre = new JLabel("Ajouter / Supprimer un client");
	  JLabel nomL = new JLabel("Nom client         : ");
	  JTextField nomTF = new JTextField("",10);
	  JLabel prenomL = new JLabel("Prenom client    : ");
	  JTextField prenomTF = new JTextField("",10);
	  JLabel numL = new JLabel("Tel client           : ");
	  JTextField numTF = new JTextField("",10);
	  JLabel adresseL = new JLabel("Adresse client   : ");
	  JTextField adresseTF = new JTextField("",10);
	  JPanel nordPanel = new JPanel();
	  JPanel westPanel = new JPanel();
	  
	 
	  JButton ajoutP = new JButton("Ajouter");
	  JButton suppP = new JButton("Supprimer");
	  
	  Magasin magasin;
	  Vector<Client> listeClients = new Vector<Client>();
	  
	  public GestionClient(Magasin m) {
		  this.setTitle("Gestion de clients");
		  this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		  this.setPreferredSize(new Dimension(750,250));
		  
		  magasin = m;
		  
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
	        for(int i=0; i<listeClients.size();i++){
	            Vector<Object> o = new Vector<Object>();
	            o.add(listeClients.get(i).nom);
	            o.add(listeClients.get(i).prenom);
	            o.add(listeClients.get(i).num);
	            o.add(listeClients.get(i).adresse);
	            données.add(o);
	        }
	        
	        JTable tableClients = new JTable(données, colonnes);
	        magasin.addObserver( new JTableObserver(tableClients) );
	        JScrollPane scrollPane = new JScrollPane(tableClients);
	        tableClients.setDefaultEditor(Object.class,null);
	        tableClients.getColumnModel().getColumn(0).setPreferredWidth(55);
	        tableClients.getColumnModel().getColumn(1).setPreferredWidth(55);
	        tableClients.getColumnModel().getColumn(2).setPreferredWidth(60);
	        
	        getContentPane().add(scrollPane,BorderLayout.CENTER);
	        
	        JTextField[] tabJTF = new JTextField[3];
	        tabJTF[0] = nomTF;
	        tabJTF[1] = prenomTF;
	        tabJTF[2] = numTF;
	        
	        //LISTERNER
	        
	        this.setVisible(true);
	  }
}