import java.awt.event.ActionEvent;
import javax.swing.*;



// Класс возврата действия.
public class RedoAction extends AbstractAction {

    private View view;

    public RedoAction(View view){ this.view = view; }

    @Override
    public void actionPerformed(ActionEvent e) {
        view.redo();
    }
}
