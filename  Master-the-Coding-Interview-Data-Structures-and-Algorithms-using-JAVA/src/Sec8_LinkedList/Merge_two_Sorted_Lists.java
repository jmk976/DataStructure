package Sec8_LinkedList;


public class Merge_two_Sorted_Lists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //Approach 1: Recursion
        //Time complexity : O(n + m)
        //Space complexity : O(n + m)
        if( list1 == null ){
            return list2;
        } else if( list2 == null){
            return list1;
        } else if( list1.val < list2.val ){
            list1.next = mergeTwoLists(list1.next, list2 );
            return list1;
        } else{
            list2.next = mergeTwoLists(list1, list2.next );
            return list2;
        }

    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {

        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }

            prev = prev.next;
        }

        prev.next = (list1 == null ? list2 : list1);

        return prehead.next;
    }

    public static void main(String[] args) {
        Merge_two_Sorted_Lists mt = new Merge_two_Sorted_Lists();
        ListNode list1 = new ListNode(1, new ListNode(4, new ListNode(5, null)) );
        ListNode list2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(6, null))) );
        ListNode result = mt.mergeTwoLists2(list1, list2);
       
        while(result != null ){//다음값이 있는지 체크
        int current = result.val;
        System.out.println(current); //값 출력
        result = result.next;
        }
       
    
    }



}
    

