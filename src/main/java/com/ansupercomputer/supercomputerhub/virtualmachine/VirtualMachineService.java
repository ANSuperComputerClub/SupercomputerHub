package com.ansupercomputer.supercomputerhub.virtualmachine;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VirtualMachineService {
    /**
     * Look at the world's greatest database!
     */
    private List<VirtualMachine> virtualMachines = new ArrayList<>();

    /**
     * Gets the list of all VM's
     */
    public List<VirtualMachine> getAllVirtualMachines() {
        return virtualMachines;
    }

    /**
     * Creates a virtual machine
     */
    public void addVirtualMachine(VirtualMachine vm) {
        virtualMachines.add(vm);
    }

    /**
     * Finds a virtual machine
     */
    public VirtualMachine getVirtualMachineById(int id) {
        return virtualMachines.stream().filter(vm -> vm.getId() == id).findFirst().get();
    }

    /**
     * Deletes a virtual machine
     */
    public void deleteVirtualMachine(int id) {
        virtualMachines = virtualMachines.stream().filter(vm -> vm.getId() != id).toList();
    }
}
