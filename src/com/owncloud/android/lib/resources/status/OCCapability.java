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

    // Files Sharing
    private boolean mFilesSharingPublicEnabled;
    private boolean mFilesPublicPasswordEnforced;
    private boolean mFilesSharingPublicExpireDateEnabled;
    private boolean mFilesSharingPublicSendMail;
    private boolean mFilesSharingPublicUpload;
    private boolean mFilesSharingUserSendMail;
    private boolean mFilesSharingResharing;

    // Core PollInterval
    private int mCorePollinterval;

    // Files
    private boolean mFilesBigFileChuncking;
    private boolean mFilesUndelete;
    private boolean mFilesVersioning;

    public OCCapability(){
        mId = 0;
        mAccountName = "";

        mVersionMayor = 0;
        mVersionMinor = 0;
        mVersionMicro = 0;
        mVersionString = "";
        mVersionString = "";

        mFilesSharingPublicEnabled = true;
        mFilesPublicPasswordEnforced = false;
        mFilesSharingPublicExpireDateEnabled = false;
        mFilesSharingPublicSendMail = true;
        mFilesSharingPublicUpload = true;
        mFilesSharingUserSendMail = false;
        mFilesSharingResharing = true;

        mCorePollinterval = 0;

        mFilesBigFileChuncking = true;
        mFilesUndelete = true;
        mFilesVersioning = false;
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

    public boolean isFilesSharingPublicEnabled() {
        return mFilesSharingPublicEnabled;
    }

    public void setFilesSharingPublicEnabled(boolean filesSharingPublicEnabled) {
        this.mFilesSharingPublicEnabled = filesSharingPublicEnabled;
    }

    public boolean isFilesPublicPasswordEnforced() {
        return mFilesPublicPasswordEnforced;
    }

    public void setFilesPublicPasswordEnforced(boolean filesPublicPasswordEnforced) {
        this.mFilesPublicPasswordEnforced = filesPublicPasswordEnforced;
    }

    public boolean isFilesSharingPublicExpireDateEnabled() {
        return mFilesSharingPublicExpireDateEnabled;
    }

    public void setFilesSharingPublicExpireDateEnabled(boolean filesSharingPublicExpireDateEnabled) {
        this.mFilesSharingPublicExpireDateEnabled = filesSharingPublicExpireDateEnabled;
    }

    public boolean isFilesSharingPublicSendMail() {
        return mFilesSharingPublicSendMail;
    }

    public void setFilesSharingPublicSendMail(boolean filesSharingPublicSendMail) {
        this.mFilesSharingPublicSendMail = filesSharingPublicSendMail;
    }

    public boolean isFilesSharingPublicUpload() {
        return mFilesSharingPublicUpload;
    }

    public void setFilesSharingPublicUpload(boolean filesSharingPublicUpload) {
        this.mFilesSharingPublicUpload = filesSharingPublicUpload;
    }

    public boolean isFilesSharingUserSendMail() {
        return mFilesSharingUserSendMail;
    }

    public void setFilesSharingUserSendMail(boolean filesSharingUserSendMail) {
        this.mFilesSharingUserSendMail = filesSharingUserSendMail;
    }

    public boolean isFilesSharingResharing() {
        return mFilesSharingResharing;
    }

    public void setFilesSharingResharing(boolean filesSharingResharing) {
        this.mFilesSharingResharing = filesSharingResharing;
    }

    public int getCorePollinterval() {
        return mCorePollinterval;
    }

    public void setCorePollinterval(int corePollinterval) {
        this.mCorePollinterval = corePollinterval;
    }

    public boolean isFilesBigFileChuncking() {
        return mFilesBigFileChuncking;
    }

    public void setFilesBigFileChuncking(boolean filesBigFileChuncking) {
        this.mFilesBigFileChuncking = filesBigFileChuncking;
    }

    public boolean isFilesUndelete() {
        return mFilesUndelete;
    }

    public void setFilesUndelete(boolean filesUndelete) {
        this.mFilesUndelete = filesUndelete;
    }

    public boolean isFilesVersioning() {
        return mFilesVersioning;
    }

    public void setFilesVersioning(boolean filesVersioning) {
        this.mFilesVersioning = filesVersioning;
    }


}
