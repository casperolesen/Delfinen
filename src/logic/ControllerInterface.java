/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.List;

/**
 *
 * @author Vics
 */
public interface ControllerInterface {
    
    public List<Member> getMembers() throws Exception;
    
    public List<Member> searchMailForMembers(String email) throws Exception;
    
    public Member getMember(int id) throws Exception;
    
    public void createMember(Member member) throws Exception;
    
    public void editMember(Member member) throws Exception;
    
    public void deleteMember(Member member) throws Exception;
       
}