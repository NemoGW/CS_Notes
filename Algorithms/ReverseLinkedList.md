```java
public ListNode reverseList(ListNode head){
        if(head == null){
            return head;
        }

        ListNode tail = head;
        head = head.next;

        tail.next = null;

        while(head!=null){
            ListNode temp = head.next;
            head.next = tail;
            tail = head;
            head = temp;
        }

        return tail;
    }
```
