package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import static com.javarush.task.task32.task3209.ExceptionHandler.log;

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
        // Он будет записывать переданный текст с html тегами в документ document.
        // При его реализации: Сбрось документ.
        // Создай новый реадер StringReader на базе переданного текста.
        // Вызови метод read() из класса HTMLEditorKit, который вычитает данные
        // из реадера в документ document.
        // Проследи, чтобы метод не кидал исключения. Их необходимо просто логировать.
    public void setPlainText(String text) {
        resetDocument();
        StringReader stringReader = new StringReader(text);
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        try {
            htmlEditorKit.read(stringReader, document, 0);
        } catch (BadLocationException e) { log(e); }
        catch (IOException e) { log(e); }
    }
}
