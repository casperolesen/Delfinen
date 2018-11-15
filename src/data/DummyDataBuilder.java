package data;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Member;

/**
 *
 * @author caspe
 */
public class DummyDataBuilder {

    DataAccessorInterface data = null;

    public DummyDataBuilder() {
        this.data = new DataAccessorFile();
    }

    public static void main(String[] args) {
        try {
            new DummyDataBuilder().buildMembersFile();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void buildMembersFile() throws Exception {
        long start = System.currentTimeMillis();

        Path file = Paths.get("crashData.txt");
        Files.deleteIfExists(file);
        
        List<String> dummyOutput = new ArrayList<>();

        for (int i = 1; i <= 1000000; i++) {

            int id = i;
            String name = "Member " + i;
            String email = "membermail@test.dk";
            LocalDate birthday = LocalDate.parse("1900-12-24");
            boolean active = true;
            
            if (Math.random() < 0.1) {
                active = false;
            }
            
            boolean elite = true;
            boolean[] categories = {true, true, true, true};

            Member member = new Member(id, name, email, birthday, active, elite, categories);

            String output = member.getID() + ";" + member.toFile();
            dummyOutput.add(output);
        }

        Files.write(file, dummyOutput);
        
        long end = System.currentTimeMillis();
        System.out.println("Tid i millis: " + (end - start));
        System.out.println("Tid i sekunder: " + ((end - start) * 0.001));
    }
}
