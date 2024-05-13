public class MovimientoCuenta {
    private String tipoOperacion;
    private double monto;

    public MovimientoCuenta(String tipoOperacion, double monto) {
        this.tipoOperacion = tipoOperacion;
        this.monto = monto;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
