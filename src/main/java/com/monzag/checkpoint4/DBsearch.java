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
            ArrayList<Customer> resultCustomer = findInCustomers(phrase);
            for (Customer customer : resultCustomer) {
                System.out.println(customer);
            }

            ArrayList<Sale> resultSale = findInSales(phrase);
            for (Sale sale : resultSale) {
                System.out.println(sale);
            }


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

    public ArrayList<Sale> findInSales(String phrase) throws SQLException {
        ArrayList<Sale> foundPhrases = new ArrayList<Sale>();

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:target/database.db");
             Statement stmt = connection.createStatement();) {

            String query = "SELECT * FROM sales WHERE " +
                    "id LIKE '%" + phrase + "%'" +
                    "OR customer_id LIKE '%" + phrase + "%'" +
                    "OR LOWER(product_name) LIKE '%" + phrase + "%'" +
                    "OR net_value LIKE '%" + phrase + "%'" +
                    "OR tax_rate LIKE '%" + phrase + "%';";

            ResultSet result = stmt.executeQuery(query);

            while (result.next()) {
                Integer id = result.getInt("id");
                Integer customer_id = result.getInt("customer_id");
                String product_name = result.getString("product_name");
                Integer net_value = result.getInt("net_value");
                Integer tax_rate = result.getInt("tax_rate");
                Sale sale = new Sale(id, customer_id, product_name, net_value, tax_rate);
                foundPhrases.add(sale);
            }

            result.close();
        }

        return foundPhrases;
    }

}
