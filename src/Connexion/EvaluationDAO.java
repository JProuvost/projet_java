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
public class EvaluationDAO extends DAO<Evaluation>{
    public EvaluationDAO(Connexion conn){
        super(conn);
    }
    @Override
    public boolean create(Evaluation as)
    {
        try{
            connexion.executeUpdate("INSERT INTO evaluation (idevaluation, note, appreciation, iddetail) VALUES ("+as.getid()+", "+as.getnote()+", '"+as.getappreciation()+"', "+as.getidDetailBulletin()+")");
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public boolean delete(Evaluation as)
    {
        try{connexion.executeUpdate("DELETE FROM evaluation WHERE idevaluation="+as.getid());
        return true;
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public boolean update(Evaluation as)
    {
        try{
            connexion.executeUpdate("UPDATE evaluation SET note="+as.getnote()+", appreciation='"+as.getappreciation()+"', iddetail="+as.getidDetailBulletin()+" WHERE idevaluation="+as.getid());
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public ArrayList<Evaluation> tout()
    {
        ArrayList<Evaluation> a = new ArrayList<>();
        a.add(new Evaluation());
        try{
            ArrayList<String>results=connexion.remplirChampsRequete("SELECT * FROM detailbulletin");
            for(String elem:results)
            {
                String[] result=elem.split(",");
                a.add(new Evaluation(Integer.parseInt(result[0]),Integer.parseInt(result[1]),Float.parseFloat(result[2]),result[3]));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return a;
    }
    /*@Override
    public Evaluation find(int id)
    {
        Evaluation a = new Evaluation();
        try{
            String result = (String) connexion.remplirChampsRequete("SELECT * FROM evaluation WHERE idevaluation="+id).get(0);
            String[] elements =result.split(",");
            a = new Evaluation(Integer.parseInt(elements[0]), Float.parseFloat(elements[1]), elements[2], Integer.parseInt(elements[3]));
        }catch (Exception e){
            System.out.println("L'évaluation cherchée n'existe pas.");
        }
        return a;
    }*/
}
