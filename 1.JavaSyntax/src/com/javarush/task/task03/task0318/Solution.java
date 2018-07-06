package com.javarush.task.task03.task0318;

/* 
План по захвату мира
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sAge = br.readLine();
        int nAge = Integer.parseInt(sAge);
        String name = br.readLine();
        System.out.println(name + " захватит мир через " + nAge + " лет. Му-ха-ха!");
    }
}
