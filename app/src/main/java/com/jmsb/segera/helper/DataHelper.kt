package com.jmsb.segera.helper

import android.content.Context
import android.database.DatabaseErrorHandler
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        internal val DATABASE_NAME = "segera.db"
        private val DATABASE_VERSION = 1
        val TABLE_MATKUL = "matkul"
        val TABLE_PERTEMUAN = "pertemuan"

        //UNIVERSAL
        val COLUMN_ID = "id"
        //MATKUL
        val COLUMN_MATKUL = "matkul"
        val COLUMN_SKS = "sks"
        val COLUMN_JATAH = "jatah"
        val COLUMN_BOLOS = "bolos"
        val COLUMN_DOSEN = "dosen"
        //PERTEMUAN
        val COLUMN_ID_MATKUL = "id_matkul"
        val COLUMN_HARI = "hari"
        val COLUMN_JAM_MULAI = "jam_mulai"
        val COLUMN_JAM_SELESAI = "jam_selesai"
        val COLUMN_RUANG = "ruang"
    }

    override fun onCreate(db: SQLiteDatabase) {
        var query = ("CREATE TABLE " + TABLE_MATKUL + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY autoincrement, "
                + COLUMN_MATKUL + " TEXT NOT NULL, "
                + COLUMN_SKS + " INTEGER NOT NULL, "
                + COLUMN_JATAH + " INTEGER NOT NULL, "
                + COLUMN_BOLOS + " INTEGER NOT NULL, "
                + COLUMN_DOSEN + " TEXT NOT NULL "
                + ")")
        db.execSQL(query)

        query = ("CREATE TABLE " + TABLE_PERTEMUAN + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY autoincrement, "
                + COLUMN_ID_MATKUL + " INTEGER NOT NULL, "
                + COLUMN_HARI + " INTEGER NOT NULL, "
                + COLUMN_JAM_MULAI + " TEXT NOT NULL, "
                + COLUMN_JAM_SELESAI + " TEXT NOT NULL, "
                + COLUMN_RUANG + " TEXT NOT NULL "
                + ")")
        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }

    fun insert_matkul(
        db: SQLiteDatabase,
        matkul: String,
        sks: Int,
        jatah: Int,
        bolos: Int,
        dosen: String
    ) {
        val query =
            ("INSERT INTO " + TABLE_MATKUL + "(" + COLUMN_MATKUL + "," + COLUMN_SKS + "," + COLUMN_JATAH + "," + COLUMN_BOLOS + "," + COLUMN_DOSEN + ") VALUES("
                    + "'" + matkul + "',"
                    + "'" + sks + "',"
                    + jatah + ","
                    + bolos + ","
                    + "'" + dosen + "'"
                    + ")")
        db.execSQL(query)
    }

    fun insert_pertemuan(
        db: SQLiteDatabase,
        id_matkul: Int,
        hari: Int,
        jam_mulai: String,
        jam_selesai: String,
        ruangan: String
    ) {
        val query =
            ("INSERT INTO " + TABLE_PERTEMUAN + "(" + COLUMN_ID_MATKUL + "," + COLUMN_HARI + "," + COLUMN_JAM_MULAI + "," + COLUMN_JAM_SELESAI + "," + COLUMN_RUANG + ") VALUES("
                    + id_matkul + ","
                    + hari + ","
                    + "'" + jam_mulai + "',"
                    + "'" + jam_selesai + "',"
                    + "'" + ruangan + "'"
                    + ")")
        db.execSQL(query)
    }

    fun delete(table: String, id: Int) {
        val db = this.writableDatabase
        val query = ("DELETE FROM " + table
                + " WHERE id=" + id)
        db.execSQL(query)
    }
}