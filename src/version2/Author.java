package version2;
import java.io.Serializable;

public class Author extends  Human {

    public Author(String name, String lastName) {
        super(name, lastName);
    }

    @Override
    public String toString() {
        return "name: " + name + " lastName: " + lastName;
    }
}
