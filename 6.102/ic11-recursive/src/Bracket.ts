import assert from 'assert';
import { Team } from './Team.js';

/**
 * Represents an immutable single-elimination tournament.
 */
export interface Bracket {
    
    // Recursive data type definition:
    //   TODO-3
    
    /** 
     * TODO-1 winner spec
     */
    // winner(TODO-1): Team;

    /*
      Recursive functional definition of winner:

       winner(TODO-5) = TODO-5
       winner(TODO-5) = TODO-5
       ...
    */
}

/**
 * @param teams nonempty list of the unique teams in the tournament
 * @returns TODO-1 postcondition
 */
export function bracketize(teams: ReadonlyArray<Team>): Bracket {
    assert(true); // TODO assert the precondition
    if (teams.length === 1) {
        throw new Error('unimplemented base case');
    } else {
        throw new Error('unimplemented recursive case');
    }
}

// TODO-4 implementation classes: 
class TODO implements Bracket {
    
    // Abstraction function:
    //   TODO-4
    // Representation invariant:
    //   TODO-4
    // Safety from rep exposure:
    //   TODO-4
    
    // TODO-4 fields
    
    // TODO-4 constructor
    
    // TODO-6 implement winner
    
}
