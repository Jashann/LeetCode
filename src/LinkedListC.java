public class LinkedListC {
    // Linked List - Problem 1
//    public ListNode reverseList(ListNode head) {
//
//        ListNode iterator    = head;
//        ListNode prevNode    = null;
//        ListNode currentNode = null;
//
//        while ( iterator != null ) {
//            prevNode    = currentNode;
//            currentNode = iterator;
//            // This is important. Else otherwise currentNode.next will make the program lose the pointer
//            iterator    = iterator.next;
//            currentNode.next = prevNode;
//        }
//        return currentNode;
//    }

    // Linked List - Problem 2 (Neetcode's solution)
//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        final ListNode root = new ListNode();
//        ListNode prev = root;
//        while (list1 != null && list2 != null) {
//            if (list1.val < list2.val) {
//                prev.next = list1;
//                list1 = list1.next;
//            } else {
//                prev.next = list2;
//                list2 = list2.next;
//            }
//            prev = prev.next;
//        }
//        prev.next = list1 != null ? list1 : list2;
//        return root.next;
//    }
}
