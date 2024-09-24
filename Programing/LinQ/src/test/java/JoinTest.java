import org.example.Deparment;
import org.example.Linq;
import org.example.Student;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JoinTest {
    @Test(expected = NullPointerException.class)
    public void Test_InnerJoin_department_Students(){
        //Arrange
        List<Deparment> deparments = new ArrayList<>();
        Deparment cntt = new Deparment(1,"CNTT");
        deparments.add(cntt);
        Deparment coKhi = new Deparment(2,"Co Khi");
        deparments.add(coKhi);
        Deparment ngoaiNgu = new Deparment(3,"Ngoai Ngu");
        deparments.add(ngoaiNgu);
        Deparment kinhTe = new Deparment(4,"Kinh Te");
        deparments.add(kinhTe);
        Deparment logistic = new Deparment(5,"Logistic");
        deparments.add(logistic);
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Vu","Duc Huy", cntt));
        students.add(new Student(2,"Trinh","Ngoc Dung", kinhTe));
        students.add(new Student(3,"Nguyen","Thi Bich", ngoaiNgu));
        students.add(new Student(4,"Pham","Quoc Thien", coKhi));
        students.add(new Student(5,"Tran","Dinh Thang", cntt));
        students.add(new Student(6,"Vu","Ngoc Dan", cntt));

        //Act
        Map<Deparment, List<Student>> result = Linq.innerJoin(deparments,students).on((left, right) -> left.getId() == right.getDeparment().getId());
        //Assert
        Assert.assertEquals(3, result.get(cntt).size());
        Assert.assertEquals(1, result.get(kinhTe).size());
        Assert.assertEquals(1, result.get(coKhi).size());
        Assert.assertEquals(1, result.get(ngoaiNgu).size());
        Assert.assertEquals(0, result.get(logistic).size());
    }

    @Test
    public void Test_leftJoin_department_Students(){
        //Arrange
        List<Deparment> deparments = new ArrayList<>();
        Deparment cntt = new Deparment(1,"CNTT");
        deparments.add(cntt);
        Deparment coKhi = new Deparment(2,"Co Khi");
        deparments.add(coKhi);
        Deparment ngoaiNgu = new Deparment(3,"Ngoai Ngu");
        deparments.add(ngoaiNgu);
        Deparment kinhTe = new Deparment(4,"Kinh Te");
        deparments.add(kinhTe);
        Deparment logistic = new Deparment(5,"Logistic");
        deparments.add(logistic);
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Vu","Duc Huy", cntt));
        students.add(new Student(2,"Trinh","Ngoc Dung", kinhTe));
        students.add(new Student(3,"Nguyen","Thi Bich", ngoaiNgu));
        students.add(new Student(4,"Pham","Quoc Thien", coKhi));
        students.add(new Student(5,"Tran","Dinh Thang", cntt));
        students.add(new Student(6,"Vu","Ngoc Dan", cntt));

        //Act
        Map<Deparment, List<Student>> result = Linq.leftJoin(deparments,students).on((left, right) -> left.getId() == right.getDeparment().getId());
        //Assert
        Assert.assertEquals(3, result.get(cntt).size());
        Assert.assertEquals(1, result.get(kinhTe).size());
        Assert.assertEquals(1, result.get(coKhi).size());
        Assert.assertEquals(1, result.get(ngoaiNgu).size());
        Assert.assertEquals(0, result.get(logistic).size());
    }
}
