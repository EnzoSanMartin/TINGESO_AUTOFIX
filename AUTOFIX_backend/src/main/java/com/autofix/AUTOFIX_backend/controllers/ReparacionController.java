package com.autofix.AUTOFIX_backend.controllers;

import com.autofix.AUTOFIX_backend.entities.ReparacionEntity;
import com.autofix.AUTOFIX_backend.services.ReparacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/autofix/v1/reparaciones")
@CrossOrigin("*")
public class ReparacionController {
    @Autowired
    ReparacionService reparacionService;
}
