package com.autofix.AUTOFIX_backend.services;

import com.autofix.AUTOFIX_backend.entities.HistorialReparacionEntity;
import com.autofix.AUTOFIX_backend.entities.ReparacionEntity;
import com.autofix.AUTOFIX_backend.repositories.HistorialReparacionRepository;
import com.autofix.AUTOFIX_backend.repositories.ReparacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HistorialReparacionService {
    @Autowired
    HistorialReparacionRepository historialReparacionRepository;

    @Autowired
    ReparacionEntity reparacionEntity;

    @Autowired
    ReparacionRepository reparacionRepository;

    public int calcularMontoTotal(HistorialReparacionEntity historialReparacionEntity) {

    }



}
