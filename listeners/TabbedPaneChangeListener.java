package com.javarush.task.task32.task3209.listeners;

import src.main.java.sam.com.view.View;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TabbedPaneChangeListener implements ChangeListener {
    private View view;

    public TabbedPaneChangeListener(View view) { this.view = view; }

    @Override
    public void stateChanged(ChangeEvent e) { view.selectedTabChanged(); }

}
