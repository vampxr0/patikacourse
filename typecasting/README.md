# 🔄Type Casting in Java

Type casting means converting one data type into another.

There are two main types:

## 1. Implicit Casting (Widening)
Java does this automatically.

```java
int a = 0;
double b = a;  // int → double (no error)
```

## Explicit Casting (Narrowing)
You must do this manually.
```java
double x = 0.5;
int y = (int) x;  // double → int (needs casting)
```
In this code we have done conversions from int to double and double to int.