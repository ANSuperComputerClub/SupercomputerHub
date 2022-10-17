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
     * @return every virual machine
     */
    public List<VirtualMachine> getVirtualMachines() {
        return virtualMachines;
    }

    public VirtualMachine createVirtualMachine(VirtualMachine newVm) {
        virtualMachines.add(newVm);
        return newVm;
    }

    public VirtualMachine getVirtualMachineById(Long id) throws VirtualMachineNotFoundException {
        for(VirtualMachine machine: virtualMachines) {
            if(machine.getId().equals(id)) {
                return machine;
            }
        }
        throw new VirtualMachineNotFoundException();
    }

    /**
     * Starts up the VM
     * @param vm
     * @return
     */
    public boolean startVirtualMachine(VirtualMachine vm) {
        // In here we want to insert the server code that actually does the starting up
        vm.startVm();
        return true;
    }

}
