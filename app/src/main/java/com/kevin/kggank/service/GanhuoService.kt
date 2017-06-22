package com.kevin.kggank.service


import com.kevin.kggank.constants.Category
import com.kevin.kggank.entity.GanhuoListEntity
import com.kevin.kggank.entity.GanhuoOneDayEntity

import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by kevin on 16/4/18.
 */
interface GanhuoService {

    @GET("day/{year}/{month}/{day}")
    fun getGanhuoOneDays(
            @Path("year") year: String,
            @Path("month") month: String,
            @Path("day") day: String
    ): Flowable<GanhuoOneDayEntity>

    /**
     * 获取福利数据

     * @param pageSize 每页个数
     * *
     * @param pageNo   页数
     * *
     * @return
     */
    @GET("data/" + Category.FULI + "/{pageSize}/{pageNo}")
    fun getGirlInfo(
            @Path("pageSize") pageSize: Int?,
            @Path("pageNo") pageNo: Int?
    ): Flowable<GanhuoListEntity>

    /**
     * 获取android数据

     * @param pageSize 每页个数
     * *
     * @param pageNo   页数
     * *
     * @return
     */
    @GET("data/" + Category.ANDROID + "/{pageSize}/{pageNo}")
    fun getAndroidInfo(
            @Path("pageSize") pageSize: Int?,
            @Path("pageNo") pageNo: Int?
    ): Flowable<GanhuoListEntity>


    /**
     * 获取ios数据

     * @param pageSize 每页个数
     * *
     * @param pageNo   页数
     * *
     * @return
     */
    @GET("data/" + Category.IOS + "/{pageSize}/{pageNo}")
    fun getIOSInfo(
            @Path("pageSize") pageSize: Int?,
            @Path("pageNo") pageNo: Int?
    ): Flowable<GanhuoListEntity>

    /**
     * 获取休息视频数据

     * @param pageSize 每页个数
     * *
     * @param pageNo   页数
     * *
     * @return
     */
    @GET("data/" + Category.VIDEO + "/{pageSize}/{pageNo}")
    fun getVideoInfo(
            @Path("pageSize") pageSize: Int?,
            @Path("pageNo") pageNo: Int?
    ): Flowable<GanhuoListEntity>

    /**
     * 获取前端数据

     * @param pageSize 每页个数
     * *
     * @param pageNo   页数
     * *
     * @return
     */
    @GET("data/" + Category.WEB + "/{pageSize}/{pageNo}")
    fun getWebInfo(
            @Path("pageSize") pageSize: Int?,
            @Path("pageNo") pageNo: Int?
    ): Flowable<GanhuoListEntity>

    /**
     * 获取拓展资源数据

     * @param pageSize 每页个数
     * *
     * @param pageNo   页数
     * *
     * @return
     */
    @GET("data/" + Category.EXTEND + "/{pageSize}/{pageNo}")
    fun getExtendInfo(
            @Path("pageSize") pageSize: Int?,
            @Path("pageNo") pageNo: Int?
    ): Flowable<GanhuoListEntity>

    /**
     * 获取所有类型数据

     * @param pageSize 每页个数
     * *
     * @param pageNo   页数
     * *
     * @return
     */
    @GET("data/" + Category.ALL + "/{pageSize}/{pageNo}")
    fun getAllInfo(
            @Path("pageSize") pageSize: Int?,
            @Path("pageNo") pageNo: Int?
    ): Flowable<GanhuoListEntity>
}

