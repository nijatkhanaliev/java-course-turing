package az.edu.turing.module3.lesson01;

public class IntegerStorage {
    private Integer[] integers = new Integer[0];

    public void add(int a){
        Integer[] newInteger = new Integer[integers.length+1];

        for(int i=0;i<integers.length;i++){
            newInteger[i]=integers[i];
        }
        integers = newInteger;

        integers[integers.length-1] = a;
    }

    public Integer get(int index){
        if(index>=integers.length){
            System.out.println("index is higher than array length");
            return null;
        }

       return integers[index];
    }

    public void remove(int index){
        Integer[] newIntegers = new Integer[integers.length-1];
        boolean isSameIndex = false;
        for (int i=0;i<integers.length;i++){
            if(i==index){
                isSameIndex = true;
            }else{
                if(!isSameIndex){
                    newIntegers[i] = integers[i];
                }else{
                    newIntegers[i-1] = integers[i];
                }
            }

        }

        integers = newIntegers;
    }


}
