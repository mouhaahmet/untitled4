import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class MultiSet {
    private CharSequence mot;
    public static  HashMap<Integer,ArrayList<LinkedList<Character>>> recovery() {
        ArrayList<String> list = new ArrayList<>();
        String fileName = "/amuhome/c19027029/IdeaProjects/untitled4/src/dico.txt";
        //String fileName =
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            list = (ArrayList<String>) stream
                    .map(String::toLowerCase)
                    .sorted()
                    .distinct()
                    .limit(15)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        HashMap<Integer,ArrayList<LinkedList<Character>>> Ma = new HashMap<Integer, ArrayList<LinkedList<Character>>>();
        for (String ma : list) {
            Ma.put(toCodePoints(ma), transformation1(transformation(ma)));
        }
        return Ma;

    }
    public static LinkedList<Character> transformation(String word) {
        LinkedList<Character> arrayword1 = new LinkedList<Character>();
        for (int i = 0; i < word.length(); i++) {
            arrayword1.add(word.charAt(i));
        }
        Collections.sort(arrayword1);
        return arrayword1;
    }
    public static ArrayList<LinkedList<Character>> transformation1 (LinkedList<Character> list)
    {
        ArrayList<LinkedList<Character>> arraygeneral = new ArrayList<LinkedList<Character>>();
            arraygeneral.add((list));
        return arraygeneral;

    }
    public int hashCode() {
        return toCodePoints(this.mot);
    }

    static int toCodePoints(CharSequence letters) {
        return somme(letters.codePoints().boxed().collect(Collectors.toList()));
    }

    private static int somme(List<Integer> list) {
        int somme =0;
        for (int i = 0; i <list.size() ; i++) {
            somme = somme + list.get(i);
        }

        return (somme);
    }


}
