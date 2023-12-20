package mirea.javaLessons.practical13;

public class Main {
    public static void main(String[] args) {
        Number n1 = new Number("89099355326");
        Number n2 = new Number("+79651405518");
        Number n3 = new Number("+4956623538888");
        //System.out.println(n1.getNumb());
        //System.out.println(n2.getNumb());
        //System.out.println(n3.getNumb());
        FileTextArr fl = new FileTextArr();
        System.out.println(fl.getLine());
    }
}
