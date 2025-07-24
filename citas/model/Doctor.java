package model;

import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {
    private String speciality;

    public Doctor(String name, String email, String speciality) {
        super(name, email);
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    private final ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();

    public void addAvailableAppointment(Date date, String time) {
        availableAppointments.add(new AvailableAppointment(date, time));
    }

    public ArrayList<AvailableAppointment> getAvailableAppointments() {
        return availableAppointments;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", speciality='" + speciality + '\'' +
                ", availableAppointments=" + availableAppointments +
                '}';
    }

    public static class AvailableAppointment {
        private final Date date;
        private final String time;

        public AvailableAppointment(Date date, String time) {
            this.date = date;
            this.time = time;
        }

        public Date getDate() {
            return date;
        }

        public String getTime() {
            return time;
        }

        @Override
        public String toString() {
            return "AvailableAppointment{" +
                    "date=" + date +
                    ", time='" + time + '\'' +
                    '}';
        }
    }
}