package com.mechadragonx.hanoi;

import java.util.Stack;

public class Main
{
    private static int operations = 0;
    private static Stack<Integer> source = new Stack<>();
    private static Stack<Integer> aux = new Stack<>();
    private static Stack<Integer> target = new Stack<>();
    private static final int DISC_SIZE = 7;

    public static void main(String[] args)
    {
        setup(DISC_SIZE);
        System.out.println("Expected Number of Moves: " + (int)((Math.pow(2, DISC_SIZE) - 1)));
        print();
        hanoi(source.size(), source, target, aux);
        System.out.println("Total Number of Moves: " + operations);
        print();
    }
    private static void setup(int size)
    {
        for(int i = size; i > 0; i--)
        {
            source.push(i);
        }
    }
    private static void hanoi(int discs, Stack<Integer> source, Stack<Integer> aux, Stack<Integer> target)
    {
        int currentDisc;
        if(discs == 1)
        {
            currentDisc = source.pop();
            target.push(currentDisc);
            operations++;
        }
        else
        {
            hanoi(discs - 1, source, target, aux);
            currentDisc = source.pop();
            target.push(currentDisc);
            operations++;
            hanoi(discs - 1, aux, source, target);
        }
    }
    private static void print()
    {
        System.out.println("A: " + source);
        System.out.println("B: " + target);
        System.out.println("C: " + aux + "\n");
    }
}
