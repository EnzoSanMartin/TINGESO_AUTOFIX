package com.autofix.AUTOFIX_backend.services;

import com.autofix.AUTOFIX_backend.entities.RecargoKilometrajeEntity;
import com.autofix.AUTOFIX_backend.repositories.RecargoKilometrajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecargoKilometrajeService {
    @Autowired
    RecargoKilometrajeRepository recargoKilometrajeRepository;

    public RecargoKilometrajeEntity getKM(Long kilometraje) { return recargoKilometrajeRepository.findByKM(kilometraje); }
}
