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
public class CuentaCorriente extends Cuenta {
    public CuentaCorriente(int numeroCuenta, String titular, double saldo, double acum){
        super(numeroCuenta, titular, saldo, acum);
    }

    
    @Override
    public double calcularInteres(){
        return getSaldo() * 0.01; 
    }
}
