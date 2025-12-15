package com.ecouv.EcoUv.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/uv")
public class UvController {

    @GetMapping
    public Map<String, Object> obtenerNivelUv() {

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("nivelUV", 8);
        respuesta.put("riesgo", "Alto");

        return respuesta;
    }
}
