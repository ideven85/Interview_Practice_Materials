/**
 * @param {number} millis
 */
async function sleep(millis) {

}


 // let t = Date.now()
//  sleep(100).then(() => console.log(Date.now() - t)) // 100

setTimeout(()=>console.log("Tick tock"),500);
let fifteen = Promise.resolve(15);
fifteen.then(value => console.log(value));

Array.prototype.last = function() {

};
