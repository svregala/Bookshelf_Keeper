// Name: Steve Regala
// USC NetID: sregala
// CSCI455 PA2
// Fall 2021

import java.util.ArrayList;

public class TestAssert {

   public static void main(String[] args) {

      ArrayList<Integer> arrList1 = new ArrayList<Integer>();
      arrList1.add(1);
      arrList1.add(4);
      arrList1.add(10);
      arrList1.add(35);
      Bookshelf newBookList1 = new Bookshelf(arrList1);
      // ^^^ SATISFIES PRECONDITION SO IT DOES NOT CRASH

      ArrayList<Integer> arrList2 = new ArrayList<Integer>();
      arrList2.add(1);
      arrList2.add(4);
      arrList2.add(-10);
      arrList2.add(35);
      Bookshelf newBookList2 = new Bookshelf(arrList2);

      /* The output of the above was:
      Exception in thread "main" java.lang.AssertionError
        at Bookshelf.<init>(Bookshelf.java:53)
        at TestAssert.main(TestAssert.java:25)
       */

   }
}