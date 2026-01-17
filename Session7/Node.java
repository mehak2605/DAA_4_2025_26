package Session7;

public class Node{
    int data;
    Node left, right;
    Node(int x)
    {
        data=x;
        left=null;
        right=null;
    }
    public static int compareNodes(Node a, Node b)
    {
        if(a.data<b.data)
        return -1;
        return 1;
    }
}
