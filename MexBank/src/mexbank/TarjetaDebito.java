package mexbank;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author czarat
 */
public class TarjetaDebito extends CuentaBase{
    public TarjetaDebito(double apertura){
        super();
        abrirCuenta(apertura);
    }
    
    protected void retirar(double cantidad){
        depositar(-cantidad); 
        
    }
    
}
