package test;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class MethodsCount {



    public static int countOfTest(Method[] methods) {
        int count=0;
        for (Method method:methods) {
          Annotation annotation = method.getAnnotation(org.testng.annotations.Test.class);
            if(annotation instanceof org.testng.annotations.Test) {
                count++;
                System.out.println(method.getName());
            }
        }
        return count;
    }

    public static void writeMethodsWithAnnotationToFile(Method[] methods){
        Method[]methodsWithAnnotation=new Method[countOfTest(methods)];
        int i=0;
        for (Method method:methods) {
            Annotation annotation = method.getAnnotation(org.testng.annotations.Test.class);
            if(annotation instanceof org.testng.annotations.Test) {
               methodsWithAnnotation[i++]= method;
            }
            }
        FileWriter nFile;
        try {
            nFile = new FileWriter("src/test/resources/testMethods.txt");
            for (int k=0; k<methodsWithAnnotation.length; k++ ) {
                if (k!=methodsWithAnnotation.length-1)
                nFile.write(methodsWithAnnotation[k].getName()+", ");
                else nFile.write(methodsWithAnnotation[k].getName());
            }
            nFile.close();
        } catch (IOException e) {
            e.printStackTrace();
            }
        }
    }

