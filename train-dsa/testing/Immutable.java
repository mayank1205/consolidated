import java.util.ArrayList;
import java.util.List;

public final class Immutable {
    private final String name;
    private final String address;
    private final int number;
    private final List<String> subjects;
    // Fields are declared above
    // Constructor and getter methods below

    Immutable(String name, String address, int number, List<String> subjects) {
        this.name = name;
        this.address = address;
        this.number = number;
        this.subjects = new ArrayList<>(subjects);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getNumber() {
        return number;
    }

    public List<String> getSubjects() {
        // Return a copy of the list to maintain immutability
        return new ArrayList<>(subjects);
    }
}