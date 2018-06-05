package com.genitrust.wallofcoins.dashwallet.wallofcoins.api;

import java.util.List;
import java.util.Map;

import com.genitrust.wallofcoins.dashwallet.wallofcoins.request.CreateAuthReq;
import com.genitrust.wallofcoins.dashwallet.wallofcoins.response.AdsListActivityResp;
import com.genitrust.wallofcoins.dashwallet.wallofcoins.response.CaptureHoldResp;
import com.genitrust.wallofcoins.dashwallet.wallofcoins.response.CheckAuthResp;
import com.genitrust.wallofcoins.dashwallet.wallofcoins.response.ConfirmDepositResp;
import com.genitrust.wallofcoins.dashwallet.wallofcoins.response.CreateAdResp;
import com.genitrust.wallofcoins.dashwallet.wallofcoins.response.CreateAuthResp;
import com.genitrust.wallofcoins.dashwallet.wallofcoins.response.CreateDeviceResp;
import com.genitrust.wallofcoins.dashwallet.wallofcoins.response.CreateHoldResp;
import com.genitrust.wallofcoins.dashwallet.wallofcoins.response.CurrentAuthResp;
import com.genitrust.wallofcoins.dashwallet.wallofcoins.response.DiscoveryInputsResp;
import com.genitrust.wallofcoins.dashwallet.wallofcoins.response.GetAuthTokenResp;
import com.genitrust.wallofcoins.dashwallet.wallofcoins.response.GetCurrencyResp;
import com.genitrust.wallofcoins.dashwallet.wallofcoins.response.GetHoldsResp;
import com.genitrust.wallofcoins.dashwallet.wallofcoins.response.GetOffersResp;
import com.genitrust.wallofcoins.dashwallet.wallofcoins.response.GetPricingOptionsResp;
import com.genitrust.wallofcoins.dashwallet.wallofcoins.response.GetReceivingOptionsResp;
import com.genitrust.wallofcoins.dashwallet.wallofcoins.response.OrderListResp;
import com.genitrust.wallofcoins.dashwallet.wallofcoins.response.SendVerificationResp;
import com.genitrust.wallofcoins.dashwallet.wallofcoins.response.VerifyAdResp;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * RestApi Client Interface For all WOC RestFull API with Method
 * Get,Post,Update & Delete API call
 */
public interface RestApi {

    @GET("api/v1/auth/current/")
    Call<CurrentAuthResp> getCurrentAuth();

    @POST("api/v1/auth/")
    Call<CreateAuthResp> createAuth(@Body CreateAuthReq createAuthReq);

    @GET("api/v1/orders/")
    Call<List<OrderListResp>> getOrders(@Query("publisherId") String publisherId);


    @GET("api/v1/auth/{phone}/")
    Call<CheckAuthResp> checkAuth(@Path("phone") String username, @Query("publisherId") String publisherId);

    @DELETE("api/v1/auth/{phone}/")
    Call<CheckAuthResp> deleteAuth(@Path("phone") String username, @Query("publisherId") String publisherId);

    @DELETE("api/v1/orders/{orderId}/")
    Call<Void> cancelOrder(@Path("orderId") String orderId, @Query("publisherId") String publisherId);

    @FormUrlEncoded
    @POST("api/v1/auth/{phone}/authorize/")
    Call<GetAuthTokenResp> getAuthToken(@Path("phone") String username, @FieldMap Map<String, String> partMap);

    @GET("api/v1/banks/")
    Call<List<GetReceivingOptionsResp>> getReceivingOptions(@Query("country") String country, @Query("publisherId") String publisherId);


    //--------------dash wizard
    @GET("api/v1/banks/")
    Call<List<GetReceivingOptionsResp>> getReceivingOptions();
    //----------------------

    @GET("api/v1/ad/")
    Call<List<AdsListActivityResp>> getAdsListing();

    @GET("api/v1/markets/{crypto}/{currency}/")
    Call<List<GetPricingOptionsResp>> getPricingOptions(@Path("crypto") String crypto, @Path("currency") String currency);

    @GET("api/v1/currency/")
    Call<List<GetCurrencyResp>> getCurrency();

    @FormUrlEncoded
    @POST("api/adcreate/")
    Call<CreateAdResp> createAd(@FieldMap Map<String, Object> partMap);

    @FormUrlEncoded
    @POST("api/sendVerification/")
    Call<SendVerificationResp> sendVerification(@FieldMap Map<String, Object> partMap);

    @FormUrlEncoded
    @POST("api/verifyAd/")
    Call<VerifyAdResp> verifyAd(@FieldMap Map<String, String> partMap);

    @FormUrlEncoded
    @POST("api/v1/discoveryInputs/")
    Call<DiscoveryInputsResp> discoveryInputs(@FieldMap Map<String, String> partMap);

    @GET("api/v1/discoveryInputs/{discoveryId}/offers/")
    Call<GetOffersResp> getOffers(@Path("discoveryId") String discoveryId, @Query("publisherId") String publisherId);

    @FormUrlEncoded
    @POST("api/v1/holds/")
    Call<CreateHoldResp> createHold(@FieldMap Map<String, String> partMap);

    @GET("api/v1/holds/")
    Call<List<GetHoldsResp>> getHolds();

    @DELETE("api/v1/holds/{id}/")
    Call<Void> deleteHold(@Path("id") String id);

    @FormUrlEncoded
    @POST("api/v1/holds/{id}/capture/")
    Call<List<CaptureHoldResp>> captureHold(@Path("id") String id, @FieldMap Map<String, String> partMap);

    @FormUrlEncoded
    @POST("api/v1/orders/{holdId}/confirmDeposit/")
    Call<ConfirmDepositResp> confirmDeposit(@Path("holdId") String holdId, @Field("your_field") String yourField, @Query("publisherId") String publisherId);

    @FormUrlEncoded
    @POST("api/v1/devices/")
    Call<CreateDeviceResp> createDevice(@FieldMap Map<String, String> partMap);

    @GET("api/v1/devices/")
    Call<List<CreateDeviceResp>> getDevice();

}
