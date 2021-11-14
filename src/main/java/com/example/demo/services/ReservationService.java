package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.ReservationModel;
import com.example.demo.repositories.ReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    ReservationRepository reservationRepository;

    public ArrayList<ReservationModel> obtenerReservas() {
        return (ArrayList<ReservationModel>) reservationRepository.findAll();
    }

    public ReservationModel guardarReserva(ReservationModel reserva) {
        return reservationRepository.save(reserva);
    }

    public Optional<ReservationModel> obtenerReservaPorId(Long id) {
        return reservationRepository.findById(id);
    }

    public boolean eliminarUsuario(Long id) {
        try {
            reservationRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
