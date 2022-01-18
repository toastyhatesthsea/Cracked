package StacksAndQueues;

public class AnimalQueue<T extends Comparable<T>> extends Queue<T>
{


    public T dequeueAny()
    {
        if (head == null)
        {
            return null;
        } else
        {
            T someAnimal = head.data;
            size--;
            head = head.next;
            return someAnimal;
        }
    }

    public T dequeueCat()
    {
        if (head == null)
        {
            return null;
        } else if (head == tail)
        {
            T someData = head.data;

            if (someData instanceof Cat)
            {
                return someData;
            } else
            {
                return null;
            }
        } else
        {
            Node<T> current = head;

            while (current != null)
            {
                T someData = current.data;

                if (someData instanceof Cat)
                {
                    return someData;
                }
                current = current.next;
            }
            return null;
        }
    }

}


class Dog implements Comparable
{

    @Override
    public int compareTo(Object o)
    {
        return 0;
    }
}

class Cat implements Comparable
{

    @Override
    public int compareTo(Object o)
    {
        return 0;
    }
}

class AnimalQueueTester
{
    public static void main(String[] asdlkasldkasd)
    {
        AnimalQueue someQueue = new AnimalQueue();

        someQueue.enQueue(99);
        someQueue.enQueue(7);
        someQueue.enQueue(10);
        Cat someCat = new Cat();

        someQueue.enQueue(someCat);

        someQueue.enQueue("WhAT WHAT");
        Cat aCatReturned = (Cat)someQueue.dequeueCat();
    }
}