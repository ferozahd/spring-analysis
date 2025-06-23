package com.frameworkanalysis.spring.core;


import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.IOException;

/*
 * Common Implementations of org.springframework.core.io.Resource:
 *
 * 1. ClassPathResource         - Loads from the classpath
 * 2. FileSystemResource        - Loads from the file system
 * 3. UrlResource               - Loads from a URL (http, https, ftp, etc.)
 * 4. InputStreamResource       - Wraps an InputStream as a Resource
 * 5. ByteArrayResource         - Wraps a byte array as a Resource
 * 6. PathResource              - Uses java.nio.file.Path
 * 7. VfsResource               - Supports Virtual File Systems (e.g., JBoss VFS)
 * 8. DescriptiveResource       - Represents a description without actual content
 * 9. ServletContextResource    - Loads resources from a ServletContext (web apps)
 */

public class SpringCoreResourceStarter {

    public static void main(String[] args) throws IOException {
        Resource r = new ClassPathResource("resource_text.txt");
        byte[] content = r.getContentAsByteArray();
        for (byte b : content) {
            System.out.print((char) b);
        }
        System.out.println();


        Resource url_R = new UrlResource("https://jwt.io");
        byte[] urlContent = url_R.getContentAsByteArray();
        for (byte b : urlContent) {
            System.out.print((char) b);
        }


    }
}
