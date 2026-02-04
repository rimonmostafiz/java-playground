```java
public interface Comparable<T> {
    int compareTo(T o);
}
```
## Three possible return values
1. **Negative value** Argument object is greater than this object
2. **Positive value** Argument object is lesser than this object
3. **Zero** They are both the same

```java
import com.rimonmostafiz.java.collection.exercises.objectordering.comparable.Person;

// given that id is an int
public int compareTo(Person o) {
    return this.id - o.id;
}
```
### What is problem with the above implementation? <br>
It can cause overflow error
- this.id is negative and close to INT_MIN
- o.id is negative and this.id is close to INT_MAX

So the best approach is to use the in-built compare method of the class, example
```java
    @Override
    public int compareTo(Person o) {
        return Integer.compare(this.age, o.age);
    }
```
### Reverse order sorting using comparable
If we switch the order of the argument in Integer.compare() then the order will switch
```java
    // this will sort from smaller to greater
    @Override
    public int compareTo(Person o) {
        return Integer.compare(this.age, o.age);
    }

    // this will sort from greater to smaller
    @Override
    public int compareTo(Person o) {
        return Integer.compare(o.age, this.age);
    }
```