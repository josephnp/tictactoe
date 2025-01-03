package tictactoe;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GameFrame extends JFrame {

    private static final long serialVersionUID = -3654659384960289531L;
    
    private final String[] isMarked = new String[9];
    private int moveCount = 0;

    public GameFrame() {
        ImageIcon image = new ImageIcon("logo.jpg");
        this.setIconImage(image.getImage());
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        this.setTitle("Tic-Tac-Toe");
        this.setSize(600, 600);
        this.setLayout(new GridLayout(3, 3, 20, 20));
        
        this.getContentPane().setBackground(Color.lightGray);

        for (int i = 0; i < 9; i++) {
            this.add(new GamePanel(i, this));
        }

        for (int i = 0; i < 9; i++) {
            isMarked[i] = "";
        }
    }

    public void markCell(int index, String mark) {
        isMarked[index] = mark;
        moveCount++;
        
        if (checkWinner()) {
            JOptionPane.showMessageDialog(this, mark + " wins!");
            resetGame();
        } else if (moveCount == 9) {
        	JOptionPane.showMessageDialog(this, "Draw!");
        	resetGame();
        }
    }

    private boolean checkWinner() {
        int[][] winningCombinations = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // columns
            {0, 4, 8}, {2, 4, 6}             // diagonals
        };

        for (int[] combination : winningCombinations) {
            if (!isMarked[combination[0]].isEmpty() &&
                isMarked[combination[0]].equals(isMarked[combination[1]]) &&
                isMarked[combination[1]].equals(isMarked[combination[2]])) {
                return true;
            }
        }
        
        
        return false;
    }

    private void resetGame() {
        for (int i = 0; i < 9; i++) {
            isMarked[i] = "";
        }
        
        this.getContentPane().removeAll();
        
        for (int i = 0; i < 9; i++) {
            this.add(new GamePanel(i, this));
        }
        
        this.revalidate();
        this.repaint();
    }
}

