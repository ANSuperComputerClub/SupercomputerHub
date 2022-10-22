package com.ansupercomputer.supercomputerhub.virtualmachine

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["vm"])
class VirtualMachineController (@Autowired val service: VirtualMachineService) {
    /**
     * Returns a list of all virtual machines
     */
    @GetMapping
    fun getVirtualMachines(): List<VirtualMachine> {
        return service.getAllVirtualMachines()
    }

    /**
     * Add a virtual machine
      */
    @PostMapping
    fun addVirtualMachine(@RequestBody vm: VirtualMachine) {
        return service.addVirtualMachine(vm)
    }

    /**
     * Delete a virtual machine
     */
    @DeleteMapping(value = ["{id}/delete"])
    fun deleteVirtualMachine(@PathVariable id: Int): Boolean {
        return service.deleteVirtualMachine(id)
    }

    /**
     * Get a specific virtual machine by id
     */
    @GetMapping(value = ["{id}"])
    fun getVirtualMachineById(@PathVariable id: Int): VirtualMachine? {
        return service.getVirtualMachineById(id)
    }

}
