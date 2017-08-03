package positionListLLDirect;

import exceptionClasses.EmptyListException;
import positionInterfaces.Position;

public class NodePositionListBackwardsTester {

	public static void main(String[] args) {
		
		NodePositionList<Integer> w = new NodePositionList<Integer> (); 
		NodePositionList<Integer> q = new NodePositionList<Integer> (); 
		q.addFirst(10); 
		
		w.addFirst(5); 
		w.addFirst(3); 
		
		w.addLast(10); 
		w.addLast(13); 
		try {
			Position<Integer> p = w.first();
			w.addAfter(p, 2); 
			p = w.next(p); 
			w.addAfter(p, 34); 
			w.addBefore(p, 40); 
			p = q.first(); 
			//w.addAfter(p, 89); 
			/*
			 * There is no position 89 in the list w,
			 *  thus is not possible to add a position after 89.
			 */
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		System.out.println("List w: ");
		showElements(w); 
		
		PositionListElementsBackWardsIterator<Integer> b2fIterator = new PositionListElementsBackWardsIterator<Integer>(w);
		System.out.println("\n\nTesting Backward Iterator in Position List w:\n");
		while(b2fIterator.hasNext())
		{
			int n = b2fIterator.next();
			System.out.println(n);
			
			
		}
		System.out.println("\nBackwards iterator test end\n\n");

	}
	
	

	private static <E> void showElements(NodePositionList<E> w) {
		for(E p : w) 
			System.out.println(p); 
	}
	
	

}
