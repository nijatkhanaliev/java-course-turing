package az.edu.turing.module2.lesson01;

public class StudentDemo {

    public static void main(String[] args) {
        Student s1 = new Student("John",25);
        Student s2 = new Student("John",25);
        Student s3 = new Student("John",25);

        System.out.println(s3.count);//3

        Student s4 = new Student("John",25);
        Student s5 = new Student("John",25);
        Student s6 = new Student("John",25);

        System.out.println(s3.count); //6
        System.out.println(Student.count); //6

        String s = "sablam";
        System.out.println(s.replaceAll("[a-b]","*"));

        popArrayElement();
    }

    public static void popArrayElement(){
        int[] arr = {1,2,3,4,5};
        int length = arr.length;//5
        for(int i=1;i<=length;i++){
            int[] newArr = new int[arr.length-1];

            System.out.println(i + ": " + arr[length-i]);

            for(int j=0;j<newArr.length;j++){
                newArr[j] = arr[j];
            }
            arr = newArr;
        }
        System.out.println(arr.length==0);//true
    }

}
