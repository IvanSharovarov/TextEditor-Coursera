package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		if(element == null) throw new NullPointerException();
		
		LLNode<E> newElem = new LLNode<E>(element);
		tail.prev.next = newElem;
		newElem.prev = tail.prev;
		tail.prev = newElem;
		
		size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		if(0 > index || index >= size) throw new IndexOutOfBoundsException();
		LLNode<E> item = head;
		for(int i=0; i <= index; i++)
			item = item.next;
		return item.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		if((index < 0 || index >= size) && size != 0) throw new IndexOutOfBoundsException();
		if(element == null) throw new NullPointerException();
		
		LLNode<E> prevElem = head;
		for(int i=0; i < index; i++)
			prevElem = prevElem.next;
		
		LLNode<E> newElem = new LLNode<E>(element);
		
		newElem.next = prevElem.next;
		prevElem.next = newElem;
		newElem.next.prev = newElem;
		newElem.prev = prevElem;
		size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
		
		LLNode<E> element = head;
		
		for(int i = 0; i <= index; i++)
			element = element.next;

		element.prev.next = element.next;
		element.prev.prev = element.prev;
		size --;
		
		return element.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
		if(element == null) throw new NullPointerException();
		
		LLNode<E> item = head;
		for(int i=0; i <= index; i++)
			item = item.next;
		item.data = element;
		
		return element;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor
	public LLNode()
	{
		this.data = null;
		this.prev = null;
		this.next = null;
	}

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
