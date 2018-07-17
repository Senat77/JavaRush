package com.javarush.task.task17.task1706;

public class OurPresident
{
    private static OurPresident president;

    static
    {
        synchronized (OurPresident.class)// (president)
        {
            president = new OurPresident();
        }
    }

    private OurPresident()
    {
    }

    public static synchronized OurPresident getOurPresident()
    {
        return president;
    }
}
