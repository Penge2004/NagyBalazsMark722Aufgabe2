package Ui;

import Service.AppService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
            System.out.println("Welcome to the ... App");
            while (true) {
                System.out.println("\nHere are your options: ");
                System.out.println("1. Manage thing 1");
                System.out.println("2. Manage thing 2");
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
                        manageThing1();
                        break;
                    }
                    case 2: {
                        manageThing2();
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
    public void manageThing1() {
        int choice;

        try {
            while (true) {
                System.out.println("Here are your options: \n");
                System.out.println("1. Add a new thing");
                System.out.println("2. Delete a thing");
                System.out.println("3. Update a thing");
                System.out.println("4. Get a thing by its Id");
                System.out.println("5. View all things");
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
                        addNewThing1();
                        break;
                    }
                    case 2: {
                        deleteThing1();
                        break;
                    }
                    case 3: {
                        updateThing1();
                        break;
                    }
                    case 4: {
                        getThing1ByID();
                        break;
                    }
                    case 5: {
                        viewAllThing1();
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
    public void manageThing2() {

        int choice;
        try {
            while (true) {
                System.out.println("Here are your options: \n");
                System.out.println("1. Add a new thing");
                System.out.println("2. Delete a thing");
                System.out.println("3. Update a thing");
                System.out.println("4. Get a thing by its Id");
                System.out.println("5. View all things");
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
                        addNewThing2();
                        break;
                    }
                    case 2: {
                        deleteThing2();
                        break;
                    }
                    case 3: {
                        updateThing2();
                        break;
                    }
                    case 4: {
                        getThing2ByID();
                        break;
                    }
                    case 5: {
                        viewAllThing2();
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
    private void addNewThing1() {
        try {
            System.out.println("Please enter following information: ");
            System.out.print("Id: ");
            int id = Integer.parseInt(reader.readLine());
            System.out.print("Name: ");
            String name = reader.readLine();
            appService.add1(id, name);
            System.out.println("Item successfully added\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds a new item to the second repository.
     */
    private void addNewThing2() {
        try {
            System.out.println("Please enter following information: ");
            System.out.print("Id: ");
            int id = Integer.parseInt(reader.readLine());
            System.out.print("Name: ");
            String name = reader.readLine();
            appService.add2(id, name);
            System.out.println("Item successfully added\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates an existing item in the first repository.
     */
    private void updateThing1() {
        viewAllThing1();
        try {
            System.out.println("Please enter following information: ");
            System.out.println("Id of the thing you would like to update: ");
            int id = Integer.parseInt(reader.readLine());
            System.out.print("Name: ");
            String name = reader.readLine();
            appService.update1(id, name);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates an existing item in the second repository.
     */
    private void updateThing2() {
        viewAllThing2();
        try {
            System.out.println("Please enter following information: ");
            System.out.println("Id of the thing you would like to update: ");
            int id = Integer.parseInt(reader.readLine());
            System.out.print("Name: ");
            String name = reader.readLine();
            appService.update2(id, name);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Displays all items in the first repository.
     */
    private void viewAllThing1() {
        System.out.println("All thing1 :");
        appService.getAll1().forEach(System.out::println);
        System.out.println();
    }

    /**
     * Displays all items in the second repository.
     */
    private void viewAllThing2() {
        System.out.println("All thing2 :");
        appService.getAll2().forEach(System.out::println);
        System.out.println();
    }

    /**
     * Displays an item from the first repository by its ID.
     */
    private void getThing1ByID() {
        try {
            System.out.println("Enter the ID of the thing you would like to view: ");
            int id = Integer.parseInt(reader.readLine());
            System.out.println(appService.get1(id));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Displays an item from the second repository by its ID.
     */
    private void getThing2ByID() {
        try {
            System.out.println("Enter the ID of the thing you would like to view: ");
            int id = Integer.parseInt(reader.readLine());
            System.out.println(appService.get2(id));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes an item from the first repository by its ID.
     */
    private void deleteThing1(){
        try {
            viewAllThing1();
            System.out.print("Enter the id of the thing you want to delete: ");
            int id = Integer.parseInt(reader.readLine());
            appService.delete1(id);
            System.out.println("Item deleted successfully");

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Deletes an item from the second repository by its ID.
     */
    private void deleteThing2(){
        try {
            viewAllThing2();
            System.out.print("Enter the id of the thing you want to delete: ");
            int id = Integer.parseInt(reader.readLine());
            appService.delete2(id);
            System.out.println("Item deleted successfully");

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
