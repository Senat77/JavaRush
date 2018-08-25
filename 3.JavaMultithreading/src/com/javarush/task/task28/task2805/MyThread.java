package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread
{
    public static AtomicInteger tPriority = new AtomicInteger(1);

    private void setCurPriority ()
    {
        synchronized (MyThread.class)
        {
            if(tPriority.get() > MAX_PRIORITY)
                tPriority = new AtomicInteger(1);
            setPriority(tPriority.get());
            if(getThreadGroup() != null)
            {
                if(tPriority.get() > getThreadGroup().getMaxPriority())
                {
                    setPriority(getThreadGroup().getMaxPriority());
                }
            }
            tPriority.incrementAndGet();
        }
    }

    public MyThread()
    {
        setCurPriority();
    }

    public MyThread(Runnable target)
    {
        super(target);
        setCurPriority();
    }

    public MyThread(ThreadGroup group, Runnable target)
    {
        super(group, target);
        setCurPriority();
    }

    public MyThread(String name)
    {
        super(name);
        setCurPriority();
    }


    public MyThread(ThreadGroup group, String name)
    {
        super(group, name);
        setCurPriority();
    }


    public MyThread(Runnable target, String name)
    {
        super(target, name);
        setCurPriority();
    }


    public MyThread(ThreadGroup group, Runnable target, String name)
    {
        super(group, target, name);
        setCurPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize)
    {
        super(group, target, name, stackSize);
        setCurPriority();
    }

    /*
    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize, boolean inheritThreadLocals)
    {
        super(group, target, name, stackSize, inheritThreadLocals);
        setCurPriority();
    }
    */
}
