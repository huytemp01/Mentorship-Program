import org.example.Linq;
import org.example.Student;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OfTypeTest {
    @Test
    public void test_filter_elements_of_string(){
        //Arrange
        List list = new ArrayList<>();
        list.add(0);
        list.add("two");
        list.add("three");
        list.add(new Student(1,"Vu","Duc Huy"));
        Linq linq = Linq.of(list);
        //Act
        List<String> result = linq.ofType(String.class).toList();

        //Assert
        String[] expected = new String[]{"two","three"};
        Assert.assertArrayEquals(expected,result.toArray() );
    }

    @Test
    public void test_filter_elements_of_Student(){
        //Arange
        List list = new ArrayList<>();
        list.add(0);
        list.add("two");
        list.add("three");
        Student huy = new Student(1,"Vu","Duc Huy");
        list.add(huy);
        Linq linq = Linq.of(list);
        //Act
        List<Student> result = linq.ofType(Student.class).toList();
        //Assert
        Assert.assertEquals(huy, result.get(0));
    }

    @Test
    public void test_filter_elements_of_number(){
        //Arange
        List list = new ArrayList<>();
        list.add(0);
        list.add("two");
        list.add("three");
        list.add(12);
        list.add(2.5);
        Student huy = new Student(1,"Vu","Duc Huy");
        list.add(huy);
        Linq linq = Linq.of(list);
        //Act
        List<Number> result = linq.ofType(Number.class).toList();
        //Assert
        Assert.assertTrue(result.containsAll(Arrays.asList(0, 12,2.5)));
    }

    @Test
    public void test_filter_elements_of_double(){
        //Arange
        List list = new ArrayList<>();
        list.add(0);
        list.add("two");
        list.add("three");
        list.add(12);
        list.add(2.5);
        Student huy = new Student(1,"Vu","Duc Huy");
        list.add(huy);
        Linq linq = Linq.of(list);
        //Act
        List<Double> result = linq.ofType(Double.class).toList();
        //Assert
        Assert.assertTrue(result.containsAll(Arrays.asList(2.5)));
    }

    @Test
    public void test_filter_elements_of_null(){
        //Arange
        List list = new ArrayList<>();
        list.add(0);
        list.add("two");
        list.add(null);
        list.add("three");
        list.add(12);
        list.add(null);
        list.add(2.5);
        Student huy = new Student(1,"Vu","Duc Huy");
        list.add(huy);
        Linq linq = Linq.of(list);
        //Act
        List<?> result = linq.ofType(null).toList();
        //Assert
        Assert.assertTrue(result.containsAll(Arrays.asList(null, null)));
    }

    @Test
    public void test_filter_arrays_from_list(){
        //Arange
        List list = new ArrayList<>();
        list.add(0);
        list.add("two");
        list.add(null);
        list.add("three");
        int[] ints = new int[]{1,5,2};
        list.add(ints);
        Student huy = new Student(1,"Vu","Duc Huy");
        list.add(huy);
        double[] doubles = new double[]{3.5,6.4,2.1};
        list.add(doubles);
        Linq linq = Linq.of(list);
        //Act
        List<int[]> result = linq.ofType(int[].class).toList();
        //Assert
        Assert.assertTrue(result.containsAll(Arrays.asList(ints)));

    }

}
