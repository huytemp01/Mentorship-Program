import org.example.Gender;
import org.example.Linq;
import org.example.Student;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GroupTest {
    @Test
    public void Test_Group_By_Gender(){
        //Arrange
        List<Student> students = new ArrayList<>();
        Student s1 = new Student(1,"Vu","Duc Huy", Gender.MALE);
        Student s2 = new Student(2,"Nguyen","Xuan Thang", Gender.MALE);
        Student s3 = new Student(3,"Trinh","Thu Cuc",Gender.FEMALE );
        Student s4 = new Student(4,"Vu","Hoang Nguyen", Gender.MALE);
        Student s5 = new Student(5,"Nguyen","Ngoc Anh", Gender.FEMALE);
        Student s6 = new Student(6,"Hoang","Ngoc Tu", Gender.MALE);
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        students.add(s6);
        //Act
        Map<Gender, List<Student>> result = Linq.from(students).groupBy(Student::getGender);
        //Assert
        Assert.assertEquals(result.get(Gender.MALE).size(), 4);
        Assert.assertEquals(result.get(Gender.FEMALE).size(),2);
    }

    @Test
    public void Test_Group_By_Age(){
        //Arrange
        List<Student> students = new ArrayList<>();
        Student s1 = new Student(1,"Vu","Duc Huy", 20);
        Student s2 = new Student(2,"Nguyen","Xuan Thang", 25);
        Student s3 = new Student(3,"Trinh","Thu Cuc",20 );
        Student s4 = new Student(4,"Vu","Hoang Nguyen", 21);
        Student s5 = new Student(5,"Nguyen","Ngoc Anh", 21);
        Student s6 = new Student(6,"Hoang","Ngoc Tu", 20);
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        students.add(s6);
        //Act
        Map<Integer, List<Student>> result = Linq.from(students).groupBy(Student::getAge);
        //Assert
        Assert.assertEquals(result.get(20).size(), 3);
        Assert.assertEquals(result.get(21).size(),2);
        Assert.assertEquals(result.get(25).size(),1);
    }
}
