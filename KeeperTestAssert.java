// Name: Steve Regala
// USC NetID: sregala
// CSCI455 PA2
// Fall 2021

import java.util.ArrayList;

public class KeeperTestAssert {

   public static void main(String[] args) {

      ArrayList<Integer> arrList1 = new ArrayList<Integer>();
      arrList1.add(1);
      arrList1.add(4);
      arrList1.add(10);
      arrList1.add(35);
      Bookshelf newBookList1 = new Bookshelf(arrList1);
      BookshelfKeeper keeper1 = new BookshelfKeeper(newBookList1);
      // ^^^ SATISFIES PRECONDITION SO IT DOES NOT CRASH


      ArrayList<Integer> arrList2 = new ArrayList<Integer>();
      arrList2.add(1);
      arrList2.add(4);
      arrList2.add(10);
      arrList2.add(35);
      arrList2.add(35);
      Bookshelf newBookList2 = new Bookshelf(arrList2);
      BookshelfKeeper keeper2= new BookshelfKeeper(newBookList2);
      // ^^^ SATISFIES PRECONDITION SO IT DOES NOT CRASH

      ArrayList<Integer> arrList3 = new ArrayList<Integer>();
      arrList3.add(1);
      arrList3.add(4);
      arrList3.add(10);
      arrList3.add(35);
      arrList3.add(75);
      arrList3.add(8);
      Bookshelf newBookList3 = new Bookshelf(arrList3);
      BookshelfKeeper keeper3= new BookshelfKeeper(newBookList3);
      // ^^^ Crashes because it violates representation invariant
      /*
      Exception in thread "main" java.lang.AssertionError
        at BookshelfKeeper.<init>(BookshelfKeeper.java:51)
        at KeeperTestAssert.main(KeeperTestAssert.java:40)

       */


   }

}
