package com.company;
public class DMyLinkedLIst<E> implements MyList<E>
{
        private class Node
        {
            E element;
            Node next;
            Node prev;
            Node(E element)
            {
                this.element = element;
                this.next = null;
                this.prev=null;
            }
        }

        private Node head;
        private Node tail;
        private int size;

        public DMyLinkedLIst()
        {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        @Override
        public int size()
        {
            return size;
        }

        @Override
        public boolean contains(Object o)
        {
            return indexOf(o) != -1;
        }

        @Override
        public void add(E element)
        {
            Node newNode = new Node(element);
            if (head==null)
            {
                head=newNode;
                tail=newNode;
            }
            else
            {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
            size++;
        }

        @Override
        public void add(E element, int index)
        {
            if (index < 0 || index > size)
            {
                throw new IndexOutOfBoundsException(index);
            }
            if (index == size)
            {
                add(element);
            }
            else {
                Node newNode = new Node(element);
                if (index == 0)
                {
                    newNode.next = head;
                    head.prev = newNode;
                    head = newNode;
                }
                else
                {
                    Node nodeAtIndex = getNode(index);
                    Node prevNode = nodeAtIndex.prev;
                    newNode.next = nodeAtIndex;
                    newNode.prev = prevNode;
                    prevNode.next = newNode;
                    nodeAtIndex.prev = newNode;
                }
                size++;
            }
        }

        private Node getNode(int index)
        {
            if (index < 0 || index >= size)
            {
                throw new IndexOutOfBoundsException("Index out of range: " + index);
            }
            if (index < size / 2)
            {
                Node current = head;
                for (int i = 0; i < index; i++)
                {
                    current = current.next;
                }
                return current;
            }
            else
            {
                Node current = tail;
                for (int i = size - 1; i > index; i--)
                {
                    current = current.prev;
                }
            }
            return current;
        }

        @Override
        public boolean remove(E element)
        {
            int index=indexOf(element);
                if (index != -1)
                {
                    remove(index);
                    return true;
                }
            return false;
        }

        @Override
        public E remove(int index)
        {
            Node nodeToRemove = getNode(index);
            Node prevNode = nodeToRemove.prev;
            Node nextNode = nodeToRemove.next;
            if (prevNode != null)
            {
                prevNode.next = nextNode;
            }
            else {
                head = nextNode;
            }

            if (nextNode != null)
            {
                nextNode.prev = prevNode;
            }
            else {
                tail = prevNode;
            }

            size--;
            return nodeToRemove.element;
        }

        @Override
        public void clear()
        {
            head = tail = null;
            size = 0;
        }

        @Override
        public E get(int index)
        {
            return getNode(index).element;
        }

        @Override
        public int indexOf(Object o)
        {
            Node current = head;
            int index = 0;
            while (current != null)
            {
                if (current.element.equals(o))
                {
                    return index;
                }
                current = current.next;
                index++;
            }
            return -1;
        }

        @Override
        public int lastIndexOf(Object o)
        {
            Node current = tail;
            int index = size - 1;
            while (current != null)
            {
                if (current.element.equals(o))
                {
                    return index;
                }
                current = current.prev;
                index--;
            }
            return -1;
        }

        @Override
        public void sort()
        {

        }

}
