/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Jean
 */
public class AnneeScolaire {
    private int id;
    public AnneeScolaire()
    {
        
    }
    public AnneeScolaire(int a)
    {
        id = a;
    }
    public int get_id()
    {
        return id;
    }
    public void set_id(int id)
    {
        this.id = id;
    }
}
