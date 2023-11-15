package com.catail.lib_commons.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.catail.lib_commons.R;
import com.catail.lib_commons.activity.UseCameraActivity;
import com.catail.lib_commons.adapter.PhotoSelectionAdapter;
import com.donkingliang.imageselector.utils.ImageSelector;

import java.util.Date;

import cn.hzw.doodle.DoodleActivity;
import cn.hzw.doodle.DoodleParams;

public class PhotoSelectUtils {
    /**
     * 拍照
     */
    public static void takePhoto(Activity activity) {
        try {
            Intent intent = new Intent(activity,
                    UseCameraActivity.class);
            activity.startActivityForResult(intent, ConstantValue.takePhotoCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void DealTakePhoto(Bitmap bitmap, String path) {
        try {
            int SystemCurrentVersion = Utils.GetSystemCurrentVersion();
            Date date = new Date(System.currentTimeMillis());
            // 获取当前时间转中/英文
            String time;
            if (SystemCurrentVersion == 0) {
                time = DateFormatUtils.Date2CNStr(date);
            } else {
                time = DateFormatUtils.CNDateStrTOENDate(date);
            }

            Bitmap img = Utils.createBitmap(bitmap, null, time);

            Utils.saveBitmap(path, img);

            if (bitmap != null) {
                bitmap.recycle();
            }
            if (img != null) {
                img.recycle();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 从相册选择图片
     **/
    public static void SelectSingleFromAlbum(Activity activity) {
        //单选
        ImageSelector.builder()
                .useCamera(false) // 设置是否使用拍照
                .setSingle(true)  //设置是否单选
                .setViewImage(true) //是否点击放大图片查看,，默认为true
                .start(activity, ConstantValue.CopyWeChatImageSelector); // 打开相册
    }

    /**
     * 从相册选择图片
     **/
    public static void SelectMultipleFromAlbum(Activity activity, int maxselectCount) {
        //多选
        ImageSelector.builder()
                .useCamera(false) // 设置是否使用拍照
                .setSingle(false)  //设置是否单选
                .setViewImage(true) //是否点击放大图片查看,，默认为true
                .setMaxSelectCount(maxselectCount)
                .start(activity, ConstantValue.CopyWeChatImageSelector); // 打开相册
    }



    public static int[] strs = {R.string.use_camera, R.string.choose_image};
    public static Uri captureFileUri = null;

    /**
     * 列表 拍照 从本地相册选择照片去做检查
     */
    public static void showPhotoSelectionDialog(final AppCompatActivity activity, int maxselectCount) {
        final AlertDialog PhotoSelectionDialog = new AlertDialog.Builder(activity).create();
        View photoSelectionView = activity.getLayoutInflater().inflate(R.layout.photo_selection_listview, null);
        ListView PhotoSelectionListView = photoSelectionView.findViewById(R.id.lv_photo_selection);
        PhotoSelectionAdapter photoSelectionAdapter = new PhotoSelectionAdapter(strs);
        PhotoSelectionListView.setAdapter(photoSelectionAdapter);
        PhotoSelectionDialog.setView(photoSelectionView);
        PhotoSelectionDialog.show();

        Utils.setAlertDialogConner(PhotoSelectionDialog);
        Utils.setAlertDialogSize(activity, PhotoSelectionDialog, 0);

        PhotoSelectionListView.setOnItemClickListener((parent, view, position, id) -> {
            if (position != -1) {
                if (position == 0) {
                    // 选的第一个为拍照.
                    takePhoto(activity);
                    PhotoSelectionDialog.dismiss();
                } else if (position == 1) {
                    PhotoSelectUtils.SelectMultipleFromAlbum(activity, maxselectCount);
                    PhotoSelectionDialog.dismiss();
                }
            }
        });
    }

    public static void ImageEditor(Activity activity, String imageEditorPic, int position) {
        DoodleParams params = new DoodleParams(); // 涂鸦参数
        params.mImagePath = imageEditorPic; // the file path of image
        params.mPosition = position;//索引
        params.mType = 1;//0是拍照相册图片 ,1是附件图片
        DoodleActivity.startActivityForResult(activity, params, ConstantValue.ImageEditorCode);
    }

}
