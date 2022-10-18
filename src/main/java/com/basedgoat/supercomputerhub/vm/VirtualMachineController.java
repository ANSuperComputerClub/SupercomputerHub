package com.basedgoat.supercomputerhub.vm;

import com.basedgoat.supercomputerhub.exception.VirtualMachineNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
     * @return A list of all virtual machines
     */
    @GetMapping
    public List<VirtualMachine> getAllVirtualMachine() {
        return service.getVirtualMachines();
    }

    /**
     * TODO Implement this method
     *
     * @return the completed virtual machine, after it's inserted
     */
    @PostMapping
    public VirtualMachine createVirtualMachine(@RequestBody VirtualMachine newVm) {
        return service.createVirtualMachine(newVm);
    }

    @GetMapping(value = "find/{id}")
    public VirtualMachine getVirtualMachine(@PathVariable long id) throws VirtualMachineNotFoundException {
        // There is probably a better way to handle these errors
        return service.getVirtualMachineById(id);
    }

    /**
     * Starts the virtual machine
     *
     * @param id the id of the virtual machine to start
     * @return Whether the VM was successfully started, or not
     */
    @GetMapping(value = "{id}/start")
    public boolean startVirtualMachine(@PathVariable long id) throws VirtualMachineNotFoundException {
        var vm = service.getVirtualMachineById(id);
        service.startVirtualMachine(vm);
        return true;
    }

    @ExceptionHandler
    public ResponseEntity<Object> exception(VirtualMachineNotFoundException e) {
        return new ResponseEntity<>("VM not found", HttpStatus.NOT_FOUND);
    }
}
