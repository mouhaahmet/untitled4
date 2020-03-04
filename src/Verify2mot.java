import java.util.ArrayList;
import java.util.Collections;

public class Verify2mot {
    public static void verify2mot(String word,ArrayList<ArrayList<Character>> listtab,ArrayList<String> newdico)
    {
        ArrayList<Character> arrayword = new ArrayList<Character>();
        for(int i=0 ; i<word.length() ; i++)
        {
            arrayword.add(word.charAt(i));
        }
        Collections.sort(arrayword);
        for (int i = 0 ; i < listtab.size() ; i++)
        {
            ArrayList<Character> newarrayword = (ArrayList<Character>) arrayword.clone();
            if (newarrayword.containsAll(listtab.get(i)))
            {
               Verify2mot.delete(newarrayword,listtab.get(i));
               for (int j = i+1 ; j < listtab.size() ; j++)
               {
                   if (newarrayword.containsAll(listtab.get(j)))
                   {
                       Verify2mot.delete(newarrayword,listtab.get(j));
                       if (newarrayword.size()==0)
                       {
                           System.out.println(word+"est un deux mot de "+newdico.get(i)+" et de "+newdico.get(j));
                       }

                   }
               }
            }
        }


    }
    public static ArrayList<Character> delete( ArrayList<Character> mere , ArrayList<Character> fils)
    {
        if (mere.containsAll(fils))
        {
            for (int k=0;k<fils.size();k++)
            {
                Character local = fils.get(k);
                mere.remove(local);
            }
        }
        return mere;
    }
}
