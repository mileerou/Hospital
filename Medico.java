public abstract class Medico {
    protected String idMedico;
    protected String nombreCompleto;
    protected String departamento;
    protected int tiempoExperiencia;
    protected double salarioBase;
    protected int pacientesAtendidos;
    protected boolean disponible;

    public Medico(String idMedico, String nombreCompleto, String departamento,
                  int tiempoExperiencia, double salarioBase) {
        this.idMedico = idMedico;
        this.nombreCompleto = nombreCompleto;
        this.departamento = departamento;
        this.tiempoExperiencia = tiempoExperiencia;
        this.salarioBase = salarioBase;
        this.disponible = true;
        this.pacientesAtendidos = 0;
    }

    public void nuevaConsulta() {
        pacientesAtendidos++;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public int getTiempoExperiencia() {
        return tiempoExperiencia;
    }

    public String getIdMedico() {
        return idMedico;
    }

    public abstract double calcularSalario();

    public abstract String informacionEmpleado();

    @Override
    public String toString() {
        return informacionEmpleado();
    }
}
