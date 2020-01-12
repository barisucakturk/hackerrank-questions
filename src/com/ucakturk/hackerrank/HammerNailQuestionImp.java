package com.ucakturk.hackerrank;

public class HammerNailQuestionImp {


    public int hammer(int[]A, int Y) {

        int totalElementCount = A.length;
        int maxPopulatedElementCount = 0;
        int possibleNailCountForMaxPopulatedElement = Y;
        int result = maxPopulatedElementCount + possibleNailCountForMaxPopulatedElement;

        int tempElement = A[0];
        int tempElementCount = 0;
        int tempResult;

        for (int i = 0; i < A.length; i++) {
            if (tempElement != A[i]) {
                tempResult = calculateMax(totalElementCount, tempElementCount, totalElementCount - i, Y);
                result = getResult(result, tempElement, tempElementCount, tempResult);
                tempElement = A[i];
                tempElementCount = 1;
            } else {
                tempElementCount++;
            }
        }
        //calculate for the last element
        tempResult = calculateMax(totalElementCount, tempElementCount, 0, Y);
        return getResult(result, tempElement, tempElementCount, tempResult);

    }

    private int getResult(int result, int tempElement, int tempElementCount, int tempResult) {
        int maxPopulatedElement;
        int maxPopulatedElementCount;
        if (tempResult >= result) {
            maxPopulatedElement = tempElement;
            maxPopulatedElementCount = tempElementCount;
            result = tempResult;
            System.out.println("maxPopulatedElement: " + maxPopulatedElement);
            System.out.println("maxPopulatedElementCount: " + maxPopulatedElementCount);
            System.out.println("Result: " + result);
        }
        return result;
    }

    private int calculateMax(int totalElementCount, int tempElementCount, int tempElementAfterCount,int Y) {
        int possibleNailCountForTempElement;
        int tempElementBeforeCount = totalElementCount - tempElementAfterCount - tempElementCount;
        if (tempElementAfterCount >= Y) {
            possibleNailCountForTempElement = Y;
        } else if (tempElementBeforeCount >= (Y - tempElementAfterCount)) {
            possibleNailCountForTempElement = tempElementAfterCount;
        } else {
            possibleNailCountForTempElement = tempElementAfterCount- ((Y - tempElementAfterCount)-tempElementBeforeCount);
        }
        return tempElementCount + possibleNailCountForTempElement;
    }

    public static void main(String[] args) {
        // 1-10.000 range
         int[] A = { 1, 1, 3, 3, 3, 3, 5, 5 };
        // 0 - n range
         int Y = 3;
        HammerNailQuestionImp imp = new HammerNailQuestionImp();
        System.out.println(imp.hammer(A,Y));

    }
}
