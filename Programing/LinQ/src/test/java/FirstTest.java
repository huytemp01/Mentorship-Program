import org.example.Linq;
import org.example.Student;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class FirstTest {
    @Test
    public void Test_first_number_greater_than_5(){
        //Arrange
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(6);
        numbers.add(1);
        numbers.add(2);
        numbers.add(7);
        int expected = 6;
        //Act
        int result = Linq.from(numbers).first(e -> e > 5);
        //
        Assert.assertEquals(expected,result);
    }

    @Test
    public void Test_first_student_have_id_greater_than_5(){
        //Arrange
        List<Student> students = new ArrayList<>();
        Student s1 = new Student(1,"Vu","Duc Huy");
        Student s2 = new Student(2,"Nguyen","Xuan Thang");
        Student s3 = new Student(3,"Tran","Duc Manh");
        Student s4 = new Student(4,"Vu","Hoang Nguyen");
        Student s5 = new Student(5,"Trinh","Van Quyet");
        Student s6 = new Student(6,"Hoang","Ngoc Tu");
        students.addAll(Arrays.asList(s1,s2,s3,s4,s5,s6));
        Student expected = s6;
        //Act
        Student result = Linq.from(students).first(e -> e.getId() > 5);
        //
        Assert.assertEquals(expected,result);
    }

    @Test(expected = NoSuchElementException.class)
    public void Test_first_should_return_throw_exception(){
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
        Student result = Linq.from(students).first(e -> e.getId() > 6);

    }


    @Test(expected = NoSuchElementException.class)
    public void Test_first_should_throw_expection(){
        //Arrange
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(6);
        numbers.add(1);
        numbers.add(2);
        numbers.add(7);
        int expected = 6;
        //Act
        int result = Linq.from(numbers).first(e -> e > 9);
    }
}
