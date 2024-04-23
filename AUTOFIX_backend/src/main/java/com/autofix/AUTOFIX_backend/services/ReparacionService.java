package com.autofix.AUTOFIX_backend.services;

import com.autofix.AUTOFIX_backend.entities.ReparacionEntity;
import com.autofix.AUTOFIX_backend.repositories.ReparacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReparacionService {
    @Autowired
    ReparacionRepository reparacionRepository;


    public ReparacionEntity saveReparacion(ReparacionEntity reparacion) {return reparacionRepository.save(reparacion); }
    public ReparacionEntity updateReparacion(ReparacionEntity reparacion) {return reparacionRepository.save(reparacion); }
}
