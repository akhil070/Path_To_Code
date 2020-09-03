public class Merge_Two_Sorted extends  Template{

    public void Approach1(Node l1,Node l2){
//        Takes O(N) time
        Node dummy = new Node(0);
        Node ptr = dummy;
        while(l1!=null && l2!=null){
            if(l1.data <= l2.data){
                ptr.next = l1;
                l1 = l1.next;
            }
            else {
                ptr.next = l2;
                l2 = l2.next;
            }
            ptr = ptr.next;
        }
        if(l1!=null)
            ptr.next = l1;
        if(l2!=null)
            ptr.next = l2;
        printelements(dummy.next);
    }
    public void mergeLists(Node l1,Node l2){
        Approach1(l1,l2);
    }
    public static void main(String[] args) {
        Merge_Two_Sorted MS = new Merge_Two_Sorted();
        for(int i=5;i<=10;i++){
            MS.insert(i);
        }
        Node l1 = MS.head;
        MS.head = null;
        for(int i=-1;i<=6;i++){
            MS.insert(i);
        }
        Node l2 = MS.head;
        MS.mergeLists(l1,l2);
    }
}
