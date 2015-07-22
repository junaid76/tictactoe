package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import logic.Game;

public class GameCell extends JPanel {

    // position on game board
    int x, y;
    char token;
    Game game;

    public GameCell(Game game, int x, int y) {

        this.x = x;
        this.y = y;
        this.game = game;

        setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        addMouseListener(new PlaceToken());
    }

    @Override
    public void paintComponent(Graphics graphics) {

        Graphics2D g = (Graphics2D) graphics;

        super.paintComponent(graphics);

        g.setColor(Color.BLUE);
        g.fillRect(0, 0, getWidth(), getHeight());

        repaint();

        if (token == 'X') {
            drawX(g);
        }

        if (token == 'O') {
            drawO(g);
        }
    }

    public void drawX(Graphics2D g) {
        g.setColor(Color.MAGENTA);
        g.setStroke(new BasicStroke(4));
        g.drawLine(0, 0, getWidth(), getHeight());
        g.drawLine(getWidth(), 0, 0, getHeight());
    }

    public void drawO(Graphics2D g) {
        g.setColor(Color.ORANGE);
        g.setStroke(new BasicStroke(4));
        g.drawOval(0, 0, getWidth(), getHeight());
    }

    public void log(String log) {
        System.out.println(log);
    }

    public void displayMessage(String m) {
        JOptionPane.showMessageDialog(null, m);
    }

    class PlaceToken extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (game.grid[x][y] == ' ') {
                // get the current token
                token = game.currentToken;

                // change the token in the correct cells position
                game.grid[x][y] = token;

                // display player move to board
                repaint();

                if (game.isOver()) {
                    displayMessage("We have a winner! " + token + " has won");
                    System.exit(0);
                }

                if (game.isFull()) {
                    displayMessage("It's a draw. Too bad");
                    System.exit(0);
                }

                // change the token for the next move
                game.currentToken = (token == 'X') ? 'O' : 'X';

            } else {
                displayMessage("Cell is occupied. Please choose another");
            }
        }
    }
}
