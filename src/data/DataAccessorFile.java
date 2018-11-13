package data;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
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
        List<Member> members = new ArrayList<>();    
        for(String line:readAllLines(fileMembers)){
            String[] parts = line.split(splitSymbol);
            members.add(new Member(
                    Integer.parseInt(parts[0].trim()),
                    parts[1].trim(),
                    parts[2].trim(),
                    LocalDate.parse(parts[3].trim()),
                    Boolean.parseBoolean(parts[4].trim()),
                    Boolean.parseBoolean(parts[5].trim())));
        }
        
        return members;
    }

    @Override
    public List<Member> searchMailForMembers(String email) throws Exception {
        List<Member> members = new ArrayList<>(); 
            for(String line:readAllLines(fileMembers)){
            if(email.equals(line.split(splitSymbol)[2])){
            String[] parts = line.split(splitSymbol);
            members.add(new Member(
                    Integer.parseInt(parts[0].trim()),
                    parts[1].trim(),
                    parts[2].trim(),
                    LocalDate.parse(parts[3].trim()),
                    Boolean.parseBoolean(parts[4].trim()),
                    Boolean.parseBoolean(parts[5].trim())));
            }}
        return members;
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
        try{
        List<String> lines = readAllLines(fileMembers);
        int id = Integer.parseInt(lines.get(lines.size() -1).split(splitSymbol)[0]) +1;
        appendLine(fileMembers,id+splitSymbol+member.toFile());
        } catch(Exception e){
            throw new Exception();
        }
    }

    @Override
    public void editMember(Member member) throws Exception {
       editLine(""+member.getID(),member.getID()+splitSymbol+member.toFile(), fileMembers);
    }

    @Override
    public void deleteMember(Member member) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
