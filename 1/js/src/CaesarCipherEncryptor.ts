function caesarCipher(plaintext: string, k: number): string {
	let ciphertext = "";

	k = k % 26;

	for(let i=0; i<plaintext.length; i++) {
		const newCharCode = 97 + ( plaintext.charCodeAt(i) - 97 + k) % 26;
		ciphertext += String.fromCharCode(newCharCode);
	}

	return ciphertext;
}

(function main() {
	const plaintext = "abcdefghijklmnopqrstuvwxyz";
	const k = 2;

	console.log(caesarCipher(plaintext, k))
})();
