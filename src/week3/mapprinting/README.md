# Map Types Comparison

This project compares the ordering and data storage characteristics of different `Map` implementations in Java.

## Map Types Used
- **HashMap**: Stores key-value pairs without any specific order. Insertion order is not preserved.
- **LinkedHashMap**: Stores key-value pairs **in the order they were inserted**.
- **TreeMap**: Sorts keys according to their natural ordering (alphabetical/numerical).

## Output Logic
- **HashMap** → Random order
- **LinkedHashMap** → Insertion order
- **TreeMap** → Natural ordering (alphabetical)
