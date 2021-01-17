package ciphertext;

public class Main {

	public static void main(String[] args) {
		long start1 = System.currentTimeMillis();
		System.out.println("Hill Cipher:");
		HillCipher hc = new HillCipher("uma");
		System.out.print("Encrypted: ");
		hc.encrypt();
		System.out.print(", Decrypted: ");
		hc.decrypt();
		long end1 = System.currentTimeMillis();
		System.out.println("\nEstimate time in milisecond: "+(end1-start1));
		
		long start2 = System.currentTimeMillis();
		System.out.println("\nCaeser Cipher:");
		CaeserCipher cc = new CaeserCipher("uma");
		cc.encrypt();
		cc.decrypt();
		long end2 = System.currentTimeMillis();
		System.out.println("Estimate time in milisecond: "+(end2-start2));
		
		long start3 = System.currentTimeMillis();
		System.out.println("\nMonoalphabetic Cipher:");
		MonoalphabeticCipher mc = new MonoalphabeticCipher("uma");
		mc.encrypt();
		mc.decrypt();
		long end3 = System.currentTimeMillis();
		System.out.println("Estimate time in milisecond: "+(end3-start3));
	}
}