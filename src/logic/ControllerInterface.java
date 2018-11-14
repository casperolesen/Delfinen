/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author Vics
 */
public interface ControllerInterface {

/**
 * 
 * @return total antal af både aktive og inaktive member's
 */
    public int getTotalNumberOfMembers();

    /**
     * 
     * @return  total antal af aktive member's
     */
    public int getTotalNumberOfActiveMembers();

}
