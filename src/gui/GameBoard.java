package gui;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import logic.Game;

class GameBoard {

    private final JFrame frame;
    private final JPanel board;
    private final GameCell[][] cells;
    private final Game game;

    public GameBoard(Game game) {

        frame = new JFrame("tic tac toe game");
        board = new JPanel(new GridLayout(3, 3));
        cells = new GameCell[3][3];
        this.game = game;
        populateCells();

        frame.add(board);
        frame.setLocation(300, 200);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void populateCells() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = new GameCell(game, i, j);
                board.add(cells[i][j]);
            }
        }
    }
}
