import java.io.Serializable;

public class Author extends  Human implements Serializable {

    public Author(String name, String lastName) {
        super(name, lastName);
    }

    @Override
    public String toString() {
        return "name: " + name + " lastName: " + lastName;
    }
}
