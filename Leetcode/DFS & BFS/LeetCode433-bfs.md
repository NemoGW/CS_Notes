# Leetcode 433. Minimum Genetic Mutation

## Link to the questions

[Leetcode 433. Minimum Genetic Mutation](https://leetcode.com/problems/minimum-genetic-mutation/description/)

## Question description

A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.

Suppose we need to investigate a mutation from a gene string startGene to a gene string endGene where one mutation is defined as one single character changed in the gene string.

For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.

Given the two gene strings startGene and endGene and the gene bank bank, return the minimum number of mutations needed to mutate from startGene to endGene. If there is no such a mutation, return -1.

Note that the starting point is assumed to be valid, so it might not be included in the bank.

```
Example 1:
    Input: startGene = "AACCGGTT", endGene = "AACCGGTA", bank = ["AACCGGTA"]
    Output: 1

Example 2:
    Input: startGene = "AACCGGTT", endGene = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
    Output: 2
```

And the constrains are:

- 0 <= bank.length <= 10
- startGene.length == endGene.length == bank[i].length == 8
- startGene, endGene, and bank[i] consist of only the characters ['A', 'C', 'G', 'T'].

## Problem solving thought process

Looking at the problem, we can see that for the start mutation to the end string the following conditions are followed.

1. All characters are within 'A' 'C' 'G' 'T'
2. All mutations are stored in bank
3. There is only one single character different

And then the problem is to find the shortest path to the string.
To find shortest path we can use - BFS

## Code and Explanation

As what we disscused before we will be using backtracking algo to approach this problem.

```java
public int minMutation(String startGene, String endGene, String[] bank){

           //Queue to start each node
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<String>();

        List<String> banks = Arrays.asList(bank);

        int distance = 0;
        q.add(startGene);
        visited.add(startGene);

        while(!q.isEmpty()){

            int n = q.size();
            for(int i=0; i<n; i++){
                String s = q.poll();

                if(s.equals(endGene)) return distance;

                char[] c = s.toCharArray();
                for(int j=0; j<8; j++){
                    char tmp = c[j];
                    for(int k=0; k<4; k++){
                        c[j] = "ACGT".charAt(k);
                        String t = new String(c);

                        if(!visited.contains(t) && banks.contains(t)){
                            q.add(t);
                            visited.add(t);
                        }
                    }

                    c[j]=tmp;
                }
            }

            distance++;
        }
        return -1;
    }

}

```
