
public class Book implements Packable {

    private String name;
    private String author;
    private double weight;
    
    public Book(String name, String author, double weight){
        this.author = author;
        this.name = name;
        this.weight = weight;
    }

    @Override
    public double weight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return name + ": " + author;
    }

}
