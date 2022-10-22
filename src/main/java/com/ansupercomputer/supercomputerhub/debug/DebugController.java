package com.ansupercomputer.supercomputerhub.debug;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "debug")
public class DebugController {
    @GetMapping
    public String debugPrint() {
        return "Debug";
    }
}
