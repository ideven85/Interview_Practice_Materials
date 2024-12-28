import assert from 'assert';
import { isDeepStrictEqual } from 'util';

/**
 * Solver for Sudoku puzzles.
 * 
 * A Sudoku puzzle is a square NxN grid of cells in which the numbers 1..N
 * should be written so that, after the puzzle is solved by filling in all the cells,
 * each number appears exactly once in each row, column, and block,
 * where a block is a sqrt(N) x sqrt(N) grid of cells, and the whole grid is tiled by N blocks.
 * Thus N must be a perfect square: 4, 9, 16, etc.
 * The conventional size for human solving is N=9.
 * See http://en.wikipedia.org/wiki/Sudoku for more information.
 * 
 * In the functions below, the puzzleGrid:number[][] parameter has the following preconditions:
 *  - ... precondition on size
 *  - ... precondition on individual values
 *  - ... precondition on overall values
 */


export const blockSize = 3;
export const puzzleSize = blockSize * blockSize;


// TODO: uncomment the surrounding class declaration
//export class Sudoku {
    
    /**
     * @param puzzleGrid (see above for precondition on puzzleGrid)
     * @param row    0 <= row < puzzleSize
     * @param column 0 <= column < puzzleSize
     * @returns the row of the puzzle that contains the cell at [row][column],
     *          using 1...puzzleSize for cells that contain numbers, and 0 for empty cells
     */
    export function getRow(puzzleGrid: number[][], row: number, column: number): number[] {
        return puzzleGrid[row].slice();
    }
    
    /**
     * @param puzzleGrid (see above for precondition on puzzleGrid)
     * @param row    0 <= row < puzzleSize
     * @param column 0 <= column < puzzleSize
     * @returns the column of the puzzle that contains the cell at [row][column],
     *          using 1...puzzleSize for cells that contain numbers, and 0 for empty cells
     */
    export function getColumn(puzzleGrid: number[][], row: number, column: number): number[] {
        const cells = [];
        for (let ii = 0; ii < puzzleSize; ii++) {
            cells.push(puzzleGrid[ii][column]);
        }
        return cells;
    }
    
    /**
     * @param puzzleGrid (see above for precondition on puzzleGrid)
     * @param row    0 <= row < puzzleSize
     * @param column 0 <= column < puzzleSize
     * @returns the block of the puzzle that contains the cell at [row][column],
     *          using 1...puzzleSize for cells that contain numbers, and 0 for empty cells,
     *          returned in order from left to right, top to bottom
     */
    export function getBlock(puzzleGrid: number[][], row: number, column: number): number[] {
        const cells = [];
        const startRow = Math.floor(row / blockSize) * blockSize;
        const startColumn = Math.floor(column / blockSize) * blockSize;
        for (let cellRow = 0; cellRow < blockSize; cellRow++) {
            for (let cellColumn = 0; cellColumn < blockSize; cellColumn++) {
                cells.push(puzzleGrid[startRow + cellRow][startColumn + cellColumn]);
            }
        }
        return cells;
    }
    
    /**
     * @param puzzleGrid (see above for precondition on puzzleGrid)
     * @returns true if the puzzle can be solved, and modifies puzzleGrid to fill in blank cells
     *          with a solution; returns false if no solution exists
     */
    export function solve(puzzleGrid: number[][]): boolean {
        // find an empty cell
        for (let row = 0; row < puzzleSize; row++) {
            for (let column = 0; column < puzzleSize; column++) {
                if (puzzleGrid[row][column] === 0) {
                    // found an empty cell; try to fill it
                    const rowColumnBlock = [
                        getRow(puzzleGrid, row, column),
                        getColumn(puzzleGrid, row, column),
                        getBlock(puzzleGrid, row, column),
                    ];
                    const alreadyUsed = new Set<number>();
                    for (const used of rowColumnBlock) {
                        for (const number of used) {
                            alreadyUsed.add(number);
                        }
                    }
                    for (let number = 1; number <= puzzleSize; number++) {
                        if ( ! alreadyUsed.has(number)) {
                            puzzleGrid[row][column] = number;
                            if (solve(puzzleGrid)) {
                                return true;
                            }
                            // couldn't solve it with that choice,
                            // so clear the cell again and backtrack
                            puzzleGrid[row][column] = 0;
                        }
                    }
                    return false; // nothing works for this cell! give up and backtrack
                }
            }
        }
        return true; // no empty cells found, so puzzle is already solved
    }
    
    /**
     * @param puzzleGrid (see above for precondition on puzzleGrid)
     * @returns true if and only if each row, column, and block of the puzzle uses all the
     *          numbers 1...puzzleSize exactly once
     */
    export function isSolved(puzzleGrid: number[][]): boolean {
        // make the set of expected numbers
        const solved = new Set<number>();
        for (let number = 1; number <= puzzleSize; number++) {
            solved.add(number);
        }
        // look at each row and column (using cells on the diagonal)
        for (let ii = 0; ii < puzzleSize; ii++) {
            if ( ! isDeepStrictEqual(new Set(getRow(puzzleGrid, ii, ii)), solved)) {
                return false;
            }
            if ( ! isDeepStrictEqual(new Set(getColumn(puzzleGrid, ii, ii)), solved)) {
                return false;
            }
        }
        // look at each block (using the upper-left cells)
        for (let row = 0; row < puzzleSize; row += blockSize) {
            for (let column = 0; column < puzzleSize; column += blockSize) {
                if ( ! isDeepStrictEqual(new Set(getBlock(puzzleGrid, row, column)), solved)) {
                    return false;
                }
            }
        }
        return true; // all rows, columns, and blocks are correct
    }
    
    /**
     * @param puzzleGrid (see above for precondition on puzzleGrid)
     * @returns string representation of puzzle, suitable for printing
     */
    export function toString(puzzleGrid: number[][]): string {
        let result = '';
        for (let row = 0; row < puzzleSize; row++) {
            if (row > 0 && row % blockSize === 0) {
                for (let column = 0; column < puzzleSize; column++) {
                    if (column > 0 && column % blockSize === 0) {
                        result += '+';
                    }
                    result += '-';
                }
                result += '\n';
            }
            for (let column = 0; column < puzzleSize; column++) {
                if (column > 0 && column % blockSize === 0) {
                    result += '|';
                }
                const cell = puzzleGrid[row][column];
                if (cell === 0) {
                    result += ' ';
                } else {
                    result += puzzleGrid[row][column];
                }
            }
            result += '\n';
        }
        return result;
    }
    
    /**
     * @param puzzleGrid (see above for precondition on puzzleGrid)
     * @returns a copy of puzzleGrid
     */
    export function copyPuzzle(puzzleGrid: number[][]): number[][] {
        const newPuzzle = [];
        for (const row of puzzleGrid) {
            newPuzzle.push(row.slice());
        }
        return newPuzzle;
    }
    
//}
