package com.monzag.checkpoint4;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DBsearch {

    public DBsearch() {
    }

    public void run() {
        String phrase = getPhrase();
        try {
            ArrayList<Customer> result = findInCustomers(phrase);

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public String getPhrase() {
        String userInput;

        System.out.println("\nSearch phrase: ");
        userInput = new Scanner(System.in).nextLine();
        return userInput.toLowerCase();
    }

    public ArrayList<Customer> findInCustomers(String phrase) throws SQLException {
        ArrayList<Customer> foundPhrases = new ArrayList<Customer>();

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:target/database.db");
             Statement stmt = connection.createStatement();) {

            String query = "SELECT * FROM customers WHERE " +
                    "id LIKE '%" + phrase + "%'" +
                    "OR LOWER(name) LIKE '%" + phrase + "%'" +
                    "OR LOWER(surname) LIKE '%" + phrase + "%'" +
                    "OR birthyear LIKE '%" + phrase + "%'" +
                    "OR LOWER(gender) LIKE '%" + phrase + "%';";

            ResultSet result = stmt.executeQuery(query);

            while (result.next()) {
                Integer id = result.getInt("id");
                String name = result.getString("name");
                String surname = result.getString("surname");
                Integer birthyear = result.getInt("birthyear");
                String gender = result.getString("gender");
                Customer customer = new Customer(id, name, surname, birthyear, gender);
                foundPhrases.add(customer);
            }

            result.close();
        }
        
        return foundPhrases;
    }
}
