import org.example.Linq;
import org.example.Student;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

public class LinqTest {

    @Test
    public void test_where_should_return_elements(){
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
        List<Student> result = linq.Where(s -> s.getId() == 2);
        //Assert
        int expected = 1;
        Assert.assertEquals(expected,result.size());
        Assert.assertEquals(students.get(1), result.get(0));
    }

    @Test
    public void test_OrderBY_should_return_in_ascending_id_order(){
        //Arrange
        List<Student> students = new ArrayList<>();
        students.add(new Student(3,"Tran", "Thanh Man"));
        students.add(new Student(5,"Pham", "Quoc Khanh"));
        students.add(new Student(2,"Nguyen", "Minh Duc"));
        students.add(new Student(4,"Le", "Thuan Thien"));
        students.add(new Student(1,"Vu", "Duc Huy"));
        Linq<Student> linq = Linq.of(students);
        //Act
        List<Student> result = linq.orderBy(Student::getId);
        //Assert
        Assert.assertEquals(result.get(0).getId(),1);
        Assert.assertEquals(result.get(result.size()-1).getId(), 5);
    }

    @Test
    public void test_OrderBY_should_return_in_descending_id_order(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(3,"Tran", "Thanh Man"));
        students.add(new Student(5,"Pham", "Quoc Khanh"));
        students.add(new Student(2,"Nguyen", "Minh Duc"));
        students.add(new Student(4,"Le", "Thuan Thien"));
        students.add(new Student(1,"Vu", "Duc Huy"));
        Linq<Student> linq = Linq.of(students);
        //Act
        List<Student> result = linq.orderByDescending(Student::getId);
        //Assert
        Assert.assertEquals(result.get(0).getId(),5);
        Assert.assertEquals(result.get(result.size()-1).getId(), 1);
    }

    @Test
    public void test_OrderBY_should_return_in_ascending_firstname_order(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(3,"Tran", "Thanh Man"));
        students.add(new Student(5,"Pham", "Quoc Khanh"));
        students.add(new Student(2,"Nguyen", "Minh Duc"));
        students.add(new Student(4,"Le", "Thuan Thien"));
        students.add(new Student(1,"Vu", "Duc Huy"));
        Linq<Student> linq = Linq.of(students);
        //Act
        List<Student> result = linq.orderBy(Student::getFirstName);
        //Assert
        Assert.assertEquals("Le",result.get(0).getFirstName());
        Assert.assertEquals("Vu",result.get(result.size()-1).getFirstName() );
    }

    @Test
    public void test_OrderBY_should_return_in_descending_firstname_order(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(3,"Tran", "Thanh Man"));
        students.add(new Student(5,"Pham", "Quoc Khanh"));
        students.add(new Student(2,"Nguyen", "Minh Duc"));
        students.add(new Student(4,"Le", "Thuan Thien"));
        students.add(new Student(1,"Vu", "Duc Huy"));
        Linq<Student> linq = Linq.of(students);
        //Act
        List<Student> result = linq.orderByDescending(Student::getFirstName);
        //Assert
        Assert.assertEquals("Vu",result.get(0).getFirstName());
        Assert.assertEquals("Le",result.get(result.size()-1).getFirstName() );
    }


}
