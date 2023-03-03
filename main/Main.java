package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  private static BufferedReader br;
  private  static  String description;
  private  static  String title;
  private  static  String theme;
  private  static  String name;
  private  static  int cost;
  private  static  int minAge;
  private  static  int age;
  private  static  int minutes;
  private  static  int minPlayers;
  private  static  int maxPlayers;
  private  static  double rating;


  static
  {
    br = new BufferedReader(new InputStreamReader(System.in));
  }
  public static void main(String[] args) throws IOException {

    //player-------------------------------
    System.out.println("Enter PLayer Name ");
    name = br.readLine();
    System.out.println("Enter PLayer Age");
    age = Integer.parseInt(br.readLine());
    Player player1 = new Player(name,age);

    System.out.println(player1.getName());
    System.out.println(player1.getAge());



    //snack----------------------------------------
    System.out.println("Enter Snack  ");
    description = br.readLine();
    System.out.println("Cost ");
    cost = Integer.parseInt(br.readLine());
    Snack sn = new Snack(description,cost,player1);
    System.out.println(sn.getDescription());
    System.out.println(sn.getCost());
    System.out.println(sn.getProvider());


    //board game--------------------------------------
    System.out.println("Game title ");
    title = br.readLine();
    System.out.println("Minimum Age ");
    minAge = Integer.parseInt(br.readLine());
    System.out.println("Minutes ");
    minutes = Integer.parseInt(br.readLine());
    System.out.println("Minimum Players");
    minPlayers = Integer.parseInt(br.readLine());
    System.out.println("Max Players");
    maxPlayers = Integer.parseInt(br.readLine());
    System.out.println("Rating ");
    rating = Double.parseDouble(br.readLine());
    BoardGame bg = new BoardGame(title,player1,minAge,minutes,minPlayers,maxPlayers,rating);
    System.out.println(bg.getTitle());
    System.out.println(bg.getOwner());
    System.out.println(bg.getMinimumAge());
    System.out.println(bg.getMinutes());
    System.out.println(bg.getMinimumplayers());
    System.out.println(bg.getMaximumplayers());
    System.out.println(bg.getRating());
    bg.setRating(19.5);

    //gaming Party--------------------------------------
    System.out.println("Theme ");
    theme = br.readLine();
    GamingParty gamingParty = new GamingParty(theme,bg);
    gamingParty.addPlayer(player1);
    gamingParty.play(bg);
    gamingParty.addSnack(sn);
    System.out.println(gamingParty.getPartyCost());
    gamingParty.setWinner("Nitin");
    System.out.println(gamingParty.getWinner());
    gamingParty.outputPartyDetails();
    gamingParty.calculateRecommendedSnacks(bg);


  }
}
