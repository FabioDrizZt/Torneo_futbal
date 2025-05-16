package torneo_futbal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InstalacionDeportiva {

    private String nombreInstalacion; // Name of the installation
    private List<Disciplina> disciplinas;   // Associated disciplines
    private List<ReservaInstalacion> reservas;   // Reservations
    private int capacidad;

    // Constructor
    public InstalacionDeportiva(String nombreInstalacion, int capacidad, Disciplina disciplina) {
        this.nombreInstalacion = nombreInstalacion;
        this.capacidad = capacidad;
        this.disciplinas = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    // Getters y setters
    public String getNombreInstalacion() {
        return nombreInstalacion;
    }

    public void setNombreInstalacion(String nombreInstalacion) {
        this.nombreInstalacion = nombreInstalacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public List<Disciplina> getDisciplina() {
        return new ArrayList<>(disciplinas);
    }

    public List<ReservaInstalacion> getReservas() {
        return new ArrayList<>(reservas);
    }
    
    //setters disciplinas and reservas
    public void setDisciplinas(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
    }

    public void setReservas(ReservaInstalacion reserva) {
        this.reservas.add(reserva);
    }

    // Verificar disponibilidad de instalación
    public boolean estaDisponible(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        for (ReservaInstalacion reserva : reservas) {
            if (reserva.getEstado().equals("Reservada")) {
                // Comprobar si la instalación está solapada en tiempos
                if (reserva.getFechaReservaInicio().isBefore(fechaFin) && reserva.getFechaReservaFin().isAfter(fechaInicio)) {
                    return false; // La instalación está solapada en tiempos
                }
            }
        }
        return true; // La instalación está disponible
    }
    // toString
    @Override
    public String toString() {
        return "Nombre: " + nombreInstalacion + "\n" +
               "Disciplinas: " + disciplinas + "\n" +
               "Reservas: " + reservas;
    }


}
