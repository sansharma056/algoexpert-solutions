class Job {
	id: number;
	prerequisites: Job[];
	visited: boolean;
	visiting: boolean;

	constructor(id: number) {
		this.id = id;
		this.prerequisites = [];
		this.visited = this.visiting = false;
	}
}

function topologicalSort(
	ids: number[],
	dependencies: [number, number][]
): number[] {
	const jobs: Map<number, Job> = new Map();
	ids.map((id) => jobs.set(id, new Job(id)));

	for (const dependency of dependencies) {
		const job = jobs.get(dependency[1]);
		if (job) {
			job.prerequisites.push(jobs.get(dependency[0])!);
		}
	}

	const order: number[] = [];

	for (const [, job] of jobs) {
		const cycleFound = explore(job, order);
		if (cycleFound) {
			return [];
		}
	}

	return order;
}

function explore(job: Job, order: number[]): boolean {
	if (job.visited) {
		return false;
	}

	if (job.visiting) {
		return true;
	}

	job.visiting = true;

	for (const prerequisite of job.prerequisites) {
		const cycleFound = explore(prerequisite, order);
		if (cycleFound) {
			return true;
		}
	}

	order.push(job.id);
	job.visited = true;
	job.visiting = false;

	return false;
}

(function main() {
	const ids = [1, 2, 3, 4];
	const dependencies: [number, number][] = [
		[1, 2],
		[1, 3],
		[3, 2],
		[4, 2],
		[4, 3],
	];

	console.log(topologicalSort(ids, dependencies));
})();
