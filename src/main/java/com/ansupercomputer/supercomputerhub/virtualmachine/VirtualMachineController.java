package com.ansupercomputer.supercomputerhub.virtualmachine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "vm")
public class VirtualMachineController {
    private final VirtualMachineService service;

    @Autowired
    public VirtualMachineController(VirtualMachineService service) {
        this.service = service;
    }

    /**
     * Returns a list of all virtual machines
     */
    @GetMapping
    public List<VirtualMachine> getVirtualMachines() {
        return service.getAllVirtualMachines();
    }

    /**
     * Add a virtual machine
     */
    @PostMapping
    public void addVirtualMachine(@RequestBody VirtualMachine vm) {
        service.addVirtualMachine(vm);
    }

    /**
     * Delete a virtual machine
     */
    @DeleteMapping(value = "{id}/delete")
    public void deleteVirtualMachine(@PathVariable int id) {
        service.deleteVirtualMachine(id);
    }

    /**
     * Get a specific virtual machine by id
     */
    @GetMapping(value = "{id}")
    public VirtualMachine getVirtualMachineById(@PathVariable int id) {
        return service.getVirtualMachineById(id);
    }
}
