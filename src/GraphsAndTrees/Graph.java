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


