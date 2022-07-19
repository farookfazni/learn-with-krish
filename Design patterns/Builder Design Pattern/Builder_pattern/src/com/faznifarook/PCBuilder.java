package com.faznifarook;

public class PCBuilder {
    private String ram;
    private String rom;

    public PCBuilder addRam(String ram){
        this.ram = ram;
        return this;
    }

    public PCBuilder addRom(String rom){
        this.rom = rom;
        return this;
    }
    public PC getPC(){
        return new PC(ram, rom);
    }
}
