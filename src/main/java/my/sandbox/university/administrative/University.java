package my.sandbox.university.administrative;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import my.sandbox.university.exception.EmptyUnitException;
import my.sandbox.university.methodology.FacultyName;
import my.sandbox.university.methodology.Subject;
import my.sandbox.university.unit.Statistics;

public class University extends AdministrativeUnit implements MarkedBySubject {
    private Map<FacultyName, Faculty> faculties;

    public University() {
        this.faculties = new HashMap<>();
    }

    public void addFaculty(Faculty faculty) {
        faculties.put(faculty.getName(), faculty);
    }

    @Override
    public ArrayList<Integer> getMarksBySubject(Subject subject) throws EmptyUnitException {
        return getMarksBySubject(faculties.values(), subject);
    }

    public double averageMarkBySubject(Subject subject) throws EmptyUnitException {
        return Statistics.average(getMarksBySubject(subject));
    }

    public double averageMarkBySubjectOnFaculty(FacultyName name, Subject subject) throws EmptyUnitException {
        return Statistics.average(faculties.get(name).getMarksBySubject(subject));
    }

    public double averageMarkBySubjectOnGroup(FacultyName name, int groupNumber, Subject subject)
        throws EmptyUnitException {
        return Statistics.average(faculties.get(name).getGroups().get(groupNumber).getMarksBySubject(subject));
    }
}
