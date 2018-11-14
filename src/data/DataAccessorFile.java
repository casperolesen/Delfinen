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

public class DataAccessorFile implements DataAccessorInterface {

    private final String fileMembers = "members_delfinen.txt"; // filepath som String
    private final String splitSymbol = ";";

    public List<String> readAllLines(String filename) throws IOException {
        try {
            Charset cs = Charset.forName("ISO-8859-1");
            Path path = Paths.get(filename);
            List<String> lines = Files.readAllLines(path, cs);

            return lines;
        } catch (IOException ex) {
            throw new IOException();
        }
    }

    public void appendLine(String outFilename, String input) throws IOException {
        try {
            PrintWriter out = new PrintWriter(new FileWriter(outFilename, true));
            out.append(input + System.lineSeparator());
            out.close();
        } catch (IOException ex) {
            throw new IOException();
        }
    }

    public void editLine(String id, String newLine, String filename) throws IOException {
        List<String> allLinesInFile = readAllLines(filename);
            for (int i = 0; i < allLinesInFile.size(); i++) {
                if (id.equals(allLinesInFile.get(i).split(splitSymbol)[0].trim())) {
                    allLinesInFile.set(i, newLine);
                    break;
                }
            }
            Files.write(Paths.get(filename), allLinesInFile);
    }
    
    public void removeLine(String id, String filename ) throws IOException {
        List<String> allLinesInFile = readAllLines(filename);
            
            for (int i = 0; i < allLinesInFile.size(); i++) {
                if (id.equals(allLinesInFile.get(i).split(splitSymbol)[0].trim())) {
                    allLinesInFile.remove(i);
                }
            }
            
            Files.write(Paths.get(filename), allLinesInFile);
    }

    @Override
    public List<Member> getMembers() throws Exception {
        List<Member> members = new ArrayList<>();
        for (String line : readAllLines(fileMembers)) {
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
            if(email.equals(line.split(splitSymbol)[2].trim())){
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

        for (String line : allLinesInFile) {
            if (Integer.toString(id).equals(line.split(splitSymbol)[0].trim())) {
                int id_member = Integer.parseInt(line.split(splitSymbol)[0].trim());
                String name = line.split(splitSymbol)[1].trim();
                String email = line.split(splitSymbol)[2].trim();
                LocalDate birthday = LocalDate.parse(line.split(splitSymbol)[3].trim());
                Boolean active = Boolean.valueOf(line.split(splitSymbol)[4].trim());
                Boolean elite = Boolean.valueOf(line.split(splitSymbol)[5].trim());
                Member member = new Member(id_member, name, email, birthday, active, elite);

                return member;

            }
        }

        return null;
    }

    @Override
    // 
    
    /**
     * ER DET BARE NAVNET, SOM FORVIRRER MIG?? En methode "createMember", som tager et Member som parameter.
     * Mulig løsning: Ændre navnet til "saveMember-something" - eller gi' methoden oplysningerne på det nye Member, og kald new Member inde i methoden
     */
    public void createMember(Member member) throws Exception {
        try {
            List<String> lines = readAllLines(fileMembers);
            int id = Integer.parseInt(lines.get(lines.size() - 1).split(splitSymbol)[0]) + 1;
            appendLine(fileMembers, id + splitSymbol + member.toFile());
        } catch (Exception e) {
            throw new Exception();
        }
    }

    @Override
    public void editMember(Member member) throws Exception {
        try{
        editLine("" + member.getID(), member.getID() + splitSymbol + member.toFile(), fileMembers);
        } catch(IOException e){
            throw new Exception();
        }
    }

    @Override
    public void deleteMember(int id) throws Exception {
        removeLine(Integer.toString(id), fileMembers);
    }

}
