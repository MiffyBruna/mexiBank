package mexbank;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author czarat
 */
public class CuentaAhorro extends CuentaBase {

    public CuentaAhorro(double apertura) {
        super();
        abrirCuenta(apertura);
    }

    public void invertir() {
        double interes = getMontoActual() * 0.10;
        depositar(interes);
    }

}
