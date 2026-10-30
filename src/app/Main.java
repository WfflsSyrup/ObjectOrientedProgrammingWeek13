package app;

import exception.DuplicateRecordException;
import model.ItemRecord;
import service.RecordManager;
import java.util.Scanner;

public class Main {
    private static final Scanner INPUT = new Scanner(System.in);
    private static final RecordManager MANAGER = new RecordManager();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\nEXCEPTION SAFE RECORD ENTRY");
            System.out.println("1 - Add record");
            System.out.println("0 - Exit");
            System.out.print("Choice: ");
            String choice = INPUT.nextLine().trim();

            switch (choice) {
                case "1" -> addRecord();
                case "0" -> {
                    running = false;
                    System.out.println("Application closed.");
                }
                default -> System.out.println("Choose a number from 0 to 1.");
            }
        }
    }

    private static void addRecord() {
        try {
            System.out.print("Record ID: ");
            String id = INPUT.nextLine();
            
            System.out.print("Record name: ");
            String name = INPUT.nextLine();
            
            int quantity = readQuantity();

            MANAGER.add(new ItemRecord(id, name, quantity));
            System.out.println("Record added successfully.");
        } catch (DuplicateRecordException | IllegalArgumentException exception) {
            System.out.println("Unable to add record: " + exception.getMessage());
        }
    }

    private static int readQuantity() {
        System.out.print("Quantity: ");
        String text = INPUT.nextLine();
        try {
            return Integer.parseInt(text.trim());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("Quantity must be a whole number.");
        }
    }
}
