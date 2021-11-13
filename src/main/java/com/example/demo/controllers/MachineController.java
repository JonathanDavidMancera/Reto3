package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.MachineModel;
import com.example.demo.services.MachineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
/* import org.springframework.web.bind.annotation.PutMapping; */
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jonathan David Mancera - Sambas
 */

@RestController
@RequestMapping("/api/Machine")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class MachineController {
    /**
     * La anotación indica la inyección de dependecias
     */
    @Autowired
    MachineService machineService;

    /**
     * Este método devuelve una lista de máquinas 
     * @return
     */
    @GetMapping("/all")
    public ArrayList<MachineModel> obtenerMaquinas() {
        return machineService.obtenerMaquinas();
    }

    /**
     * Toma como parámetro máquina para el cuerpo de la petición
     * @param machine
     * @return
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public MachineModel guardarMaquina(@RequestBody MachineModel machine) {
        return this.machineService.guardarMaquina(machine);
    }
    /**
     * Este método busca una máquina por "id" gracias a @pathVariable y el método tiene como parámetro el id correspondiente de la máquina para realizar la petición
     * @param id
     * @return
     */
    @GetMapping( path = "/{id}")
    public Optional<MachineModel> obtenerMaquinaPorId(@PathVariable("id") Long id) {
        return this.machineService.obtenerMaquinaPorId(id);
    }

/*     @PutMapping("/update")
    public Optional<MachineModel> actualizarMaquina(@RequestBody MachineModel machine) {
        return this.machineService.
    } */
}
