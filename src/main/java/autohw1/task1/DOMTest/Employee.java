package autohw1.task1.DOMTest;

public class Employee {
    private String firstName;
    private String lastName;
    private String position;
    private String department;
    private int expYears;

    public Employee(String firstName, String lastName, String position, String department, int expYears) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.department = department;
        this.expYears = expYears;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public int getExpYears() {
        return expYears;
    }
}