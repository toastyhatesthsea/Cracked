package Strings;

import java.util.HashMap;
import java.util.Map;

public class OneAway
{

    /**
     * Checks if both strings are 'one-away' from being equal. Can only replace, remove or add one character
     *
     * @param firstString  String
     * @param secondString String
     * @return boolean
     */
    public static boolean checkIfOneAway(String firstString, String secondString)
    {
        int firstStringLength = firstString.length();
        int secondStringLength = secondString.length();

        int stringLengthDifference = firstStringLength - secondStringLength;
        if (stringLengthDifference < 0)
        {
            stringLengthDifference = stringLengthDifference * -1;
        }

        if (stringLengthDifference > 1)
        {
            return false;
        }

        firstString = firstString.toLowerCase();
        secondString = secondString.toLowerCase();

        HashMap<Character, Integer> firstStringHashMap = new HashMap<>();
        HashMap<Character, Integer> secondStringHashMap = new HashMap<>();

        for (int i = 0; i < firstString.length(); i++)
        {
            char aChar = firstString.charAt(i);

            Integer aValue = firstStringHashMap.putIfAbsent(aChar, 1);

            if (aValue != null)
            {
                firstStringHashMap.put(aChar, 1 + aValue);
            }
        }

        for (int i = 0; i < secondString.length(); i++)
        {
            char aChar = secondString.charAt(i);

            Integer aValue = secondStringHashMap.putIfAbsent(aChar, 1);

            if (aValue != null)
            {
                secondStringHashMap.put(aChar, 1 + aValue);
            }
        }

        int totalDifferences = 0;
        for (Map.Entry<Character, Integer> anEntry : firstStringHashMap.entrySet())
        {
            Integer aValueFromSecondStringHashMap = secondStringHashMap.get(anEntry.getKey());

            if (aValueFromSecondStringHashMap == null || !aValueFromSecondStringHashMap.equals(anEntry.getValue()))
            {
                totalDifferences++;
            }
            if (totalDifferences > 1)
            {
                return false;
            }
        }
        return true;
    }

}

class OneAwayTesters
{
    public static void main(String[] sdfsdfkljsdklfjds)
    {
        boolean answer = OneAway.checkIfOneAway("bale", "bales");
    }
}
