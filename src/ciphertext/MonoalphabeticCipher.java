package ciphertext;
import java.util.Arrays;

public class MonoalphabeticCipher extends Cipher{
		private String[] plainText;
		private static String[] key;
		private static String[] c;
		
		MonoalphabeticCipher(String plainText){
			this.plainText = plainText.split("");
		}

		@Override
		void key() {
			this.key = new String[]{"q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d",
		            "f", "g", "h", "j", "k", "l", "z", "x", "c", "v", "b", "n", "m"};
		}
		
		@Override
		void encrypt() {
		    String[] pickPlainText = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
		            "u", "v", "w", "x", "y", "z"};
			this.key();
			c = new String[]{"","",""};
			for(int i=0;i<plainText.length;i++) {
				for(int j=0;j<pickPlainText.length;j++) {
					if(plainText[i].equals(pickPlainText[j])) {
						pickPlainText[j] = this.key[j];
						c[i] = pickPlainText[j];
					}
				}
			}
			System.out.println("Encrypted: "+Arrays.toString(c));
		}

		@Override
		void decrypt() {
			 String[] pickPlainText = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
			            "u", "v", "w", "x", "y", "z"};
				String[] d= {"","",""};
				for(int j=0;j<this.c.length;j++) {
					for(int k=0;k<this.key.length;k++) {
						if(this.c[j].equals(this.key[k])) {
							d[j] = pickPlainText[k];
						}
					}
				}
				System.out.println("Decrypted: "+Arrays.toString(d));
		}
}