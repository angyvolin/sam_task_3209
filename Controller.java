package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.File;

public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }

    public void init() { }

    public void exit() { System.exit(0); }

    public Controller(View view) {
        this.view = view;
    }

    public HTMLDocument getDocument() { return document; }
        // будет сбрасывать текущий документ. Он должен:
        // Удалять у текущего документа document слушателя правок которые можно
        // отменить/вернуть (найди подходящий для этого метод, унаследованный от AbstractDocument).
        // Слушателя нужно запросить у представления (метод getUndoListener()).
        // Не забудь проверить, что текущий документ существует (не null).
        // Создавать новый документ по умолчанию и присваивать его полю document.
        // Добавлять новому документу слушателя правок.
        // Вызывать у представления метод update().
    public void resetDocument() {
        if (document != null) { document.removeUndoableEditListener(view.getUndoListener()); }
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }
}
