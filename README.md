# Bookshelf_Keeper
 
**Description**:
This is a program to interact with a bookshelf-keeper, that maintains a shelf of books in increasing order by height. The program enables users to perform a series of put and pick operations via a BookshelfKeeper object. The pick operation refers to a case where you need to pick a book from a given position (index), and the put operation refers to putting a book of given height on the shelf, such that the bookshelf remains sorted after completing any operation.

The user input consists of the initial state of our bookshelf and a series of pick and put operations to perform; for each operation it will print out the contents of the updated bookshelf, the number of lower-level book-moving operations used, and the total number of lower-level operations used since the start of the program. More details below.


Upon running the program, initializing a bookshelf (array of sorted integers), and doing pick/put operations, you will see an example like the following:

Please enter initial arrangement of books followed by newline:

1 2 3 4

[1, 2, 3, 4] 0 0

Type pick <index> or put <height> followed by newline. Type end to exit.

pick 3

[1, 2, 3] 1 1

put 3

[1, 2, 3, 3] 1 2


**Notes**:
There are three classes in this program, Bookshelf, BookshelfKeeper, and BookshelfKeeperProg:

Bookshelf:
The Bookshelf class abstracts the idea of having multiple books on a bookshelf in any order: so books don’t fall over, books on a Bookshelf can only be inserted or removed at either of the ends, although you can look at any book on a bookshelf. Books are identified only by their height.  You can think of two books of the same height as just being two copies of the same book.

BookshelfKeeper:
The BookshelfKeeper class contains a Bookshelf and has the pick and put operations: these are implemented using the minimal number of Bookshelf mutator calls such that it keeps the underlying bookshelf sorted by the height of the books.

BookshelfKeeperProg:
The BookshelfKeeperProg contains the main method and is responsible for reading user input and printing results. It allows the user to perform a series of pickPos and putHeight operations on a bookshelf in an interactive mode with user commands called pick and put. It can also be run in a batch mode by using input and output redirection. Batch testing can executed using the command: 
java -ea BookshelfKeeperProg < inputFile > yourOutputFile.
Then, once your output file is generated, compare it with the provided output file using the Linux diff command. The statement below should produce no output if your program works correctly:
diff yourOutputFile providedOutputFile.
For example for the test file provided with name test1, you will do something like the following:
        
      java -ea BookshelfKeeperProg < test/test1 > myout1.out

      diff myout1.out test/test1.out