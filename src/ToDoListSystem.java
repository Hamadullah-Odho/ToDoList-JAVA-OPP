import java.util.*;
final public class ToDoListSystem {
    Scanner scan = new Scanner(System.in);
    List<User> users = new ArrayList<>();
    private int currentuser = 0 ;

    public void signup(){
        try {
            System.out.print("---- Sign up ----\n");

            System.out.print("Enter Username : ");
            String username = scan.nextLine();

            System.out.println("\n Supported Addresses");
            System.out.println("1. @gmail.com \n2. @yahoo.com \n3. @hotmail.com");
            System.out.print("Enter Email Address : ");
            String email = scan.nextLine();

            System.out.print("Enter Phone Number : ");
            String phone = scan.nextLine();

            System.out.print("Enter Pin :");
            int pin = Integer.parseInt(scan.nextLine());

            if (email.endsWith("@gmail.com") || email.endsWith("@yahoo.com") || email.endsWith("@hotmail.com")) {
                User user = new User();
                user.setName(username);
                user.setEmail(email);
                user.setNumber(phone);
                user.setPin(pin);
                users.add(user);
                System.out.println("registered successfully");
            } else {
                System.out.println("Enter Correct Email");
            }
        }
        catch (NumberFormatException e){
            System.out.println("Invalid Input detected");
        }
        catch (Exception e){
            System.out.println("Something went wrong");
        }


    }
    public boolean signin(){
        System.out.println("---- Sign In ----\n");
        try {
            System.out.print("Enter Email :");
            String email = scan.nextLine();
            System.out.print("Enter Pin :");
            int pin = Integer.parseInt(scan.nextLine());
            boolean notFound = true;
            int index = 0;
            for (User u : users) {
                if (email.equals(u.getEmail())) {

                    u.login(email,pin);
                    System.out.println("Logged In");
                    currentuser = index;
                    notFound = false;
                    break;
                }
                index++;
            }
            if(notFound){
                System.out.println("Invalid Email or Pin");
                return false;
            }
            else{
                return true;
            }
        }
        catch (NumberFormatException e){
            System.out.println("Invalid pin format");
            return false;
        }
    }

    public void addTask(){
        try{
            System.out.println();
            System.out.println("---- Add Task ----\n");
            System.out.print("Enter Task : ");
            String task = scan.nextLine();
            users.get(currentuser).setTask(task.concat(" pending"));
            System.out.println("Task Added Successfully");

        }
        catch (NumberFormatException e){
            System.out.println("Non - numeric input found");

        }
        catch (Exception e){
            System.out.println("Something went wrong");
        }
    }

    public void showTasks(){
        System.out.println("---- Tasks List ----\n");
        users.get(currentuser).getTasks();
        System.out.println("----------------------");
    }

    public void deleteTask(){
        try {
            System.out.println("--- Delete Task ---\n");
            System.out.println("--- Task List ---");
            users.get(currentuser).getTasks();
            System.out.println("------------------");
            System.out.print("Enter Task Index : ");
            int index = Integer.parseInt(scan.nextLine());
            users.get(currentuser).removeTask(index);
            System.out.println("Task Removed Successfully");
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Enter Correct Index");
        }
        catch (Exception e){
            System.out.println("Something went wrong");
        }
    }

    public void showDetails(){
        System.out.println("--- User Details ---\n");
        System.out.println(users.get(currentuser).getDetails());
        System.out.println("-----------------------\n");
    }

    public void markComplete(){
        try {
            System.out.println("--- Mark Task As Complete ---\n");
            users.get(currentuser).getTasks();
            System.out.print("\nEnter Task Index :");
            int index = Integer.parseInt(scan.nextLine());
            users.get(currentuser).taskComplete(index);
            System.out.println("Task Marked As Completed");
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid Index Selected");
        }
    }
}
