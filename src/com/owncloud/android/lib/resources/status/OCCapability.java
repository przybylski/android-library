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

/**
 * Contains data of the Capabilities for an account, from the Capabilities API
 */
public class OCCapability {

    private static final String TAG = OCCapability.class.getSimpleName();

    private long mId;
    private String mAccountName;

    // Server version
    private int mVersionMayor;
    private int mVersionMinor;
    private int mVersionMicro;
    private String mVersionString;
    private String mVersionEdition;

    // Core PollInterval
    private int mCorePollinterval;

    // Files Sharing
    private CapabilityBooleanType mFilesSharingApiEnabled;

    private CapabilityBooleanType mFilesSharingPublicEnabled;
    private CapabilityBooleanType mFilesPublicPasswordEnforced;
    private CapabilityBooleanType mFilesSharingPublicExpireDateEnabled;
    private int mFilesSharingPublicExpireDateDays;
    private CapabilityBooleanType mFilesSharingPublicExpireDateEnforced;
    private CapabilityBooleanType mFilesSharingPublicSendMail;
    private CapabilityBooleanType mFilesSharingPublicUpload;

    private CapabilityBooleanType mFilesSharingUserSendMail;

    private CapabilityBooleanType mFilesSharingResharing;

    private CapabilityBooleanType mFilesSharingFederationOutgoing;
    private CapabilityBooleanType mFilesSharingFederationIncoming;

    // Files
    private CapabilityBooleanType mFilesBigFileChuncking;
    private CapabilityBooleanType mFilesUndelete;
    private CapabilityBooleanType mFilesVersioning;

    public OCCapability(){
        mId = 0;
        mAccountName = "";

        mVersionMayor = 0;
        mVersionMinor = 0;
        mVersionMicro = 0;
        mVersionString = "";
        mVersionString = "";

        mCorePollinterval = 0;

        mFilesSharingApiEnabled = CapabilityBooleanType.UNKNOWN;
        mFilesSharingPublicEnabled = CapabilityBooleanType.UNKNOWN;
        mFilesPublicPasswordEnforced = CapabilityBooleanType.UNKNOWN;
        mFilesSharingPublicExpireDateEnabled = CapabilityBooleanType.UNKNOWN;
        mFilesSharingPublicExpireDateDays = 0;
        mFilesSharingPublicExpireDateEnforced = CapabilityBooleanType.UNKNOWN;
        mFilesSharingPublicSendMail = CapabilityBooleanType.UNKNOWN;
        mFilesSharingPublicUpload = CapabilityBooleanType.UNKNOWN;
        mFilesSharingUserSendMail = CapabilityBooleanType.UNKNOWN;
        mFilesSharingResharing = CapabilityBooleanType.UNKNOWN;
        mFilesSharingFederationOutgoing = CapabilityBooleanType.UNKNOWN;
        mFilesSharingFederationIncoming = CapabilityBooleanType.UNKNOWN;

        mFilesBigFileChuncking = CapabilityBooleanType.UNKNOWN;
        mFilesUndelete = CapabilityBooleanType.UNKNOWN;
        mFilesVersioning = CapabilityBooleanType.UNKNOWN;
    }


    // Getters and Setters
    public String getAccountName() {
        return mAccountName;
    }

    public void setAccountName(String accountName) {
        this.mAccountName = accountName;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        this.mId = id;
    }

    public int getVersionMayor() {
        return mVersionMayor;
    }

    public void setVersionMayor(int versionMayor) {
        this.mVersionMayor = versionMayor;
    }

    public int getVersionMinor() {
        return mVersionMinor;
    }

    public void setVersionMinor(int versionMinor) {
        this.mVersionMinor = versionMinor;
    }

    public int getVersionMicro() {
        return mVersionMicro;
    }

    public void setVersionMicro(int versionMicro) {
        this.mVersionMicro = versionMicro;
    }

    public String getVersionString() {
        return mVersionString;
    }

    public void setVersionString(String versionString) {
        this.mVersionString = versionString;
    }

    public String getVersionEdition() {
        return mVersionEdition;
    }

    public void setVersionEdition(String versionEdition) {
        this.mVersionEdition = versionEdition;
    }


    public int getCorePollinterval() {
        return mCorePollinterval;
    }

    public void setCorePollinterval(int corePollinterval) {
        this.mCorePollinterval = corePollinterval;
    }

    public CapabilityBooleanType isFilesSharingApiEnabled() {
        return mFilesSharingApiEnabled;
    }

