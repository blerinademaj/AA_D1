package Detyra1;

import java.io.*;
import java.util.Stack;
import java.util.EmptyStackException;

class Non_rekursive {
    // Java program for iterative
    // Tower of Hanoi
    // A structure to represent a stack
    class Stack {
        int capacity;
        int top;
        int array[];
    }

    // Function to create a stack of given capacity.
    Stack createStack(int capacity) {
        Stack stack = new Stack();
        stack.capacity = capacity;
        stack.top = -1;
        stack.array = new int[capacity];
        return stack;
    }

    // Stack is full when the top is equal
    // to the last index
    boolean isFull(Stack stack) {
        return (stack.top == stack.capacity - 1);
    }

    // Stack is empty when top is equal to -1
    boolean isEmpty(Stack stack) {
        return (stack.top == -1);
    }

    // Function to add an item to stack.It
    // increases top by 1
    void push(Stack stack, int item) {
        if (isFull(stack))
            return;

        stack.array[++stack.top] = item;
    }

    // Function to remove an item from stack.It
    // decreases top by 1
    int pop(Stack stack) {
        if (isEmpty(stack))
            return Integer.MIN_VALUE;

        return stack.array[stack.top--];
    }

    // Function to implement legal movement between
    // two poles
    void moveDisksBetweenTwoPoles(Stack src, Stack dest, char s, char d) {
        int pole1TopDisk = pop(src);
        int pole2TopDisk = pop(dest);
        // Kur pole 1 eshte empty
        if (pole1TopDisk == Integer.MIN_VALUE) {
            push(src, pole2TopDisk);
            moveDisk(d, s, pole2TopDisk);
        }
        // Kur pole2 pole eshte empty
        else if (pole2TopDisk == Integer.MIN_VALUE) {
            push(dest, pole1TopDisk);
            moveDisk(s, d, pole1TopDisk);
        }
        // kur top disk i pole1 > top disk i pole2
        else if (pole1TopDisk > pole2TopDisk) {
            push(src, pole1TopDisk);
            push(src, pole2TopDisk);
            moveDisk(d, s, pole2TopDisk);
        }
        // kur top disk i pole1 < top disk i pole2
        else {
            push(dest, pole2TopDisk);
            push(dest, pole1TopDisk);
            moveDisk(s, d, pole1TopDisk);
        }
    }

    // Function to show the movement of disks
    void moveDisk(char fromPeg, char toPeg, int disk) {
        System.out.println("Move the disk " + disk + " from " + fromPeg +
                " to " + toPeg);
    }

    // Funksioni Iterativ
    void tohIterative(int num_of_disks, Stack src, Stack aux, Stack dest) {
        int i, total_num_of_moves;
        char s = 'S', d = 'D', a = 'A';

        if (num_of_disks % 2 == 0) {//Nese numri i diqeve eshte qift, atehere interchange destination pole
            char temp = d;         //dhe auxiliarity pole
            d = a;
            a = temp;
        }
        total_num_of_moves = (int) (Math.pow(2, num_of_disks) - 1);
        // Disqet me te medha do te behen "pushed" se pari
        for (i = num_of_disks; i >= 1; i--)
            push(src, i);
        for (i = 1; i <= total_num_of_moves; i++) {
            if (i % 3 == 1)
                moveDisksBetweenTwoPoles(src, dest, s, d);
            else if (i % 3 == 2)
                moveDisksBetweenTwoPoles(src, aux, s, a);
            else if (i % 3 == 0)
                moveDisksBetweenTwoPoles(aux, dest, a, d);
        }
    }

    public double time_second() {
        double time = System.currentTimeMillis();
        System.out.println("Koha e ekzekutimit në sekonda: " + ((time) / 1000));

        return ((time) / 1000);
    }

    public double time_millis() {

        System.out.println("Koha e ekzekutimit në milisekonda: ");
        System.out.println(System.currentTimeMillis());
        return System.currentTimeMillis();
    }

    public double time_microsecond() {

        double time = System.currentTimeMillis();
        System.out.println("Koha e ekzekutimit në mikrosekonda: " + ((time) * 1000));

        return ((time) * 1000);
    }

    public double time_nano() {
        System.out.println("Koha e ekzekutimit në nanosekonda: ");
        System.out.println(System.nanoTime());
        return System.nanoTime();
    }

    public double time_picosecond() {

        double time = System.nanoTime();
        System.out.println("Koha e ekzekutimit në pikosekonda: " + ((time) * 1000));

        return ((time) * 1000);
    }

    // Driver code
    public static void main(String[] args) {

        // Input: number of disks
        int num_of_disks = 3;
        Non_rekursive ob = new Non_rekursive();
        Stack src, dest, aux;

        // Create three stacks of size 'num_of_disks'
        // to hold the disks
        src = ob.createStack(num_of_disks);
        dest = ob.createStack(num_of_disks);
        aux = ob.createStack(num_of_disks);

        ob.tohIterative(num_of_disks, src, aux, dest);
    }
}

// This code is contributed by Sumit Ghosh
