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
package net.mad.ads.base.api.model.user.impl;


import java.util.Date;

import net.mad.ads.base.api.BaseObject;
import net.mad.ads.base.api.model.user.Message;
import net.mad.ads.base.api.model.user.MessageType;

public class SimpleMessage extends BaseObject implements Message {

	protected static final String ID = "id";
	protected static final String SUBJECT = "subject";
	protected static final String MESSAGE = "message";
	protected static final String TYPE = "type";
	protected static final String SOURCE_USER = "source_user";
	protected static final String DEST_USER = "dest_user";
	protected static final String CREATED = "created";
	
	@Override
	public String getId() {
		return get(ID, String.class, null);
	}

	@Override
	public void setId(String id) {
		put(ID, id);
	}

	@Override
	public String getMessage() {
		return get(MESSAGE, String.class, null);
	}

	@Override
	public void setMessage(String message) {
		put(MESSAGE, message);
	}

	@Override
	public String getSubject() {
		return get(SUBJECT, String.class, null);
	}

	@Override
	public void setSubject(String subject) {
		put(SUBJECT, subject);
	}

	@Override
	public String getSourceUserId() {
		return get(SOURCE_USER, String.class, null);
	}

	@Override
	public void setSourceUserId(String userid) {
		put(SOURCE_USER, userid);
	}

	@Override
	public String getDestUserId() {
		return get(DEST_USER, String.class, null);
	}

	@Override
	public void setDestUserId(String userid) {
		put(DEST_USER, userid);
	}

	@Override
	public MessageType getTyp() {
		return get(TYPE, MessageType.class, MessageType.DEFAULT);
	}

	@Override
	public void setType(MessageType type) {
		put(TYPE, type);
	}
	@Override
	public Date getCreated () {
		return get(CREATED, Date.class, null);
	}
	@Override
	public void setCreated (Date created) {
		put(CREATED, created);
	}

}
