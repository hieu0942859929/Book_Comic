package com.example.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.myapplication.ui.home.DanhSachSach.Sach;

import java.util.ArrayList;

public class DiaLogSach extends AppCompatDialogFragment {
    Button diaLogTheLoai,dialogTacGia;
    String[] listItemsTheLoai,listItemsTacGia;
    boolean[] checkedItemsTheLoai,checkedItemsTacGia;
    public ArrayList<Integer> arrayList = new ArrayList<>();
    public ArrayList<Integer> arrayList1 = new ArrayList<>();

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_dialog_sach, null);
        listItemsTheLoai = getResources().getStringArray(R.array.item_theloai);
        listItemsTacGia = getResources().getStringArray(R.array.item_tacgia);
        diaLogTheLoai = view.findViewById(R.id.dialogTheLoai);
        dialogTacGia = view.findViewById(R.id.dialogTacGia);
        checkedItemsTheLoai = new boolean[listItemsTheLoai.length];
        checkedItemsTacGia = new boolean[listItemsTacGia.length];
        builder.setView(view);
        setClick();
        return builder.create();
    }


    public void setClick() {
        diaLogTheLoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
                builder1.setTitle("Item avalible");
                builder1.setMultiChoiceItems(listItemsTheLoai, checkedItemsTheLoai, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i, boolean isChecked) {
                        if (isChecked) {
                            arrayList.add(i);
                        } else {
                            arrayList.remove((Integer.valueOf(i)));
                        }
                    }
                });
                builder1.setCancelable(false);
                builder1.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dismiss();
                    }
                });
                builder1.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder1.setNeutralButton("Clear all", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i = 0; i < checkedItemsTheLoai.length; i++) {
                            checkedItemsTheLoai[i] = false;
                            arrayList.clear();
                        }
                    }
                });
                AlertDialog dialog = builder1.create();
                dialog.show();
            }
        });
        dialogTacGia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
                builder1.setTitle("Item avalible");
                builder1.setMultiChoiceItems(listItemsTacGia, checkedItemsTacGia, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i, boolean isChecked) {
                        if (isChecked) {
                            arrayList1.add(i);
                        } else {
                            arrayList1.remove((Integer.valueOf(i)));
                        }
                    }
                });
                builder1.setCancelable(false);
                builder1.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dismiss();
                    }
                });
                builder1.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder1.setNeutralButton("Clear all", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i = 0; i < checkedItemsTacGia.length; i++) {
                            checkedItemsTacGia[i] = false;
                            arrayList1.clear();
                        }
                    }
                });
                AlertDialog dialog = builder1.create();
                dialog.show();
            }
        });
    }
}
