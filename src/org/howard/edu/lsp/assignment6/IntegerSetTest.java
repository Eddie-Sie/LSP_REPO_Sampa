package org.howard.edu.lsp.assignment6;
 
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
 
/**
 * Assignment 6: JUnit 5 tests for IntegerSet.
 *
 * Complete every TODO. Do not remove, rename, or disable test methods.
 * Each test must contain meaningful assertions and run independently.
 */
public class IntegerSetTest {
 
    // ===== clear() =====
 
    /**
     * Create a populated set; call clear(); assert that it is empty and its length is zero.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testClearClearsPopulatedSet() {
        IntegerSet a=s(3,1,2);
        a.clear();
        assertTrue(a.isEmpty());
        assertEquals(0,a.length());
    }
 
    /**
     * Clear an already empty set; verify it remains empty.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testClearClearsEmptySet() {
        IntegerSet a=s();
        a.clear();
        assertTrue(a.isEmpty());
        assertEquals(0,a.length());
    }
 
    // ===== length() =====
 
    /**
     * Add repeated and unique integers; assert the number of distinct elements.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testLengthCountsUniqueElements() {
        IntegerSet a=s(1,1,2,3,3);
        assertEquals(3,a.length());
    }
 
    /**
     * Verify a new empty set has length zero.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testLengthEmptySetLength() {
        assertEquals(0,s().length());
    }
 
    // ===== equals() =====
 
    /**
     * Construct sets with identical elements in different insertion orders; assert equality.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testEqualsIgnoresInsertionOrder() {
        assertTrue(s(3,1,2).equals(s(2,3,1)));
    }
 
    /**
     * Construct sets of equal length with different elements; assert inequality.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testEqualsDetectsDifferentContents() {
        assertFalse(s(1,2).equals(s(1,3)));
    }
 
    /**
     * Verify two separately constructed empty sets compare equal.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testEqualsEmptySetsEqual() {
        assertTrue(s().equals(s()));
    }
 
    /**
     * Verify a set equals itself and differs from a set of another size.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testEqualsSameObjectAndDifferentSizes() {
        IntegerSet a=s(1,2);
        assertTrue(a.equals(a));
        assertFalse(a.equals(s(1)));
        assertFalse(a.equals(null));
    }
 
    // ===== contains() =====
 
    /**
     * Verify contains() is true for a present element and false for an absent one.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testContainsPresentAndAbsent() {
        IntegerSet a=s(1,3,-5);
        assertTrue(a.contains(-5));
        assertTrue(a.contains(3));
        assertFalse(a.contains(2));
    }
 
    /**
     * Verify an empty set does not contain an arbitrary integer.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testContainsEmptySetContainsNothing() {
        assertFalse(s().contains(0));
    }
 
    // ===== largest() =====
 
    /**
     * Verify largest() returns the maximum across negative, zero, and positive values.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testLargestNegativeAndPositiveValues() {
        assertEquals(10,s(-9,10,0,-1).largest());
        assertEquals(-2,s(-8,-2,-4).largest());
    }
 
    /**
     * Use assertThrows() to verify IllegalStateException for an empty set.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testLargestEmptySetThrowsException() {
        assertThrows(IllegalStateException.class,()->s().largest());
    }
 
    // ===== smallest() =====
 
    /**
     * Verify smallest() returns the minimum across negative, zero, and positive values.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testSmallestNegativeAndPositiveValues() {
        assertEquals(-9,s(2,-9,0,7).smallest());
        assertEquals(3,s(8,3,4).smallest());
    }
 
    /**
     * Use assertThrows() to verify IllegalStateException for an empty set.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testSmallestEmptySetThrowsException() {
        assertThrows(IllegalStateException.class,()->s().smallest());
    }
 
    // ===== add() =====
 
    /**
     * Add the same integer repeatedly; verify only one copy exists.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testAddIgnoresDuplicates() {
        IntegerSet a=s(4);
        a.add(4);
        a.add(4);
        assertEquals(1,a.length());
        assertEquals("[4]",a.toString());
    }
 
    /**
     * Add Integer.MIN_VALUE, Integer.MAX_VALUE, and zero; verify all are represented.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testAddHandlesIntegerBoundaries() {
        IntegerSet a=s(Integer.MIN_VALUE,Integer.MAX_VALUE,0);
        assertEquals(3,a.length());
        assertEquals(Integer.MIN_VALUE,a.smallest());
        assertEquals(Integer.MAX_VALUE,a.largest());
    }
 
    // ===== remove() =====
 
    /**
     * Remove a present element; verify it is absent and others remain.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testRemoveRemovesExistingElement() {
        IntegerSet a=s(1,2,3);
        a.remove(2);
        assertEquals("[1, 3]",a.toString());
        assertFalse(a.contains(2));
    }
 
    /**
     * Remove an absent element; verify the set is unchanged.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testRemoveIgnoresAbsentElement() {
        IntegerSet a=s(1,2);
        a.remove(99);
        assertEquals("[1, 2]",a.toString());
        assertEquals(2,a.length());
    }
 
    // ===== union() =====
 
    /**
     * Verify union() contains all distinct elements from two overlapping sets.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testUnionOverlappingSets() {
        IntegerSet a=s(1,2),c=s(2,3);
        IntegerSet r=a.union(c);
        assertSet(r,1,2,3);
        assertSet(a,1,2);
        assertSet(c,2,3);
    }
 
    /**
     * Verify union with an empty set and with the same object.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testUnionEmptyAndSameOperand() {
        IntegerSet a=s(1,2);
        assertSet(a.union(s()),1,2);
        assertSet(s().union(a),1,2);
        assertSet(a.union(a),1,2);
    }
 
    /**
     * Verify both inputs remain unchanged; modify the result and verify the inputs are still unchanged.
     * Assignment 5 equivalent: 3 point(s).
     */
    @Test
    public void testUnionDoesNotMutateInputs() {
        IntegerSet a=s(1,2),c=s(2,3),r=a.union(c);
        assertNotSame(a,r);
        assertNotSame(c,r);
        r.add(99);
        r.remove(1);
        assertSet(a,1,2);
        assertSet(c,2,3);
        assertSet(r,2,3,99);
    }
 
