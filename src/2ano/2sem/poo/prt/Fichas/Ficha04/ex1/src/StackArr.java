import java.util.Arrays;

public class StackArr {
    private String[] arr;
    private int size;
    private int top;

    public StackArr(){
        this.size = 10;
        this.arr = new String[this.size];
        this.top = -1;
    }

    public StackArr(String[] arr, int size, int top) {
        setArr(arr);
        this.size = size;
        this.top = top;
    }

    public StackArr(StackArr stackArr){
        setArr(stackArr.getArr());
        setSize(stackArr.getSize());
        setTop(stackArr.getTop());
    }

    public String top(){
        if(empty()) return null;
        return getArr()[top];
    }

    public void push(String s){
        if(this.top+1 >= this.size){
            this.size *= 2;
            this.arr = Arrays.copyOf(this.arr, this.size);
        }
        this.arr[++top] = s;
    }

    public void pop(){
        if(!empty()) this.arr[top--] = null;
    }

    public boolean empty(){
        return this.top == -1;
    }

    public int length(){
        return this.top+1;
    }

    public String[] getArr() {
        return Arrays.copyOf(this.arr, this.arr.length);
    }

    public void setArr(String[] arr) {
        this.arr = Arrays.copyOf(arr, arr.length);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }
}
