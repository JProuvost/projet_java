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
public class TrimestreDAO extends DAO<Trimestre>{
    public TrimestreDAO(Connexion conn){
        super(conn);
    }
    @Override
    public boolean create(Trimestre as)
    {
        try{
            connexion.executeUpdate("INSERT INTO trimestre (idtrimestre, numero, debut, fin, idannee) VALUES ("+as.get_id()+", "+as.get_numero()+", '"+as.get_debut()+"', '"+as.get_fin()+"', "+as.get_idannee()+")");
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public boolean delete(Trimestre as)
    {
        try{connexion.executeUpdate("DELETE FROM trimestre WHERE idtrimestre="+as.get_id());
        return true;
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public boolean update(Trimestre as)
    {
        try{
            connexion.executeUpdate("UPDATE trimestre SET numero="+as.get_numero()+", debut='"+as.get_debut()+", fin="+as.get_fin()+", idannee="+as.get_idannee()+" WHERE idtrimestre="+as.get_id());
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public Trimestre find(int id)
    {
        Trimestre a = new Trimestre();
        try{
            String result = (String) connexion.remplirChampsRequete("SELECT * FROM trimestre WHERE idtrimestre="+id).get(0);
            String[] elements =result.split(",");
            a = new Trimestre(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]), elements[2], elements[3], Integer.parseInt(elements[4]));
        }catch (Exception e){
            System.out.println("La trimestre cherchée n'existe pas.");
        }
        return a;
    }
}
