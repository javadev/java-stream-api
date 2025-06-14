package java_stream_api;

import java.util.Objects;

public class Person {
    private final String name, city;

    public Person(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Person)
                && Objects.equals(((Person) o).name, name)
                && Objects.equals(((Person) o).city, city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city);
    }
}
