package LinkedList;

public class Node<T>
{
    Node next;
    T someData;

    public Node(Node nextNode, T data)
    {
        next = nextNode;
        someData = data;
    }
}
