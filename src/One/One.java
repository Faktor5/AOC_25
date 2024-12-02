import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class One {
    public static void main(String... args) throws IOException {
        var br = new BufferedReader(new FileReader("./In/1.input"));

        List<Integer> l = new ArrayList<>(), r = new ArrayList<>();

        br.lines()
        .filter(s -> !s.trim().isBlank())
        .map(s -> s.split("   ")) 
        .forEach(arr -> {l.add(Integer.parseInt(arr[0].trim())); r.add(Integer.parseInt(arr[1].trim()));});

        br.close();

        // sort l and r ascending
        l.sort(null);
        r.sort(null);

        interface distance {int getDistance(int[] p);};
        distance d = (p) -> Math.abs(p[0] - p[1]);
        
        var res = IntStream.range(0, l.size())
        .mapToObj(i -> new int[] {l.get(i), r.get(i)})
        .mapToInt(d::getDistance)
        .reduce((sl, sr) -> sl + sr);

        System.out.println(res.getAsInt());
    }
}