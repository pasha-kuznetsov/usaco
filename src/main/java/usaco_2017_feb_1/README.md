# USACO 2017 February Contest, Platinum

## Problem 1. Why Did the Cow Cross the Road

Why did the cow cross the road? We may never know the full reason, but it is 
certain that Farmer John's cows do end up crossing the road quite frequently. 
In fact, they end up crossing the road so often that they often bump into 
each-other when their paths cross, a situation Farmer John would like to remedy.

Farmer John raises `NN` breeds of cows (`1 ≤ N ≤ 100,000`), 
and each of his fields is dedicated to grazing for one specific breed; 
for example, a field dedicated to breed 12 can only be used for cows of breed 12 
and not of any other breed. A long road runs through his farm. 

There is a sequence of `N` fields on one side of the road (one for each breed), 
and a sequence of `N` fields on the other side of the road (also one for each breed). 
When a cow crosses the road, she therefore crosses between the two fields 
designated for her specific breed.

Had Farmer John planned more carefully, he would have ordered the fields by breed 
the same way on both sides of the road, so the two fields for each breed would be 
directly across the road from each-other. This would have allowed cows to cross 
the road without any cows from different breeds bumping into one-another. 

Alas, the orderings on both sides of the road might be different, 
so Farmer John observes that there might be pairs of breeds that cross. 
A pair of different breeds `(a,b))` is "crossing" if any path across the road 
for breed `a` must intersect any path across the road for breed `b`.

Farmer John would like to minimize the number of crossing pairs of breeds. 
For logistical reasons, he figures he can move cows around on one side of the road 
so the fields on that side undergo a "cyclic shift". That is, for some `0 ≤ k < N`,
every cow re-locates to the field `k` fields ahead of it, with the cows in the last 
`k` fields moving so they now populate the first `k` fields. 

For example, if the fields on one side of the road start out ordered by breed as 
`3, 7, 1, 2, 5, 4, 6` and undergo a cyclic shift by `k=2`, the new order will be 
`4, 6, 3, 7, 1, 2, 5`.

Please determine the minimum possible number of crossing pairs of breeds that can 
exist after an appropriate cyclic shift of the fields on one side of the road.

### Input format (file mincross.in)

* The first line of input contains `N`. 
* The next `N` lines describe the order, by breed ID, 
of fields on one side of the road; each breed ID is an integer in the range `1…N`.
* The last `N` lines describe the order, by breed ID, 
of the fields on the other side of the road.

### Output format (file mincross.out)

Please output the minimum number of crossing pairs of breeds after a cyclic shift 
of the fields on one side of the road (either side can be shifted).

### Sample input

```
5
5
4
1
3
2
1
3
2
5
4
```

### Sample output

```
0
```

> **Problem credits:** Brian Dean

## Implementation

* Renumber the 2nd sequence in terms of positions of the 1st one.
* Count inversions using modified merge sort.
* Apply shifts by accounting for the following property of the renumbered 
sequence. When an item is moved item the start of the sequence to the back:
    * It adds this many inversions: `N - pos - 1`
    * It subtracts this many inversions: `pos` 
    * For example:
        ```
        2 3 4 5 1 0
        ```
        Moving 2 to the back of the sequence:
        ```
        3 4 5 1 0 2 
        ```
        * `2` is now coming after `3`, `4` and `5` (`+ N - pos - 1` inversions)
        * `2` is no longer preceding `1` and `0` (`- pos` inversions)
* Repeat the above for the 1st sequence remapped by 2nd positions
  and select the best result between the two.

> **See also:** Editorial solution description at [USACO](http://usaco.org/current/data/sol_mincross_platinum_feb17.html).

## Tests

> **See:** [test/groovy/usaco_2017_feb_1](../../../test/groovy/usaco_2017_feb_1)

![Result](../../resources/usaco_2017_feb_1/result.png)
