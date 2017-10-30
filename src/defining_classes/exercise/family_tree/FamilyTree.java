package defining_classes.exercise.family_tree;

import java.util.*;

public class FamilyTree {

    private Map<String, FamilyMember> tree;

    public FamilyTree() {
        this.tree = new LinkedHashMap<>();
    }

    public void addMember(String line){
        if(line.contains("-")){
            String[] input = line.split("\\s*-\\s*");
            String parentData = input[0];
            String childData = input[1];
            FamilyMember parent = new FamilyMember(parentData);
            FamilyMember child = new FamilyMember(childData);
//            System.out.println(parent);
//            System.out.println(child);

//            System.out.println(Arrays.toString(input));

            if(!tree.containsKey(parentData)){
                tree.put(parentData, parent);
            }

            if(!tree.containsKey(childData)){
                tree.put(childData, child);
            }

            tree.get(parentData).addChild(child);
            tree.get(childData).addParent(parent);

        }else{
            String[] input = line.split("\\s+");
            String name = String.format("%s %s", input[0], input[1]);
            String date = input[2];
//            System.out.println(Arrays.toString(input));
//            System.out.println(name);
            if(tree.containsKey(name)){
                tree.get(name).setBirthDate(date);
            }

            if(tree.containsKey(date)){
                tree.get(date).setName(name);
            }
        }

//        System.out.println(tree);
    }

    public List<FamilyMember> getMembers(){
        List<FamilyMember> result = new ArrayList<>();

        for (FamilyMember familyMember : tree.values()) {
            if(!result.contains(familyMember)){
                result.add(familyMember);
            } else {
                List<FamilyMember> children = result.get(result.indexOf(familyMember)).getChildren();
                for (FamilyMember member : familyMember.getChildren()) {
                    if(!children.contains(member)){
                        children.add(member);
                    }
                }

                List<FamilyMember> parents = result.get(result.indexOf(familyMember)).getParents();
                for (FamilyMember member : familyMember.getParents()) {
                    if(!parents.contains(member)){
                        parents.add(member);
                    }
                }
            }

        }
//        System.out.println(result);
        return result;
    }


}
