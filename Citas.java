import java.time.LocalDateTime;

public class Citas {
    private int idCita;
    private String nombrePaciente;
    Medico medicoAsignado;
    private LocalDateTime fechaHora;
    private String tipoCita;
    private EstadoCita estado;

    public Citas(int idCita, String nombrePaciente, Medico medicoAsignado,
                 LocalDateTime fechaHora, String tipoCita) {
        this.idCita = idCita;
        this.nombrePaciente = nombrePaciente;
        this.medicoAsignado = medicoAsignado;
        this.fechaHora = fechaHora;
        this.tipoCita = tipoCita;
        this.estado = EstadoCita.PROGRAMADA;
    }

    public void cambiarEstado(EstadoCita estadoNuevo) {
        this.estado = estadoNuevo;
    }

    public void reagendar(LocalDateTime fechaNueva) {
        this.fechaHora = fechaNueva;
        this.estado = EstadoCita.REAGENDADA;
    }

    @Override
    public String toString() {
        return "Cita #" + idCita + " - Paciente: " + nombrePaciente +
                " - Médico: " + medicoAsignado.getNombreCompleto() +
                " (" + estado + ")";
    }
}

