# JavaScript Basics

## JavaScript Variable
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