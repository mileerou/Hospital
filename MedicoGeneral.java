public class MedicoGeneral extends Medico {
    private String especializacion;
    private int capacidadDia;
    private double tarifaConsulta;

    public MedicoGeneral(String id, String nombre, String dep, int exp, double base,
                         String especializacion, int capacidadDia, double tarifaConsulta) {
        super(id, nombre, dep, exp, base);
        this.especializacion = especializacion;
        this.capacidadDia = capacidadDia;
        this.tarifaConsulta = tarifaConsulta;
    }

    @Override
    public double calcularSalario() {
        return salarioBase + (pacientesAtendidos * tarifaConsulta);
    }

    @Override
    public String informacionEmpleado() {
        return "Médico General: " + nombreCompleto +
                " | Esp: " + especializacion +
                " | Capacidad diaria: " + capacidadDia;
    }
}
