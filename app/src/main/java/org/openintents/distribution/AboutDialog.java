/*
 * Copyright (C) 2007-2017 OpenIntents.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openintents.distribution;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import org.openintents.intents.AboutMiniIntents;
import org.openintents.timesheet.R;
import org.openintents.timesheet.Timesheet;
import org.openintents.util.IntentUtils;
import org.openintents.util.VersionUtils;

/**
 * About dialog
 *
 * @author Peli
 * @version 2009-01-16
 */
public class AboutDialog extends GetFromMarketDialog {
    private static final String TAG = "About";

    public AboutDialog(Context context) {
        super(context, R.string.aboutapp_not_available, R.string.aboutapp_get, R.string.aboutapp_market_uri, R.string.aboutapp_developer_uri);
        String version = VersionUtils.getVersionNumber(context);
        setTitle(VersionUtils.getApplicationName(context));
        setMessage(context.getString(R.string.aboutapp_not_available, new Object[]{version}));
    }

    public static void showDialogOrStartActivity(Activity activity, int dialogId) {
        Intent intent = new Intent(Timesheet.ACTION_SHOW_ABOUT_DIALOG);
        intent.putExtra(AboutMiniIntents.EXTRA_PACKAGE_NAME, activity.getPackageName());
        if (IntentUtils.isIntentAvailable(activity, intent)) {
            activity.startActivity(intent);
        } else {
            activity.showDialog(dialogId);
        }
    }
}
