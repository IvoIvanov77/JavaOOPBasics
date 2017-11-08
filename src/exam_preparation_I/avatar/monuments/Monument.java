package exam_preparation_I.avatar.monuments;

public abstract class Monument {

    private String name;

    Monument(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getAffinity();


}
