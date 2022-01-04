package Strings;

import javax.swing.text.html.parser.Entity;
import java.util.*;

public class Permutation
{

    public static boolean isPermutation(String firstString, String secondString)
    {
        if (firstString.length() != secondString.length()) //Not a permutation if both strings are not equal
        {
            return false;
        }

        boolean answer = true;
        firstString = firstString.toLowerCase();
        secondString = secondString.toLowerCase();

        HashMap<Character, Integer> firstStringHash = new HashMap<>();
        HashMap<Character, Integer> secondStringHash = new HashMap<>();


        for (int i = 0; i < firstString.length(); i++)
        {
            char aChar = firstString.charAt(i);
            char secondChar = secondString.charAt(i);

            Integer aValue = firstStringHash.putIfAbsent(aChar, 1);

            if (aValue != null)
            {
                firstStringHash.put(aChar, aValue + 1);
            }

            aValue = secondStringHash.putIfAbsent(secondChar, 1);

            if (aValue != null)
            {
                secondStringHash.put(secondChar, aValue + 1);
            }
        }

        for (Map.Entry<Character, Integer> anEntry : firstStringHash.entrySet())
        {
            Integer firstValue = anEntry.getValue();
            Integer secondValue = secondStringHash.get(anEntry.getKey());

            if (secondValue == null || !Objects.equals(firstValue, secondValue))
            {
                return false;
            }
        }

        return answer;
    }

}

class PermutationsTester
{
    public static void main(String[] aaskjdkasd)
    {
        boolean answer = Permutation.isPermutation("thus", "that");
    }
}