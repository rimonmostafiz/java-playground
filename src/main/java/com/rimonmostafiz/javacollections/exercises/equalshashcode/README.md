## The equals contract

- Reflexivity
    - an object should be equal to itself
- Symmetry
    - if x is equals to y, then y should also be equlas to x
- Transitivity
    - if x is equal to y and y is equal to z, then x should also be equal to z
- Consistency
    - should return the same result unless the state of the object has been modified
- Non-nullity
    - an object should never be considered equal to null

## An equals implementation

```java

import java.util.Objects;

public class Person {
    int age;
    String name;

    @Override
    public boolean equals(Object obj) {
        Person person = (Person) obj;
        return age == person.age && name == person.name;
    }
}
```

What is wrong with `return age == person.age && name == person.name;`?

- This might work or might not work!! <br>
- As `name` is String and `==` on String check the reference only. <br>
- So if `name` and `person.name` is same reference then this will pass and return `true`. <br>
- Otherwise, if they are different references but the value is same then this will return `false`. <br>

So to fix that we can write

```java
    @Override
    public boolean equals(Object obj) {
        Person person = (Person) obj;
        return age == person.age && name.equals(person.name);
    }
```

This might also not work as `name` can be null!! <br>
And we might get a **NullPointerException**, so we've to add null check!

```java
    @Override
    public boolean equals(Object obj) {
        Person person = (Person) obj;
        return age == person.age 
                && name != null
                && name.equals(person.name);
    }
```

Now what is problem with above version? <br>

- The Problem is with this line `Person person = (Person) obj;`
- We are assuming obj is always Person, it can be a Cat or a Vehicle
- So we should be careful while casting obj to Person
  A BETTER version should be

```java
        if (this == obj) {
            return true;
        } 
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Person person = (Person) obj;
```

On this version we're checking

- If both then instances are same reference then there is noting to check we can return true
- Then we're checking, if obj is null -- Non-nullity Rules(an object should never be considered equal to null)
- We should never call equal method on a null object that will cause a NullPointerException
- The next comparison is if they are not same type, then they can't be equal at all
  So after those two check it is safe to cast obj to Person.

Now our equals method version looks something like

```java
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Person person = (Person) obj;
        
        return age == person.age 
                && name != null
                && name.equals(person.name);
    }
```

Now above will work, we can still do a slight modification and make it better

```java
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Person person = (Person) obj;
        
        return age == person.age 
                && objects.equals(name, person.name);
    }
```

This one is a better version which protects against null <br>
**NOTE:** One thing to keep in mind is if name is a custom class that we've implemented, then we have to make sure it
has an equal implementation for this to work.