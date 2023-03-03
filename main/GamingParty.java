package main;

import java.util.Random;

public class GamingParty {

    private final String theme;
    private final String boardGame;
    private final Player[] players;
    private final Snack[] snacks;
    private  String winner = null;
    private static int i;
    private static int snackIterator;

    static {
        i = -1;
        snackIterator = -1;
    }

    public GamingParty(String theme, BoardGame game) {
        this.theme = theme;
        this.boardGame = game.getTitle();
        this.players = new Player[game.getMaximumplayers()];
        this.snacks = new Snack[game.getMaximumplayers() * 2];
        this.winner = null;
    }

    public void addPlayer(Player player) {
        if(i>0) {
            for (Player player1 : this.players) {
                if (player1.getName().equals(player)) {
                    System.out.println("the player is already playing the game at this party");
                }
                return;
            }
        }
        if (i >= this.players.length) {
            System.out.println("maximum number of players have been reached for the game at this party");
            return;
        }
        if (player.getAge() >= 18) {
            ++i;
            this.players[i] = player;
        } else {
            System.out.println("The player does not meet the age requirements for the board game at this party");
        }
    }

    public void play(BoardGame game) {
        if (this.players.length == game.getMinimumplayers()) {
            System.out.println("Play");
        } else {
            int numPlayers = 0;

            for (Player player: this.players) {
                if(player!=null)
                    ++numPlayers;
            }
            System.out.println(game.getMinimumplayers() - numPlayers);
            int op = game.getMinimumplayers() - numPlayers;
            System.out.println("you need " + op + " more players");
        }
    }

    public void addSnack(Snack snack) {
        if (snackIterator >= this.snacks.length) {
            System.out.println("there are enough snacks");
        } else {
            ++snackIterator;
            this.snacks[snackIterator] = snack;
        }
    }

    public double getPartyCost()
    {
        double totalCost = 0;
        for(Snack snack : snacks)
        {
            if(snack!=null)
                totalCost += snack.getCost();
        }
        return totalCost;
    }

    public String getWinner()
    {
        return this.winner;

    }
    public void setWinner(String winnerName)
    {
        if(this.winner==null)
        {
            for (Player player: players) {
                if(player!=null)
                {
                    this.winner = winnerName;
                    return;
                }

            }
            System.out.println("The player didn't even play the game so cannot win!");
        }
        else
        {
            System.out.println("The winner has already been decided! It was "+this.winner);
        }
    }

    public void outputPartyDetails()
    {
        if(this.winner.equals(null) || this.players.length==0 || this.snacks.length==0)
        {
            System.out.println("Theme: "+ this.theme);
            System.out.println("Board game: "+this.boardGame);
            System.out.println("Players:");
            System.out.println("Snacks:");
            System.out.println("No winner yet!");
        }
        else {
            System.out.println("Theme: " + this.theme);
            System.out.println("Board game: " + this.boardGame);
            System.out.println("Players: ");
            for (Player player : players) {
                if (player!=null)
                    System.out.println(player.getName());
            }
            System.out.println("Snacks: ");
            for (Snack snack : snacks) {
                if (snack!=null)
                    System.out.println(snack.getDescription() + " provided by " + snack.getProvider());
            }
            System.out.println("The winner is " + this.winner);
        }
    }

    public void calculateRecommendedSnacks(BoardGame game)
    {

        int totalSnacks = 0;
        if(this.players.length==0)
            return;
        else {
            double hours = Math.round((double)game.getMinutes() / 60);
            if ((int)hours > this.snacks.length) {
                hours = this.snacks.length;
            }
            int snackCounter ;
            while ((int)hours > 0) {
                snackCounter = 0;
                for (Player player : players) {
                    if (player!=null && snackCounter<=snackIterator) {
                        ++totalSnacks;
                        System.out.println(player.getName() + " food ->" + this.snacks[(int) (snackCounter)].getDescription());
                    }
                    ++snackCounter;
                }
                --hours;
            }
        }
        System.out.println("A total of "+totalSnacks+" snacks are recommended for the game");
    }
}
