public class Cirujano extends Medico {
    private String tipoOperacion;
    private int horasDisponibles;
    private double bonoRiesgo;

    public Cirujano(String id, String nombre, String dep, int exp, double base,
                    String tipoOperacion, int horasDisponibles, double bonoRiesgo) {
        super(id, nombre, dep, exp, base);
        this.tipoOperacion = tipoOperacion;
        this.horasDisponibles = horasDisponibles;
        this.bonoRiesgo = bonoRiesgo;
    }

    @Override
    public double calcularSalario() {
        return salarioBase + (horasDisponibles * 300) + bonoRiesgo;
    }

    @Override
    public String informacionEmpleado() {
        return "Cirujano: " + nombreCompleto +
                " | Tipo operación: " + tipoOperacion +
                " | Horas disponibles: " + horasDisponibles;
    }
}
