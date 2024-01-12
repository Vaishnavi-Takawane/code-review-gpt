console.log("Let's do it")

const accountId = 1001
let accountEmail ="vaish@gmail.com" //only available within scope
var accountPassword="123"   //prefer not to use as it have block and functional scope
accountCity="Pune"  //without let or var memory can be assigned to variable

//accountId=123 //cannot change const variable

console.table([accountId,accountEmail,accountPassword,accountCity]) //display values in form of table at once


const name="vaishnavi"
const repoCount = 3

console.log(`String interpolation- My name is ${name} and repoCnt is ${repoCount}`)


//-------------String operations------------
console.log("---------String operations-----------");
const gameName =new String('Cricket')

console.log(`Prototype ${gameName.__proto__}`)
console.log((`CharAt- ${gameName.charAt(2)}`))
console.log((`indexOf- ${gameName.indexOf('C')}`))

const newGameName=gameName.substring(0,4) //even -8 is given still start from start
console.log(`substring ${newGameName}`)

const anotherGameName=gameName.slice(-8,4)
console.log(`slice ${anotherGameName}`);

const strWithSpace="   vaishnavi   "
console.log(`str with space - ${strWithSpace}`);
console.log(`trim - ${strWithSpace.trim()}`);   //eliminate extra spaces

console.log(`includes - ${strWithSpace.includes('vaish')}`); //check whether included in str or not

//------------number and math------------
console.log("---------number and math-----------");
const score=400
console.log(`num ${score}`);
console.log(`type of score - ${typeof score}`);

const newScore=new Number(100);
console.log(`num obj - ${newScore}`);
console.log(`type of newscore - ${typeof newScore}`);

console.log(`convert to str print len- ${newScore.toString().length}`);
console.log(`toFixed - ${newScore.toFixed(2)}`);    //100.00

const otherNum= 123.899 //round off and show only 3 digits (124)
console.log(`toPrecision - ${otherNum.toPrecision(3)}`);

const hundreds=1000000
console.log(`toLocaleString - ${hundreds.toLocaleString('en-IN')}`);

//----------Math----------
console.log("---------math----------");

console.log(`random math - ${Math.random()}`); //by def value between 0-1

//---------date-----------
//date is calculated from starting date 1 jan 1970
console.log("---------date-----------");
let myDate = new Date()
console.log(`date- ${myDate}`);
console.log(`date- ${myDate.toString()}`);
console.log(`date- ${myDate.toDateString()}`);
console.log(`date- ${myDate.toLocaleString()}`);
console.log(`date- ${myDate.toLocaleDateString()}.`);

let myNewDate=new Date(2023,0,23)       //0 - Jan month
console.log(`date created ${myNewDate}`);

let myNewDate1=new Date(2023,0,23,5,3)   //5,3 for time    
console.log(`date with time ${myNewDate1}`);

let myNewDate2=new Date("2023-01-04")       //01 - Jan month
console.log(`date ${myNewDate2}`);

let myTimestamp=Date.now()
console.log(`timestamp ${myTimestamp}`);
console.log(` ${myDate.getTime()}`);

console.log(`get month ${myDate.getMonth()}`);  //month start from 0

//-------------------Array--------------
console.log("---------array-----------");
const myArr=[0,1,'Hello']   //hetro array allowed 

myArr.push(4)
console.log(`Hetrogenous Array ${myArr}`);

myArr.pop()
console.log(`After pop Array ${myArr}`);

myArr.unshift(2)    //add ele at first
myArr.shift()       //del ele from first

const newArr=myArr.join() //joins array ele and convert it into string
console.log(`Join ${newArr}`);

console.log(`Slice- ${myArr.slice(1,3)}`);  //takes from original arr. But original arr remains same
console.log(`Splice- ${myArr.splice(1,3)}`); //takes from orginal array. Changes orginal arr therefore only remaining ele are in original


//----------Object--------------
//object literals
const mysym=Symbol("key1")
const user={
    name:"Vaish",
    [mysym]:"key1",
    age:"22",
    isLoggedIn: false
}
console.log("---------Obj values-----------");
console.log(user.name);
console.log(user["name"]);
console.log(typeof user[mysym]);

