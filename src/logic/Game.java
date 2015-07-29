package logic;

public class Game {

    public char currentToken;
    public char[][] grid;

    public Game() {
        currentToken = 'X';
        grid = new char[3][3];
        emptyCells();
    }

    public final void emptyCells() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    public boolean isOver() {

        // check horizontal
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == currentToken
                    && grid[i][1] == currentToken
                    && grid[i][2] == currentToken) {
                return true;
            }
        }

        // check vertical
        for (int i = 0; i < 3; i++) {
            if (grid[0][i] == currentToken
                    && grid[1][i] == currentToken
                    && grid[2][i] == currentToken) {
                return true;
            }
        }

        // check negative diagonal
        if (grid[1][1] == currentToken
                && grid[0][0] == currentToken
                && grid[2][2] == currentToken) {
            return true;
        }

        // check positive diagonal
        return grid[1][1] == currentToken
                && grid[0][2] == currentToken
                && grid[2][0] == currentToken;
    }

    public boolean isFull() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // check grid for any empty cells
                if (grid[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}