package com.kevin.kggank.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.http.PUT;

/**
 * Created by kevin on 16/5/18.
 */
public class GanhuoOneDayEntity extends CategoryResultEntity<GanhuoOneDayEntity.GanhuoOneDayDataEntity>{

    public static class GanhuoOneDayDataEntity {

        @SerializedName("Android")
        List<GanhuoEntity> androidInfo;

        @SerializedName("iOS")
        List<GanhuoEntity> iosInfo;

        @SerializedName("拓展资源")
        List<GanhuoEntity> extendInfo;

        @SerializedName("瞎推荐")
        List<GanhuoEntity> recommendInfo;

        @SerializedName("休息视频")
        List<GanhuoEntity> videoInfo;

        @SerializedName("福利")
        List<GanhuoEntity> girlInfo;

        public List<GanhuoEntity> getAndroidInfo() {
            return androidInfo;
        }

        public void setAndroidInfo(List<GanhuoEntity> androidInfo) {
            this.androidInfo = androidInfo;
        }

        public List<GanhuoEntity> getIosInfo() {
            return iosInfo;
        }

        public void setIosInfo(List<GanhuoEntity> iosInfo) {
            this.iosInfo = iosInfo;
        }

        public List<GanhuoEntity> getExtendInfo() {
            return extendInfo;
        }

        public void setExtendInfo(List<GanhuoEntity> extendInfo) {
            this.extendInfo = extendInfo;
        }

        public List<GanhuoEntity> getRecommendInfo() {
            return recommendInfo;
        }

        public void setRecommendInfo(List<GanhuoEntity> recommendInfo) {
            this.recommendInfo = recommendInfo;
        }

        public List<GanhuoEntity> getVideoInfo() {
            return videoInfo;
        }

        public void setVideoInfo(List<GanhuoEntity> videoInfo) {
            this.videoInfo = videoInfo;
        }

        public List<GanhuoEntity> getGirlInfo() {
            return girlInfo;
        }

        public void setGirlInfo(List<GanhuoEntity> girlInfo) {
            this.girlInfo = girlInfo;
        }
    }
}