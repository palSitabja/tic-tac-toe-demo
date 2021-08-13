package ticTacToeService;

import ticTacToeEntity.GameBoard;
import ticTacToeEntity.Player;
import ticTacToeException.GameException;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class GameLogic {
    Set<Player> playerSet=new HashSet<>();

    public void addPlayer(Player player, GameBoard gameBoard) throws GameException {

        if (!gameBoard.getSymbols().contains(player.getSymbol())){
            throw new GameException("Invalid Symbol");
        }else {
            playerSet.add(player);
        }


    }

    public void play(List<Player> playerList, GameBoard gameBoard){
        Integer noOfPlayers=playerList.size();
        int i=0;
        Scanner sc=new Scanner((System.in));
        while (true){
            int turn=i%noOfPlayers;
            System.out.println(playerList.get(turn).getName()+"'s turn\nEnter cell no (row col):");
            int row=sc.nextInt();
            int col=sc.nextInt();

            if(gameBoard.getBoard()[row][col]!="-"){
                System.out.println("This cell is filled try another !!");
            }else{
                i++;
                gameBoard.getBoard()[row][col]=playerList.get(turn).getSymbol();
                Boolean winer=printBoard(gameBoard);
                if(winer){
                    System.out.println("Game is drawn !!");
                    break;
                }
                Boolean winner=checkBoard(gameBoard,playerList.get(turn),row,col);
                if(winner){
                    System.out.println("Congratulations!!!\n"+playerList.get(turn).getName()+" is winner");
                    break;
                }
            }
        }

    }

    public Boolean checkBoard(GameBoard gameBoard,Player player,int row,int col){

        int cellCount=gameBoard.getCellCount();
        int horizontalCount=0;
        int vericalCount=0;
        int diagonalCount=0;
        int crossDiagCount=0;
        int temp=cellCount-1;
        for (int i = 0; i < cellCount; i++) {
            if(gameBoard.getBoard()[row][i]==player.getSymbol()){
                vericalCount++;
            }
            if(gameBoard.getBoard()[i][col]==player.getSymbol()){
                horizontalCount++;
            }
            if(gameBoard.getBoard()[i][i]==player.getSymbol()){
                diagonalCount++;
            }
            if(gameBoard.getBoard()[i][temp]==player.getSymbol()){
                crossDiagCount++;
                temp--;
            }
        }
        if(vericalCount==cellCount || horizontalCount==cellCount || diagonalCount==cellCount || crossDiagCount==cellCount){
            return true;
        }else{
            return false;
        }

    }
    public Boolean printBoard(GameBoard gameBoard){
        String[][] board=gameBoard.getBoard();
        int count=0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j]!="-"){
                    count++;
                }
                System.out.print(board[i][j]+"   ");
            }
            System.out.println();
        }
        if (count==gameBoard.getCellCount()*gameBoard.getCellCount()) return true;
        else return false;
    }

}
