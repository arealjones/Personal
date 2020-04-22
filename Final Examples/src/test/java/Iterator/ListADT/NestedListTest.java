package Iterator.ListADT;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class NestedListTest {
    IListAdt<String> empty;
    IListAdt<String> one;
    IListAdt<String> two;

    @Before
    public void setUp() throws Exception {
        empty = NestedList.createEmpty();
        one = NestedList.createEmpty();
        one.append("A");
        two = NestedList.createEmpty();
        two.append("B");
        two.append("A");
        System.out.println(two.toString());
    }

    @Test
    public void get() throws IndexOutOfBoundsException {
        assertEquals("A", one.get(0));
        assertEquals("A", two.get(1));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void getNegative() throws IndexOutOfBoundsException {
        one.get(-1);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void getTooBig() throws IndexOutOfBoundsException {
        two.get(2);
    }

    @Test
    public void append() {
        empty.append("A");
        empty.equals(one);
    }

    @Test
    public void insert() {
        one.insert("B", 0);
        one.equals(two);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void insertNegative() {
        two.insert("C", -5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void insertTooBig() {
        two.insert("C", 3);
    }

    @Test
    public void testEquals() {
        assertTrue(one.equals(one));
        assertFalse(one.equals(null));
        assertFalse(empty.equals(new ArrayList<>()));
        assertFalse(one.equals(empty));
        assertTrue(empty.equals(NestedList.createEmpty()));
    }

    @Test
    public void testHashCode() {
        one.insert("B", 0);
        assertTrue(one.hashCode() == two.hashCode());
    }

    @Test
    public void testToString() {
        one.insert("B", 0);
        assertTrue(one.toString().equals(two.toString()));
    }

    @Test
    public void size() {
        assertEquals(1, one.size());
        assertEquals(0, empty.size());
        assertEquals(2, two.size());
    }
}