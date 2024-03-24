package version3;

import java.io.*;

public class Author extends  Human implements Externalizable {

    public Author(String name, String lastName) {
        super(name, lastName);
    }
    public Author(){}

    @Override
    public String toString() {
        return "name: " + name + " lastName: " + lastName;
    }
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(getName());
        out.writeObject(getLastName());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setName((String) in.readObject());
        setLastName((String) in.readObject());
    }
}
