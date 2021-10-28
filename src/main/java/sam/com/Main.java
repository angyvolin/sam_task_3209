package src.main.java.sam.com;

import src.main.java.sam.com.controller.Controller;
import src.main.java.sam.com.model.helper.ReadHelper;
import src.main.java.sam.com.model.helper.WriteHelper;



public class Main {
    private static final String SET_TXT = "setting.txt";
    private static final String USER_DIR = "user.dir";
    private static final String LOG_TXT = "log.txt";



    public static void main(String[] args) {

        if (args.length >= 2) {
            ReadHelper.setPath(args[0]);
            WriteHelper.setPath(args[1]);
        } else {
            WriteHelper.setPath(System.getProperty(USER_DIR) + LOG_TXT);
            ReadHelper.setPath(System.getProperty(USER_DIR) + SET_TXT);
        }

        ReadHelper.readSetting();

        View view = View.builder().build();
        Controller controller = Controller.builder().view(view).build();
        view.setController(controller);
        view.init();
        controller.init();
    }
}
