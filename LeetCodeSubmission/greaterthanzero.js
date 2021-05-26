function getNumber(arr) {
  let n = arr.length
  let myMap = new Map()
let counter = 0;

  for (let i = 0; i < n; i++) {
    if (myMap.has(arr[i])) {
      let freq = myMap.get(arr[i])
      count = freq + 1
      myMap.set(arr[i], count)
    } else {
      myMap.set(arr[i], 1)
    }
  }

  while(counter <= arr.length){
    if(myMap.has(counter)){
        counter++;
    }
    else{
        break;
    }
  }
  return counter;
}

let arr = [
  -12, 2, 1, 2, 4, 4, 4, 4, 7, 4, 34, 23, 0, 1, -1, -50, 16, 23, 7, 4, 2, 3
]

console.log(getNumber(arr))
