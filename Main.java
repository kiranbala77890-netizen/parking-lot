import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ParkingLot lot = new ParkingLot("CGC Smart Parking", 3, 3, 1);
        int choice = -1;

        System.out.println("=== Welcome to CGC Smart Parking ===");

        do {
            System.out.println("\n1. Park vehicle");
            System.out.println("2. Exit vehicle (pay)");
            System.out.println("3. Total earnings");
            System.out.println("0. Quit");
            System.out.print("Choice: ");

            try {
                choice = sc.nextInt();
                sc.nextLine();   // enter ka leftover hatao

                switch (choice) {
                    case 1:
                        System.out.print("Type (1=Car, 2=Bike, 3=Truck): ");
                        int type = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Plate number: ");
                        String plate = sc.nextLine().trim();

                        Vehicle v;
                        if (type == 1) {
                            v = new Car(plate);
                        } else if (type == 2) {
                            v = new Bike(plate);
                        } else if (type == 3) {
                            v = new Truck(plate);
                        } else {
                            System.out.println("Invalid vehicle type!");
                            break;
                        }

                        Ticket ticket = lot.parkVehicle(v);
                        System.out.println("Parked! " + ticket);
                        break;

                    case 2:
                        System.out.print("Ticket ID: ");
                        int id = sc.nextInt();
                        System.out.print("Hours parked: ");
                        long hours = sc.nextLong();
                        sc.nextLine();
                        double fee = lot.exitVehicle(id, hours);
                        System.out.println("Total fee: Rs." + fee);
                        break;

                    case 3:
                        System.out.println("Total earnings: Rs." + lot.getTotalEarnings());
                        break;

                    case 0:
                        System.out.println("Thank you! Drive safe.");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (ParkingFullException | InvalidTicketException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number!");
                sc.nextLine();   // galat input saaf karo
            }
        } while (choice != 0);

        sc.close();
    }
}