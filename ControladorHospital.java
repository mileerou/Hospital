import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ControladorHospital {
    private List<Medico> personal;
    private List<Citas> citas;
    private List<String> historialReagendaciones;

    public ControladorHospital() {
        personal = new ArrayList<>();
        citas = new ArrayList<>();
        historialReagendaciones = new ArrayList<>();
    }

    public void asignarMedico(Medico medico) {
        personal.add(medico);
    }

    public Medico buscarDisponibles(String especialidad) {
        for (Medico m : personal) {
            if (m.getClass().getSimpleName().equalsIgnoreCase(especialidad) && m.isDisponible()) {
                return m;
            }
        }
        return null;
    }

    public void programarCita(Citas cita) {
        Medico m = cita.medicoAsignado;
        if (m.isDisponible()) {
            citas.add(cita);
            m.setDisponible(false);
        }
    }

    public void reagendarCita(Citas cita) {
        cita.reagendar(LocalDateTime.now().plusDays(1));
        historialReagendaciones.add("Cita reagendada: " + cita);
        cita.medicoAsignado.setDisponible(true);
    }

    public double calcularNominaDepartamento(String departamento) {
        double total = 0;
        for (Medico m : personal) {
            if (m.getDepartamento().equalsIgnoreCase(departamento)) {
                total += m.calcularSalario();
            }
        }
        return total;
    }

    public List<Medico> getPersonal() {
        return personal;
    }

    public List<Citas> getCitas() {
        return citas;
    }

    public List<String> getHistorialReagendaciones() {
        return historialReagendaciones;
    }
}

