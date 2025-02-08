package my.sandbox.university.administrative;

import java.util.ArrayList;

import my.sandbox.university.exception.EmptyUnitException;
import my.sandbox.university.methodology.Subject;

public interface MarkedBySubject {
    ArrayList<Integer> getMarksBySubject(Subject subject) throws EmptyUnitException;
}
