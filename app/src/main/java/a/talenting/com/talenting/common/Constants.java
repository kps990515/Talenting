package a.talenting.com.talenting.common;

/**
 * Created by daeho on 2017. 11. 28..
 */

public class Constants {
    public static final int REQ_LOG_IN_ACTIVITY = 1;

    public static final int REQ_SIGN_UP = 100;
    public static final int REQ_LOG_IN = 110;
    public static final int REQ_LOG_IN_GOOGLE = 111;
    public static final int REQ_LOG_IN_FACEBOOK = 112;
    public static final int REQ_LOG_OPTION = 120;

    public static final int REQ_ADD_HOSTING = 900;
    public static final int REQ_EDIT_HOSTING = 901;
    public static final int REQ_ADD_EVENT = 800;
    public static final int REQ_EDIT_EVENT = 801;

    public static final int REQ_EVENT_PLACE = 500;

    public static final int REQ_SELECT_PLACE = 501;

    private static final String URL_API = "http://talenting-env.ap-northeast-2.elasticbeanstalk.com/api/";
    private static final String URL_MEMBER = URL_API + "member/";

    public static final String URL_SIGN_UP = URL_MEMBER + "sign-up/";
    public static final String URL_SIGN_IN = URL_MEMBER + "log-in/";
    public static final String URL_EMAIL_CHECK = URL_MEMBER + "email-check/";
    public static final int CAMERA_PERMISSION_REQ = 902;
    public static final int CAMERA_REQ = 800;
    public static final int GALLERY_REQ = 801;
    public static final int LOGIN_REQ = 900;
    public static final int PERMISSION_REQ = 901;

    public static final String EXT_PROFILE = "profile";

    public static final String EXT_LAT = "lat";
    public static final String EXT_LNG = "lng";
    public static final String EXT_IS_DETAIL = "isdetail";

    public static final String EXT_HOSTING_PK = "hosting_pk";
    public static final String EXT_USER_PK = "user_pk";
    public static final String EXT_USER_TRIP_ADDR = "user_trip_address";
    public static final String EXT_EVENT_PK = "event_pk";
    public static final String EXT_CHAT_PK = "chat_pk";
    public static final String EXT_FROM_USER_PK = "from_user_pk";
    public static final String EXT_TO_USER_PK = "to_user_pk";
}
