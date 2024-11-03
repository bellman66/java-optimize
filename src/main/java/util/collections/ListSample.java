package util.collections;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListSample {

    @Test
    void LinkedListTest() {
        // given
        LinkedList<String> linkedList = new LinkedList<>();

        // when
        /**
         * internal implementation of add method
         *   -
         *      public boolean add(E e) {
         *         linkLast(e);
         *         return true;
         *      }
         *
         *      void linkLast(E e) {
         *         final Node<E> l = last;
         *         final Node<E> newNode = new Node<>(l, e, null);
         *         last = newNode;
         *         if (l == null)
         *             first = newNode;
         *         else
         *             l.next = newNode;
         *         size++;
         *         modCount++;
         *      }
         */
        linkedList.add("A");
        linkedList.add("B");

        // then
        assertEquals(linkedList.size(), 2);
    }

    @Test
    void LinkedListIndexOfTest() {
        // given
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("A");
        linkedList.add("B");

        // when
        int index = linkedList.indexOf("B");

        // then
        // internal implementation of indexOf method
        //
        //     public int indexOf(Object o) {
        //        int index = 0;
        //        if (o == null) {
        //            for (Node<E> x = first; x != null; x = x.next) {
        //                if (x.item == null)
        //                    return index;
        //                index++;
        //            }
        //        } else {
        //            // for-loop recursion
        //            for (Node<E> x = first; x != null; x = x.next) {
        //                if (o.equals(x.item))
        //                    return index;
        //                index++;
        //            }
        //        }
        //        return -1;
        //    }
        assertEquals(index, 1);
    }
}
