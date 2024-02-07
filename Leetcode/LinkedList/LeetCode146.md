# Leetcode 146. LRU Cache

## Link to the questions

[Leetcode 146. LRU Cache](https://leetcode.com/problems/lru-cache/description/)

## Question description

Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

- LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
- int get(int key) Return the value of the key if the key exists, otherwise return -1.
- void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.

The functions get and put must each run in O(1) average time complexity.

```
Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]

Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4

```

And the constrains are:

- 1 <= capacity <= 3000
- 0 <= key <= 104
- 0 <= value <= 105

## Problem solving thought process

The problem wants the **_get_** and the **_put_** function to be in **_O(1)_** time complexity. Seeing this, the first thought process was to use a **_HashMap_** for storing.

Now the questions comes down to how to achieve - when cache reaches capacity, then remove the least used key.

This can be done using a Linkedlist, when a key is **_put_** we add it to the end of the list, and when we **_get_** a key, we also move the key to the end of the list. And when capacity hits, we remove the head - which is the least used element.

For searching the element in the list, we can use the map key identifier to achieve **_O(1)_** however, getting the previous node is not going to be **_O(1)_**, so we will have to use a Doubly Linked List!

E.g.
List: head -> 1 -> 2 -> 3 -> null
Map: key 1 maps to list node 1.

## Code and Explanation

1. Creating nodes

```java
class Node{
        int key;
        int value;

        Node prev;
        Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
```

2. Create Double linked list

```java
class DoubleLinkedList {
        private Node head = new Node(-1, -1);
        private Node tail = head;

        //add to the end
        public void add(Node node){
            tail.next = node;
            node.prev = tail;
            tail = node;
        }

        public void remove(Node node){
            node.prev.next = node.next;
            if(node.next != null){
                node.next.prev = node.prev;
            } else {
                tail = node.prev;
            }

            node.prev = null;
            node.next = null;
        }

        public void moveToTail(Node node){
            remove(node);
            add(node);
        }
    }
```

3. Create the cache using map

```java
    private int capacity = 0;
    private HashMap<Integer, Node> map = new HashMap<>();
    private DoubleLinkedList list = new DoubleLinkedList();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            list.moveToTail(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            list.moveToTail(node);
        } else {
            if(map.size() == capacity){
                Node head = list.head.next;
                map.remove(head.key);
                list.remove(head);

                Node node = new Node(key, value);

                list.add(node);
                map.put(key,node);
            } else {
                Node node = new Node(key, value);
                list.add(node);
                map.put(key, node);
            }
        }
    }
```

Complexity:
Time - O(1)
Space - O(1)
