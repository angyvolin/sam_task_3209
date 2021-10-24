package src.main.java.sam.com.model.listeners;


import src.main.java.sam.com.view.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;



@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UndoMenuListener implements MenuListener {
    // он должен реализовывать интерфейс MenuListener и иметь конструктор
    // UndoMenuListener(View view, JMenuItem undoMenuItem, JMenuItem redoMenuItem).
    private JMenuItem undoMenuItem;
    private JMenuItem redoMenuItem;
    private View view;



    @Override
    public void menuSelected(MenuEvent menuEvent) {
        undoMenuItem.setEnabled(view.canUndo());
        redoMenuItem.setEnabled(view.canRedo());
    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
}
