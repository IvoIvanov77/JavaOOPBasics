package defining_classes.exercise.try_to_fix_family_tree;

import java.util.ArrayList;
import java.util.List;

class FamilyMember {

    private String name;
    private String birthDate;
    private List<FamilyMember> parents;
    private List<FamilyMember> children;

    private FamilyMember() {
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    FamilyMember(String name, String birthDate) {
        this();
        this.name = name;
        this.birthDate = birthDate;
    }

    void addChild(FamilyMember child){
        this.children.add(child);
    }

    void addParent(FamilyMember parent){
        this.parents.add(parent);
    }

    void printParents(){
        System.out.println("Parents:");
        for (FamilyMember parent : parents) {
            System.out.println(parent);
        }
    }

    void printChildren(){
        System.out.println("Children:");
        for (FamilyMember child : children) {
            System.out.println(child);
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.birthDate);
    }
}
