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
            connexion.executeUpdate("INSERT INTO enseignement (idenseignement, iddiscipline, idclasse, idpersonne) VALUES ("+as.get_id()+", "+as.get_iddiscipline()+", "+as.get_idclasse()+", "+as.get_idpersonne()+")");
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public boolean delete(Enseignement as)
    {
        try{connexion.executeUpdate("DELETE FROM enseignement WHERE idenseignement="+as.get_id());
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
            connexion.executeUpdate("UPDATE enseignement SET iddiscipline="+as.get_iddiscipline()+", idclasse="+as.get_idclasse()+", idpersonne="+as.get_idpersonne()+" WHERE idenseignement="+as.get_id());
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
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
    }
}
