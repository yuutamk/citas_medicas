package org.example;


public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataBaseConnection dbConnection = new DataBaseConnection();
        dbConnection.connectAndQuery();

    }
}
