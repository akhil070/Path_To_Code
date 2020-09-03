public class Find_Middle extends  Template{
    public void Appraoch1(Node head){
        int cnt = size();
        int mid = cnt/2;
        Node curr =head;
        while(mid-- > 0){
            curr = curr.next;
        }
        System.out.println("Middle node is: "+curr.data);
    }
    public void Approach2(Node head){
        Node slowptr = head ,fastptr = head;
        while(fastptr!=null && fastptr.next!=null){
            slowptr = slowptr.next;
            fastptr = fastptr.next.next;
        }
        System.out.println("Middle node is: "+slowptr.data);
    }
    public void findMiddle(Node head){
//        Appraoch1(head);
        Approach2(head);
    }
    public static void main(String[] args) {
        Find_Middle FM =new Find_Middle();
        for(int i=1;i<11;i++){
            FM.insert(i);
        }
        FM.findMiddle(FM.head);
    }
}
