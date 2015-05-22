    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int len1=0, len2=0;
        ListNode n1, n2;
        ListNode last1=null, last2=null;
        for (n1 = headA; n1 != null; n1=n1.next) {
            last1 = n1;
            len1++;
        }

        for (n2 = headB; n2 != null; n2=n2.next) {
            last2 = n2;
            len2++;
        }

        if (last1 != last2) {
            return null;
        }
        if (len1 >= len2) {
            n1 = headA;
            for (int i=0; i < len1-len2; i++) {
                n1 = n1.next;
            }
            n2 = headB;
            while (n1 != null) {
                if (n1 == n2)
                    return n1;
                n1 = n1.next;
                n2 = n2.next;
            }
        } else {
            n2 = headB;
            for (int i=0; i < len2-len1; i++) {
                n2 = n2.next;
            }
            n1 = headA;
            while (n2 != null) {
                if (n2 == n1)
                    return n2;
                n1 = n1.next;
                n2 = n2.next;
            }
        }

        return null;
    }
