package inheritance.exercises.animals;

class Frog extends Animal{

    Frog(String name, String age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Frogggg";
    }
}
