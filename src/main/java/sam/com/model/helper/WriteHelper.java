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
    private static String pathSetting = "";
    private static String pathLog = "";

    public static void setPath(String path) {
        WriteHelper.pathLog = path;
    }


    public static void writeLog(String in) {
        if (flagStart && new File(pathLog).isFile()) {
            new File(pathLog);
            flagStart = false;
        }
        write(in);
    }

    private static void write(String in) {
        try (FileWriter writer = new FileWriter(pathSetting, false)) {
            writer.write(in);
            writer.append('\n');
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean isThereFile() {
        if (new File(pathSetting).isFile()) {
            new File(pathSetting);
            return true;
        }
        return false;
    }
}
