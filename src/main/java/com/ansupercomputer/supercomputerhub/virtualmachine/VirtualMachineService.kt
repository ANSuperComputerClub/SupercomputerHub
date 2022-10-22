package com.ansupercomputer.supercomputerhub.virtualmachine

import org.springframework.stereotype.Component

@Component
class VirtualMachineService {
    /**
     * Look at the world's greatest database!
     */
    private val virtualMachines: MutableList<VirtualMachine> = mutableListOf()

    /**
     * Gets the list of all VM's
     */
    fun getAllVirtualMachines(): List<VirtualMachine> {
        return virtualMachines.toList()
    }

    /**
     * Creates a virtual machine
     */
    fun addVirtualMachine(vm: VirtualMachine) {
        virtualMachines.add(vm)
    }

    /**
     * Finds a virtual machine
     */
    fun getVirtualMachineById(id: Int): VirtualMachine? {
        return virtualMachines.find { vm -> vm.id == id }
    }

    /**
     * Deletes a virtual machine
     */
    fun deleteVirtualMachine(id: Int): Boolean {
        return virtualMachines.removeIf { vm -> vm.id == id }
    }
}
