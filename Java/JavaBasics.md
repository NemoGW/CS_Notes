# Java Basics

- [Java Basics](#java-basics)
  - [1. Fundamental](#1-fundamental)
    - [JDK, JRE and JVM](#jdk-jre-and-jvm)
    - [Java Variables](#java-variables)
    - [Data Types](#data-types)
    - [Wrappers](#wrappers)

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
