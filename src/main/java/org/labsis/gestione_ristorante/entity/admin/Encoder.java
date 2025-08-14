package org.labsis.gestione_ristorante.entity.admin;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encoder {
    public String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Errore nell'hashing", e);
        }
    }
    public boolean verifyPassword(String rawPassword, String storedHash) {
        return hashPassword(rawPassword).equals(storedHash);
    }

}
