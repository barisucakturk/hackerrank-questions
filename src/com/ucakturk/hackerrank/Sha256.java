package com.ucakturk.hackerrank;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Sha256 {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(input.getBytes());
        byte[] digest = messageDigest.digest();
        String encryptedValue = DatatypeConverter.printHexBinary(digest);
        System.out.println(encryptedValue);

    }
}