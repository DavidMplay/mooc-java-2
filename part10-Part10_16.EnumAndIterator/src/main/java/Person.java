
public class Person {

    private String name;
    private Education edu;
    
    public Person(String name, Education edu){
        this.name = name;
        this.edu = edu;
    }
    
    public Education getEducation(){
        return this.edu;
    }
    public String getName(){
        return this.name;
    }
    public String toString(){
        return getName() + ", " + getEducation();
    }
}
