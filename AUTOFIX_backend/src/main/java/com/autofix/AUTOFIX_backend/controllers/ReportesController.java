package com.autofix.AUTOFIX_backend.controllers;

import com.autofix.AUTOFIX_backend.services.ReportesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autofix/v1/reportes")
@CrossOrigin("*")
public class ReportesController {
    @Autowired
    ReportesService reportesService;

    @GetMapping("/R2")
    public ResponseEntity<List<List<Object>>> generarReporteR2() {
        List<List<Object>> R2 = reportesService.R2();
        return ResponseEntity.ok(R2);
    }
    @GetMapping("/R3")
    public ResponseEntity<List<List<Object>>> generarReporteR3() {
        List<List<Object>> R3 = reportesService.R3();
        return ResponseEntity.ok(R3);
    }
    @GetMapping("/R4")
    public ResponseEntity<List<List<Object>>> generarReporteR4() {
        List<List<Object>> R4 = reportesService.R4();
        return ResponseEntity.ok(R4);
    }
}
