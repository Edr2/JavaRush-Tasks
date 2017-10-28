package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static {
        reset();
    }

    public static void main(String[] args) {
        Solution.reset();
    }

    public static Flyable result;

    public static void reset() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();

            if( line.equals("plane") ) {
                int a = Integer.parseInt(br.readLine());
                result = new Plane(a);
            }
            if( line.equals("helicopter") )
                result = new Helicopter();

            br.close();
        }
        catch (IOException e){ }
    }
}