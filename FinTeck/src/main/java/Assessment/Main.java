package Assessment;
import java.util.Scanner;

public class Main {

    static CustomerDao customerDAO = new CustomerDao();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        boolean running = true;

        while (running) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customers");
            System.out.println("0. Exit");
            System.out.print("Enter Choice: ");

            String choice = sc.nextLine();

            switch (choice) {

                case "1":

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    Customer customer = new Customer(name, email, phone);
                    customerDAO.save(customer);

                    System.out.println("Customer Saved Successfully");
                    break;

                case "2":

                    customerDAO.findAll()
                            .forEach(c ->
                                    System.out.println(c.getCustomerId() + " - " +c.getFullName()));

                    break;

                case "0":
                    running = false;
                    System.out.println("Application Closed");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        }

        sc.close();
    }
}