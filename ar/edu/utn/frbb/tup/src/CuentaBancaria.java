import java.util.ArrayList;
import java.util.List;


public abstract class CuentaBancaria {
    private int numeroCuenta;
    private Cliente cliente;
    private double saldo;
    private String tipoCuenta;
    private String fechaApertura;
    private List<MovimientoCuenta> movimientos;

    public CuentaBancaria(int numeroCuenta, Cliente cliente, double saldo, String tipoCuenta, String fechaApertura) {
        this.numeroCuenta = numeroCuenta;
        this.cliente = cliente;
        this.saldo = saldo;
        this.tipoCuenta = tipoCuenta;
        this.fechaApertura = fechaApertura;
        this.movimientos = new ArrayList<>();
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public List<MovimientoCuenta> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<MovimientoCuenta> movimientos) {
        this.movimientos = movimientos;
    }

    public abstract void depositar(double cantidad);
    public abstract void retirar(double cantidad);
    public abstract void transferir(CuentaBancaria destino, double cantidad);
    public abstract double consultarSaldo();
}
