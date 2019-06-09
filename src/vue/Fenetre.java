/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import data.Ecole;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame{

  private static CardLayout cl = new CardLayout();
  public static JPanel content = new JPanel();
  public static Ecole ecole = new Ecole();
  Page accueil = new Page();
  Selannee selannee = new Selannee();
  VoirClasse voirClasse = new VoirClasse();
  //Liste des noms de nos conteneurs pour la pile de cartes

  public Fenetre(){
    
    this.setTitle("Gestion d'école");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
		
    //On crée trois conteneurs de couleur différente		
    
    JPanel boutonPane = new JPanel();
    JButton bouton = new JButton("Contenu suivant");
    //Définition de l'action du bouton
    bouton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
        //Via cette instruction, on passe au prochain conteneur de la pile
        cl.next(content);
      }
    });
    
    boutonPane.add(bouton);
    //On définit le layout
    content.setLayout(cl);
    //On ajoute les cartes à la pile avec un nom pour les retrouver
    content.add(accueil.get_panel(), "accueil");
    content.add(selannee, "selannee");
    content.add(voirClasse,"voirClasse");
    
    this.getContentPane().add(boutonPane, BorderLayout.NORTH);
    this.getContentPane().add(content, BorderLayout.CENTER);
    this.setVisible(true);
  }
  public static void changePanel(String a)
    {
        cl.show(content,a);
    }
}