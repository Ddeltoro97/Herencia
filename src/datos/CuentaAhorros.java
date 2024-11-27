/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class CuentaAhorros extends Cuenta {

    public CuentaAhorros(int numeroCuenta, String titular, double saldo, double acum){
        super(numeroCuenta, titular, saldo, acum);
    }

    public double cuatroPorMil(double cantidad){
        double valor = cantidad * 0.004;
        return valor;
    }
    
    @Override
    public void retirar(double cantidad){
        double aux = cuatroPorMil(cantidad);
        double cantidadFinal = cantidad + aux;
        if (getSaldo() - cantidadFinal  >= 100000){
            setSaldo(getSaldo() - cantidadFinal );
            setAcum(aux + getAcum());
            JOptionPane.showMessageDialog(null, "Quedan " + getSaldo());
        }
        else{
            JOptionPane.showMessageDialog(null, "Fondos insuficientes " +getSaldo());
        }
    }
}
