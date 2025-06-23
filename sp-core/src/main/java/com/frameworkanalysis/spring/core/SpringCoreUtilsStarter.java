package com.frameworkanalysis.spring.core;

import com.frameworkanalysis.spring.core.model.Demo;
import org.springframework.util.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.IllformedLocaleException;

/*
 * Core Utility Classes in Spring (org.springframework.util):
 *
 * 1. StringUtils             - String manipulation helpers
 * 2. ObjectUtils             - Object null-safety and default handling
 * 3. CollectionUtils         - Collection null-checking and merging
 * 4. ClassUtils              - Class metadata and classpath handling
 * 5. ReflectionUtils         - Reflection helpers (invoke methods, fields)
 * 6. Assert                  - Validation assertions
 * 7. MimeTypeUtils           - Handling MIME types
 * 8. AntPathMatcher          - Path matching with Ant-style patterns
 * 9. FileCopyUtils           - File and stream copying
 * 10. ResourceUtils          - Resource path handling
 * 11. DigestUtils            - Digest algorithms (MD5, SHA-1)
 * 12. ConcurrentReferenceHashMap - Thread-safe weak/soft map
 * 13. NumberUtils            - Number parsing utilities
 * 14. StopWatch              - Performance timing
 * 15. MultiValueMapAdapter   - Multi-value map adapter
 */
public class SpringCoreUtilsStarter {
    public static void main(String[] args) {

        var hashExample = new Object();
        System.out.println(hashExample);
        System.out.println(hashExample.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(hashExample)));


        /**
         * String utils
         */

        System.out.println(StringUtils.arrayToCommaDelimitedString(new String[]{"Feroz", "Dawud", "Yead"}));
        if (!StringUtils.hasText("     ")) {
            System.out.println("No text or Only white space");
        }

        for (String s : StringUtils.addStringToArray(new String[]{"Feroz", "Dawud", "Yead"}, "Rahela"))
            System.out.println(s);


        System.out.println(
                StringUtils.collectionToDelimitedString(
                        Arrays.asList("Feroz", "Dawud", "Yead"),
                        ",", "M. ", " Shah"
                )
        );
//        M. Feroz Shah,M. Dawud Shah,M. Yead Shah
        var fileUri = "/Users/dawud/Desktop/sittap/franework-analysis/src/main/resources/spring_core/resource.txt";
        System.out.println(StringUtils.getFilename(fileUri));
        System.out.println(StringUtils.getFilenameExtension(fileUri));


        /**
         * ObjectUtils
         */

        System.out.println(
                ObjectUtils.nullSafeEquals(
                        new String[]{"Feroz", "Dawud", "Yead"},
                        new String[]{"Feroz", "Dawud", "Yead"}
                )
        );
        System.out.println(
                ObjectUtils.nullSafeEquals(
                        new String[]{"Feroz", "Dawud", "Yead", "Rahela"},
                        new String[]{"Feroz", "Dawud", "Yead"}
                )
        );
        System.out.println(
                ObjectUtils.nullSafeEquals(
                        new String[]{"Feroz", "Dawud", "Yead", null},
                        new String[]{"Feroz", "Dawud", "Yead", null}
                )
        );


        /**
         * MimeTypeUtils
         */
        System.out.println(MimeTypeUtils.parseMimeType("image/jpg").getType());

/**
 * ReflectionUtils
 */

        ReflectionUtils.doWithFields(Demo.class, field -> {
            System.out.println(field.getName());
        });

        try {


            var constructor = Demo.class.getDeclaredConstructor();
            ReflectionUtils.makeAccessible(constructor);
            var demo = constructor.newInstance();

            // Set 'name'
            var nameField = ReflectionUtils.findField(Demo.class, "name");
            assert nameField != null;
            ReflectionUtils.makeAccessible(nameField);
            ReflectionUtils.setField(nameField, demo, "Feroz");

            // Set 'age'
            var ageField = ReflectionUtils.findField(Demo.class, "age");
            assert ageField != null;
            ReflectionUtils.makeAccessible(ageField);
            ReflectionUtils.setField(ageField, demo, 28);

            // Set 'maritalStatus'
            Field maritalStatusField = ReflectionUtils.findField(Demo.class, "maritalStatus");
            assert maritalStatusField != null;
            ReflectionUtils.makeAccessible(maritalStatusField);
            ReflectionUtils.setField(maritalStatusField, demo, true);

            // Print result
            System.out.println("Name: " + demo.getName());
            System.out.println("Age: " + demo.getAge());
            System.out.println("Married: " + demo.isMaritalStatus());
        }catch (NoSuchMethodException | IllformedLocaleException | InstantiationException | IllegalAccessException |
                InvocationTargetException s){

        }

        /**
         * ClassUtils
         */


    }


}

