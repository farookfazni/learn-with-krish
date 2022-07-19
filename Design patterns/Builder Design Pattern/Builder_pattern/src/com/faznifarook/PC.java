package com.faznifarook;

public class PC {
    private String ram;
    private String rom;

    public PC(String ram,String rom){
        super();
        this.ram = ram;
        this.rom = rom;
    }

    @Override
    public String toString() {
        return "PC{" +
                "Ram='" + ram + '\'' +
                ", Rom='" + rom + '\'' +
                '}';
    }

}
