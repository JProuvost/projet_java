/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visuelle;

import static visuelle.Fenetre.content;

/**
 *
 * @author Mikhali
 */
public class EleveCommun extends javax.swing.JPanel {

    /**
     * Creates new form EleveComment
     */
    public EleveCommun(int a) {
        idclasse=a;
        initComponents();
    }

                           
    private void initComponents() {

        ElevePasEnregistré = new javax.swing.JButton();
        EleveEnregistré = new javax.swing.JButton();

        ElevePasEnregistré.setText("Eleve Non-Enregistré");
        ElevePasEnregistré.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ElevePasEnregistréActionPerformed(evt);
            }
        });

        EleveEnregistré.setText("Eleve deja Enregistré");
        EleveEnregistré.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EleveEnregistré2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(ElevePasEnregistré, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(EleveEnregistré, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EleveEnregistré, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ElevePasEnregistré, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(106, Short.MAX_VALUE))
        );
    }                       

    private void ElevePasEnregistréActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        content.add(new addElevePasInscrit(idclasse),"addElevePasInscrit");
        Fenetre.changePanel("addElevePasInscrit");
    }                                        

    private void EleveEnregistré2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        content.add(new visuelle.AjouterEleveRelou(idclasse),"AjouterEleveRelou");
        Fenetre.changePanel("AjouterEleveRelou"); 
    }                                        


    // Variables declaration - do not modify         
    private int idclasse;
    private javax.swing.JButton ElevePasEnregistré;
    private javax.swing.JButton EleveEnregistré;
    // End of variables declaration                   
}