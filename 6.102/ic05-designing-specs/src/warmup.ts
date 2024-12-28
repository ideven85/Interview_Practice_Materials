
export function split(s: string, sep: string): Array<string>
// requires: sep.length = 1
// effects: returns array `v` such that ???
{ throw new Error("not implementing today"); }

/*
Consider these possible pieces of the postcondition we could write in the ??? above
(these are just pieces, not complete postconditions)

1. Why might we choose *not* to write 
        `v` is nonempty
    in the postcondition?



2. Why might we choose *not* to write 
        `v` has no empty strings
    in the postcondition?



3. Why might we choose *not* to write
        `v` is made by finding the first `sep` in `s` and taking the substring
        before that as the first element, then repeating
   in the postcondition?



*/
