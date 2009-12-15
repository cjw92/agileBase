package com.gtwm.pb.dashboard;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import com.gtwm.pb.auth.DisallowedException;
import com.gtwm.pb.model.interfaces.AppUserInfo;
import com.gtwm.pb.model.interfaces.CompanyInfo;
import com.gtwm.pb.model.interfaces.DashboardInfo;
import com.gtwm.pb.model.interfaces.DashboardOutlierInfo;
import com.gtwm.pb.model.interfaces.DashboardTrendOutlierInfo;
import com.gtwm.pb.model.interfaces.ReportSummaryDataInfo;
import com.gtwm.pb.model.interfaces.ReportSummaryInfo;
import com.gtwm.pb.util.CodingErrorException;
import com.gtwm.pb.util.ObjectNotFoundException;
import com.gtwm.pb.util.Enumerations.UserType;

public class Dashboard implements DashboardInfo {

	private Dashboard() {
	}
	
	public Dashboard(CompanyInfo company) {
		
	}
	
	public Map<ReportSummaryInfo, ReportSummaryDataInfo> getCompanyReportSummaries() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<DashboardOutlierInfo> getDashboardOutliers() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<DashboardTrendOutlierInfo> getDashboardTrendOutliers() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Integer> getDataChangesPerWeek() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getDataChangesPercentageChange() {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Integer> getLoginsPerWeek() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getLoginsPercentageChange() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Map<UserType, Integer> getRecentLoginCounts() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> getRecentReportModificationDescriptions() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> getRecentTableModificationDescriptions() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Integer> getReportViewsPerWeek() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getReportViewsPercentageChange() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getTreeMapJSON() throws ObjectNotFoundException, DisallowedException,
			SQLException, JSONException, CodingErrorException {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<ReportSummaryInfo, ReportSummaryDataInfo> getUserReportSummaries(AppUserInfo user) {
		// TODO Auto-generated method stub
		return null;
	}

}
