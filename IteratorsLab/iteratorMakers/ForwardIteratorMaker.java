package iteratorMakers;

import java.util.Iterator;

import positionInterfaces.PositionList;
import positionInterfaces.PositionListIteratorMaker;
import positionListLLDirect.PositionListElementsIterator;

public class ForwardIteratorMaker<E> implements PositionListIteratorMaker<E> {

	@Override
	public Iterator<E> makeIterator(PositionList<E> pl) {
		
		return new PositionListElementsIterator<E>(pl);
	}

}