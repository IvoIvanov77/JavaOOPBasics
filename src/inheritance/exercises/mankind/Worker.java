package inheritance.exercises.mankind;

public class Worker extends Human{

    private Double weekSalary;
    private Double workHoursPerDay;

    Worker(String firstName, String lastName, Double weekSalary, Double workHoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    private Double getWeekSalary() {
        return weekSalary;
    }

    private void setWeekSalary(Double weekSalary) {
        if(weekSalary <= 10){
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    private Double getWorkHoursPerDay() {
        return workHoursPerDay;
    }

    private void setWorkHoursPerDay(Double workHoursPerDay) {
        if(workHoursPerDay < 1 && workHoursPerDay > 12){
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHoursPerDay = workHoursPerDay;
    }

    private Double getSalaryPerHour(){
        return this.weekSalary / 7 / this.workHoursPerDay;
    }


    @Override
    public void setLastName(String lastName) {
        if(lastName.length() < 4){
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
        super.setLastName(lastName);
    }

    @Override
    public String toString() {
        return String.format(
                "%s" +
                        "Week Salary: %.2f\n" +
                        "Hours per day: %.2f\n" +
                        "Salary per hour: %.2f\n",
                super.toString(),
                this.getWeekSalary(),
                this.getWorkHoursPerDay(),
                this.getSalaryPerHour()
        );
    }
}
