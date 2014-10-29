/*
 * Copyright (C) 2010-2014 Geometer Plus <contact@geometerplus.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 */

package org.geometerplus.fbreader.network.opds;

import org.geometerplus.fbreader.network.IPredefinedNetworkLink;
import org.geometerplus.fbreader.network.urlInfo.*;

public class OPDSPredefinedNetworkLink extends OPDSNetworkLink implements IPredefinedNetworkLink {
	static final String ID_PREFIX = "urn:fbreader-org-catalog:";

	private final String myPredefinedId;

	public OPDSPredefinedNetworkLink(int id, String predefinedId, String title, String summary, String language, UrlInfoCollection<UrlInfoWithDate> infos) {
		super(id, getStringIdInternal(predefinedId), title, summary, language, infos);
		myPredefinedId = predefinedId;
	}

	public Type getType() {
		return Type.Predefined;
	}

	public String getPredefinedId() {
		return myPredefinedId;
	}

	private static String getStringIdInternal(String predefinedId) {
		if (predefinedId.startsWith(ID_PREFIX)) {
			return predefinedId.substring(ID_PREFIX.length());
		}
		return predefinedId;
	}

	@Override
	public String getStringId() {
		return getStringIdInternal(myPredefinedId);
	}
}
