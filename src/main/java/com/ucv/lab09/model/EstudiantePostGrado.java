package com.ucv.lab09.model;

public class EstudiantePostGrado extends Estudiante {

    private String gradoAcademico;

    private static int contador = 0;

    public EstudiantePostGrado(
            String apellidos,
            String nombres,
            String semestreIngreso,
            String gradoAcademico) {

        super(apellidos, nombres, semestreIngreso);

        this.gradoAcademico = gradoAcademico;

        this.codigo = generarCodigo();
    }

    public String generarCodigo() {

        contador++;

        return String.format("EPOS%04d", contador);
    }

    @Override
    public double pagoParcialPension() {

        if (gradoAcademico.equalsIgnoreCase("Bachiller"))
            return 400;

        return 350;
    }

    @Override
    public double descuentos() {
        return 0;
    }

    public String mostrarDatos(boolean completo) {

        return super.mostrarDatos()
                + "\nGrado Académico: " + gradoAcademico
                + "\nPago Parcial: " + pagoParcialPension()
                + "\nPago Final: " + pagoFinalPension();
    }
}