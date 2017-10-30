package defining_classes.exercise.family_tree;

import java.util.ArrayList;
import java.util.List;

public class FamilyMember {

    private String name;
    private String birthDate;
    private List<FamilyMember> parents;
    private List<FamilyMember> children;

    public FamilyMember() {
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public FamilyMember(String name, String birthDate) {
        this();
        this.name = name;
        this.birthDate = birthDate;
    }

    public FamilyMember(String input){
        this();
        if(isBirthDate(input)){
            this.name = null;
            this.birthDate = input;
//            System.out.println(true + birthDate);
        }else{
            this.name = input;
            this.birthDate = null;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    private boolean isBirthDate(String input){
        return input.matches("\\d+/\\d+/\\d+");
    }

    public void addChild(FamilyMember child){
        this.children.add(child);
    }

    public void addParent(FamilyMember parent){
        this.parents.add(parent);
    }

    public void printParents(){
        System.out.println("Parents:");
        for (FamilyMember parent : parents) {
            System.out.println(parent);
        }
    }

    public void printChildren(){
        System.out.println("Children:");
        for (FamilyMember child : children) {
            System.out.println(child);
        }
    }

    public List<FamilyMember> getParents() {
        return parents;
    }

    public List<FamilyMember> getChildren() {
        return children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FamilyMember that = (FamilyMember) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return birthDate != null ? birthDate.equals(that.birthDate) : that.birthDate == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getName(), this.birthDate);
    }
}
