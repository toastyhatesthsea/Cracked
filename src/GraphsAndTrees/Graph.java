package GraphsAndTrees;

public class Graph<T> implements Cloneable
{

    public boolean[][] edges;
    public T[] labels;

    public Graph(int size)
    {
        edges = new boolean[size][size];
        labels = (T[]) new Object[size];
    }

    public void addEdge(int source, int target)
    {
        edges[source][target] = true;
    }

    public T getLabel(int vertex)
    {
        return labels[vertex];
    }

    public boolean isEdge(int source, int target)
    {
        return edges[source][target];
    }

    public int[] neighbors(int vertex)
    {
        int count = 0;
        for (int i = 0; i < labels.length; i++)
        {
            if (edges[vertex][i])
            {
                count++;
            }
        }

        int[] answer = new int[count];

        count = 0;
        for (int i = 0; i < labels.length; i++)
        {
            if (edges[vertex][i])
            {
                count++;
                answer[count] = i;
            }
        }
        return answer;
    }

    private boolean[] arrayOfNeighbors(int vertex)
    {
        boolean[] tempers = new boolean[edges[vertex].length];

        for (int i = 0; i < edges[vertex].length; i++)
        {
            tempers[i] = edges[vertex][i];
        }

        return tempers;
    }

    /**
     * Swaps the Edges of the two vertices
     *
     * @param vertexOne int
     * @param vertexTwo int
     */
    public void interchange(int vertexOne, int vertexTwo)
    {
        boolean[] vertexOneConnections = arrayOfNeighbors(vertexOne);
        boolean[] vertexTwoConnections = arrayOfNeighbors(vertexTwo);

        for (int i = 0; i < vertexOneConnections.length; i++)
        {
            this.edges[vertexTwo][i] = vertexOneConnections[i];
            this.edges[vertexOne][i] = vertexTwoConnections[i];
        }
    }

    public void deleteVertices(int amount)
    {
        int newSize = labels.length - amount;
        T[] newLabels = (T[]) new Object[newSize];
        boolean[][] newEdges = new boolean[newSize][newSize];

        for (int i = 0; i < newLabels.length; i++)
        {
            newLabels[i] = labels[i];
            for (int j = 0; j < newEdges[i].length; j++)
            {
                newEdges[i][j] = edges[i][j];
            }
        }
        this.edges = newEdges;
        this.labels = newLabels;
    }

    public void addVertices(int amount)
    {
        int newSize = labels.length + amount;
        T[] newLabels = (T[]) new Object[newSize];
        boolean[][] newEdges = new boolean[newSize][newSize];

        for (int i = 0; i < labels.length; i++)
        {
            newLabels[i] = labels[i];
            for (int j = 0; j < edges[i].length; j++)
            {
                newEdges[i][j] = edges[i][j];
            }
        }
        this.labels = newLabels;
        this.edges = newEdges;
    }
}

class GraphTesters
{
    public static void main(String[] asdkjaskdjasd)
    {
        Graph someGraph = new Graph(5);
        someGraph.addEdge(1, 1);
        someGraph.addEdge(1, 2);
        someGraph.addEdge(0, 3);
        someGraph.interchange(1, 0);
    }
}
