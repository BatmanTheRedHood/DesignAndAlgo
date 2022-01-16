package Adhoc;

import java.util.HashMap;
import java.util.Map;

public class Microsoft2 {
    public void printHello() {
        System.out.println("Hello MS");
    }

    public int solution(int[][] a) {
        // write your code in Java SE 8
        int docCount = 0;
        Map<Integer, Integer> docMap = new HashMap<>();

        for (int i=0; i<a.length; i++) {
            for (int j=0; j<a[0].length; j++) {
                int doctor = a[i][j];
                if (docMap.containsKey(doctor)) {
                    int docHospital = docMap.get(doctor);
                    if (docHospital >= 0 && docHospital != i) {
                        docCount++;
                        docMap.put(doctor, -1);
                    }
                } else {
                    docMap.put(doctor, i);
                }
            }
        }

        return docCount;
    }
}
