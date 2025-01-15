package Ui;

import Domain.Medicine;
import Domain.Patient;
import Service.AppService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;

/**
 * User Interface (UI) class to interact with the user and manage operations on two repositories.
 * Provides a menu-driven approach to perform CRUD operations on the repositories.
 */
public class UI {

    /**
     * The service layer to handle application logic.
     */
    AppService appService;

    /**
     * Reader for handling user input from the console.
     */
    BufferedReader reader;

    /**
     * Constructs a UI object with the given service layer.
     *
     * @param appService the service layer to interact with the repositories.
     */
    public UI(AppService appService) {
        this.appService = appService;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Starts the main application loop. Displays the main menu and handles user input.
     */
    public void RUN() {
        try{
            System.out.println("Welcome to the Hospital management App");
            while (true) {
                System.out.println("\nHere are your options: ");
                System.out.println("1. Manage Medicines");
                System.out.println("2. Manage Patients");
                System.out.println("0. Exit\n");
                int choice;
                while (true) {
                    System.out.print("Your choice:");
                    choice = Integer.parseInt(reader.readLine());
                    if (choice == 0 || choice == 1 || choice == 2)
                        break;
                    else {
                        System.out.println("Invalid option. Choose 1, 2 or 0\n");
                    }
                }
                switch (choice) {
                    case 1: {
                        manageMedicines();
                        break;
                    }
                    case 2: {
                        managePatients();
                        break;
                    }
                    case 0: {
                        System.out.println("Thank you for using the app.\nHave a nice day!");
                        System.exit(0);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Displays the menu for managing the first Domain element and handles user input for various operations.
     */
    public void manageMedicines() {
        int choice;

        try {
            while (true) {
                System.out.println("Here are your options: \n");
                System.out.println("1. Add a new medicine");
                System.out.println("2. Delete a medicine");
                System.out.println("3. Update a medicine");
                System.out.println("4. Get a medicine by its Id");
                System.out.println("5. View all medicines");
                System.out.println("0. Return to main menu");
                while (true) {
                    System.out.print("Your choice:");
                    choice = Integer.parseInt(reader.readLine());
                    if (choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5 || choice == 0) {
                        break;
                    } else {
                        System.out.println("Invalid option. Choose 1, 2, 3, 4, 5 or 0\n");
                    }
                }
                switch (choice) {
                    case 1: {
                        addNewMedicine();
                        break;
                    }
                    case 2: {
                        deleteMedicine();
                        break;
                    }
                    case 3: {
                        updateMedicine();
                        break;
                    }
                    case 4: {
                        getMedicineById();
                        break;
                    }
                    case 5: {
                        viewAllMedicines();
                        break;
                    }
                    case 0: {
                        return;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Displays the menu for managing the second Domain element and handles user input for various operations.
     */
    public void managePatients() {

        int choice;
        try {
            while (true) {
                System.out.println("Here are your options: \n");
                System.out.println("1. Add a new patient");
                System.out.println("2. Delete a patient");
                System.out.println("3. Update a patient");
                System.out.println("4. Get a patient by its Id");
                System.out.println("5. View all patients");
                System.out.println("6. Add new Medicine");
                System.out.println("7. Filter patients by diagnose");
                System.out.println("8. Filter patients by Medicine");
                System.out.println("9. Sort the medicines by price for a patient");
                System.out.println("0. Return to main menu");
                while (true) {
                    System.out.print("Your choice:");
                    choice = Integer.parseInt(reader.readLine());
                    if (choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5 || choice == 6
                            || choice == 0 || choice == 7 || choice == 8 || choice == 9) {
                        break;
                    } else {
                        System.out.println("Invalid option. Choose 1, 2, 3, 4, 5, 6, 7, 8, 9 or 0\n");
                    }
                }
                switch (choice) {
                    case 1: {
                        addNewPatient();
                        break;
                    }
                    case 2: {
                        deletePatient();
                        break;
                    }
                    case 3: {
                        updatePatient();
                        break;
                    }
                    case 4: {
                        getPatientById();
                        break;
                    }
                    case 5: {
                        viewAllPatients();
                        break;
                    }
                    case 6:{
                        addNewMedicineToPatient();
                        break;
                    }
                    case 7:{
                        filterPatientsByDiagnose();
                        break;
                    }
                    case 8:{
                        filterPatientsByHealthProblem();
                        break;
                    }
                    case 9:{
                        sortMedicinesOfAPatient();
                        break;
                    }
                    case 0: {
                        return;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds a new item to the first repository.
     */
    private void addNewMedicine() {
        try {
            System.out.println("Please enter following information: ");
            System.out.print("Id: ");
            int id = Integer.parseInt(reader.readLine());
            System.out.print("Name: ");
            String name = reader.readLine();
            System.out.print("Price: ");
            int price = Integer.parseInt(reader.readLine());
            System.out.print("Health problem: ");
            String healthProblem = reader.readLine();
            appService.addMedicine(id, name,price,healthProblem);
            System.out.println("Item successfully added\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds a new item to the second repository.
     */
    private void addNewPatient() {
        try {
            System.out.println("Please enter following information: ");
            System.out.print("Id: ");
            int id = Integer.parseInt(reader.readLine());
            System.out.print("Name: ");
            String name = reader.readLine();
            System.out.print("Age: ");
            int age = Integer.parseInt(reader.readLine());
            System.out.print("Diagnose: ");
            String diagnose = reader.readLine();
            appService.addPatient(id, name, age, diagnose);
            System.out.println("Item successfully added\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates an existing item in the first repository.
     */
    private void updateMedicine() {
        viewAllMedicines();
        try {
            System.out.println("Please enter following information: ");
            System.out.println("Id of the medicine you would like to update: ");
            int id = Integer.parseInt(reader.readLine());
            System.out.print("Name: ");
            String name = reader.readLine();
            System.out.println("Price: ");
            int price = Integer.parseInt(reader.readLine());
            System.out.print("Health problem: ");
            String healthProblem = reader.readLine();
            appService.updateMedicine(id, name,price, healthProblem);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates an existing item in the second repository.
     */
    private void updatePatient() {
        viewAllPatients();
        try {
            System.out.println("Please enter following information: ");
            System.out.println("Id of the patient you would like to update: ");
            int id = Integer.parseInt(reader.readLine());
            System.out.print("Name: ");
            String name = reader.readLine();
            System.out.print("Age: ");
            int age = Integer.parseInt(reader.readLine());
            System.out.print("Diagnose: ");
            String diagnose = reader.readLine();
            appService.updatePatient(id, name,age,diagnose);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Displays all items in the first repository.
     */
    private void viewAllMedicines() {
        System.out.println("All Medicines :");
        appService.getAllMedicines().forEach(System.out::println);
        System.out.println();
    }

    /**
     * Displays all items in the second repository.
     */
    private void viewAllPatients() {
        System.out.println("All patients :");
        appService.getAllPatients().forEach(System.out::println);
        System.out.println();
    }

    /**
     * Displays an item from the first repository by its ID.
     */
    private void getMedicineById() {
        try {
            System.out.println("Enter the ID of the medicine you would like to view: ");
            int id = Integer.parseInt(reader.readLine());
            System.out.println(appService.getMedicine(id));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Displays an item from the second repository by its ID.
     */
    private void getPatientById() {
        try {
            System.out.println("Enter the ID of the patient you would like to view: ");
            int id = Integer.parseInt(reader.readLine());
            System.out.println(appService.getPatient(id));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes an item from the first repository by its ID.
     */
    private void deleteMedicine(){
        try {
            viewAllMedicines();
            System.out.print("Enter the id of the medicine you want to delete: ");
            int id = Integer.parseInt(reader.readLine());
            appService.deleteMedicine(id);
            System.out.println("Item deleted successfully");

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Deletes an item from the second repository by its ID.
     */
    private void deletePatient(){
        try {
            viewAllPatients();
            System.out.print("Enter the id of the patient you want to delete: ");
            int id = Integer.parseInt(reader.readLine());
            appService.deletePatient(id);
            System.out.println("Item deleted successfully");

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Assigns a new medicine for a patient
     * */
    private void addNewMedicineToPatient() throws IOException {
        viewAllPatients();
        viewAllMedicines();
        System.out.println("Select the patient id that wants to make a purchase");
        int patID = Integer.parseInt(reader.readLine());
        System.out.println("Medicine id: ");
        int medicineID = Integer.parseInt(reader.readLine());
        appService.addMedicineToPatient(patID,medicineID);
    }

    /**
     * Filters the patients by a user specified diagnose
     * */
    private void filterPatientsByDiagnose() throws IOException {
        List<Patient> allPatients = appService.getAllPatients();
        System.out.print("The diagnose after which you want to filter: ");
        String diagnose = reader.readLine();
        for(Patient patient : allPatients) {
            if (patient.getDiagnose().equals(diagnose))
                System.out.println(patient);
        }
    }

    /**
     * Filters the patients by a user specified medicine(which has the healthProblem attribute)
     * */
    private void filterPatientsByHealthProblem() throws IOException {
        System.out.println("The HealthProblem after which you want to filter: ");
        String healthProblem = reader.readLine();
        List<Patient> allPatients = appService.getAllPatients();
        for (Patient patient : allPatients){
            List<Medicine> medicineList = patient.getMedicines();
            for (Medicine medicine : medicineList){
                if (medicine.getHealthProblem().equals(healthProblem)){
                    System.out.println(patient);
                }
            }

        }
    }

    /**
     * Sorts the medicines of a patients by price ascending or descending (the user choices)
     * */
    private void sortMedicinesOfAPatient() throws IOException {
        viewAllPatients();
        System.out.println("Which patients medicines do you want to sort (id): ");
        int patID = Integer.parseInt(reader.readLine());
        Patient patient = appService.getPatient(patID);
        List<Medicine> medicineList = patient.getMedicines();
        System.out.println("Do you want to sort ascending(1) or descending(2)");
        int choice = Integer.parseInt(reader.readLine());
        switch (choice){
            case 1:{
                medicineList.sort(Comparator.comparing(Medicine::getPrice));
                break;
            }
            case 2:{
                medicineList.sort(Comparator.comparing(Medicine::getPrice).reversed());
            }
        }
        medicineList.forEach(System.out::println);
    }
}

