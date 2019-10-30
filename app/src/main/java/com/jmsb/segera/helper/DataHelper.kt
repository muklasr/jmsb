package com.jmsb.segera.helper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataHelper(context: Context?) : SQLiteOpenHelper(context, "segera.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        var query = "CREATE TABLE jadwal(" +
                "id integer primary key," +
                "nama text," +
                "sks integer," +
                "hari integer," +
                "jam text," +
                "jatah_bolos integer," +
                "bolos integer," +
                "dosen text," +
                "ruang text" +
                ");"
        db?.execSQL(query)

        query = "INSERT INTO jadwal VALUES(1, 'Analisis Desain Perangkat Lunak', 2, 1, '07.15 - 09.00', 3, 1, 'Rifqi', 'HY U202');"
        db?.execSQL(query)
        query = "INSERT INTO jadwal VALUES(2, 'Perancangan Antarmuka Pengguna', 2, 1, '09.00 - 10.40', 6, 1, 'Fani', 'Lab RPL 2');"
        db?.execSQL(query)
        query = "INSERT INTO jadwal VALUES(3, 'Praktikum Administrasi Sistem', 2, 1, '12.00 - 14.00', 3, 1, 'Dayat', 'Lab RPL 6');"
        db?.execSQL(query)
        query = "INSERT INTO jadwal VALUES(4, 'Jaringan Komputer', 2, 1, '14.00 - 16.00', 6, 1, 'Yoga', 'Lab RPL 3');"
        db?.execSQL(query)
        query = "INSERT INTO jadwal VALUES(5, 'Pemrograman Web', 2, 2, '07.15 - 10.40', 6, 1, 'Abid', 'Lab RPL 2');"
        db?.execSQL(query)
        query = "INSERT INTO jadwal VALUES(6, 'Proyek Aplikasi', 2, 2, '12.00 - 15.30', 6, 1, 'Rifqi', 'Lab RPL 6');"
        db?.execSQL(query)
        query = "INSERT INTO jadwal VALUES(7, 'Pemrograman Aplikasi Perangkat Bergerak', 2, 3, '07.15 - 09.00', 6, 1, 'Ady', 'Lab Mulmed');"
        db?.execSQL(query)
        query = "INSERT INTO jadwal VALUES(8, 'Bahasa Indonesia', 2, 3, '09.00 - 10.40', 3, 1, 'Anny', 'HY U202');"
        db?.execSQL(query)
        query = "INSERT INTO jadwal VALUES(9, 'Praktikum Analisis Desain Perangkat Lunak', 2, 3, '12.00 - 14.00', 6, 1, 'Firma', 'Lab RPL 2');"
        db?.execSQL(query)
        query = "INSERT INTO jadwal VALUES(10, 'Administrasi Sistem', 2, 3, '14.00 - 15.30', 3, 1, 'Imam', 'HY U202');"
        db?.execSQL(query)
        query = "INSERT INTO jadwal VALUES(11, 'Pemrograman Aplikasi Perangkat Bergerak', 2, 4, '07.15 - 09.00', 6, 1, 'Ady', 'Lab Mulmed');"
        db?.execSQL(query)
        query = "INSERT INTO jadwal VALUES(12, 'Praktikum Analisis Desain Perangkat Lunak', 2, 4, '09.00 - 10.40', 6, 1, 'Firma', 'Lab 5');"
        db?.execSQL(query)
        query = "INSERT INTO jadwal VALUES(13, 'Perancangan Antarmuka Pengguna', 2, 4, '14.00 - 15.30', 6, 1, 'Fani', 'Lab RPL 2');"
        db?.execSQL(query)
        query = "INSERT INTO jadwal VALUES(14, 'Desain Elementer', 2, 5, '07.15 - 09.00', 3, 1, 'Yos', 'HY U202');"
        db?.execSQL(query)
        query = "INSERT INTO jadwal VALUES(15, 'Praktikum Desain Elementer', 2, 5, '09.00 - 10.40', 3, 1, 'Dede', 'Lab Mulmed');"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}