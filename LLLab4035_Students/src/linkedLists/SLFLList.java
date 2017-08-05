package linkedLists;
/**
 * Singly linked list with references to its first and its
 * last node. 
 * 
 * @author pirvos
 *
 */

import linkedLists.LinkedList;

public class SLFLList<E> implements LinkedList<E>
{

	private SNode<E> first, last;
	int length;

	public SLFLList()
	{
		first = last = null;
		length=0;
	}

	public void addFirstNode(Node<E> nuevo)
	{
		SNode<E> nuevoX= (SNode<E>) nuevo;
		if(length()==0)
			first=nuevoX;
		nuevoX.setNext(first);
		first= nuevoX;
		length++;

	}

	public void addNodeAfter(Node<E> target, Node<E> nuevo)
	{
		//Precondition target is a valid node.
		SNode<E> sNuevo= (SNode<E>) nuevo;
		SNode<E> sTarget= (SNode<E>) target;
	
		sNuevo.setNext((SNode<E>)getNodeAfter(sTarget));
		sTarget.setNext(sNuevo);
		
		length++;		
	}

	public void addNodeBefore(Node<E> target, Node<E> nuevo)
	{
		SNode<E> sNuevo= (SNode<E>) nuevo;
		SNode<E> sTarget= (SNode<E>) target;
		SNode<E> marker= (SNode<E>)getNodeBefore(sTarget);
		
		sNuevo.setNext(sTarget);
		marker.setNext(sNuevo);
		
		length++;
	}

	public Node<E> getFirstNode() throws NodeOutOfBoundsException
	{
		if(length()==0)
			throw new NodeOutOfBoundsException("Dude this is empty...");
		
		return first;
	}

	public Node<E> getLastNode() throws NodeOutOfBoundsException
	{
		if(length()==0)
			throw new NodeOutOfBoundsException("Dude this is empty...");
		
		SNode<E> marker = first;
		while(marker.getNext()!=null)
			marker=marker.getNext();
		
		return marker;
	}

	public Node<E> getNodeAfter(Node<E> target) throws NodeOutOfBoundsException
	{
		SNode<E> sTarget= (SNode<E>)target;
		return sTarget.getNext();
	}

	public Node<E> getNodeBefore(Node<E> target) throws NodeOutOfBoundsException
	{
		SNode<E> marker= first;
		while(marker.getNext()!=target)
			marker = marker.getNext();
		return marker;
	}

	public int length()
	{
		return length;
	}

	public void removeNode(Node<E> target)
	{
		SNode<E> sTarget = (SNode<E>)target;
		SNode<E> after = (SNode<E>)getNodeAfter(target);
		SNode<E> before = (SNode<E>)getNodeBefore(target);
		
		before.setNext(after);
		sTarget.setNext(null);
		length--;
		
	}

	public Node<E> createNewNode()
	{
		return new SNode<E>();
	}

	///////////////////////////////////////////////////
	// private and static inner class that defines the
	// type of node that this list implementation uses
	private static class SNode<T> implements Node<T>
	{
		private T element;
		private SNode<T> next;

		public SNode()
		{
			element = null;
			next = null;
		}

		public SNode(T data, SNode<T> next)
		{
			this.element = data;
			this.next = next;
		}

		public SNode(T data)
		{
			this.element = data;
			next = null;
		}

		public T getElement()
		{
			return element;
		}

		public void setElement(T data)
		{
			this.element = data;
		}

		public SNode<T> getNext()
		{
			return next;
		}

		public void setNext(SNode<T> next)
		{
			this.next = next;
		}
	}

}
