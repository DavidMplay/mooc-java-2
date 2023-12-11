
public class TripleTacoBox implements TacoBox {

    public int tacos;

    public TripleTacoBox() {
        this.tacos = 3;
    }

    @Override
    public int tacosRemaining() {
        return this.tacos;
    }

    @Override
    public void eat() {
        if (tacos > 0) {
            tacos -= 1;
        }
    }
}
