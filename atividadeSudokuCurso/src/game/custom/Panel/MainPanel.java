package game.custom.Panel;

import java.awt.Dimension;
import javax.swing.JPanel;

public class MainPanel extends JPanel {

    public MainPanel(final Dimension dimension) {
        this.setPreferredSize(dimension);
        this.setSize(dimension);
    }
}

