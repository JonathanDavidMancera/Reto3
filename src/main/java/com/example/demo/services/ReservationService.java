package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.ReservationModel;
import com.example.demo.repositories.ReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Jonathan David Mancera - Sambas
 */
@Service
public class ReservationService {
    @Autowired
    /**
     * La anotación Autowired indica la inyección de dependencias
     */
    ReservationRepository reservationRepository;

    /**
     * El método obtener reservas devuelve un array con los objetos encontrados
     * @return
     */
    public ArrayList<ReservationModel> obtenerReservas() {
        return (ArrayList<ReservationModel>) reservationRepository.findAll();
    }

    /**
     * El método guardar toma como parámetro el un objeto de ReservationNodel y lo guarda en ReservationRepository gracias al método save que hereda de CrudRepository
     * @param reserva
     * @return
     */
    public ReservationModel guardarReserva(ReservationModel reserva) {
        return reservationRepository.save(reserva);
    }

    /**
     * Toma como parámetro id y hace uso del método findById
     * @param id
     * @return
     */
    public Optional<ReservationModel> obtenerReservaPorId(Long id) {
        return reservationRepository.findById(id);
    }

    /**
     * Intenta eliminar un usuario sí existe, de lo contrario con el catch evita que el programa se colapse
     * @param id
     * @return
     */
    public boolean eliminarUsuario(Long id) {
        try {
            reservationRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
