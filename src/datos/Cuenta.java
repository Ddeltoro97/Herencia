/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author USER
 */
public class Cuenta {
    private int numeroCuenta;
    private String titular;
    private double saldo;
    private double acum;

    public double getAcum() {
        return acum;
    }

    public void setAcum(double acum) {
        this.acum = acum;
    }

    public Cuenta(int numeroCuenta, String titular, double saldo, double acum) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
        this.acum = acum;
    }


    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }
    
    public void consignar(double cantidad){
        this.saldo = this.saldo + cantidad;
    }
    
    public void retirar(double cantidad){
        this.saldo = this.saldo - cantidad;
    }
    
    public double calcularInteres(){
        return this.saldo * 0.005;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    
    
}
