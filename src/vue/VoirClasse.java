/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import data.AnneeScolaire;
import data.Classe;
import data.Niveau;
import data.Trimestre;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static vue.Fenetre.content;
import static vue.Fenetre.ecole;
import static vue.Selannee.annee;
import javax.swing.JScrollPane;
/**
 *
 * @author Jean
 */
public class VoirClasse extends javax.swing.JPanel {

    /**
     * Creates new form panelvoirclasse
     */
    public VoirClasse() {
        
        initComponents();
    }
                         
    private void initComponents() {

        home = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ajouterClasse = new javax.swing.JButton();
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        // The 0 argument is number rows.
        JTable table = new JTable(tableModel);
        JScrollPane scroll= new JScrollPane(table);
        ArrayList<Classe> alClasses = null;
        ArrayList<Trimestre> trimestres = null;
        String afficher = "afficher";
        ecole.addAnnee();
        try{ecole.getmine(ecole.seekerAnnee(2018), trimestres,alClasses);
        for(Classe elem: alClasses){
            int id = elem.getid();
            String nomniveau;
            String nom= elem.getnom();
            int idNiveau = elem.getidNiveau();
            try{Niveau niveau = ecole.seekerNiveau(idNiveau);
            nomniveau=niveau.getnom();}
            catch(Exception e){nomniveau="";}
            Object[] data ={id,nom,nomniveau,afficher,afficher};
            tableModel.addRow(data);
        }
        }catch(Exception e){}
        Action selectprofesseur = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                int modelRow = Integer.valueOf( e.getActionCommand() );
                content.add(new VoirLProf((int) table.getModel().getValueAt(modelRow,0)),"VoirLProf");
                Fenetre.changePanel("VoirLProf");
            }
        };
 
        ButtonColumn buttonColumn = new ButtonColumn(table, selectprofesseur, 3);
        buttonColumn.setMnemonic(KeyEvent.VK_D);

        Action selecteleve = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                int modelRow = Integer.valueOf( e.getActionCommand() );
                content.add(new VoirLEleve((int) table.getModel().getValueAt(modelRow,0)),"VoirLEleve");
                Fenetre.changePanel("VoirLEleve");
        }
    };
 
        ButtonColumn buttonColumn2 = new ButtonColumn(table,selecteleve , 4);
        buttonColumn2.setMnemonic(KeyEvent.VK_D);
        
        home.setText("Home");
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });
        
        jLabel1.setText("Liste des classes         "+annee);

        ajouterClasse.setText("Ajouter Classe");
        ajouterClasse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterClasseActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(scroll)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ajouterClasse, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(home)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(home)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ajouterClasse))
                .addContainerGap()
                .addComponent(scroll)
                .addContainerGap(10, Short.MAX_VALUE))
        );
    }                        

    private void ajouterClasseActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        Fenetre.changePanel("accueil");
    }                                    
    
                     
    
    private javax.swing.JButton ajouterClasse;
    private javax.swing.JButton home;
    private javax.swing.JLabel jLabel1;
    private String[] columnNames = {"id","Nom","Niveau","Afficher Professeur","Afficher eleves"};
    // End of variables declaration                   
}
