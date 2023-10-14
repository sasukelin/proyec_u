import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class AplicacionBancaria {
    private Map<String, CuentaBancaria> cuentas;
    private Scanner scanner;

    public AplicacionBancaria() {
        this.cuentas = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int option = -1;

        System.out.println("Bienvenido a la Aplicación Bancaria Wolf Bank");
        while (option != 0) {
            System.out.println("Por favor, elija una opción:");
            System.out.println("1. Crear una cuenta");
            System.out.println("2. Ingresa a tu cuenta");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    crearCuenta();
                    break;
                case 2:
                    ingresarCuenta();
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private void crearCuenta() {
        System.out.println("Ingrese su usuario:");
        String usuario = scanner.next();
        if (!cuentas.containsKey(usuario)) {
            System.out.println("Ingrese su saldo inicial:");
            double saldo = scanner.nextDouble();
            System.out.println("Ingrese su contraseña:");
            String password = scanner.next();
            CuentaBancaria cuenta = new CuentaBancaria(usuario, saldo, password);
            cuentas.put(usuario, cuenta);
            System.out.println("¡Cuenta creada exitosamente!");
        } else {
            System.out.println("Ya existe una cuenta con este usuario.");
        }
    }

    private void ingresarCuenta() {
        System.out.println("Ingresa tu usuario");
        String usuario = scanner.next();
        if (cuentas.containsKey(usuario)) {
            CuentaBancaria cuenta = cuentas.get(usuario);
            cuenta.ingresarCuenta(scanner);
        } else {
            System.out.println("El usuario no existe");
        }
    }
}