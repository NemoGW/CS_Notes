# Java Interview Questions

**Question: Can you explain the four main principles of OOP and provide a Java example for each?**

- Polymorphism: Allows objects of different classes to be treated as objects of a common super class. It includes method **overloading (same method name, different parameters)** and **overriding (same method name and parameters as in the superclass)**.
- Inheritance: Enables a new class to inherit properties and behavior from an existing class using **extends for classes** and **implements for interfaces**.
- Abstraction: Hides complex implementation details and shows only the necessary features of an object. It can be achieved using **abstract classes and interfaces**.
- Encapsulation: Bundles the data (attributes) and methods that operate on the data into a single unit called a class, and restricts access to some of the object's components using **access modifiers (private, protected, public)**.

**Question: What is the difference between checked and unchecked exceptions in Java? Can you provide an example of when to use each?**

- Checked Exceptions: These are checked at compile-time. They must be either caught or declared in the method's throws clause.
  - Example: IOException.
- Unchecked Exceptions: These are not checked at compile-time, meaning the compiler does not require methods to catch or declare them. They inherit from RuntimeException.
  - Example: NullPointerException, ArithmeticException.

**Question: How does the synchronized keyword work in Java, and when would you use it? Can you explain the concept of intrinsic locks?**

- The synchronized keyword in Java is used to control access to a block of code or method by multiple threads. It **ensures that only one thread can execute a synchronized method/block at a time**, providing a lock for an object or class. Intrinsic locks, or monitor locks, are mechanism that provide mutual exclusive access to a block of synchronized code.

**Question: How does Java store strings in memory, and what is the string pool? Why should you use StringBuilder in Java?**

- The String Pool is a special memory region where Java stores literal string values. Strings are immutable to increase Java's efficiency and security. StringBuilder is used for creating mutable string sequences to avoid the performance cost associated with immutable strings. StringBuilder is used to modify strings without creating a new String object.

**Question: Can you explain what a Stream is in Java 8 and give an example of how to use it to filter a list of integers to only even numbers?**

- Java 8 introduced Streams, which provide a new abstraction for processing sequences of elements. A Stream supports a chain of operations, such as filter, map, or reduce, on the elements. For filtering even numbers from a list of integers:

```java
List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
List<Integer> evenNumbers = list.stream()
                                 .filter(n -> n % 2 == 0)
                                 .collect(Collectors.toList());

```

**Question: What are the main differences between ArrayList and LinkedList in Java, and when would you prefer one over the other?**

- ArrayList stores elements in a dynamic array, providing rapid random access but slow insertion and removal in the middle of the list.
- LinkedList stores elements in a doubly-linked list, allowing for faster insertion and removal at the expense of slower random access.

**Question: How does a HashMap work internally in Java? What happens when two keys have the same hash code?**

- A HashMap in Java works by storing entries in "buckets" based on the hash codes of their keys. When two keys have the same hash code, a collision occurs, and entries are stored in a linked list or tree (Java 8 and later) within the same bucket. The equals method is used to distinguish between entries in the same bucket.

**Question: Can you explain the difference between a Queue and a Stack, and provide a real-world example where each might be used?**

- Queue: A queue is a First-In-First-Out (FIFO) data structure. This means that the first element added to the queue will be the first one to be removed. Queues are commonly used in scenarios like scheduling tasks, handling asynchronous data (e.g., data packets in networking), or in breadth-first search algorithms. In Java, queues are typically represented by the Queue interface, and common implementations include LinkedList and PriorityQueue.

