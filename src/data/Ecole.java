/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author Mikhali
 */
public class Ecole extends idClasse {

    String nom;
    ArrayList<AnneeScolaire> annee;
    ArrayList<Trimestre> trimestre;
    ArrayList<Niveau> niveau;
    ArrayList<Classe> classe;
    ArrayList<Discipline> discipline;
    ArrayList<Personne> personne;
    ArrayList<Enseignement> enseignement;
    ArrayList<Inscription> inscription;
    ArrayList<Bulletin> bulletin;
    ArrayList<DetailBulletin> detail;
    ArrayList<Evaluation> evaluation;
    
    Ecole(){
        
    }
    
    public void getmine(AnneeScolaire a, ArrayList<Trimestre> myTrimestre, ArrayList<Classe> myClasse){
        
        for(int i = 0 ; i<trimestre.size() ; i++)
        {
            if(trimestre.get(i).getidAnnee() == a.getid()){
                myTrimestre.add(trimestre.get(i));
            }
        }
        
        for(int i = 0 ; i<classe.size() ; i++)
        {
            if(classe.get(i).getidAnnee() == a.getid()){
                myClasse.add(classe.get(i));
            }
        }
    }
    
    public void getmine(Niveau a, ArrayList<Classe> myClasse){
        
        for(int i = 0 ; i<classe.size() ; i++)
        {
            if(classe.get(i).getidNiveau() == a.getid()){
                myClasse.add(classe.get(i));
            }
        }
    }
    
    public void getmine(Classe a, ArrayList<Enseignement> myEnseignement, ArrayList<Inscription> myInscription){
        
        for(int i = 0 ; i<enseignement.size() ; i++)
        {
            if(enseignement.get(i).getidClasse() == a.getid()){
                myEnseignement.add(enseignement.get(i));
            }
        }
        
        for(int i = 0 ; i<inscription.size() ; i++)
        {
            if(inscription.get(i).getidClasse() == a.getid()){
                myInscription.add(inscription.get(i));
            }
        }
    }
    
    public void getmine(Discipline a, ArrayList<Enseignement> myEnseignement){
        
        for(int i = 0 ; i<enseignement.size() ; i++)
        {
            if(enseignement.get(i).getidDiscipline() == a.getid()){
                myEnseignement.add(enseignement.get(i));
            }
        }
    }
    
    public void getmine(Personne a, ArrayList<Enseignement> myEnseignement, ArrayList<Inscription> myInscription){
        
        for(int i = 0 ; i<enseignement.size() ; i++)
        {
            if(enseignement.get(i).getidPersonne() == a.getid()){
                myEnseignement.add(enseignement.get(i));
            }
        }
        
        for(int i = 0 ; i<inscription.size() ; i++)
        {
            if(inscription.get(i).getidPersonne() == a.getid()){
                myInscription.add(inscription.get(i));
            }
        }
    }
    
    public void getmineEns(Personne a, ArrayList<Enseignement> myEnseignement){
        
        for(int i = 0 ; i<enseignement.size() ; i++)
        {
            if(enseignement.get(i).getidPersonne() == a.getid()){
                myEnseignement.add(enseignement.get(i));
            }
        }
    }
    
    public void getmineIns(Personne a, ArrayList<Inscription> myInscription){
        
        for(int i = 0 ; i<inscription.size() ; i++)
        {
            if(inscription.get(i).getidPersonne() == a.getid()){
                myInscription.add(inscription.get(i));
            }
        }
    }
    
    public void getmine(Trimestre a, ArrayList<Bulletin> myBulletin){
        
        for(int i = 0 ; i<bulletin.size() ; i++)
        {
            if(bulletin.get(i).getidTrimestre() == a.getid()){
                myBulletin.add(bulletin.get(i));
            }
        }
    }
    
    public void getmine(Inscription a, ArrayList<Bulletin> myBulletin){
        
        for(int i = 0 ; i<bulletin.size() ; i++)
        {
            if(bulletin.get(i).getidInscription() == a.getid()){
                myBulletin.add(bulletin.get(i));
            }
        }
    }
    
    public void getmine(Enseignement a, ArrayList<DetailBulletin> myDetailBulletin){
        
        for(int i = 0 ; i<detail.size() ; i++)
        {
            if(detail.get(i).getidEnseignement() == a.getid()){
                myDetailBulletin.add(detail.get(i));
            }
        }
    }
    
    public void getmine(Bulletin a, ArrayList<DetailBulletin> myDetailBulletin){
        
        for(int i = 0 ; i<detail.size() ; i++)
        {
            if(detail.get(i).getidBulletin() == a.getid()){
                myDetailBulletin.add(detail.get(i));
            }
        }
    }
    
    public void getmine(DetailBulletin a, ArrayList<Evaluation> myEvaluation){
        
        for(int i = 0 ; i<evaluation.size() ; i++)
        {
            if(evaluation.get(i).getidDetailBulletin() == a.getid()){
                myEvaluation.add(evaluation.get(i));
            }
        }
    }
    
    public void seek()
    
}