public class Template {
    Node head;
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }
    void insert(int data){
        Node new_node=new Node(data);
        if (head==null) head=new_node;
        else{
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=new_node;
        }
    }
    void printelements(Node head){
        Node temp=head;
        while(temp!=null){
            if (temp.next==null) System.out.print(temp.data);
            else System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println();
    }
    void printelements(){
        Node temp=head;
        while(temp!=null){
            if (temp.next==null) System.out.print(temp.data);
            else System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println();
    }
    public int size(){
        Node temp=head; int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }
    public Node copynodes(){
        return head;
    }
    public void empty_list(){
        head=null;
    }
    public void setHead(Node list){
        head=list;
    }
}