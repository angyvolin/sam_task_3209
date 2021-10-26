package src.main.java.sam.com.model.listeners;

import src.main.java.sam.com.view.View;

import javax.swing.event.MenuListener;
import javax.swing.event.MenuEvent;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import javax.swing.*;
import java.awt.*;



@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TextEditMenuListener implements MenuListener {
    // TextEditMenuListener. Этот класс также должен реализовывать интерфейс MenuListener.
    // Добавь ему конструктор TextEditMenuListener(View view).
    // В следующих заданиях мы рассмотрим его детальнее.
    // TextEditMenuListener. This class must also implement the MenuListener interface.
    // Add constructor TextEditMenuListener (View view) to it.
    // In the next tasks we will look at it in more detail.
    private View view;



    @Override
    public void menuSelected(MenuEvent menuEvent) {
        // должен устанавливать доступность пунктов меню стиль,
        // выравнивание, цвет и шрифт в зависимости от выбранной вкладки.
        // should set the accessibility of menu items style,
        // alignment, color and font depending on the selected tab.
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
