## `Interface Comparable<T>`
This interface imposes a total ordering on the objects of each class that implements it. This ordering is referred to as the class's natural ordering, and the class's compareTo method is referred to as its natural comparison method.
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


## `Interface Comparator<T>`
```java
@FunctionalInterface
public interface Comparator<T> {
    int compare(T o1, T o2);
}
```
A comparison function, which imposes a total ordering on some collection of objects. Comparators can be passed to a sort method (such as Collections.sort or Arrays.sort) to allow precise control over the sort order. Comparators can also be used to control the order of certain data structures (such as sorted sets or sorted maps), or to provide an ordering for collections of objects that don't have a natural ordering.<br>

Sometimes what we're comparing depends on context <br>
Let's say we're soring a Student Class, we can't always relay on ordering based on id, for example we might need
- **By grade** for ranking
- **By height** for physical training exercises
- **By name** for attendance

But there is oly one **compareTo()** method!
The solution to this problem is The Comparator interface which can act as a third party comparator which Take two object of a same type.<br>
As this is kinda **Third Party** comparator we can have multiple implementation of the comparator of same type.

NOTE: Also as this is a @FunctionalInterface we can pass lambda and create our own comparator without creating a class.