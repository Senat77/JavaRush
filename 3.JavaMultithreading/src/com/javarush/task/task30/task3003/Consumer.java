package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

public class Consumer implements Runnable
{
    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {
        Thread t = Thread.currentThread();
        while(!t.isInterrupted())
        {
            try
            {
                t.sleep(450);
                while(true)
                {
                    ShareItem shareItem = queue.take();
                    System.out.format("Processing %s\n",shareItem.toString());
                }
            }
            catch (InterruptedException e) {}
        }
    }
}
