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
public class ClasseDAO extends DAO<Classe>{
    public ClasseDAO(Connexion conn){
        super(conn);
    }
    @Override
    public boolean create(Classe as)
    {
        try{
            connexion.executeUpdate("INSERT INTO classe (idclasse, nom, idniveau, idannee) VALUES ("+as.get_id()+", '"+as.get_nom()+"', "+as.get_idniveau()+", "+as.get_idannee()+")");
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public boolean delete(Classe as)
    {
        try{connexion.executeUpdate("DELETE FROM classe WHERE idclasse="+as.get_id());
        return true;
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public boolean update(Classe as)
    {
        try{
            connexion.executeUpdate("UPDATE classe SET nom='"+as.get_nom()+"', idniveau="+as.get_idniveau()+", idannee="+as.get_idannee()+" WHERE idclasse="+as.get_id());
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public Classe find(int id)
    {
        Classe a = new Classe();
        try{
            String result = (String) connexion.remplirChampsRequete("SELECT * FROM classe WHERE idclasse="+id).get(0);
            String[] elements =result.split(",");
            a = new Classe(Integer.parseInt(elements[0]), elements[1], Integer.parseInt(elements[2]), Integer.parseInt(elements[3]));
        }catch (Exception e){
            System.out.println("La classe cherchée n'existe pas.");
        }
        return a;
    }
}
