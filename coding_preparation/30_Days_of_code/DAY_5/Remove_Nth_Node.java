public class Remove_Nth_Node extends Template{
    public void RemoveNode(Node head,int n){
        Node ref_ptr = head ,main_ptr =head;
        Node dummy = null;
        int cnt = 0;
        if(head!=null) {
            while (cnt < n) {
                if (ref_ptr == null) {
                    return;
                }
                ref_ptr = ref_ptr.next;
                cnt++;
            }
        }
        if(ref_ptr == null){
            main_ptr = main_ptr.next;
            printelements(main_ptr);
            return;
        }
        while(ref_ptr.next!=null){
            main_ptr = main_ptr.next;
            ref_ptr = ref_ptr.next;
        }
        main_ptr.next = main_ptr.next.next;
        printelements();
    }
//    Removes nth node from the back
    public static void main(String[] args) {
        Remove_Nth_Node RN = new Remove_Nth_Node();
        for(int i=1;i<=10;i++){
            RN.insert(i);
        }
        RN.RemoveNode(RN.head,100);
    }
}
