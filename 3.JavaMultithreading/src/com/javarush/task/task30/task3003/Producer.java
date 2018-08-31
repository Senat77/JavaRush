package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

public class Producer implements Runnable
{
    TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {
        Thread t = Thread.currentThread();

            for (int i = 1; i < 10; i++)
            {
                try
                {
                    t.sleep(100);
                    System.out.format("Элемент 'ShareItem-%s' добавлен\n",i);
                    queue.offer(new ShareItem("ShareItem-" + i,i));
                    if(queue.hasWaitingConsumer())
                        System.out.format("Consumer в ожидании!\n");
                }
                catch (Exception e) {}
            }

    }
}
