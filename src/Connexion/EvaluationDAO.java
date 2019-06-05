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
            connexion.executeUpdate("INSERT INTO evaluation (idevaluation, note, appreciation, iddetail) VALUES ("+as.get_id()+", "+as.get_note()+", '"+as.get_appreciation()+"', "+as.get_iddetail()+")");
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public boolean delete(Evaluation as)
    {
        try{connexion.executeUpdate("DELETE FROM evaluation WHERE idevaluation="+as.get_id());
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
            connexion.executeUpdate("UPDATE evaluation SET note="+as.get_note()+", appreciation='"+as.get_appreciation()+"', iddetail="+as.get_iddetail()+" WHERE idevaluation="+as.get_id());
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
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
    }
}
