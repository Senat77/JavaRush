package com.javarush.task.task20.task2001;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Asset
{
    public Asset(String name, double price)
    {
        this.name = name;
        this.price = price;
    }

    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    /*
    public void save (OutputStream outputStream) throws IOException
    {
        outputStream.write(name.getBytes());
        outputStream.write(String.valueOf(price).getBytes());
    }

    public void load (InputStream inputStream)
    {
        inputStream.read(name);
    }
    */

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Asset asset = (Asset) o;

        if (Double.compare(asset.price, price) != 0) return false;
        return name != null ? name.equals(asset.name) : asset.name == null;
    }

    @Override
    public int hashCode()
    {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
