package java_tests;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

/**
 * Created by ritvikmathur on 6/19/17.
 */
public class Person {

    String name;

    Integer id;

    Integer age;

    Date dob;


    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        if (id != null ? !id.equals(person.id) : person.id != null) return false;
        if (age != null ? !age.equals(person.age) : person.age != null) return false;
        return dob != null ? dob.equals(person.dob) : person.dob == null;
    }

    @Override
    public int hashCode() {
        Object[] x = {name, id, age, dob};
        return Arrays.hashCode(x);

    }
}
