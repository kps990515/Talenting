package a.talenting.com.talenting.common;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.content.FileProvider;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import a.talenting.com.talenting.BuildConfig;
import a.talenting.com.talenting.R;
import a.talenting.com.talenting.custom.domain.detailItem.MyTripItem;
import a.talenting.com.talenting.custom.domain.detailItem.TextContentItem;
import a.talenting.com.talenting.custom.domain.detailItem.TitleAndValueItem;
import a.talenting.com.talenting.util.FormatUtil;
import a.talenting.com.talenting.util.PermissionUtil;

import static a.talenting.com.talenting.common.Constants.CAMERA_PERMISSION_REQ;
import static a.talenting.com.talenting.common.Constants.CAMERA_REQ;
import static a.talenting.com.talenting.common.Constants.GALLERY_REQ;
import static android.app.Activity.RESULT_OK;

/**
 * Created by daeho on 2017. 12. 11..
 */

public class DialogManager {
    public static void showMyTripDialog(Context context, MyTripItem item, IDialogStringEvent event){
        showTextDialog(context, item, event);
        showStartDatePickerDialog(context, item, event);
        showEndDatePickerDialog(context, item, event);
        showNumTextDialog(context, item, event);
        showMultiLineTextDialog(context, item.descriptionTitle, item, event);
    }

