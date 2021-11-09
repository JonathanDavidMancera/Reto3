package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.MessageModel;
import com.example.demo.repositories.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;

    public ArrayList<MessageModel> obtenerMensajes() {
        return (ArrayList<MessageModel>) messageRepository.findAll();
    }

    public MessageModel guardarMensaje(MessageModel message) {
        return messageRepository.save(message);
    }

    public Optional<MessageModel> obtenerMensajePorId(Long id) {
        return messageRepository.findById(id);
    }
}