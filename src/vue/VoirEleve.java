/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import data.AnneeScolaire;
import data.Bulletin;
import data.Classe;
import data.Enseignement;
import data.Inscription;
import data.Niveau;
import data.Personne;
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
public class VoirEleve extends javax.swing.JPanel {

    public VoirEleve(int a) {
        
        initComponents(a);
    }
                         
    private void initComponents(int a) {

        home = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        // The 0 argument is number rows.
        JTable table = new JTable(tableModel);
        JScrollPane scroll= new JScrollPane(table);
        try{
            Inscription inscription=ecole.seekerInscription(a);
            Personne etudiant=(Personne)ecole.whoamI(inscription).get("Personne");
            String info;
            info =etudiant.getprenom()+" "+etudiant.getnom()+"      "+annee;
            jLabel1.setText(info);
            ArrayList<Bulletin> bulletins = null;
            ecole.getmine(inscription, bulletins);
            for(int i=0;i<bulletins.size();i++)
            {
                int id=bulletins.get(i).getid();
                String nom = "T"+i;
                double moyenne=ecole.MoyenneBulletin(id);
                String appreciation = bulletins.get(i).getappreciation();
                Object[] data={id,nom,moyenne,appreciation,"Voir plus"};
                tableModel.addRow(data);
            }
            
        }catch(Exception e){System.out.println("Erreur lors de la récupération de l'élève");}

        Action selectbulletin = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                int modelRow = Integer.valueOf( e.getActionCommand() );
                content.add(new VoirBulletin((int) table.getModel().getValueAt(modelRow,0)),"VoirBulletin");
                Fenetre.changePanel("VoirBulletin");
        }
    };
 
        ButtonColumn buttonColumn2 = new ButtonColumn(table,selectbulletin , 4);
        buttonColumn2.setMnemonic(KeyEvent.VK_D);
        
        home.setText("Home");
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
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
                    )
                .addContainerGap()
                .addComponent(scroll)
                .addContainerGap(10, Short.MAX_VALUE))
        );
    }                                                                

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        Fenetre.changePanel("accueil");
    }                                    
    
                     
    private javax.swing.JButton home;
    private javax.swing.JLabel jLabel1;
    private String[] columnNames = {"id","Trimestre","moyenne","appréciation","Voir détail"};
    // End of variables declaration                   
}
