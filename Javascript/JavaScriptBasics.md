# JavaScript Basics
-[1. Variable](#variable)
    -[Datatypes](#datatypes)
    -[Operators](#special-operators)
-[2. Event](#event)

## Variable
JavaScript variables can be declared using `let` or `var` or `const`.
**JavaScript is case sensitive**

1. `var` variables can be restated, and changed.
 - global change
2. `let` variables cannot be restated, but can be changed.
 - block change
3. `const` variables cannot be changed.
 - however, const variables property can be updated.

```javascript

var hello = "hello1";
var hello = "hello2";
hello = "hello3";

//here hello will be chanegd to hello1 -> hello2 -> hello3

let hello = "hello1";
let hello = "hello2"; //this is not allowed
hello = "hello3";

//here hello will be changed to hello1 -> hello3

const hello = "hello1";
const hello = "hello2"; // this is not allowed
hello = "hello3"; //this is not allowed

//suppose you declare a const with properities. (AKA Object)
const hello = {
    id: "1",
    message: "hello"
}

//this is not allowed
hello = {
    id: "2",
    message: "hello2" 
}

//can be changed like
hello.id = "3";
```
### DataTypes
JavaScript has 8 Datatypes
1. String
2. Number
3. Bigint
4. Boolean
5. Undefined
6. Null
7. Symbol
8. Object

```javascript
// Numbers:
let length = 16;
let weight = 7.5;

// Strings:
let color = "Yellow";
let lastName = "Johnson";

// Booleans
let x = true;
let y = false;

// Object:
const person = {firstName:"John", lastName:"Doe"};

// Array object:
const cars = ["Saab", "Volvo", "BMW"];

// Date object:
const date = new Date("2022-03-25");
```

**The Object Datatype**
The object data type can contain:
1. An object
2. An array
3. A date

When adding a number to string, JavaScript will treat the number as a string.

E.g.
```javascript
let n = 1;
let hello = hello;

let message = hello + n; // hello1
```

### Special Operators
**Compare operator**

Use for comparsion
`===` or `!==`
- these denotes **equal value and equal type**

`==` vs `===`
```javascript
var a = [1,2,3];
var b = [1,2,3];

var c = { x: 1, y: 2 };
var d = { x: 1, y: 2 };

var e = "text";
var f = "te" + "xt";

a == b            // false
a === b           // false

c == d            // false
c === d           // false

e == f            // true
e === f           // true

"abc" == new String("abc")    // true
"abc" === new String("abc")   // false
```

**JavaScript Type Operators**
1. typeof - Returns the type of a variable
2. instanceof - Returns true if an object is an instance of an object type

```javascript
typeof ""             // Returns "string"
typeof "John"         // Returns "string"
typeof "John Doe"     // Returns "string"
```

## Event
**CommonHTML Events**
|Event|Description|
|:--:|:--:|
|onchange|An HTML element has been changed|
|onclick|The user clicks an HTML element|
|onmouseover|The user moves the mouse over an HTML element|
|onmouseout|The user moves the mouse away from an HTML element|
|onkeydown|The user pushes a keyboard key|
|onload|The browser has finished loading the page|