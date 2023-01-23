import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CohortTest {
    private Cohort cohort;
    private List<Student> students;
    private Student student1;
    private Student student2;
    private double cohortGPA;

    @Before
    public void setUp() {
        this.cohort = new Cohort();
        this.student1 = new Student(1, "Carl");
        this.student2 = new Student(2, "Karl");
        this.students = Arrays.asList(student1, student2);
        cohort.addStudent(student1);
        cohort.addStudent(student2);
        student1.addGrade(78);
        student1.addGrade(84);
        student2.addGrade(91);
        student2.addGrade(70);
        double sum = 0;
        for (Student student : students) {
            sum += student.getGradeAverage();
        }
        cohortGPA = (sum / students.size());
    }

    @Test
    public void addStudent() {
        assertEquals(2, cohort.getStudents().size());
    }

    @Test
    public void listOfStudents() {
        assertEquals(students, cohort.getStudents());
    }

    @Test
    public void averageOfCohort() {
        assertEquals(cohortGPA, cohort.getCohortAverage(), .001);
    }

}
