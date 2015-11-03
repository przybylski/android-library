/* ownCloud Android Library is available under MIT license
 *   @author masensio
 *   Copyright (C) 2015 ownCloud Inc.
 *
 *   Permission is hereby granted, free of charge, to any person obtaining a copy
 *   of this software and associated documentation files (the "Software"), to deal
 *   in the Software without restriction, including without limitation the rights
 *   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *   copies of the Software, and to permit persons to whom the Software is
 *   furnished to do so, subject to the following conditions:
 *
 *   The above copyright notice and this permission notice shall be included in
 *   all copies or substantial portions of the Software.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *   EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *   MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *   NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
 *   BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 *   ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 *   CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *   THE SOFTWARE.
 *
 */

package com.owncloud.android.lib.resources.status;

import android.net.Uri;

import com.owncloud.android.lib.common.OwnCloudClient;
import com.owncloud.android.lib.common.operations.RemoteOperation;
import com.owncloud.android.lib.common.operations.RemoteOperationResult;
import com.owncloud.android.lib.common.utils.Log_OC;

import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.http.HttpStatus;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Get the Capabilities from the server
 *
 * Save in Result.getData:
 * - data[0]: Version node in a HashTable<String,String> with the keys:
 *      - major
 *      - minor
 *      - micro
 *      - string
 *      - edition
 * - data[1]: int with core-pollinterval
 * - data[2]: Files Sharing node in a HashTable<Boolean, String> with the keys:
 *      - public:enabled
 *      - public-password:enforced
 *      - public-expire_date:enabled
 *      - public:send_mail
 *      - public:upload
 *      - user:send_mail
 *      - resharing
 * - data[3]: Files node in a HashTable<Boolean, String> with the keys:
 *      - files:bigfilechunking
 *      - files:undelete
 *      - files:versioning
 */
public class GetRemoteCapabilitiesOperation extends RemoteOperation {

    private static final String TAG = GetRemoteCapabilitiesOperation.class.getSimpleName();


    // OCS Routes
    private static final String OCS_ROUTE = "/ocs/v1.php/cloud/capabilities";

    // Arguments - names
    private static final String PARAM_FORMAT = "format";

    // Arguments - constant values
    private static final String VALUE_FORMAT = "json";

    // JSON Node names
    private static final String NODE_OCS = "ocs";

    private static final String NODE_META = "meta";

    private static final String NODE_DATA = "data";
    private static final String NODE_VERSION = "version";

    private static final String NODE_CAPABILITIES = "capabilities";
    private static final String NODE_CORE = "core";
    private static final String NODE_FILES_SHARING = "files_sharing";
    public static final String NODE_PUBLIC = "public";
    public static final String NODE_PASSWORD = "password";
    public static final String NODE_EXPIRE_DATE = "expire_date";
    public static final String NODE_USER = "user";
    public static final String NODE_FILES = "files";

    private static final String PROPERTY_STATUS = "status";
    private static final String PROPERTY_STATUSCODE = "statuscode";
    private static final String PROPERTY_MESSAGE = "message";

    private static final String PROPERTY_POLLINTERVAL = "pollinterval";

    public static final String PROPERTY_MAJOR = "major";
    public static final String PROPERTY_MINOR = "minor";
    public static final String PROPERTY_MICRO = "micro";
    public static final String PROPERTY_STRING = "string";
    public static final String PROPERTY_EDITION = "edition";

    public static final String PROPERTY_ENABLED = "enabled";
    public static final String PROPERTY_ENFORCED = "enforced";
    public static final String PROPERTY_SEND_MAIL = "send_mail";
    public static final String PROPERTY_UPLOAD = "upload";
    public static final String PROPERTY_RESHARING = "resharing";

    public static final String PROPERTY_BIGFILECHUNKING = "bigfilechunking";
    public static final String PROPERTY_UNDELETE = "undelete";
    public static final String PROPERTY_VERSIONING = "versioning";


    /**
     * Constructor
     *
     */
    public GetRemoteCapabilitiesOperation() {

    }

