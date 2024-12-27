const unless= (test,then) => {
     if(!test())
        then();

}
const repeat = (x) => {

}

repeat(3,n => {
    unless(n%2===1,() =>{
        console.log(`${n} is even `);
    })
});

