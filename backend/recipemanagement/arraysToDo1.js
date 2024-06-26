

const pushToFront = (arr, value) =>{

    arr = [value,...arr]
    return arr

} 

console.log(pushToFront([5,7,2,3], 8))

const popFront = (arr) => {

    let [value, ...newarr] = arr
    console.log(`Popped array: ${newarr}`)
    arr = newarr
    return value
}

console.log(popFront([5,7,2,3]))