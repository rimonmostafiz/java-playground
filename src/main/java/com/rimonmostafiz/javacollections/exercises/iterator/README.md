### Fail-fast iterators

- iterators not tolerant to underlying changes
- uses and internal modification counter
- throw **ConcurrentModificationException** if modified since last `next()`
- when we're using collections and in-between iteration if the collections is being modied then this happen
- the default iterator is fail-fast iterator

The java doc's says:<br>
**Fail-fast iterators throw ConcurrentModificationException on a _best-effort_ basis!!**

**What is this best-effort means here?**<br>
The best-effort means here is it is going try its best to alert you that something is wrong!
