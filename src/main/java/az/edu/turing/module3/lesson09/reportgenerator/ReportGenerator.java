package az.edu.turing.module3.lesson09.reportgenerator;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class ReportGenerator {

    public ReportGenerator() {

    }

    public void generateReport(Object object) throws IllegalAccessException, IOException {
        Class<?> clazz = object.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();

        try(FileWriter fileWriter = new FileWriter(clazz.getSimpleName().toLowerCase() + "-report.txt",true);
            BufferedWriter writer = new BufferedWriter(fileWriter)
        ){
            for(Field field : declaredFields){
                if(field.isAnnotationPresent(IncludeInReport.class)){
                    field.setAccessible(true);
                    writer.write(field.getName() + " : ");
                    writer.write(String.valueOf(field.get(object)));
                    writer.write("\n");
                }
            }
            writer.write("--------------------------------");
            writer.write("\n");
        }



    }

}
