class OrgChart {
	name: string;
	directReports: OrgChart[];

	constructor(name: string) {
		this.name = name;
		this.directReports = [];
	}

	addDirectReport(directReport: OrgChart) {
		this.directReports.push(directReport);
	}
}

class OrgInfo {
	numOfImpReports: number;
	lowestCommonManager: OrgChart | null;

	constructor(numOfImpReports: number, lowestCommonManager: OrgChart | null) {
		this.numOfImpReports = numOfImpReports;
		this.lowestCommonManager = lowestCommonManager;
	}
}

function lowestCommonManager(
	topMostManager: OrgChart,
	report1: OrgChart,
	report2: OrgChart
) {
	return getOrgInfo(topMostManager, report1, report2).lowestCommonManager;
}

function getOrgInfo(
	topMostManager: OrgChart,
	report1: OrgChart,
	report2: OrgChart
): OrgInfo {
	let numOfImpReports = 0;

	for (const directReport of topMostManager.directReports) {
		const orgInfo = getOrgInfo(directReport, report1, report2);

		if (orgInfo.lowestCommonManager != null) {
			return orgInfo;
		}

		numOfImpReports += orgInfo.numOfImpReports;
	}

	if (topMostManager == report1 || topMostManager == report2) {
		numOfImpReports++;
	}

	const orgInfo = new OrgInfo(numOfImpReports, null);
	if (numOfImpReports == 2) {
		orgInfo.lowestCommonManager = topMostManager;
	}

	return orgInfo;
}
