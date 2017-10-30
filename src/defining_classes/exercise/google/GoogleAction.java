package defining_classes.exercise.google;

import java.util.LinkedHashMap;
import java.util.Map;

class GoogleAction {

    private Map<String, Person> people;

    GoogleAction() {
        this.people = new LinkedHashMap<>();
    }

    void addPerson(String line){

        String[] token = line.split(" ");

        String name = token[0];
        String item = token[1];

        switch (item){
            case "company" : {
                String companyName = token[2];
                String department = token[3];
                double salary = Double.parseDouble(token[4]);

                people.computeIfAbsent(name, v ->  new Person(name));
                people.get(name).setCompany(companyName, department, salary);
                break;

            }

            case "pokemon" : {
                String pokemonName = token[2];
                String pokemonType = token[3];

                if (!people.containsKey(name)) {
                    Person p = new Person(name);
                    people.put(name, p);
                }

                people.get(name).addPokemon(pokemonName, pokemonType);
                break;
            }

            case "parents" :{
                String parentName = token[2];
                String birthday = token[3];

                people.computeIfAbsent(name, v ->  new Person(name));
                people.get(name).addParent(parentName, birthday);
                break;
            }

            case "children" :{
                String childName = token[2];
                String birthday = token[3];

                people.computeIfAbsent(name, v ->  new Person(name));
                people.get(name).addChild(childName, birthday);
                break;
            }

            case "car" : {
                String carName = token[2];
                int speed = Integer.parseInt(token[3]);

                people.computeIfAbsent(name, v ->  new Person(name));
                people.get(name).setCar(carName, speed);
                break;

            }

        }

    }

    Person getPerson(String name){
        return this.people.get(name);
    }

}
