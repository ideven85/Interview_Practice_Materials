import assert from 'assert';

/**
 * Represents an immutable sports team.
 */
export class Team {
    
    // Abstraction function:
    //   TODO
    // Representation invariant:
    //   TODO
    // Safety from rep exposure:
    //   TODO
    
    // checks the rep invariant
    private checkRep(): void {
        // TODO
    }
    
    /**
     * Make a new team with the given city and team name
     * @param home city/town/school where this team is from, e.g. "MIT"
     * @param name team name, e.g. "Beavers"
     */
    constructor(
        public readonly home: string,
        public readonly name: string,
    ) {
        this.checkRep();
    }
    
    /**
     * @inheritdoc
     */
    public toString(): string {
        return this.home + " " + this.name;
    }
    
    // TODO equalValue
}
