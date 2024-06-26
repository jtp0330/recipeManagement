

const pushToFront = (arr, value) =>{

    arr = [value,...arr]
    return arr

} 

console.log(pushToFront([5,7,2,3], 8))

const popFront = (arr) => {
    value=arr[0]
    //TODO
    arr=[...arr]
    console.log(`Popped array: ${arr}`)
    return value
}

console.log(popFront([5,7,2,3], 8))