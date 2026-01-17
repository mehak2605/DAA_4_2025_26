// User function Template for Java
package Session7;
import java.util.*;
public class huffman{
    public void preOrder(Node root, ArrayList<String> ans, String curr)
    {
        if(root==null)
        return;
        if(root.left==null&&root.right==null)
        {
            ans.add(curr);
            return;
        }
        preOrder(root.left, ans, curr+'0');
        preOrder(root.right, ans, curr+'1');
    }
    public ArrayList<String> huffmanCodes(String S, int f[], int N) {
        // Code here
        int n=S.length();
        PriorityQueue <Node> pq=new PriorityQueue<>(Node::compareNodes);
        for(int i=0; i<n; i++)
        {
            Node tmp=new Node(f[i]);
            pq.add(tmp);
        }
        
        while(pq.size()>=2)
        {
            Node l=pq.poll();
            Node r=pq.poll();
            
            Node newNode=new Node(l.data+r.data);
            newNode.left=l;
            newNode.right=r;
            
            pq.add(newNode);
        }
        
        Node root=pq.poll();
        ArrayList<String> ans=new ArrayList<>();
        preOrder(root, ans, "");
        return ans;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter string: ");
        String s=sc.next();
        int f[]=new int[s.length()];
        System.out.println("Enter the frequency: ");
        for(int i=0; i<s.length(); i++)
            f[i]=sc.nextInt();

        huffman obj=new huffman();
        ArrayList <String> ans=obj.huffmanCodes(s, f, s.length());
        System.out.println("HUffman coding:");
        for(String str:ans)
            System.out.print(str);

        sc.close();
    }
}