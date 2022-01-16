package Algos.BackTracking;

import models.Algorithm;

import java.util.ArrayList;

public class GenerateIPAddress extends Algorithm {


    public ArrayList<String> genIp(String s) {
        ArrayList<String> ipList = new ArrayList<>();

        foo(s, 0, "", 3, ipList);

        return ipList;
    }

    private void foo(String s, int i, String partIP, int dots, ArrayList<String> ipList) {
        if (dots == 0) {
            String ip = partIP + s.substring(i);
            if (!ip.endsWith(".") && isValidIp(ip)) // As validity check allows . at end
                ipList.add(ip);

            return;
        }

        // string has ended and dots are remaining.
        if (i >= s.length())
            return;

        // PartIP is invalid. So other combination will be invalid too.
        if (!isValidIp(partIP))
            return;

        // Remaining string length > 3*dots + 3
        if (s.length() - i > 3*dots + 3)
            return;

        // Add dot after index
        foo(s, i+1, partIP+ s.charAt(i) + ".", dots -1, ipList);

        // Don't add dot
        foo(s, i+1, partIP+ s.charAt(i), dots, ipList);
    }

    private boolean isValidIp(String partIP) {
        //System.out.println(partIP);
        String[] numList = partIP.split("\\.");

        for (String num: numList) {
            System.out.println(num);
            if (num.isEmpty())
                continue;

            // To catch 011, 05, 00, etc. cases.. but not 1.0.0.1...
            if (num.startsWith("0") && num.length() > 1)
                return false;

            int number = Integer.parseInt(num);
            if (number < 0 || number> 255)
                return false;
        }

        return true;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void run() {
        System.out.println(genIp("11211"));
        System.out.println(genIp("67535629"));
    }
}
