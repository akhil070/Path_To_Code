public class Add_Numbers extends  Template{
    public Node reverse(Node head){
        Reverse r = new Reverse();
        return r.reverseNodes(head);
    }
    public void addNumbers(Node l1,Node l2){
        Node dummy = new Node(0);
        l1 = reverse(l1);
        l2 = reverse(l2);
        Node curr = dummy;
        int sum = 0;
        while(l1!=null || l2!=null) {
            sum = sum/10;
            if(l1!=null){
                sum += l1.data;
                l1 = l1.next;
            }
            if(l2!=null){
                sum += l2.data;
                l2 = l2.next;
            }
            curr.next = new Node(sum%10);
            curr = curr.next;
        }
        if(sum/10==1)
            curr.next = new Node(1);
        dummy = reverse(dummy.next);
        printelements(dummy);
    }
    public static void main(String[] args) {
        Add_Numbers AN = new Add_Numbers();
        int arr2[] = {9,9,9,2,1,5,7,9};
        int arr1[] = {9,9,9,5,3,9,0,0,0,0,0};
        for(int i=0;i<arr1.length;i++){
            AN.insert(arr1[i]);
        }
        Node l1 = AN.head;
        AN.setHead(null);
        for(int i=0;i<arr2.length;i++){
            AN.insert(arr2[i]);
        }
        Node l2 = AN.head;
        AN.setHead(null);
        AN.addNumbers(l1,l2);
    }
}
