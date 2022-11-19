package BitManipulation;

/*
Stream of binary number is coming, the task is to tell the number formed so far is divisible by a given number n.
At any given time, you will get 0 or 1 and tell whether the number formed with these bits is divisible by n or not.
Generally, e-commerce companies ask this type of questions. It was asked me in Microsoft interview.
Actually that question was a bit simple, interviewer fixed the n to 3.
 */

import java.util.Scanner;

public class CheckDivisibilityInBinaryStream {

/*
In this solution, we just maintain the remainder if remainder is 0, the formed number is divisible by n otherwise not.
This is the same technique that is used in Automata to remember the state. Here also we are remembering the state of divisibility of input number.
In order to implement this technique, we need to observe how the value of a binary number changes, when it is appended by 0 or 1. Let’s take an example.
Suppose you have binary number 1. If it is appended by 0 it will become 10 (2 in decimal) means 2 times of the previous value.
If it is appended by 1 it will become 11(3 in decimal), 2 times of previous value +1.
How does it help in getting the remainder?
Any number (n) can be written in the form m = an + r where a, n and r are integers and r is the remainder.
So when m is multiplied by any number so the remainder. Suppose m is multiplied by x so m will be mx = xan + xr.
so (mx)%n = (xan)%n + (xr)%n = 0 + (xr)%n = (xr)%n;
We need to just do the above calculation (calculation of value of number when it is appended by 0 or 1 ) only over remainder.

When a binary number is appended by 0 (means
multiplied by 2), the new remainder can be
calculated based on current remainder only.
r = 2*r % n;

And when a binary number is appended by 1.
r = (2*r + 1) % n;
 */

    public static void CheckDivisibility(int n)
    {
        Scanner console = new Scanner(System.in);
        int remainder = 0;
        System.out.print("press any key other than 0 and 1 to terminate \n");
        while (true)
        {
            // Read next incoming bit via standard
            // input. 0, 00, 000.. are same as int 0
            // ans 1, 01, 001, 00..001 is same as 1.
            int incomingBit = console.nextInt();

            // Update remainder
            if (incomingBit == 1)
                remainder = (remainder * 2 + 1) % n;
            else if (incomingBit == 0)
                remainder = (remainder * 2) % n;
            else
                break;

            // If remainder is 0.
            if (remainder % n == 0)
                System.out.print("yes \n");
            else
                System.out.print("no \n");
        }
    }

    //Driver code
    public static void main(String[] args) {
        CheckDivisibility(3);
    }
}
