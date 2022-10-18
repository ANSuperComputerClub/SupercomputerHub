package com.basedgoat.supercomputerhub.vm;

import com.basedgoat.supercomputerhub.exception.VirtualMachineNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VirtualMachineService {
    /**
     * The World's greatest database
     */
    private final List<VirtualMachine> virtualMachines = List.of(
            new VirtualMachine("mainWindows", 10, 4, 20),
            new VirtualMachine("mainUbuntu", 20, 8, 40)
    );

    /**
     * Gets all virtual machines
     *
     * @return every virtual machine
     */
    public List<VirtualMachine> getVirtualMachines() {
        return virtualMachines;
    }

    public VirtualMachine createVirtualMachine(VirtualMachine newVm) {
        virtualMachines.add(newVm);
        return newVm;
    }

    public VirtualMachine getVirtualMachineById(Long id) throws VirtualMachineNotFoundException {
        for (VirtualMachine machine : virtualMachines) {
            if (machine.getId().equals(id)) {
                return machine;
            }
        }
        throw new VirtualMachineNotFoundException();
    }

    /**
     * Starts up the VM
     *
     * @param vm the virtual machine to start up
     */
    public void startVirtualMachine(VirtualMachine vm /* In the future do we want to make this an id rather than an object?*/) {
        // In here we want to insert the server code that actually does the starting up
        vm.startVm();
        // Maybe a microservice for monitoring VM's?
        // In the future we need to throw an error if it fails
    }

    public int getTotalCoreCount() {
        int coreCount = 0;
        for(VirtualMachine vm: virtualMachines) {
            coreCount += vm.getCores();
        }
        return coreCount;
    }

    public int getTotalRam() {
        int ram = 0;
        for(VirtualMachine vm: virtualMachines) {
            ram += vm.getRam();
        }
        return ram;
    }

    public int getTotalStorage() {
        int storage = 0;
        for(VirtualMachine vm: virtualMachines) {
            storage += vm.getStorage();
        }
        return storage;
    }

}
