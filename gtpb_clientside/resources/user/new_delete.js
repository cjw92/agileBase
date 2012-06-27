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
function fNew() {
	location='AppController.servlet?return=gui/administration/users/list&add_user';
}

function fDelete() {
	var sAction='remove_user';
	var sRowIdentifier='internalusername';
	var oDelete=new fDeleteObj(sAction,sRowIdentifier);
}

function sendPasswordReset(oButton) {
	var jqButton = $(oButton);
	var internalUserName = jqButton.attr("data_internalusername");
	$("#password_reset_result").load("AppController.servlet", {
		"return": "gui/administration/users/return_password_reset",
		internalusername: internalUserName
	});
}

