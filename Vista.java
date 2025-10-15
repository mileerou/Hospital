import java.time.LocalDateTime;
import java.util.Scanner;

public class Vista {
    private Scanner sc;
    private ControladorHospital controlador;

    public Vista(ControladorHospital controlador) {
        this.controlador = controlador;
        this.sc = new Scanner(System.in);
    }

    public void mostrarMenuPrincipal() {
        System.out.println("\n--- MENÚ HOSPITAL ---");
        System.out.println("1. Registrar trabajador");
        System.out.println("2. Programar cita");
        System.out.println("3. Reagendar cita");
        System.out.println("4. Mostrar personal");
        System.out.println("5. Salir");
    }

    public void registrarTrabajador() {
        System.out.print("Tipo (MedicoGeneral / Cirujano / Enfermero / Pediatra): ");
        String tipo = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        if (tipo.equalsIgnoreCase("MedicoGeneral")) {
            controlador.asignarMedico(new MedicoGeneral("MG1", nombre, "General", 5, 5000, "Interna", 10, 150));
        } else if (tipo.equalsIgnoreCase("Cirujano")) {
            controlador.asignarMedico(new Cirujano("C1", nombre, "Cirugía", 7, 7000, "Cardíaca", 10, 1200));
        } else if (tipo.equalsIgnoreCase("Enfermero")) {
            controlador.asignarMedico(new Enfermero("E1", nombre, "Enfermería", 4, 3500, "Nocturno", "CertA", true, 500));
        } else if (tipo.equalsIgnoreCase("Pediatra")) {
            controlador.asignarMedico(new Pediatra("P1", nombre, "Pediatría", 6, 6000, 200, false, 300));
        }
    }

    public void programarCita() {
        System.out.print("Tipo de médico: ");
        String tipo = sc.nextLine();
        Medico m = controlador.buscarDisponibles(tipo);
        if (m == null) {
            System.out.println("No hay médicos disponibles.");
            return;
        }
        System.out.print("Nombre del paciente: ");
        String paciente = sc.nextLine();

        Citas cita = new Citas(controlador.getCitas().size() + 1, paciente, m,
                LocalDateTime.now(), "Consulta");
        controlador.programarCita(cita);
        System.out.println("Cita programada correctamente.");
    }

    public void reagendarCita() {
        if (controlador.getCitas().isEmpty()) {
            System.out.println("No hay citas para reagendar.");
            return;
        }
        Citas cita = controlador.getCitas().get(0);
        controlador.reagendarCita(cita);
        System.out.println("Cita reagendada.");
    }

    public void mostrarReportes() {
        for (Medico m : controlador.getPersonal()) {
            System.out.println(m.informacionEmpleado());
        }
    }

    public void iniciar() {
        int opcion;
        do {
            mostrarMenuPrincipal();
            System.out.print("Seleccione opción: ");
            opcion = Integer.parseInt(sc.nextLine());
            if (opcion == 1) registrarTrabajador();
            else if (opcion == 2) programarCita();
            else if (opcion == 3) reagendarCita();
            else if (opcion == 4) mostrarReportes();
        } while (opcion != 5);
    }
}
