package se.lexicon.practice.section4.model;

import se.lexicon.practice.section4.sequencer.EmployeeSequencer;

import java.time.LocalDate;

public abstract class Employee {

    protected static final int BASE_SALARY = 25_000;

    //Fields
    private final int id;
    private String name;
    private double salary;
    private LocalDate dateHired;

    //Constructor
    protected Employee(String name, LocalDate dateHired) {
        this.id = EmployeeSequencer.getNextId();
        this.name = name;
        this.dateHired = dateHired;
        this.salary = BASE_SALARY;
    }

    protected Employee(int id, String name, LocalDate dateHired) {
        this.id = id;
        this.name = name;
        this.dateHired = dateHired;
        this.salary = BASE_SALARY;
    }

//Custom methods

    public abstract void calculateSalary();


    //Getters & Setters  etc.
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    protected void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getDateHired() {
        return dateHired;
    }

    public void setDateHired(LocalDate dateHired) {
        this.dateHired = dateHired;
    }
}
