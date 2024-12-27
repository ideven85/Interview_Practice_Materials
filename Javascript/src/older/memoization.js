export default function memoization(fn){
    const cache = {};//Const or Let?
    return function (...args){
        if(!cache[args])
            cache[args] = fn.apply(this,args);
        return cache[args];


    }
}
