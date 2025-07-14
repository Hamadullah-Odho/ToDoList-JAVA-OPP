import java.util.ArrayList;
import java.util.List;
public class User extends Person {

    private final List<String> tasks = new ArrayList<>();

    //setters

    public void setName(String name){this.name = name;}
    public void setEmail(String email){this.email = email;}
    public void setNumber(String number){ this.number = number;}
    public void setPin(int pin){this.pin = pin;}
    public void setTask(String task){tasks.add(task);}

    //getters

    public String getName(){return name;}
    public String getEmail(){return email;}
    public String getNumber(){return number;}
    public void getTasks(){
        int index = 0;
        for(String t : tasks){
            System.out.println(index + " " + t);
            index++;
        }
    }

    @Override
    public boolean login(String email, int pass) {

        if (getEmail().equals(email)) {
            if (pin == pass) {
                return true;
            }
            return false;
        } else {
            return false;
        }
    }

    public void removeTask(int index){
        tasks.remove(index);
    }

    public String getDetails(){
        String details = "Username : " + getName() + "\nEmail Address :" + getEmail() +
                "\nPhone number : " + getNumber();
        return details;
    }

    public void taskComplete(int index){
        tasks.get(index).replace("pending","completed");
    }


}
