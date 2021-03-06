# USACO 2017 February Contest, Platinum

## Problem 2. Why Did the Cow Cross the Road II

Farmer John is continuing to ponder the issue of cows crossing the road through his farm, 
introduced in the preceding problem. He realizes that interaction between some pairs of breeds 
is actually acceptable if the breeds are friendly, a property that turns out to be easily 
characterized in terms of breed ID: breeds `a` and `b` are friendly if `|a−b| ≤ 4`, 
and unfriendly otherwise. It is ok for cows to wander into fields designated for other breeds, 
as long as they are friendly.

Given the ordering of `N` fields on both sides of the road through FJ's farm (again, 
with exactly one field for each breed on each side), please help FJ determine the maximum number 
of crosswalks he can draw over his road, such that no two intersect, and such that each crosswalk 
joins a pair of fields containing two breeds that are friendly. Each field can be accessible via 
at most one crosswalk (so crosswalks don't meet at their endpoints).

### Input format (file `nocross.in`)

* The first line of input contains `N` (`1 ≤ N ≤ 100,000`). 
* The next `N` lines describe the order, by breed ID, of fields on one side of the road; 
    each breed ID is an integer in the range `1…N`.
* The last `N` lines describe the order, by breed ID, of the fields on the other side of the road.
* Each breed ID appears exactly once in each ordering.

### Output format (file `nocross.out`)

Please output the maximum number of disjoint "friendly crosswalks" Farmer John can draw across the road.

### Sample input

```
6
1
2
3
4
5
6
6
5
4
3
2
1
```

### Sample output

```
5
```

> **Problem credits:** Brian Dean

## Implementation

> **See:** Editorial solution description at [USACO](http://usaco.org/current/data/sol_nocross_platinum_feb17.html).

## Tests

> **See:** [test/groovy/usaco_2017_feb_2](../../../test/groovy/usaco_2017_feb_2)
