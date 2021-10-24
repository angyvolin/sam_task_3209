package src.main.java.sam.com.model.listeners;

import src.main.java.sam.com.view.View;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;


@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TabbedPaneChangeListener implements ChangeListener {
    private View view;



    @Override
    public void stateChanged(ChangeEvent e) { view.selectedTabChanged(); }

}
