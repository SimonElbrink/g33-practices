package se.lexicon.practice.section4.model;

import se.lexicon.MyUtils;

import java.time.LocalDate;
import java.util.Arrays;

public class SystemDeveloper extends Employee {

    private static final int AMOUNT_EXTRA_PER_CERTIFICATE = 1000;
    private static final int AMOUNT_EXTRA_PER_LANGUAGE = 1500;

    private String[] certificates;
    private String[] programmingLanguages;

    //Constructor
    public SystemDeveloper(String name, LocalDate dateHired, String[] certificates, String[] programmingLanguages) {
        super(name, dateHired);
        this.certificates = certificates;
        this.programmingLanguages = programmingLanguages;

        calculateSalary();
    }


    @Override
    public void calculateSalary() {

        final double certificateExtra = certificates.length * AMOUNT_EXTRA_PER_CERTIFICATE;
        final double languageExtra = programmingLanguages.length * AMOUNT_EXTRA_PER_LANGUAGE;

        final double newSalary = Employee.BASE_SALARY + certificateExtra + languageExtra;

        super.setSalary(newSalary);
    }

    public String[] getCertificates() {
        return certificates;
    }

    /**
     * Also re-Calculates salary.
     * @param certificates array of certificates to set.
     */
    public void setCertificates(String[] certificates) {
        this.certificates = certificates;

        calculateSalary();
    }

    public void addCertificate(String certificate){

        //Copy and expand array
        String[] newCertificatesArray = Arrays.copyOf(certificates,certificates.length+1);

        //Add Element in the array.
        newCertificatesArray[newCertificatesArray.length -1] = certificate;

        //Replacing and calculates the new salary
        this.certificates = newCertificatesArray;

        //Calculate new Salary
        calculateSalary();
    }

    public String[] getProgrammingLanguages() {
        return programmingLanguages;
    }

    public void setProgrammingLanguages(String[] programmingLanguages) {
        this.programmingLanguages = programmingLanguages;

        calculateSalary();
    }

    public void addProgrammingLanguage(String language){

        String[] newArray = MyUtils.addToArray(programmingLanguages, language);

        setProgrammingLanguages(newArray);

    }

    @Override
    public String toString() {
        return "SystemDeveloper{" +
                "certificates=" + Arrays.toString(certificates) +
                ", programmingLanguages=" + Arrays.toString(programmingLanguages) +
                '}';
    }

}
