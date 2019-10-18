package com.javarush.task.task32.task3209.actions;


import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.StyleConstants;
import java.awt.event.ActionEvent;
import javax.swing.*;

        //  Класс SuperscriptAction. Он будет отвечать за стиль "Надстрочный знак".
public class SuperscriptAction extends StyledEditorKit.StyledTextAction {

        //public SuperscriptAction() { super("Надстрочный знак"); }
    public SuperscriptAction() { super(StyleConstants.Superscript.toString()); }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JEditorPane editor = getEditor(actionEvent);
        if (editor != null) {
            MutableAttributeSet mutableAttributeSet = getStyledEditorKit(editor).getInputAttributes();
            SimpleAttributeSet simpleAttributeSet = new SimpleAttributeSet();
            StyleConstants.setSuperscript(simpleAttributeSet, !StyleConstants.isSuperscript(mutableAttributeSet));
            setCharacterAttributes(editor, simpleAttributeSet, false);
        }
    }
}
