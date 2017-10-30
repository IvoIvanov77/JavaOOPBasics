package defining_classes.exercise.family_tree;

import com.sun.org.apache.bcel.internal.generic.FADD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String member = reader.readLine();

        String line = reader.readLine();


        FamilyTree familyTree = new FamilyTree();

        while(!line.equalsIgnoreCase("end")){

            if(line.isEmpty()){
                return;
            }
            familyTree.addMember(line);
            line = reader.readLine();
        }

        List<FamilyMember> members = familyTree.getMembers();
        FamilyMember familyMember = getMember(member, members);
        if(familyMember == null) return;


        setList(familyMember.getParents(), members);

        System.out.println(familyMember);

        familyMember.printParents();
        familyMember.printChildren();
    }

    public static FamilyMember getMember(String token, List<FamilyMember> members){

        for (FamilyMember member : members) {
            if(member.getName().equals(token) || member.getBirthDate().equals(token)){
                return member;
            }
        }
        return null;
    }

    public static void setList(List<FamilyMember> toSet, List<FamilyMember> setter){

        for (FamilyMember familyMember : toSet) {
//            System.out.println(familyMember);
            if(familyMember.getName() == null){
                for (int i = 0; i < setter.size(); i++) {
                    if(familyMember.getBirthDate().equals(setter.get(i).getBirthDate())){
                        familyMember.setName(setter.get(i).getName());
                    }
                }
            }
        }

    }


}
