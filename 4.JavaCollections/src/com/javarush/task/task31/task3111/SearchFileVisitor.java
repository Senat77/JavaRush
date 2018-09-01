package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path>
{
    private String partOfName, partOfContent;
    private int minSize, maxSize;
    private List<Path> foundFiles = new LinkedList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
    {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length

        boolean flag = true;

        if(partOfName != null)
            flag &= file.toString().contains(partOfName);
        if (partOfContent != null)
            flag &= new String(content).contains(partOfContent);
        if (minSize != 0)
            flag &= content.length >= minSize;
        if (maxSize != 0)
            flag &= content.length <= maxSize;
        if (flag)
            foundFiles.add(file);

        return super.visitFile(file, attrs);
    }

    public List<Path> getFoundFiles()
    {
        return foundFiles;
    }

    public void setPartOfName(String partOfName)
    {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent)
    {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize)
    {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize)
    {
        this.maxSize = maxSize;
    }
}
