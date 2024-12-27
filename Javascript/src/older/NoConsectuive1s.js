// //{ Driver Code Starts
// //Initial Template for javascript

// 'use strict';

// process.stdin.resume();
// process.stdin.setEncoding('utf-8');

// let inputString = '';
// let currentLine = 0;

// process.stdin.on('data', inputStdin => {
//     inputString += inputStdin;
// });

// process.stdin.on('end', _ => {
//     inputString = inputString.trim().split('\n').map(string => {
//         return string.trim();
//     });
    
//     main();
// });

// function readLine() {
//     return inputString[currentLine++];
// }

// function printList(res,n){
//     let s="";
//     for(let i=0;i<n;i++){
//         s+=res[i];
//         s+=" ";
//     }
//     console.log(s);
// }


// function main() {
//     let t = parseInt(readLine());
//     let i = 0;
//     for(;i<t;i++)
//     {
//         let n = parseInt(readLine());
//         let obj = new Solution();
//         let res = obj.countStrings(n);
//         console.log(res);
        
//     }
// }// } Driver Code Ends



// } Driver Code Ends


//User function Template for javascript


/**
 * @param {number} n
 * @returns {number}
*/

class Solution{
     a;
   binary(n){
    if(n===0){
        console.log(this.a);
    
    }else{
        this.a[n-1]=0;
        this.binary(n-1);
        this.a[n-1]=1;
        this.binary(n-1);
    }
    

   }
    printStrings(n){
        this.a = [n];
        this.binary(n);

    }
    countStrings(n){
        //code here
        if(n<=1){
            return n;
        }else{
            let a=0,b=1;
            for(let i=0;i<=n;i++){
                b+=a;
                a=b-a;
            }
            return b;

        }
        
    }
}

const sol = new Solution();
sol.printStrings(4);
console.log(sol.countStrings(4));