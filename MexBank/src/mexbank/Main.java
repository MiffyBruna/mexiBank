/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mexbank;

import java.util.Scanner;

/**
 *
 * @author czarat
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("¡Bienvenido a MexBank, tu banco virtual!");

        // Ask the user to specify the account type
        boolean validAccountTypeSelected = false;
        int accountType = 0; // Initialize with an invalid value

        try (var scanner = new Scanner(System.in)) {

            while (!validAccountTypeSelected) {
                // Ask the user to specify the account type
                System.out.print("Selecciona tipo de cuenta (1: TarjetaCredito, 2: TarjetaDebito, 3: CuentaAhorro): ");
                accountType = scanner.nextInt();

                if (accountType >= 1 && accountType <= 3) {
                    validAccountTypeSelected = true;
                } else {
                    System.out.println("Tipo de cuenta no válido. Por favor, selecciona una opción válida.");
                }

            }

            // Depending on the user's choice, create the corresponding account type
            switch (accountType) {
                case 1 -> {
                    System.out.print("Seleccionaste Crédito, Cuál es el monto del préstamo? ");
                    Double monto = scanner.nextDouble();
                    var account = new TarjetaCredito(monto);
                    System.out.print("\nEl balance inicial es: " + account.getMontoActual());
                    account.sumarInteres();
                    System.out.print("\nEl balance después de interés es: " + account.getMontoActual());

                    realizarDeposito(scanner, account);
                    System.out.println("¡ADIOS!");
                }

                case 2 -> {
                    System.out.print("Seleccionaste Débito, Cuál es monto de apertura? ");
                    Double apertura_debito = scanner.nextDouble();
                    var cuenta_debito = new TarjetaDebito(apertura_debito);
                    System.out.print("\nEl Balance inicial es de: " + cuenta_debito.getMontoActual());
                    realizarRetiro(scanner, cuenta_debito);
                    realizarDeposito(scanner, cuenta_debito);
                    System.out.println("¡ADIOS!");
                }
                case 3 -> {
                    System.out.print("Seleccionaste Ahorro, Con cuanto desea abrir la cuenta? ");
                    Double apertura_prestamo = scanner.nextDouble();
                    CuentaAhorro cuenta_ahorro = new CuentaAhorro(apertura_prestamo);
                    System.out.print("\nEl Balance inicial es de: " + cuenta_ahorro.getMontoActual());
                    realizarDeposito(scanner, cuenta_ahorro);
                    cuenta_ahorro.invertir();
                    System.out.print("INVIRTIENDO ");
                    System.out.print("\n***********************");
                    System.out.print("\n***********************");
                    System.out.print("\n***********************");
                    revisarBalance(scanner, cuenta_ahorro);
                }
                default -> {
                    System.out.println("Invalid account type.");
                }
            }

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }
    }

    public static void realizarDeposito(Scanner scanner, CuentaBase account) {
        System.out.print("\n¿Deseas hacer un depósito? (Sí o No): ");
        String depositChoice = scanner.next();

        if (depositChoice.equalsIgnoreCase("Sí") || depositChoice.equalsIgnoreCase("si") || depositChoice.equalsIgnoreCase("s")) {
            System.out.print("¿Cuál es el monto del depósito? ");
            double deposito = scanner.nextDouble();
            account.depositar(deposito);
            System.out.print("Balance final: ");
            System.out.printf("%.2f%n", account.getMontoActual());
        } else {
            System.out.print("Balance final: ");
            System.out.printf("%.2f%n", account.getMontoActual());
        }
    }

    public static void realizarRetiro(Scanner scanner, TarjetaDebito account) {
        System.out.print("\n¿Deseas hacer un retiro? (Sí o No): ");
        String retiroChoice = scanner.next();

        if (retiroChoice.equalsIgnoreCase("Sí") || retiroChoice.equalsIgnoreCase("si") || retiroChoice.equalsIgnoreCase("s")) {
            System.out.print("¿Cuál es el monto del retiro? ");
            double retiro = scanner.nextDouble();
            account.retirar(retiro);
            System.out.print("Balance final: ");
            System.out.printf("%.2f%n", account.getMontoActual());
        } else {
            System.out.print("Balance final: ");
            System.out.printf("%.2f%n", account.getMontoActual());
        }
    }

    private static void revisarBalance(Scanner scanner, CuentaBase account) {
        System.out.print("\n¿Deseas revisar tu balance? (Sí o No): ");
        String balanceChoice = scanner.next();

        if (balanceChoice.equalsIgnoreCase("Si") || balanceChoice.equalsIgnoreCase("Sí") || balanceChoice.equalsIgnoreCase("s")) {
            System.out.print("El balance es: ");
            System.out.printf("%.2f%n", account.getMontoActual());
        } else {
            System.out.println("¡ADIOS!");
        }
    }
}
