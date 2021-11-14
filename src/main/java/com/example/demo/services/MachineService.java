package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.MachineModel;
import com.example.demo.repositories.MachineRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MachineService {
    @Autowired
    MachineRepository machineRepository;

    public ArrayList<MachineModel> obtenerMaquinas() {
        return (ArrayList<MachineModel>) machineRepository.findAll();
    }

    public MachineModel guardarMaquina(MachineModel model) {
        return machineRepository.save(model);
    }

    public Optional<MachineModel> obtenerMaquinaPorId(Long id) {
        return machineRepository.findById(id);
    }

    public boolean eliminarUsuario(Long id) {
        try {
            machineRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
