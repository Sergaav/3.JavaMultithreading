package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Смена кодировки
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        Charset win1251 = Charset.forName("Windows-1251");
        Charset utf8 = StandardCharsets.UTF_8;

        try (FileInputStream fileInputStream = new FileInputStream(args[0]);
             FileOutputStream fileOutputStream = new FileOutputStream(args[1])) {
            byte[] byteIn = new byte[fileInputStream.available()];
            while (fileInputStream.available() > 0) {
                fileInputStream.read(byteIn);
            }
            String s = new String(byteIn, win1251);
            byte[] masOut = s.getBytes(utf8);
            fileOutputStream.write(masOut);
            fileOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
