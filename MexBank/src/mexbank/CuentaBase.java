/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mexbank;

/**
 *
 * @author czarat
 */
public class CuentaBase {

    private double montoActual;

    public void abrirCuenta(double monto) {
        this.montoActual = monto;
    }

    public void depositar(double monto) {
        this.montoActual += monto;
    }

    protected double getMontoActual() {
        return this.montoActual;

    }

}
