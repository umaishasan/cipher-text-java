package ciphertext;
import java.util.Arrays;

public class HillCipher extends Cipher{
    private String[] plainText;
    private int[][] key,c ;
    private String[] pickPlainText = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "y", "z"};

    public HillCipher(String plainText){
        this.plainText = plainText.split(""); //get plain text
    }

    void key() {
        this.key = new int[][]{{3, 10, 20}, {20, 9, 17},{9, 4, 17}};
    }

    void encrypt(){
        this.key();
        int[][] result={{0,0,0}};
        int[] f = new int[plainText.length];
        int[][] s = {{0,0,0}};
        int[] p = {};
        this.c = new int[][]{{0,0,0}}; //cipher text

        for(int i=0;i<plainText.length;i++) {
            for(int j=0;j<pickPlainText.length;j++){
                if(plainText[i].equals(pickPlainText[j])) {
                    f[i] = j;
                }
            }
        }
        for(int i=0;i<f.length;i++){
            s = Arrays.copyOf(s,s.length);
            s[s.length-1]=f;
            break;
        }
        for(int i=0;i<s.length;i++){
            for(int j=0;j<key[0].length;j++){
                for(int k=0;k<key.length;k++){
                    result[i][j] += s[i][k] * key[k][j];
                }
            }
        }
        int u =0;
        for(int i=0;i<1;i++) {
            for (int j=0;j<3;j++) {
                int t = result[i][j];
                u = Math.floorMod(t, 26);
                System.out.print(pickPlainText[u]);
                p = Arrays.copyOf(p,p.length+1);
                p[p.length-1] = u;
            }
        }
        c = Arrays.copyOf(c,c.length);
        c[c.length-1] = p;
    }

    void decrypt() {
        int[][] result2={{0,0,0}};
        int det = 0, detAgain = 0, dmi = 0;
        int[][] keyIV = {{0},{0},{0}};
        for(int i=0;i<3;i++){
            det += (this.key[0][i]*(this.key[1][(i+1)%3]*this.key[2][(i+2)%3] - this.key[1][(i+2)%3]*this.key[2][(i+1)%3]))%26;
        }
        detAgain = (26%det);
        for(int i=1;i<10;i++){
            if((detAgain*i)%26 == 1){
                dmi = i;
            }
        }
        for(int i=0;i<3;i++){
        	int[] h={0,0,0};
            for(int j=0;j<3;j++){
                int s = (((this.key[(j+1)%3][(i+1)%3]*this.key[(j+2)%3][(i+2)%3])-(this.key[(j+2)%3][(i+1)%3]*this.key[(j+1)%3][(i+2)%3]))*(dmi));
                h[j] = Math.floorMod(s, 26);
            }
            keyIV[i] = h;
        }
        //for multiply
        for(int i=0;i<this.c.length;i++) {
        	for(int j=0;j<keyIV[0].length;j++) {
        		for(int k=0;k<keyIV.length;k++) {
            		result2[i][j] += this.c[i][k] * keyIV[k][j];
        		}
        	}
        }
        //for print
        for(int i=0;i<1;i++) {
        	for(int j=0;j<3;j++) {
        		int t = result2[i][j];
        		int u = (t%26);
        		System.out.print(pickPlainText[u]);
        		//System.out.println(u);
        	}
        }
    }
}