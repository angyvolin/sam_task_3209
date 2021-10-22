package src.main.java.sam.com;

import src.main.java.sam.com.view.View;

public class Main {


  public static void main(String[] args) {
          View view = new View();
          Controller controller = new Controller(view);
          view.setController(controller);
          view.init();
          controller.init();
      }
}
