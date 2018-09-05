package com.javarush.task.task33.task3309;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlType(name = "first")
@XmlRootElement
public class First
{
    public List<String> notsecond = new ArrayList<>();
    {
        notsecond.add("some string");
        notsecond.add("some string");
        notsecond.add("need CDATA because of < and >");
        notsecond.add("");
    }
}