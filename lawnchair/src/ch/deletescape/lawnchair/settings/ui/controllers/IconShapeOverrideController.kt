/*
 *     This file is part of Lawnchair Launcher.
 *
 *     Lawnchair Launcher is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Lawnchair Launcher is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Lawnchair Launcher.  If not, see <https://www.gnu.org/licenses/>.
 */

package ch.deletescape.lawnchair.settings.ui.controllers

import android.content.Context
import android.support.annotation.Keep
import android.support.v7.preference.ListPreference
import android.support.v7.preference.Preference
import ch.deletescape.lawnchair.lawnchairPrefs
import ch.deletescape.lawnchair.settings.ui.PreferenceController
import com.android.launcher3.R
import com.android.launcher3.graphics.IconShapeOverride

@Keep
class IconShapeOverrideController(context: Context) : PreferenceController(context) {

    override val isVisible = IconShapeOverride.isSupported(context)

    override fun onPreferenceAdded(preference: Preference): Boolean {
        if (!super.onPreferenceAdded(preference)) return false
        if (preference is ListPreference) {
            if (context.lawnchairPrefs.developerOptionsEnabled) {
                preference.setEntries(R.array.alt_icon_shape_names)
                preference.setEntryValues(R.array.alt_icon_shape_values)
            }
        }
        return true
    }
}
