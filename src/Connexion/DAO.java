/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connexion;

import java.util.ArrayList;
import jdbcv2018.Connexion;

public abstract class DAO<T> {
  protected Connexion connexion = null;
   
  public DAO(Connexion conn){
    this.connexion = conn;
  }
   
  /**
  * Méthode de création
  * @param obj
  * @return boolean 
  */
  public abstract boolean create(T obj);

  /**
  * Méthode pour effacer
  * @param obj
  * @return boolean 
  */
  public abstract boolean delete(T obj);

  /**
  * Méthode de mise à jour
  * @param obj
  * @return boolean
  */
  public abstract boolean update(T obj);

  /**
   * Méthode de création de tout
   * @return ArrayList<T>
   */
  public abstract ArrayList<T> tout();
}
