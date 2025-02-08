package my.sandbox.university.administrative;

import static my.sandbox.common.constant.IntConstant.TEN;
import static my.sandbox.common.constant.IntConstant.ZERO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import my.sandbox.university.exception.EmptyUnitException;
import my.sandbox.university.exception.InvalidMarkException;
import my.sandbox.university.methodology.Subject;
import my.sandbox.university.unit.Statistics;

public class Student implements MarkedBySubject {
    private final int id;
    private final String firstName;
    private final String lastName;
    private Map<Subject, ArrayList<Integer>> marks;

    public Student(String firstName, String lastName) {
        this.id = firstName.hashCode() ^ lastName.hashCode();
        this.firstName = firstName;
        this.lastName = lastName;
        this.marks = new HashMap<>();
    }

    public void assess(Subject subject, int mark) throws InvalidMarkException {
        if (mark < ZERO || mark > TEN) {
            throw new InvalidMarkException(mark + "isn't valid mark. Please use marks from 0 to 10");
        }
        ArrayList<Integer> subjectMarks = marks.get(subject);
        if (subjectMarks == null) {
            ArrayList<Integer> firstMark = new ArrayList<>();
            firstMark.add(mark);
            marks.put(subject, firstMark);
        }
        else {
            subjectMarks.add(mark);
        }
    }

    public double averageMarkBySubject(Subject subject) {
        return Statistics.average(getMarksBySubject(subject));
    }

    public double averageMark() throws EmptyUnitException {
        Set<Subject> studentsSubjects = marks.keySet();
        if (studentsSubjects.isEmpty()) {
            throw new EmptyUnitException();
        }
        ArrayList<Integer> allMarks = new ArrayList<>();
        for (Subject subject : studentsSubjects) {
            allMarks.addAll(getMarksBySubject(subject));
        }
        return Statistics.average(allMarks);
    }

    @Override
    public ArrayList<Integer> getMarksBySubject(Subject subject) {
        ArrayList<Integer> marksBySubject = marks.get(subject);
        if (marksBySubject == null) {
            return new ArrayList<>();
        }
        return marksBySubject;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
