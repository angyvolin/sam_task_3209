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
public class SubscriptAction extends StyledEditorKit.StyledTextAction {
    // Класс SubscriptAction, который отвечает за стиль текста "Подстрочный знак".

    //public SubscriptAction() { super("Подстрочный знак"); }
    public SubscriptAction() { super(StyleConstants.Subscript.toString()); }

  
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JEditorPane editor = getEditor(actionEvent);

        if (editor != null) {
            MutableAttributeSet mutableAttributeSet = getStyledEditorKit(editor).getInputAttributes();
            SimpleAttributeSet simpleAttributeSet = new SimpleAttributeSet();
            StyleConstants.setSubscript(simpleAttributeSet, !StyleConstants.isSubscript(mutableAttributeSet));
            setCharacterAttributes(editor, simpleAttributeSet, false);
        }
    }
}
