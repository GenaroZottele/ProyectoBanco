
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaBancario sistema = new SistemaBancario();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bienvenido al Sistema Bancario");
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Agregar Cuenta a Cliente Existente");
            System.out.println("3. Realizar Depósito");
            System.out.println("4. Realizar Retiro");
            System.out.println("5. Realizar Transferencia");
            System.out.println("6. Consultar Saldo");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarCliente(sistema, scanner);
                    break;
                case 2:
                    agregarCuentaAClienteExistente(sistema, scanner);
                    break;
                case 3:
                    realizarDeposito(sistema, scanner);
                    break;
                case 4:
                    realizarRetiro(sistema, scanner);
                    break;
                case 5:
                    realizarTransferencia(sistema, scanner);
                    break;
                case 6:
                    consultarSaldo(sistema, scanner);
                    break;
                case 7:
                    System.out.println("Gracias por utilizar nuestro servicio. ¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione nuevamente.");
            }
        }
    }

    private static void agregarCliente(SistemaBancario sistema, Scanner scanner) {
        System.out.print("Ingrese el ID del cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del cliente: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese la dirección del cliente: ");
        String direccion = scanner.nextLine();
        System.out.print("Ingrese el número de teléfono del cliente: ");
        String telefono = scanner.nextLine();

        Cliente cliente = new Cliente(id, nombre, apellido, direccion, telefono);
        sistema.agregarCliente(cliente);
    }

    private static void agregarCuentaAClienteExistente(SistemaBancario sistema, Scanner scanner) {
        System.out.print("Ingrese el ID del cliente al que desea agregar la cuenta: ");
        int idCliente = scanner.nextInt();
        Cliente cliente = sistema.buscarClientePorId(idCliente);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        
        System.out.print("Ingrese el número de cuenta: ");
        int numeroCuenta = scanner.nextInt();
        System.out.print("Ingrese el saldo inicial: ");
        double saldo = scanner.nextDouble();
        System.out.print("Ingrese el tipo de cuenta (Corriente/Ahorros): ");
        scanner.nextLine(); 
        String tipoCuenta = scanner.nextLine();
        System.out.print("Ingrese la fecha de apertura: ");
        String fechaApertura = scanner.nextLine();

        CuentaBancaria cuenta;
        if ("Corriente".equalsIgnoreCase(tipoCuenta)) {
            cuenta = new CuentaCorriente(numeroCuenta, cliente, saldo, fechaApertura);
        } else if ("Ahorros".equalsIgnoreCase(tipoCuenta)) {
            cuenta = new CuentaAhorros(numeroCuenta, cliente, saldo, fechaApertura);
        } else {
            System.out.println("Tipo de cuenta no válido.");
            return;
        }

        sistema.agregarCuenta(cuenta);
        cliente.agregarCuentaBancaria(cuenta);
    }

    private static void realizarDeposito(SistemaBancario sistema, Scanner scanner) {
        System.out.print("Ingrese el número de cuenta: ");
        int numeroCuenta = scanner.nextInt();
        System.out.print("Ingrese la cantidad a depositar: ");
        double cantidad = scanner.nextDouble();

        sistema.realizarDeposito(numeroCuenta, cantidad);
    }

    private static void realizarRetiro(SistemaBancario sistema, Scanner scanner) {
        System.out.print("Ingrese el número de cuenta: ");
        int numeroCuenta = scanner.nextInt();
        System.out.print("Ingrese la cantidad a retirar: ");
        double cantidad = scanner.nextDouble();

        sistema.realizarRetiro(numeroCuenta, cantidad);
    }

    private static void realizarTransferencia(SistemaBancario sistema, Scanner scanner) {
        System.out.print("Ingrese el número de cuenta de origen: ");
        int origen = scanner.nextInt();
        System.out.print("Ingrese el número de cuenta de destino: ");
        int destino = scanner.nextInt();
        System.out.print("Ingrese la cantidad a transferir: ");
        double cantidad = scanner.nextDouble();

        sistema.realizarTransferencia(origen, destino, cantidad);
    }

    private static void consultarSaldo(SistemaBancario sistema, Scanner scanner) {
        System.out.print("Ingrese el número de cuenta: ");
        int numeroCuenta = scanner.nextInt();

        double saldo = sistema.consultarSaldo(numeroCuenta);
        if (saldo != -1) {
            System.out.println("El saldo de la cuenta " + numeroCuenta + " es: $" + saldo);
        }
    }
}

