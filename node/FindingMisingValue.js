var arr = [ 26,24,25,22,21,27,28,29,30 ];
arr.sort()
// console.log(arr);
var i,x,y;

for (let i = 0; i < arr.length; i++) {
    x = arr[i];
    y = arr[i+1];
    if(x+1 != y){
        console.log(x+1);
        break;
    }else if((x+1 == y) && (i==arr.length-1)){
        console.log(y+1);
    }
  }