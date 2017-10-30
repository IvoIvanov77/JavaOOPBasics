package defining_classes.exercise.try_to_fix_family_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String memberName = reader.readLine();

        List<String> membersData = new ArrayList<>();

        FamilyTree familyTree = new FamilyTree();

        String line;

        while(true){

           if("end".equalsIgnoreCase(line = reader.readLine())){
               break;
           }

           if(line.contains("-")){
               membersData.add(line);
           }else {
               familyTree.addMember(line);
           }
        }

        for (String membersDatum : membersData) {
            familyTree.addChildAndParent(membersDatum);
        }

        FamilyMember result = familyTree.getMember(memberName);
        System.out.println(result);
        result.printParents();
        result.printChildren();
    }
}
