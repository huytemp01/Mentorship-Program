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
        List list = new ArrayList<>();
        list.add(0);
        list.add("two");
        list.add("three");
        list.add(new Student(1,"Vu","Duc Huy"));
        Linq linq = Linq.of(list);

        List<String> result = linq.ofType(String.class);

        String[] expected = new String[]{"two","three"};
        Assert.assertArrayEquals(expected,result.toArray() );
    }
}
