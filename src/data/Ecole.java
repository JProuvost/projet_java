/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.HashMap;

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
    
    public HashMap<String,idClasse> whoamI(Classe a){
        
        HashMap<String,idClasse> I = new HashMap<>();
        
        for(int i = 0 ; i<niveau.size() ; i++)
        {
            if(niveau.get(i).getid() == a.getidNiveau()){
                I.put("Niveau", niveau.get(i));
            }
        }
        
        for(int i = 0 ; i<annee.size() ; i++)
        {
            if(annee.get(i).getid() == a.getidAnnee()){
                I.put("AnneeScolaire", annee.get(i));
            }
        }
        
        return I;
    }
    
     public HashMap<String,idClasse> whoamI(Enseignement a){
        
        HashMap<String,idClasse> I = new HashMap<>();
        
        for(int i = 0 ; i<classe.size() ; i++)
        {
            if(classe.get(i).getid() == a.getidClasse()){
                I.put("Classe", classe.get(i));
            }
        }
        
        for(int i = 0 ; i<discipline.size() ; i++)
        {
            if(discipline.get(i).getid() == a.getidDiscipline()){
                I.put("Discipline", discipline.get(i));
            }
        }
        
        for(int i = 0 ; i<personne.size() ; i++)
        {
            if(personne.get(i).getid() == a.getidPersonne()){
                I.put("Personne", personne.get(i));
            }
        }
        
        return I;
    }
    
     public HashMap<String,idClasse> whoamI(Trimestre a){
        
        HashMap<String,idClasse> I = new HashMap<>();
        
        for(int i = 0 ; i<annee.size() ; i++)
        {
            if(annee.get(i).getid() == a.getidAnnee()){
                I.put("AnneeScolaire", annee.get(i));
            }
        }
        
        return I;
    }
     
    public HashMap<String,idClasse> whoamI(Inscription a){
        
        HashMap<String,idClasse> I = new HashMap<>();
        
        for(int i = 0 ; i<classe.size() ; i++)
        {
            if(classe.get(i).getid() == a.getidClasse()){
                I.put("Classe", classe.get(i));
            }
        }
        
        for(int i = 0 ; i<personne.size() ; i++)
        {
            if(personne.get(i).getid() == a.getidPersonne()){
                I.put("Personne", personne.get(i));
            }
        }
        
        return I;
    }
    
    public HashMap<String,idClasse> whoamI(Bulletin a){
        
        HashMap<String,idClasse> I = new HashMap<>();
        
        for(int i = 0 ; i<inscription.size() ; i++)
        {
            if(inscription.get(i).getid() == a.getidInscription()){
                I.put("Inscription", inscription.get(i));
            }
        }
        
        for(int i = 0 ; i<trimestre.size() ; i++)
        {
            if(trimestre.get(i).getid() == a.getidTrimestre()){
                I.put("Trimestre", trimestre.get(i));
            }
        }
        
        return I;
    }
    
    public HashMap<String,idClasse> whoamI(DetailBulletin a){
        
        HashMap<String,idClasse> I = new HashMap<>();
        
        for(int i = 0 ; i<bulletin.size() ; i++)
        {
            if(bulletin.get(i).getid() == a.getidBulletin()){
                I.put("Bulletin", bulletin.get(i));
            }
        }
        
        for(int i = 0 ; i<enseignement.size() ; i++)
        {
            if(enseignement.get(i).getid() == a.getidEnseignement()){
                I.put("Enseignement", enseignement.get(i));
            }
        }
        
        return I;
    }
    
    public HashMap<String,idClasse> whoamI(Evaluation a){
        
        HashMap<String,idClasse> I = new HashMap<>();
        
        for(int i = 0 ; i<detail.size() ; i++)
        {
            if(detail.get(i).getid() == a.getidDetailBulletin()){
                I.put("DetailBulletin", detail.get(i));
            }
        }
        
        return I;
    }
    
    public void supprAnnee(int id){
        
        int i = 0;
        
        while(i<annee.size())
        {
            if(annee.get(i).getid() == id){
               annee.remove(i);
               i = annee.size();
            }
            i++;
        }
    }
    
    public void supprTrimestre(int id){
        
        int i = 0;
        
        while(i<trimestre.size())
        {
            if(trimestre.get(i).getid() == id){
               trimestre.remove(i);
               i = trimestre.size();
            }
            i++;
        }
    }
    
    public void supprNiveau(int id){
        
        int i = 0;
        
        while(i<niveau.size())
        {
            if(niveau.get(i).getid() == id){
               niveau.remove(i);
               i = niveau.size();
            }
            i++;
        }
    }
    
    public void supprClasse(int id){
        
        int i = 0;
        
        while(i<classe.size())
        {
            if(classe.get(i).getid() == id){
               classe.remove(i);
               i = classe.size();
            }
            i++;
        }
    }
    
    public void supprDiscipline(int id){
        
        int i = 0;
        
        while(i<discipline.size())
        {
            if(discipline.get(i).getid() == id){
               discipline.remove(i);
               i = discipline.size();
            }
            i++;
        }
    }
    
    public void supprPersonne(int id){
        
        int i = 0;
        
        while(i<personne.size())
        {
            if(personne.get(i).getid() == id){
               personne.remove(i);
               i = personne.size();
            }
            i++;
        }
    }
    
    public void supprEnseignement(int id){
        
        int i = 0;
        
        while(i<enseignement.size())
        {
            if(enseignement.get(i).getid() == id){
               enseignement.remove(i);
               i = enseignement.size();
            }
            i++;
        }
    }
    
    public void supprInscription(int id){
        
        int i = 0;
        
        while(i<inscription.size())
        {
            if(inscription.get(i).getid() == id){
               inscription.remove(i);
               i = inscription.size();
            }
            i++;
        }
    }
    
    public void supprBulletin(int id){
        
        int i = 0;
        
        while(i<bulletin.size())
        {
            if(bulletin.get(i).getid() == id){
               bulletin.remove(i);
               i = bulletin.size();
            }
            i++;
        }
    }
    
    public void supprDetail(int id){
        
        int i = 0;
        
        while(i<detail.size())
        {
            if(detail.get(i).getid() == id){
               detail.remove(i);
               i = detail.size();
            }
            i++;
        }
    }
    
    public void supprEvaluation(int id){
        
        int i = 0;
        
        while(i<evaluation.size())
        {
            if(evaluation.get(i).getid() == id){
               evaluation.remove(i);
               i = evaluation.size();
            }
            i++;
        }
    }
    
    public void addAnnee(int id){
        annee.add(new AnneeScolaire(id));
    }
}