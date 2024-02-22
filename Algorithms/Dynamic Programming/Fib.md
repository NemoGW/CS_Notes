# Fibonacci sequence

is a sequence in which each number is the sum of the two preceding ones. Numbers that are part of the Fibonacci sequence are known as Fibonacci numbers

e.g.
fib(n): 0 1 1 2 3 5 8 13 21

Recursively:
how to find fib(6)?
fib(6) = fib(5) + fib(4)

exponential O(2^n)
this is nailing down to the bottom of fib(4) -> fib(2) + fib(1) -> fib(1) -> fib(0)

```java
public int fib(int n){
    if(n==0 || n==1){
        return n;
    }

    return fib(n-1) + fib(n-2);
}
```

needs a memo
this ill store fib(4), so when looking for fib(5) -> we already have fib(4) stored in hashmap

```java
public int fib(int n, HashMap<Integer, Integer> memo){
    if(n==0 || n==1){
        return n;
    }

    if(memo.containsKey(n)){
        return memo.get(n);
    }

    int result fib(n-1, memo) + fib(n-2,memo);
    memo.put(n, result);
    return result;
}

public int fib(int n){
    return fib(n, new HashMap<>());
}
```
