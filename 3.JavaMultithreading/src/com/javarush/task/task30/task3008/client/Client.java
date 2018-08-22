package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;

public class Client
{
    protected Connection connection;
    private volatile boolean clientConnected = false;

    protected String getServerAddress()
    {
        return ConsoleHelper.readString();
    }

    protected int getServerPort()
    {
        return ConsoleHelper.readInt();
    }

    protected String getUserName()
    {
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole()
    {
        return true;
    }

    protected SocketThread getSocketThread()
    {
        return new SocketThread();
    }

    protected void sendTextMessage(String text)
    {
        try
        {
            Message mes = new Message(MessageType.TEXT,text);
            connection.send(mes);
        }
        catch (IOException e)
        {
            System.out.println("Ошибка отправки сообщения");
            clientConnected = false;
        }
    }

    public void run()
    {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        try
        {
            synchronized (this)
            {
                wait();
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("Ошибка");
            return;
        }
        //synchronized (this)
        //{
            if(clientConnected)
            {
                System.out.println("Соединение установлено. Для выхода наберите команду 'exit'.");
                while(clientConnected)
                {
                    String text = ConsoleHelper.readString();
                    if("exit".equals(text))
                        break;
                    else
                    {
                        if(shouldSendTextFromConsole())
                            sendTextMessage(text);
                    }
                }
            }
            else
            {
                System.out.println("Произошла ошибка во время работы клиента.");
            }
        //}
    }

    public class SocketThread extends Thread
    {
        @Override
        public void run()
        {

        }
    }

    public static void main(String[] args)
    {
        Client client = new Client();
        client.run();
    }
}
