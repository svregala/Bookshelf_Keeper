// Name: Steve Regala
// USC NetID: sregala
// CSCI455 PA2
// Fall 2021

import java.util.ArrayList;

public class BookshelfTester {

   public static void main(String[] args)
   {

      // EXERCISE 2:

      // test constructor w/o input parameter & toString method
      Bookshelf bookList1 = new Bookshelf();
      System.out.println("TESTING constructor with no input parameter (bookList1) -->");
      System.out.println("Expected: []");
      System.out.println("Actual: " + bookList1.toString());
      System.out.println();

      // test constructor with input parameter & toString method
      ArrayList<Integer> testArrayList = new ArrayList<Integer>();
      testArrayList.add(2);
      testArrayList.add(8);
      testArrayList.add(10);
      testArrayList.add(43);
      testArrayList.add(21);
      Bookshelf bookList2 = new Bookshelf(testArrayList);
      System.out.println("TESTING constructor with input parameter (bookList2) -->");
      System.out.println("Expected: [2, 8, 10, 43, 21]");
      System.out.println("Actual: " + bookList2.toString());
      System.out.println();


      // EXERCISE 3
      // test addFront(int height), addLast(int height), removeFront(), removeLast() ----
      // addFront to an empty Bookshelf object
      System.out.println("TESTING addFront -->");
      System.out.println("Adding 54 and then 3 in front of bookList1..");
      bookList1.addFront(54);
      bookList1.addFront(3);
      System.out.println("Expected: [3, 54]");
      System.out.println("Actual: " + bookList1.toString());

      // addFront to bookList2
      System.out.println("Adding 500 in front of bookList2..");
      bookList2.addFront(500);
      System.out.println("Expected: [500, 2, 8, 10, 43, 21]");
      System.out.println("Actual: " + bookList2.toString());
      System.out.println();

      // addLast to bookList1
      System.out.println("TESTING addLast -->");
      System.out.println("Adding 78 to the end of bookList1..");
      bookList1.addLast(78);
      System.out.println("Expected: [3, 54, 78]");
      System.out.println("Actual: " + bookList1.toString());
      System.out.println();

      // removeFront() to bookList2
      System.out.println("TESTING removeFront and that it prints what was removed -->");
      System.out.println("Removing front of bookList2: " + bookList2.removeFront());
      System.out.println("Expected: [2, 8, 10, 43, 21]");
      System.out.println("Actual: " + bookList2.toString());
      System.out.println();

      // removeLast() to bookList2
      System.out.println("TESTING removeLast and that it prints what was removed -->");
      System.out.println("Removing last of bookList2: " + bookList2.removeLast());
      System.out.println("Expected: [2, 8, 10, 43]");
      System.out.println("Actual: " + bookList2.toString());
      System.out.println();


      // EXERCISE 4
      // test getHeight(int position), size(), isSorted() ----
      // getHeight on bookList2
      System.out.println("TESTING getHeight on bookList2: position 0 & position 2 -->");
      System.out.println("Expected: 2");
      System.out.println("Actual: " + bookList2.getHeight(0));
      System.out.println("Expected: 10");
      System.out.println("Actual: " + bookList2.getHeight(2));
      System.out.println();

      // size on bookList2
      System.out.println("TESTING size on bookList2 -->");
      System.out.println("Expected: 4");
      System.out.println("Actual: " + bookList2.size());
      System.out.println();

      // isSorted on bookList1
      System.out.println("TESTING isSorted on bookList1 after adding 6 at the end -->");
      bookList1.addLast(6);
      System.out.println("Expected: false");
      System.out.println("Actual: " + bookList1.isSorted());
      System.out.println();

      // isSorted on bookList2
      System.out.println("TESTING isSorted on bookList2 -->");
      System.out.println("Expected: true");
      System.out.println("Actual: " + bookList2.isSorted());
      System.out.println();

      // print the contents of bookList1 and bookList2
      System.out.println("bookList1 object holds: " + bookList1.toString());
      System.out.println("bookList2 object holds: " + bookList2.toString());
      System.out.println();
      // bookList1 -> [3, 54, 78, 6]
      // bookList2 -> [2, 8, 10, 43, 21]


      // ---------------------------------------------------------

      // NOW TESTING ASSERT IMPLEMENTATION TEST
      ArrayList<Integer> testArrayList2 = new ArrayList<Integer>();
      testArrayList2.add(5);
      testArrayList2.add(11);
      testArrayList2.add(3);
      Bookshelf bookList3 = new Bookshelf(testArrayList2);
      System.out.println("bookList3 object holds: " + bookList3.toString());

      // bookList3.addFront(-2);
      /*
      Exception in thread "main" java.lang.AssertionError
        at Bookshelf.addFront(Bookshelf.java:67)
        at BookshelfTester.main(BookshelfTester.java:123)
       */

      //bookList3.addLast(-4);
      /*
      Exception in thread "main" java.lang.AssertionError
        at Bookshelf.addLast(Bookshelf.java:80)
        at BookshelfTester.main(BookshelfTester.java:130)
       */

      /*
         don't need to test remove with -ea because program will crash if
         it includes a negative number or it when it tires to add a
         negative number
         remaining to be tested: removeFront, removeLast, getHeight, size, toString, isSorted
         Follow-up question: would the assert statement be needed to all methods?
       */
   }
}