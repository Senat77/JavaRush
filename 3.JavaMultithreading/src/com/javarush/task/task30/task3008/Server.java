package com.javarush.task.task30.task3008;

import java.io.Closeable;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server
{
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args)
    {
        try (ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt()))
        {
            System.out.println("Сервер запущен");
            while (true)
            {
                try
                {
                    new Handler(serverSocket.accept()).start();
                }
                catch (IOException e1)
                {
                    e1.printStackTrace();
                    break;
                }
            }
        }
        catch (Exception e)
        {
           e.printStackTrace();
        }
    }

    public static void sendBroadcastMessage(Message message)
    {
        for(Map.Entry<String,Connection> e : connectionMap.entrySet())
        {
            try
            {
                e.getValue().send(message);
            }
            catch (IOException e1)
            {
                System.out.println("Сообщение пользователю " + e.getKey() + " не отправлено");
            }
        }
    }

    private static class Handler extends Thread
    {
        public Socket socket;

        public Handler(Socket socket)
        {
            this.socket = socket;
        }

        @Override
        public void run()
        {
            try
            {
                try
                {
                    ConsoleHelper.writeMessage("Установлено новое соединение с адресом: " + socket.getRemoteSocketAddress());
                    Connection connection = new Connection(socket);
                    String userName = serverHandshake(connection);
                    Server.sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                    sendListOfUsers(connection, userName);
                    serverMainLoop(connection, userName);
                    connectionMap.remove(userName);
                    connection.close();
                    Server.sendBroadcastMessage(new Message(MessageType.USER_REMOVED,userName));
                }
                catch (IOException e)
                {
                    ConsoleHelper.writeMessage("Ошибка обмена данных с клиентом ");
                }
            }
            catch (ClassNotFoundException e1)
            {
                ConsoleHelper.writeMessage("Ошибка обмена данных с клиентом ");
            }
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException
        {
            while(true)
            {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();
                if(message.getType().equals(MessageType.USER_NAME))
                {
                    if(message.getData() != null && !message.getData().isEmpty())
                    {
                        if(!connectionMap.containsKey(message.getData()))
                        {
                            connectionMap.put(message.getData(),connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                            return message.getData();
                        }
                    }
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException
        {
            for(Map.Entry<String,Connection> e : connectionMap.entrySet())
            {
                if(!e.getKey().equals(userName))
                {
                    connection.send(new Message(MessageType.USER_ADDED,e.getKey()));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException
        {
            while(true)
            {
                Message mes = connection.receive();
                if (mes.getType() == MessageType.TEXT)
                {
                    Server.sendBroadcastMessage(new Message(MessageType.TEXT,userName + ": " + mes.getData()));
                }
                else
                {
                    ConsoleHelper.writeMessage("Ошибочный формат сообщения");
                }
            }
        }
    }
}