    public static void showDatePickerDialog(Context context, TitleAndValueItem item, IDialogStringEvent event) {
        showDatePickerDialog(context, item.title, item.value, event);
    }
    public static void showStartDatePickerDialog(Context context, MyTripItem item, IDialogStringEvent event) {
        showDatePickerDialog(context, "Arrival Date", item.startDate, event);
    }
    public static void showEndDatePickerDialog(Context context, MyTripItem item, IDialogStringEvent event) {
        showDatePickerDialog(context, "Departure Date", item.endDate, event);
    }
    public static void showDatePickerDialog(Context context, String title, String value, IDialogStringEvent event){
        View v = LayoutInflater.from(context).inflate(R.layout.dialog_datepicker, null, false);
        DatePicker datePicker = v.findViewById(R.id.datePicker);
        if(value==null || value.equals("")) {
            datePicker.init(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(), new DatePicker.OnDateChangedListener() {
                @Override
                public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//
                }
            });
        }else {
            String[] array = value.split("-");
            datePicker.init(Integer.parseInt(array[0]), Integer.parseInt(array[1]), Integer.parseInt(array[2]), new DatePicker.OnDateChangedListener() {
                @Override
                public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                }
            });
        }
            new MaterialDialog.Builder(context)
                    .title(title)
                    .customView(v, true)
                    .positiveText("Save")
                    .onAny((@NonNull MaterialDialog dialog, @NonNull DialogAction which) -> {
                        event.callback(datePicker.getYear() + "-" + (datePicker.getMonth() + 1) + "-" + datePicker.getDayOfMonth());
                    })
                    .show();
        }

    public static void showDateTimePickerDialog(Context context, TitleAndValueItem item, IDialogStringEvent event) {
        showDateTimePickerDialog(context, item.title, item.value, event);
    }
    public static void showDateTimePickerDialog(Context context, String title, String value, IDialogStringEvent event){
        View v = LayoutInflater.from(context).inflate(R.layout.dialog_datetimepicker, null, false);
        DatePicker datePicker = v.findViewById(R.id.datePicker);
        TimePicker timePicker = v.findViewById(R.id.timePicker);

        int year, month, day, hour, min, sec;

        if(value == null || "".equals(value)) {
            Calendar calendar = Calendar.getInstance();
            year = calendar.get(Calendar.YEAR);
            month = calendar.get(Calendar.MONTH);
            day = calendar.get(Calendar.DAY_OF_MONTH);
            hour = calendar.get(Calendar.HOUR);
            min = calendar.get(Calendar.MINUTE);
            sec = calendar.get(Calendar.SECOND);
        }
        else{
            Date d = FormatUtil.utcStringToDate(value);
            year = Integer.parseInt(DateFormat.format("yyyy", d).toString());
            month = Integer.parseInt(DateFormat.format("MM", d).toString());
            day = Integer.parseInt(DateFormat.format("dd", d).toString());
            hour = Integer.parseInt(DateFormat.format("hh", d).toString());
            min = Integer.parseInt(DateFormat.format("mm", d).toString());
            sec = Integer.parseInt(DateFormat.format("ss", d).toString());
        }

        datePicker.init(year, month, day, (DatePicker view, int y, int m, int d) -> {});
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            timePicker.setHour(hour);
            timePicker.setMinute(min);
        }

        new MaterialDialog.Builder(context)
                .title(title)
                .customView(v, true)
                .positiveText("Save")
                .onAny((@NonNull MaterialDialog dialog, @NonNull DialogAction which) -> {
                    String s = "";
                    s = datePicker.getYear()
                            + "-" + (datePicker.getMonth() + 1)
                            + "-" + datePicker.getDayOfMonth();

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        s += " " + timePicker.getHour() + ":" + timePicker.getMinute() + ":00";
                    }

                    event.callback(s);
                })
                .show();
    }

    public static void showTextDialog(Context context, TitleAndValueItem item, IDialogStringEvent event){
        showTextDialog(context, item.title, item.value, event);
    }
    public static void showTextDialog(Context context, MyTripItem item, IDialogStringEvent event){
        showTextDialog(context, item.desTitle, item.des, event);
    }
    public static void showTextDialog(Context context, String title, String value, IDialogStringEvent event){
        View v = LayoutInflater.from(context).inflate(R.layout.dialog_input_text, null, false);
        EditText editText = v.findViewById(R.id.editText);
        editText.setHint(R.string.hosting_input);
        editText.setText(value);

        new MaterialDialog.Builder(context)
                .title(title)
                .customView(v, true)
                .positiveText("Save")
                .onAny((@NonNull MaterialDialog dialog, @NonNull DialogAction which) -> {
                    event.callback(editText.getText().toString());
                })
                .show();
    }

    public static void showMultiLineTextDialog(Context context, String title, TextContentItem item, IDialogStringEvent event){
        showMultiLineTextDialog(context, title, item.content, event);
    }
    public static void showMultiLineTextDialog(Context context, String title, MyTripItem item, IDialogStringEvent event){
        showMultiLineTextDialog(context, title, item.description, event);
    }
    public static void showMultiLineTextDialog(Context context, String title, String value, IDialogStringEvent event){
        View v = LayoutInflater.from(context).inflate(R.layout.dialog_input_multi_line_text, null, false);
        EditText editText = v.findViewById(R.id.editText);
        editText.setHint(R.string.hosting_input);
        editText.setText(value);

        new MaterialDialog.Builder(context)
                .title(title)
                .customView(v, true)
                .positiveText("Save")
                .onAny((@NonNull MaterialDialog dialog, @NonNull DialogAction which) -> {
                    event.callback(editText.getText().toString());
                })
                .show();
    }

    public static void showTypeListDialog(Context context, String title, Map<String, String> data, IDialogTypeEvent event){
        int[] ids = new int[data.size()];
        List<String> items = new ArrayList<>();
        int index = 0;
        for(String key : data.keySet()){
            ids[index] = index;
            items.add(data.get(key));

            index++;
        }

        new MaterialDialog.Builder(context)
                .title(title)
                .items(items)
                .itemsIds(ids)
                .itemsCallback(new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                        int i = 0;
                        for(String key : data.keySet()){
                            if(i == view.getId()){
                                event.callback(key, text.toString());
                                return;
                            }
                            i++;
                        }
                    }
                })
                .show();
    }

    public static void showListDialog(Context context, String title, List<String> data, IDialogStringEvent event){
        new MaterialDialog.Builder(context)
                .title(title)
                .items(data)
                .itemsCallbackSingleChoice(-1, new MaterialDialog.ListCallbackSingleChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                        event.callback(data.get(which));
                        return true;
                    }
                })
                .show();
    }

    public static void showNumTextDialog(Context context, TitleAndValueItem item, IDialogStringEvent event){
        showNumTextDialog(context, item.title, item.value, event);
    }
    public static void showNumTextDialog(Context context, MyTripItem item, IDialogStringEvent event){
        showNumTextDialog(context, item.numTitle, item.num, event);
    }
    public static void showNumTextDialog(Context context, String title, String value, IDialogStringEvent event){
        View v = LayoutInflater.from(context).inflate(R.layout.dialog_input_num_text, null, false);
        EditText editText = v.findViewById(R.id.editText);
        editText.setText(value);

        new MaterialDialog.Builder(context)
                .title(title)
                .customView(v, true)
                .positiveText("Save")
                .onAny((@NonNull MaterialDialog dialog, @NonNull DialogAction which) -> {
                    event.callback(editText.getText().toString());
                })
                .show();
    }

    public static void showCameraDialog(Activity activity, ActivityResultManager resultManager, IDialogStringEvent event){
        View v = LayoutInflater.from(activity).inflate(R.layout.dialog_camera, null, false);

        MaterialDialog materialDialog = new MaterialDialog.Builder(activity).customView(v, true).build();

        //region camera event
        v.findViewById(R.id.btnCamera).setOnClickListener(view -> {
            String[] Permission = new String[] { Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE };

            PermissionUtil pUtil = new PermissionUtil(CAMERA_PERMISSION_REQ, Permission);
            pUtil.check(activity, new PermissionUtil.IPermissionGrant() {
                @Override
                public void run() {
                    ActivityResultItem resultItem = new ActivityResultItem(CAMERA_REQ, (int resultCode, Intent data) -> {
                        Uri uri = null;
                        if(resultCode == RESULT_OK){
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) uri = fileUri;
                            else uri = data.getData();
                        }

                        if(uri != null) event.callback(uri.toString());

                        materialDialog.cancel();
                    });
                    resultManager.addItem(resultItem);

                    camera(activity);
                }

                @Override
                public void fail() {

                }
            });
        });
        //endregion
        //region gallery event
        v.findViewById(R.id.btnGallery).setOnClickListener(view -> {
            String[] Permission = new String[] { Manifest.permission.READ_EXTERNAL_STORAGE };

            PermissionUtil pUtil = new PermissionUtil(CAMERA_PERMISSION_REQ, Permission);
            pUtil.check(activity, new PermissionUtil.IPermissionGrant() {
                @Override
                public void run() {
                    ActivityResultItem resultItem = new ActivityResultItem(GALLERY_REQ, (int resultCode, Intent data) -> {
                        Uri uri = null;
                        if(resultCode == RESULT_OK) uri = data.getData();

                        if(uri != null) event.callback(uri.toString());

                        materialDialog.cancel();
                    });
                    resultManager.addItem(resultItem);

                    gallery(activity);
                }

                @Override
                public void fail() {

                }
            });
        });
        //endregion

        materialDialog.show();
    }
    //region camera / gallery functions
    private static Uri fileUri = null;
    private static void camera(Activity activity){
        // 1. Intent 만들기
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // 2. 호환성 처리 버전체크 - 롤리팝 이상
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            // 3. 실제 파일이 저장되는 파일 객체 < 빈 파일을 생성해 둔다
            File photoFile = null;

            // 3.1 실제 파일이 저장되는 곳에 권한이 부여되어 있어야 한다
            //     롤리팝 부터는 File Provider를 선언해 줘야만한다 > Manifest에
            try {
                photoFile = createFile(activity);

                // 갤러리에서 나오지 않을때
                refreshMedia(activity, photoFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            fileUri = FileProvider.getUriForFile(activity, BuildConfig.APPLICATION_ID + ".provider", photoFile);

            intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
            activity.startActivityForResult(intent, CAMERA_REQ);
        }
        else activity.startActivityForResult(intent, CAMERA_REQ);
    }
    private static void gallery(Activity activity){
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        activity.startActivityForResult(intent, GALLERY_REQ);
    }
    private static void refreshMedia(Activity activity, File file){
        MediaScannerConnection.scanFile(activity, new String[]{file.getAbsolutePath()}, null, new MediaScannerConnection.OnScanCompletedListener() {
            @Override
            public void onScanCompleted(String path, Uri uri) {

            }
        });
    }
    private static File createFile(Context context) throws IOException {
        // 임시파일명 생성
        String tempFileName = "Temp_" + System.currentTimeMillis();

        // 임시파일 저장용 디렉토리 생성
        File tempDir = new File(Environment.getExternalStorageDirectory() + File.separator + "Talenting" + File.separator);

        // 생성체크
        if(!tempDir.exists()) tempDir.mkdirs();

        //실제 임시파일을 생성
        File tempFile = File.createTempFile(tempFileName, ".jpg", tempDir);

        return tempFile;
    }
    //endregion
}
