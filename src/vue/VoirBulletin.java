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
import data.DetailBulletin;
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
public class VoirBulletin extends javax.swing.JPanel {

    public VoirBulletin(int a) {
        
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
            Bulletin bulletin=ecole.seekerBulletin(a);
            Personne etudiant=(Personne)ecole.whoamI((Inscription)ecole.whoamI(bulletin).get("Inscription")).get("Personne");
            Trimestre trimestre=(Trimestre)ecole.whoamI(bulletin).get("Trimestre");
            String info;
            info=etudiant.getnom()+" "+etudiant.getprenom()+" T"+trimestre.getnumero()+"      "+annee;
            jLabel1.setText(info);
            ArrayList<DetailBulletin> detailbulletins = null;
            ecole.getmine(bulletin, detailbulletins);
            for(DetailBulletin elem: detailbulletins)
            {
                int id=elem.getid();
                String discipline=ecole.seekerDiscipline(ecole.seekerEnseignement(elem.getidEnseignement()).getidDiscipline()).getnom();
                double moyenne = ecole.MoyenneDetail(elem.getid());
                String appreciation = elem.getappreciation();
                Object[] data={id,discipline,moyenne,"Voir plus",appreciation};
                tableModel.addRow(data);
            }
            
        }catch(Exception e){System.out.println("Erreur lors de la récupération de la discipline");}

        Action selectdetail = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                int modelRow = Integer.valueOf( e.getActionCommand() );
                content.add(new VoirDetail((int) table.getModel().getValueAt(modelRow,0)),"VoirDetail");
                Fenetre.changePanel("VoirDetail");
            }
    };
 
        ButtonColumn buttonColumn2 = new ButtonColumn(table,selectdetail , 3);
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
    private String[] columnNames = {"id","Discipline","moyenne","Voir plus","Appréciation"};
    // End of variables declaration                   
}
