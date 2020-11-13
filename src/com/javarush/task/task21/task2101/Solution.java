package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/

public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000


    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] out = new byte[4];

        StringBuilder tempOut = new StringBuilder();
        for (int i = 0; i < ip.length; i++) {
            String tempIp;
            String tempMask;

            tempIp = String.format("%8s", Integer.toBinaryString(ip[i] & 0xff)).replace(' ', '0');
            tempMask = String.format("%8s", Integer.toBinaryString(mask[i] & 0xff)).replace(' ', '0');
            for (int k = 0; k < 8; k++) {
                tempOut.append((char) (tempIp.charAt(k) & tempMask.charAt(k)));
            }


            out[i] = (byte)Integer.parseInt(tempOut.toString(),2);
            tempOut.delete(0, 8);

        }


        return out;
    }

    public static void print(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes){
            sb.append(String.format("%8s",Integer.toBinaryString(b & 0xff)).replace(' ','0')).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);

        System.out.println(sb.toString());

    }
}
