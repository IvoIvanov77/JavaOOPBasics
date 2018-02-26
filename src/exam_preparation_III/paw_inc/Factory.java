package exam_preparation_III.paw_inc;

import exam_preparation_III.paw_inc.centers.AdoptionCenter;
import exam_preparation_III.paw_inc.centers.CleansingCenter;

public class Factory {

    public static AdoptionCenter createAdoptionCenter(String name){
        return new AdoptionCenter(name);
    }

    public static CleansingCenter createCleansingCenter(String name){
        return new CleansingCenter(name);
    }


}
