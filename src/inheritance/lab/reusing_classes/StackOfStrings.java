package inheritance.lab.reusing_classes;

import java.util.List;

public class StackOfStrings {

    private List<String> container;

    public void push(String item){ container.add(item); }

    public String pop() {return container.remove(container.size() - 1); }

    public String peek() {return container.get(container.size() - 1); }

    public boolean isEmpty(){return this.container.isEmpty();}


}
