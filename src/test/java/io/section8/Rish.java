package io.section8;

public class Rish {
    public static void main(String[] args) {
        int n=20;
//        int j=0;
//        for(int i=1;i<=n;i++){
//            j++;
//            if(j%3==0){
//                n+=1;
//            }
//        }
        int k=n;
        while(n>=3){
            k+=n/3;
            n=n/3;
        }
        System.out.println(k);
    }
}
