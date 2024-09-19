import org.example.Linq;
import org.example.Student;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountTest {

    @Test
    public void Test_count_number_greater_than_5(){
        //Arrange
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(6);
        numbers.add(1);
        numbers.add(2);
        numbers.add(7);
        Linq<Integer> linq = Linq.from(numbers);
        int expected = 2;
        //Act
        long count = linq.count(e -> e > 5);
        //Assert
        Assert.assertEquals(expected, count);
    }

    @Test
    public void Test_count_length_List(){
        //Arrange
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(6);
        numbers.add(1);
        numbers.add(2);
        numbers.add(7);
        Linq<Integer> linq = Linq.from(numbers);
        int expected = 5;
        //Act
        long count = linq.count();
        //Assert
        Assert.assertEquals(expected,count);
    }

    @Test
    public void Test_count_student_have_id_less_than_4(){
        //Arrange
        List<Student> students = new ArrayList<>();
        Student s1 = new Student(1,"Vu","Duc Huy");
        Student s2 = new Student(2,"Nguyen","Xuan Thang");
        Student s3 = new Student(3,"Tran","Duc Manh");
        Student s4 = new Student(4,"Vu","Hoang Nguyen");
        Student s5 = new Student(5,"Trinh","Van Quyet");
        Student s6 = new Student(6,"Hoang","Ngoc Tu");
        students.addAll(Arrays.asList(s1,s2,s3,s4,s5,s6));
        Linq<Student> linq = Linq.from(students);
        long expected = 3;
        //Act
        long count = linq.count(e -> e.getId() < 4);
        //Assert
        Assert.assertEquals(expected, count);
    }

    @Test
    public void Test_Count_should_return_number_of_students_have_id_less_than_4_and_is_even(){
        //Arrange
        List<Student> students = new ArrayList<>();
        Student s1 = new Student(1,"Vu","Duc Huy");
        Student s2 = new Student(2,"Nguyen","Xuan Thang");
        Student s3 = new Student(3,"Tran","Duc Manh");
        Student s4 = new Student(4,"Vu","Hoang Nguyen");
        Student s5 = new Student(5,"Trinh","Van Quyet");
        Student s6 = new Student(6,"Hoang","Ngoc Tu");
        students.addAll(Arrays.asList(s1,s2,s3,s4,s5,s6));
        Linq<Student> linq = Linq.from(students);
        long expected = 1;
        //Act
        long count = linq.count(e -> e.getId() < 4 && e.getId()%2 == 0);
        //Assert
        Assert.assertEquals(expected, count);
    }

}
