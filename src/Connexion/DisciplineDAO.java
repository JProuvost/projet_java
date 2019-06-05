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
public class DisciplineDAO extends DAO<Discipline>{
    public DisciplineDAO(Connexion conn){
        super(conn);
    }
    @Override
    public boolean create(Discipline as)
    {
        try{
            connexion.executeUpdate("INSERT INTO discipline (iddiscipline, nom) VALUES ("+as.get_id()+", '"+as.get_nom()+"')");
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public boolean delete(Discipline as)
    {
        try{connexion.executeUpdate("DELETE FROM discipline WHERE iddiscipline="+as.get_id());
        return true;
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public boolean update(Discipline as)
    {
        try{
            connexion.executeUpdate("UPDATE discipline SET nom='"+as.get_nom()+"' WHERE iddiscipline="+as.get_id());
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public Discipline find(int id)
    {
        Discipline a = new Discipline();
        try{
            String result = (String) connexion.remplirChampsRequete("SELECT * FROM discipline WHERE iddiscipline="+id).get(0);
            String[] elements =result.split(",");
            a = new Discipline(Integer.parseInt(elements[0]), elements[1]);
        }catch (Exception e){
            System.out.println("La discipline cherchée n'existe pas.");
        }
        return a;
    }
}
