package scala.collection.immutable

import scala.annotation.tailrec

/**
  * Created by rorygraves on 13/10/2016.
  */
object ListOps {

  def fastFilter[A](l: List[A], p: A => Boolean): List[A] = {
    @tailrec def noneIn(l: List[A]): List[A] = {
      if(l.isEmpty)
        Nil
      else {
        val h = l.head
        val t = l.tail
        if(p(h))
          allIn(l, t)
        else
          noneIn(t)
      }
//      l match {
//        case x :: xs =>
//          if(p(x))
//            allIn(l, xs)
//          else
//            noneIn(xs)
//        case Nil =>
//          Nil
//      }
    }

    @tailrec def allIn(start: List[A], remaining: List[A]): List[A] = {
      if(remaining.isEmpty)
        start
      else {
        val x = remaining.head
        if(p(x))
          allIn(start, remaining.tail)
        else
          partialFill(start, remaining)
      }
    }


    def partialFill(origStart: List[A], firstMiss: List[A]): List[A] = {
      val newHead = ::(origStart.head, Nil)
      var toProcess = origStart.tail.asInstanceOf[::[A]]
      var currentLast = newHead
      // we know that all elements are :: until at least firstMiss.tail
      while(!(toProcess eq firstMiss)) {
        val newElem = ::(toProcess.head, Nil)
        currentLast.tl = newElem
        currentLast = newElem
        toProcess = toProcess.tail.asInstanceOf[::[A]]
      }

      // at this point newHead points to a list which is a duplicate of all the 'in' elements up to the first miss.
      // currentLast is the last element in that list.

      // now we are going to try and share as much of the tail as we can, only moving elements across when we have to.
      var next = firstMiss.tail
      var nextToCopy = next // the next element we would need to copy to our list if we cant share.
      while(!next.isEmpty) {
//        println("Next = " + next)
        val head: A = next.head
        if(p(head)) {
          next = next.tail
        } else {
          // its not a match - do we have outstanding elements?
          while(!(nextToCopy eq next)) {
            val newElem = ::(nextToCopy.head, Nil)
            currentLast.tl = newElem
            currentLast = newElem
            nextToCopy = nextToCopy.tail
          }
          nextToCopy = next.tail
          next = next.tail
        }

      }

      // we have remaining elements - need to add them to the
      if(!nextToCopy.isEmpty)
        currentLast.tl = nextToCopy

      newHead
    }

    noneIn(l)
  }
}
