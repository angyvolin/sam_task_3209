package src.main.java.sam.com.model.helper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WriteHelper {
    private static boolean flagStart = true;
    private static String path = "";

    public static void setPath(String path) {
        WriteHelper.path = path;
    }


    public static void writeLog(String in) {
        if (flagStart && new File(path).isFile()) {
            new File(path);
            flagStart = false;
        }
        write(in);
    }

    private static void write(String in) {
        try (FileWriter writer = new FileWriter(path, false)) {
            writer.write(in);
            writer.append('\n');
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
