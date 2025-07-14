public abstract class Person {

    protected String name;
    protected String email;
    protected String number;
    protected int pin;

    public abstract boolean login(String username, int pass);
    public abstract String getDetails();
}
