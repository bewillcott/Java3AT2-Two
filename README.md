
# Java3 AT2 Question 2
This is a TAFE assignment for the Diploma in Software Development, at the South Metropolitan TAFE,
Rockingham, Western Australia.

The project task is to develop a mechanical parts list,
to use at Jupiter Mining Corporation (a fake business entity).

A balanced binary search tree (BBST) needs to be created/developed, for a dictionary
of no less than 10 words.  It must be possible to search the list, and add
and remove from the list.

## Implementation
This project consists of four sub-projects within the one Visual Studio session:

- ConsoleAppTest
- MyNETCoreLib
- MyWpfNETCoreLib
- Prog3AT2-Two

### ConsoleAppTest
This is a small console application that uses a fixed set of names to test the required 
functionality of the Balanced Binary Search Tree (BBST).

### MyNETCoreLib
This is a Class Library that contains the BBST: `AvlTree<T>` and the
`ObservableAvlTree<T>`.

### MyWpfNETCoreLib
This is a WPF Class Library that contains a helper console window:
`LogConsole` and a supporting class: `TextBlockOutputter`.
Together they provide a means to redirect the `Console.Write{Line}()`
output to a window for easier debugging.

### Prog3AT2-Two
This is the GUI program that provides the means to utilize the BBST in
a more meaningful way.  It has buttons to Add, Remove and Search a
list of strings, displayed in a ListBox.
