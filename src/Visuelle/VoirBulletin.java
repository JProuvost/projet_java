/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visuelle;

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
import static visuelle.Fenetre.content;
import static visuelle.Fenetre.e;
import static visuelle.Selannee.annee;
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
            Bulletin bulletin=e.seekerBulletin(a);
            Personne etudiant=(Personne)e.whoamI((Inscription)e.whoamI(bulletin).get("Inscription")).get("Personne");
            Trimestre trimestre=(Trimestre)e.whoamI(bulletin).get("Trimestre");
            String info;
            info=etudiant.getnom()+" "+etudiant.getprenom()+" T"+trimestre.getnumero()+"      "+annee;
            jLabel1.setText(info);
            ArrayList<DetailBulletin> detailbulletins = new ArrayList<>();
            e.getmine(bulletin, detailbulletins);
            for(DetailBulletin elem: detailbulletins)
            {
                int id=elem.getid();
                String discipline=e.seekerDiscipline(e.seekerEnseignement(elem.getidEnseignement()).getidDiscipline()).getnom();
                double moyenne = e.MoyenneDetail(elem.getid());
                String appreciation = elem.getappreciation();
                Object[] data={id,discipline,moyenne,"Voir plus",appreciation,"Modifier appréciation"};
                tableModel.addRow(data);
            }
            
        }catch(Exception e){System.out.println("Erreur lors de la récupération de la discipline");}
        
        Action modifierappreciation = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                int modelRow = Integer.valueOf( e.getActionCommand() );
                content.add(new ModifierAppreciation((int) table.getModel().getValueAt(modelRow,0),"Detail"),"ModifierAppreciationdetail");
                Fenetre.changePanel("ModifierAppreciationdetail");
        }
    };
 
        ButtonColumn buttonColumn = new ButtonColumn(table,modifierappreciation , 5);
        buttonColumn.setMnemonic(KeyEvent.VK_D);
        
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
        
        home.setText("home");
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
    private String[] columnNames = {"id","Discipline","moyenne","Voir plus","Appréciation","Modifier appréciation"};
    // End of variables declaration                   
}
