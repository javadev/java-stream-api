package java_stream_api;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private String name;
    private int age;
    private String birthdate;
    private List<String> hobbies = new ArrayList<>();

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public int getBirthYear() {
        return 2000 - age;
    }

    public void setBirthdate(String b) {
        this.birthdate = b;
    }

    public String getBirthdate() {
        return birthdate;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof User)
                && Objects.equals(((User) o).name, name)
                && ((User) o).age == age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
