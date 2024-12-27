import memoization from "./memoization.js";
import fib from "./memoized_fib.js";


function main(){
    const now = new Date();
    const memoized_fib = memoization(fib);
    console.log(memoized_fib(10));
    console.log(memoized_fib(now.getHours()));

}
main();
