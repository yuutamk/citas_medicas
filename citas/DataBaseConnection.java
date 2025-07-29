package org.example;

import java.sql.*;

public class DataBaseConnection {
    String url="jdbc:mysql://localhost:3306/citas_medicas";
    String user="root";
    String pass="";

    Connection myConn = null;
    Statement myStmt = null;
    ResultSet myRs = null;

    public void connectAndQuery() {
        try {
            myConn = DriverManager.getConnection(url, user, pass);
            System.out.println("Genial nos conectamos");

            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("SELECT * FROM users");

            while (myRs.next()) {
                System.out.println(myRs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Algo salio mal");
        } finally {
            try {
                if (myRs != null) myRs.close();
                if (myStmt != null) myStmt.close();
                if (myConn != null) myConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void createAppointment(int doctorId, int patientId, String appointmentDate, String reason) {
        String query = "INSERT INTO appointments (doctor_id, patient_id, appointment_date, reason) VALUES (?, ?, ?, ?)";
        try (Connection myConn = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = myConn.prepareStatement(query)) {
            pstmt.setInt(1, doctorId);
            pstmt.setInt(2, patientId);
            pstmt.setString(3, appointmentDate);
            pstmt.setString(4, reason);
            pstmt.executeUpdate();
            System.out.println("Appointment created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void readAppointments() {
        String query = "SELECT * FROM appointments";
        try (Connection myConn = DriverManager.getConnection(url, user, pass);
             Statement stmt = myConn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Doctor ID: " + rs.getInt("doctor_id") + ", Patient ID: " + rs.getInt("patient_id") + ", Date: " + rs.getString("appointment_date") + ", Reason: " + rs.getString("reason"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAppointment(int appointmentId, String newDate, String newReason) {
        String query = "UPDATE appointments SET appointment_date = ?, reason = ? WHERE id = ?";
        try (Connection myConn = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = myConn.prepareStatement(query)) {
            pstmt.setString(1, newDate);
            pstmt.setString(2, newReason);
            pstmt.setInt(3, appointmentId);
            pstmt.executeUpdate();
            System.out.println("Appointment updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAppointment(int appointmentId) {
        String query = "DELETE FROM appointments WHERE id = ?";
        try (Connection myConn = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = myConn.prepareStatement(query)) {
            pstmt.setInt(1, appointmentId);
            pstmt.executeUpdate();
            System.out.println("Appointment deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
