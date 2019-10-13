package Oracle;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.testng.annotations.Test;

public class TestArrayList {

	/** Unit Test Cases For ArrayList.SubList */
	
	/*
	 * Test Scenario: 
	 * 	Testing Blank data fetched from Sublist, as we specified both
	 *  "fromIndex" and "toIndex" as same. 
	 */
	@Test
	public void TC1_testEmptySubList() {

		List<String> myList = new ArrayList<>();
		myList.add("A");
		myList.add("B");
		myList.add("C");

		List<String> subList = myList.subList(1, 1);
		System.out.println("Abhijeet:"+subList);
		assertTrue(subList.isEmpty());
	}

	/*
	 * Test Scenario: 
	 * 	Providing "fromIndex" is less than "0", i.e -1, 
	 *  So, that it will throw IndexOutOfBoundsException inside subListRangeCheck 
	 */
	@Test(expectedExceptions = IndexOutOfBoundsException.class)
	public void TC2_testIndexOutOfLowerBound() {

		List<String> orig = new ArrayList<>();
		orig.add("A");
		orig.add("B");
		orig.add("C");

		orig.subList(-1, 1);
	}

	/*
	 * Test Scenario: 
	 * 	Providing "toIndex" is greater than max size, i.e 4, 
	 *  So, that it will throw IndexOutOfBoundsException inside subListRangeCheck 
	 */
	@Test(expectedExceptions = IndexOutOfBoundsException.class)
	public void TC3_testIndexOutOfUpperBound() {

		List<String> orig = new ArrayList<>();
		orig.add("A");
		orig.add("B");
		orig.add("C");

		orig.subList(0, 4);
	}

	/*
	 * Test Scenario: 
	 * 	Providing "fromIndex" is greater than "toIndex, 
	 *  So, that it will throw IllegalArgumentException inside subListRangeCheck 
	 */
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void TC4_testFromGreaterThanTo() {

		List<String> orig = new ArrayList<>();
		orig.add("A");
		orig.add("B");
		orig.add("C");

		orig.subList(2, 0);
	}

	/*
	 * Test Scenario: 
	 * 	Providing "fromIndex" and "toIndex, 
	 *  And then opt list of data, of given ArrayList
	 */
	@Test
	public void TC5_testSubList() {

		List<String> orig = new ArrayList<>();
		orig.add("A");
		orig.add("B");
		orig.add("C");
		orig.add("D");

		int from = 1;
		int to = 3;

		List<String> subList = orig.subList(from, to);
		//System.out.println("Abhijeet:"+subList.size());
		assertEquals(subList.size(), to - from);
		
		for (int i = 0; i < subList.size(); i++) {
			//System.out.println("Abhijeet:"+i+":"+subList.get(i)+":"+orig.get(from + i));
			assertEquals(subList.get(i), orig.get(from + i));
		}
	}

	/*
	 * Test Scenario: 
	 * 	Functional Cases where, after subList, we are altering the content of 
	 *  the ArratList
	 */
	@Test
	public void TC6_testSubListModify() {

		List<String> orig = new ArrayList<>();
		orig.add("A");
		orig.add("B");
		orig.add("C");
		orig.add("D");

		int from = 1;
		int to = 3;

		// element in sublist B and C
		List<String> subList = orig.subList(from, to);
		subList.remove("B");

		assertEquals(subList.size(), 1);

		// removed from original too
		assertEquals(orig.size(), 3);
		assertFalse(orig.contains("B"));

		subList.add("E");
		assertEquals(subList.size(), 2);

		// added in orig too
		assertEquals(orig.size(), 4);
		assertTrue(orig.contains("E"));

		System.out.println(orig);
	}
	/******************************************************************************************/
	
	/** Unit Test Cases For Iterator */
	
	/*
	 * Test Scenario: 
	 * Best Scenario: Initialize Iterator Index and iterate(traverse) all the values with next().
	 */
	@Test
    public void TC7_testIteratorAllElementInOrder() {

        List<String> orig = new ArrayList<>();
        orig.add("A");
        orig.add("B");
        orig.add("C");

        Iterator<String> itr = orig.iterator();

        assertEquals(itr.next(), "A");
        assertEquals(itr.next(), "B");
        assertEquals(itr.next(), "C");
    }
    
	/*
	 * Test Scenario: 
	 * Best Scenario: Initialize Iterator Index and iterate(traverse) all the values with next().
	 * After Re confirming whether next value is present or not with hasNext();
	 */
    @Test
    public void TC8_testIteratorHasNext() {

        List<String> orig = new ArrayList<>();
        orig.add("A");
        orig.add("B");

        Iterator<String> itr = orig.iterator();

        assertTrue(itr.hasNext());
        assertEquals(itr.next(), "A");
       
        assertTrue(itr.hasNext());
        assertEquals(itr.next(), "B");
        
        assertFalse(itr.hasNext());
    }

    /*
	 * Test Scenario: 
	 * Initialize Iterator Index and iterate(traverse) all the values with next().
	 * Iterate next value, which is not present in List, i.e  NoSuchElementException
	 */
    @Test(expectedExceptions = NoSuchElementException.class)
    public void TC9_testNoSuchElementException() {

        List<String> orig = new ArrayList<>();
        orig.add("A");

        Iterator<String> itr = orig.iterator();

        assertTrue(itr.hasNext());
        assertEquals(itr.next(), "A");

        // exception
        itr.next();
    }

