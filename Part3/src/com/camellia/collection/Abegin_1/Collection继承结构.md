---
title: Collection继承结构
date: 2024-06-08 22:56:02
tags:
categories:
   - Java SE
---



# Collection继承结构

1. `SequencedCollection `和` SequencedSet` 是 Java 21 中新增的接口。
   - `SequencedCollection `是一个扩展自 `Collection `的接口，==表示元素是有顺序的集合==。
   - `SequencedSet `是一个扩展自` Set `的接口，同时也扩展了` SequencedCollection `接口。这意味着` SequencedSet `==不仅是一个无重复元素的集合，并且这些元素是有顺序的==。
2.  ==6个实现类中只有`HashSet`是无序集合。==剩下的都是有序集合。
- **有序集合**： 集合中存储的元素具有明确的顺序，可以通过下标访问，或者元素是按照某种排序规则排列的。
- **无序集合**： 集合中存储的元素没有明确的顺序，无法通过下标访问，也不按照任何排序规则排列。



## 一、每个集合对应实现类的数据结构

### 1.1 有序集合

1. **LinkedList**：
   - **数据结构**：双向链表。
   - **用途**：支持在任意位置进行高效的插入和删除操作，但不专门设计为队列。尽管如此，由于其双向性质，它可以被用来实现队列等数据结构。

2. **ArrayList**：
   - **数据结构**：动态数组。
   - **特性**：支持快速的随机访问，但在数组容量不足时，需要动态扩展数组大小。

3. **Vector**：
   - **数据结构**：动态数组。
   - **特性**：与 `ArrayList` 类似，但同步化，适用于多线程环境。

4. **LinkedHashSet**：
   - **数据结构**：结合了哈希表和双向链表。
   - **特性**：维护元素的插入顺序，同时提供基于哈希表的高效查询能力。

5. **TreeSet**：
   - **数据结构**：基于红黑树的实现。
   - **特性**：自动排序，能够根据元素的自然顺序或自定义比较器来排序元素。

### 1.2 无序集合

1. **HashSet**：
   - **数据结构**：基于哈希表。
   - **特性**：元素的存储顺序不保证，因此是无序的。提供高效的查找、插入和删除操作。



## 二、List 与 Set 的可重复性

### 2.1 List 集合
- **特点**：`List` 接口<u>允许存储的元素是有序的，并且允许元素重复。</u>
- **索引**：元素在 `List` 中是有位置索引的，可以通过索引来访问元素。

### 2.2 Set 集合

- **特点**：`Set` 接口<u>存储的元素是唯一的（不可重复）。如果尝试添加重复的元素，集合会忽略这个操作。</u>



## 三、Collection继承结构图

<img src="https://camelliaxiaohua-1313958787.cos.ap-shanghai.myqcloud.com/asserts_JavaSE/202406082257104.png"  />

>  <a href ="https://github.com/camelliaxiaohua/JavaSE/blob/master/Part3/src/assert/Collection%E7%BB%A7%E6%89%BF%E7%BB%93%E6%9E%84%E5%9B%BE%EF%BC%88%E5%A4%A7%E5%9B%BE%EF%BC%89.png"  target="_blank">查看原图</a>
