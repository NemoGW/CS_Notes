# Leetcode 752. Open the Lock

## Link to the questions

[Leetcode 752. Open the Lock](https://leetcode.com/problems/open-the-lock/description/)

## Question description

You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.

The lock initially starts at '0000', a string representing the state of the 4 wheels.

You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.

Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.

```
Example 1:
    Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
    Output: 6
    Explanation:A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202". Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid, because the wheels of the lock become stuck after the display becomes the dead end "0102".

Example 2:
    Input: deadends = ["8888"], target = "0009"
    Output: 1
    Explanation: We can turn the last wheel in reverse to move from "0000" -> "0009".

Example 3:
    Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
    Output: -1
    Explanation: We cannot reach the target without getting stuck.
```

Constrains:

- 1 <= deadends.length <= 500
- deadends[i].length == 4
- target.length == 4
- target will not be in the list deadends.
- target and deadends[i] consist of digits only.

## Problem solving thought process

To start off the question, we just need to find all the possible combinations until it matches the target. To do so, we can image that:

Starting at '0000' and rotate the weel once. We will be getting '0001', '0010', '0100', '1000', '9000', '0900', '0090', '0009'. Total of **8** combinations. And so on, for all these 8 combinations, when you rotate them again, you will be getting another 8 combinations. And the question is asking you to find the minimum rotations - this is a classic BFS problem.

## Code and Explanation

We can start off the question by implementing the BFS algo first, and then modify it.

- if deadlock is meet -> exit the forloop.

```java
//rotating upward
public String add(String s, int i){
    char[] c = s.toCharArray();
    if(c[i] == '9'){
        c[i] = '0';
    } else {
        c[i] += 1;
    }

    return new String(c);
}

//rotating downward
public String minus(String s, int i){
    char[] c = s.toCharArray();
    if(c[i] == '0'){
        c[i] = '9';
    } else {
        c[i] -= 1;
    }

    return new String(c);
}

//bfs
public int openLock(String[] deadends, String target) {
    Queue<String> q = new LinkedList<>();
    Set<String> deads = new HashSet<>();
    Set<String> visited = new HashSet<>();

    for(String s : deadends){
        deads.add(s);
    }

    q.offer("0000");
    visited.add("0000");

    int steps = 0;

    while(!q.isEmpty()){
        int size = q.size();
        for(int i=0; i<size; i++){
            String cur = q.poll();
            if(deads.contains(cur)){
                continue;
            }
            if(target.equals(cur)){
                return steps;
            }

            for(int j=0; j<4; j++){
                String up = add(cur, j);
                if(!visited.contains(up)){
                    q.offer(up);
                    visited.add(up);
                }
                String down = minus(cur, j);
                if(!visited.contains(down)){
                    q.offer(down);
                    visited.add(down);
                }
            }
        }

        steps++;
    }
}
```
