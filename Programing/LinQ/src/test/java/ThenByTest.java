import org.example.Linq;
import org.example.Student;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThenByTest {
    @Test
    public void Test_OrderBy_firstname_thenBy_last_name(){
        //Arrange
        List<Student> students = new ArrayList<>();
        Student s1 = new Student(1,"Vu","Duc Huy");
        Student s2 = new Student(2,"Nguyen","Xuan Thang");
        Student s3 = new Student(3,"Tran","Duc Manh");
        Student s4 = new Student(4,"Vu","Hoang Nguyen");
        Student s5 = new Student(5,"Trinh","Van Quyet");
        Student s6 = new Student(6,"Hoang","Ngoc Tu");
        students.addAll(Arrays.asList(s1,s2,s3,s4,s5,s6));
        //Act
        List<Student> result = Linq.from(students).orderBy(Student::getFirstName).thenBy(Student::getLastName).toList();
        //Assert
        Assert.assertEquals("Hoang", result.get(0).getFirstName());
        Assert.assertEquals("Vu", result.get(result.size() -1).getFirstName());
        Assert.assertEquals("Duc Huy", result.get(result.size()-1).getLastName());
    }

    @Test
    public void Test_OrderBy_firstname_thenBy_id(){
        //Arrange
        List<Student> students = new ArrayList<>();
        Student s1 = new Student(1,"Vu","Duc Huy");
        Student s2 = new Student(2,"Nguyen","Xuan Thang");
        Student s3 = new Student(3,"Tran","Duc Manh");
        Student s4 = new Student(4,"Vu","Hoang Nguyen");
        Student s5 = new Student(5,"Trinh","Van Quyet");
        Student s6 = new Student(6,"Hoang","Ngoc Tu");
        students.addAll(Arrays.asList(s1,s2,s3,s4,s5,s6));
        //Act
        List<Student> result = Linq.from(students).orderBy(Student::getFirstName).thenBy(Student::getId).toList();
        //Assert
        Assert.assertEquals("Hoang", result.get(0).getFirstName());
        Assert.assertEquals("Vu", result.get(result.size() -1).getFirstName());

    }
}
