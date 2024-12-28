
/**
 * @param start must be integer
 * @param end must be integer >= start
 * @returns array of consecutive integers starting with start and ending with end (exclusive)
 */
export function range(start: number, end: number): Array<number> {
    const length = end - start;
    return new Array<number>(length)
               .fill(0)
               .map((value: number, index: number) => start + index);
}

/**
 * @returns MIT majors that are just numeric (like course 6)
 */
export function getNumberedMajors(): Array<number> {

    // TODO #1: comment out the existing code of this method and replace it
    //          with one return statement using range() and filter().
    //          Use no for-loops, no if-statements, and no array mutation.
    
    // return range(YOUR_CODE_HERE).filter(YOUR_CODE_HERE);
    
    const majors: Array<number> = [];
    for (let major = 1; major <= 24; major++) {
        majors.push(major);
    }
    for (let notAMajor of [13, 19, 23]) {
        const i = majors.indexOf(notAMajor)
        if (i !== -1) {
            majors.splice(i, 1);
        }
    }
    return majors;
}

/**
 * @returns all MIT majors (e.g. "6", "CMS")
 */
export function getAllMajors(): Array<string> {

    // TODO #2: comment out the existing code of this method and replace it
    //          with one return statement using the structure below.
    //          Use no for-loops, no if-statements, and no array mutation.
    
    // return getNumberedMajors().YOUR_CODE_HERE
    //        .concat(
    //            ["A", "W", "G", "H", "L", "M"].YOUR_CODE_HERE
    //        )
    //        .concat(YOUR_CODE_HERE);
    
    let majors: Array<string> = [];
    for (const major of getNumberedMajors()) {
        majors.push(major.toString());
    }
    for (const suffix of ["A", "W", "G", "H", "L", "M"]) {
        majors.push("21" + suffix);
    }
    majors = majors.concat(["CMS", "STS", "WGS"]);
    return majors;
}

/**
 * @param majors array of MIT majors, e.g. "6", "CMS"
 * @returns number of elements of majors
 */
export function numberOfMajors(majors: Array<string>): number {

    // TODO #3: comment out the existing code of this method and do the same
    //          thing with reduce() instead of length.
    
    // return majors.reduce((count: number, nextMajor: string) => YOURCODEHERE, 0);
    
    return majors.length;
}

/**
 * @param majors array of MIT majors, e.g. "6", "CMS"
 * @returns the elements of majors separated by ","
 */
export function commaSeparatedMajors(majors: Array<string>): string {

    // TODO #4: comment out the existing code of this method and do the same
    //          thing with reduce() instead of join().
    
    // return majors.reduce((s: string, t: string) => YOUR_CODE_HERE);
    // hint: you may also need try-catch
    
    return majors.join(",");
}

/**
 * @param majors array of MIT majors, e.g. "6", "CMS"
 * @returns urls that point to pages in the MIT course catalog for those majors 
 */
export function getCatalogUrls(majors: Array<string>): Array<string> {

    // TODO #5: comment out the existing code of this method and replace it
    //          with one return statement using flatMap().
    //          Use no for-loops, no if-statements, and no array mutation.
    
    // return majors.flatMap((major: string) => YOUR_CODE_HERE);
    
    const urls: Array<string> = [];
    for (const major of majors) {
        for (const suffix of ["a", "b", "c"]) {
            urls.push("http://student.mit.edu/catalog/m" + major + suffix + ".html");
        }
    }
    return urls;
}



/**
 * @param start must be integer
 * @param end must be integer >= start
 * @returns sequence of consecutive integers starting with start and ending with end (exclusive)
 */
export function* range2(start: number, end: number): Generator<number> {
    // TODO #6: implement with a loop that uses `yield`
}

/**
 * @param iterable sequence of values
 * @param mapper function applied to each value
 * @returns sequence of results of calling `mapper` on each value from the iterable, in the same order
 */
export function* map<T, U>(iterable: Iterable<T>, mapper: (item: T) => U): Generator<U> {
    // TODO #7: implement with a loop that uses `yield`
}

/**
 * @param iterable sequence of values
 * @param predicate function applied to each value
 * @returns the elements of the iterable for which `predicate` returned true, in the same order
 */
export function* filter<T>(iterable: Iterable<T>, predicate: (item: T) => boolean): Generator<T> {
    // TODO #7: implement with a loop that uses `yield`
}
