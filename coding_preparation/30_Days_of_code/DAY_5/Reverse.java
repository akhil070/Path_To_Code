class Reverse extends Template{

    public Node reverseNodes(Node head){
        // Iterrative code
        Node curr = head , next = null ,prev = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    public static void main(String[] args){
        Reverse r = new Reverse();
        for(int i=1;i<5;i++)
            r.insert(i);
        Node head = r.copynodes();
        r.head = r.reverseNodes(head);
        r.printelements();
    }
}