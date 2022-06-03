var arr = [ 26,24,25,22,23,29,30,27,21 ];
arr.sort()
// console.log(arr);
var i,x,y;
var start = 21;
var array_len = 10;

if(array_len != arr.length){
   for (let i = 0; i < arr.length; i++) {
    x = arr[i];
    y = arr[i+1];
    if(arr[0]!=start){
        console.log(start);
        break;
    }
    else if(x+1 != y){
        console.log(x+1);
        break;
    }else if((x+1 == y) && (i==arr.length-1)){
        console.log(y+1);
        break;
    } 
}
}else{
        console.log("No Missing Values Found");
    }
  