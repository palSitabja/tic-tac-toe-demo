import ticTacToeEntity.GameBoard;
import ticTacToeEntity.Player;
import ticTacToeService.GameLogic;

import java.util.*;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome To TIC-TAC-TOE");
        System.out.println("Enter No of players (Min 2): ");
        Integer noPlayer=sc.nextInt();

        List<Player> playerSet=new ArrayList<>();
        Set<String> symbols =new HashSet<>();
        for (int i = 0; i < noPlayer; i++) {
            System.out.println("Enter player "+(i+1)+" name and symbol separated by space (eg: Alice X)");
            //String[] strings=sc.nextLine().split(" ");
            //System.out.println(Arrays.toString(strings));
            String name=sc.next();
            String symbol=sc.next();
            Player player=new Player();
            player.setName(name);
            player.setSymbol(symbol);
            symbols.add(symbol);
            playerSet.add(player);
        }
        System.out.println("Enter board size (eg 3 for 3*3): ");
        Integer boardSize=sc.nextInt();
        GameBoard gameBoard=new GameBoard();
        gameBoard.setCellCount(boardSize);
        gameBoard.setSymbols(symbols);
        String[][] board=new String[boardSize][];
        for (int i = 0; i < boardSize; i++) {
            String[] ar=new String [boardSize];
            Arrays.fill(ar,"-");
            board[i]=ar;
        }
        gameBoard.setBoard(board);
        System.out.println(playerSet+"\n"+board[1][1]);
        GameLogic gameLogic=new GameLogic();
        gameLogic.play(playerSet,gameBoard);
    }
}
