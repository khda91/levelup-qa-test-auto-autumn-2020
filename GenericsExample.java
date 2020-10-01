import java.util.List;
import java.util.ArrayList;

public class GenericsExample {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("mmmm");
        list.add("kiiuw");
        list.add(Long.valueOf(123L));

        System.out.print(list);
    }

}