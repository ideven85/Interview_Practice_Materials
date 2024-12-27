const greaterThan = (x) =>{
    return y => y>x?y:x;
}
const noisy = f => {
    return (...args) => {
        console.log(`Called with ${args}`);
        const result = f(...args);
        console.log(`Called with ${args} returned result ${result}`);
        return result;

    }
}
const factorial = (n)=>{
    return n<2?1:n*factorial(n-1);
}
const x=factorial(6),y=factorial(7);

function lessThan(x, y) {
    return y>x?x:y;
}

console.log(noisy(Math.min)(
    greaterThan(x+y)(x-y),lessThan(x+y,x-y)
));

console.log(greaterThan(false)(1))