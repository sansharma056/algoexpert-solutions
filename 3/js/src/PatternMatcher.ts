function switchPattern(pattern: string): string {
	let newPattern = "";

	for (const char of pattern) {
		if (char == "x") {
			newPattern += "y";
		} else {
			newPattern += "x";
		}
	}

	return newPattern;
}

function getPatternInfo(pattern: string): [number, number, number] {
	let numOfX = 0;
	let numOfY = 0;
	let posOfFirstY = -1;

	for (let i = 0; i < pattern.length; i++) {
		const char = pattern[i];

		if (char == "x") {
			numOfX++;
		} else {
			numOfY++;
			if (posOfFirstY == -1) {
				posOfFirstY = i;
			}
		}
	}

	return [numOfX, numOfY, posOfFirstY];
}

function createStringFromPattern(
	pattern: string,
	x: string,
	y: string
): string {
	let res = "";

	for (const char of pattern) {
		if (char == "x") {
			res += x;
		} else {
			res += y;
		}
	}

	return res;
}

function patternMatcher(pattern: string, str: string): [string, string] {
	if (pattern.length > str.length) {
		return ["", ""];
	}

	let switched = false;

	if (pattern[0] == "y") {
		pattern = switchPattern(pattern);
		switched = true;
	}

	const [numOfX, numOfY, posOfFirstY] = getPatternInfo(pattern);

	for (let i = 1; i <= str.length; i++) {
		const potentialX = str.substring(0, i);
		const potentialYLength = (str.length - numOfX * i) / numOfY;

		if (potentialYLength < 0 || potentialYLength % 1 != 0) {
			continue;
		}

		const potentialY = str.substring(
			i * posOfFirstY,
			i * posOfFirstY + potentialYLength
		);

		if (createStringFromPattern(pattern, potentialX, potentialY) == str) {
			return switched ? [potentialY, potentialX] : [potentialX, potentialY];
		}
	}

	return ["", ""];
}

(function main() {
	const pattern = "xxyxxy";
	const str = "gogopowerrangergogopowerranger";

	console.log(patternMatcher(pattern, str));
})();
