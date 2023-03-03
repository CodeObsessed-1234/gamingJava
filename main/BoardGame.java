package main;

public class BoardGame {
    private final String title;
    private final String owner;
    private final int minimumAge;
    private final int minutes;
    private final int minimumplayers;
    private final int maximumplayers;
    private double rating;
    
    public BoardGame(String title, Player owner, int minimumAge, int minutes, int minimumplayers, int maximumplayers, double rating)
    {
        this.title = title;
        this.owner = owner.getName();
        this.minimumAge = minimumAge;
        this.minutes = minutes;
        this.minimumplayers = minimumplayers;
        this.maximumplayers = maximumplayers;
        this.rating = rating;
        if((int)(this.rating)<0 || (int)(this.rating)>100)
        {
            System.out.println("Rating percentage not valid. Setting to 0");
            this.rating = 0;
        }
    }

    public String getOwner() {
        return owner;
    }

    public int getMinimumAge() {
        return minimumAge;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getMinimumplayers() {
        return minimumplayers;
    }

    public int getMaximumplayers() {
        return maximumplayers;
    }

    public String getTitle() {
        return title;
    }

    public void setRating(double rating) {
        if(rating<0 || rating>100)
           System.out.println("Rating percentage not valid.");
        else
            this.rating = rating;
        
    }

    public double getRating() {
        return rating;
    }
    
    
    
}
