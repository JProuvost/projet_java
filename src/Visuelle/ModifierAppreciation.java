/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visuelle;

import data.Bulletin;
import data.DetailBulletin;
import data.Evaluation;
import data.Inscription;
import data.Personne;
import static visuelle.Fenetre.content;
import static visuelle.Fenetre.e;

/**
 *
 * @author Jean
 */
public class ModifierAppreciation extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    public ModifierAppreciation(int id, String type) {
        this.id=id;
        this.type=type;
        initComponents();
    }
    
    
    private void initComponents() {

        home = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        fappreciation = new javax.swing.JTextField();
        valider = new javax.swing.JButton();

        home.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        home.setText("Home");
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Appréciation :");

        fappreciation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fappreciationActionPerformed(evt);
            }
        });

        valider.setText("Valider");
        valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fappreciation, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(152, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(valider, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(fappreciation, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(valider, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );
    }                      

    private void fappreciationActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        appreciation=fappreciation.getText();
    }                                             

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        Fenetre.changePanel("accueil");
    }                                    

    private void validerActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here
        appreciation=fappreciation.getText();
        e.modappre(id, type, appreciation);
        switch(type){
            case "Detail":
                try{
                    DetailBulletin detail=e.seekerDetail(id);
                    Bulletin bulletin=(Bulletin)e.whoamI(detail).get("Bulletin");
                    content.add(new VoirBulletin(bulletin.getid()),"VoirBulletin");
                    Fenetre.changePanel("VoirBulletin");
                }catch(Exception e){}
                break;
            case "Bulletin":
                System.out.println("bite");
                try{Bulletin bulletin=e.seekerBulletin(id);
                System.out.println("bite");
                Personne eleve=(Personne)e.whoamI((Inscription)e.whoamI(bulletin).get("Inscription")).get("Personne");
                System.out.println("bite");
                content.add(new VoirEleve(eleve.getid()),"VoirEleve");
                System.out.println("bite");
                Fenetre.changePanel("VoirEleve");}catch(Exception e){}
                break;
            case "Evaluation":
                try{
                    Evaluation evaluation= e.seekerEvaluation(id);
                    DetailBulletin detail=(DetailBulletin)e.whoamI(evaluation).get("Detail");
                    content.add(new VoirDetail(detail.getid()),"VoirDetail");
                    Fenetre.changePanel("VoirDetail");
                }catch(Exception e){}
                break;
        }
    }                                       


    // Variables declaration - do not modify       
    private int id;
    private String type;
    private String appreciation="";
    private javax.swing.JTextField fappreciation;
    private javax.swing.JButton home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton valider;
    // End of variables declaration                   
}
