package View;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.StatClientListener;
import Model.Magasin;

public class StatClient extends JFrame{
	
	Magasin magasin;
	JComboBox<String> listClient;
    JLabel titreClient= new JLabel("Statistiques des clients");
    JLabel artPlusAchete = new JLabel("L'article le plus acheté : ");
    JLabel nomArticlePlusAchete = new JLabel();
    JLabel listLabel = new JLabel("Liste d'acticles achetés : ");
    JPanel clientPanel = new JPanel();
	
	
	public StatClient(Magasin m){
		magasin = m;
		this.setTitle("Statistiques des clients");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(750,400));
        this.setSize(750,400);
		this.setLocationRelativeTo(null);
        this.setResizable(false);
        clientPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx=0.9;
        constraints.weighty=0.9;
        constraints.gridwidth = 2;
        constraints.insets=new Insets(10,10,0,0);
        clientPanel.add(titreClient,constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx=0.9;
        constraints.weighty=0.9;
        constraints.gridwidth = 2;
        constraints.anchor=GridBagConstraints.PAGE_START;
        constraints.insets=new Insets(10,10,0,0);

        Vector<String> nomClients = new Vector<String>();
        nomClients.add("");
        for (int i =0;i<magasin.listClients.size();i++){
            nomClients.add(magasin.listClients.get(i).nom +" "+magasin.listClients.get(i).prenom);
        }
        listClient = new JComboBox<>(nomClients);
        listClient.setPreferredSize(new Dimension(150,30));
        clientPanel.add(listClient,constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.weightx=0.9;
        constraints.weighty=0.9;
        constraints.gridwidth = 1;
        constraints.anchor=GridBagConstraints.PAGE_START;
        constraints.insets=new Insets(10,60,0,0);
        clientPanel.add(artPlusAchete,constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.weightx=0.9;
        constraints.weighty=0.9;
        constraints.gridwidth = 1;
        constraints.anchor=GridBagConstraints.FIRST_LINE_START;
        constraints.insets=new Insets(10,30,0,0);
        clientPanel.add(nomArticlePlusAchete,constraints);
        
        
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.weightx=0.9;
        constraints.weighty=0.9;
        constraints.anchor=GridBagConstraints.PAGE_START;
        constraints.insets=new Insets(10,60,0,0);
        clientPanel.add(listLabel,constraints);

        DefaultTableModel modelC = new DefaultTableModel();
        modelC.addColumn("Nom");
        modelC.addColumn("Prix");
        modelC.addColumn("Quantite");
        modelC.addColumn("Designation");
        
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.weightx=0.9;
        constraints.weighty=0.9;
        constraints.anchor=GridBagConstraints.FIRST_LINE_START;
        constraints.insets=new Insets(10,30,0,0);
        JTable tableC = new JTable(modelC);
        JScrollPane scrollPanelC = new JScrollPane(tableC);
        scrollPanelC.setPreferredSize(new Dimension(350,100));
        clientPanel.add(scrollPanelC,constraints);
        tableC.setDefaultEditor(Object.class,null);
        
        getContentPane().add(clientPanel);
        
        StatClientListener statCL = new StatClientListener(magasin,listClient,tableC,nomArticlePlusAchete);
        listClient.addActionListener(statCL);
        
        this.pack();
        this.setVisible(true);
	}
}
