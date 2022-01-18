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

    public void deleteMiddle()
    {
        int middle = this.size / 2;
        Node current = head;

        for (int i = 1; i < middle; i++)
        {
            current = current.next;
        }
        current.next = current.next.next;
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

    public static boolean isPalindrone(LinkedList<Character> aList)
    {
        LinkedList<Character> reverseList = new LinkedList<Character>();

        Node current = aList.head;

        while (current != null)
        {
            Character aChar = (Character) current.someData;
            reverseList.add(aChar);
            current = current.next;
        }

        Node currentNodeForAList = aList.head;
        Node currentNodeForReverseList = reverseList.head;

        while (currentNodeForAList != null)
        {
            char aListChar = (char)currentNodeForAList.someData;
            char reverseListChar = (char) currentNodeForReverseList.someData;

            if (aListChar != reverseListChar)
            {
                return false;
            }
        }

        return true;
    }

    public static boolean intersection(LinkedList listOne, LinkedList listTwo)
    {
        Node currentNodeForListOne = listOne.head;
        Node currentNodeForListTwo = listTwo.head;

        HashMap<Node, Integer> aCollectionOfNodes = new HashMap<>();

        while (currentNodeForListOne != null)
        {
            if (aCollectionOfNodes.putIfAbsent(currentNodeForListOne, 1) != null)
            {
                return true;
            }
            currentNodeForListOne = currentNodeForListOne.next;
        }

        while (currentNodeForListTwo != null)
        {
            if (aCollectionOfNodes.putIfAbsent(currentNodeForListTwo, 1) != null)
            {
                return true;
            }
            currentNodeForListTwo = currentNodeForListTwo.next;
        }
        return false;
    }

    public static LinkedList addLinkedListsOfNumbers(LinkedList listOne, LinkedList listTwo)
    {
        int intOne = 0;
        int intTwo = 0;

        Node current = listOne.head;

        while (current != null)
        {
            int One = intOne * 10 + (int) current.someData;
            current = current.next;
        }

        current = listTwo.head;

        while (current != null)
        {
            intTwo = intTwo * 10 + (int) current.someData;
            current = current.next;
        }

        int total = intOne + intTwo;

        LinkedList<Integer> someTotal = new LinkedList<Integer>();

        while (total >= 10)
        {
            int digit = total % 10;
            someTotal.add(digit);
            total = total / 10;
        }
        someTotal.add(total);

        return someTotal;
    }
}

class ListTesters<T>
{
    public static void main(String[] asldkasldkasd)
    {
        LinkedList listOne = new LinkedList();
        LinkedList listTwo = new LinkedList();
        int meow = 5;
        int rawrs = 6;

        listOne.add(meow);
        listOne.add(rawrs);
        listOne.add(8);
        listOne.add(5);
        //5865

        listTwo.add(5);
        listTwo.add(8);
        listTwo.add(9);
        listTwo.add(9);
        listTwo.add(3);
        listTwo.add(rawrs);
        //39981

        //someList.removeDuplicates();
        //Object someObject = someList.findElementFromLast(2);
        //listOne.deleteMiddle();
        //LinkedList total = LinkedList.addLinkedListsOfNumbers(listOne, listTwo);
        boolean intersectionAnswer = LinkedList.intersection(listOne, listTwo);
    }
}
