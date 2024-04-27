package com.autofix.AUTOFIX_backend.services;

import com.autofix.AUTOFIX_backend.entities.BonoEntity;
import com.autofix.AUTOFIX_backend.repositories.BonoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Service
public class BonoService {
    @Autowired
    BonoRepository bonoRepository;

    public BonoEntity getMarca(String marca) {return bonoRepository.findByMarca(marca); }
    public BonoEntity getCantBonos (int cantBonos) {return bonoRepository.findByCantBonos(cantBonos); }
    public BonoEntity getMonto(Long monto) {return bonoRepository.findByMonto(monto); }

    public ArrayList<BonoEntity> getCantBonosBetween(int cantBonosI, int cantBonosF) {return (ArrayList<BonoEntity>) bonoRepository.findByCantBonosBetween(cantBonosI, cantBonosF); }

    public BonoEntity saveBono(BonoEntity bono) {return bonoRepository.save(bono); }
    public BonoEntity updateBono(BonoEntity bono) {return  bonoRepository.save(bono); }
}
