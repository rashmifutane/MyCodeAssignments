package comparator;

/**
 * Created by futaner on 01/08/17.
 */
public class Employee {

private int id;
private int age;
private String firstName;
private String lastName;



    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
       return true;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