    @Override
    protected RemoteOperationResult run(OwnCloudClient client) {
        RemoteOperationResult result = null;
        int status;
        GetMethod get = null;

        try {
            Uri requestUri = client.getBaseUri();
            Uri.Builder uriBuilder = requestUri.buildUpon();
            uriBuilder.appendEncodedPath(OCS_ROUTE);
            uriBuilder.appendQueryParameter(PARAM_FORMAT, VALUE_FORMAT);

            // Get Method
            get = new GetMethod(uriBuilder.build().toString());
            get.addRequestHeader(OCS_API_HEADER, OCS_API_HEADER_VALUE);

            status = client.executeMethod(get);

            if(isSuccess(status)) {
                String response = get.getResponseBodyAsString();
                Log_OC.d(TAG, "Successful response: " + response);

                // Parse the response
                JSONObject respJSON = new JSONObject(response);
                JSONObject respOCS = respJSON.getJSONObject(NODE_OCS);
                JSONObject respMeta = respOCS.getJSONObject(NODE_META);
                JSONObject respData = respOCS.getJSONObject(NODE_DATA);
                JSONObject respVersion = respData.getJSONObject(NODE_VERSION);
                JSONObject respCapabilities = respData.getJSONObject(NODE_CAPABILITIES);
                JSONObject respCore = respCapabilities.getJSONObject(NODE_CORE);
                JSONObject respFilesSharing = respCapabilities.getJSONObject(NODE_FILES_SHARING);
                JSONObject respPublic = respFilesSharing.getJSONObject(NODE_PUBLIC);
                JSONObject respUser = respFilesSharing.getJSONObject(NODE_USER);
                JSONObject respFiles = respCapabilities.getJSONObject(NODE_FILES);

                // Read meta
                boolean statusProp = respMeta.getBoolean(PROPERTY_STATUS);
                int statuscode = respMeta.getInt(PROPERTY_STATUSCODE);
                String message = respMeta.getString(PROPERTY_MESSAGE);

                if (statusProp) {
                    ArrayList<Object> data = new ArrayList<Object>(); // For result data
                    // Add Version
                    Hashtable<String, String> versionTable = new Hashtable<String, String>(5);
                    versionTable.put(String.valueOf(respVersion.getInt(PROPERTY_MAJOR)), PROPERTY_MAJOR);
                    versionTable.put(String.valueOf(respVersion.getInt(PROPERTY_MINOR)), PROPERTY_MINOR);
                    versionTable.put(String.valueOf(respVersion.getInt(PROPERTY_MICRO)), PROPERTY_MICRO);
                    versionTable.put(respVersion.getString(PROPERTY_STRING), PROPERTY_STRING);
                    versionTable.put(respVersion.getString(PROPERTY_EDITION), PROPERTY_EDITION);
                    data.add(versionTable);
                    Log_OC.d(TAG, "*** Added " + NODE_VERSION);

                    // Add Core: pollinterval
                    data.add(respCore.getInt(PROPERTY_POLLINTERVAL));
                    Log_OC.d(TAG, "*** Added " + NODE_CORE);

                    // Add files_sharing: public, user, resharing
                    Hashtable<Boolean, String> fileSharing = new Hashtable<Boolean, String>(6);
                    fileSharing.put(respPublic.getBoolean(PROPERTY_ENABLED),
                            NODE_PUBLIC + ":" + PROPERTY_ENABLED);
                    fileSharing.put(respPublic.getJSONObject(NODE_PASSWORD).getBoolean(PROPERTY_ENFORCED),
                            NODE_PUBLIC + "-" + NODE_PASSWORD + ":" + PROPERTY_ENFORCED);
                    fileSharing.put(respPublic.getJSONObject(NODE_EXPIRE_DATE).getBoolean(PROPERTY_ENABLED),
                            NODE_PUBLIC + "-" + NODE_EXPIRE_DATE + ":" + PROPERTY_ENABLED);
                    fileSharing.put(respPublic.getBoolean(PROPERTY_UPLOAD),
                            NODE_PUBLIC + ":" + PROPERTY_UPLOAD);
                    fileSharing.put(respUser.getBoolean(PROPERTY_SEND_MAIL),
                            NODE_USER + ":" + PROPERTY_SEND_MAIL);
                    fileSharing.put(respFilesSharing.getBoolean(PROPERTY_RESHARING), PROPERTY_RESHARING);
                    data.add(fileSharing);
                    Log_OC.d(TAG, "*** Added " + NODE_FILES_SHARING);

                    // Add files
                    Hashtable<Boolean, String> files = new Hashtable<Boolean, String>(3);
                    files.put(respFiles.getBoolean(PROPERTY_BIGFILECHUNKING),
                            NODE_FILES + ":" + PROPERTY_BIGFILECHUNKING);
                    files.put(respFiles.getBoolean(PROPERTY_UNDELETE),
                            NODE_FILES + ":" + PROPERTY_UNDELETE);
                    files.put(respFiles.getBoolean(PROPERTY_VERSIONING),
                            NODE_FILES + ":" + PROPERTY_VERSIONING);
                    data.add(files);
                    Log_OC.d(TAG, "*** Added " + NODE_FILES);

                    // Result
                    result = new RemoteOperationResult(true, status, get.getResponseHeaders());
                    result.setData(data);

                    Log_OC.d(TAG, "*** Get Capabilities completed ");
                } else {
                    result = new RemoteOperationResult(statusProp, statuscode, null);
                    Log_OC.e(TAG, "Failed response while getting capabilities from the server ");
                    Log_OC.e(TAG, "*** status: " + statusProp+ "; message: " + message);
                }

            } else {
                result = new RemoteOperationResult(false, status, get.getResponseHeaders());
                String response = get.getResponseBodyAsString();
                Log_OC.e(TAG, "Failed response while getting capabilities from the server ");
                if (response != null) {
                    Log_OC.e(TAG, "*** status code: " + status + "; response message: " + response);
                } else {
                    Log_OC.e(TAG, "*** status code: " + status);
                }
            }

        } catch (Exception e) {
            result = new RemoteOperationResult(e);
            Log_OC.e(TAG, "Exception while getting capabilities", e);

        } finally {
            if (get != null) {
                get.releaseConnection();
            }
        }
        return result;
    }

    private boolean isSuccess(int status) {
        return (status == HttpStatus.SC_OK);
    }
}
