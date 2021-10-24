package src.main.java.sam.com.model.listeners;

import javax.swing.event.UndoableEditListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.undo.UndoManager;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;


@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UndoListener implements UndoableEditListener {
    // Этот класс будет следить за правками, которые можно отменить или вернуть.
    private UndoManager undoManager;

    

    @Override // должен из переданного события получать правку и добавлять ее в undoManager.
    public void undoableEditHappened(UndoableEditEvent e) { undoManager.addEdit(e.getEdit()); }
}
