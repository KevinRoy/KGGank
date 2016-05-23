package com.kevin.kggank.net.service;


import com.kevin.kggank.constants.Category;
import com.kevin.kggank.entity.BaseResultEntity;
import com.kevin.kggank.entity.CategoryResultEntity;
import com.kevin.kggank.entity.GanhuoEntity;
import com.kevin.kggank.entity.GanhuoListEntity;
import com.kevin.kggank.entity.GanhuoOneDayEntity;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by kevin on 16/4/18.
 */
public interface GanhuoService {

    @GET("day/{year}/{month}/{day}")
    Observable<GanhuoOneDayEntity> getGanhuoOneDays(
            @Path("year") String year,
            @Path("month") String month,
            @Path("day") String day
    );

    /**
     * 获取福利数据
     *
     * @param pageSize 每页个数
     * @param pageNo   页数
     * @return
     */
    @GET("data/" + Category.FULI + "/{pageSize}/{pageNo}")
    Observable<GanhuoListEntity> getGirlInfo(
            @Path("pageSize") Integer pageSize,
            @Path("pageNo") Integer pageNo
    );

    /**
     * 获取android数据
     *
     * @param pageSize 每页个数
     * @param pageNo   页数
     * @return
     */
    @GET("data/" + Category.ANDROID + "/{pageSize}/{pageNo}")
    Observable<GanhuoListEntity> getAndroidInfo(
            @Path("pageSize") Integer pageSize,
            @Path("pageNo") Integer pageNo
    );


    /**
     * 获取ios数据
     *
     * @param pageSize 每页个数
     * @param pageNo   页数
     * @return
     */
    @GET("data/" + Category.IOS + "/{pageSize}/{pageNo}")
    Observable<GanhuoListEntity> getIOSInfo(
            @Path("pageSize") Integer pageSize,
            @Path("pageNo") Integer pageNo
    );

    /**
     * 获取休息视频数据
     *
     * @param pageSize 每页个数
     * @param pageNo   页数
     * @return
     */
    @GET("data/" + Category.VIDEO + "/{pageSize}/{pageNo}")
    Observable<GanhuoListEntity> getVideoInfo(
            @Path("pageSize") Integer pageSize,
            @Path("pageNo") Integer pageNo
    );

    /**
     * 获取前端数据
     *
     * @param pageSize 每页个数
     * @param pageNo   页数
     * @return
     */
    @GET("data/" + Category.WEB + "/{pageSize}/{pageNo}")
    Observable<GanhuoListEntity> getWebInfo(
            @Path("pageSize") Integer pageSize,
            @Path("pageNo") Integer pageNo
    );

    /**
     * 获取拓展资源数据
     *
     * @param pageSize 每页个数
     * @param pageNo   页数
     * @return
     */
    @GET("data/" + Category.EXTEND + "/{pageSize}/{pageNo}")
    Observable<GanhuoListEntity> getExtendInfo(
            @Path("pageSize") Integer pageSize,
            @Path("pageNo") Integer pageNo
    );

    /**
     * 获取所有类型数据
     *
     * @param pageSize 每页个数
     * @param pageNo   页数
     * @return
     */
    @GET("data/" + Category.ALL + "/{pageSize}/{pageNo}")
    Observable<GanhuoListEntity> getAllInfo(
            @Path("pageSize") Integer pageSize,
            @Path("pageNo") Integer pageNo
    );
}