    // ===== intersect() =====
 
    /**
     * Verify intersection contains exactly the shared elements.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIntersectOverlappingSets() {
        IntegerSet a=s(1,2,3),c=s(2,3,4);
        assertSet(a.intersect(c),2,3);
        assertSet(a,1,2,3);
        assertSet(c,2,3,4);
    }
 
    /**
     * Verify disjoint intersection is empty and self-intersection is unchanged.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIntersectDisjointAndSameOperand() {
        IntegerSet a=s(1,2);
        assertSet(a.intersect(s(3,4)));
        assertSet(a.intersect(a),1,2);
    }
 
    /**
     * Modify the intersection result and verify both input sets remain unchanged.
     * Assignment 5 equivalent: 3 point(s).
     */
    @Test
    public void testIntersectIndependentResult() {
        IntegerSet a=s(1,2),c=s(2,3),r=a.intersect(c);
        assertNotSame(a,r);
        assertNotSame(c,r);
        r.add(7);
        r.remove(2);
        assertSet(a,1,2);
        assertSet(c,2,3);
        assertSet(r,7);
    }
 
    // ===== diff() =====
 
    /**
     * Verify A.diff(B) returns elements in A but not B, and distinguish direction.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testDiffDirectionMatters() {
        IntegerSet a=s(1,2,3),c=s(2,4);
        assertSet(a.diff(c),1,3);
        assertSet(c.diff(a),4);
        assertSet(a,1,2,3);
        assertSet(c,2,4);
    }
 
    /**
     * Verify difference with an empty set and difference with itself.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testDiffEmptyAndSameOperand() {
        IntegerSet a=s(1,2);
        assertSet(a.diff(s()),1,2);
        assertSet(s().diff(a));
        assertSet(a.diff(a));
    }
 
    /**
     * Modify the difference result and verify neither input changes.
     * Assignment 5 equivalent: 3 point(s).
     */
    @Test
    public void testDiffIndependentResult() {
        IntegerSet a=s(1,2,3),c=s(2,4),r=a.diff(c);
        assertNotSame(a,r);
        assertNotSame(c,r);
        r.remove(1);
        r.add(9);
        assertSet(a,1,2,3);
        assertSet(c,2,4);
        assertSet(r,3,9);
    }
 
    // ===== complement() =====
 
