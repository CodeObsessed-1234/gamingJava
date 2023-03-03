package main;


public class Player {
    private  String name = null;
    private int age = 0;
   
    
    public Player(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    
    public String getName()
    {
       return this.name;
    }
    public int getAge()
    {
        return this.age;
    }
    
}
