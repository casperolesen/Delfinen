package data;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import logic.Member;

public class DataAccessorFile implements DataAccessorInterface{
    private final String fileMembers = "members_delfinen.txt"; // filepath som String
    private final String splitSymbol = "||";
    
    public List<String> readAllLines(String filename) throws IOException{
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
    
    public void editLine(String id, String newLine, String filename ) throws IOException {
        List<String> allLinesInFile = readAllLines(filename);
        for (String line : allLinesInFile) {
            
            for (int i = 0; i < allLinesInFile.size(); i++) {
                if (id.equals(line.split(splitSymbol)[0].trim())) {
                    allLinesInFile.set(i, newLine);
                    break;
                }
            }
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
        
        List<String> allLinesInFile = readAllLines(fileMembers);
        
        for (String line : allLinesInFile ) {
            if (Integer.toString(id).equals(line.split(splitSymbol)[0].trim())) {
                int id_member = Integer.parseInt(line.split(",")[0].trim());
                    String name = line.split(",")[1].trim();
                    String email = line.split(",")[2].trim();
                    LocalDate birthday = LocalDate.parse(line.split(",")[3].trim());
                    Boolean active = Boolean.valueOf(line.split(",")[4].trim());
                    Boolean elite = Boolean.valueOf(line.split(",")[5].trim());
                Member member = new Member (id_member, name, email, birthday, active, elite);
                
                return member;
                
            }
        }
        
        return null;
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
