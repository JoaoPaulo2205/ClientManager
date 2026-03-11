import model.Client;
import service.ClientService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static boolean isContinue = true;
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to the CLient Manager");

        ClientService service = new ClientService();

        do {
            System.out.println(
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
        ClientService service = new ClientService();
        switch (option) {
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

                try {
                    service.saveNewClient(new Client(name, email, cellphoneNumber, CPF));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                isContinue = true;
                break;
            case 2:
                System.out.println("---------------- Clients List ----------------------------------");
                try {
                    List<Client> client = service.listClients();
                    client.forEach(System.out::println);

                }catch (SQLException e){
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
                System.out.println("---------------------------------------------------------------");
                isContinue = true;
                break;
            case 3:
                try {
                    System.out.println("Enter ID: ");
                    int id = scan.nextInt();
                    System.out.println(service.searchClientbyId(id));
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
                isContinue = true;
                break;
            case 4:
                try{
                    System.out.println("Enter Client ID:");
                    int id = scan.nextInt();

                    System.out.println("Client: " + service.searchClientbyId(id));

                    System.out.println("What information would you like to update?");
                    System.out.println("""
                            1 - Name\
                            
                            2 - Email\
                            
                            3 - CPF\
                            
                            4 - Cellphone Number\
                            
                            5 - Change all the information about the client""");
                    int field = scan.nextInt();
                    Client client = service.searchClientbyId(id);
                    scan.nextLine();

                    switch (field) {
                        case 1:
                            System.out.println("Insert a new name: ");
                            String newName = scan.nextLine();
                            client.setName(newName);
                            try{
                                service.updateClient(client);
                            }catch (Exception e){
                                e.getMessage();
                            }
                            break;
                        case 2:
                            System.out.println("Insert a new email: ");
                            String newEmail = scan.nextLine();
                            client.setEmail(newEmail);
                            try{
                                service.updateClient(client);
                            }catch (Exception e){
                                e.getMessage();
                            }
                            break;
                        case 3:
                            System.out.println("Insert a new CPF: ");
                            String newCPF = scan.nextLine();
                            client.setCpf(newCPF);
                            try{
                                service.updateClient(client);
                            }catch (Exception e){
                                e.getMessage();
                            }
                            break;
                        case 4:
                            System.out.println("Insert a new cellphone number: ");
                            String newCellphoneNumber = scan.nextLine();
                            client.setCellphoneNumber(newCellphoneNumber);
                            try{
                                service.updateClient(client);
                            }catch (Exception e){
                                e.getMessage();
                            }
                            break;
                        case 5:
                            System.out.println("Enter Client Data" +
                                    "\nNew Name: ");
                            newName = scan.nextLine();
                            client.setName(newName);

                            System.out.println("New CPF: ");
                            newCPF = scan.nextLine();
                            client.setCpf(newCPF);

                            System.out.println("New Email: ");
                            newEmail = scan.nextLine();
                            client.setEmail(newEmail);

                            System.out.println("New Cellphone Number: ");
                            newCellphoneNumber = scan.nextLine();
                            client.setCellphoneNumber(newCellphoneNumber);

                            try{
                                service.updateClient(client);
                            }catch (Exception e){
                                e.getMessage();
                            }
                            break;
                        default:
                            System.out.println("Invalid input");
                            break;
                    }
                }catch (Exception e){
                    System.out.printf("Error: " + e.getMessage());
                }
                break;
            case 5:
                try {
                    System.out.print("Enter Client ID: ");
                    int id = scan.nextInt();
                    System.out.println(service.searchClientbyId(id));

                    service.deleteClient(id);
                }catch (Exception e){
                    e.getMessage();
                }
                break;

            case 0:
                System.out.println("Shutting down...");
                isContinue = false;
                break;

            default:
                System.out.println("Invalid option - Try again");
                isContinue = true;
                break;
        }

    }
}
