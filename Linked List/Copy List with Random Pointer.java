/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        hm=new HashMap<>();
        Node node=head;
        while(node!=null){
            hm.put(node, new Node(node.val));
            node=node.next;
        }
        node=head;
        while(node!=null){
            hm.get(node).next=hm.get(node.next);
            hm.get(node).random=hm.get(node.random);
            node=node.next;
        }
        return hm.get(head);
    }
    Map<Node,Node> hm;
}
