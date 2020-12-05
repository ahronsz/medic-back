package com.upc.medicback.jms;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.upc.medicback.entidades.Cita;
import com.upc.medicback.entidades.CitaOyente;
import com.upc.medicback.services.ServicioCitaCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JmsOyente {

    @Autowired
    private ServicioCitaCore servicioCitaCore;

    @JmsListener(destination = "cola.medic")
    public void saveCita(String mensaje) {
        System.out.println("Recibido: " + mensaje);
        ObjectMapper mapper = new ObjectMapper();
        try {
            CitaOyente cita = mapper.readValue(mensaje, CitaOyente.class);
            System.out.println(cita);
            String msjConsola = servicioCitaCore.registrarColaCita(cita);
            System.out.println(msjConsola);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
