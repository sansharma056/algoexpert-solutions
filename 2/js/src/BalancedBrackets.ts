function isBalanced(brackets: string): boolean {
	const map: Map<String, String> = new Map();
	map.set("(", ")");
	map.set("[", "]");
	map.set("{", "}");

	const stack: string[] = [];
	for(const bracket of brackets) {
		if(map.has(bracket)) {
			stack.push(bracket);
		} else {
			if(map.get(stack.pop()!) != bracket) {
				return false;
			}
		}
	}

	return stack.length == 0;
}

(function main() {
	const brackets = "(([]()()){})";
	console.log(isBalanced(brackets))
})();
