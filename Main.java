public class Main {
    public static void main(String[] args) {
        ControladorHospital controlador = new ControladorHospital();
        Vista vista = new Vista(controlador);
        vista.iniciar();
    }
}
