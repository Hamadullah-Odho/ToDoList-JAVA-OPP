import java.util.Scanner;
public class ToDoList {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ToDoListSystem system = new ToDoListSystem();
        boolean programrunning = true;

        do{
            try {
                System.out.println("---- TO DO LIST ----\n");
                System.out.println("1. Sign up / Register");
                System.out.println("2. Sign in / Login");
                System.out.println("3. Exit\n");
                System.out.println("-------------------------");
                System.out.print("Enter Selection :");
                int select = Integer.parseInt(scan.nextLine());
                System.out.println("\n");

                switch (select){
                    case 1:
                        system.signup();
                        break;
                    case 2:
                        if(system.signin()){
                            boolean usermenu = true;
                            while (usermenu) {
                                System.out.println("--- Menu ---\n");
                                System.out.println("1. Add Tasks");
                                System.out.println("2. Mark Task as completed");
                                System.out.println("3. Delete Tasks");
                                System.out.println("4. Show Tasks");
                                System.out.println("5. Show User Details");
                                System.out.println("6. Logout\n");
                                System.out.print("Enter Selection :");
                                select = Integer.parseInt(scan.nextLine());
                                System.out.println();

                                switch (select) {
                                    case 1:
                                        system.addTask();
                                        break;
                                    case 2:
                                        system.markComplete();
                                        break;
                                    case 3:
                                        system.deleteTask();
                                        break;
                                    case 4:
                                        system.showTasks();
                                        break;
                                    case 5:
                                        system.showDetails();
                                        break;
                                    case 6:
                                        usermenu = false;
                                        break;
                                    default:
                                        System.out.println("Enter Correct Selection");
                                }
                            }
                        }
                        break;
                    case 3:
                        programrunning = false;
                        break;
                    default:
                        System.out.println("Invalid Selection\n");
                }
                System.out.println();
            }
            catch(NumberFormatException e){
                System.out.println("Invalid Input detected\n");
            }
            catch (Exception e){
                System.out.println("Something went wrong\n");
            }
        }while(programrunning);
        System.out.println("---- Terminated ----");
    }
}
