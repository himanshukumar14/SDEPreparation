package DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a string expression of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators.
You may return the answer in any order.
The test cases are generated such that the output values fit in a 32-bit integer and the number of different results does not exceed 104.

Example 1:

Input: expression = "2-1-1"
Output: [0,2]
Explanation:
((2-1)-1) = 0
(2-(1-1)) = 2
Example 2:

Input: expression = "2*3-4*5"
Output: [-34,-14,-10,-10,10]
Explanation:
(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10

Constraints:

1 <= expression.length <= 20
expression consists of digits and the operator '+', '-', and '*'.
All the integer values in the input expression are in the range [0, 99].
 */

public class DifferentWaysToAddParentheses {

    /*
    The most difficult part is finding the pattern
I will set example to show the pattern I found:
Let's say 2-1-1+1, you can think it like a tree, every time when you read the operator you will split it into left part and right part:

iteration 1:
			2 - 1- 1 + 1
		   /   \
		  2 - (1-1+1)
		 /	   /  \
		2	- (1 - (1+1))

		then

			2 - 1- 1 + 1
		   /   \
		  2 - (1-1+1)
		 /	     /  \
		2 - ((1 -1)+1)

This give us
1.  2-(1 - (1+1))=3
2.  2 -(1 -1)+1))=1


iteration 2:
		2 - 1 - 1 + 1
		    /   \
		(2 -1)-(1 + 1)
this give us
1. (2-1)-(1+1) = -1

iteration 3:
			2 - 1- 1 + 1
				   /   \
		   (2 - 1 - 1) + 1
			 / \          \
		   (2 - (1 -  1)) +  1

		   then

		   2 - 1- 1 + 1
				   /   \
		   (2 - 1 - 1) + 1
			     / \      \
		 ((2 - 1) -  1) +  1
this give us
1. 2 - (1 -  1)) +  1=3
2. ((2 - 1) -  1) +  1=1

So the solution is [3,1,-1,3,1]

     */

    public List<Integer> diffWaysToCompute(String expression) {
        return recur(expression, new HashMap<>());
    }

    public List<Integer> recur(String input, Map<String, List<Integer>> mem) {
        if(mem.containsKey(input)) {
            return mem.get(input);
        }
        List<Integer> res = new ArrayList<>();
        int n = input.length();
        for(int i = 0; i < n; ++i) {
            char ch = input.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                List<Integer> left = recur(input.substring(0, i), mem);
                List<Integer> right = recur(input.substring(i + 1), mem);
                for(int l : left) {
                    for(int r : right) {
                        if(ch == '+')
                            res.add(l + r);
                        else if(ch == '-')
                            res.add(l - r);
                        else if(ch == '*')
                            res.add(l * r);
                        else if(ch == '/')
                            res.add(l / r);
                    }
                }
            }
        }
        if(res.size() == 0) {
            res.add(Integer.valueOf(input));
        }
        mem.put(input, res);
        return res;
    }
}
