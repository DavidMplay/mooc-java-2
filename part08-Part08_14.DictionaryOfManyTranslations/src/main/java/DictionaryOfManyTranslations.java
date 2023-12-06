
import java.util.HashMap;
import java.util.ArrayList;

public class DictionaryOfManyTranslations {

    private HashMap<String, ArrayList<String>> list;

    public DictionaryOfManyTranslations() {
        list = new HashMap();
    }

    public void add(String word, String translation) {
        this.list.putIfAbsent(word, new ArrayList<>());

        this.list.get(word).add(translation);
    }

    public ArrayList<String> translate(String word) {
        if(this.list.get(word)==null){
            ArrayList<String> empty = new ArrayList();
            return empty;
        }
                return this.list.get(word);
    }
    public void remove(String word){
        this.list.remove(word);
    }
}
