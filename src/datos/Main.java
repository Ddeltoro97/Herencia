/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class Main {
    
      private static ArrayList<Cuenta> cuentas = new ArrayList<>();
      private static int auxCuenta = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int opcion;
        int cuenta = 0;
        do{
            
        
        
        opcion = Integer.parseInt(JOptionPane.showInputDialog("Menu: " +
                "\n1. Crear nueva cuenta" +
                "\n2. Mostrar saldo cuenta" +
                "\n3. Hallar valor de interes sobre el saldo" +
                "\n4. Consignar dinero" +
                "\n5. Retirar dinero"+
                "\n6. 4x1000 acumulado"+
                "\n7. Eliminar cuenta" +
                "\n8. Salir"
                    ));
        switch (opcion){
            case 1:
                crearCuenta();
                break;
            case 2:
                cuenta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese número de cuenta a mostrar"));
                mostrarCuenta(cuenta);
                break;
            case 3:
                cuenta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese número de cuenta a mostrar"));
                mostrarInteres(cuenta);
                break;
            case 4:
                cuenta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese número de cuenta a mostrar"));
                consignar(cuenta);
                break;
            case 5:
                cuenta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese número de cuenta a mostrar"));
                retirar(cuenta);
                break;
            case 6:
                 cuenta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese número de cuenta a mostrar"));
                 cuatro(cuenta);
                 break;
            case 7:
                cuenta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese número de cuenta a eliminar"));
                borrar(cuenta);
                break;
            default:
                opcion = 8;
                break;
                
        }
        } while (opcion !=8);
        
      
        
    }
        
      private static void crearCuenta(){
            int tipo = Integer.parseInt(JOptionPane.showInputDialog("Tipo de cuenta: " + 
                    "\n1. Ahorros" +
                    "\n2. Corriente" +
                    "\n3. CDT "));
            
            int numeroCuenta = auxCuenta + 1;
            String titular = JOptionPane.showInputDialog("Titular: ");
            double saldo = Double.parseDouble(JOptionPane.showInputDialog("Saldo inicial: "));
            
            System.out.println(tipo);
            switch(tipo){
                case 1:
                    cuentas.add(new CuentaAhorros(numeroCuenta, titular, saldo, 0));
                    auxCuenta = auxCuenta + 1;
                    mostrarCuenta(numeroCuenta);
                    break;
                case 2:
                    cuentas.add(new CuentaCorriente(numeroCuenta, titular, saldo, 0));
                    auxCuenta = auxCuenta + 1;
                    mostrarCuenta(numeroCuenta);
                    break;
                case 3:
                    cuentas.add(new CuentaCDT(numeroCuenta, titular, saldo, 0));
                    auxCuenta = auxCuenta + 1;
                    mostrarCuenta(numeroCuenta);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Tipo de cuenta inválido");
            }
            
        }
      
    private static void mostrarCuenta(int usaCuenta){
        
        for (Cuenta cuenta : cuentas){
            if(cuenta.getNumeroCuenta() == usaCuenta){

                JOptionPane.showMessageDialog(null, "Información cuenta: " + cuenta.getNumeroCuenta()  +
                        "\n1. Titular " + cuenta.getTitular() +
                        "\n2. Saldo " + cuenta.getSaldo());
                return;
            } 
           
        }
         JOptionPane.showMessageDialog(null, "Cuenta no encontrada");
    }
    
    private static void mostrarInteres(int usaCuenta){
        for(Cuenta cuenta : cuentas){
            if(cuenta.getNumeroCuenta() == usaCuenta){
                JOptionPane.showMessageDialog(null, "El interes es " + cuenta.calcularInteres());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Cuenta no encontrada");
    }
    
    private static void consignar(int usaCuenta){
        for (Cuenta cuenta : cuentas){
            if(cuenta.getNumeroCuenta() == usaCuenta){
                double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor a consignar"));
                if (valor <= 0){
                    JOptionPane.showMessageDialog(null, "Solo debe ingresar números positivos");
                    return;
                }else{
                    cuenta.consignar(valor);
                    JOptionPane.showMessageDialog(null, "Nuevo sueldo " + cuenta.getSaldo());
                    return;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Cuenta no encontrada");
    }
    
    private static void retirar(int usaCuenta){
        for (Cuenta cuenta : cuentas){
            if(cuenta.getNumeroCuenta() == usaCuenta){
                  double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor a retirar"));
                   if (valor <= 0){
                        JOptionPane.showMessageDialog(null, "Solo debe ingresar números positivos");
                        return;
                }else{
                        cuenta.retirar(valor);
                        JOptionPane.showMessageDialog(null, "Nuevo sueldo " + cuenta.getSaldo());
                        return;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Cuenta no encontrada");
    }
    
    private static void cuatro(int usaCuenta){
         for (Cuenta cuenta : cuentas){
             if(cuenta.getNumeroCuenta() == usaCuenta){
                 JOptionPane.showMessageDialog(null, "Valor 4x1000 " + cuenta.getAcum());
                 return;
             }
         }
        JOptionPane.showMessageDialog(null, "Cuenta no encontrada");
    }
    
    private static void borrar(int usaCuenta){
        for (Cuenta cuenta: cuentas){          
            if(cuenta.getNumeroCuenta() == usaCuenta){
                cuentas.remove(cuenta);
                JOptionPane.showMessageDialog(null, "Cuenta eliminada");
            }
            
        }
         JOptionPane.showMessageDialog(null, "Cuenta no encontrada");
    }
    
}
