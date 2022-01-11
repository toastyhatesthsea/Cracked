package StacksAndQueues;

public class Queue<T extends Comparable<T>>
{
    Node<T> tail;
    Node<T> head;
    int size;


    public Queue()
    {
        tail = null;
        head = null;
        size = 0;
    }


    public void enQueue(T someData)
    {
        if (tail == null)
        {
            tail = new Node<>(null, someData);
            head = tail;
        } else
        {
            Node<T> newTail = new Node<>(null, someData);
            tail.next = newTail;
            tail = newTail;
        }
        size++;
    }

    public T deQueue()
    {
        if (head == null)
        {
            return null;
        } else
        {
            T dataToReturn = head.data;
            head = head.next;
            size--;
            return dataToReturn;
        }
    }

}

class QueueTesters
{
    public static void main(String[] kasldklaskd)
    {
        Queue someQueue = new Queue();
        someQueue.enQueue(99);
        someQueue.enQueue(7);
        someQueue.enQueue(10);

        Object someData = someQueue.deQueue();
    }
}
