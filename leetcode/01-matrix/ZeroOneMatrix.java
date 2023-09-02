import java.util.ArrayList;
import java.util.stream.Collectors;

public class ZeroOneMatrix {
    public static void main(String[] args) {
        ArrayList<char[]> ls = new ArrayList<>();

        ls.stream().map(String::new).collect(Collectors.toList());
    }
}
