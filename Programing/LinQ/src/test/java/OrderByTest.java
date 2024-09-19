import org.example.Linq;
import org.example.Student;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class OrderByTest {
    @Test
    public void test_OrderBY_should_return_in_ascending_id_order(){
        //Arrange
        List<Student> students = new ArrayList<>();
        students.add(new Student(3,"Tran", "Thanh Man"));
        students.add(new Student(5,"Pham", "Quoc Khanh"));
        students.add(new Student(2,"Nguyen", "Minh Duc"));
        students.add(new Student(4,"Le", "Thuan Thien"));
        students.add(new Student(1,"Vu", "Duc Huy"));
        //Act
        List<Student> result = Linq.from(students).orderBy(Student::getId).toList();
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
        //Act
        List<Student> result = Linq.from(students).orderByDescending(Student::getId).toList();
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
        //Act
        List<Student> result = Linq.from(students).orderBy(Student::getFirstName).toList();
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
        //Act
        List<Student> result = Linq.from(students).orderByDescending(Student::getFirstName).toList();
        //Assert
        Assert.assertEquals("Vu",result.get(0).getFirstName());
        Assert.assertEquals("Le",result.get(result.size()-1).getFirstName() );
    }


    @Test
    public void test_Where_on_id_less_than_4_then_Order_by_id(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(3,"Tran", "Thanh Man"));
        students.add(new Student(5,"Pham", "Quoc Khanh"));
        students.add(new Student(2,"Nguyen", "Minh Duc"));
        students.add(new Student(4,"Le", "Thuan Thien"));
        students.add(new Student(1,"Vu", "Duc Huy"));
        //Act
        List<Student> result = Linq.from(students).Where(student -> student.getId()<4).orderBy(Student::getId).toList();
        //Assert
        Assert.assertEquals("Vu",result.get(0).getFirstName());
        Assert.assertEquals("Tran",result.get(result.size()-1).getFirstName() );
    }

    @Test
    public void test_Where_on_id_less_than_4_then_Order_by_firstname(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(3,"Tran", "Thanh Man"));
        students.add(new Student(5,"Pham", "Quoc Khanh"));
        students.add(new Student(2,"Nguyen", "Minh Duc"));
        students.add(new Student(4,"Le", "Thuan Thien"));
        students.add(new Student(1,"Vu", "Duc Huy"));
        //Act
        List<Student> result = Linq.from(students).Where(student -> student.getId()<4).orderBy(Student::getFirstName).toList();
        //Assert
        Assert.assertEquals("Nguyen", result.get(0).getFirstName());
        Assert.assertEquals("Vu", result.get(result.size()-1).getFirstName());
    }
}
