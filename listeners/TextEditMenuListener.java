package com.javarush.task.task32.task3209.listeners;


import src.main.java.sam.com.view.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

// TextEditMenuListener. Этот класс также должен реализовывать интерфейс MenuListener.
    // Добавь ему конструктор TextEditMenuListener(View view).
    // В следующих заданиях мы рассмотрим его детальнее.
public class TextEditMenuListener implements MenuListener {
    private View view;

    public TextEditMenuListener(View view) { this.view = view; }

    @Override // должен устанавливать доступность пунктов меню стиль,
              // выравнивание, цвет и шрифт в зависимости от выбранной вкладки.
    public void menuSelected(MenuEvent menuEvent) {
        JMenu jMenu = (JMenu) menuEvent.getSource();
        for (Component c : jMenu.getMenuComponents()){
            c.setEnabled(view.isHtmlTabSelected());
        }
    }

    @Override
    public void menuDeselected(MenuEvent menuEvent) {

    }

    @Override
    public void menuCanceled(MenuEvent menuEvent) {

    }
}
