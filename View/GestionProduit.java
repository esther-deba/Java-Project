package View;

import java.awt.*;
import java.util.Vector;

import javax.swing.*;


import Model.Depot;
import Model.LigneStock;

public class GestionProduit extends JFrame{
	
	  JLabel titre = new JLabel("Ajouter / Supprimer un produit");
	  JLabel nomL = new JLabel("Nom produit : ");
	  JTextField nomTF = new JTextField("",10);
	  JLabel prixL = new JLabel("Prix produit   : ");
	  JTextField prixTF = new JTextField("",10);
	  JLabel qteL = new JLabel("Quantité       : ");
	  JTextField qteTF = new JTextField("",10);
	  JLabel descriptionL = new JLabel("Description   : ");
	  JTextField descriptionTF = new JTextField("",10);
	  JPanel nordPanel = new JPanel();
	  JPanel westPanel = new JPanel();
	  JPanel centerPanel = new JPanel();
	 
	  JButton ajoutP = new JButton("Ajouter");
	  JButton suppP = new JButton("Supprimer");
	  
	  Vector<LigneStock> ligneStock;
	  Depot depot;
	  
	  public GestionProduit(Depot d) {
		  this.setTitle("Gestion de produits");
		  this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		  this.setPreferredSize(new Dimension(750,250));
		//  this.setResizable(false);
		  
		  depot = d;
		  ligneStock = depot.listLigneStock;
		  
		  getContentPane().setLayout(new BorderLayout());
		  titre.setHorizontalAlignment(SwingConstants.CENTER);
		  getContentPane().add(nordPanel, BorderLayout.NORTH);
		  nordPanel.add(titre);
		  getContentPane().add(westPanel, BorderLayout.WEST);
		  JPanel nomPanel = new JPanel();
		  JPanel prixPanel = new JPanel();
		  JPanel qtePanel = new JPanel();
		  JPanel descriptionPanel = new JPanel();
		  
		  nomPanel.setLayout(new FlowLayout());
		  nomPanel.add(nomL);
		  nomPanel.add(nomTF);
		  
		  prixPanel.setLayout(new FlowLayout());
		  prixPanel.add(prixL);
		  prixPanel.add(prixTF);
		  
		  qtePanel.setLayout(new FlowLayout());
		  qtePanel.add(qteL);
		  qtePanel.add(qteTF);
		  
		  descriptionPanel.setLayout(new FlowLayout());
		  descriptionPanel.add(descriptionL);
		  descriptionPanel.add(descriptionTF);
		  
		  
		  westPanel.setLayout(new GridLayout(6,1,5,5));
		  westPanel.add(nomPanel);
		  westPanel.add(prixPanel);
		  westPanel.add(qtePanel);
		  westPanel.add(descriptionPanel);
		  westPanel.add(ajoutP);
		  westPanel.add(suppP);
		  
		
	 
		  Vector<String> colonnes = new Vector<String>();
		  colonnes.add("Nom");
		  colonnes.add("Prix");
		  colonnes.add("Quantité");
		  colonnes.add("Description");
		  
		  Vector<Vector<Object>> données = new Vector<Vector<Object>>();
		  for(int i=0; i<ligneStock.size();i++){
			  Vector<Object> objetArticle = new Vector<Object>();
			  objetArticle.add(ligneStock.get(i).article.nom);
			  objetArticle.add(ligneStock.get(i).article.prix);
			  objetArticle.add(ligneStock.get(i).qte);
			  objetArticle.add(ligneStock.get(i).article.description);
			  données.add(objetArticle);
		  }
		  
		  JTable table = new JTable(données, colonnes);
		  depot.addObserver(new JTableObserver(table));
		  JScrollPane scrollPane = new JScrollPane(table);
		  table.setDefaultEditor(Object.class,null);
		  
		  centerPanel.add(scrollPane);
		  
		  scrollPane.setPreferredSize(new Dimension(450,250));

	      table.getColumnModel().getColumn(1).setPreferredWidth(20);
	      table.getColumnModel().getColumn(2).setPreferredWidth(20);
	      table.getColumnModel().getColumn(3).setPreferredWidth(100);
	      
	      getContentPane().add(centerPanel,BorderLayout.CENTER);
	      
	      JTextField[] tabJTF = new JTextField[3];
	      tabJTF[0] = nomTF;
	      tabJTF[1] = prixTF;
	      tabJTF[2] = qteTF;

							//LISTENER
	      
	  }
	  }
