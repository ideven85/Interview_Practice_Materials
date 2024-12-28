import assert from 'assert';

import { Team } from '../src/Team.js';
import { Bracket, bracketize } from '../src/Bracket.js';

describe('Bracket', function() {
    
    // MISSING testing strategy (not a todo for today)
    
    it('covers single team', function() {
        const team = new Team('Brooklyn', 'Dodgers');
        const singleTeam = bracketize([ team ]);
        const winner = null; // TODO-2 get winner
        assert(false); // TODO-2 winner is team
    });
    
    it('covers one match', function() {
        const team1 = new Team('Mudville', 'Mudders');
        const team2 = new Team('East Podunk', 'Bears');
        const oneMatch = bracketize([ team1, team2 ]);
        const winner = null; // TODO-2 get winner
        assert(false); // TODO-2 winner is team1
    });
    
    // MISSING test additional partitions (not a todo for today)
});
