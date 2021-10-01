function validate(arr: number[], subseq: number[]): boolean {
	let i, j;	
	i=j=0;

	while(i < arr.length && j < arr.length) {
		if(arr[i] == arr[j]) {
			j++;
		}	

		if(j == arr.length) {
			return true;
		}

		i++;
	}

	return false;
}

(function main() {
	const arr = [5,1,22,25,6,-1,8,10];
	const subseq = [1,6,-1,10];

	console.log(validate(arr, subseq));
})();
