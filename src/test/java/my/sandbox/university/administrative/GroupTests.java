package my.sandbox.university.administrative;

import static my.sandbox.constant.StringConstant.IVAN;
import static my.sandbox.constant.StringConstant.IVANOV;
import static my.sandbox.constant.StringConstant.PETR;
import static my.sandbox.constant.StringConstant.PETROV;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.Test;

import my.sandbox.university.exception.EmptyUnitException;
import my.sandbox.university.exception.InvalidMarkException;
import my.sandbox.university.methodology.Subject;

public class GroupTests {
    @Test(expectedExceptions = EmptyUnitException.class)
    public void shouldHasAStudents() throws EmptyUnitException {
        new Group(1).getMarksBySubject(Subject.MATH);
    }

    @Test
    public void shouldReturnEmptyListIfNoOneStudentTakeASubject() throws EmptyUnitException {
        Group group = new Group(1);
        group.addStudent(new Student(IVAN, IVANOV));
        assertTrue(group.getMarksBySubject(Subject.MATH).isEmpty());
    }

    @Test
    public void shouldReturnListWithAllMarkForSingleStudent() throws EmptyUnitException, InvalidMarkException {
        Group group = new Group(1);
        Student ivanov = new Student(IVAN, IVANOV);
        ivanov.assess(Subject.MATH, 10);
        ivanov.assess(Subject.MATH, 10);
        group.addStudent(ivanov);
        assertEquals(group.getMarksBySubject(Subject.MATH), new ArrayList<Integer>(Arrays.asList(10, 10)));
    }

    @Test
    public void shouldReturnListWithMarkForAllStudents() throws EmptyUnitException, InvalidMarkException {
        Group group = new Group(1);
        Student ivanov = new Student(IVAN, IVANOV);
        Student petrov = new Student(PETR, PETROV);
        ivanov.assess(Subject.MATH, 10);
        petrov.assess(Subject.MATH, 10);
        group.addStudent(ivanov);
        group.addStudent(petrov);
        assertEquals(group.getMarksBySubject(Subject.MATH), new ArrayList<Integer>(Arrays.asList(10, 10)));
    }
}
