package com.ucv.lab09.service;

import com.ucv.lab09.model.Estudiante;

public class EstudianteService
        implements IEstudianteService {

    @Override
    public String mostrarInformacion(
            Estudiante estudiante) {

        return estudiante.mostrarDatos();
    }
}