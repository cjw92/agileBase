/*
 *  Copyright 2011 GT webMarque Ltd
 * 
 *  This file is part of agileBase.
 *
 *  agileBase is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  agileBase is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with agileBase.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.gtwm.pb.model.interfaces;

import java.util.List;
import java.util.Set;
import java.util.SortedSet;

import com.gtwm.pb.dashboard.interfaces.DashboardInfo;
import com.gtwm.pb.model.interfaces.AppUserInfo;
import com.gtwm.pb.model.interfaces.AppRoleInfo;
import com.gtwm.pb.model.manageUsage.UsageLogger.LogType;
import com.gtwm.pb.util.ObjectNotFoundException;

/**
 * agileBase uses companies to separate data, i.e. each company can only see
 * their own data, users etc.
 * 
 * Users and roles will belong to companies. By extension, tables will also
 * belong to companies since in order to use a table at all, a privilege must
 * exist on it and privileges apply to users and roles
 */
public interface CompanyInfo {

	public String getInternalCompanyName();

	public void setCompanyName(String companyName);

	public String getCompanyName();

	public SortedSet<AppUserInfo> getUsers();

	public SortedSet<AppRoleInfo> getRoles();

	public SortedSet<ModuleInfo> getModules();

	public SortedSet<TableInfo> getTables();

	/**
	 * URLs for tabs that are loaded when agileBase starts
	 */
	public Set<String> getTabAddresses();

	public ModuleInfo getModuleByInternalName(String internalModuleName)
			throws ObjectNotFoundException;

	public void addUser(AppUserInfo user);

	public void addRole(AppRoleInfo role);

	public void addModule(ModuleInfo module);

	public void addTabAddress(String tabAddress);

	public void removeUser(AppUserInfo user);

	public void removeRole(AppRoleInfo role);

	public void removeModule(ModuleInfo module);

	public void removeTabAddress(String tabAddress);

	/**
	 * Notify the company that a table belongs to it. Note, the definitive owner
	 * of a table is identified by a privilege but the company keeps a cache of
	 * tables it owns for quick reference
	 */
	public void addTable(TableInfo table);

	public void removeTable(TableInfo table);

	/**
	 * Get the dashboard for this company
	 */
	public DashboardInfo getDashboard();
	
	public void setDashboard(DashboardInfo dashboard);

	/**
	 * Return the IDs of report summaries that have been selected for display in the company dashboard
	 */
	public SortedSet<Long> getChartIdsForDashboard();
	
	public void addChartIdForDashboard(long id);
	
	public void removeChartIdForDashboard(long id);
	
	/**
	 * Return the IDs of report summaries that have been blacklisted from the company dashboard
	 */
	public SortedSet<Long> getChartIdsNotForDashboard();
	
	public void addChartIdNotForDashboard(long id);
	
	public void removeChartIdNotForDashboard(long id);
		
	/**
	 * Return a cache of the data generated by UsageStats.getTimelineCounts
	 * 
	 * Use that method to get the data, which will call this cache if necessary
	 * 
	 * @see com.gtwm.pb.manageUsage.usageStats#getTimelineCounts(LogType, int)
	 * 
	 *      TODO: These will be made obsolete by getDashboard which will include
	 *      the data
	 */
	public List<Integer> getCachedSparkline(LogType logType, int options);

	public void setCachedSparkline(LogType logType, int options, List<Integer> sparklineData);
}
