package StacksAndQueues;

public class Stack<T extends Comparable<T>>
{
    Node<T> head;
    Node<T> tail;
    Node<T> minimum;
    int size;
    T previousMinimum;

    public void push(T someData)
    {
        if (head == null)
        {
            head = new Node<T>(null, someData);
            tail = head;
            minimum = head;
        } else
        {
            Node<T> newHead = new Node<T>(null, someData);
            Node<T> oldHead = head;
            head = newHead;
            head.next = oldHead;

            if (someData.compareTo(minimum.data) <= 0)
            {
                Node<T> newHeadMinimum = new Node<>(null, someData);
                Node<T> oldMinimumHead = minimum;
                minimum = newHeadMinimum;
                minimum.next = oldMinimumHead;
            }
        }
        size++;
    }

    /**
     * Pops the element off the Stack
     *
     * @return T
     */
    public T pop()
    {

        if (minimum != null && minimum.data.equals(head.data))
        {
            minimum = minimum.next;
        }
        if (head != null)
        {
            T poppedData = head.data;
            head = head.next;
            size--;
            return poppedData;
        }

        return null;
    }

    /**
     * Gets minimum element in the list
     *
     * @return T
     */
    public T minimum()
    {
        return minimum.data;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }
}

class Node<T>
{
    Node<T> next;
    T data;

    public Node(Node<T> aNode, T someData)
    {
        this.next = aNode;
        this.data = someData;
    }
}

class StackTesters
{
    public static void main(String[] sdflksdlfkds)
    {
        Stack meowStackOne = new Stack();

        meowStackOne.push(1);
        meowStackOne.push(4);
        meowStackOne.push(2);
        meowStackOne.push(0);
        meowStackOne.pop();

    }
}