package Strings;

import java.util.Arrays;

public class Unique
{
    public static boolean isUnique(String aString)
    {
        boolean answer = true;
        for (int i = 0; i < aString.length() && answer; i++)
        {
            for (int j = 0; j < aString.length() && answer; j++)
            {
                if (j != i)
                {
                    if (aString.charAt(i) == aString.charAt(j))
                    {
                        answer = false;
                    }
                }
            }
        }
        return answer;
    }

    public static boolean isUniqueFaster(String aString)
    {
        boolean answer = true;

        char[] charArrayOfString = aString.toCharArray();
        Arrays.parallelSort(charArrayOfString);

        for (int i = 0; i + 1 < charArrayOfString.length && answer; i++)
        {
            char currentCharInArray = charArrayOfString[i];
            char nextCharInArray = charArrayOfString[i + 1];

            if (currentCharInArray == nextCharInArray)
            {
                answer = false;
            }
        }
        return answer;
    }

}

class UniqueTesters
{
    public static void main(String[] asdasdasdas)
    {
        boolean answer = Unique.isUnique("whatinthebutt");
        boolean anotherAnswer = Unique.isUniqueFaster("whatinthebutt");

    }
}
