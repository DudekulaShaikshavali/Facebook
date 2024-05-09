package org.example;

public class ArrayMax {
  public static void main(String[]args){
    int arr[]={5,2,3,4,7};
    int max=0;
    int min=0;
    for(int i=0;i<arr.length;i++){
      if(arr[i] > max){
        max=arr[i];
    }else if(arr[i] < min ){
        min=arr[i];
    }
    }
    System.out.println("Array maximum:"+max);
     System.out.println("Arrayminimum:"+min);
  }
}
