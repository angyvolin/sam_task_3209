package src.main.java.sam.com.model.actions;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.StyleConstants;
import java.awt.event.ActionEvent;
import lombok.NoArgsConstructor;
import lombok.Builder;
import javax.swing.*;


@Builder
@NoArgsConstructor
public class SuperscriptAction extends StyledEditorKit.StyledTextAction {
    // Класс SuperscriptAction. Он будет отвечать за стиль "Надстрочный знак".
    // SuperscriptAction class. He will be responsible for the "Superscript" style.

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
