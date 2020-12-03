package se.lexicon.practice.section4.model;

import se.lexicon.MyUtils;

import java.time.LocalDate;
import java.util.Arrays;


public class SalesPerson extends Employee {

    private static final double AMOUNT_EXTRA_PER_CLIENT = 500;
    private static final double AMOUNT_EXTRA_PER_NEW_CLIENT = 1000;


    private String[] clients;
    private int acquiredClients;

    public SalesPerson(String name, LocalDate dateHired, String[] clients, int acquiredClients) {
        super(name, dateHired);
        this.clients = clients;
        this.acquiredClients = acquiredClients;

        calculateSalary();
    }

    protected SalesPerson(int id, String name, LocalDate dateHired, String[] clients, int acquiredClients) {
        super(id, name, dateHired);
        this.clients = clients;
        this.acquiredClients = acquiredClients;
    }

    @Override
    public void calculateSalary() {

        if (clients != null) {
            final double clientExtra = clients.length * AMOUNT_EXTRA_PER_CLIENT;
            final double newClientExtra = acquiredClients * AMOUNT_EXTRA_PER_NEW_CLIENT;

            final double newSalary = BASE_SALARY + clientExtra + newClientExtra;

            super.setSalary(newSalary);
        }
    }

    public String[] getClients() {
        return clients;
    }

    public void setClients(String[] clients) {
        this.clients = clients;

        calculateSalary();
    }

    public void addClient(String client){

        String[] newClientArray = MyUtils.addToArray(clients, client);

        setClients(newClientArray);

    }

    public int getAcquiredClients() {
        return acquiredClients;
    }

    public void setAcquiredClients(int acquiredClients) {
        this.acquiredClients = acquiredClients;

        calculateSalary();
    }

    public void recruitANewClient(){
        ++acquiredClients;

        calculateSalary();
    }

    @Override
    public String toString() {
        return "SalesPerson{" +
                "clients=" + Arrays.toString(clients) +
                ", acquiredClients=" + acquiredClients +
                '}';
    }
}
