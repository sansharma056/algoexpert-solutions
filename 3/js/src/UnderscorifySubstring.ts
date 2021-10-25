function getLocations(str: string, substr: string): [number, number][] {
	const locations: [number, number][] = [];

	let i = 0;
	while (i < str.length) {
		const begIdx = str.indexOf(substr, i);

		if (begIdx == -1) {
			break;
		}

		locations.push([begIdx, begIdx + substr.length]);
		i = begIdx + 1;
	}

	return locations;
}

function collapse(locations: [number, number][]): [number, number][] {
	if (locations.length <= 1) {
		return locations;
	}

	const collapsedLocations: [number, number][] = [];
	collapsedLocations.push(locations[0]);

	let prev = collapsedLocations[0];

	for (let i = 1; i < locations.length; i++) {
		const cur = locations[i];
		if(cur[0] <= prev[1]) {
			prev[1] = cur[1];
		} else {
			prev = cur;
			collapsedLocations.push(cur);
		}
	}

	return collapsedLocations;
}

function underscorify(str: string, locations: [number, number][]): string {
	let res = str;

	for(let i=locations.length-1; i>=0; i--) {
		const location = locations[i];
		res = res.slice(0, location[0]) + "_" + res.slice(location[0], location[1]) + "_" + res.slice(location[1], res.length);
	}

	return res;
}

function underscorifySubstring(str: string, substr: string) {
	return underscorify(str, collapse(getLocations(str, substr)));
}

(function main() {
	const str = "testthis is a testtest to see if testestest it works";
	const substr = "test";

	console.log(underscorifySubstring(str, substr));
})();
