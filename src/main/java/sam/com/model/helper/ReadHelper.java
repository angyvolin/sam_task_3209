package src.main.java.sam.com.model.helper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static src.main.java.sam.com.model.helper.WriteHelper.isThereFile;


@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReadHelper {
    private static boolean flagStart = true;
    private static String path = "";

    public static void setPath(String path) {
        ReadHelper.path = path;
    }



    public static void readSetting() {
        if (flagStart && isThereFile()) {
            flagStart = false;
        } else {
            try (FileReader reader = new FileReader(path)) {
                reader.read();
                // TO DO
            } catch (IOException e) {
                WriteHelper.writeLog(e.toString());
                System.out.println(e.getMessage());
            }
        }
    }
}
