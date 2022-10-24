package com.ansupercomputer.supercomputerhub.virtualmachine;

import com.ansupercomputer.supercomputerhub.user.User;

public class VirtualMachine {
    private int id;
    private int cores;
    private int storage;
    private int ram;
    private User owner;

    public VirtualMachine(int id, int cores, int storage, int ram, User owner) {
        this.id = id;
        this.cores = cores;
        this.storage = storage;
        this.ram = ram;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public int getCores() {
        return cores;
    }

    public int getStorage() {
        return storage;
    }

    public int getRam() {
        return ram;
    }

    public User getOwner() {
        return owner;
    }
}
