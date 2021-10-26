package src.main.java.sam.com.model.actions;

import src.main.java.sam.com.view.View;

import java.awt.event.ActionEvent;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import javax.swing.*;



@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RedoAction extends AbstractAction {
    // Класс возврата действия.

    private View view;

    @Override
    public void actionPerformed(ActionEvent e) {
        view.redo();
    }
}
