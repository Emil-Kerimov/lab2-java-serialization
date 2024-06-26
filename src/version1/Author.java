package version1;
import java.io.Serializable;

public class Author extends  Human implements Serializable {
    private static final long serialVersionUID = 1L;

    public Author(String name, String lastName) {
        super(name, lastName);
    }

    @Override
    public String toString() {
        return "name: " + name + " lastName: " + lastName;
    }
}
