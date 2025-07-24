package model;

import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import citas.DatabaseConnection;

public class AppointmentDoctor implements ISchedulable {
    private int id;
    private Patient patient;
    private Doctor doctor;
    private Date date;
    private String time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public void schedule(Date date, String time) {
        // Implementación para guardar la cita en la base de datos
    }

    public void rejectAppointment(int appointmentId) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE appointments SET status = 'rejected' WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, appointmentId);
                statement.executeUpdate();
                System.out.println("Appointment rejected successfully.");
            }
        } catch (SQLException e) {
            System.err.println("Error rejecting appointment: " + e.getMessage());
        }
    }

    public void markAsAttended(int appointmentId) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE appointments SET status = 'attended' WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, appointmentId);
                statement.executeUpdate();
                System.out.println("Appointment marked as attended.");
            }
        } catch (SQLException e) {
            System.err.println("Error marking appointment as attended: " + e.getMessage());
        }
    }

    public void rescheduleAppointment(int appointmentId, Date newDate) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE appointments SET status = 'rescheduled', rescheduled_date = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setTimestamp(1, new java.sql.Timestamp(newDate.getTime()));
                statement.setInt(2, appointmentId);
                statement.executeUpdate();
                System.out.println("Appointment rescheduled successfully.");
            }
        } catch (SQLException e) {
            System.err.println("Error rescheduling appointment: " + e.getMessage());
        }
    }
}