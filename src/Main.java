import model.Client;
import service.ClientService;

import javax.xml.transform.Source;
import java.util.Scanner;

public class Main {
    public static boolean isContinue;
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("----- Client Manager -----");

        ClientService service = new ClientService();

        do {
            System.out.println("Welcome to the CLient Manager" +
                    "\n======= MENU =======" +
                    "\n1 - Register Client" +
                    "\n2 - Show Clients" +
                    "\n3 - Search By ID" +
                    "\n4 - Update Client" +
                    "\n5 - Remove Client" +
                    "\n0 - Exit\n");
            System.out.println("Enter your choice: ");
            int option = scan.nextInt();
            scan.nextLine();

            checkOptions(option);

        } while (isContinue);
    }

    public static void checkOptions(int option) {
        switch (option) {
            case 0:
                isContinue = false;
                break;
            case 1:
                System.out.flush();
                System.out.println("Enter Client Data" +
                        "\nName: ");
                String name = scan.nextLine();

                System.out.println("CPF: ");
                String CPF = scan.nextLine();

                System.out.println("Email: ");
                String email = scan.nextLine();

                System.out.println("Cellphone Number: ");
                String cellphoneNumber = scan.nextLine();

                //service.registerClient(name, CPF, email, cellphoneNumber);
        }

    }
}
