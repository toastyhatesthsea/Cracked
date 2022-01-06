package LinkedList;

import java.util.HashMap;

public class LinkedList<T>
{

    Node head, tail;
    int size;

    public LinkedList()
    {
        head = null;
        tail = null;
    }

    public void add(T someData)
    {
        if (head == null)
        {
            head = new Node(null, someData);
            tail = head;
        } else
        {
            Node<T> oldHead = head;
            head = new Node(oldHead, someData);
        }
        size++;
    }

    public T findElementFromLast(int index)
    {
        int indexToFind = this.size - index;

        Node current = head;
        int count = 1;

        while (count < indexToFind)
        {
            current = current.next;
            count++;
        }
        T someValue = (T) current.someData;
        return someValue;
    }

    public boolean removeDuplicates()
    {
        HashMap<T, Integer> collection = new HashMap<>();

        Node current = head;
        Node prev = current;
        boolean answer = false;

        while (current.next != null)
        {
            if (collection.putIfAbsent((T) current.someData, 1) != null)
            {
                int aValue = collection.get((T) current.someData);
                collection.put((T) current.someData, 1 + aValue);
                Node nextCurrent = current.next;
                prev.next = nextCurrent;
                answer = true;
                this.size--;
            }
            prev = current;
            current = current.next;
        }
        return answer;
    }
}

class ListTesters<T>
{
    public static void main(String[] asldkasldkasd)
    {
        LinkedList someList = new LinkedList();
        int meow = 5;
        int rawrs = 6;

        someList.add(meow);
        someList.add(rawrs);
        someList.add(8);
        someList.add(5);
        someList.add(10);
        someList.add(8);
        someList.add(9);
        someList.add(9);

        //someList.removeDuplicates();
        Object someObject = someList.findElementFromLast(2);
    }
}
