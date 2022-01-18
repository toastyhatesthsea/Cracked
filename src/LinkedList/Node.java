package LinkedList;

public class Node<T>
{
    Node<T> next;
    T someData;

    public Node(Node<T> nextNode, T data)
    {
        next = nextNode;
        someData = data;
    }
}
