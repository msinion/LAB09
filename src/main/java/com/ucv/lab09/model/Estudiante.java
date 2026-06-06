package com.ucv.lab09.model;

import com.ucv.lab09.service.Constantes;

import java.io.Serializable;

public abstract class Estudiante
        implements Serializable, Constantes {

    protected String codigo;
    protected String apellidos;
    protected String nombres;
    protected String semestreIngreso;

    public Estudiante() {
    }

    public Estudiante(String apellidos,
                      String nombres,
                      String semestreIngreso) {

        this.apellidos = apellidos;
        this.nombres = nombres;
        this.semestreIngreso = semestreIngreso;
    }

    public abstract double pagoParcialPension();

    public abstract double descuentos();

    public double pagoFinalPension() {
        return pagoParcialPension() - descuentos();
    }

    public String mostrarDatos() {

        return "Código: " + codigo +
                "\nApellidos: " + apellidos +
                "\nNombres: " + nombres +
                "\nSemestre: " + semestreIngreso;
    }

    // getters y setters

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getSemestreIngreso() {
        return semestreIngreso;
    }

    public void setSemestreIngreso(String semestreIngreso) {
        this.semestreIngreso = semestreIngreso;
    }
}