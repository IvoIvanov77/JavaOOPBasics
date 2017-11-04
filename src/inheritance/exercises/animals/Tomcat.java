package inheritance.exercises.animals;

class Tomcat extends Cat {

    Tomcat(String name, String age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Give me one million b***h";
    }

    @Override
    public void setGender(String gender) {
        if(!gender.equals("Male")){
            throw new IllegalArgumentException("Invalid input!");
        }
        super.setGender(gender);
    }
}
