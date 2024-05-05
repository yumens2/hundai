
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Application{
   
    public boolean containsDuplicate(List<Integer> digits) {
        return digits.stream().distinct().count() != digits.size();
    }


}
