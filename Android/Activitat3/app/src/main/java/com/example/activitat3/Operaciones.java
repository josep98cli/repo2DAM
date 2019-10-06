package com.example.activitat3;

public class Operaciones {
    private double numero1;
    private double numero2;
    private String operacion1;

    public Operaciones(double numero1, double numero2, String operacion1) {
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.operacion1 = operacion1;
    }

    public Operaciones() {
    }

    public double getNumero1() {
        return numero1;
    }

    public void setNumero1(double numero1) {
        this.numero1 = numero1;
    }

    public double getNumero2() {
        return numero2;
    }

    public void setNumero2(double numero2) {
        this.numero2 = numero2;
    }

    public String getOperacion1() {
        return operacion1;
    }

    public void setOperacion1(String operacion1) {
        this.operacion1 = operacion1;
    }

    double operacionSuma(double numero1, double numero2){
        return numero1+numero2;
    }

    double operacionResta(double numero1, double numero2){
        return numero1-numero2;
    }
    double operacionMulti(double numero1, double numero2){
        return numero1*numero2;
    }
    double operacionDivision(double numero1, double numero2){
        return numero1/numero2;
    }
}
