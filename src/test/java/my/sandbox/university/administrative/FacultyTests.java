package my.sandbox.university.administrative;

import static my.sandbox.constant.StringConstant.IVAN;
import static my.sandbox.constant.StringConstant.IVANOV;
import static my.sandbox.constant.StringConstant.PETR;
import static my.sandbox.constant.StringConstant.PETROV;
import static my.sandbox.constant.StringConstant.SIDOR;
import static my.sandbox.constant.StringConstant.SIDOROV;
import static my.sandbox.constant.StringConstant.VASILIEV;
import static my.sandbox.constant.StringConstant.VASILII;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.Test;

import my.sandbox.university.exception.EmptyUnitException;
import my.sandbox.university.exception.InvalidMarkException;
import my.sandbox.university.methodology.FacultyName;
import my.sandbox.university.methodology.Subject;

public class FacultyTests {
    @Test(expectedExceptions = EmptyUnitException.class)
    public void shouldHasAGroup() throws EmptyUnitException {
        new Faculty(FacultyName.ART).getMarksBySubject(Subject.MATH);
    }

    @Test
    public void shouldReturnEmptyListIfNoOneStudentTakeASubject() throws EmptyUnitException {
        Faculty faculty = new Faculty(FacultyName.ART);
        Group group = new Group(1);
        group.addStudent(new Student(IVAN, IVANOV));
        faculty.addGroup(group);
        assertTrue(faculty.getMarksBySubject(Subject.MATH).isEmpty());
    }

    @Test
    public void shouldReturnListWithAllMarkForSingleStudent() throws EmptyUnitException, InvalidMarkException {
        Faculty faculty = new Faculty(FacultyName.ART);
        Group group = new Group(1);
        Student ivanov = new Student(IVAN, IVANOV);
        ivanov.assess(Subject.MATH, 10);
        ivanov.assess(Subject.MATH, 10);
        group.addStudent(ivanov);
        faculty.addGroup(group);
        assertEquals(faculty.getMarksBySubject(Subject.MATH), new ArrayList<>(Arrays.asList(10, 10)));
    }

    @Test
    public void shouldReturnListWithMarkForAllStudentsInSingleGroup() throws EmptyUnitException, InvalidMarkException {
        Faculty faculty = new Faculty(FacultyName.ART);
        Group group = new Group(1);
        Student ivanov = new Student(IVAN, IVANOV);
        Student petrov = new Student(PETR, PETROV);
        ivanov.assess(Subject.MATH, 10);
        petrov.assess(Subject.MATH, 10);
        group.addStudent(ivanov);
        group.addStudent(petrov);
        faculty.addGroup(group);
        assertEquals(faculty.getMarksBySubject(Subject.MATH), new ArrayList<>(Arrays.asList(10, 10)));
    }

    @Test
    public void shouldReturnListWithMarkForAllStudentsInAllGroups() throws EmptyUnitException, InvalidMarkException {
        Faculty faculty = new Faculty(FacultyName.ART);
        Group firstGroup = new Group(1);
        Student ivanov = new Student(IVAN, IVANOV);
        Student petrov = new Student(PETR, PETROV);
        ivanov.assess(Subject.MATH, 10);
        petrov.assess(Subject.MATH, 10);
        firstGroup.addStudent(ivanov);
        firstGroup.addStudent(petrov);
        faculty.addGroup(firstGroup);

        Group secondGroup = new Group(2);
        Student sidorov = new Student(SIDOR, SIDOROV);
        Student vasiliev = new Student(VASILII, VASILIEV);
        sidorov.assess(Subject.MATH, 7);
        vasiliev.assess(Subject.MATH, 8);
        secondGroup.addStudent(sidorov);
        secondGroup.addStudent(vasiliev);
        faculty.addGroup(secondGroup);

        assertEquals(faculty.getMarksBySubject(Subject.MATH), new ArrayList<>(Arrays.asList(10, 10, 7, 8)));
    }
}
