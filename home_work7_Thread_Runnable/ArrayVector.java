package home_work7_Thread_Runnable;

import java.util.Iterator;

public class ArrayVector implements Ivector,Cloneable {

    int vectorSize;
    private double[] vector;


    /**
     * @param _vectorSize - Количество элементов вектора
     *                    vector      - массив вектора 1
     */


    ArrayVector(int _vectorSize) {
        this.vectorSize = _vectorSize;
        vector = new double[vectorSize];

        for (int i = 0; i < this.getVectorSize(); i++) {
            double r = Math.random() * 100;
            int b = (int) r;
            this.setElement(i, b);
            //   System.out.println( " Все элементы по вектору 1 " + this.getElement(i));

        }
    }

    /**
     * @param i -  индекс элемента
     * @return - элемент по индексу
     */
    public double getElement(int i) {
        return vector[i];
    }

    /**
     * @param index     -  Индекс элемента
     * @param element -  Значение для подстановки
     * @return новое значение
     */

    public  void  setElement(int index, double element) {
        if (index < vector.length) {
            vector[index] = element;

        }
    }

    /**
     * @return Количество элементов
     */

    public int getVectorSize() {
        return vectorSize;
    }

    /**
     * @return Минимальное значение вектора 1
     */

    public double getMin() {
        double min = vector[0];
        for (int z = 0; z < vector.length; z++) {
            if (min > vector[z])
                min = vector[z];
        }
        return min;
    }


    /**
     * @return Евклидова Норма
     */

    public double getNorm() {
        int norm = 0;
        for (double i : vector) {
            norm += i * i;
        }
        return Math.sqrt(norm);
    }



    public Iterator iterator() {
        return new ArrayVectorIterator(this);
    }



    public static class ArrayVectorIterator implements Iterator {
        private ArrayVector aggregate = null;
        private int current = -1;
        private int length;

        public ArrayVectorIterator(ArrayVector v) {
            aggregate = v;
            length = v.getVectorSize();
        }

        public boolean hasNext() {
            current++;
            return current < length;
        }

        public Object next() {
            current++;
            return aggregate.getElement(current);
        }

        public void remove() {

            throw new UnsupportedOperationException();
        }
    }

    public static class ArrayVectorFactory implements VectorFactory {

        public ArrayVector createInstance(int size) {
            return new ArrayVector(size);
        }
    }

    public String toString() {
        int current = 0;
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < this.getVectorSize(); i++) {
            sb.append(vector[i]).append(" ");
        }
        return sb.toString();
    }

    public boolean equals(Object obj ) {
        if (!(obj instanceof ArrayVector)) return false;
        ArrayVector myObj = (ArrayVector) obj;
        if (getVectorSize() != myObj.getVectorSize() ){
            return false;
        }
        for (int i =0; i<this.getVectorSize();i++){
            if (this.getElement(i)!=myObj.getElement(i)){
                return  false;
            }
        }
return true;
    }

    public int hashCode(){
            int result = 0;
            long t;
            for (int i = 0; i<vector.length;i++){
                t=Double.doubleToLongBits(vector[i]);
                result^=(((int)(t>>32))^(int)(t&0x00000000FFFFFFFF));
            }
            return result;
        }
public Object clone() throws CloneNotSupportedException {
        return super.clone();
}


}






