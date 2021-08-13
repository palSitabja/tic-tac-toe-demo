package ticTacToeEntity;

import java.util.Arrays;
import java.util.Set;

public class GameBoard {
    private Integer cellCount;
    private String [][] board;
    private Set<String> symbols;
    public Integer getCellCount() {
        return cellCount;
    }

    public void setCellCount(Integer cellCount) {
        this.cellCount = cellCount;
    }

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    public Set<String> getSymbols() {
        return symbols;
    }

    public void setSymbols(Set<String> symbols) {
        this.symbols = symbols;
    }

    @Override
    public String toString() {
        return "GameBoard{" +
                "cellCount=" + cellCount +
                ", board=" + Arrays.toString(board) +
                ", symbols=" + symbols +
                '}';
    }
}
