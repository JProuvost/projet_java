/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connexion;
import java.sql.SQLException;
import jdbcv2018.Connexion;
import java.util.ArrayList;
import data.*;
/**
 *
 * @author Jean
 */
public class EnseignementDAO extends DAO<Enseignement>{
    public EnseignementDAO(Connexion conn){
        super(conn);
    }
    @Override
    public boolean create(Enseignement as)
    {
        try{
            connexion.executeUpdate("INSERT INTO enseignement (idenseignement, iddiscipline, idclasse, idpersonne) VALUES ("+as.getid()+", "+as.getidDiscipline()+", "+as.getidClasse()+", "+as.getidPersonne()+")");
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public boolean delete(Enseignement as)
    {
        try{connexion.executeUpdate("DELETE FROM enseignement WHERE idenseignement="+as.getid());
        return true;
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public boolean update(Enseignement as)
    {
        try{
            connexion.executeUpdate("UPDATE enseignement SET iddiscipline="+as.getidDiscipline()+", idclasse="+as.getidClasse()+", idpersonne="+as.getidPersonne()+" WHERE idenseignement="+as.getid());
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public ArrayList<Enseignement> tout()
    {
        ArrayList<Enseignement> a = new ArrayList<>();
        a.add(new Enseignement());
        try{
            ArrayList<String>results=connexion.remplirChampsRequete("SELECT * FROM enseignement");
            for(String elem:results)
            {
                String[] result=elem.split(",");
                a.add(new Enseignement(Integer.parseInt(result[0]),Integer.parseInt(result[1]),Integer.parseInt(result[2]),Integer.parseInt(result[3])));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return a;
    }
    /*@Override
    public Enseignement find(int id)
    {
        Enseignement a = new Enseignement();
        try{
            String result = (String) connexion.remplirChampsRequete("SELECT * FROM enseignement WHERE idenseignement="+id).get(0);
            String[] elements =result.split(",");
            a = new Enseignement(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]), Integer.parseInt(elements[2]), Integer.parseInt(elements[3]));
        }catch (Exception e){
            System.out.println("L'enseignement cherché n'existe pas.");
        }
        return a;
    }*/
}
