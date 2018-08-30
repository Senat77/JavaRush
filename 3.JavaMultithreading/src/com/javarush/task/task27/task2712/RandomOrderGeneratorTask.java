package com.javarush.task.task27.task2712;

import java.util.ArrayList;
import java.util.List;


public class RandomOrderGeneratorTask implements Runnable
{
    private List<Tablet> tablets = new ArrayList<>();
    private int interval;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval)
    {
        this.tablets = tablets;
        this.interval = interval;
    }

    @Override
    public void run()
    {
        try
        {
           while (tablets.size() > 0)
           {
             Thread.sleep(interval);
             Tablet tablet = tablets.get((int) (Math.random() * tablets.size()));
             tablet.createTestOrder();
           }
        }
        catch (InterruptedException ignored) {}
    }
}
