package src.main.java.sam.com.view;

import src.main.java.sam.com.controller.Controller;
import src.main.java.sam.com.model.ExceptionHandler;

import javax.swing.*;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class View extends JFrame implements ActionListener {
    private Controller controller;

            // это будет панель с двумя вкладками.
    private JTabbedPane tabbedPane = new JTabbedPane();
            // это будет компонент для визуального редактирования html.
    private JTextPane htmlTextPane = new JTextPane();
            // это будет компонент для редактирования html в виде текста,
            // он будет отображать код html(теги и их содержимое).
    private JEditorPane plainTextPane = new JEditorPane();

    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

//      4. В конструкторе класса View, через класс UIManager, должен устанавливаться внешний вид
//          и поведение (look and feel).
    public View () {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }
                // Они будут отвечать за инициализацию меню и панелей редактора.
//      1. В методе initMenuBar() должно создаваться новое меню (объект типа JMenuBar).
//      2. В методе initMenuBar() c помощью src.main.java.sam.com.model.MenuHelper должно быть проинициализировано
//          меню в следующем порядке: Файл, Редактировать, Стиль, Выравнивание, Цвет, Шрифт и Помощь.
//      3. В методе initMenuBar() должно добавляться новосозданное меню в верхнюю часть панели контента
//          текущего фрейма, используя метод getContentPane().
    public void initMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();
        initFileMenu(this, jMenuBar);
        initEditMenu(this, jMenuBar);
        initStyleMenu(this, jMenuBar);
        initAlignMenu(this, jMenuBar);
        initColorMenu(this, jMenuBar);
        initFontMenu(this, jMenuBar);
        initHelpMenu(this, jMenuBar);
            //getContentPane().add(jMenuBar, BorderLayout.BEFORE_FIRST_LINE);
            // тоже самое чего не приняло не знаю.
        getContentPane().add(jMenuBar, BorderLayout.NORTH);
    }

//      1. В методе initEditor() для компонента htmlTextPane должен устанавливаться тип контента "text/html"
//          через сеттер setContentType.
//      2. В методе initEditor() должен создаваться новый локальный компонент JScrollPane через конструктор
//          принимающий htmlTextPane.
//      3. В методе initEditor() для компонента tabbedPane должна добавляться вкладка с именем "HTML"
//          и созданным компонентом JScrollPane на базе htmlTextPane.
//      4. В методе initEditor() должен создаваться новый локальный компонент JScrollPane через конструктор
//          принимающий plainTextPane.
//      5. В методе initEditor() для компонента tabbedPane должна добавляться вкладка с именем "Текст"
//          и созданным компонентом JScrollPane на базе plainTextPane.
//      6. В методе initEditor() для компонента tabbedPane должен устанавливаться предпочтительный размер панели,
//          через сеттер setPreferredSize.
//      7. В методе initEditor() для компонента tabbedPane должен добавляться слушатель
//          TabbedPaneChangeListener через метод addChangeListener.
//      8. Метод initEditor() должен добавлять по центру панели контента текущего фрейма нашу панель
//          с вкладками, через getContentPane().add().
    public void initEditor() {
        htmlTextPane.setContentType("text/html");
        JScrollPane jScrollPane = new JScrollPane(htmlTextPane);
        tabbedPane.addTab("HTML", jScrollPane);
        JScrollPane jScrollPaneNew = new JScrollPane(plainTextPane);
        tabbedPane.addTab("Текст", jScrollPaneNew);
        tabbedPane.setPreferredSize(new Dimension(500, 500));
        tabbedPane.addChangeListener(new com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener(this));
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
        
    }
                //-------------------------------------------------------------

                // Он будет инициализировать графический интерфейс.
    public void initGui() {
        this.initMenuBar();
        this.initEditor();
        this.pack();
    }
                //-------------------------------------------------------------

    public void init() {
        this.initGui();
            // Добавлять слушателя событий нашего окна. В качестве подписчика создай
            // и используй объект класса FrameListener.
            //В качестве метода для добавления подписчика используй подходящий метод из класса Window
            // от которого наследуется и наш класс через классы JFrame и Frame.
        addWindowListener(new com.javarush.task.task32.task3209.listeners.FrameListener(this));
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // Показывать наше окно. Используй метод setVisible с правильным параметром.
        setVisible(true);
    }

        // отменяет последнее действие. Реализуй его используя undoManager.
    public void undo() {
        try {
            undoManager.undo();
        } catch (CannotUndoException e) {
            ExceptionHandler.log(e);
        }
    }

        // возвращает ранее отмененное действие. Реализуй его по аналогии с предыдущим пунктом.
    public void redo() {
        try {
            undoManager.redo();
        } catch (CannotRedoException e) {
            ExceptionHandler.log(e);
        }
    }

        // должен сбрасывать все правки в менеджере undoManager.
    public void resetUndo() { undoManager.discardAllEdits(); }

    public void selectedTabChanged() {}

    public boolean isHtmlTabSelected() {
        if (tabbedPane.getSelectedIndex() == 0) return true;
        else return false;
    }

    public void exit() { controller.exit(); }

    public boolean canUndo() { return undoManager.canUndo(); }

    public boolean canRedo() { return undoManager.canRedo(); }

    public void actionPerformed(ActionEvent e){ }

    public Controller getController() { return controller; }

    public UndoListener getUndoListener() { return undoListener; }

    public void setController(Controller controller) { this.controller = controller; }

}