- Stack: A stack is a Last-In-First-Out (LIFO) data structure. The last element added to the stack will be the first to be removed. Stacks are useful in situations that require backtracking (such as navigating a browser's history), parsing expressions (like in compilers), or for depth-first search algorithms. In Java, stacks can be implemented using the Stack class or by using an ArrayList or LinkedList and managing the elements in a LIFO manner.

**Question: Write a SQL query to find the second highest salary from the "employees" table.**

```sql
SELECT MAX(salary) FROM employees WHERE salary < (SELECT MAX(salary) FROM employees);
```

**Question: What are the main types of NoSQL databases, and can you provide an example use case for each type?**

NoSQL databases are designed to handle a wide variety of data types, including document, key-value, wide-column, and graph formats. They are useful for:

- Document: Storing, retrieving, and managing document-oriented information, e.g., MongoDB.
- Key-Value: Storing data as a collection of key-value pairs, e.g., Redis.
- Wide-Column: Optimized for queries over large datasets, e.g., Cassandra.
- Graph: Storing networks of data, e.g., Neo4j, suitable for social networks, fraud detection, and more.

**Question: How would you test a method that calculates the sum of two numbers using JUnit? Provide a simple code example.**

```java
import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {
    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.add(2, 3));
    }
}

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}

```

**Question: What are the differences between abstract classes and interfaces in Java, and when would you use each?**

- Abstract classes are declared with the abstract keyword and that they can contain both abstract methods (without an implementation) and non-abstract methods (with an implementation).
- Interfaces, on the other hand, can declare methods but traditionally couldn't contain implementation details prior to Java 8. With Java 8 and beyond, interfaces can contain default and static methods with implementations.

Java allows a class to implement multiple interfaces but only extend one abstract class.

**_Usage_**

- Abstract Class: Use when you want to share code among several closely related classes.
- Interface: Use when you want to specify that a class must implement a particular behavior (prior to Java 8, interfaces couldn't contain implementation code).

**Question: Can you explain what lambda expressions are in Java 8, and provide an example of their use with a Comparator?**

- Lambda expressions in Java 8 and beyond are a concise way of representing an anonymous method that can be passed around as if it were a value. **Like a method but without names, has a parameter and a retrun value**

**Question: What is Comparator? Comparator vs. Comparable?**

- `Comparable` is an interface defining a single method **compareTo** that an object can use to **compare itself with another object**. If a class implements Comparable, it agrees to mutual comparison and a natural ordering.
- `Comparator` is an interface for defining an external comparison strategy. Use **Comparator when you want to define multiple ways to compare the same class or compare classes that did not implement Comparable**.

**Question: Describe the purpose of the Optional class introduced in Java 8. How does it help in handling null values?**

- `Optional` is a container object used to **contain not-null objects.** Optional object is used to represent null with absent value. It is a better alternative to returning null from methods:

```java
Optional<String> optional = Optional.of("Hello");
optional.ifPresent(System.out::println); // Prints "Hello" if present

```

**Question: Explain the difference between List and Set in Java Collections. Can you give an example when you would prefer using one over the other?**

- List: An ordered collection that can contain duplicate elements. It allows positional access and insertion of elements.
- Set: A collection that cannot contain duplicate elements. It models the mathematical set abstraction.
- Use a List when order matters or duplicates are needed. Use a Set for unique elements and when order isn't important.

**Question: Java 8 introduced several enhancements to the Map interface. Can you describe one of these enhancements?**

- Java 8 added several new default methods to the Map interface, including `forEach`, `getOrDefault`, `putIfAbsent`, `remove`, `replace`, and `computeIfAbsent`.

**Question: Describe the purpose of the ConcurrentHashMap in Java. How does it differ from a regular HashMap?**

- `ConcurrentHashMap` is a **thread-safe** variant of HashMap introduced in the `java.util.concurrent` package. It allows concurrent access to the map, making it suitable for multi-threaded applications. Unlike Hashtable or synchronizing access to a HashMap, it does **not lock** the map as a whole. Instead, it uses a segment of locks improving concurrency and throughput.

**Question: Can you explain what a binary search tree (BST) is and how it differs from a regular binary tree?**

- A binary search tree (BST) is a type of binary tree where the tree is arranged in a way that for each node, all elements in the left subtree are less than the node, and all elements in the right subtree are greater. This property makes it efficient for operations like search, insert, and delete.

**Question: Briefly explain what a graph data structure is and the difference between a directed and an undirected graph.**

A graph is a collection of nodes (vertices) and edges connecting some pairs of nodes. Graphs can be used to represent networks like roads, internet, social networks, etc.

- Directed Graph: A graph where the edges have a direction, indicating the relationship flows from one vertex to another.
- Undirected Graph: A graph where the edges do not have a direction, indicating a two-way relationship.

**Question: Static vs. Instance Methods in Java**

- Static Methods: Belong to the class rather than any specific instance of the class and can be called without creating an instance of the class. Static methods are used for operations that don't require data from an instance of the class. They are marked with the static keyword.
- Instance Methods: Belong to an instance of a class. They can manipulate the instance variables of the object to which they belong. Instance methods can access static methods and static variables directly.

**Question: Functional Interfaces in Java 8**

- A functional interface in Java is an interface that contains exactly one abstract method, allowing it to be used for lambda expressions and method references. Java 8 annotates these interfaces with @FunctionalInterface annotation to ensure they meet the criteria.

**Question: TreeMap vs. HashMap**

- HashMap: Provides constant-time performance for basic operations (get and put), assuming the hash function disperses elements properly among the buckets. It does not guarantee any order of the map elements.
- TreeMap: Implements the NavigableMap interface and guarantees that the elements will be in ascending key order. It provides O(log n) time cost for the containsKey, get, put, and remove operations.

- Use HashMap when order is not important and you need efficient access to elements. Use TreeMap when you need sorted order for keys.

**Questions: Generics in Collections**

- Generics provide a way to ensure type safety in collections by allowing you to specify the type of elements stored in a collection. This prevents runtime errors by catching type mismatches at compile time.

**Questions: Thread vs. Runnable**

- Thread: Extending the Thread class means your class cannot extend any other class, as Java doesn't support multiple inheritance.
- Runnable: Implementing the Runnable interface is more flexible as it allows your class to extend another class.

**Question: Thread Life Cycle**

1. New: The thread is created but not yet started.
2. Runnable: The thread is ready to run and may be running.
3. Blocked: The thread is blocked waiting for a monitor lock.
4. Waiting: The thread is waiting indefinitely for another thread to perform a particular action.
5. Timed Waiting: The thread is waiting for another thread to perform an action for up to a specified waiting time.
6. Terminated: The thread has exited its run method and is done executing.

**Question: What is the difference between the synchronized method and synchronized block in Java? Provide examples where each would be appropriate.**

- Synchronized Method: Declares an entire method as synchronized, locking on the instance (or class for static methods) for the duration of the method.

```java
public synchronized void syncMethod() {
    // code
}

```

- Synchronized Block: Allows more precise control over the lock object and scope.

```java
public void someMethod() {
    synchronized(this) {
        // code block
    }
}

```

**Questions: Explain what a deadlock is in a multithreading context. How can deadlocks be detected and prevented in Java?**

- A deadlock is a situation where two or more threads are blocked forever, each waiting for the other to release a lock. Deadlocks can be prevented by ensuring that locks are always acquired and released in a consistent order and by using timeouts.

**Question: What is a thread pool in Java and why would you use it? How can you implement a simple thread pool using the Executor framework?**

- A thread pool is a collection of reusable threads. Using a thread pool helps to limit the number of threads being created, reduce overhead, and improve application performance. In Java, thread pools can be easily implemented using the Executor framework.

```java
ExecutorService executor = Executors.newFixedThreadPool(10);
executor.execute(new RunnableTask());
```

**Question: Explain the purpose of the volatile keyword in Java. How does it affect variable visibility and access in a multithreaded environment?**

- The volatile keyword in Java is used to indicate that a variable's value will be modified by different threads. Declaring a variable volatile ensures that its value is read from and written to main memory, thus ensuring visibility of changes to all threads.

**Question: Compare and contrast ReentrantLock with intrinsic locks obtained via synchronized blocks. When would you use ReentrantLock over synchronized?**

- Intrinsic Locks: Obtained using the `synchronized` keyword. Intrinsic locks are easy to use but offer less flexibility.

- ReentrantLock: Part of the java.util.concurrent.locks package. It offers more flexibility through methods like tryLock(), lockInterruptibly(), and the ability to implement non-block-structured locking disciplines.

- Use ReentrantLock for advanced locking capabilities not available with synchronized.

**Question: Explain the concept of Compare-And-Swap (CAS) and its relevance to atomic variables in Java. How do atomic variables utilize CAS operations?**

- Compare-And-Swap (CAS) is an atomic instruction used for managing concurrency without locks. Atomic variables in Java, such as AtomicInteger, use CAS operations to ensure thread safety by atomically checking and setting values.

**Question: How can threads communicate with each other in a Java program? Discuss the use of `wait()`, `notify()`, and `notifyAll()` methods in the context of thread communication.**

- Threads can communicate with each other using `wait()`, `notify()`, and `notifyAll()` methods. These methods must be called within a synchronized block or method.

- `wait()`: Causes the current thread to wait until another thread invokes
- `notify()` or `notifyAll()` on the same object.
- `notify()`: Wakes up one waiting thread chosen at the caller's discretion.
- `notifyAll()`: Wakes up all threads waiting on the object's monitor.

**Question: What is the Java Memory Model, and why is it important for concurrent programming? How does it define the interaction between threads and memory?**

- The Java Memory Model defines how threads interact through memory and what behaviors are allowed in concurrent execution. It's crucial for understanding the visibility of changes made by one thread to other threads and for writing correct, thread-safe code.

**Question: Concurrent Collections: Explain the advantages of using concurrent collections like ConcurrentHashMap, CopyOnWriteArrayList, and BlockingQueue. How do they differ from their non-concurrent counterparts?**
Concurrent collections like `ConcurrentHashMap`, `CopyOnWriteArrayList`, and `BlockingQueue` are designed for concurrent access, improving performance and reliability over synchronized collections. They provide thread-safe operations without the need for external synchronization and often use lock stripping and other strategies to allow higher concurrency levels.

- `ConcurrentHashMap`: A thread-safe version of HashMap that allows concurrent access and updates.
- `CopyOnWriteArrayList`: A thread-safe variant of ArrayList where all mutative operations (add, set, etc.) are implemented by making a fresh copy.
- `BlockingQueue`: A type of queue that supports operations that wait for the queue to become non-empty when retrieving an element and wait for space to become available in the queue when storing an element.
