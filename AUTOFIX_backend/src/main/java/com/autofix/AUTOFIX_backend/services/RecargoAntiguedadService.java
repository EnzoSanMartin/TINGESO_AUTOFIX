package com.autofix.AUTOFIX_backend.services;

import com.autofix.AUTOFIX_backend.entities.RecargoAntiguedadEntity;
import com.autofix.AUTOFIX_backend.repositories.RecargoAntiguedadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecargoAntiguedadService {
    @Autowired
    RecargoAntiguedadRepository recargoAntiguedadRepository;

    public RecargoAntiguedadEntity getAño(int año) {return  recargoAntiguedadRepository.findByAño(año); }
}