    /*
	 * Test Scenario: 
	 * Initialize Iterator Index and iterate(traverse) all the values with next().
	 * Remove the current Index Value and Check Appropraite and Size and elements remaining
	 */
    @Test
    public void TC10_testRemove() {

        List<String> orig = new ArrayList<>();
        orig.add("A");
        orig.add("B");

        Iterator<String> itr = orig.iterator();

        assertEquals(itr.next(), "A");

        // "A" removed from list
        itr.remove();

        // removed from orig
        assertEquals(orig.size(), 1);
        assertFalse(orig.contains("A"));
    }

    /*
	 * Test Scenario: 
	 * Initialize Iterator Index and iterate(traverse) all the values with next().
	 * Remove the current Index Value and then again trying to remove already deleted element
	 * that cause to throw IllegalStateException
	 */
    @Test(expectedExceptions = IllegalStateException.class)
    public void TC11_testRemoveDoubleCall() {

        List<String> orig = new ArrayList<>();
        orig.add("A");
        orig.add("B");

        Iterator<String> itr = orig.iterator();

        assertEquals(itr.next(), "A");

        itr.remove();
        itr.remove();
    }

    /*
	 * Test Scenario: 
	 * Initialize Iterator Index and then trying to Remove the 
     * Value without using next();
	 */
    @Test(expectedExceptions = IllegalStateException.class)
    public void TC12_testRemoveIllegalState() {

        List<String> orig = new ArrayList<>();
        orig.add("A");
        orig.add("B");

        Iterator<String> itr = orig.iterator();

        // called before calling next
        itr.remove();
    }
    
    /*
	 * Test Scenario: 
	 * After Initialize Iterator Index if any add or delete method get invoked
	 * Which makes current size of Arraylist may shrink or expand.
	 * Then iterator need to be initiailzed again, other wise it will throw 
	 * ConcurrentModificationException
	 */
    @Test(expectedExceptions = ConcurrentModificationException.class)
    public void TC13_testConcurrentModification() {

        List<String> orig = new ArrayList<>();
        orig.add("A");
        orig.add("B");

        Iterator<String> itr = orig.iterator();

        // add or remove
        orig.add("C");
        
        // called before calling next
        itr.next();
    }
    /*
	 * Test Scenario: 
	 * After Initialize Iterator Index if any modifiaction is executed which doesnt
	 * change the size of list, only update indexed value, will work perfectly 
	 */
    @Test
    public void TC14_testNoConcurrentModification() {

        List<String> orig = new ArrayList<>();
        orig.add("A");
        orig.add("B");

        Iterator<String> itr = orig.iterator();

        // change "B" to "C"
        orig.set(1, "C");
        
        assertEquals(itr.next(), "A");
        assertEquals(itr.next(), "C");
    }
    /*******************************************************************************/
    
    /** Unit Test Cases For addAll */
    
    /*
     * Scenario:
     * 	Adding 2 Different ArrayList and checking the Current Size
     */
    @Test
    public void TC15_testAddAll() {

        List<String> orig = new ArrayList<>();
        orig.add("A");
        orig.add("B");
        orig.add("C");

        int size = orig.size();

        List<String> end = new ArrayList<>();
        end.add("D");
        end.add("E");
        end.add("F");

        assertTrue(orig.addAll(end));
        assertEquals(orig.size(), 6);

        for (String s : end) {

            assertEquals(orig.get(size++), s);
        }
    }

    /*
     * Scenario:
     * 	Adding content of a ArrayList in another blank ArrayList
     */
    @Test
	public void TC16_testAddToEmpty() {

		List<String> orig = new ArrayList<>();

		List<String> end = new ArrayList<>();
		end.add("D");
		end.add("E");
		end.add("F");

		assertTrue(orig.addAll(end));
		assertEquals(orig.size(), 3);

		int i = 0;
		for (String s : end) {

			assertEquals(orig.get(i++), s);
		}
	}

    /*
     * Scenario:
     * 	Adding content of a ArrayList in another ArrayList.
     * After executing, if we modify or clean the Destination ArrayList.
     * Source List doesnt have any effect
     */
    @Test
    public void TC17_testArgNotModified() {

        List<String> orig = new ArrayList<>();
        orig.add("A");
        orig.add("B");
        orig.add("C");

        List<String> end = new ArrayList<>();
        end.add("D");
        end.add("E");
        end.add("F");

        assertTrue(orig.addAll(end));

        // end list not modified at all
        assertEquals(end.size(), 3);
        assertEquals(end.get(0), "D");
        assertEquals(end.get(1), "E");
        assertEquals(end.get(2), "F");

        // deleted elements in orig
        orig.clear();

        // no effect on end array
        assertEquals(end.size(), 3);
        assertEquals(end.get(0), "D");
        assertEquals(end.get(1), "E");
        assertEquals(end.get(2), "F");
    }

    /*
     * Scenario:
     * Adding empty content of a ArrayList in another ArrayList.
     * will return false
     */

    @Test
    public void TC18_testAddEmptyList() {

        List<String> orig = new ArrayList<>();
        orig.add("A");
        orig.add("B");
        orig.add("C");

        List<String> end = Collections.emptyList();

        // return false if orig not modified
        assertFalse(orig.addAll(end));
        assertEquals(orig.size(), 3);
    }

}
