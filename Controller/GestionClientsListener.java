package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;

import Model.Client;
import Model.Magasin;

public class GestionClientsListener implements ActionListener{

	Magasin monMagasin;
    JTextField[] tabTF;
    JTextField textTF;
    JTable tableClients;
    
    public GestionClientsListener(Magasin m, JTextField[] tab_tf, JTextField adr_text, JTable tab_donnees) {
    	monMagasin = m;
    	tabTF = tab_tf;
    	textTF = adr_text;
    	tableClients = tab_donnees;
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String nomClient = tabTF[0].getText();
        String prenomClient = tabTF[1].getText();
        String telClient = tabTF[2].getText();
        String adresseClient = textTF.getText();
        
        if (((JButton) e.getSource()).getText().equals("Ajouter")) {
        	// vérifier si un des 4 champs est vide
        	if (nomClient.equals("") || prenomClient.equals("") || telClient.equals("") || adresseClient.equals("")) {
                return;
            }
        	// recupérer et creer un nouveau client depuis les champs saisis
            Client client = new Client(nomClient, prenomClient, telClient, adresseClient, monMagasin);
            
            //vérifie si le client existe déja dans notre magasin
            for (int i = 0; i < monMagasin.listClients.size(); i++) {
                if (monMagasin.listClients.get(i) == client) {
                    return;
                }
            }
            // Ajouter  client
            monMagasin.ajouteClient(client);
            
         // Vider les champs
            for (int i = 0; i < 3; i++) {
                tabTF[i].setText("");
            }
            textTF.setText("");
        }
        
        if (((JButton) e.getSource()).getText().equals("Supprimer")) {
        	//Vérifie le champs nom et prenom pour supprimer
            if( nomClient.equals("") || prenomClient.equals("") ) {
                return ;
            }
            
         // recherche et suppression du client dont le nom et prenom ont été saisi
            for (int i = 0; i < tableClients.getRowCount(); i++) {
                Object nomRow = tableClients.getValueAt(i, 0);
                Object prenomRow = tableClients.getValueAt(i, 1);
                if ( nomClient.equals( ((String)nomRow) ) && prenomClient.equals( ((String)prenomRow) ) ) {
                    monMagasin.supprimerClient( monMagasin.rechercherClient((String)nomRow)) ;
                }
            }
        }
		
	}

}
