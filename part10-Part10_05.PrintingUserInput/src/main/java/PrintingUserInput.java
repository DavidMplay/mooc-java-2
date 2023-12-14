
import java.util.ArrayList;
import java.util.Scanner;

public class PrintingUserInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList();

        while (true) {
            String s = scanner.nextLine();
            if (s.isEmpty()){
                break;
            }
            list.add(s);
        }
        list.stream().forEach(sentance -> System.out.println(sentance));
    }
}
