package exam_preparation_III.paw_inc.centers;

abstract class Center {

    private String name;

    protected Center(String name) {
        this.setName(name);

    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }
}
