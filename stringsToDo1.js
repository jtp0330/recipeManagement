// Strings To Do 1
// Write functions using the JavaScript language for all challenges. Use only a single JavaScript file for this assignment. Do not use built-in methods (unless otherwise instructed). (.length is a property, and is allowed.)

// Remove Blanks
// Create a function that, given a string, returns all of that string’s contents, but without blanks. 
const removeBlanks = (str) =>{
    let new_str = ""
    let start =0
    let end = str.length

    while (start < end)
    {
        if(str[start] !== ' '){
            new_str += str[start];
        }
        start++;
    }
    return new_str;
}

// Examples:

// removeBlanks(" Pl ayTha tF u nkyM usi c ") => "PlayThatFunkyMusic"
// removeBlanks("I can not BELIEVE it's not BUTTER") => "IcannotBELIEVEit'snotBUTTER"
console.log("Exercise 1:")
console.log(removeBlanks(" Pl ayTha tF u nkyM usi c "))
console.log(removeBlanks("I can not BELIEVE it's not BUTTER"))
console.log("")

// Get Digits
// Create a JavaScript function that given a string, returns the integer made from the string’s digits. You are allowed to use isNaN() and Number().

const getDigits = (str) => {
    let digit_str = "";

    for(let i = 0; i < str.length; i++)
        {
            if(!isNaN(str[i]) && (Number(str[i]) || str[i] === '0'))
                {
                    digit_str += str[i];
                }
        }
    return Number(digit_str);
}
// Examples:

// getDigits("abc8c0d1ngd0j0!8") => 801008

// getDigits("0s1a3y5w7h9a2t4?6!8?0") => 1357924680
console.log("Exercise 2:")
console.log(getDigits("abc8c0d1ngd0j0!8")) 
console.log(getDigits("0s1a3y5w7h9a2t4?6!8?0"))
console.log("")


// Acronyms
// Create a function that, given a string, returns the string’s acronym (first letter of the word capitalized). You are allowed to use .split() and .toUpperCase().

const acronym = (str) => {
    let acronym = "";
    //split string into array of strings, delimited/separated by space
    let strings = str.split(" ");

    for(let i =0; i < str.length; i++)
    {
        //append the uppercase version of each letter to result string
        let curr_word = strings[i]
        acronym += curr_word ? curr_word[0].toUpperCase() : '';
    }

    return acronym;
}
// acronym(" there's no free lunch - gotta pay yer way. ") => "TNFL-GPYW". 

// acronym("Live from New York, it's Saturday Night!") => "LFNYISN".
console.log("Exercise 3:")
console.log(acronym(" there's no free lunch - gotta pay yer way. ")) 
console.log(acronym("Live from New York, it's Saturday Night!"))
console.log("")



// Count Non-Spaces
// Create a function that, given a string, returns the number of non-space characters found in the string. 

const countNonSpaces = (str)=>{
    let nonSpaces = 0;

    for (let i = 0; i < str.length; i++)
        {
            if(str[i] !== ' '){
                nonSpaces++;
            }
        }
        return nonSpaces;
}
// Examples:
console.log("Exercise 4:")
// countNonSpaces("Honey pie, you are driving me crazy") => 29
// countNonSpaces("Hello world !") => 11
console.log(countNonSpaces("Honey pie, you are driving me crazy")) 
console.log(countNonSpaces("Hello world !")) 
console.log("")


// Remove Shorter Strings
// Create a function that, given an array of strings and a numerical value, returns an array that only contains strings longer than or equal to the given value.

const removeShorterStrings = (strs, len) =>{
    let new_strs = [];

    for (let i = 0; i < strs.length; i++)
        {
            if(strs[i].length >= len)
                {
                    new_strs[new_strs.length] = strs[i];
                }
                
        }
        return new_strs;
}
// Examples:
console.log("Exercise 5:")
// removeShorterStrings(['Good morning', 'sunshine', 'the', 'Earth', 'says', 'hello'], 4) => ['Good morning', 'sunshine', 'Earth', 'says', 'hello']
// removeShorterStrings(['There', 'is', 'a', 'bug', 'in', 'the', 'system'], 3) => ['There', 'bug', 'the', 'system']
console.log(removeShorterStrings(['Good morning', 'sunshine', 'the', 'Earth', 'says', 'hello'], 4)) 
console.log(removeShorterStrings(['There', 'is', 'a', 'bug', 'in', 'the', 'system'], 3))
console.log("")