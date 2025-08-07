package game.custom.input;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import static game.service.EventEnum.CLEAR_SPACE;
import static java.awt.Font.PLAIN;

import game.model.Space;
import game.service.EventEnum;
import game.service.EventListener;

public class NumberText extends JTextField implements EventListener {

    private final Space space;

    public NumberText(final Space space) {
        this.space = space;
        var dimension = new Dimension(50, 50);
        this.setPreferredSize(dimension);
        this.setFont(new Font("Arial", PLAIN, 20));
        this.setHorizontalAlignment(CENTER);
        this.setDocument(new NumberTextLimit());
        this.setEnabled(!space.isFixed());

        if (space.isFixed()) {
            this.setText(space.getActual().toString());
        }

        this.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(final DocumentEvent e) {
                changeSpace();
            }

            @Override
            public void removeUpdate(final DocumentEvent e) {
                changeSpace();
            }

            @Override
            public void changedUpdate(final DocumentEvent e) {
                changeSpace();
            }

            private void changeSpace() {
                if (getText().isEmpty()) {
                    space.clearSpace();
                } else {
                    try {
                        space.setActual(Integer.parseInt(getText()));
                    } catch (NumberFormatException ex) {
                        // Caso insira algo inválido, limpa o campo e espaço
                        space.clearSpace();
                        setText("");
                    }
                }
            }
        });
    }

    @Override
    public void update(final EventEnum eventType) {
        if (eventType.equals(CLEAR_SPACE) && this.isEnabled()) {
            this.setText("");
        }
    }
}
