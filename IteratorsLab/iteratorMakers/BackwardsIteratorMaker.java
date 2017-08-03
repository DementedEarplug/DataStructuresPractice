package iteratorMakers;

import java.util.Iterator;

import positionInterfaces.PositionList;
import positionInterfaces.PositionListIteratorMaker;
import positionListLLDirect.PositionListElementsBackWardsIterator;

public class BackwardsIteratorMaker<E> implements PositionListIteratorMaker<E> {

	@Override
	public Iterator<E> makeIterator(PositionList<E> pl) {
		
		return new PositionListElementsBackWardsIterator<E>(pl);
	}

}