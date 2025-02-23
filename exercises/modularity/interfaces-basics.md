# Interfaces - Basics

In these exercises, you will learn how to identify the common interfaces that a set of classes should implement.

Note that, due to various historical reasons, these classes may not actually implement them in practice; we're asking you what they _should_ implement if you could design Java again without worrying about legacy code.


## Collections


Which interface(s) should the classes `ArrayList`, `HashSet`, and `ArrayDeque` all implement?

- [x] `Iterable`
- [ ] `Set`
- [ ] `Queue`
- [ ] `List`

Which interface(s) should the classes `ArrayList`, `Vector`, and `LinkedList` all implement?

- [x] `Iterable`
- [ ] `Set`
- [ ] `Queue`
- [x] `List`

Which interface(s) should the classes `ConcurrentLinkedQueue`, `AbstractSet`, and `Properties` all implement?

- [x] `Iterable`
- [ ] `Set`
- [ ] `Queue`
- [ ] `List`


## Files

Which interface(s) should the classes `BufferedReader`, `OutputStreamWriter` and `GZIPInputStream` all implement?

- [ ] `InputStream`
- [ ] `Readable`
- [ ] `Flushable`
- [x] `Closeable`

Which interface(s) should the classes `PrintStream`, `OutputStreamWriter` and `FilterWriter` all implement?

- [ ] `InputStream`
- [ ] `Readable`
- [x] `Flushable`
- [x] `Closeable`


## Various

Which interface(s) should the classes `Integer`, `Path` and `ZonedDateTime` all implement?

- [ ] `Iterable`
- [x] `Comparable`
- [ ] `Watchable`
- [x] `Serializable`

Which interface(s) should the classes `BigDecimal`, `ThaiBuddhistCalendar` and `java.util.regex.Pattern` all implement?

- [ ] `Iterable`
- [ ] `Comparable`
- [ ] `Watchable`
- [x] `Serializable`
