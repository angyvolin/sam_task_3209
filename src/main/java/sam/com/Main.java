package src.main.java.sam.com;

import src.main.java.sam.com.controller.Controller;
import src.main.java.sam.com.model.WriteHelper;


public class Main {
    private static final String LOG_TXT = "log.txt";

    public static void main(String[] args) {

        if (args.length > 0) {
            WriteHelper.setPath(args[0]);
        } else {
            String path = System.getProperty("user.dir");
            WriteHelper.setPath(System.getProperty("user.dir") + LOG_TXT);
        }

        View view = View.builder().build();
        Controller controller = Controller.builder().view(view).build();
        view.setController(controller);
        view.init();
        controller.init();
    }
}
