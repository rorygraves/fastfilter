package scala.collection.immutable

import scala.annotation.tailrec
import scala.collection.generic.CanBuildFrom

/**
  * Created by rorygraves on 13/10/2016.
  */
object ListOps {


  def fastFilterNot[A](l: List[A], p: A => Boolean): List[A] = {
    fastFilterImpl(l, isFlipped =  true, p)
  }

  def fastFilter[A](l: List[A], p: A => Boolean): List[A] = {
    fastFilterImpl(l, isFlipped =  false, p)
  }

  def fastFilterImpl[A](l: List[A],isFlipped: Boolean, p: A => Boolean): List[A] = {
    // everything so far is not included
    @tailrec def noneIn(l: List[A]): List[A] = {
      if(l.isEmpty)
        Nil
      else {
        val h = l.head
        val t = l.tail
        if(p(h) != isFlipped)
          allIn(l, t)
        else
          noneIn(t)
      }
    }

    // everything from 'start' is included, if everything from this point is in we can return the origin
    // start otherwise if we discover an element that is out we must create a new partial list.
    @tailrec def allIn(start: List[A], remaining: List[A]): List[A] = {
      if(remaining.isEmpty)
        start
      else {
        val x = remaining.head
        if(p(x)  != isFlipped)
          allIn(start, remaining.tail)
        else
          partialFill(start, remaining)
      }
    }

    // we have seen elements that should be included then one that should be excluded, start building
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
      while(!next.isEmpty) {  // generally recommended is next.isNonEmpty but this incurs an extra method call.
        val head: A = next.head
        if(p(head) != isFlipped) {
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
