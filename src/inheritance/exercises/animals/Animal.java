package inheritance.exercises.animals;

class Animal {

    private String name;
    private Integer age;
    private String gender;

    Animal(String name, String  age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    private String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(String s) {
        Integer age = null;
        try{
            age = Integer.parseInt(s);
        }catch (NumberFormatException e){
            System.out.println("Invalid input!");
        }
        if(age == null || age < 0){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    private String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if(gender.equals("Female") || gender.equals("Male")){
            this.gender = gender;
        }else{
            throw new IllegalArgumentException("Invalid input!");
        }

    }

    public String produceSound(){
        return "Not implemented!";
    }

    @Override
    public String toString() {
        return String.format(
                "%s\n" +
                "%s %s %s\n" +
                "%s",
                this.getClass().getSimpleName(),
                this.getName(), this.getAge(), this.getGender(),
                this.produceSound()
        );
    }
}
