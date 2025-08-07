package game.custom.Panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.Border;

import game.custom.input.NumberText;

public class SudokuSector extends JPanel {

    public SudokuSector(final List<NumberText> textFields) {
        var dimension = new Dimension(170, 170);
        this.setPreferredSize(dimension);
        this.setSize(dimension);

        Border outer = new LineBorder(Color.BLACK, 2, true);
        Border padding = new EmptyBorder(8, 8, 8, 8);
        this.setBorder(new CompoundBorder(outer, padding));

        this.setLayout(new GridLayout(3, 3, 5, 5));
        textFields.forEach(this::add);
    }
}
