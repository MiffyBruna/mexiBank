package mexbank;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author czarat
 */
public class TarjetaCredito extends CuentaBase {

    public TarjetaCredito(double apertura) {
        super();
        // Balance de línea de crédito siempre es negativa

        if (apertura < 0) {
            abrirCuenta(apertura);
        } else {
            apertura = -apertura;
            abrirCuenta(apertura);
        }

    }

    public void sumarInteres() {
        // Sumar el 15% del monto actual a la deuda
        double interes = getMontoActual() * 0.15;
        depositar(interes);
    }

}
