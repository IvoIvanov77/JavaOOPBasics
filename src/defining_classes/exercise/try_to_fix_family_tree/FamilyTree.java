package defining_classes.exercise.try_to_fix_family_tree;

import java.util.LinkedHashMap;
import java.util.Map;

class FamilyTree {

    private Map<String, FamilyMember> tree;

    FamilyTree() {
        this.tree = new LinkedHashMap<>();
    }


    void addMember(String line){
        String[] input = line.split("\\s+");
        String name = String.format("%s %s", input[0], input[1]);
        String birthDate = input[2];
        FamilyMember member = new FamilyMember(name, birthDate);
        this.tree.put(line, member);
    }

    void addChildAndParent(String line){
        String[] input = line.split("\\s+-\\s+");
        String parentData = input[0];
        String  childData = input[1];

        FamilyMember parent = getMember(parentData);
        FamilyMember child = getMember(childData);

        parent.addChild(child);
        child.addParent(parent);
    }

    FamilyMember getMember(String key){

        for (String s : tree.keySet()) {
           if(s.contains(key)) {
               return this.tree.get(s);
           }
        }
        return null;
    }

}
