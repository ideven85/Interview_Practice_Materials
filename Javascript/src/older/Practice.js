new Promise((_, reject) => reject(new Error("Error 1")))
    .then(value => console.log("Handler 1"))
    .catch(reason => {
        console.log("Caught Failure: " + reason)
        return "Nothing"
    })
    .then(value => console.log("Handler 2 ", value))

const promise = new Promise((resolve, reject) =>
    reject(new Error("Error on first promise")))
    .then(value => {
        console.log("In first promise");
        return "Then"
    }).catch(reason => console.log("Error on second promise"+reason))
    .finally(console.log);

// console.log(promise.then(x => {
//     console.log(10);
// }).catch(reason => console.log("Bored of promises"))
//     .finally(console.log));