## Frontend Interview Questions

Contains JS basics, Front-end Dev, Framework (Angular/React)

**Question: Explain the difference between var, let, and const in JavaScript. How does scoping work for each?**

- `var` and `let` are used to declare function variables. The difference is that `var` can be global scope (when declared outside the function). `let` is block-scope meaning it is limited to block, statement or expression.
- `const` is block-scope and used to declare varaibale that cannot be re-assigned.

**Question: Name at new features introduced in ES6 (ECMAScript 2015) and provide a brief explanation of each.**

1. **Classes:** A class is a type of function, but instead of using the keyword function to initiate it, we use the keyword class, and the properties are assigned inside a constructor() method.

```javascript
class Car {
  constructor(name) {
    this.brand = name;
  }
}
```

2. **Arrow Functions:** Provides a more concise syntax for writing function expressions by removing the need for the function keyword and handling this differently.

```javascript
() => expression

param => expression

(param) => expression

(param1, paramN) => expression

() => {
  statements
}

param => {
  statements
}

(param1, paramN) => {
  statements
}
```

3. **Variables** : let const var
4. **Array Methods**: There are alot functions - some essentials to know

   - **.map()** : The map() function creates a new array generated from the results of callback function on every element within the array.

   ```javascript
   let ls = [3, 5, 7]; // 3, 5, 7
   let lsMul2 = ls.map((item) => item * 2); // [6, 10, 14]

   // another case
   let jsxList = ls.map((item, index) => <li key={index}>{item}</li>);
   ```

   - **.filter()**: The filter() method creates a new array with all elements that pass the test set by the callback function.

   ```javascript
   let ls = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
   let even = ls.filter((item) => item % 2 === 0); // [2, 4, 6, 8, 10]
   ```

   - **.forEach()**: The forEach() method executes a callback function once for each array element.

   ```javascript
   let ls = ["a", "b"];
   ls.forEach((item) => console.log(item));

   //output
   //a
   //b
   ```

   - **.every() and .some()**: The `every()` method tests whether all elements in the array pass the test set by the callback function. It returns a Bool. The `some()` method tests whether at least one element in the array passes the test set in the callback function. It also returns a Bool.

   ```javascript
   //every()
   let ls1 = [1, 4, 5, 7, 9];
   let ls2 = [1, 4, 5, 20, 9];

   // callback will return true if an item is less than 10
   ls1.every((item) => item < 10); // returns true
   ls2.every((item) => item < 10); // returns false

   //some()
   let ls1 = [1, 4, 5, 7, 9];
   let ls2 = [1, 3, 5, 7, 9];

   // callback will return true if at-lease on even number is present
   ls1.some((item) => item % 2 === 0); // returns true
   ls2.some((item) => item % 2 === 0); // returns false
   ```

   - **.sort()**: The sort() method sorts the elements of an array in place and returns the sorted array, default is in ascending order. Elements are first converted into strings and comparison is done on UTF-8 unit values.

   - **.reduce()**: The reduce() method executes a reducer function as a callback on each element of the array, resulting in a single output value.

   ```javascript
   let array1 = [1, 2, 3, 4];
   let reducer = (accumulator, currentValue) => accumulator + currentValue;
   console.log(array1.reduce(reducer));
   let arr = [
     { id: 1, price: 10 },
     { id: 2, price: 20 },
     { id: 3, price: 30 },
   ];

   let reducer = (accumulator, currentValue) => ({
     totalPrice: accumulator.totalPrice + currentValue.price,
   });
   // passing a default value to the accumulator
   arr.reduce(reducer, { totalPrice: 0 });
   ```

   - **.includes()**: The includes() checks to see if an elements exists in an array; returns bool.

   ```javascript
   let arr = ["apple", "orange", "mango"];
   console.log(arr.includes("orange")); // true
   console.log(arr.includes("strawberry")); // false
   ```

   - **.splice()**: The splice() method allows us to remove, add or modify elements of an array in-place. Parameters: (1. Index, 2. Delete Count, 3. New Elements to be added.)

   ```javascript
   let fruits = ["Apple", "Orange", "Mango"];

   // when we want to add something, we specify delete count 0
   fruits.splice(1, 0, "Strawberry"); // ['Apple', 'Strawberry' ,'Orange', 'Mango']
   // removing element at index 3
   fruits.splice(3, 1); // ['Apple', 'Strawberry' ,'Orange']
   // replacing element
   fruits.splice(2, 1, "Melon"); // ['Apple', 'Strawberry' ,'Melon']
   // adding multiple items
   fruits.splice(0, 0, "Watermelon", "Date"); // ['Watermelon', 'Date' ,'Apple', 'Strawberry' ,'Orange']
   ```

   - **.concat()**: The concat() method is used to add data to an array. It can also be used to merge two arrays. This method does not change the existing arrays, but instead returns a new array.

   ```javascript
   let a = [1, 2, 3];
   let b = 4;
   let c = a.concat(b); // [1, 2, 3, 4]
   ```

   - **.push() and .pop()** : `push()` add, `pop()` remove from the end.

   ```javascript
   let fruits = ["Apple", "Orange", "Mango"];
   fruits.push("Melon"); // ['Apple', 'Orange', 'Mango', Melon]
   let length = fruits.push("Date", "Strawberry"); // ['Apple', 'Orange', 'Mango', Melon, 'Date', 'Strawberry']

   // removing element from the end
   fruits.pop(); // ['Apple', 'Orange', 'Mango', Melon, 'Date']
   ```

   - **.shit() and .unshift()**: The shift() method removes the first element from original array and returns that removed element. The shift() method adds an element to the start of the original array and returns the length of the array.

   ```javascript
   let fruits = ["Apple", "Orange", "Mango"];
   fruits.shift(); // ['Orange', 'Mango']

   fruits.unshift("Date", "Melon"); // ['Date', 'Melon', 'Orange', 'Mango']
   ```

