
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class Employees {

    private List<Person> workers;

    public Employees() {
        this.workers = new ArrayList<>();
    }

    public void add(Person personToAdd) {
        workers.add(personToAdd);
    }

    public void add(List<Person> peopleToAdd) {
        this.workers.addAll(peopleToAdd);
    }

    public void print() {
        this.workers.stream().forEach(worker -> System.out.println(worker));
    }

    public void print(Education education) {
        Iterator<Person> iterator = workers.iterator();

        while (iterator.hasNext()) {
            Person next = iterator.next();
            if (next.getEducation().equals(education)) {
                System.out.println(next);
            }
        }
    }

    public void fire(Education education) {
        Iterator<Person> iterator = workers.iterator();

        while (iterator.hasNext()) {
            if (iterator.next().getEducation().equals(education)) {
                iterator.remove();
            }
        }
    }
}
