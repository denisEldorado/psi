/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.config.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author KennethKZMMuhia
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HashingImplementationTest {


    private final String[] plainText = {"881188", "7faf56e5c29e9df5cf4edaffc404a7bbe07bd62e32048079e556a304278ae554", "blueskyconsulting"};
    private final String[] hashedText = {"0p/iiUM0/vKaJtPCII5fCA==", "MocWtPMpri0MMbY6779BNg=="};
    @Autowired
    private HashingImplementation hashingImplementation;

    @Test
    public void testEncryptSha2() {
        String t = "881188P@s23#pb20170301163223";
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("Text %s hashed to %s", t, hashingImplementation.encryptSha2(t)));
//        Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("Text %s hashed to %s", t, hashingImplementation.getEncryptedSha265Value(t)));
    }

    @Test
    public void testEncryption() {
        String hashedStr;
        for (String aPlainText : plainText) {
            hashedStr = hashingImplementation.getEncryptedValue(aPlainText);
            Logger.getLogger(HashingImplementationTest.class.getName()).log(Level.INFO, "Text {0} has been hashed to {1}", new Object[]{aPlainText, hashedStr});

        }

    }

    @Test
    public void testDecryption() {
        String unhash;
        for (String hashedText1 : hashedText) {
            unhash = hashingImplementation.getDecryptedValue(hashedText1);
            //			assertThat(plainText[i]).isEqualTo(unhash);
            Logger.getLogger(HashingImplementationTest.class.getName()).log(Level.INFO, "Text {0} has been unhashed from {1}", new Object[]{hashedText1, unhash});
//                Logger.getLogger(HashingImplementationTest.class.getName()).log(Level.INFO, "Unhash works{0}", unhash);
        }

    }

    @Test
    public void keyGenerationTest() {
        hashingImplementation.GenerateNewKey();
    }

}
