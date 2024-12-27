function f(s: string, arr: Array<string>): void {
    s.concat("b");
    s += "c";
    arr.push("d");
}
let t: string = "a";
let tarr: Array<string> = [t];
f(t, tarr);
console.log(t,tarr);


