package com.autofix.AUTOFIX_backend.services;

import com.autofix.AUTOFIX_backend.entities.DescuentoCantReparacionesEntity;
import com.autofix.AUTOFIX_backend.repositories.DescuentoCantReparacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DescuentoCantReparacionesService {
    @Autowired
    DescuentoCantReparacionesRepository descuentoCantReparacionesRepository;

    public DescuentoCantReparacionesEntity getCant(int cant) {return descuentoCantReparacionesRepository.findByCant(cant); }

}
