package com.kevin.kggank.entity;

import com.google.gson.annotations.SerializedName;
import com.kevin.kggank.constants.Category;

import java.util.List;

import retrofit2.http.PUT;

/**
 * 干货显示暂时也为这个列表顺序
 * Created by kevin on 16/5/18.
 */
public class GanhuoOneDayEntity extends CategoryResultEntity<GanhuoOneDayEntity.GanhuoOneDayDataEntity>{

    public static class GanhuoOneDayDataEntity {

        @SerializedName(Category.FULI)
        List<GanhuoEntity> girlInfo;

        @SerializedName(Category.ANDROID)
        List<GanhuoEntity> androidInfo;

        @SerializedName(Category.IOS)
        List<GanhuoEntity> iosInfo;

        @SerializedName(Category.APP)
        List<GanhuoEntity> appInfo;

        @SerializedName(Category.WEB)
        List<GanhuoEntity> webInfo;

        @SerializedName(Category.EXTEND)
        List<GanhuoEntity> extendInfo;

        @SerializedName(Category.RECOMMEND)
        List<GanhuoEntity> recommendInfo;

        @SerializedName(Category.VIDEO)
        List<GanhuoEntity> videoInfo;

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

        public List<GanhuoEntity> getAppInfo() {
            return appInfo;
        }

        public void setAppInfo(List<GanhuoEntity> appInfo) {
            this.appInfo = appInfo;
        }

        public List<GanhuoEntity> getWebInfo() {
            return webInfo;
        }

        public void setWebInfo(List<GanhuoEntity> webInfo) {
            this.webInfo = webInfo;
        }
    }
}