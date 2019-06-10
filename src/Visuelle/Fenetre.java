/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visuelle;

import data.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Stat.*;

public class Fenetre extends JFrame{

  private static CardLayout cl = new CardLayout();
  public static JPanel content = new JPanel();
  public static Ecole e = new Ecole();
  
  //Liste des noms de nos conteneurs pour la pile de cartes

  public Fenetre(){
    
    Page accueil = new Page();  
    this.setTitle("Gestion d'école");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setSize(1000,800);
    //On crée trois conteneurs de couleur différente		
   
    
    //On définit le layout
    content.setLayout(cl);
    content.setSize(1500, 500);
    //On ajoute les cartes à la pile avec un nom pour les retrouver
    content.add(accueil, "accueil");
    this.getContentPane().add(content, BorderLayout.CENTER);
    this.setVisible(true);
  }
  public static void changePanel(String a)
    {
        cl.show(content,a);
    }
}