    public void setFilesSharingApiEnabled(CapabilityBooleanType filesSharingApiEnabled) {
        this.mFilesSharingApiEnabled = filesSharingApiEnabled;
    }

    public CapabilityBooleanType isFilesSharingPublicEnabled() {
        return mFilesSharingPublicEnabled;
    }

    public void setFilesSharingPublicEnabled(CapabilityBooleanType filesSharingPublicEnabled) {
        this.mFilesSharingPublicEnabled = filesSharingPublicEnabled;
    }

    public CapabilityBooleanType isFilesPublicPasswordEnforced() {
        return mFilesPublicPasswordEnforced;
    }

    public void setFilesPublicPasswordEnforced(CapabilityBooleanType filesPublicPasswordEnforced) {
        this.mFilesPublicPasswordEnforced = filesPublicPasswordEnforced;
    }

    public CapabilityBooleanType isFilesSharingPublicExpireDateEnabled() {
        return mFilesSharingPublicExpireDateEnabled;
    }

    public void setFilesSharingPublicExpireDateEnabled(CapabilityBooleanType filesSharingPublicExpireDateEnabled) {
        this.mFilesSharingPublicExpireDateEnabled = filesSharingPublicExpireDateEnabled;
    }

    public int getFilesSharingPublicExpireDateDays() {
        return mFilesSharingPublicExpireDateDays;
    }

    public void setFilesSharingPublicExpireDateDays(int filesSharingPublicExpireDateDays) {
        this.mFilesSharingPublicExpireDateDays = filesSharingPublicExpireDateDays;
    }

    public CapabilityBooleanType isFilesSharingPublicExpireDateEnforced() {
        return mFilesSharingPublicExpireDateEnforced;
    }

    public void setFilesSharingPublicExpireDateEnforced(CapabilityBooleanType filesSharingPublicExpireDateEnforced) {
        this.mFilesSharingPublicExpireDateEnforced = filesSharingPublicExpireDateEnforced;
    }


    public CapabilityBooleanType isFilesSharingPublicSendMail() {
        return mFilesSharingPublicSendMail;
    }

    public void setFilesSharingPublicSendMail(CapabilityBooleanType filesSharingPublicSendMail) {
        this.mFilesSharingPublicSendMail = filesSharingPublicSendMail;
    }

    public CapabilityBooleanType isFilesSharingPublicUpload() {
        return mFilesSharingPublicUpload;
    }

    public void setFilesSharingPublicUpload(CapabilityBooleanType filesSharingPublicUpload) {
        this.mFilesSharingPublicUpload = filesSharingPublicUpload;
    }

    public CapabilityBooleanType isFilesSharingUserSendMail() {
        return mFilesSharingUserSendMail;
    }

    public void setFilesSharingUserSendMail(CapabilityBooleanType filesSharingUserSendMail) {
        this.mFilesSharingUserSendMail = filesSharingUserSendMail;
    }

    public CapabilityBooleanType isFilesSharingResharing() {
        return mFilesSharingResharing;
    }

    public void setFilesSharingResharing(CapabilityBooleanType filesSharingResharing) {
        this.mFilesSharingResharing = filesSharingResharing;
    }


    public CapabilityBooleanType isFilesSharingFederationOutgoing() {
        return mFilesSharingFederationOutgoing;
    }

    public void setFilesSharingFederationOutgoing(CapabilityBooleanType filesSharingFederationOutgoing) {
        this.mFilesSharingFederationOutgoing = filesSharingFederationOutgoing;
    }

    public CapabilityBooleanType isFilesSharingFederationIncoming() {
        return mFilesSharingFederationIncoming;
    }

    public void setFilesSharingFederationIncoming(CapabilityBooleanType filesSharingFederationIncoming) {
        this.mFilesSharingFederationIncoming = filesSharingFederationIncoming;
    }

    public CapabilityBooleanType isFilesBigFileChuncking() {
        return mFilesBigFileChuncking;
    }

    public void setFilesBigFileChuncking(CapabilityBooleanType filesBigFileChuncking) {
        this.mFilesBigFileChuncking = filesBigFileChuncking;
    }

    public CapabilityBooleanType isFilesUndelete() {
        return mFilesUndelete;
    }

    public void setFilesUndelete(CapabilityBooleanType filesUndelete) {
        this.mFilesUndelete = filesUndelete;
    }

    public CapabilityBooleanType isFilesVersioning() {
        return mFilesVersioning;
    }

    public void setFilesVersioning(CapabilityBooleanType filesVersioning) {
        this.mFilesVersioning = filesVersioning;
    }




}
