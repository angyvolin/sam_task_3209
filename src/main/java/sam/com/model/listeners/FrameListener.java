package src.main.java.sam.com.model.listeners;

import src.main.java.sam.com.view.View;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;


@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FrameListener extends WindowAdapter {
    private View view;

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        this.view.exit();
        super.windowClosed(windowEvent);
    }
}
