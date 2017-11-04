package inheritance.exercises.animals;

class Cat extends Animal{

    Cat(String name, String age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "MiauMiau";
    }
}
