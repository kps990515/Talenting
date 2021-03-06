package a.talenting.com.talenting.domain.profile.photo;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.Response;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by user on 2017-12-14.
 */

public interface IProfilePhotoApiService {
    @Multipart
    @POST("/member/profile/{profile_pk}/image/")
    Observable<Response<Void>> create(
            @Header("Authorization") String token,
            @Path("profile_pk") String profilePk,
            @Part MultipartBody.Part image);

    @GET("/member/profile/{profile_pk}/image/{image_pk}/")
    Observable<ProfileImageResponse> retrieve(
            @Header("Authorization") String token,
            @Path("profile_pk")String profilePk,
            @Path("image_pk")String pk);

    @Multipart
    @PUT("/member/profile/{profile_pk}/image/{image_pk}/")
    Observable<Response<Void>> update(
            @Header("Authorization") String token,
            @Path("profile_pk")String profilePk,
            @Path("image_pk")String pk,
            @Part MultipartBody.Part image);

    @DELETE("/member/profile/{profile_pk}/image/{image_pk}/")
    Observable<Response<Void>> delete(
            @Header("Authorization") String token,
            @Path("profile_pk")String profilePk,
            @Path("image_pk")String pk);

}
