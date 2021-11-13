package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.MachineModel;
import com.example.demo.services.MachineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
/* import org.springframework.web.bind.annotation.PutMapping; */
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Machine")
public class MachineController {
    
    @Autowired
    MachineService machineService;

    @GetMapping("/all")
    public ArrayList<MachineModel> obtenerMaquinas() {
        return machineService.obtenerMaquinas();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public MachineModel guardarMaquina(@RequestBody MachineModel machine) {
        return this.machineService.guardarMaquina(machine);
    }

    @GetMapping( path = "/{id}")
    public Optional<MachineModel> obtenerMaquinaPorId(@PathVariable("id") Long id) {
        return this.machineService.obtenerMaquinaPorId(id);
    }

/*     @PutMapping("/update")
    public Optional<MachineModel> actualizarMaquina(@RequestBody MachineModel machine) {
        return this.machineService.
    } */
}
