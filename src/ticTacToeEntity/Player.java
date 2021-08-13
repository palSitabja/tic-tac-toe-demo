package ticTacToeEntity;

import java.util.List;
import java.util.Set;

public class Player {
    private String name;
    private String symbol;
    //private Integer noOfsymbol;
   // private Set<String> symbols;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}