**5. Destructuring Assignment:** A syntax that makes it possible to unpack values from arrays or properties from objects into distinct variables. (Basically assign variables).

```javascript
//Before:
const vehicles = ["mustang", "f-150", "expedition"];
const car = vehicles[0];
const truck = vehicles[1];
const suv = vehicles[2];

/*------------------------------------------------------*/

//With Destructuring
const vehicles = ["mustang", "f-150", "expedition"];

const [car, truck, suv] = vehicles;
```

**6. Modules:** JavaScript modules allow you to break up your code into separate files. Use `import` and `export`.

```javascript
export const name = "Jesse";
export const age = 40;

/* OR */
const name = "Jesse";
const age = 40;

export { name, age };

/* OR */
const message = () => {
  const name = "Jesse";
  const age = 40;
  return name + " is " + age + "years old.";
};

export default message;
```

**7. Ternary Operator:** replacing if/else using ?/:

```javascript
if (authenticated) {
  renderApp();
} else {
  renderLogin();
}

/* TO */

authenticated ? renderApp() : renderLogin();
```

**8. Spread Operator:** The JavaScript spread operator (...) allows us to quickly copy all or part of an existing array or object into another array or object.

```javascript
const numbersOne = [1, 2, 3];
const numbersTwo = [4, 5, 6];
const numbersCombined = [...numbersOne, ...numbersTwo];

/* ---- */

const myVehicle = {
  brand: "Ford",
  model: "Mustang",
  color: "red",
};

const updateMyVehicle = {
  type: "car",
  year: 2021,
  color: "yellow",
};

const myUpdatedVehicle = { ...myVehicle, ...updateMyVehicle };

/* ---- */
const numbers = [1, 2, 3, 4, 5, 6];

const [one, two, ...rest] = numbers;
```

**9. Template Literals:** Allows for embedded expressions and multi-line strings using backticks (``).

```javascript
const name = "World";
console.log(`Hello, ${name}!`); // "Hello, World!"
```

**Question: What is the difference between setTimeout(), Promise, and async/await? Provide an example of how each is used.**

- `setTimeout()`: A function that executes a piece of code after a specified delay.

```javascript
setTimeout(() => console.log("This prints after 2 seconds"), 2000);
```

- Promise: An object representing the eventual completion or failure of an asynchronous operation. It allows you to write asynchronous code in a more manageable way.

```javascript
new Promise((resolve, reject) => {
  // Asynchronous operation
  resolve("Success");
});
```

- async/await: Syntactic sugar built on top of Promises, making asynchronous code look more like synchronous code.

```javascript
async function fetchData() {
  let data = await someAsyncDataFunction();
  console.log(data);
}
```

**Question: Explain what the Document Object Model (DOM) is and how you can manipulate it using JavaScript.**

- The Document Object Model (DOM) is a programming interface for web documents. It represents the page so that programs can **change the document structure, style, and content.** JavaScript can be used to manipulate the DOM by **selecting, adding, deleting, and modifying elements.**

**Question: What are media queries, and how are they used in responsive web design?**

- Media queries are a CSS technique introduced in CSS3. They allow content rendering to adapt to conditions such as screen resolution (e.g., smartphone screen vs. desktop monitor).

```javascript
@media (min-width: 600px) {
  .example {
    background-color: blue;
  }
}
```

**Question: Describe the CSS box model and explain each component that makes up the box model.**

- Describes the design and layout of elements on a web page. It consists of:

1. Margins: The outermost layer, the space between the border and the neighboring elements.
2. Borders: Surrounds the padding and content. The border's size contributes to the overall dimensions of the element.
3. Padding: The space between the border and the content.
4. Content: The actual content of the box, where text and images appear.

**Question: Compare and contrast Angular and React. What are the key differences, and when might you choose one over the other?**

- Angular: MVC framework to build web applications.
- React: Library focused on building user interface, the view layer.

**Question: Explain the concept of state in React. How does Redux help manage state in a React application?**

- State in React is an object that determines how that component renders & behaves.
- Redux provides a centralized store for state that can be accessed throughout the application, making it easier to manage state.

**Question: What are components in Angular, and how do they communicate with each other?**

- Components are the basic building blocks of Angular applications. They control a patch of screen called a view. Angular components have a template for their HTML part, a class to handle business logic, and styling information. Components communicate with each other using inputs (to pass data to a child component) and outputs (to emit events from a child to a parent component).

**Question: What is a closure in JavaScript?**

- A closure is a function that remembers the variables from the place where it is defined, regardless of where it is executed later. They allow for the encapsulation of variables and functions, keeping them private and protected from the global scope.

```javascript
function makeAdder(x) {
  return function (y) {
    return x + y;
  };
}

const add5 = makeAdder(5);
console.log(add5(2)); // 7
```

**Question: Explain event bubbling and capturing.**

Event bubbling and capturing are two ways of event propagation in the HTML DOM API when an event occurs in an element inside another element.

- Event Bubbling: In event bubbling, the event is first captured and handled by the innermost element and then propagated to outer elements.

- Event Capturing (Event Trickling): In event capturing, the event is first captured by the outermost element and propagated to the inner elements.

**Question: What is `this` keyword in JavaScript?**
The `this` keyword in JavaScript refers to the object it belongs to. It has different values depending on where it is used:

- In a method, `this` refers to the owner object.
- Alone, `this` refers to the global object.
- In a function, `this` refers to the global object.
- In an event, `this` refers to the element that received the event.
- In strict mode, `this` in functions is undefined.
