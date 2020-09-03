public class Delete_Node extends Template{
    public void deleteNode(Node head){
        if(head.next==null)
            head = null;
        else {
            head.data = head.next.data;
            head.next = head.next.next;
        }
        printelements();
    }
    public static void main(String[] args) {
        Delete_Node DN  =  new Delete_Node();
        for(int i=1;i<=5;i++){
            DN.insert(i);
        }
        DN.deleteNode(DN.head.next.next);
    }
}
