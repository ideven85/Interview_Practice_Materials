import assert from 'assert';
import { Bag } from './Bag.js';

/**
 * A mutable multiset (also called a bag) whose elements are strings.
 * In a multiset, elements may occur more than once.
 * For example, { a, a, a, b, b } is a multiset with 3 occurrences of a and 2 occurrences of b.
 * { a^3, b^2 } is another common way to write it.
 */
export class BasicBag {
    
    private elements: Array<string> = [];
    
    // Representation invariant:
    //   TODO
    // Abstraction function:
    //   AF(elements) = TODO
    // Safety from rep exposure:
    //   TODO
    
    private checkRep(): void {
    }
    
    /**
     * Make a new empty bag.
     */
     public constructor() {
        this.checkRep();
    }
    
    /**
     * Get size of the bag.
     * @returns the number of elements in this bag
     */
    public size(): number {
        this.checkRep();
        return this.elements.length;
    }
    
    /**
     * Test for membership.
     * @param elt a possible element
     * @returns true iff this bag contains elt
     */
    public contains(elt: string): boolean {
        this.checkRep();
        return this.elements.includes(elt);
    }
    
    /**
     * Modifies this bag by adding one occurrence of x to the bag.
     * @param elt element to add
     */
    public add(elt: string): void {
        this.elements.push(elt);
        this.checkRep();
    }
    
    /**
     * Modifies this bag by removing one occurrence of elt, if found.
     * If elt is not found in the bag, has no effect.
     * @param elt element to remove
     */
    public remove(elt: string): void {
        const i = this.elements.indexOf(elt);
        if (i !== -1) {
            this.elements.splice(i, 1);
        }
        this.checkRep();
    }

}
