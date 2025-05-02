package az.edu.turing.module3.lesson07;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        User user = new User("salam",24,"124587");
        Class<User> clazz = User.class;

        Method method = clazz.getMethod("getAge");
        System.out.println(method.getDefaultValue());
        System.out.println(method.invoke(user));

        Method[] declaredMethods = clazz.getDeclaredMethods();
        for(Method m : declaredMethods){
            Class<?>[] parameterTypes = m.getParameterTypes();

            if(m.getParameterCount()==0){
                System.out.println(m.getName() + " 1 if case");
                System.out.println(m.invoke(user));
            }else if(parameterTypes.length==1 && parameterTypes[0] == String.class){
                System.out.println(m.getName() + " 2 if case");
                System.out.println(m.invoke(user,"salam"));
            }else{
                System.out.println(m.getName() + " 3 if case");
                System.out.println(m.invoke(user,15));
            }
        }

        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        List<Constructor<?>> collect = Arrays.stream(declaredConstructors).filter((s) -> s.getParameterCount() == 0)
                .toList();

        User user1 = (User) collect.getFirst().newInstance();
        System.out.println(user1);

        System.out.println(clazz.getClassLoader().getName());

        System.out.println(clazz.getDeclaredField("password"));

        Class<?>[] interfaces = clazz.getInterfaces();
        System.out.println(interfaces.length);
    }

}
