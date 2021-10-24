package src.main.java.sam.com;

import src.main.java.sam.com.controller.Controller;



public class Main {

  public static void main(String[] args) {
          View view = View.builder().build();
          Controller controller = Controller.builder().view(view).build();
          view.setController(controller);
          view.init();
          controller.init();
      }
}
