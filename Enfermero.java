public class Enfermero extends Medico {
    private String tipoTurno;
    private String nivelCertificacion;
    private boolean nocturno;
    private double bonoNocturno;

    public Enfermero(String id, String nombre, String dep, int exp, double base,
                     String tipoTurno, String nivelCertificacion, boolean nocturno, double bonoNocturno) {
        super(id, nombre, dep, exp, base);
        this.tipoTurno = tipoTurno;
        this.nivelCertificacion = nivelCertificacion;
        this.nocturno = nocturno;
        this.bonoNocturno = bonoNocturno;
    }

    @Override
    public double calcularSalario() {
        return salarioBase + (nocturno ? bonoNocturno : 0);
    }

    @Override
    public String informacionEmpleado() {
        return "Enfermero: " + nombreCompleto +
                " | Turno: " + tipoTurno +
                " | Certificación: " + nivelCertificacion;
    }
}
