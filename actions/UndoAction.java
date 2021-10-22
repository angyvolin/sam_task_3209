package com.javarush.task.task32.task3209.actions;


import src.main.java.sam.com.view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;

// Класс отмены действия UndoAction.
public class UndoAction extends AbstractAction {
    private View view;

    public UndoAction(View view){ this.view = view; }

    @Override
    public void actionPerformed(ActionEvent e) { view.undo(); }
}