    /**
     * Verify A.complement(B) returns elements in B but not A.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testComplementReverseDifference() {
        IntegerSet a=s(1,2,3),c=s(2,4,5);
        assertSet(a.complement(c),4,5);
        assertSet(c.complement(a),1,3);
        assertSet(a,1,2,3);
        assertSet(c,2,4,5);
    }
 
    /**
     * Verify complement with an empty receiver and with an empty argument.
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testComplementEmptyOperands() {
        IntegerSet a=s(1,2);
        assertSet(s().complement(a),1,2);
        assertSet(a.complement(s()));
        assertSet(s().complement(s()));
    }
 
    /**
     * Modify the complement result and verify neither input changes.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testComplementIndependentResult() {
        IntegerSet a=s(1,2),c=s(2,3),r=a.complement(c);
        assertNotSame(a,r);
        assertNotSame(c,r);
        r.add(9);
        r.remove(3);
        assertSet(a,1,2);
        assertSet(c,2,3);
        assertSet(r,9);
    }
 
    // ===== isSubsetOf() =====
 
    /**
     * Verify a proper subset is recognized.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsSubsetOfProperSubset() {
        assertTrue(s(1,2).isSubsetOf(s(1,2,3)));
        assertFalse(s(1,2,3).isSubsetOf(s(1,2)));
    }
 
    /**
     * Verify a set with an element missing from the other set is not a subset.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsSubsetOfNotSubset() {
        assertFalse(s(1,4).isSubsetOf(s(1,2,3)));
    }
 
    /**
     * Verify equal sets are subsets of each other.
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testIsSubsetOfEqualSets() {
        IntegerSet a=s(1,2),c=s(2,1);
        assertTrue(a.isSubsetOf(c));
        assertTrue(c.isSubsetOf(a));
    }
 
    /**
     * Verify the empty set is a subset of a nonempty set, but not vice versa.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsSubsetOfEmptyCases() {
        IntegerSet a=s(1);
        assertTrue(s().isSubsetOf(a));
        assertFalse(a.isSubsetOf(s()));
        assertTrue(s().isSubsetOf(s()));
    }
 
    // ===== isDisjoint() =====
 
    /**
     * Verify disjoint sets return true.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsDisjointNoOverlap() {
        assertTrue(s(1,2).isDisjoint(s(3,4)));
        assertTrue(s(3,4).isDisjoint(s(1,2)));
    }
 
    /**
     * Verify overlapping sets return false.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsDisjointOverlap() {
        assertFalse(s(1,2).isDisjoint(s(2,3)));
        assertFalse(s(2,3).isDisjoint(s(1,2)));
    }
 
    /**
     * Verify disjointness with an empty set and with the same nonempty object.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsDisjointEmptyAndSameOperand() {
        IntegerSet a=s(1,2);
        assertTrue(a.isDisjoint(s()));
        assertTrue(s().isDisjoint(a));
        assertFalse(a.isDisjoint(a));
        assertTrue(s().isDisjoint(s()));
    }
 
    // ===== symmetricDiff() =====
 
    /**
     * Verify symmetric difference contains elements appearing in exactly one set.
     * Assignment 5 equivalent: 3 point(s).
     */
    @Test
    public void testSymmetricDiffPartiallyOverlappingSets() {
        IntegerSet a=s(1,2,3),c=s(2,3,4);
        assertSet(a.symmetricDiff(c),1,4);
        assertSet(a,1,2,3);
        assertSet(c,2,3,4);
    }
 
    /**
     * Verify symmetric difference of identical sets is empty.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testSymmetricDiffIdenticalSets() {
        IntegerSet a=s(1,2);
        assertSet(a.symmetricDiff(s(2,1)));
        assertSet(a.symmetricDiff(a));
    }
 
    /**
     * Verify behavior with an empty set and with disjoint sets.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testSymmetricDiffEmptyAndDisjointSets() {
        IntegerSet a=s(1,2);
        assertSet(a.symmetricDiff(s()),1,2);
        assertSet(s().symmetricDiff(a),1,2);
        assertSet(a.symmetricDiff(s(3,4)),1,2,3,4);
    }
 
    /**
     * Modify the result and verify both input sets remain unchanged.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testSymmetricDiffIndependentResult() {
        IntegerSet a=s(1,2),c=s(2,3),r=a.symmetricDiff(c);
        assertNotSame(a,r);
        assertNotSame(c,r);
        r.remove(1);
        r.add(9);
        assertSet(a,1,2);
        assertSet(c,2,3);
        assertSet(r,3,9);
    }
 
    // ===== isEmpty() =====
 
    /**
     * Verify a newly constructed set is empty.
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testIsEmptyNewSet() {
        assertTrue(s().isEmpty());
    }
 
    /**
     * Verify a set with an element is not empty.
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testIsEmptyPopulatedSet() {
        assertFalse(s(1).isEmpty());
    }
 
    /**
     * Clear a populated set and verify it is empty.
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testIsEmptyAfterClear() {
        IntegerSet a=s(1,2);
        a.clear();
        assertTrue(a.isEmpty());
        assertEquals(0,a.length());
    }
 
    // ===== toString() =====
 
    /**
     * Verify elements appear in ascending numeric order regardless of insertion order.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testToStringAscendingOrder() {
        assertEquals("[-10, -1, 2, 30]",s(30,2,-10,-1).toString());
    }
 
    /**
     * Verify an empty set formats as [].
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testToStringEmptyFormatting() {
        assertEquals("[]",s().toString());
    }
 
    /**
     * Verify comma-space formatting, brackets, and duplicate suppression.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testToStringExactSpacingAndDuplicates() {
        assertEquals("[1, 2, 10]",s(10,1,2,2,1).toString());
    }
 
    /** Constructs a fresh set from the supplied values. */
    private static IntegerSet s(int... values) {
        IntegerSet result = new IntegerSet();
        for (int value : values) result.add(value);
        return result;
    }

    /** Verifies exact membership, not just size. */
    private static void assertSet(IntegerSet actual, int... values) {
        IntegerSet expected = s(values);
        assertTrue(expected.equals(actual), "Expected " + expected + " but got " + actual);
        assertEquals(expected.length(), actual.length());
    }
}
