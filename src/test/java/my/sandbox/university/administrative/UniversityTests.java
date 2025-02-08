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

public class UniversityTests {
    @Test(expectedExceptions = EmptyUnitException.class)
    public void shouldHasAGroup() throws EmptyUnitException {
        new University().getMarksBySubject(Subject.MATH);
    }

    @Test
    public void shouldReturnEmptyListIfNoOneStudentTakeASubject() throws EmptyUnitException {
        University university = new University();
        Faculty faculty = new Faculty(FacultyName.ART);
        Group group = new Group(1);
        group.addStudent(new Student(IVAN, IVANOV));
        faculty.addGroup(group);
        university.addFaculty(faculty);
        assertTrue(university.getMarksBySubject(Subject.MATH).isEmpty());
    }

    @Test
    public void shouldReturnListWithAllMarkForSingleStudent() throws EmptyUnitException, InvalidMarkException {
        University university = new University();
        Faculty faculty = new Faculty(FacultyName.ART);
        Group group = new Group(1);
        Student ivanov = new Student(IVAN, IVANOV);
        ivanov.assess(Subject.MATH, 10);
        ivanov.assess(Subject.MATH, 10);
        group.addStudent(ivanov);
        faculty.addGroup(group);
        university.addFaculty(faculty);
        assertEquals(university.getMarksBySubject(Subject.MATH), new ArrayList<>(Arrays.asList(10, 10)));
    }

    @Test
    public void shouldReturnListWithMarkForAllStudentsInSingleGroup() throws EmptyUnitException, InvalidMarkException {
        University university = new University();
        Faculty faculty = new Faculty(FacultyName.ART);
        Group group = new Group(1);
        Student ivanov = new Student(IVAN, IVANOV);
        Student petrov = new Student(PETR, PETROV);
        group.addStudent(ivanov);
        group.addStudent(petrov);
        faculty.addGroup(group);
        university.addFaculty(faculty);

        ivanov.assess(Subject.MATH, 10);
        petrov.assess(Subject.MATH, 10);
        assertEquals(university.getMarksBySubject(Subject.MATH), new ArrayList<>(Arrays.asList(10, 10)));
    }

    @Test
    public void shouldReturnListWithMarkForAllStudentsForAllGroupsForAllFaculties()
        throws EmptyUnitException, InvalidMarkException {
        Faculty artFaculty = new Faculty(FacultyName.ART);
        Group firstGroupArt = new Group(1);
        Student ivanovArt = new Student(IVAN, IVANOV);
        Student petrovArt = new Student(PETR, PETROV);
        ivanovArt.assess(Subject.MATH, 10);
        petrovArt.assess(Subject.MATH, 10);
        firstGroupArt.addStudent(ivanovArt);
        firstGroupArt.addStudent(petrovArt);
        artFaculty.addGroup(firstGroupArt);

        Group secondGroupArt = new Group(2);
        Student sidorovArt = new Student(SIDOR, SIDOROV);
        Student vasilievArt = new Student(VASILII, VASILIEV);
        sidorovArt.assess(Subject.MATH, 7);
        vasilievArt.assess(Subject.MATH, 8);
        secondGroupArt.addStudent(sidorovArt);
        secondGroupArt.addStudent(vasilievArt);
        artFaculty.addGroup(secondGroupArt);

        Faculty mathFaculty = new Faculty(FacultyName.MATHEMATICS);
        Group firstGroup = new Group(1);
        Student ivanov = new Student(IVAN, IVANOV);
        Student petrov = new Student(PETR, PETROV);
        ivanov.assess(Subject.MATH, 10);
        petrov.assess(Subject.MATH, 10);
        firstGroup.addStudent(ivanov);
        firstGroup.addStudent(petrov);
        mathFaculty.addGroup(firstGroup);

        Group secondGroup = new Group(2);
        Student sidorov = new Student(SIDOR, SIDOROV);
        Student vasiliev = new Student(VASILII, VASILIEV);
        sidorov.assess(Subject.MATH, 7);
        vasiliev.assess(Subject.MATH, 8);
        secondGroup.addStudent(sidorov);
        secondGroup.addStudent(vasiliev);
        mathFaculty.addGroup(secondGroup);

        University university = new University();
        university.addFaculty(artFaculty);
        university.addFaculty(mathFaculty);

        assertEquals(university.getMarksBySubject(Subject.MATH),
            new ArrayList<>(Arrays.asList(10, 10, 7, 8, 10, 10, 7, 8)));
    }
}
