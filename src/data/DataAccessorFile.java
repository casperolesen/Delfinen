package data;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import logic.Member;

public class DataAccessorFile implements DataAccessorInterface{
    private String filetext = "members_delfinen.txt"; // filepath som String
    private Path filepath = Paths.get(filetext); // Path oprettet via filetext. Burde laves på en linje
    
    public List readAllLines(String filename) throws IOException{
        try {
            Charset cs = Charset.forName("ISO-8859-1");
            Path path = Paths.get(filename);
            List<String> lines = Files.readAllLines(path, cs);
            
            return lines;
        } catch (IOException ex) {
            throw new IOException();
        }
    }
    
    public void appendLine(String outFilename, String input) throws IOException{
        try {
            PrintWriter out = new PrintWriter(new FileWriter(outFilename, true));
            out.append(input+System.lineSeparator());
            out.close();
        } catch (IOException ex) {
            throw new IOException();
        }
    }

    @Override
    public List<Member> getMembers() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Member> searchMailForMembers(String email) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Member getMember(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createMember(Member member) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editMember(Member member) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteMember(Member member) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
