package az.atlacademy.springbootintro.dto;

import java.util.Objects;

public class Student {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String address;
    private double fee;

    public Student(Long id, String name, String surname, String email, String address, double fee) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
        this.fee = fee;
    }

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(student.fee, fee) == 0 && Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects.equals(surname, student.surname) && Objects.equals(email, student.email) && Objects.equals(address, student.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email, address, fee);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", fee=" + fee +
                '}';
    }
}
