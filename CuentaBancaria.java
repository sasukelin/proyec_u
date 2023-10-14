
import java.util.Scanner;

class CuentaBancaria {
    private String usuario;
    private double saldo;
    private String password;

    public CuentaBancaria(String usuario, double saldo, String password) {
        this.usuario = usuario;
        this.saldo = saldo;
        this.password = password;
    }

    public void ingresarCuenta(Scanner scanner) {
        System.out.println("Ingresa Contraseña ");
        String inputPassword = scanner.next();
        if (inputPassword.equals(1234)) {
            System.out.println("Bienvenido " + usuario);
            int opcion = -1;

            while (opcion != 0) {
                System.out.println("Por favor, elija una opción:");
                System.out.println("1. Consultar saldo");
                System.out.println("2. Ingresar dinero");
                System.out.println("3. Retirar dinero");
                System.out.println("4. Realizar una transacción");
                System.out.println("0. Salir");

                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Su saldo es: " + saldo);
                        break;
                    case 2:
                        System.out.println("Ingrese la cantidad a depositar:");
                        double cantidadDeposito = scanner.nextDouble();
                        depositar(cantidadDeposito);
                        break;
                    case 3:
                        System.out.println("Ingrese la cantidad a retirar:");
                        double cantidadRetiro = scanner.nextDouble();
                        retirar(cantidadRetiro);
                        break;
                    case 4:
                        realizarTransaccion(); 
                        break;
                    case 0:
                        System.out.println("Saliendo de la cuenta. ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            }
        } else {
            System.out.println("Contraseña incorrecta");
        }
    }


    private void depositar(double cantidad) {
        saldo += cantidad;
        System.out.println("Depósito realizado exitosamente. Saldo actual: " + saldo);
    }

    private void retirar(double cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
            System.out.println("Retiro realizado exitosamente. Saldo actual: " + saldo);
        } else {
            System.out.println("Fondos insuficientes.");
        }
    }

    private void realizarTransaccion() {

    }
}
