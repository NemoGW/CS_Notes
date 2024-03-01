# Java Thread

- [Java Thread](#java-thread)
  - [1. Using Thread](#using)
    - [Runnable](#runnable)
    - [Callable](#callable)
    - [Thread](#thread)
  - [2. Thread Life cycle](#thread)
    - [New](#new)
    - [Runable](#runable)
    - [Blocked/Waiting](#blocked--waiting)
    - [Timed Waiting](#timed-waiting)
    - [Terminated](#terminated)

## 1. Using Thread

Advantages of Java Multithreading

1. It doesn't block the user because threads are independent and you can perform multiple operations at the same time.

2. You can perform many operations together, so it saves time.

3. Threads are independent, so it doesn't affect other threads if an exception occurs in a single thread.

**Three ways to use thread**

1. Runnable interface
2. Callable interface
3. Thread class

### Runnable

- Interface: Runnable is an interface.
- Method: It has a single method called run() which does not return any value (void) and does not throw any checked exceptions.
- Purpose: It is used to define a task that can be executed by a thread. The task can be passed to a Thread object as an argument to its constructor.
- Usage: When you only need to override the run() method without needing to inherit from the Thread class.
- Limitation: The run() method cannot return a result or throw checked exceptions.

```java
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        // ...
    }
}
```

Create an object of runnable and then using thread.start() to run

```java
public static void main(String[] args) {
    MyRunnable instance = new MyRunnable();
    Thread thread = new Thread(instance);
    thread.start();
}
```

### Callable

- Interface: Callable is an interface introduced in Java 5.
- Method: It has a single method called call() which can **return a result and can throw a checked exception**.
- Purpose: Used to define a task that returns a result and may throw an exception. It is more flexible than Runnable because of its ability to return a result and throw checked exceptions.
- Usage: Use Callable when you need to execute a task that returns a result and/or might throw an exception. Callable tasks need to be submitted to an executor service. The executor returns a Future object which can be used to retrieve the result of the Callable task.
- Advantage: Ability to return a result and throw checked exceptions makes it more versatile than Runnable.

```java
public class MyCallable implements Callable<Integer> {
    public Integer call() {
        return 123;
    }
}
```

### Thread

- Class: Thread is a class that represents a thread of execution in a program.
- Method: It can directly run a task by overriding its run() method. Alternatively, a Thread can be constructed with a Runnable object, and its run() method is called when the thread is started.
- Purpose: Used to create and start a new thread. It provides mechanisms to manage thread execution, like starting, running, and terminating threads.
- Usage: Directly extend the Thread class when you need to both define a task and manage thread execution within the same class.
- Limitation: Extending the Thread class means you cannot extend any other class, as Java does not support multiple inheritance.

```java
public class MyThread extends Thread {
    public void run() {
        // ...
    }
}
public static void main(String[] args) {
    MyThread mt = new MyThread();
    mt.start();
}
```

**Thread class vs Runnable/Callable interfaces**

- Generally using interfaces would be better beacuse:
  1. Java does not support multiple extends, but can implemnt multiple interfaces.
  2. Thread is too heavy, classes might only require basic implementation.

## Thread Life cycle

A thread can only be in one state, and the thread state here specifically refers to the thread state of the Java virtual machine and cannot reflect the state of the thread under a specific operating system.

### New

Newly created and not running yet

### RUNABLE

- Runnable: A thread, that is ready to run is then moved to the runnable state. In the runnable state, the thread may be running or may be ready to run at any given instant of time. It is the duty of the thread scheduler to provide the thread time to run, i.e., moving the thread the running state.
  - A program implementing multithreading acquires a fixed slice of time to each individual thread. Each and every thread runs for a short span of time and when that allocated time slice is over, the thread voluntarily gives up the CPU to the other thread, so that the other threads can also run for their slice of time. Whenever such a scenario occurs, all those threads that are willing to run, waiting for their turn to run, lie in the runnable state. In the runnable state, there is a queue where the threads lie.
- Running: When the thread gets the CPU, it moves from the runnable to the running state. Generally, the most common change in the state of a thread is from runnable to running and again back to runnable.

### BLOCKED / WAITING

Whenever a thread is inactive for a span of time (not permanently) then, either the thread is in the blocked state or is in the waiting state.

**Blocked**
Requesting to obtain the monitor lock to enter the synchronized function or code block, but other threads have already occupied the monitor lock, so it is in a blocking state. To end this state and enter RUNABLE requires other threads to release the monitor lock.

**Waiting**
Wait for other threads to wake up explicitly.

The difference between blocking and waiting is that **blocking is passive, waiting to acquire the monitor lock. Waiting is active and is entered by calling methods such as Object.wait().**

|                    Entering method                     |           Existing method            |
| :----------------------------------------------------: | :----------------------------------: |
| Object.wait() method without setting Timeout parameter | Object.notify() / Object.notifyAll() |
| Thread.join() method without setting Timeout parameter | The other thread completes execution |
|               LockSupport.park() method                |      LockSupport.unpark(Thread)      |

### TIMED WAITING

There is no need to wait for other threads to wake up explicitly, it will be automatically woken up by the system after a certain period of time.

|              Entering method               |                Existing method                |
| :----------------------------------------: | :-------------------------------------------: |
|           Thread.sleep() method            |                  Time ended                   |
| Object.wait() with a set Timeout parameter | Time ends/Object.notify()/Object.notifyAll()  |
| Thread.join() with a set Timeout parameter | Time ends/The other thread finishes execution |
|          LockSupport.parkNanos()           |          LockSupport.unpark(Thread)           |
|          LockSupport.parkUntil()           |          LockSupport.unpark(Thread)           |

### TERMINATED

When thread ended. Or terminated by error

## Basic Thread Mech

### Executor

### Daemon

### sleep()

### yield()
