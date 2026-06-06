package com.ucv.lab09.model;

public class EstudiantePreGrado extends Estudiante {

    private String categoria;
    private double promedioPonderado;
    private String colegioProcedencia;

    private static int contador = 0;

    public EstudiantePreGrado(
            String apellidos,
            String nombres,
            String semestreIngreso,
            String categoria,
            double promedioPonderado,
            String colegioProcedencia) {

        super(apellidos, nombres, semestreIngreso);

        this.categoria = categoria;
        this.promedioPonderado = promedioPonderado;
        this.colegioProcedencia = colegioProcedencia;

        this.codigo = generarCodigo();
    }

    public String generarCodigo() {

        contador++;

        return String.format("EPRE%04d", contador);
    }

    @Override
    public double pagoParcialPension() {

        if (categoria.equalsIgnoreCase("A")) {

            if (colegioProcedencia.equalsIgnoreCase("Estatal"))
                return 320;
            else
                return 450;
        }

        if (colegioProcedencia.equalsIgnoreCase("Estatal"))
            return 300;
        else
            return 420;
    }

    @Override
    public double descuentos() {

        if (promedioPonderado >= 13)
            return pagoParcialPension() * 0.08;

        return 0;
    }

    public String mostrarDatos(boolean completo) {

        return super.mostrarDatos()
                + "\nCategoría: " + categoria
                + "\nPromedio: " + promedioPonderado
                + "\nColegio: " + colegioProcedencia
                + "\nPago Parcial: " + pagoParcialPension()
                + "\nDescuento: " + descuentos()
                + "\nPago Final: " + pagoFinalPension();
    }
}