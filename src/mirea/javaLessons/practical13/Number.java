package mirea.javaLessons.practical13;

public class Number {
    private String numb;
    public Number(String n){
        if(n.charAt(0) == '8'){
            n.replace('8', '7');
        }
        else{
            n = n.substring(1);
        }
        this.numb = "+" + n.substring(0, n.length() - 10) + " " + n.substring(n.length() - 10, n.length() - 7) + "-" + n.substring(n.length() - 7, n.length() - 4) + "-" + n.substring(n.length() - 4, n.length());
    }

    public String getNumb() {
        return numb;
    }
}
