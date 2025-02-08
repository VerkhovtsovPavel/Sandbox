package my.sandbox.university.administrative;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import my.sandbox.university.exception.EmptyUnitException;
import my.sandbox.university.methodology.FacultyName;
import my.sandbox.university.methodology.Subject;

public class Faculty extends AdministrativeUnit implements MarkedBySubject {
    private FacultyName name;
    private Map<Integer, Group> groups;

    public Faculty(FacultyName name) {
        this.name = name;
        this.groups = new HashMap<>();
    }

    public Map<Integer, Group> getGroups() {
        return groups;
    }

    public void addGroup(Group group) {
        groups.put(group.getNumber(), group);
    }

    @Override
    public ArrayList<Integer> getMarksBySubject(Subject subject) throws EmptyUnitException {
        return getMarksBySubject(groups.values(), subject);
    }

    public FacultyName getName() {
        return name;
    }
}
