package encapsulation.exercise.animal_farm;

class Chicken {

    private String name;
    private int age;

    Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private int getAge() {
        return age;
    }

    private void setAge(int age) {
        if(age < 0 || age > 15){
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    private float getEggsProduction() {
        if(this.getAge() < 6){
            return 2;
        }else if(this.getAge() < 12){
            return 1;
        }else {
            return 0.75f;
        }
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.0f eggs per day.",
                this.getName(), this.getAge(), this.getEggsProduction());
    }
}
