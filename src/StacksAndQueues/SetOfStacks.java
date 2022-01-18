package StacksAndQueues;

public class SetOfStacks<T extends Comparable<T>>
{
    Stack<T> stackOne;
    Stack<T> stackTwo;
    int size;


    public void push(T someData)
    {
        if (size < 3)
        {
            stackOne.push(someData);
        } else
        {
            stackTwo.push(someData);
        }
        size++;
    }


    public T pop()
    {
        size--;
        if (size < 3)
        {
            return stackOne.pop();
        } else
        {
            return stackTwo.pop();
        }
    }

    public SetOfStacks()
    {
        stackOne = new Stack<>();
        stackTwo = new Stack<>();
    }
}

class SetOfStacksTesters
{
    public static void main(String[] popadspoasdsa)
    {
        SetOfStacks meowStackOne = new SetOfStacks();

        meowStackOne.push(1);
        meowStackOne.push(4);
        meowStackOne.push(2);
        meowStackOne.push(0);
        meowStackOne.push(10);
        meowStackOne.pop();
        meowStackOne.pop();
        meowStackOne.pop();

        meowStackOne.push(99);

    }
}