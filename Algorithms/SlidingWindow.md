## Sliding window

Sliding window is simply using two pointers to maintain a "window", slide it through the array and update the answer.

### Algo sudo code

```java
int left = 0, right = 0;

while(left < right && right < s.size()){

    //make window bigger
    window.add(s[right]);
    right++;

    while(window needs shrink){
        window.remove(s[left]);
        left++;
    }
}
```

The time-complexity for this method is about O(N)

### Updated Algo sudo code

```java
void slidingWindow(string s) {
    // use properate data structure
    unordered_map<char, int> window;

    int left = 0, right = 0;
    while (right < s.size()) {
        // c is the charater that will be entering the window
        char c = s[right];
        window.add(c)
        // sliding right (window bigger)
        right++;
        // update data
        ...

        /*** debug place ***/

        printf("window: [%d, %d)\n", left, right);
        /********************/

        // if left window needs shrink
        while (left < right && window needs shrink) {
            // d remove d outof window
            char d = s[left];
            window.remove(d)
            // shrink window
            left++;
            // update data
            ...
        }
    }
}
```
