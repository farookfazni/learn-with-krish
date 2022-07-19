package com.faznifarook;

public class App {
    public static void main(String[] args) {
        PC p = new PCBuilder().addRam("4 GB").addRom("2 GB").getPC();
        System.out.println(p);
    }
}
