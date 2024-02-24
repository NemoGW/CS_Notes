# Java Basics

- [Java Basics](#java-basics)

  - [1. Fundamental](#1-fundamental)
    - [JDK, JRE and JVM](#jdk-jre-and-jvm)
    - [Java Variables](#java-variables)
    - [Data Types](#data-types)
    - [Wrappers](#wrappers)
  - [2. OOP Concept](#2-oop-concept)

    - [Object and Class](#object-and-class)
    - [Inheritance](#inheritance)
    - [Polymorphism](#polymorphism)
    - [Abstraction](#abstraction)
    - [Encapsulation](#encapsulation)

    <!-- -[3. Key Word](#) - [Staic](#) - [Final](#) -->

## 1. Fundamental

### JDK, JRE and JVM

1.  JVM (Java Virtual Machine) - provides a runtime environment in which Java bytecode can be executed.

    - loads code
    - verifies code
    - executes code
    - provides runtime enviornment

    JVM provides definitions for the:

         - Memory area
         - Class file format
         - Register set
         - Garbage-collected heap
         - Fatal error reporting etc.

2.  JRE (Java Runtime Environment) - set of software tools which are used for developing Java applications.

    - Used to provide runtime environment.
    - Implementation of JVM
    - Physically exists
    - Contains set of libraries + other files that JVM uses.

<div align="center"> <img src="https://github.com/NemoGW/CS_Notes/blob/main/Java/Assets/JRE.png"/> </div><br>

3. JDK (Java Development Kit) - software development environment used to develop java applications and applets.

   - Physically exists
   - Contains JRE + development tools
   - Development tools like: Javadoc, java etc.

### Java Variables

Types of variables:

- local variable
  - can only be declared inside the body of the method.
  - cannot be defined with "static" keyword.
  - other methods does not know the existance of this local variable
- instance variable
  - inside the class but outside the body of the method.
  - value is instance-specific and not shared among instances.
- static variable
  - singly copy of static variable
  - can be share among all instances of class
  - memory allocation happens only once when the class is loaded in the memory.

```java
public class A
{
    static int m=100;//static variable
    void method()
    {
        int n=90;//local variable
    }
    public static void main(String args[])
    {
        int data=50;//instance variable
    }
}//end of class
```

### Data Types

1. Primitive data types

   - byte/8
   - char/16
   - short/16
   - int/32
   - float/32
   - long/64
   - double/64
   - boolean/~

   boolean can only be true or false. Or 1, 0

2. Non-primitive data types
   - Classes
   - Interfaces
   - Arrays etc.

### Wrappers

Variable assignments will be done through autoboxing and unboxing.

For instance:

```java
Integer x = 1; //autoboxing - Integer.valueOf(2)
int y = x; //unboxing - X.intValue();
```

###

## 2. OOP Concept

### Object and Class

Object is an instance of a class

- real-world entity
- runtime entity
- entity which has state and behavior

### Inheritance

Parent to Child relationship.

- Superclass & subclasses
- uses **extends** key word
  - e.g. `class Subclass extends Superclass{}`

Key to remeber:

1. Method Overriding - when subclass has a method with same name & return type & parameter as method in the superclass. Allows submethod to have implementation of a method that is already provided by its super class.
2. Access Modifier - **protected** in superclass can be accessed by the subclass. **private** cannot be directly accessed.
3. 'super' keyword - used to call the superclass's method and constructor.

### Polymorphism

Types:

1. Complie-Time Polymorphism (Static Binding or Method Overloading). - Overloading: Multiple method having the **same name different parameters**

2.Runtime polymorphism - Overriding: **same name, same return, same parameter but different class**

### Abstraction

There are two ways to achieve abstraction in java

1. Abstract class (0 to 100%)
2. Interface (100%)

**Abstract Class**
It can have abstract and non-abstract methods. It needs to be extended and its method implemented. It cannot be instantiated.

- An abstract class must be declared with an abstract keyword.
- It can have abstract and non-abstract methods.
- It cannot be instantiated.
- It can have constructors and static methods also.
- It can have final methods which will force the subclass not to change the body of the method.

**Interface**
There are mainly three reasons to use interface. They are given below.

1. It is used to achieve abstraction.
2. By interface, we can support the functionality of multiple inheritance.
3. It can be used to achieve loose coupling.

| Abstract class | Interface |
| Abstract class can have abstract and non-abstract methods. | Interface can have only abstract methods. Since Java 8, it can have default and static methods also. |
|Abstract class doesn't support multiple inheritance. |Interface supports multiple inheritance.|
|Abstract class can have final, non-final, static and non-static variables. |Interface has only static and final variables.|
|Abstract class can provide the implementation of interface. |Interface can't provide the implementation of abstract class.|
|The abstract keyword is used to declare abstract class. |The interface keyword is used to declare interface.|
|An abstract class can extend another Java class and implement multiple Java interfaces. |An interface can extend another Java interface only.|
|An abstract class can be extended using keyword "extends". |An interface can be implemented using keyword "implements".|
|A Java abstract class can have class members like private, protected, etc. Members of a Java |interface are public by default.|

Example:

```java
public abstract class Shape{
public abstract void draw();
}
```

```java
public interface Drawable{
void draw();
}
```

### Encapsulation
