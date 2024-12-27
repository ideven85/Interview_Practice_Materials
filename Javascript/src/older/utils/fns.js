const square = function (x) {
    return x*x;
}
const double = x => x*2;


const roundTo = (n,step) => {
    const remainder = n%step;
    return n-remainder+ (remainder < step/2?0 : step);
}

const hummus = function(factor) {
    const ingredient = function(amount, unit, name) {
        let ingredientAmount = amount * factor;
        if (ingredientAmount > 1) {
            unit += "s";
        }
        console.log(`${ingredientAmount} ${unit} ${name}`);
    };
    const units = ["can","cup", "cup","clove","tablespoon","teaspoon"];
    const ingredients = ["chickpeas","tahini","lemon juice","garlic oil","olive oil","cumin"];

    const dictionary = {};
    for(let i=0;i<units.length;i++){
        dictionary[units[i]]=ingredients[i];
    }
    console.log(dictionary);


    ingredient(1, "can", "chickpeas");//Why not?
    ingredient(0.25, "cup", "tahini");
    ingredient(0.25, "cup", "lemon juice");
    ingredient(1, "clove", "garlic");
    ingredient(2, "tablespoon", "olive oil");
    ingredient(0.5, "teaspoon", "cumin");
};

const power = (base,exponent) => {
    if(exponent===0)
        return 1;
    if(exponent===1)
        return base;
    else if(exponent%base===0){
        //base = base*base;
        return base*power(base,(Math.round(exponent/2)));
    }else{
        return base*power(base,exponent-1);
    }
}


/**
 * Find factors
 */



const main = () =>{
    console.log(square(double(10)));
    console.log(roundTo(26,8));
    hummus(2);
    console.log(power(70,9));
}

main();