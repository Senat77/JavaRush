package com.javarush.task.task21.task2113;

/*
Ипподром
 */

import java.util.ArrayList;
import java.util.List;

public class Hippodrome
{
    private List<Horse> horses;

    public static Hippodrome game;

    public List<Horse> getHorses()
    {
        return horses;
    }

    public Hippodrome(List<Horse> horses)
    {
        this.horses = horses;
    }

    public void run() throws InterruptedException
    {
        for (int i = 0; i < 100; i++)
        {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move()
    {
        for (Horse h : horses)
        {
            h.move();
        }
    }

    public void print()
    {
        for (Horse h : horses)
        {
            h.print();
        }
        for (int i = 0; i < 10; i++)
        {
            System.out.println();
        }
    }

    public Horse getWinner()
    {
        double maxDistance = 0;
        Horse winHorse = null;
        for(Horse h : horses)
        {
            if(maxDistance < h.getDistance())
            {
                winHorse = h;
                maxDistance = h.getDistance();
            }
        }
        return winHorse;
    }

    public void printWinner()
    {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) throws InterruptedException
    {
        List<Horse> list = new ArrayList<>();
        list.add(new Horse("One",3,0));
        list.add(new Horse("Two",3,0));
        list.add(new Horse("Three",3,0));

        game = new Hippodrome(list);
        game.run();
        game.printWinner();
    }
}
