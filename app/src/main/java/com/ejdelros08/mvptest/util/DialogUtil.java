/**
 * Created by EJ Del Rosario
 * Copyright (c) 2015
 * Personal Intellectual Property
 * All Rights Reserved
 */

package com.ejdelros08.mvptest.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

public class DialogUtil {

	/**
	 * creates and shows a non-cancellable alert dialog
	 * @param context
	 * @param message for the alert dialog
	 */
	public static void showAlertDialog(Context context, String message){
		showAlertDialog(context, null, message);
	}

	/**
	 * creates and shows a non-cancellable alert dialog
	 * @param context
	 * @param title for the alert dialog
	 * @param message for the alert dialog
	 */
	public static void showAlertDialog(Context context, String title, String message){
		AlertDialog.Builder msgbox = new AlertDialog.Builder(context);
		if(title != null) {
			msgbox.setTitle(title);
		}
		msgbox.setMessage(message);
		msgbox.setPositiveButton("Ok", null);
		msgbox.setCancelable(false);
		msgbox.show();
	}

	/**
	 * creates and shows a non-cancellable alert dialog
	 * @param context
	 * @param message for the alert dialog
	 * @param listener when the dialog is dismissed
	 */
	public static void showAlertDialog(Context context, String message, DialogInterface.OnDismissListener listener){
		showAlertDialog(context, null, message, listener);
	}

	/**
	 * creates and shows a non-cancellable alert dialog
	 * @param context
	 * @param title for the alert dialog; pass null to hide title
	 * @param message for the alert dialog
	 * @param listener when the dialog is dismissed
	 */
	public static void showAlertDialog(Context context, String title, String message, DialogInterface.OnDismissListener listener){
		AlertDialog.Builder msgbox = new AlertDialog.Builder(context);
		if(title != null) {
			msgbox.setTitle(title);
		}
		msgbox.setMessage(message);
		msgbox.setPositiveButton("Ok", null);
		msgbox.setCancelable(false);
		
		AlertDialog dialog = msgbox.create();
		dialog.setOnDismissListener(listener);
		dialog.show();
	}

	/**
	 * creates and shows a non-cancellable confirmation dialog
	 * @param context
	 * @param message for the alert dialog
	 * @param buttonPositive positive button text
	 * @param buttonNegative negative button text
	 * @param listener for the buttons
	 */
	public static void showConfirmationDialog(Context context, String message, String buttonPositive, String buttonNegative, DialogInterface.OnClickListener listener){
		showConfirmationDialog(context, null, message, buttonPositive, buttonNegative, listener);
	}

	/**
	 * creates and shows a non-cancellable confirmation dialog
	 * @param context
	 * @param title for the alert dialog
	 * @param message for the alert dialog
	 * @param buttonPositive positive button text
	 * @param buttonNegative negative button text
	 * @param listener for the buttons
	 */
	public static void showConfirmationDialog(Context context, String title, String message, String buttonPositive, String buttonNegative, DialogInterface.OnClickListener listener){
		AlertDialog.Builder msgbox = new AlertDialog.Builder(context);
		if(title != null) {
			msgbox.setTitle(title);
		}
		msgbox.setMessage(message);
		msgbox.setPositiveButton(buttonPositive, listener);
		msgbox.setNegativeButton(buttonNegative, listener);
		msgbox.setCancelable(false);
		msgbox.show();
	}

	public static ProgressDialog showIndeterminateProgressDialog(@NonNull Context context, String title, @NonNull String message, boolean isCancellable){
		ProgressDialog dialog = new ProgressDialog(context);
		if(!title.isEmpty()) {
			dialog.setTitle(title);
		}

		dialog.setMessage(message);
		dialog.setCancelable(isCancellable);
		dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		dialog.setCanceledOnTouchOutside(isCancellable);
		dialog.show();

		return dialog;
	}

	/**
	 * shows a toast
	 * @param context
	 * @param message
	 * @param length
	 */
	public static void showToast(Context context, String message, int length){
		Toast.makeText(context, message, length).show();
	}

}
