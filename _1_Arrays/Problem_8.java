/*
8. Write a class Polynomial to perform the following
a. Design a constructor to represent a polynomial (of single variable x).
b. Create a method to addition of polynomials.
c. Create a method to subtraction of polynomials.
d. Create a method to multiply of polynomials.
e. Create a method to find derivative of the polynomial.
*/

package _1_Arrays;

class Polynomial{
    int [] p ;
    int coef;
    int deg;
    Polynomial(int coef, int deg){
        this.coef = coef;
        this.deg=deg;
        p=new int[deg+1];
        p[deg] = coef;
    }
    public String toString() {
        String poly ="";
        poly+=p[p.length-1]+" x^ "+(p.length-1);
        for(int i=p.length-2; i>=0; i--) {
            if(p[i]>0) {
                poly+=" + "+p[i]+" x^ "+i;
            }else if(p[i]<0) {
                poly+=" - "+(-p[i])+" x^ "+i;
            }
        }
        return poly;
    }

    Polynomial add(Polynomial pol) {
        Polynomial p1 = new Polynomial(0,Math.max(this.deg, pol.deg));
        for(int i=0; i<= pol.deg;i++) {
            p1.p[i] += pol.p[i];
        }
        for(int i=0; i<= this.deg;i++) {
            p1.p[i] += this.p[i];
        }
        return p1;
    }

    Polynomial multiply(Polynomial pol) {
        Polynomial p1 = new Polynomial(0,this.deg + pol.deg);
        for(int i=0; i<=pol.deg; i++) {
            for(int j =0; j<=this.deg; j++) {
                p1.p[i+j]= pol.p[i]+this.p[j];
            }
        }
        return p1;
    }

    Polynomial sub(Polynomial pol) {
        Polynomial p1 = new Polynomial(0,Math.max(this.deg, pol.deg));
        for(int i=0; i<= this.deg;i++) {
            p1.p[i] += this.p[i];
        }
        for(int i=0; i<= pol.deg;i++) {
            p1.p[i] -= pol.p[i];
        }
        return p1;
    }

    Polynomial derivative() {
        Polynomial p1 = new Polynomial(0,Math.max(0,this.deg-1));
        for(int i=1; i<=this.deg; i++) {
            p1.p[i-1] = i*this.p[i];
        }
        return p1;
    }

}

public class Problem_8 {

    public static void main(String[] args) {
        Polynomial p1 = new Polynomial(4,3);
        Polynomial p2 = new Polynomial(2,2);
        Polynomial p = p1.add(p2);

        Polynomial q1 = new Polynomial(4,0);
        Polynomial q2 = new Polynomial(2,2);
        Polynomial q = q1.add(q2);

        Polynomial pq = p.add(q);

        Polynomial qp = p.sub(q);

        Polynomial x = p.multiply(q);

        System.out.println(p);
        System.out.println(q);
        System.out.println(pq);
        System.out.println(qp);
        System.out.println(x);
        System.out.println(x.derivative());
        System.out.println(p.derivative());
    }
}


/*
OUTPUT:
4 x^ 3 + 2 x^ 2
2 x^ 2 + 4 x^ 0
4 x^ 3 + 4 x^ 2 + 4 x^ 0
4 x^ 3 - 4 x^ 0
6 x^ 5 + 4 x^ 4 + 2 x^ 3 + 2 x^ 2 + 4 x^ 0
30 x^ 4 + 16 x^ 3 + 6 x^ 2 + 4 x^ 1
12 x^ 2 + 4 x^ 1
*/
