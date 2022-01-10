package StacksAndQueues;

public class QueueWithStacks<T extends Comparable<T>>
{
    Stack<T> traditionalStack;
    Stack<T> queueStack;
    int size;

    public QueueWithStacks()
    {
        traditionalStack = new Stack<>();
        queueStack = new Stack<>();
    }

    public void enQueue(T data)
    {
        traditionalStack.push(data);
        size++;
    }

    public T deQueue()
    {
        if (queueStack.isEmpty())
        {
            while (!traditionalStack.isEmpty())
            {
                T someData = traditionalStack.pop();
                queueStack.push(someData);
            }
        }
        return queueStack.pop();
    }

}

class QueueWithStackTesters
{
    public static void main(String[] poiasdiasd)
    {
        QueueWithStacks meowStackOne = new QueueWithStacks();

        meowStackOne.enQueue(1);
        meowStackOne.enQueue(4);
        meowStackOne.enQueue(2);
        meowStackOne.enQueue(0);

        Object someThing = meowStackOne.deQueue();

        meowStackOne.enQueue(99);

        someThing = meowStackOne.deQueue();
    }
}
