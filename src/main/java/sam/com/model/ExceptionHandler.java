package src.main.java.sam.com.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;



@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionHandler {
    public static void log(Exception e){
        System.out.println(e.toString());
    }
}
