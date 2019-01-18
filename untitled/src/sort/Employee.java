package sort;

public class Employee {
    private String name;

    public Employee(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


//    @Override
//    public String toString() {
//        return "Employee{" +
//                "name='" + name + '\'' +
//                '}';
//    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }

//    @Override
//    public boolean equals(final Object o) {
//        if (this == o) return true;
//
//        if (o == null || getClass() != o.getClass()) return false;
//
//        final Employee employee = (Employee) o;
//
//        return new org.apache.commons.lang.builder.EqualsBuilder()
//                .append(name, employee.name)
//                .isEquals();
//    }
//
//    @Override
//    public int hashCode() {
//        return 1;
//    }

//    @Override
//    public boolean equals(final Object obj) {
//        return false;
//    }

    //    @Override
//    public boolean equals(final Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        final Employee employee = (Employee) o;
//
//        return name != null ? name.equals(employee.name) : employee.name == null;
//    }
}
