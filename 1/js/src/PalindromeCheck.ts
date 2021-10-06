function isPalindrome(s: string): boolean {
	const n = s.length;
	for(let i=0, j=n-1; i < n/2; i++,j--) {
		if(s[i] != s[j]) {
			return false;
		}
	}


	return true;
}

(function main() {
	const s = "abcdcba";

	console.log(isPalindrome(s));
})();
