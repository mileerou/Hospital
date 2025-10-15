public class Pediatra extends Medico {
    private double tarifaConsulta;
    private boolean turnoUrgencia;
    private double bonoUrgencia;

    public Pediatra(String id, String nombre, String dep, int exp, double base,
                    double tarifaConsulta, boolean turnoUrgencia, double bonoUrgencia) {
        super(id, nombre, dep, exp, base);
        this.tarifaConsulta = tarifaConsulta;
        this.turnoUrgencia = turnoUrgencia;
        this.bonoUrgencia = bonoUrgencia;
    }

    @Override
    public double calcularSalario() {
        return salarioBase + (pacientesAtendidos * tarifaConsulta)
                + (turnoUrgencia ? bonoUrgencia : 0);
    }

    @Override
    public String informacionEmpleado() {
        return "Pediatra: " + nombreCompleto +
                " | Turno urgencia: " + turnoUrgencia;
    }
}
