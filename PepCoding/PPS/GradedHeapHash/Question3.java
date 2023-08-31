package GradedHeapHash;

import java.util.Scanner;

public class Question3 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int noOfEle = sc.nextInt();

        HashTable hashtable = new HashTable(13, noOfEle);

        for (int i = 0; i < noOfEle; i++) {
            hashtable.hashAndAdd(sc.nextInt());
        }

        int[] res = hashtable.getCollisionMetadata();
        System.out.println("MAX COLLISIONS: " + res[0]);
        System.out.println("MAX COLLISION INDEX: " + res[1]);

        sc.close();
    }

}

class HashTable {
    int[][] hashTable;

    HashTable(int noOfRows, int noOfCols) {
        hashTable = new int[noOfRows + 1][noOfCols + 1];
    }

    private int hashValue(int value) {
        return ((4 * value) + 7) % 13;
    }

    public void hashAndAdd(int value) {
        int hashedIndex = hashValue(value);

        int lastIndexOfHashedIndex = 0;
        for (int i = 0; i < hashTable[hashedIndex].length; i++) {
            if (hashTable[hashedIndex][i] == 0) {
                break;
            }
            lastIndexOfHashedIndex++;
        }

        hashTable[hashedIndex][lastIndexOfHashedIndex] = value;

    }

    public int[] getCollisionMetadata() {
        int maxNoOfCollisionAtAnyIndex = 0;
        int indexWithMaxNoOfCollisions = -1;

        for (int i = 0; i < hashTable.length; i++) {
            int noOfCollisionsAtIndexI = 0;
            for (int k = 0; k < hashTable[i].length; k++) {
                if (hashTable[i][k] == 0) {
                    break;
                }
                noOfCollisionsAtIndexI++;
            }

            if (noOfCollisionsAtIndexI - 1 > maxNoOfCollisionAtAnyIndex) {
                maxNoOfCollisionAtAnyIndex = noOfCollisionsAtIndexI - 1;
                indexWithMaxNoOfCollisions = i;
            }
        }

        return new int[] { maxNoOfCollisionAtAnyIndex, indexWithMaxNoOfCollisions };
    }

}
