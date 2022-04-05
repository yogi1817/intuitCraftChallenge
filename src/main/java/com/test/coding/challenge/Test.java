package com.test.coding.challenge;

public class Test {

//    public static void main(String args[]){
//        int A[]  = {1,1,1,1,1};
//        System.out.println(solution(A, 0));
//    }
//
//    public static boolean solution(int[] A, int K) {
//        int n = A.length;
//        for (int i = 0; i < n - 1; i++) {
//            if (A[i] + 1 < A[i + 1])
//                return false;
//        }
//        if (A[0] != 1 && A[n - 1] != K)
//            return false;
//        else
//            return true;
//    }

    public static void main(String args[]){
        System.out.println(solution("A2Le", "2pL1"));
    }

    public static boolean solution(String S, String T) {
        String newS = convertToQuestionMark(S);
        String newT = convertToQuestionMark(T);
        return equalsIgnoreQuestionMark(newS, newT);
    }

    private static String convertToQuestionMark(String T){
        int i = 0;
        char[] chArray = T.toCharArray();
        StringBuffer questionMarkString = new StringBuffer();
        while(i < T.length()){
            if(Character.isDigit(chArray[i])){
                for(int j =0; j< Integer.parseInt(""+chArray[i]); j++){
                    questionMarkString.append("?");
                }
            }else{
                questionMarkString.append(chArray[i]);
            }
            i++;
        }
        return questionMarkString.toString();
    }

    private static boolean equalsIgnoreQuestionMark(String s1, String s2){
        int i = 0;
        char[] ch1Array = s1.toCharArray();
        char[] ch2Array = s2.toCharArray();

        while(i<s1.length() && i<s2.length()){
            if(ch1Array[i]=='?' || ch2Array[i]=='?'){
                i++;
            }else if(ch1Array[i] != ch2Array[i]){
                return false;
            }else{
                i++;
            }
        }

        return true;
    }
}


