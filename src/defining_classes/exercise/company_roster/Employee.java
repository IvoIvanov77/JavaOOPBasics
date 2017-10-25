package defining_classes.exercise.company_roster;

public class Employee {

    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    private Employee(String name, double salary, String position, String department) {
        this(name, salary, position, department, "n/a", -1);
    }

    private Employee(String name, double salary, String position, String department, String email) {
        this(name, salary, position, department, email, -1);
    }

    private Employee(String name, double salary, String position, String department, int age) {
        this(name, salary, position, department, "n/a", age);
    }

    private Employee(String name, double salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);
    }

    static Employee getInstance(String line){

        Employee employee;
        String[] input = line.split("\\s+");
        String name = input[0];
        double salary = Double.parseDouble(input[1]);
        String position = input[2];
        String department = input[3];

        if(input.length == 4){
            employee = new Employee(name, salary, position, department);
        }else if(input.length == 5){
            try {
                int age = Integer.parseInt(input[4]);
                employee = new Employee(name, salary, position, department, age);
            }catch(NumberFormatException e) {
                String email = input[4];
                employee = new Employee(name, salary, position, department, email);
            }
        }else {
            String email = input[4];
            int age = Integer.parseInt(input[5]);
            employee = new Employee(name, salary, position, department, email, age);
        }
        return employee;
    }

    String getDepartment() {
        return department;
    }


}
