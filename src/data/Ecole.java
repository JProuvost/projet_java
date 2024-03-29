/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
//DAO A MODIFIER SI JAMAIS CA BUG LORS DU GROS MERGE !!!!
import java.util.ArrayList;
import java.util.HashMap;
import Connexion.*;
import java.sql.SQLException;
import jdbcv2018.Connexion;
/**
 *
 * @author Mikhali
 */
public class Ecole{

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
    
    public Ecole(){
        annee = new ArrayList<>();
        annee.add(new AnneeScolaire(2017));
        trimestre = new ArrayList<>();
        trimestre.add(new Trimestre());
        niveau = new ArrayList<>();
        niveau.add(new Niveau());
        classe = new ArrayList<>();
        classe.add(new Classe());
        discipline = new ArrayList<>();
        discipline.add(new Discipline());
        personne = new ArrayList<>();
        personne.add(new Personne());
        enseignement = new ArrayList<>();
        enseignement.add(new Enseignement());
        inscription = new ArrayList<>();
        inscription.add(new Inscription());
        bulletin = new ArrayList<>();
        bulletin.add(new Bulletin());
        detail = new ArrayList<>();
        detail.add(new DetailBulletin());
        evaluation = new ArrayList<>();
        evaluation.add(new Evaluation());
        init();
    }
    /**
     * initialise toutes les arraylist
     */
    public void init(){
        try{
            Connexion connexion = new Connexion("ecole","root","");
            DAO<AnneeScolaire> anneescolaireDAO= new AnneeScolaireDAO(connexion);
            DAO<Bulletin> bulletinDAO= new BulletinDAO(connexion);
            DAO<Classe> classeDAO= new ClasseDAO(connexion);
            DAO<DetailBulletin> detailbulletinDAO= new DetailBulletinDAO(connexion);
            DAO<Discipline> disciplineDAO= new DisciplineDAO(connexion);
            DAO<Trimestre> trimestreDAO= new TrimestreDAO(connexion);
            DAO<Enseignement> enseignementDAO= new EnseignementDAO(connexion);
            DAO<Evaluation> evaluationDAO= new EvaluationDAO(connexion);
            DAO<Inscription> inscriptionDAO= new InscriptionDAO(connexion);
            DAO<Niveau> niveauDAO= new NiveauDAO(connexion);
            DAO<Personne> personneDAO= new PersonneDAO(connexion);
            
            annee = anneescolaireDAO.tout();
            trimestre = trimestreDAO.tout();            
            niveau = niveauDAO.tout();            
            classe = classeDAO.tout();            
            discipline = disciplineDAO.tout();          
            personne = personneDAO.tout();           
            enseignement = enseignementDAO.tout();           
            inscription = inscriptionDAO.tout();            
            bulletin= bulletinDAO.tout();
            
            detail = detailbulletinDAO.tout();
            evaluation = evaluationDAO.tout();
            
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    //get mine
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
    
    
    //who am I ?
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
    
    
    //suppression
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
    
    
    //ajout
    public void addAnnee(){
        int c = annee.size()-1;
        int id = annee.get(c).getid()+1;
        AnneeScolaire a= new AnneeScolaire(id);
        annee.add(a);
        addTrimestre(1, "7 septembre", "20 decembre", id);
        addTrimestre(2, "6 janvier", "21 mars", id);
        addTrimestre(3, "7 avril", "25 juin", id);
        try{
            Connexion connexion = new Connexion("ecole","root","");
            DAO<AnneeScolaire> asDAO = new AnneeScolaireDAO(connexion);
            asDAO.create(a);
        }catch(Exception e){
            System.out.println("Erreur de connexion à la BDD.");
        }
    }
    
    public void addBulletin(int idIns, int idTri, String appre){
        
        int id=bulletin.size();
        Bulletin a = new Bulletin(id, idIns, idTri, appre);
        bulletin.add(a);
        ArrayList<Enseignement> ens = new ArrayList<>();
        
        if(appre == ""){appre = "-";}
        
        try{
            Inscription ins = seekerInscription(idIns);
            HashMap<String,idClasse> insis = whoamI(ins);
            Classe c = (Classe)insis.get("Classe");
            getmine(c,ens, new ArrayList<>());
            try{
            Connexion connexion = new Connexion("ecole","root","");
            DAO<Bulletin> asDAO = new BulletinDAO(connexion);
            asDAO.create(a);
            }catch(Exception e){
                System.out.println("Erreur de connexion à la BDD.");
            }
        }catch(NotFoundException e){
            System.out.println("l'Inscritpion n'existe pas");
        }
        
        for(int i = 0; i<ens.size(); i++){
            addDetail(id, ens.get(i).getid()," ");
        }       
    }
    
    public void addClasse(String nom, int idNiveau, int idAnnee){
        int id = classe.size();
        Classe a= new Classe(id, nom,idNiveau, idAnnee);
        classe.add(a);
        try{
            Connexion connexion = new Connexion("ecole","root","");
            DAO<Classe> asDAO = new ClasseDAO(connexion);
            asDAO.create(a);
        }catch(Exception e){
            System.out.println("Erreur de connexion à la BDD.");
        }
    }
    
    public void addDetail(int idBull, int idEns, String appre){
        int id = detail.size();
        DetailBulletin a= new DetailBulletin(id, idBull, idEns, appre);
        detail.add(a);
        
        if(appre == ""){appre = "-";}
        
        try{
            Connexion connexion = new Connexion("ecole","root","");
            DAO<DetailBulletin> asDAO = new DetailBulletinDAO(connexion);
            asDAO.create(a);
            }catch(Exception e){
                System.out.println("Erreur de connexion à la BDD.");
            }
    }
    
    public void addDiscipline(String nom){
        int id = discipline.size();
        Discipline a = new Discipline(id, nom);
        discipline.add(a);
        try{
            Connexion connexion = new Connexion("ecole","root","");
            DAO<Discipline> asDAO = new DisciplineDAO(connexion);
            asDAO.create(a);
            }catch(Exception e){
                System.out.println("Erreur de connexion à la BDD.");
            }
    }
    
    public void addEnseignement(int idDisci, int idCla, int idPerso){
        int id = enseignement.size();
        Enseignement a = new Enseignement(id, idDisci, idCla,idPerso);
        enseignement.add(a);
        try{
            Connexion connexion = new Connexion("ecole","root","");
            DAO<Enseignement> asDAO = new EnseignementDAO(connexion);
            asDAO.create(a);
            }catch(Exception e){
                System.out.println("Erreur de connexion à la BDD.");
            }
    }
    
    public void addEvaluation(int idDeta, double note, String appre){
        int id = evaluation.size();
        Evaluation a= new Evaluation(id,idDeta, note, appre);
        evaluation.add(a);
        
        if(appre == ""){appre = "-";}
        
        try{
            Connexion connexion = new Connexion("ecole","root","");
            DAO<Evaluation> asDAO = new EvaluationDAO(connexion);
            asDAO.create(a);
            }catch(Exception e){
                System.out.println("Erreur de connexion à la BDD.");
            }
    }
    
    public void addInscription(int idCla, int idPerso){
        
        int id = inscription.size();
        Inscription a= new Inscription(id,idCla,idPerso);
        inscription.add(a);
        try{
            Connexion connexion = new Connexion("ecole","root","");
            DAO<Inscription> asDAO = new InscriptionDAO(connexion);
            asDAO.create(a);
            }catch(Exception e){
                System.out.println("Erreur de connexion à la BDD.");
            }
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
            addBulletin(id, T.get(i).getid(), " ");
        }
    }
    
    public void addNiveau(String nom){
        int id = niveau.size();
        Niveau a = new Niveau(id, nom);
        niveau.add(a);
        try{
            Connexion connexion = new Connexion("ecole","root","");
            DAO<Niveau> asDAO = new NiveauDAO(connexion);
            asDAO.create(a);
            }catch(Exception e){
                System.out.println("Erreur de connexion à la BDD.");
            }
    }
    
    
    public Personne addPersonne(String nom, String prenom, String type){
        int id = personne.size();
        Personne p = new Personne(id, nom, prenom, type);
        personne.add(p);
        try{
            Connexion connexion = new Connexion("ecole","root","");
            DAO<Personne> asDAO = new PersonneDAO(connexion);
            asDAO.create(p);
            }catch(Exception e){
                System.out.println("Erreur de connexion à la BDD.");
            }
        return p;
    }
    
    public void addTrimestre(int numero, String debut, String fin, int idA){
        int id = trimestre.size();
        System.out.println(id);
        Trimestre a = new Trimestre(id, numero,debut,fin,idA);
        trimestre.add(a);
        try{
            Connexion connexion = new Connexion("ecole","root","");
            DAO<Trimestre> asDAO = new TrimestreDAO(connexion);
            asDAO.create(a);
            }catch(Exception e){
                System.out.println("Erreur de connexion à la BDD.");
            }
    }
    
    public void addnewIns(int idClasse,String nom, String prenom){
        addInscription(idClasse, personne.size());
        addPersonne(nom,prenom,"Eleve");        
    } //doit etre modifié si blindage des createurs
    
    
    //seeker
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
    
    
    //moyenne & calcul divers
    public double MoyenneDetail(int id){
    
        double summ = 0;
        ArrayList<Evaluation> evals = new ArrayList<>();
        
        try{
            DetailBulletin d = seekerDetail(id);
            getmine(d,evals);
            if(evals.isEmpty()){
                return 0;
            }
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
    
    public double MoyenneEleve(int id){
        
        double summ = 0;
        ArrayList<Bulletin> bulletine = new ArrayList<>();
        
        try{
            Inscription d = seekerInscription(id);
            getmine(d,bulletine);
            for(int i = 0; i<bulletine.size(); i++){
                summ = summ + MoyenneBulletin(bulletine.get(i).getid());
            }
        }catch(NotFoundException e){
            System.out.println("Detail intouvable");
        }
        
        return summ/bulletine.size();
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
    
    public double MoyenneClasse(int id){
        double summ = 0;
        ArrayList<Inscription> eleve = new ArrayList<>();
        
        try{
            Classe d = seekerClasse(id);
            getmine(d, new ArrayList<Enseignement>(), eleve);
            for(int i = 0; i<eleve.size(); i++){
                summ = summ + MoyenneEleve(eleve.get(i).getid());
            }
        }catch(NotFoundException e){
            System.out.println("Detail intouvable");
        }
        
        return summ/eleve.size();
    }
    
    
    //misc
    public void modifierTrimestre(int idT, String debut, String fin){
        try{
            System.out.println(fin);
            seekerTrimestre(idT).changerdate(debut,fin);
            try{
            Connexion connexion = new Connexion("ecole","root","");
            DAO<Trimestre> asDAO = new TrimestreDAO(connexion);
            asDAO.update(seekerTrimestre(idT));
            }catch(Exception e){
                System.out.println("Erreur de connexion à la BDD.");
            }
            }catch(NotFoundException e){
            System.out.print("Le Trimestre n'existe pas");
        }
    }
    
    public void modappre(int id, String type, String mod){
        
        if(mod == ""){mod = "-";}
        
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
    public ArrayList<Discipline> getdiscipline(){
        return discipline;
    }
    public ArrayList<AnneeScolaire> getannee(){
        return annee;
    }
    
    public Classe getClasse(int id){
        return classe.get(id);
    }
    
    public ArrayList<Niveau> getniveau(){return niveau;}
    
    public ArrayList<Personne> getEleves(){
        ArrayList<Personne> toreturn = new ArrayList<>();
        for(int i = 0; i<personne.size(); i++){
            if("eleve".equals(personne.get(i).gettype())){
                toreturn.add(personne.get(i));
                System.out.println(toreturn.size());
            }
        }
        return toreturn;
    }
    
    public ArrayList<Personne> getProfs(){
        ArrayList<Personne> toreturn = new ArrayList<>();
        for(int i = 0; i<personne.size(); i++){
            if("enseignant".equals(personne.get(i).gettype())){
                toreturn.add(personne.get(i));
                System.out.println(toreturn.size());
            }
        }
        return toreturn;
    }
    
    //croisement d'Array
    public ArrayList<Classe> crossclasse(ArrayList<Classe> a,ArrayList<Classe> b){
        ArrayList<Classe> toreturn = new ArrayList<>();
        for(int i =0; i<a.size(); i++){
            for(int j = 0; j<b.size(); j++){
                if(a.get(i).getid() == b.get(j).getid()){
                    toreturn.add(a.get(i));
                }
            }
        }
        return toreturn;
    }
    
    public ArrayList<DetailBulletin> crossdetail(ArrayList<DetailBulletin> a,ArrayList<DetailBulletin> b){
        ArrayList<DetailBulletin> toreturn = new ArrayList<>();
        for(int i =0; i<a.size(); i++){
            for(int j = 0; j<b.size(); j++){
                if(a.get(i).getid() == b.get(j).getid()){
                    toreturn.add(a.get(i));
                }
            }
        }
        return toreturn;
    }
    
    public ArrayList<Personne> getpersonne(){
        return personne;
    }
    
    public ArrayList<Classe> getclasse(){
        return classe;
    }
    public ArrayList<Bulletin> getbulletin(){
        return bulletin;
    }
}
