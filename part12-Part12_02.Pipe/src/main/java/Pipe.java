
import java.util.ArrayList;

public class Pipe<T> {

    ArrayList<T> pipe;

    public Pipe() {
        this.pipe = new ArrayList();
    }

    public int size() {
        return this.pipe.size();
    }

    public void putIntoPipe(T value) {
        pipe.add(value);
    }

    public T takeFromPipe() {
        if(this.pipe.isEmpty()){
            return null;
        }
        T taken = this.pipe.get(0);
        this.pipe.remove(0);
        return taken;
    }

    public boolean isInPipe() {
        if(pipe.isEmpty()){
            return false;
        } return true;
    }
}
