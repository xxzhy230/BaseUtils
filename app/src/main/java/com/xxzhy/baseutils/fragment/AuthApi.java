package com.xxzhy.baseutils.fragment;


import com.xxzhy.baseutils.http.JsonResult;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface AuthApi {
    //"查看某个用户动态"

//    String USERINFO = Http.baseUrl + "dynamic/user/";
//    String STATISTICS = Http.baseUrl + "user/statistics";
//    String USER = Http.baseUrl + "user/";
//    String FOLLOW = Http.baseUrl + "follow/";
//    String FOLLOWER = Http.baseUrl + "follow/follower/";
//    String DYNAMICTAG = Http.baseUrl + "dynamic/tag/";
//    String TAG = Http.baseUrl + "tag/";



    /**
     * 获取验证码
     *
     * @return
     */
    @GET("api/version/findversioninformation")
    Observable<JsonResult<DataMoudle.DataBean>> version();



    /**
     * 校验验证码
     *
     * @param phone
     * @param code
     * @return
     */
    @GET("app/verifyMsgCode")
    Observable<JsonResult<Boolean>> verifyCode(@Query("phone") String phone, @Query("code") String code);


    /**
     * 注册
     *
     * @return
     */
    @Multipart
    @POST("app/register")
    Observable<JsonResult<DataMoudle.DataBean>> register(@Part MultipartBody.Part avatar,
                                                         @Query("nickName") String nickName,
                                                         @Query("birthday") String birthday,
                                                         @Query("sex") String sex,
                                                         @Query("phone") String phone,
                                                         @Query("password") String password);

    /**
     * 获取用户信息
     *
     * @return
     */
    @GET("user/")
    Observable<JsonResult<DataMoudle.DataBean>> getUser();

    /**
     * 修改用户信息
     *
     * @return
     */
    @POST("user/")
    Observable<JsonResult<DataMoudle.DataBean>> setUserNickName(
            @Query("nickName") String nickName);

    @POST("user/")
    Observable<JsonResult<DataMoudle.DataBean>> setUserBirthday(
            @Query("birthday") String nickName);

    @Multipart
    @POST("user/")
    Observable<JsonResult<DataMoudle.DataBean>> setUserheadImg(
            @Part MultipartBody.Part avatar);

    @POST("user/")
    Observable<JsonResult<DataMoudle.DataBean>> setUserSign(
            @Query("sign") String sign);

    @POST("user/")
    Observable<JsonResult<DataMoudle.DataBean>> setUserSex(
            @Query("sex") String sex);

    /**
     * 获取统计数据,包括发布动态数，获赞数，关注数，粉丝数
     *
     * @return
     */
    @GET("user/statistics")
    Observable<JsonResult<DataMoudle.DataBean>> getStatistics(@Query("othersId") String othersId);


    /**
     * 设置密码
     *
     * @param type 0:通过旧密码修改 1:通过手机号发送验证码修改
     * @return
     */
    @POST("user/password")
    Observable<JsonResult<Object>> settingPwd(@Body Map<String, String> params,
                                              @Query("type") String type);

    /**
     * 重置密码
     *
     * @return
     */
    @POST("user/password/forgot")
    Observable<JsonResult<Object>> forgot(@Body Map<String, String> params);

    /**
     * 忘记密码
     *
     * @param pwd
     * @return
     */
    @FormUrlEncoded
    @POST("user/resetpassword")
    Observable<JsonResult<Object>> forgetPwd(@Field("phone") String phone,
                                             @Field("password") String pwd,
                                             @Field("smscode") String smscode);


    /**
     * 反馈信息
     *
     * @param contact
     * @param content
     * @param userId
     * @return
     */
    @Multipart
    @POST("user/feedback")
    Observable<JsonResult<String>> feedback(@Query("contact") String contact,
                                            @Query("content") String content,
                                            @Part MultipartBody.Part avatar,
                                            @Query("userId") String userId);

    /**
     * 反馈信息
     *
     * @param contact
     * @param content
     * @param userId
     * @return
     */
    @POST("user/feedback")
    Observable<JsonResult<String>> feedback(@Query("contact") String contact,
                                            @Query("content") String content,
                                            @Query("userId") String userId);

    /**
     * 用户协议
     */
    @GET("app/userAgreement")
    Observable<JsonResult<String>> userAgreement();

    /**
     * 点赞
     */
    @POST("dynamic/like")
    Observable<JsonResult<DataMoudle.DataBean>> like(@Body Map<String, String> params);

    /**
     * 删除动态
     */
    @DELETE("dynamic/{dynamicId}")
    Observable<JsonResult<String>> delDynamic(@Path("dynamicId") String dynamicId);


    /**
     * 发送动态有图片
     *
     * @return
     */
    @Multipart
    @POST("dynamic")
    Observable<JsonResult<String>> sendDynamic(@Part MultipartBody.Part[] images,
                                               @Query("cityCode") String cityCode,
                                               @Query("content") String content,
                                               @Query("groupId") String groupId,
                                               @Query("groupName") String groupName,
                                               @Query("latitude") String latitude,
                                               @Query("longitude") String longitude,
                                               @Query("localName") String localName,
                                               @Query("tagId") String tagId,
                                               @Query("tagName") String tagName);

    /**
     * 发送动态无图片
     *
     * @return
     */
    @POST("dynamic")
    Observable<JsonResult<String>> sendDynamic(@Query("cityCode") String cityCode,
                                               @Query("content") String content,
                                               @Query("groupId") String groupId,
                                               @Query("groupName") String groupName,
                                               @Query("latitude") String latitude,
                                               @Query("longitude") String longitude,
                                               @Query("localName") String localName,
                                               @Query("tagId") String tagId,
                                               @Query("tagName") String tagName);

    /**
     * 发送动态有视频
     *
     * @return
     */
    @Multipart
    @POST("dynamic")
    Observable<JsonResult<String>> sendDynamicVideo(@Part MultipartBody.Part video,
                                                    @Query("cityCode") String cityCode,
                                                    @Query("content") String content,
                                                    @Query("groupId") String groupId,
                                                    @Query("groupName") String groupName,
                                                    @Query("latitude") String latitude,
                                                    @Query("longitude") String longitude,
                                                    @Query("localName") String localName,
                                                    @Query("tagId") String tagId,
                                                    @Query("tagName") String tagName);



    /**
     * 发送评论
     */
    @POST("v2/comment")
    Observable<JsonResult<String>> sendComment(@Body Map<String, String> params);

    /**
     * 回复评论
     */
    @POST("reply")
    Observable<JsonResult<String>> sendReply(@Body Map<String, String> params);

    /**
     * 屏蔽动态
     */
    @POST("blacklist/dynamic/{dynamicId}")
    Observable<JsonResult<String>> blackDynamic(@Path("dynamicId") String dynamicId);

    /**
     * 加入黑名单
     */
    @POST("blacklist/user/{userId}")
    Observable<JsonResult<String>> blackUser(@Path("userId") String userId);


    /**
     * 移除黑名单
     */
    @PUT("blacklist/user/{userId}")
    Observable<JsonResult<String>> delBlackUser(@Path("userId") String userId);

    /**
     * 举报动态
     */
    @POST("report/dynamic")
    Observable<JsonResult<String>> dynamicReport(@Body Map<String, String> params);


    /**
     * 删除评论
     */
    @DELETE("v2/comment/{commentId}")
    Observable<JsonResult<String>> delComment(@Path("commentId") String commentId);

    /**
     * 举报评论
     */
    @POST("commentReport/")
    Observable<JsonResult<String>> commentReport(@Body Map<String, String> params);

    /**
     * 修改小队描述
     */
    @POST("v2/team/{teamId}")
    Observable<JsonResult<String>> editTeamDesc(@Path("teamId") String teamId,
                                                @Query("teamDesc") String teamDesc);
    /**
     * 修改小队名称
     */
    @POST("v2/team/{teamId}")
    Observable<JsonResult<String>> editTeamName(@Path("teamId") String teamId,
                                                @Query("teamName") String teamName);
    /**
     * 修改小队头像
     */
    @Multipart
    @POST("v2/team/{teamId}")
    Observable<JsonResult<String>> editTeamImg(@Path("teamId") String teamId,
                                               @Part MultipartBody.Part[] images);

    /**
     * 加入或退出小队
     * 0表示退出小队，1表示加入小队
     */
    @PUT("v2/team/{teamId}")
    Observable<JsonResult<String>> teamOutOrAdd(@Path("teamId") String teamId,
                                                @Query("type") String type);

    /**
     * 删除小队
     *
     * @return
     */
    @DELETE("v2/team/{teamId}")
    Observable<JsonResult<String>> delTeam(@Path("teamId") String teamId);


    /**
     * 创建小队
     */
    @Multipart
    @POST("v2/team/")
    Observable<JsonResult<Object>> creatTeam(@Query("cityCode") String cityCode,
                                             @Query("latitude") String latitude,
                                             @Query("longitude") String longitude,
                                             @Query("localName") String localName,
                                             @Query("teamDesc") String teamDesc,
                                             @Query("teamName") String teamName,
                                             @Query("teamImgHeight") int teamImgHeight,
                                             @Query("teamImgWidth") int teamImgWidth,
                                             @Part MultipartBody.Part[] parts);

    /**
     * 举报小队
     */
    @POST("teamReport/")
    Observable<JsonResult<String>> teamReport(@Body Map<String, String> params);

    /**
     * 编辑小队信息
     */
    @Multipart
    @POST("v2/team/{teamId}")
    Observable<JsonResult<String>> editTeam(@Path("teamId") String teamId,
                                            @Part MultipartBody.Part[] parts,
                                            @Query("teamName") String teamName,
                                            @Query("teamDesc") String teamDesc,
                                            @Query("teamImgHeight") int teamImgHeight,
                                            @Query("teamImgWidth") int teamImgWidth);

    /**
     * 编辑小队信息
     */
    @POST("v2/team/{teamId}")
    Observable<JsonResult<String>> editTeam(@Path("teamId") String teamId,
                                            @Query("teamName") String teamName,
                                            @Query("teamDesc") String teamDesc);


    /**
     * 获取热门话题
     */
    @GET("search/hot")
    Observable<JsonResult<List<String>>> hot();

    /**
     * 获取标签下的群聊
     *
     * @param tagId
     * @return
     */
    @GET("tag/{tagId}/groups")
    Observable<JsonResult<List<String>>> tagGroups(@Path("tagId") String tagId);


    /**
     * 举报标签
     *
     * @return
     */
    @POST("tagReport")
    Observable<JsonResult<String>> tagReport(@Body Map<String, String> params);

    /**
     * 创建标签
     *
     * @return
     */
    @Multipart
    @POST("tag")
    Observable<JsonResult<String>> tag(@Part MultipartBody.Part[] parts,
                                       @Query("tagName") String tagName,
                                       @Query("tagDesc") String tagDesc,
                                       @Query("topicId") String topicId);



    /**
     * 修改群组头像
     */
    @Multipart
    @POST("group/")
    Observable<JsonResult<Object>> groupHead(@Body Map<String, String> params);


    /**
     * 删除小队中的成员
     */
    @PUT("v2/team/{teamId}/members")
    Observable<JsonResult<String>> delTeamMember(@Path("teamId") String teamId, @Body Map<String, String> params);


}
