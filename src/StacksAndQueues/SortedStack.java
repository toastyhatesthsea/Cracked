package StacksAndQueues;

/**
 * Stack is sorted with minimum at top
 */
public class SortedStack<T extends Comparable<T>>
{
    Node<T> head;
    Node<T> tail;
    Node<T> minimum;
    int size;

    public SortedStack()
    {
        head = null;
        tail = null;
        minimum = null;
    }

    public void push(T data)
    {
        if (head == null)
        {
            head = new Node<>(null, data);
            tail = head;
        }
        else
        {

        }
        size++;
    }

}
