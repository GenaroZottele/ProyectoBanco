import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class SistemaBancario {
    private List<Cliente> clientes;
    private List<CuentaBancaria> cuentas;
    private Random random;

    public SistemaBancario() {
        clientes = new ArrayList<>();
        cuentas = new ArrayList<>();
        random = new Random();
    }

    public void agregarCliente(Cliente cliente) {
        int numeroCuenta = generarNumeroCuentaUnico();
        cliente.setNumeroCuenta(numeroCuenta);
        
        CuentaBancaria cuenta = new CuentaCorriente(numeroCuenta, cliente, 0, "Hoy");
        cuentas.add(cuenta);
        
        clientes.add(cliente);
        System.out.println("Cliente agregado correctamente.");
        System.out.println("Número de cuenta asignado: " + numeroCuenta);
    }


    private int generarNumeroCuentaUnico() {
        int numeroCuenta;
        do {
            numeroCuenta = 1000 + random.nextInt(9000); // Genera un número de cuenta de 4 dígitos
        } while (buscarCuentaPorNumero(numeroCuenta) != null);
        return numeroCuenta;
    }

    private CuentaBancaria buscarCuentaPorNumero(int numeroCuenta) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getNumeroCuenta() == numeroCuenta) {
                return cuenta;
            }
        }
        return null;
    }

    public void eliminarCliente(int idCliente) {
        clientes.removeIf(c -> c.getId() == idCliente);
    }

    public void agregarCuenta(CuentaBancaria cuenta) {
        cuentas.add(cuenta);
    }

    public void realizarDeposito(int numeroCuenta, double cantidad) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getNumeroCuenta() == numeroCuenta) {
                cuenta.depositar(cantidad);
                System.out.println("Depósito realizado correctamente.");
                return;
            }
        }
        System.out.println("Cuenta no encontrada.");
    }

    public void realizarRetiro(int numeroCuenta, double cantidad) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getNumeroCuenta() == numeroCuenta) {
                cuenta.retirar(cantidad);
                System.out.println("Retiro realizado correctamente.");
                return;
            }
        }
        System.out.println("Cuenta no encontrada.");
    }

    public void realizarTransferencia(int origen, int destino, double cantidad) {
        CuentaBancaria cuentaOrigen = null;
        CuentaBancaria cuentaDestino = null;

        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getNumeroCuenta() == origen) {
                cuentaOrigen = cuenta;
            } else if (cuenta.getNumeroCuenta() == destino) {
                cuentaDestino = cuenta;
            }
        }

        if (cuentaOrigen != null && cuentaDestino != null) {
            cuentaOrigen.transferir(cuentaDestino, cantidad);
            System.out.println("Transferencia realizada correctamente.");
        } else {
            System.out.println("Una o ambas cuentas no encontradas.");
        }
    }

    public double consultarSaldo(int numeroCuenta) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getNumeroCuenta() == numeroCuenta) {
                return cuenta.consultarSaldo();
            }
        }
        System.out.println("Cuenta no encontrada.");
        return -1;
    }
    public Cliente buscarClientePorId(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }
}

