package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BotClient extends Client
{
    @Override
    protected SocketThread getSocketThread()
    {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole()
    {
        return false;
    }

    @Override
    protected String getUserName()
    {
        return "date_bot_" + (int)(Math.random() * 100);
    }

    public class BotSocketThread extends Client.SocketThread
    {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException
        {
            BotClient.this.sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message)
        {
            ConsoleHelper.writeMessage(message);
            if(message.contains(": "))
            {
                String userName = message.substring(0,message.indexOf(": "));
                String text = message.substring(message.indexOf(": ") + 2,message.length());
                String dPattern = "";
                switch (text)
                {
                    case "дата" :
                    {
                        dPattern = "d.MM.YYYY";
                        break;
                    }
                    case "день" :
                    {
                        dPattern = "d";
                        break;
                    }
                    case "месяц" :
                    {
                        dPattern = "MMMM";
                        break;
                    }
                    case "год" :
                    {
                        dPattern = "YYYY";
                        break;
                    }
                    case "время" :
                    {
                        dPattern = "H:mm:ss";
                        break;
                    }
                    case "час" :
                    {
                        dPattern = "H";
                        break;
                    }
                    case "минуты" :
                    {
                        dPattern = "m";
                        break;
                    }
                    case "секунды" :
                    {
                        dPattern = "s";
                        break;
                    }
                }
                if (!dPattern.isEmpty())
                {
                    SimpleDateFormat sdf = new SimpleDateFormat(dPattern);
                    BotClient.this.sendTextMessage("Информация для " + userName + ": " + sdf.format(Calendar.getInstance().getTime()));
                }
            }
        }
    }

    public static void main(String[] args)
    {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
