package inheritance.exercises.mankind;

public class Human {

//    The parent class – Human should have first name and last name. Every student has a faculty number.
//    Every worker has a week salary and work hours per day. It should be able to calculate the money he earns by hour.
//    You can see the constraints below.

    private String firstName;
    private String lastName;

    Human(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    private String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        if(!startsWithCapitalLetter(firstName)){
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
        }
        if(firstName.length() < 4){
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
        }
        this.firstName = firstName;
    }

    private String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(!startsWithCapitalLetter(lastName)){
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
        }
        if(lastName.length() < 3){
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName");
        }
        this.lastName = lastName;
    }

    private boolean startsWithCapitalLetter(String name){
        return name.toUpperCase().charAt(0) == name.charAt(0);
    }

    @Override
    public String toString() {
        return String.format(
                "First Name: %s\n" +
                "Last Name: %s\n",
                this.getFirstName(), this.getLastName());
    }
}
