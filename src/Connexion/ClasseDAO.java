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
            connexion.executeUpdate("INSERT INTO classe (idclasse, nom, idniveau, idannee) VALUES ("+as.getid()+", '"+as.getnom()+"', "+as.getidNiveau()+", "+as.getidAnnee()+")");
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public boolean delete(Classe as)
    {
        try{connexion.executeUpdate("DELETE FROM classe WHERE idclasse="+as.getid());
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
            connexion.executeUpdate("UPDATE classe SET nom='"+as.getnom()+"', idniveau="+as.getidNiveau()+", idannee="+as.getidAnnee()+" WHERE idclasse="+as.getid());
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public ArrayList<Classe> tout()
    {
        ArrayList<Classe> a = new ArrayList<>();
        a.add(new Classe());
        try{
            ArrayList<String>results=connexion.remplirChampsRequete("SELECT * FROM classe");
            for(String elem:results)
            {
                String[] result=elem.split(",");
                a.add(new Classe(Integer.parseInt(result[0]),result[1],Integer.parseInt(result[2]),Integer.parseInt(result[3])));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return a;
    }
    /*@Override
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
    }*/
}
