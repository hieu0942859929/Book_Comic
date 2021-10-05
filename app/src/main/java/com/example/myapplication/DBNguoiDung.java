package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DBNguoiDung extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "databaseLogin";
    private static final String TABLE_NAME = "tbLogin";
    private static final String iD = "iD";
    private static final String tenTaiKhoan = "tenTaiKhoan";
    private static final String hoTen = "hoTen";
    private static final String email = "email";
    private static final String sdt = "sdt";
    private static final String matKhau = "matKhau";
    private static final String phanQuyen = "phanQuyen";
    private Context context;

    public DBNguoiDung(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }

    private String sqlQuery = " CREATE TABLE " + TABLE_NAME + " ( "
            + iD + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + tenTaiKhoan + " TEXT, "
            + hoTen + " TEXT, "
            + email + " TEXT, "
            + sdt + " TEXT, "
            + matKhau + " TEXT,"
            + phanQuyen + " INTEGER DEFAULT 0 )";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addUsers(Users users) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tenTaiKhoan, users.getTenTaiKhoan());
        values.put(hoTen, users.getHoTen());
        values.put(email, users.getEmail());
        values.put(sdt, users.getSdt());
        values.put(matKhau, users.getMatKhau());
        db.insert(TABLE_NAME, null, values);
    }

    public void deleteUsers(Users users) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, iD + " = " + iD, null);
    }

    public void getDataUser(String iD) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = " SELECT * FROM " + TABLE_NAME + "WHERE iD = '" + iD + "'";
        Cursor cursor = db.rawQuery(query, null);
    }

    public Integer deleteDataUser(String iD) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "iD=?", new String[]{iD});
    }

    public boolean updateDataUser(String iD, String tenTaiKhoan, String hoTen, String email, String sdt, String matKhau, String phanQuyen) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(tenTaiKhoan, tenTaiKhoan);
        contentValues.put(hoTen, hoTen);
        contentValues.put(email, email);
        contentValues.put(sdt, sdt);
        contentValues.put(matKhau, matKhau);
        db.update(TABLE_NAME, contentValues, "iD=?", new String[]{iD});
        return true;
    }

    public boolean checkUser(String tenTaiKhoan) {
        SQLiteDatabase sqLite = this.getWritableDatabase();
        Cursor cursor = sqLite.rawQuery("SELECT tenTaiKhoan FROM tbLogin WHERE tenTaikhoan = ?", new String[]{tenTaiKhoan});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkUserandPassword(String tenTaiKhoan, String matKhau) {
        SQLiteDatabase sqLite = this.getWritableDatabase();
        Cursor cursor = sqLite.rawQuery("SELECT * FROM tbLogin WHERE tenTaikhoan = ? and matKhau = ? ", new String[]{tenTaiKhoan, matKhau});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkAdmin(String tenTaiKhoan) {
        SQLiteDatabase sqLite = this.getWritableDatabase();
        Cursor cursor = sqLite.rawQuery(" SELECT phanQuyen FROM tbLogin WHERE tenTaiKhoan = ?", new String[]{tenTaiKhoan});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
