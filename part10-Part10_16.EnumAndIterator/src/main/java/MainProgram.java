
public class MainProgram {

    public static void main(String[] args) {
        Employees t = new Employees();
        Person h = new Person("Arto", Education.PHD);
        t.add(h);
        h = new Person("Pekka", Education.BA);
        t.add(h);
        h = new Person("Matti", Education.PHD);
        t.add(h);
        t.fire(Education.PHD);
        t.print();
    }
}
