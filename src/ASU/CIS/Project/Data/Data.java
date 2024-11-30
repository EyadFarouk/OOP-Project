package ASU.CIS.Project.Data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Data {
    Path path = Paths.get("F:\\OOP");
    FileWriter fileWriter = new FileWriter("F:\\OOP\\users", true);
    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    PrintWriter printWriter = new PrintWriter(bufferedWriter);

    public Data() throws IOException {
    }


}
