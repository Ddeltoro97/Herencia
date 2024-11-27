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
public class CuentaCDT extends Cuenta{
     public CuentaCDT(int numeroCuenta, String titular, double saldo, double acum){
        super(numeroCuenta, titular, saldo, acum);
    }
     
    public double penalizacion(double cantidad){
        return cantidad * 0.30;
    }
    
     @Override
    public void consignar(double cantidad){
        System.out.println("Esto no se puede realizar ");
    }
    
    @Override
    public double calcularInteres(){
        return getSaldo() * 0.1;
    }
    
    @Override
    public void retirar(double cantidad){
        double valor = cantidad + penalizacion(cantidad);
        if(getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
        } else{
            System.out.println("Fondos insuficientes: " + getSaldo());
        }
    }
    
    
}
