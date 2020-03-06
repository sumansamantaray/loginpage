/**
 * 
 */
package com.example.springboot.loginpage.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Component;

/**
 * @author samasu5
 *
 */
@Component
public class WriteToFile {

	public void writeFile(byte[] content, String filename) throws IOException {
        File file = new File(filename);
 
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fop = new FileOutputStream(file);
        fop.write(content);
        fop.flush();
        fop.close();
        System.out.println("Written: " + filename);
    }
}
