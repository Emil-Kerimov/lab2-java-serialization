import java.io.Serializable;

public class Human implements Serializable {
    public String name;
    public String lastName;
    public Human(String name, String lastName){
        this.name = name;
        this.lastName = lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }
}
