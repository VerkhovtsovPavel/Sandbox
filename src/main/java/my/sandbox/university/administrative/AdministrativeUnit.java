package my.sandbox.university.administrative;

import java.util.ArrayList;
import java.util.Collection;

import my.sandbox.university.exception.EmptyUnitException;
import my.sandbox.university.methodology.Subject;

public abstract class AdministrativeUnit {
    ArrayList<Integer> getMarksBySubject(Collection<? extends MarkedBySubject> units, Subject subject)
        throws EmptyUnitException {
        if (units.isEmpty()) {
            throw new EmptyUnitException();
        }
        ArrayList<Integer> resultList = new ArrayList<>();
        for (MarkedBySubject unit : units) {
            resultList.addAll(unit.getMarksBySubject(subject));
        }
        return resultList;
    }
}
