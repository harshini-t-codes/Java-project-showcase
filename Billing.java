import java.util.*;

public class Bill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalBill = 0;

        while (true) {
            System.out.println("\nAvailable vehicle types:");
            System.out.println("CAR\nBIKE\nTHREE WHEELER\nEV\nEXIT");

            System.out.print("Enter vehicle type: ");
            String vehicle = sc.nextLine();

            if (vehicle.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Enter number of vehicles: ");
            int n = sc.nextInt();

            System.out.print("Enter number of hours: ");
            int hours = sc.nextInt();
            sc.nextLine(); 

            int maxLimit = 0;

            
            if (vehicle.equalsIgnoreCase("car") || vehicle.equalsIgnoreCase("three wheeler")) {
                maxLimit = 2;
            } else if (vehicle.equalsIgnoreCase("bike") || vehicle.equalsIgnoreCase("ev")) {
                maxLimit = 3;
            } else {
                System.out.println("Invalid vehicle type");
                continue;
            }

            if (n > maxLimit) {
                System.out.println("Maximum " + maxLimit + " allowed");
                continue;
            }

            int bill = calculateBill(hours) * n;
            totalBill += bill;

            System.out.println("Added bill: " + bill);
        }

        System.out.println("\nFinal Total Bill: " + totalBill);
        sc.close();
    }

    public static int calculateBill(int hours) {
        int bill = 0;

        if (hours <= 2) {
            bill = hours * 100;
        } else if (hours <= 5) {
            bill = (2 * 100) + (hours - 2) * 50;
        } else {
            bill = (2 * 100) + (3 * 50) + (hours - 5) * 20;
        }

        return bill;
    }
}