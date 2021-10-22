package src.main.java.sam.com;

import src.main.java.sam.com.controller.Controller;
import src.main.java.sam.com.view.View;

public class Main {


  public static void main(String[] args) {
          View view = View.builder().build();
          Controller controll = Controller.builder().view(view).build();
          view.controller(controll);
          view.init();
          controll.init();
      }
}
