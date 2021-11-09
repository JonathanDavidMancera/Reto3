package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.MessageModel;
import com.example.demo.services.MessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Message")
public class MessageController {
    
    @Autowired
    MessageService messageService;

    @GetMapping("/all")
    public ArrayList<MessageModel> obtenerMensajes() {
        return messageService.obtenerMensajes();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageModel guardarMensaje(@RequestBody MessageModel message) {
        return this.messageService.guardarMensaje(message);
    }

    @GetMapping( path = "/{id}")
    public Optional<MessageModel> obtenerMensajePorId(@PathVariable("id") Long id) {
        return this.messageService.obtenerMensajePorId(id);
    }
}
