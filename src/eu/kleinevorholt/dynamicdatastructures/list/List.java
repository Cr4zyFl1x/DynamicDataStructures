package eu.kleinevorholt.dynamicdatastructures.list;

import eu.kleinevorholt.dynamicdatastructures.component.Node;

import java.util.ArrayList;

public class List<E> {

    private Node<E> first;
    private Node<E> last;
    private Node<E> current;

    public List() {}
    public List(E[] initVals)
    {
        for (E val : initVals) {
            append(val);
        }
    }
    public List(List<E> initList)
    {
        concat(initList);
    }
    public List(E[] initVals, List<E> initList)
    {
        for (E val : initVals) {
            append(val);
        }
        concat(initList);
    }

    public boolean isEmpty() {
        return first == null || last == null;
    }

    public boolean hasAccess() {
        return current != null;
    }

    public void next() {
        if (!isEmpty() && hasAccess() && getObject() != last.getContent()) {
            current = current.getNext();
            return;
        }
        current = null;
    }

    public void toFirst() {
        if (!isEmpty()) current = first;
    }

    public void toLast() {
        if (!isEmpty()) current = last;
    }

    public E getObject() {
        return hasAccess() ? current.getContent() : null;
    }

    public void setObject(E pObject) {
        if (hasAccess() && pObject != null) current.setContent(pObject);
    }


    public void append(E pObject) {
        if (pObject != null) {

            Node<E> n = new Node<>(pObject);

            if (first == null) {
                first = n;
                last = n;
                return;
            }

            last.setNext(n);
            last.getNext().setPrev(last);
            last = last.getNext();
        }
    }

    public void insert(E pObject)
    {
        if (pObject != null) {

            if (!hasAccess() && !isEmpty()) return;

            if (isEmpty() && !hasAccess()) {
                append(pObject);
                return;
            }

            if (hasAccess()) {
                Node<E> node = new Node<E>(pObject);
                Node<E> prevC = current.getPrev();
                if (prevC != null) {
                    prevC.setNext(node);
                    prevC.getNext().setNext(current);
                    current.setPrev(prevC.getNext());
                    return;
                }

                current.setPrev(node);
                current.getPrev().setNext(current);
                first = current.getPrev();
            }
        }
    }

    public void remove()
    {
        if (hasAccess()) {
            if (current == last) {
                last = current.getPrev();
                if (last != null) last.setNext(null);
                current = null;
                return;
            }
            current.getNext().setPrev(current.getPrev() != null ? current.getPrev() : null);
            if (current.getPrev() != null) {
                current.getPrev().setNext(current.getNext());
            } else {
                first = current.getNext();
            }
        }
    }

    public void concat(List<E> list)
    {
        if (list != null) {
            while (!list.isEmpty()) {
                list.toFirst();
                append(list.getObject());
                list.remove();
            }
        }
    }


    public int getSize()
    {
        int i = 0;
        Node<E> tmp = first;
        while (tmp != null) {
            i++;
            tmp = tmp.getNext();
        }
        return i;
    }

    public void print()
    {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }

        int i = 0;
        Node<E> tmp = first;

        System.out.println("-------------->> Printed List <<--------------");
        while (tmp != null) {
            System.out.println(i + ". '" + tmp.getContent() + "'" + ((tmp == current) ? " (Selected)" : ""));
            tmp = tmp.getNext();
            i++;
        }
        System.out.println("-------------->> Printed List <<--------------");
    }

    public void printFromLast()
    {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }

        Node<E> tmp = last;
        System.out.print("'" + tmp + "'");
        tmp = tmp.getPrev();
        while (tmp != null) {
            System.out.print(" -> '" + tmp.getContent() + "'");
            tmp = tmp.getPrev();
        }
        System.out.print("\n");
    }

    public void printFromFirst()
    {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }

        Node<E> tmp = first;
        System.out.print("'" + tmp + "'");
        tmp = tmp.getNext();
        while (tmp != null) {
            System.out.print(" -> '" + tmp.getContent() + "'");
            tmp = tmp.getNext();
        }
        System.out.print("\n");
    }



}