function solve(str: string): string {
	let longest: [number, number] = [0, 1];

	for(let i=1; i<str.length; i++) {
		const odd = getPalindrome(i-1, i+1, str);
		const even = getPalindrome(i, i+1, str);

		longest = max(longest, max(even, odd));
	}

	return str.substring(longest[0], longest[1]);
}

function max(x: [number, number], y: [number, number]): [number, number] {
	if(x[1] - x[0] > y[1] - y[0]) {
		return x;
	}

	return y;
}

function getPalindrome(i:number, j:number, str: string): [number, number] {
	while((i >= 0 && j < str.length ) && (str[i] == str[j])) {
		i--;
		j++;
	}

	return [i+1, j];
}

(function main() {
	const str = "abaxyzzyxf";
	console.log(solve(str));
})();
