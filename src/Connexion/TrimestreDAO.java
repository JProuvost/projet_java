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
            connexion.executeUpdate("INSERT INTO trimestre (idtrimestre, numero, debut, fin, idannee) VALUES ("+as.getid()+", "+as.getnumero()+", '"+as.getdebut()+"', '"+as.getfin()+"', "+as.getidAnnee()+")");
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public boolean delete(Trimestre as)
    {
        try{connexion.executeUpdate("DELETE FROM trimestre WHERE idtrimestre="+as.getid());
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
            connexion.executeUpdate("UPDATE trimestre SET numero="+as.getnumero()+", debut='"+as.getdebut()+"', fin='"+as.getfin()+"', idannee="+as.getidAnnee()+" WHERE idtrimestre="+as.getid());
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public ArrayList<Trimestre> tout()
    {
        ArrayList<Trimestre> a = new ArrayList<>();
        a.add(new Trimestre());
        try{
            ArrayList<String>results=connexion.remplirChampsRequete("SELECT * FROM trimestre");
            
            for(String elem:results)
            {
                String[] result=elem.split(",");
                a.add(new Trimestre(Integer.parseInt(result[0]),Integer.parseInt(result[1]),result[2],result[3],Integer.parseInt(result[4])));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return a;
    }
    /*@Override
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
    }*/
}
