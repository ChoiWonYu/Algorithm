class Calculator {
    int left, right;

    public void setOprands(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public void sum() {
        System.out.println(this.left + this.right);
    }

    public void avg() {
        System.out.println((this.left + this.right) / 2);
    }
}

class SubstractionableCalculator extends Calculator {

    public void sum() {
        System.out.println("실행 결과는 " +(this.left + this.right)+"입니다.");
        //sum의 실행문을 변경했다.
    }

    public void substract() {
        System.out.println(this.left - this.right);
    }


}

public class Practice {
    public static void main(String[] args) {
        String d="d";
       char[][] c=new char[4][4];
       System.out.println((int)c[0][0]);
    }
}