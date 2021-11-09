package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.ReservationModel;
import com.example.demo.services.ReservationService;

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
@RequestMapping("/api/Reservation")
public class ReservationController {
    
    @Autowired
    ReservationService reservationService;

    @GetMapping("/all")
    public ArrayList<ReservationModel> obtenerReservas() {
        return reservationService.obtenerReservas();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationModel guardarReserva(@RequestBody ReservationModel reserva) {
        return this.reservationService.guardarReserva(reserva);
    }

    @GetMapping( path = "/{id}")
    public Optional<ReservationModel> obtenerReservaPorId(@PathVariable("id")Long id) {
        return this.reservationService.obtenerReservaPorId(id);
    }
}
