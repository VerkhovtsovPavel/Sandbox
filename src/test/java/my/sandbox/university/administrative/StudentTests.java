package my.sandbox.university.administrative;

import static my.sandbox.constant.StringConstant.IVAN;
import static my.sandbox.constant.StringConstant.IVANOV;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.testng.annotations.Test;

import my.sandbox.university.exception.EmptyUnitException;
import my.sandbox.university.exception.InvalidMarkException;
import my.sandbox.university.methodology.Subject;

public class StudentTests {
    @Test(expectedExceptions = EmptyUnitException.class)
    public void studentsShouldHasASubject() throws EmptyUnitException {
        new Student(IVAN, IVANOV).averageMark();
    }

    @Test(expectedExceptions = InvalidMarkException.class)
    public void markShouldBeFromOneToTenUseEleven() throws InvalidMarkException {
        new Student(IVAN, IVANOV).assess(Subject.MATH, 11);
    }

    @Test(expectedExceptions = InvalidMarkException.class)
    public void markShouldBeFromOneToTenUseMinusOne() throws InvalidMarkException {
        new Student(IVAN, IVANOV).assess(Subject.MATH, -1);
    }

    @Test
    public void shouldReturnEmptyListIfSubjectNotTaken() throws InvalidMarkException {
        Student ivanov = new Student(IVAN, IVANOV);
        ivanov.assess(Subject.MATH, 10);
        assertEquals(ivanov.getMarksBySubject(Subject.DRAWING), new ArrayList<Integer>());
    }

    @Test
    public void shouldReturnAllMarksBySubjectWhenOneMarkAdded() throws InvalidMarkException {
        Student ivanov = new Student(IVAN, IVANOV);
        ivanov.assess(Subject.MATH, 10);
        assertEquals(ivanov.getMarksBySubject(Subject.MATH), new ArrayList<>(Collections.singletonList(10)));
    }

    @Test
    public void shouldReturnAllMarksBySubjectWhenTwoMarkAdded() throws InvalidMarkException {
        Student ivanov = new Student(IVAN, IVANOV);
        ivanov.assess(Subject.MATH, 10);
        ivanov.assess(Subject.MATH, 0);
        assertEquals(ivanov.getMarksBySubject(Subject.MATH), new ArrayList<>(Arrays.asList(10, 0)));
    }

    @Test
    public void shouldReturnOnlyMarksByRequiredSubject() throws InvalidMarkException {
        Student ivanov = new Student(IVAN, IVANOV);
        ivanov.assess(Subject.MATH, 10);
        ivanov.assess(Subject.MODERN_ART, 10);
        ivanov.assess(Subject.MATH, 0);
        assertEquals(ivanov.getMarksBySubject(Subject.MATH), new ArrayList<>(Arrays.asList(10, 0)));
    }

    @Test
    public void averageMarkShouldIncludeAllSubjects() throws InvalidMarkException, EmptyUnitException {
        Student ivanov = new Student(IVAN, IVANOV);
        ivanov.assess(Subject.MATH, 10);
        ivanov.assess(Subject.MODERN_ART, 0);
        assertEquals(ivanov.averageMark(), 5.0);
    }
}