//Object.freeze(user) //used to freeze obj no changes will be reflected if changed
user.name="abc"
console.log(user.name);

user.greeting=function(){
    console.log(`HI ${this.name}`);
}

user.greeting()

//const instaUser=new Object() //create singleton obj

const instaUser={}  //create normal obj
instaUser.name="Vaish"
instaUser.age="22"

const regUser={     //obj stored in obj
    email:"abc@gmail.com",
    fullname:{
        userfullname:{
            firstname:"abc",
            lastname:"pqr"
        }
    }
}

console.log(regUser.fullname.userfullname.firstname);

//merge obj
const obj1={1:"a",2:"b"}
const obj2={3:"c",4:"d"}

//const obj3=Object.assign({},obj1,obj2)

const obj3={...obj1,...obj2}    //spread obj and assign
console.log(obj3);

console.log('key',Object.keys(user));
console.log('value',Object.values(user));
console.log('entries',Object.entries(user));

//--------------Object deconstructing--------
console.log("-------Obj deconstruction-----");
const {name:n}=user
console.log(n);

//-------------function-----------
console.log("--------function----------");
function sayName(){
    console.log("V");
    console.log("A");
    console.log("I");
    console.log("S");
    console.log("H");
}

sayName() //call
console.log(sayName); //reference

//var arg
console.log("--------var args----------");
function calcPrice(...num){
    return num;
}
console.log(calcPrice(200,100,200));

//------scope------------
console.log("scope");

if(true){
    let a=10
    const b=20
    var c=30
}

//console.log(a);   //a, b are not accessible outside scope but var is available therefore var is not used
//console.log(b);
console.log(c);

//-------arrow function-------------

console.log("-------arrow func-------");
const user1={
    username:"vaish",
    age:"22",
    welcome:function(){
        console.log(`${this.username}, welcome`);
        console.log(this);
    }
}
user1.welcome()
console.log(this);

const greetMe = () =>{  //arrow func
    let name="vaish"
    console.log(this);
}

greetMe()

const addTwo=(num1,num2) => (num1+num2) //no need of return - implicit func
console.log(addTwo(2,3));

//----immediately invoked function expressions (IIFE)

(function dbConnect(){              //()-func def ()-func call
    console.log('DB Connected');
})();

//arrow func cal be used with IIFE
(()=>{
    console.log("DB with arrow");
}
)()

//----for of loop-----
console.log("-----loops-------");

const arr=[1,2,3,4,5,"hello"]
for (const num of arr) {
    console.log(num);
}

//------maps---------
//map contain unique key-value pairs
console.log("--maps--------");
const map=new Map()
map.set('IN','India')
map.set('UK','Kingdom')
map.set('US','States')

for (const [key,value] of map) {
    console.log(key,' :- ',value);
    
}

console.log("----iterate obj---------");
for (const key in user) {   //loop through objects
  console.log(key," :- ",user[key]);
}

console.log("-------for each------");
arr.forEach(function (element) {
    console.log(element);
});

console.log("------for each with arrow func------");
arr.forEach(element => {
    console.log(element);
});

//------filter map and reduce-------------

console.log("---filter---------");
const item=arr.filter((num)=>num>1) //with filter
console.log(item);

const newNum=[]

arr.forEach((num) => {  //without filter
    if(num>1){
        newNum.push(num)
    }
}
)

console.log(newNum);

//----------map--------- 
console.log("------map--------");
const newNum1=arr.map((num)=>num+10)
console.log(newNum1);

const newNum2=arr.map((num) =>{ //chaining
    return num*10
}).map((num)=> num+1)
console.log(newNum2);

//----------reduce-------------
console.log("-----reduce---------");
const arr1=[1,2,3,4,5]
const initial=0
const sum=arr1.reduce(
    function(acc,currVal){
        return acc+currVal
    },initial
)
console.log(sum);
console.log("WELL DONE :)");