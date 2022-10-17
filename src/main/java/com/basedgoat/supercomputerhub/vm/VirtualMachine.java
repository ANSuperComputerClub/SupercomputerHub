package com.basedgoat.supercomputerhub.vm;

public class VirtualMachine {
    private static Long currentId = 0L;
    private String name;
    private Long id;
    private int ram;
    private int cores;
    private int storage;
    private boolean active;

    public VirtualMachine(String name, int ram, int cores, int storage) {
        this.name = name;
        this.id = currentId;
        currentId++;
        this.ram = ram;
        this.cores = cores;
        this.storage = storage;
        active = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getCores() {
        return cores;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public Long getId() {
        return id;
    }

    public void startVm() {
        active = true;
    }

    public void endVm() {
        active = false;
    }
}
