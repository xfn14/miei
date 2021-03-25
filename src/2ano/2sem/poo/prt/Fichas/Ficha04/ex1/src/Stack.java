import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Stack {
    private List<String> arr;

    public Stack(){
        this.arr = new ArrayList<>();
    }

    public Stack(List<String> arr) {
        setArr(arr);
    }

    public Stack(Stack stack){
        setArr(stack.getArr());
    }

    public String top(){
        return this.arr.get(this.arr.size()-1);
    }

    public void push(String s){
        this.arr.add(s);
    }

    public void pop(){
        if(!this.arr.isEmpty()) this.arr.remove(this.arr.size()-1);
    }

    private boolean isEmpty(){
        return this.arr.isEmpty();
    }

    private int length(){
        return this.arr.size();
    }

    public List<String> getArr() {
        return new ArrayList<>(this.arr);
    }

    public void setArr(List<String> arr) {
        this.arr = new ArrayList<>(arr);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stack stack = (Stack) o;
        return Objects.equals(getArr(), stack.getArr());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getArr());
    }

    @Override
    public String toString() {
        return "Stack{" +
                "arr=" + arr +
                '}';
    }

    @Override
    public Stack clone() throws CloneNotSupportedException {
        Stack stack = (Stack) super.clone();
        stack.arr = stack.getArr();
        return stack;
    }

//    @Override
//    protected Stack clone() {
//        return new Stack(this);
//    }
}
