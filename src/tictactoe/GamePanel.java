package tictactoe;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class GamePanel extends JButton implements ActionListener {

    private static final long serialVersionUID = -5953771526632304260L;
    private static boolean isPlayerOneTurn = true;
    private final int index;
    private final GameFrame gameFrame;

    public GamePanel(int index, GameFrame gameFrame) {
        this.index = index;
        this.gameFrame = gameFrame;

        this.setBackground(Color.darkGray);
        this.setFocusable(false);
        this.setBorderPainted(false);
        this.setFont(new Font("Arial", Font.BOLD, 60));
        this.setForeground(Color.white);

        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	// button is already marked
        if (!this.getText().isEmpty()) return;

        String mark = isPlayerOneTurn ? "X" : "O";
        this.setText(mark);
        this.setForeground(isPlayerOneTurn ? Color.red : Color.blue);
        
        gameFrame.markCell(index, mark);

        isPlayerOneTurn = !isPlayerOneTurn;
    }
}
