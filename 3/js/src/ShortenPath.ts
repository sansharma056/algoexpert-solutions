function shortenPath(path: string) {
	const tokens = path.split("/").filter( i => i.length > 0 && i != "." );
	const stack: string[] = [];

	for(const token of tokens) {
		if(token == "..") {
			if(stack.length > 0) {
				stack.pop();
			}
		}	else {
			stack.push(token);
		}
	}

	if(stack.length == 0) {
		return "/";
	}

	let newPath = "";
	while(stack.length != 0) {
		newPath += "/" + stack.shift();
	}

	return newPath;
}

(function main() {
	const path = "/foo/../test/../test/../foo//bar/./baz";
	console.log(shortenPath(path));
})();
