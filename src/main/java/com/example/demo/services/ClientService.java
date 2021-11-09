package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.ClientModel;
import com.example.demo.repositories.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public ArrayList<ClientModel> obtenerUsuarios() {
        return (ArrayList<ClientModel>) clientRepository.findAll();
    }

    public ClientModel guardarUsuario(ClientModel cliente) {
        return clientRepository.save(cliente);
    }

    public Optional<ClientModel> obtenerPorId(Long id) {
        return clientRepository.findById(id);
    }

}
