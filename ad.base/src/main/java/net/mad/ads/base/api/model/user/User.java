/**
 * Mad-Advertisement
 * Copyright (C) 2011 Thorsten Marx <thmarx@gmx.net>
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package net.mad.ads.base.api.model.user;

import java.io.Serializable;
import java.util.Date;

public interface User extends Serializable {

	public Long getId ();
	
	public void setId (Long id);
	
	public String getUsername ();
	
	public void setUsername (String username);
	
	public String getPassword ();
	
	public void setPassword (String password);
	
	public String getEmail ();
	
	public void setEmail (String email);
	
	public Date getCreated ();
	
	public void setCreated (Date created);
	
	public UserType getType ();
	
	public void setType (UserType type);
	
	public boolean isActive ();
	
	public void setActive (boolean active);
}
