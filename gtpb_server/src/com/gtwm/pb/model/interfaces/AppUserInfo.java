/*
 *  Copyright 2012 GT webMarque Ltd
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

import java.util.Set;

import com.gtwm.pb.util.CantDoThatException;
import com.gtwm.pb.util.MissingParametersException;
import com.gtwm.pb.util.Enumerations.InitialView;

/**
 * Represents an application user - someone who can log in to agileBase. Note
 * that no privilege checking is done in these methods, privilege checks must be
 * carried out before returning an AppUserInfo object
 */
public interface AppUserInfo {

	public static final String USERNAME = "username";

	public static final String PASSWORD = "password";

	public static final String SURNAME = "surname";

	public static final String FORENAME = "forename";

	public static final String INITIALVIEW = "initialview";
	
	public static final String EMAIL = "email";

	public CompanyInfo getCompany();

	public String getInternalUserName();

	public void setUserName(String userName) throws MissingParametersException, CantDoThatException;

	public String getUserName();

	public void setSurname(String surname) throws CantDoThatException;

	public String getSurname();

	public void setForename(String forename) throws CantDoThatException;

	public String getForename();

	public void setPassword(String password) throws MissingParametersException, CantDoThatException;
	
	public String getEmail();
	
	public void setEmail(String email) throws CantDoThatException;

	/**
	 * Note: It is up to the UI to decide whether it wants to retrieve
	 * passwords, security conscious organisations may want 'write-only'
	 * passwords in which case this method should never be called
	 * 
	 * @return Plain text password
	 */
	public String getPassword() throws CantDoThatException;

	public void setUserType(InitialView userType) throws CantDoThatException;

	public InitialView getUserType();

	/**
	 * A user can have some reports hidden from them, not for security reasons
	 * but to reduce clutter
	 */
	public Set<BaseReportInfo> getHiddenReports();
	
	/**
	 * Reports that should be visible by default on the user's operational dashboard and calendar
	 */
	public Set<BaseReportInfo> getOperationalDashboardReports();
	
	public void addOperationalDashboardReport(BaseReportInfo report) throws CantDoThatException;
	
	public void removeOperationalDashboardReport(BaseReportInfo report) throws CantDoThatException;
	
	/**
	 * Tables that the user can use the 'form' data input method with
	 */
	public Set<TableInfo> getFormTables() throws CantDoThatException;
	
	public void addFormTable(TableInfo table) throws CantDoThatException;
	
	public void removeFormTable(TableInfo table) throws CantDoThatException;
	
	public void hideReport(BaseReportInfo report) throws CantDoThatException;
	
	public void unhideReport(BaseReportInfo report) throws CantDoThatException;
	
	/**
	 * Record the fact that a section in the edit tab is contracted for this user
	 * @param internalFieldName	The identifier of the section heading field
	 */
	public void contractSection(String internalFieldName) throws CantDoThatException;
	
	public void expandSection(String internalFieldName) throws CantDoThatException;
	
	public Set<String> getContractedSections();
	
	/**
	 * Get the initial report this user should see when logging in
	 */
	public BaseReportInfo getDefaultReport() throws CantDoThatException;
	
	public void setDefaultReport(BaseReportInfo report) throws CantDoThatException;
}
