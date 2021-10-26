import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class LowestCommonManager {
	public static OrgChart getLowestCommonManager(OrgChart topManager, OrgChart report1, OrgChart report2)	{
		
		return getOrgInfo(topManager, report1, report2).lowestCommmonManager;
	}
	
	public static OrgInfo getOrgInfo(OrgChart topManager, OrgChart report1, OrgChart report2) {
		int numOfImpReports = 0;	
	
		for(OrgChart report : topManager.directReports) {
			OrgInfo orgInfo = getOrgInfo(report, report1, report2);
			if(orgInfo.lowestCommmonManager != null) {
				return orgInfo;
			}		
			
			numOfImpReports += orgInfo.numOfImpReports;
		}

		if(topManager == report1 || topManager == report2) {
			numOfImpReports++;
		}
		
		OrgChart lowestCommmonManager = numOfImpReports == 2 ? topManager : null;
		
		return new OrgInfo(lowestCommmonManager, numOfImpReports);
	}

	public static void main(String args[]) {
		//create organization chart
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		Map<Character, OrgChart> orgCharts = new HashMap<>();
		for(char name : alphabet.toCharArray()) {
			orgCharts.put(name, new OrgChart(name));	
		}

		for(char name: "BCDEF".toCharArray()) {
			orgCharts.get('A').addDirectReport(orgCharts.get(name));
		}
		
		for(char name: "GHI".toCharArray()) {
			orgCharts.get('B').addDirectReport(orgCharts.get(name));
		}
		
		orgCharts.get('C').addDirectReport(orgCharts.get('J'));

		for(char name: "KL".toCharArray()) {
			orgCharts.get('D').addDirectReport(orgCharts.get(name));
		}

		for(char name: "MN".toCharArray()) {
			orgCharts.get('F').addDirectReport(orgCharts.get(name));
		}

		for(char name: "OPQR".toCharArray()) {
			orgCharts.get('H').addDirectReport(orgCharts.get(name));
		}

		for(char name: "TU".toCharArray()) {
			orgCharts.get('P').addDirectReport(orgCharts.get(name));
		}
	
		orgCharts.get('R').addDirectReport(orgCharts.get('V'));
		
		for(char name: "WXY".toCharArray()) {
			orgCharts.get('V').addDirectReport(orgCharts.get(name));
		}
		
		orgCharts.get('X').addDirectReport(orgCharts.get('Z'));

		System.out.println(getLowestCommonManager(orgCharts.get('A'), orgCharts.get('I'), orgCharts.get('P')).name);
	}
}

class OrgInfo {
	OrgChart lowestCommmonManager;
	int numOfImpReports;
	
	OrgInfo(OrgChart lowestCommmonManager, int numOfImpReports) {
		this.lowestCommmonManager = lowestCommmonManager;
		this.numOfImpReports = numOfImpReports;
	}
}

class OrgChart {
	char name;
	List<OrgChart> directReports;

	OrgChart(char name) {
		this.name = name;
		directReports = new ArrayList<>();
	}
	
	void addDirectReport(OrgChart directReport) {
		this.directReports.add(directReport);
	}

	void addDirectReports(List<OrgChart> directReports) {
		for(OrgChart directReport : directReports) {
			this.directReports.add(directReport);
		}
	}
}
