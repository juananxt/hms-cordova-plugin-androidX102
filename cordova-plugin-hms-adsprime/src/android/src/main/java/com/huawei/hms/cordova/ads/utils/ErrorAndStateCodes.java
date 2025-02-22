/*
    Copyright 2022. Huawei Technologies Co., Ltd. All rights reserved.

    Licensed under the Apache License, Version 2.0 (the "License")
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        https://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/

package com.huawei.hms.cordova.ads.utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public enum ErrorAndStateCodes {

    INVALID_ERROR_CODE(-1, "Unknown Error Code From API!"),
    AD_PARAM_INNER(0, "Internal error."),
    AD_PARAM_INVALID_REQUEST(1, "Invalid ad request."),
    AD_PARAM_NETWORK_ERROR(2, "Failed to send the ad request due to a network connection error."),
    AD_PARAM_NO_AD(3, "No ad."),
    AD_PARAM_AD_LOADING(4, "The ad is being loaded and cannot be requested again."),
    AD_PARAM_LOW_API(5, "The API version is not supported by HUAWEI Ads Kit."),
    AD_PARAM_BANNER_AD_EXPIRE(6, "The banner ad has expired."),
    AD_PARAM_BANNER_AD_CANCEL(7, "The banner ad task is removed."),
    AD_PARAM_HMS_NOT_SUPPORT_SET_APP(8, "The HMS Core (APK) version does not support the setting of AppInfo."),
    REWARD_AD_STATUS_INTERNAL(0, "Internal error."),
    REWARD_AD_STATUS_REUSED(1, "Duplicate ad."),
    REWARD_AD_STATUS_NOT_LOADED(2, "The ad has not been loaded."),
    REWARD_AD_STATUS_BACKGROUND(3, "The rewarded ad is played in the background."),
    NATIVE_AD_NOT_INITIALIZED(1003, "Native Ad not initialized yet."),
    NATIVE_AD_LOADER_NOT_INITIALIZED(1001, "Native Ad Loader not initialized yet."),
    NATIVE_AD_CONFIGURATION_NOT_INITIALIZED(1002, "Native Ad Configuration not initialized yet."),
    VIDEO_OPERATOR_NOT_INITIALIZED(1003, "Video operator not initialized yet."),
    REWARD_VERIFY_CONF_NOT_INITIALIZED(2001, "Reward verify config not initialized yet."),
    ROLL_AD_NOT_INITIALIZED(3001, "Roll Ad not initialized yet."),
    BANNER_AD_SIZE_NOT_INITIALIZED(4001, "Banner Ad size not initialized yet."),
    AD_NOT_INITIALIZED(5001, "Ad not initialized yet."),
    LOAD_AD_FAILED(4000, "The XML content fails to be parsed."),
    MAIN_AD_LOAD_FAILED(4003, "The ad cannot be played or fails to be loaded."),
    CREATIVE_TYPE_ERROR(4004, "Incorrect type of the asset to be parsed"),
    AD_SLOT_MORE_THAN_CREATIVE(4005, "The number of returned assets is less than that of ad units."),
    INVALID_STATE_CODE(-2, "Unknown State Code From API!"),
    PLAY_STATE_CREATIVE_TYPE_NOT_SPECIFIED_PLAYED(2001, "An ad whose creative type is not specified is being played"),
    PLAY_STATE_PLAYBACK_PAUSE(2002, "Playback pauses"),
    PLAY_STATE_VIDEO_PLAYED(2006, "A video ad is being played"),
    PLAY_STATE_IMAGE_PLAYED(2007, "An image ad is being played"),
    SCREEN_STATE_NORMAL(1001, "normal screen mode"),
    SCREEN_STATE_FULL(1002, "full screen mode");

    private String message;

    private int code;

    private static final Map<Integer, ErrorAndStateCodes> ERROR_AD_PARAM = new HashMap<>();

    private static final Map<Integer, ErrorAndStateCodes> ERROR_AD_REWARD_STATUS = new HashMap<>();

    private static final Map<Integer, ErrorAndStateCodes> ERROR_VAST_ADS_REQUEST = new HashMap<>();

    private static final Map<Integer, ErrorAndStateCodes> PLAY_STATE_CHANGED = new HashMap<>();

    private static final Map<Integer, ErrorAndStateCodes> SCREEN_STATE_CHANGED = new HashMap<>();

    ErrorAndStateCodes(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public JSONObject toJson() {
        try {
            return new JSONObject().put("code", code).put("message", message);
        } catch (JSONException e) {
            return new JSONObject();
        }
    }

    public static ErrorAndStateCodes fromCode(int code) {
        if (!ERROR_AD_PARAM.containsKey(code)) {
            return INVALID_ERROR_CODE;
        }
        return ERROR_AD_PARAM.get(code);
    }

    public static ErrorAndStateCodes fromCodeRewardAdStatus(int code) {
        if (!ERROR_AD_REWARD_STATUS.containsKey(code)) {
            return INVALID_ERROR_CODE;
        }
        return ERROR_AD_REWARD_STATUS.get(code);
    }

    public static ErrorAndStateCodes fromCodeVast(int code) {
        if (!ERROR_VAST_ADS_REQUEST.containsKey(code)) {
            return INVALID_ERROR_CODE;
        }
        return ERROR_VAST_ADS_REQUEST.get(code);
    }

    public static ErrorAndStateCodes fromCodePlayState(int code) {
        if (!PLAY_STATE_CHANGED.containsKey(code)) {
            return INVALID_STATE_CODE;
        }
        return PLAY_STATE_CHANGED.get(code);
    }

    public static ErrorAndStateCodes fromCodeScreenState(int code) {
        if (!SCREEN_STATE_CHANGED.containsKey(code)) {
            return INVALID_STATE_CODE;
        }
        return SCREEN_STATE_CHANGED.get(code);
    }

    static {
        ERROR_AD_PARAM.put(0, AD_PARAM_INNER);
        ERROR_AD_PARAM.put(1, AD_PARAM_INVALID_REQUEST);
        ERROR_AD_PARAM.put(2, AD_PARAM_NETWORK_ERROR);
        ERROR_AD_PARAM.put(3, AD_PARAM_NO_AD);
        ERROR_AD_PARAM.put(4, AD_PARAM_AD_LOADING);
        ERROR_AD_PARAM.put(5, AD_PARAM_LOW_API);
        ERROR_AD_PARAM.put(6, AD_PARAM_BANNER_AD_EXPIRE);
        ERROR_AD_PARAM.put(7, AD_PARAM_BANNER_AD_CANCEL);
        ERROR_AD_PARAM.put(8, AD_PARAM_HMS_NOT_SUPPORT_SET_APP);

        ERROR_AD_REWARD_STATUS.put(0, REWARD_AD_STATUS_INTERNAL);
        ERROR_AD_REWARD_STATUS.put(1, REWARD_AD_STATUS_REUSED);
        ERROR_AD_REWARD_STATUS.put(2, REWARD_AD_STATUS_NOT_LOADED);
        ERROR_AD_REWARD_STATUS.put(3, REWARD_AD_STATUS_BACKGROUND);

        ERROR_VAST_ADS_REQUEST.put(4000, LOAD_AD_FAILED);
        ERROR_VAST_ADS_REQUEST.put(4003, MAIN_AD_LOAD_FAILED);
        ERROR_VAST_ADS_REQUEST.put(4004, CREATIVE_TYPE_ERROR);
        ERROR_VAST_ADS_REQUEST.put(4005, AD_SLOT_MORE_THAN_CREATIVE);

        PLAY_STATE_CHANGED.put(2001, PLAY_STATE_CREATIVE_TYPE_NOT_SPECIFIED_PLAYED);
        PLAY_STATE_CHANGED.put(2002, PLAY_STATE_PLAYBACK_PAUSE);
        PLAY_STATE_CHANGED.put(2006, PLAY_STATE_VIDEO_PLAYED);
        PLAY_STATE_CHANGED.put(2007, PLAY_STATE_IMAGE_PLAYED);

        SCREEN_STATE_CHANGED.put(1001, SCREEN_STATE_NORMAL);
        SCREEN_STATE_CHANGED.put(1001, SCREEN_STATE_FULL);

    }
}
