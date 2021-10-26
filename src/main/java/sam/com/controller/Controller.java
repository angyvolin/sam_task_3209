package src.main.java.sam.com.controller;

import src.main.java.sam.com.model.HTMLFileFilter;
import src.main.java.sam.com.view.View;

import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.HTMLDocument;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import javax.swing.*;
import java.io.*;

import static src.main.java.sam.com.model.ExceptionHandler.log;



@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Controller {
    private HTMLDocument document;
    private File currentFile;
    private View view;

    public void init() {
        createNewDocument();
    }

    public void exit() {
        System.exit(0);
    }

    public void openDocument() {
    }

    public void saveDocument() {
    }


    // будет сбрасывать текущий документ. Он должен:
    // Удалять у текущего документа document слушателя правок которые можно
    // отменить/вернуть (найди подходящий для этого метод, унаследованный от AbstractDocument).
    // Слушателя нужно запросить у представления (метод getUndoListener()).
    // Не забудь проверить, что текущий документ существует (не null).
    // Создавать новый документ по умолчанию и присваивать его полю document.
    // Добавлять новому документу слушателя правок.
    // Вызывать у представления метод update().
    public void resetDocument() {
        if (document != null) {
            document.removeUndoableEditListener(view.getUndoListener());
        }

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
        } catch (BadLocationException | IOException e) {
            log(e);
        }
    }

    // Он должен получать текст из документа со всеми html тегами.
    // Создай объект StringWriter.
    // Перепиши все содержимое из документа document в созданный объект
    //      с помощью метода write класса HTMLEditorKit.
    // Как обычно, метод не должен кидать исключений.
    public String getPlainText() {
        StringWriter stringWriter = new StringWriter();

        try {
            if (document != null) new HTMLEditorKit().write(stringWriter, document, 0, document.getLength());
        } catch (Exception e) { log(e); }

        return stringWriter.toString();
    }

    // Переключать представление на html вкладку.
    // Создавать новый объект для выбора файла JFileChooser.
    // Устанавливать ему в качестве фильтра объект src.main.java.sam.com.model.HTMLFileFilter.
    // Показывать диалоговое окно "Save File" для выбора файла.
    // Если пользователь подтвердит выбор файла:
    // Сохранять выбранный файл в поле currentFile.
    // Устанавливать имя файла в качестве заголовка окна представления.
    // Создавать FileWriter на базе currentFile.
    // Переписывать данные из документа document в объекта FileWriter-а аналогично тому,
    //      как мы это делали в методе getPlainText().
    // Метод не должен кидать исключения.
    public void saveDocumentAs() {
        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());
        //JOptionPane.showMessageDialog(view.getContentPane(), "Make your choice...",
        //      "Save File", JOptionPane.INFORMATION_MESSAGE);
        // Если пользователь подтвердит выбор файла
        if (jFileChooser.showSaveDialog(view) == JFileChooser.APPROVE_OPTION) {
            currentFile = jFileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());

            FileWriter fileWriter = null;

            try {
                fileWriter = new FileWriter(currentFile);
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
                fileWriter.close();
            } catch (IOException | BadLocationException e) {
                log(e);
            }
        }
    }

    // Он должен: Выбирать html вкладку у представления.
    // Сбрасывать текущий документ.
    // Устанавливать новый заголовок окна, например: "HTML редактор".
    //      Воспользуйся методом setTitle(), который унаследован в нашем представлении.
    // Сбрасывать правки в Undo менеджере. Используй метод resetUndo представления.
    // Обнулить переменную currentFile.
    // Реализуй метод инициализации init() контроллера.
    // Он должен просто вызывать метод создания нового документа.
    // Проверь работу пункта меню Новый.
    public void createNewDocument() {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("редактор");
        view.resetUndo();
        currentFile = null;
    }
}
    
