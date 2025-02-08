package my.sandbox.university.administrative;

import java.util.ArrayList;

import my.sandbox.university.exception.EmptyUnitException;
import my.sandbox.university.methodology.Subject;

public class Group extends AdministrativeUnit implements MarkedBySubject {
    private int number;
    private ArrayList<Student> students;

    public Group(int number) {
        this.number = number;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public ArrayList<Integer> getMarksBySubject(Subject subject) throws EmptyUnitException {
        return getMarksBySubject(students, subject);
    }

    public int getNumber() {
        return number;
    }
}
