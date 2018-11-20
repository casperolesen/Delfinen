/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.time.LocalDate;
import logic.Member;


/**
 *
 * @author Martin
 */
public class testLogic {
    
    static Controller c = new Controller();
    
    public static void main(String[] args) {
        Member testMember = new Member(100, "bob", "svans@svans.dk", LocalDate.parse("1997-11-19"), false, true, new boolean[]{true, true, true, true});
        
        System.out.println(c.getAmountToPay(testMember));
    }
    
}
