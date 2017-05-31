import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class Test {

     int num1 = num2 +2;
    static int num2 = 20;
    
    private static Pattern VARIABLE_PATTERN = Pattern.compile(
            "\\$\\s*\\{?\\s*([\\._0-9a-zA-Z]+)\\s*\\}?");

    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList();  
        list.add("1");  
        list.add("2");  
        list.add("3");  
        list.add("4");  
        list.add("5");  
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String temp = it.next();
            if ("2".equals(temp)) {
                it.remove();
            }
        }
        
        System.out.println(list.size());  
    }
}
