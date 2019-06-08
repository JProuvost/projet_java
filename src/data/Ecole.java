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
        addTrimestre(trimestre.size(), 1, "7 septembre", "20 decembre", id);
        addTrimestre(trimestre.size(), 2, "6 janvier", "21 mars", id);
        addTrimestre(trimestre.size(), 3, "7 avril", "25 juin", id);
    }
    
    public void addBulletin(int id, int idIns, int idTri, String appre){
        
        bulletin.add(new Bulletin(id, idIns, idTri, appre));
        ArrayList<Enseignement> ens = new ArrayList<>();
        
        try{
            Inscription ins = seekerInscription(idIns);
            HashMap<String,idClasse> insis = whoamI(ins);
            Classe c = (Classe)insis.get("Classe");
            getmine(c,ens, new ArrayList<>());
        }catch(NotFoundException e){
            System.out.println("l'Inscritpion n'existe pas");
        }
        
        for(int i = 0; i<ens.size(); i++){
            addDetail(detail.size(), id, ens.get(i).getid(),"");
        }       
    }
    
    public void addClasse(int id, String nom, int idNiveau, int idAnnee){
        classe.add(new Classe(id, nom, idNiveau, idAnnee));
    }
    
    public void addDetail(int id, int idBull, int idEns, String appre){
        detail.add(new DetailBulletin(id, idBull, idEns, appre));
    }
    
    public void addDiscipline(int id, String nom){
        discipline.add(new Discipline(id, nom));
    }
    
    public void addEnseignement(int id, int idDisci, int idCla, int idPerso){
        enseignement.add(new Enseignement(id, idDisci, idCla, idPerso));
    }
    
    public void addEvaluation(int id, int idDeta, double note, String appre){
        evaluation.add(new Evaluation(id, idDeta, note, appre));
    }
    
    public void addInscription(int id, int idCla, int idPerso){
        
        inscription.add(new Inscription(id, idCla, idPerso));
        ArrayList<Trimestre> T = new ArrayList<>();
                
        try{
            Classe c = seekerClasse(idCla);
            HashMap<String, idClasse> cis = whoamI(c);
            AnneeScolaire y = (AnneeScolaire)cis.get("AnneeScolaire");
            getmine(y, T, new ArrayList<Classe>());
        }catch(NotFoundException e){
            System.out.println("la Classe n'existe pas");
        }
        
        for(int i=0; i<T.size(); i++){
            addBulletin(bulletin.size(), id, T.get(i).getid(), "");
        }
    }
    
    public void addNiveau(int id, String nom){
        niveau.add(new Niveau(id, nom));
    }
    
    public void addPersonne(int id, String nom, String prenom, String type){
        personne.add(new Personne(id, nom, prenom, type));
    }
    
    public void addTrimestre(int id, int numero, String debut, String fin, int idA){
        trimestre.add(new Trimestre(id, numero, debut, fin, idA));
    }
    
    public AnneeScolaire seekerAnnee(int a) throws NotFoundException{
        
        for(int i = 0; i<annee.size(); i++){
            if(annee.get(i).getid() == a){
                return annee.get(i);
            }
        }
        throw new NotFoundException();
    }
    
    public Bulletin seekerBulletin(int a) throws NotFoundException{
        
        for(int i = 0; i<bulletin.size(); i++){
            if(bulletin.get(i).getid() == a){
                return bulletin.get(i);
            }
        }
        throw new NotFoundException();
    }
    
    public Classe seekerClasse(int a) throws NotFoundException{
        
        for(int i = 0; i<classe.size(); i++){
            if(classe.get(i).getid() == a){
                return classe.get(i);
            }
        }
        throw new NotFoundException();
    }
    
    public DetailBulletin seekerDetail(int a) throws NotFoundException{
        
        for(int i = 0; i<detail.size(); i++){
            if(detail.get(i).getid() == a){
                return detail.get(i);
            }
        }
        throw new NotFoundException();
    }
    
    public Discipline seekerDiscipline(int a) throws NotFoundException{
        
        for(int i = 0; i<discipline.size(); i++){
            if(discipline.get(i).getid() == a){
                return discipline.get(i);
            }
        }
        throw new NotFoundException();
    }
    
    public Enseignement seekerEnseignement(int a) throws NotFoundException{
        
        for(int i = 0; i<enseignement.size(); i++){
            if(enseignement.get(i).getid() == a){
                return enseignement.get(i);
            }
        }
        throw new NotFoundException();
    }
    
    public Evaluation seekerEvaluation(int a) throws NotFoundException{
        
        for(int i = 0; i<evaluation.size(); i++){
            if(evaluation.get(i).getid() == a){
                return evaluation.get(i);
            }
        }
        throw new NotFoundException();
    }
    
    public Inscription seekerInscription(int a) throws NotFoundException{
        
        for(int i = 0; i<inscription.size(); i++){
            if(inscription.get(i).getid() == a){
                return inscription.get(i);
            }
        }
        throw new NotFoundException();
    }
    
    public Niveau seekerNiveau(int a) throws NotFoundException{
        
        for(int i = 0; i<niveau.size(); i++){
            if(niveau.get(i).getid() == a){
                return niveau.get(i);
            }
        }
        throw new NotFoundException();
    }
    
    public Personne seekerPersonne(int a) throws NotFoundException{
        
        for(int i = 0; i<personne.size(); i++){
            if(personne.get(i).getid() == a){
                return personne.get(i);
            }
        }
        throw new NotFoundException();
    }
    
    public Trimestre seekerTrimestre(int a) throws NotFoundException{
        
        for(int i = 0; i<trimestre.size(); i++){
            if(trimestre.get(i).getid() == a){
                return trimestre.get(i);
            }
        }
        throw new NotFoundException();
    }
    
    public void modifierTrimestre(int idT, String debut, String fin){
        try{
            seekerTrimestre(idT).changerdate(debut,fin);
            }catch(NotFoundException e){
            System.out.print("Le Trimestre n'existe pas");
        }
    }
    
    public double MoyenneDetail(int id){
    
        double summ = 0;
        ArrayList<Evaluation> evals = new ArrayList<>();
        
        try{
            DetailBulletin d = seekerDetail(id);
            getmine(d,evals);
            for(int i = 0; i<evals.size(); i++){
                summ = summ + evals.get(i).getnote();
            }
        }catch(NotFoundException e){
            System.out.println("Detail intouvable");
        }
        
        return summ/evals.size();
    }
    
    public double MoyenneBulletin(int id){
    
        double summ = 0;
        ArrayList<DetailBulletin> details = new ArrayList<>();
        
        try{
            Bulletin d = seekerBulletin(id);
            getmine(d,details);
            for(int i = 0; i<details.size(); i++){
                summ = summ + MoyenneDetail(details.get(i).getid());
            }
        }catch(NotFoundException e){
            System.out.println("Detail intouvable");
        }
        
        return summ/details.size();
    }
    
    public double MoyenneProf(int id){
    
        double summ = 0;
        ArrayList<DetailBulletin> details = new ArrayList<>();
        
        try{
            Enseignement d = seekerEnseignement(id);
            getmine(d,details);
            for(int i = 0; i<details.size(); i++){
                summ = summ + MoyenneDetail(details.get(i).getid());
            }
        }catch(NotFoundException e){
            System.out.println("Detail intouvable");
        }
        
        return summ/details.size();
    }
    
    public void modappre(int id, String type, String mod){
        switch (type) 
                        {
                            case "Bulletin":
                                try{
                                    seekerBulletin(id).modap(mod);
                                }catch(NotFoundException e){
                                    System.out.println("Le Bulletin n'existe pas");
                                }
                            break;
                                
                            case "Detail":
                                try{
                                    seekerDetail(id).modap(mod);
                                }catch(NotFoundException e){
                                    System.out.println("Le Detail de Bulletin n'existe pas");
                                }
                            break;
                                
                            case "Evaluation":
                                try{
                                    seekerEvaluation(id).modap(mod);
                                }catch(NotFoundException e){
                                    System.out.println("L'Evaluation n'existe pas");
                                }
                            break;
                                
                            default:
                                System.out.println("verifiez le nom du choix");
                                break;
                        }
    }
    
}