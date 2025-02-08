package my.sandbox.university;

import static my.sandbox.common.constant.IntConstant.EIGHTH;
import static my.sandbox.common.constant.IntConstant.ONE;
import static my.sandbox.common.constant.IntConstant.SEVEN;
import static my.sandbox.common.constant.IntConstant.SIX;
import static my.sandbox.common.constant.IntConstant.THREE;
import static my.sandbox.common.constant.IntConstant.TWO;
import static my.sandbox.common.logger.CommonLogger.LOG;

import my.sandbox.university.administrative.Faculty;
import my.sandbox.university.administrative.Group;
import my.sandbox.university.administrative.Student;
import my.sandbox.university.administrative.University;
import my.sandbox.university.exception.EmptyUnitException;
import my.sandbox.university.exception.InvalidMarkException;
import my.sandbox.university.methodology.FacultyName;
import my.sandbox.university.methodology.Subject;

public final class Main {
    private Main() {
    }

    public static void main(String[] arg) throws InvalidMarkException, EmptyUnitException {
        Student ivanov = new Student("Ivan", "Ivanov");
        Student petrov = new Student("Pert", "Petrov");
        Student sidorov = new Student("Sidor", "Sidorov");

        Group firstGroup = new Group(ONE);
        Group secondGroup = new Group(TWO);
        Group thirdGroup = new Group(THREE);

        firstGroup.addStudent(ivanov);
        secondGroup.addStudent(petrov);
        thirdGroup.addStudent(sidorov);

        Faculty artFaculty = new Faculty(FacultyName.ART);
        Faculty mathFaculty = new Faculty(FacultyName.MATHEMATICS);
        Faculty economicFaculty = new Faculty(FacultyName.ECONOMICS);

        artFaculty.addGroup(firstGroup);
        mathFaculty.addGroup(secondGroup);
        economicFaculty.addGroup(thirdGroup);

        University university = new University();
        university.addFaculty(artFaculty);
        university.addFaculty(mathFaculty);
        university.addFaculty(economicFaculty);

        ivanov.assess(Subject.MATH, SEVEN);
        petrov.assess(Subject.MATH, EIGHTH);
        sidorov.assess(Subject.MATH, SIX);

        LOG.info(ivanov.averageMarkBySubject(Subject.MATH));
        LOG.info(university.averageMarkBySubject(Subject.MATH));
        LOG.info(university.averageMarkBySubjectOnFaculty(FacultyName.ART, Subject.MATH));
        LOG.info(university.averageMarkBySubjectOnGroup(FacultyName.ART, 1, Subject.MATH));
    }
}
