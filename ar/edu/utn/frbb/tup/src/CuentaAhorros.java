public class CuentaAhorros extends CuentaBancaria {

    public CuentaAhorros(int numeroCuenta, Cliente cliente, double saldo, String fechaApertura) {
        super(numeroCuenta, cliente, saldo, "Ahorros", fechaApertura);
    }

    @Override
    public void depositar(double cantidad) {
        setSaldo(getSaldo() + cantidad);
        getMovimientos().add(new MovimientoCuenta("Depósito", cantidad));
    }

    @Override
    public void retirar(double cantidad) {
        if (cantidad <= getSaldo()) {
            setSaldo(getSaldo() - cantidad);
            getMovimientos().add(new MovimientoCuenta("Retiro", -cantidad));
        } else {
            System.out.println("Saldo insuficiente para realizar el retiro.");
        }
    }

    @Override
    public void transferir(CuentaBancaria destino, double cantidad) {
        if (cantidad <= getSaldo()) {
            setSaldo(getSaldo() - cantidad);
            destino.depositar(cantidad);
            getMovimientos().add(new MovimientoCuenta("Transferencia enviada", -cantidad));
            destino.getMovimientos().add(new MovimientoCuenta("Transferencia recibida", cantidad));
        } else {
            System.out.println("Saldo insuficiente para realizar la transferencia.");
        }
    }

    @Override
    public double consultarSaldo() {
        return getSaldo();
    }
}