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
  - [3. Object usages](#object-usages)
    - [General methods](#general-methods)
    - [equals()](#equals)
    - [hashcode()](#hashcode)
    - [toString()](#tostring)
    - [clone()](#clone)
  - [4. String](#string)
    - [Benefit of immutable](#benefit-of-immutable)
    - [Comparsion & String pool](#string-comparsion--string-pool)
    - [new String()](#new-string)
    - [String, StringBuffer, StringBuilder](#string-stringbuffer-stringbuilder)
  - [5. Keywords](#keywords)
    - [final](#final)
    - [static](#static)
  - [6. Exception Handling](#exception-handling)
    - [try, catch, finally](#try-catch-finally)
    - [throw, throws](#throw-throws)
    - [Custom Exceptions](#custom-exception)

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

2. Runtime polymorphism - Overriding: **same name, same return, same parameter but different class**

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

**Both abstract classes and abstract methods are declared using the abstract keyword. If a class contains abstract methods, the class must be declared abstract.**

**The biggest difference between abstract classes and intereface is that abstract classes cannot be instantiated and can only be inherited.**

**Interface**
There are mainly three reasons to use interface. They are given below.

1. It is used to achieve abstraction.
2. By interface, we can support the functionality of multiple inheritance.
3. It can be used to achieve loose coupling.

| Abstract class                                                                               | Interface                                                                                            |
| -------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- |
| Abstract class can have abstract and non-abstract methods.                                   | Interface can have only abstract methods. Since Java 8, it can have default and static methods also. |
| Abstract class doesn't support multiple inheritance.                                         | Interface supports multiple inheritance.                                                             |
| Abstract class can have final, non-final, static and non-static variables.                   | Interface has only static and final variables.                                                       |
| Abstract class can provide the implementation of interface.                                  | Interface can't provide the implementation of abstract class.                                        |
| The abstract keyword is used to declare abstract class.                                      | The interface keyword is used to declare interface.                                                  |
| An abstract class can extend another Java class and implement multiple Java interfaces.      | An interface can extend another Java interface only.                                                 |
| An abstract class can be extended using keyword "extends".                                   | An interface can be implemented using keyword "implements".                                          |
| A Java abstract class can have class members like private, protected, etc. Members of a Java | interface are public by default.                                                                     |

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

**1. Comparing Two**

- Abstraction provides a IS-A relationship. Where the subclass object able to replace all parent class objects. Where Intereface provides LIKE-A relationship where it only provides a method to implement.

- Class can implement multiple interfaces, but cannot inherit multiple abstract classes.

- Interefaces fields can only be static and final type, abstraction has no restrictions.

- Members of an interface can only be public, abstraction have multiple access rights.

**2. When to use Witch?**

Using Interface:

- Want some not-related class to preform a certain action. E.g unrelated classes can implement compareTo() method in the Comparable interface;
- Needed to use multiple inheritance.

Using Abstraction:

- Code needs to shared among serveral related classes.
- Need to be able to control access to inherited memebers rather than all being public
- Non-static and non-const(non-final) fields need to be inherited.

**In many cases, interfaces take precedence over abstract classes. Because interfaces do not have the strict class hierarchy requirements of abstract classes, they can flexibly add behavior to a class. And starting from Java 8, interfaces can also have default method implementations, making the cost of modifying the interface very low.**

### Encapsulation

**package**

1. Java package is used to categorize the classes and interfaces so that they can be easily maintained.

2. Java package provides access protection.

3. Java package removes naming collision.

**Access Modifier**

1. Private: The access level of a private modifier is only within the class. It cannot be accessed from outside the class.
2. Default: The access level of a default modifier is only within the package. It cannot be accessed from outside the package. If you do not specify any access level, it will be the default.
3. Protected: The access level of a protected modifier is within the package and outside the package through child class. If you do not make the child class, it cannot be accessed from outside the package.
4. Public: The access level of a public modifier is everywhere. It can be accessed from within the class, outside the class, within the package and outside the package.

| Access Modifier | within class | within package | outside package by subclass only | outside package |
| --------------- | ------------ | -------------- | -------------------------------- | --------------- |
| Private         | Y            | N              | N                                | N               |
| Default         | Y            | Y              | N                                | N               |
| Protected       | Y            | Y              | Y                                | N               |
| Public          | Y            | Y              | Y                                | Y               |

## Object Usages

### General Methods

```java

public native int hashCode()

public boolean equals(Object obj)

protected native Object clone() throws CloneNotSupportedException

public String toString()

public final native Class<?> getClass()

protected void finalize() throws Throwable {}

public final native void notify()

public final native void notifyAll()

public final native void wait(long timeout) throws InterruptedException

public final void wait(long timeout, int nanos) throws InterruptedException

public final void wait() throws InterruptedException
```

### equals()

**1. equals relation**
The equals() method compares two strings, and returns true if the strings are equal, and false if not.

For two objects to have an equivalence relationship, the following five conditions need to be met:

1. Compare to self

```java
x.equals(x); //true
```

2. Compare to eachother

```java
x.equals(y) == y.equals(x); //true
```

3.Transitivity

```java
if (x.equals(y) && y.equals(z))
    x.equals(z); // true;
```

4. Consistency
   output will be the same no matter how many times equals are used.

```java
x.equals(y) == y.equals(x);
```

5. Compare to null
   when comparing non-null to null, it should always be false

```java
x.equals(null); //false
```

**2. == vs equals()**

- for regular variables, == compares if two variables are equal. No equals()
- for reference types, == compares if they are the same reference. equals() determine whether the referenced objects are equivalent.

```java
Integer x = new Integer(1);
Integer y = new Integer(1);
System.out.println(x.equals(y)); // true
System.out.println(x == y);      // false
```

**3. Implementation**

- Check whether it is a reference to the same object, if so, return **_true_**
- Check whether they are of the same type, if not, return **_false_**
- Transform the Object object;
- Determine whether each key field is equal.

```java
public class EqualExample {

    private int x;
    private int y;
    private int z;

    public EqualExample(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EqualExample that = (EqualExample) o;

        if (x != that.x) return false;
        if (y != that.y) return false;
        return z == that.z;
    }
}
```

### hashCode()

Returns a hashCode() of the object.

- equals() also checks if their hashCode() is the same.
- Java collections like HashSet, HashMap also utilizes hashCode() to determine the location of storage.

EqualExample does not have hashCode() method, resulting inserting two EqualExample object because their hashcode are not the same.

```java
EqualExample e1 = new EqualExample(1, 1, 1);
EqualExample e2 = new EqualExample(1, 1, 1);
System.out.println(e1.equals(e2)); // true
HashSet<EqualExample> set = new HashSet<>();
set.add(e1);
set.add(e2);
System.out.println(set.size());   // 2
```

### toString()

Returns the String representation of the object.
By default, the form ToStringExample@4554617c is returned, where the value after @ is the unsigned hexadecimal representation of the hash code.

Without overriding.

```java
 public static void main(String args[]){
   Student s1=new Student(101,"Raj","lucknow");
   Student s2=new Student(102,"Vijay","ghaziabad");

   System.out.println(s1);//compiler writes here s1.toString()
   System.out.println(s2);//compiler writes here s2.toString()
 }
}

/**
 * Output
 *
 * Student@1fee6fc
 * Student@1eed786
 *
 **/

```

with overriding - we can return values of the object

```java
 public String toString(){//overriding the toString() method
  return rollno+" "+name+" "+city;
 }
 public static void main(String args[]){
   Student s1=new Student(101,"Raj","lucknow");
   Student s2=new Student(102,"Vijay","ghaziabad");

   System.out.println(s1);//compiler writes here s1.toString()
   System.out.println(s2);//compiler writes here s2.toString()
 }
}

/**
 * output
 *
 * 101 Raj lucknow
 * 102 Vijay ghaziabad
 *
 * */
```

### clone()

The clone() method saves the extra processing task for creating the exact copy of an object.

- clone() is a protected method of Object. It is not public. If a class does not explicitly override clone(), other classes cannot directly call the clone() method of the class instance.

```java
public class CloneExample implements Cloneable {
    private int a;
    private int b;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
```

**Shallow copy vs Deep Copy**

**1. Shallow copy**
When we do a copy of some entity to create two or more than two entities such that **changes in one entity are reflected in the other entities** as well, then we can say we have done a shallow copy.

```java
public class ShallowCloneExample implements Cloneable {

    private int[] arr;

    public ShallowCloneExample() {
        arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    public void set(int index, int value) {
        arr[index] = value;
    }

    public int get(int index) {
        return arr[index];
    }

    @Override
    protected ShallowCloneExample clone() throws CloneNotSupportedException {
        return (ShallowCloneExample) super.clone();
    }
}
```

```java
ShallowCloneExample e1 = new ShallowCloneExample();
ShallowCloneExample e2 = null;
try {
    e2 = e1.clone();
} catch (CloneNotSupportedException e) {
    e.printStackTrace();
}
e1.set(2, 222);
System.out.println(e2.get(2)); // 222
```

**2. Deep Copy**
When we do a copy of some entity to create two or more than two entities such that **changes in one entity are not reflected in the other entities**, then we can say we have done a deep copy.

```java
public class DeepCloneExample implements Cloneable {

    private int[] arr;

    public DeepCloneExample() {
        arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    public void set(int index, int value) {
        arr[index] = value;
    }

    public int get(int index) {
        return arr[index];
    }

    @Override
    protected DeepCloneExample clone() throws CloneNotSupportedException {
        DeepCloneExample result = (DeepCloneExample) super.clone();
        result.arr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result.arr[i] = arr[i];
        }
        return result;
    }
}

```

```java
DeepCloneExample e1 = new DeepCloneExample();
DeepCloneExample e2 = null;
try {
    e2 = e1.clone();
} catch (CloneNotSupportedException e) {
    e.printStackTrace();
}
e1.set(2, 222);
System.out.println(e2.get(2)); // 2
```

## String

### What is String?

Strings are immutable.
Can be stored with char[].

```java
public final class String
    implements java.io.Serializable, Comparable<String>, CharSequence {
    /** The value is used for character storage. */
    private final char value[];
}
```

- In java 9 and beyond string can be stored with byte and use `coder` to identify of the encoding used to encode the bytes.

### Benefit of immutable

**1. Can cache hash values**
E.g using String as a Hashmap key. So the hashcode will not change, which only one time calculation is needed.

**2. To be used by string pool**
If a String has been created, a reference will be obtained from the String Pool. Using String Pool is only possible if String is immutable.

**3. Thread Safety**

### String comparsion & String pool

**1. String Pool**
String pool is a storage space in the java heap memory where string literals are stored.

We can use String `intern()` to add the literal to the string pool.

```java
String s1 = new String("aaa");
String s2 = new String("aaa");
System.out.println(s1 == s2);           // false
String s3 = s1.intern();
String s4 = s2.intern();
System.out.println(s3 == s4);           // true
```

intern() first puts "aaa" into the String Pool and then returns the string reference, so s3 and s4 refer to the same string.

**2. String Comparsion**

**_1. equals()_**
equals() method compares the original content of the string. It compares values of string for equality.

```java
public boolean equals(Object another) //compares this string to the specified object.

public boolean equalsIgnoreCase(String another) //compares this string to another string, ignoring case.
```

**_2. == operator_**
The == operator compares references not values.

```java
class Teststringcomparison3{
 public static void main(String args[]){
   String s1="Sachin";
   String s2="Sachin";
   String s3=new String("Sachin");
   System.out.println(s1==s2);//true (because both refer to same instance)
   System.out.println(s1==s3);//false(because s3 refers to instance created in nonpool)
 }
}
```

**_3. compareTo()_**
Compares values lexicographically and returns an integer value that describes if first string is less than, equal to or greater than second string.

s1 == s2 : The method returns 0.
s1 > s2 : The method returns a positive value.
s1 < s2 : The method returns a negative value.

```java
class Teststringcomparison4{
 public static void main(String args[]){
   String s1="Sachin";
   String s2="Sachin";
   String s3="Ratan";
   System.out.println(s1.compareTo(s2));//0
   System.out.println(s1.compareTo(s3));//1(because s1>s3)
   System.out.println(s3.compareTo(s1));//-1(because s3 < s1 )
 }
}
```

### new String()

E.g(`new String(abc)`)
2 reference will be created (let say that in the pool we did not have "abc" before)

- "abc" is a string literal, so a string object will be created in the String Pool during compilation pointing to "abc" literal.
- `new` will create a string object in the heap.

### String, StringBuffer, StringBuilder

**1. Immutation**

- String is immutable
- StringBuffer & StringBuilder is mutable

**2. Thread Safety**

- String is immutable, thus it is thread safety
- StringBuilder is **not** thread safe (StringBuilder is more efficient than StringBuffer.)
- StringBuffer is thread safe. Uses synchronized internally.(means two threads can't call the methods of StringBuffer simultaneously.)

**3. Concatenation & Substring**

Concatenation using `+`

```java
String s = "a" + "1";
```

Compiler transfrom above to

```java
String s=(new StringBuilder()).append("a").append("1").toString();
```

Substring

```java
String s="hello";
System.out.println(s.substring(0,2)); //returns he  as a substring
```

## Keywords

### final

**1. final values**

- value of final cannot be changed
- the object refering to final can be changed

```java
final int x = 1;
// x = 2;  // cannot assign value to final variable 'x'
final A y = new A();
y.a = 1; // can change y.a
```

**2. final methods**

- final values cannot be override by subclasses

**3. final classes**

- final classes cannot be inherted or extended.

### static

**1. static variable**

- static variables are the variables shared by class, can be accessed by class object.

```java
public class A {

    private int x;         // instance var
    private static int y;  // static var

    public static void main(String[] args) {
        // int x = A.x;  // Non-static field 'x' cannot be referenced from a static context
        A a = new A();
        int x = a.x;
        int y = A.y;
    }
}
```

**2. static methods**

- Static methods exist when the class is loaded and do not depend on any instance. So the static method must have an implementation, which means it cannot be an abstract method.

```java
public abstract class A {
    public static void func1(){
    }
    // public abstract static void func2();  // Illegal combination of modifiers: 'abstract' and 'static'
}
```

You can only access static fields and static methods of the class you belong to. The this and super keywords cannot be included in the method because these two keywords are associated with specific objects.

```java
public class A {

    private static int x;
    private int y;

    public static void func1(){
        int a = x;
        // int b = y;  // Non-static field 'y' cannot be referenced from a static context
        // int b = this.y;     // 'A.this' cannot be referenced from a static context
    }
}
```

**3. static block**

- static block is run at initialization

## Exception Handling

Object can be throwable, and there are two types

1. Error

- StackOverflowError, OutOfMemeoryError, LinkageError etc.

2. Exceptions

- Checked Exception: Can use try-catch block to capture the exception and restore.
- Unchecked Exception: Compile error, cannot be restored

### try, catch, finally

```java
try{
// code that may throw an exception
} catch {
// what to do when exception occur
} finally {
  // finally block is always executed
}
```

### Throw, Throws

- **Throw** is used to throw an exception in the code, inside of a function or block
- **Throws** is used to declare an exception which might be thrown by the function

### Custom exception

Extends `Exception` class

```java
public class WrongFileNameException extends Exception {
    public WrongFileNameException(String errorMessage) {
    super(errorMessage);
    }
}
```
