# Recursive Prime Number Checker

This project checks if a number is **prime** or not using a **recursive method** in Java.

## What It Does

- Starts checking from number 2.
- Only divides by **prime numbers**.
- If the number can be divided, it is **not prime**.
- Uses recursion until the square of the divisor is greater than the number.

## Example

```java
int input = 191;
System.out.println(isPrime(input, 2)); // true
```