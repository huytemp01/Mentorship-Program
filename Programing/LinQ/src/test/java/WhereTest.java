import org.example.Linq;
import org.example.Student;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

public class WhereTest {

    @Test
    public void test_where_should_return_elements(){
        //Arrange
        List<Integer> numbers = Arrays.asList(4,2,1,5,2,9);
        Linq<Integer> linq = Linq.of(numbers);
        //Act
//        List<Integer> result = linq.Where(x -> x ==2).toList();
        List<Integer> result = Linq.of(numbers).Where(x -> x ==2).toList();
        //Assert
        int expected = 2;
        Assert.assertEquals(expected,result.size());

    }

    @Test
    public void test_where_should_return_student_with_id_2(){
        //Arrange
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Vu", "Duc Huy"));
        students.add(new Student(2,"Nguyen", "Minh Duc"));
        students.add(new Student(3,"Tran", "Thanh Man"));
        students.add(new Student(4,"Le", "Thuan Thien"));
        students.add(new Student(5,"Pham", "Quoc Khanh"));
        Linq<Student> linq = Linq.of(students);
        //Act
        List<Student> result = linq.Where(s -> s.getId() == 2).toList();
        //Assert
        int expected = 1;
        Assert.assertEquals(expected,result.size());
        Assert.assertEquals(students.get(1), result.get(0));
    }




}
