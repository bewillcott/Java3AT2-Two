
# Java3 AT2 Question 2
This is a TAFE assignment for the Diploma in Software Development, at the South Metropolitan TAFE,
Rockingham, Western Australia.

The project task is to develop a mechanical parts list,
to use at Jupiter Mining Corporation (a fake business entity).

A balanced binary search tree (BBST) needs to be created/developed, for a dictionary
of no less than 10 words.  It must be possible to search the list, and add
and remove from the list.

## Implementation
This project consists of 2 sub-projects within the aggregator project:

- Common
- ConsoleApp

By developing it this way, it would be possible to develop another application, say a GUI one,
within the same aggregate project using the same _Common_ library classes.

### Common
This is a non-executable jar, containing a collection of classes that are in 'common' use across 
multiple projects.  It contains the Balanced Binary Search Tree (BBST): `AvlTree<E>`and the 
`MechanicalPart` classes.

### ConsoleApp
An application that shows how the `AvlTree<E>` class can be used. Ten `MechanicalPart`s are created
and stored in the `AvlTree<E>` object, then one is searched for, removed and added again 
(twice! - maybe).
