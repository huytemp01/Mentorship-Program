import org.example.Linq;
import org.example.Student;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinqTest {

    @Test
    public void test_where_with_list_int(){
        //Arrange
        List<Integer> numbers = Arrays.asList(4,2,1,5,2,9);
        Linq<Integer> linq = Linq.of(numbers);
        //Act
        List<Integer> result = linq.Where(x -> x == 2);
        //Assert
        int expected = 2;
        Assert.assertEquals(expected,result.size());

    }

    @Test
    public void test_where_with_list_Student(){
        //Arrange
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Vu", "Duc Huy"));
        students.add(new Student(2,"Nguyen", "Minh Duc"));
        students.add(new Student(3,"Tran", "Thanh Man"));
        students.add( new Student(4,"Le", "Thuan Thien"));
        students.add(new Student(5,"Pham", "Quoc Khanh"));
        Linq<Student> linq = Linq.of(students);
        //Act
        List<Student> result = linq.Where(s -> s.getId() == 2);
        //Assert
        int expected = 1;
        Assert.assertEquals(expected,result.size());
        Assert.assertEquals(students.get(1), result.get(0));

    }
}
