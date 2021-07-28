class CasesarCipherEncryptor {
	
	public static String caesarCipherEncryptor(String plaintext, int shift) {
		String ciphertext = "";
		
		for(char character : plaintext.toCharArray()) {
			ciphertext += ( (char)(97 + (character - 97 + shift) % 26) );
		}
		return ciphertext;
	}

	public static void main(String args[]) {
		System.out.println(caesarCipherEncryptor("abcdefghijklmnopqrstuvwxyz", 54));
	}
}
