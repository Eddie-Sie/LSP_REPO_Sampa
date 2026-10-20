
package org.howard.edu.lsp.assignment5;

import java.util.TreeSet;

/**
 * Represents a mathematical set of unique integers.
 * Elements are maintained in ascending order.
 * Set operations return new independent IntegerSet objects.
 */
public class IntegerSet {

    private final TreeSet<Integer> elements;

    /**
     * Constructs an empty IntegerSet.
     */
    public IntegerSet() {
        elements = new TreeSet<>();
    }

    /**
     * Removes all elements from this set.
     */
    public void clear() {
        elements.clear();
    }

    /**
     * Returns the number of elements in this set.
     * @return the size of this set
     */
    public int length() {
        return elements.size();
    }

    /**
     * Determines whether two sets contain the same elements.
     * @param b the set to compare
     * @return true if both sets are equal
     */
    public boolean equals(IntegerSet b) {
        return b != null && elements.equals(b.elements);
    }

    /**
     * Checks whether an integer belongs to this set.
     * @param value the integer to check
     * @return true if the integer exists
     */
    public boolean contains(int value) {
        return elements.contains(value);
    }

    /**
     * Returns the largest integer in this set.
     * @return the largest element
     * @throws IllegalStateException if the set is empty
     */
    public int largest() {
        if (isEmpty()) {
            throw new IllegalStateException("Set is empty");
        }
        return elements.last();
    }

    /**
     * Returns the smallest integer in this set.
     * @return the smallest element
     * @throws IllegalStateException if the set is empty
     */
    public int smallest() {
        if (isEmpty()) {
            throw new IllegalStateException("Set is empty");
        }
        return elements.first();
    }

    /**
     * Adds an integer, ignoring duplicates.
     * @param item the integer to add
     */
    public void add(int item) {
        elements.add(item);
    }

    /**
     * Removes an integer if it exists.
     * @param item the integer to remove
     */
    public void remove(int item) {
        elements.remove(item);
    }

    /**
     * Returns a new set containing elements from both sets.
     * @param b the other set
     * @return the union of the two sets
     */
    public IntegerSet union(IntegerSet b) {
        IntegerSet result = new IntegerSet();
        result.elements.addAll(elements);
        result.elements.addAll(b.elements);
        return result;
    }

    /**
     * Returns a new set containing common elements.
     * @param b the other set
     * @return the intersection of the sets
     */
    public IntegerSet intersect(IntegerSet b) {
        IntegerSet result = new IntegerSet();
        result.elements.addAll(elements);
        result.elements.retainAll(b.elements);
        return result;
    }

    /**
     * Returns elements in this set but not in b.
     * @param b the other set
     * @return the difference between the sets
     */
    public IntegerSet diff(IntegerSet b) {
        IntegerSet result = new IntegerSet();
        result.elements.addAll(elements);
        result.elements.removeAll(b.elements);
        return result;
    }

    /**
     * Returns elements in b but not in this set.
     * @param b the other set
     * @return the assignment-defined complement
     */
    public IntegerSet complement(IntegerSet b) {
        return b.diff(this);
    }

    /**
     * Determines whether this set is a subset of b.
     * @param b the potential superset
     * @return true if all elements are contained in b
     */
    public boolean isSubsetOf(IntegerSet b) {
        return b.elements.containsAll(elements);
    }

    /**
     * Determines whether two sets have no common elements.
     * @param b the other set
     * @return true if the sets are disjoint
     */
    public boolean isDisjoint(IntegerSet b) {
        return elements.stream().noneMatch(b.elements::contains);
    }

    /**
     * Returns elements appearing in exactly one of the sets.
     * @param b the other set
     * @return the symmetric difference
     */
    public IntegerSet symmetricDiff(IntegerSet b) {
        IntegerSet result = union(b);
        result.elements.removeAll(intersect(b).elements);
        return result;
    }

    /**
     * Checks whether this set contains no elements.
     * @return true if the set is empty
     */
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    /**
     * Returns a sorted string representation of this set.
     * @return elements enclosed in square brackets
     */
    @Override
    public String toString() {
        return elements.toString();
    }
}

