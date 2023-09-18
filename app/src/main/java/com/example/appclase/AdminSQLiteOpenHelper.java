package com.example.appclase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BaseDeDatos) {
        BaseDeDatos.execSQL("CREATE TABLE IF NOT EXISTS grupos (\n" +
                "    grupo TEXT NOT NULL PRIMARY KEY\n" +
                ");");

        BaseDeDatos.execSQL("CREATE TABLE IF NOT EXISTS alumnos (\n" +
                "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    numero INTEGER,\n" +
                "    grupo VARCHAR(10),\n" +
                "    nombre VARCHAR(80),\n" +
                "    notaparcial1 REAL,\n" +
                "    notaparcial2 REAL,\n" +
                "    notaparcial3 REAL,\n" +
                "    notaparcial4 REAL,\n" +
                "    notaparcial5 REAL,\n" +
                "    notaparcial6 REAL,\n" +
                "    notarecuperacion1parcial1 REAL,\n" +
                "    notarecuperacion1parcial2 REAL,\n" +
                "    notarecuperacion1parcial3 REAL,\n" +
                "    notarecuperacion1parcial4 REAL,\n" +
                "    notarecuperacion1parcial5 REAL,\n" +
                "    notarecuperacion1parcial6 REAL,\n" +
                "    notarecuperacion2parcial1 REAL,\n" +
                "    notarecuperacion2parcial2 REAL,\n" +
                "    notarecuperacion2parcial3 REAL,\n" +
                "    notarecuperacion2parcial4 REAL,\n" +
                "    notarecuperacion2parcial5 REAL,\n" +
                "    notarecuperacion2parcial6 REAL,\n" +
                "    notaglobal REAL\n" +
                ");");

        BaseDeDatos.execSQL("CREATE TABLE IF NOT EXISTS examen_practico (\n" +
                "    id_alumno INTEGER PRIMARY KEY,\n" +
                "    numero INTEGER,\n" +
                "    grupo VARCHAR(10),\n" +
                "    nombre VARCHAR(80),\n" +
                "    pregunta1 TEXT CHECK(pregunta1  IN ('S', 'N', NULL)),\n" +
                "    pregunta2 TEXT CHECK(pregunta2  IN ('S', 'N', NULL)),\n" +
                "    pregunta3 TEXT CHECK(pregunta3  IN ('S', 'N', NULL)),\n" +
                "    pregunta4 TEXT CHECK(pregunta4  IN ('S', 'N', NULL)),\n" +
                "    pregunta5 TEXT CHECK(pregunta5  IN ('S', 'N', NULL)),\n" +
                "    pregunta6 TEXT CHECK(pregunta6  IN ('S', 'N', NULL)),\n" +
                "    pregunta7 TEXT CHECK(pregunta7  IN ('S', 'N', NULL)),\n" +
                "    pregunta8 TEXT CHECK(pregunta8  IN ('S', 'N', NULL)),\n" +
                "    pregunta9 TEXT CHECK(pregunta9  IN ('S', 'N', NULL)),\n" +
                "    pregunta10 TEXT CHECK(pregunta10  IN ('S', 'N', NULL)),\n" +
                "    pregunta11 TEXT CHECK(pregunta11  IN ('S', 'N', NULL)),\n" +
                "    pregunta12 TEXT CHECK(pregunta12  IN ('S', 'N', NULL)),\n" +
                "    pregunta13 TEXT CHECK(pregunta13  IN ('S', 'N', NULL)),\n" +
                "    pregunta14 TEXT CHECK(pregunta14  IN ('S', 'N', NULL)),\n" +
                "    pregunta15 TEXT CHECK(pregunta15  IN ('S', 'N', NULL)),\n" +
                "    pregunta16 TEXT CHECK(pregunta16  IN ('S', 'N', NULL)),\n" +
                "    pregunta17 TEXT CHECK(pregunta17  IN ('S', 'N', NULL)),\n" +
                "    pregunta18 TEXT CHECK(pregunta18  IN ('S', 'N', NULL)),\n" +
                "    pregunta19 TEXT CHECK(pregunta19  IN ('S', 'N', NULL)),\n" +
                "    pregunta20 TEXT CHECK(pregunta20  IN ('S', 'N', NULL)),\n" +
                "    pregunta21 TEXT CHECK(pregunta21  IN ('S', 'N', NULL)),\n" +
                "    pregunta22 TEXT CHECK(pregunta22  IN ('S', 'N', NULL)),\n" +
                "    pregunta23 TEXT CHECK(pregunta23  IN ('S', 'N', NULL)),\n" +
                "    pregunta24 TEXT CHECK(pregunta24  IN ('S', 'N', NULL)),\n" +
                "    pregunta25 TEXT CHECK(pregunta25  IN ('S', 'N', NULL)),\n" +
                "    pregunta26 TEXT CHECK(pregunta26  IN ('S', 'N', NULL)),\n" +
                "    pregunta27 TEXT CHECK(pregunta27  IN ('S', 'N', NULL)),\n" +
                "    pregunta28 TEXT CHECK(pregunta28  IN ('S', 'N', NULL)),\n" +
                "    pregunta29 TEXT CHECK(pregunta29  IN ('S', 'N', NULL)),\n" +
                "    pregunta30 TEXT CHECK(pregunta30  IN ('S', 'N', NULL)),\n" +
                "    pregunta31 TEXT CHECK(pregunta31  IN ('S', 'N', NULL)),\n" +
                "    pregunta32 TEXT CHECK(pregunta32  IN ('S', 'N', NULL)),\n" +
                "    pregunta33 TEXT CHECK(pregunta33  IN ('S', 'N', NULL)),\n" +
                "    pregunta34 TEXT CHECK(pregunta34  IN ('S', 'N', NULL)),\n" +
                "    pregunta35 TEXT CHECK(pregunta35  IN ('S', 'N', NULL)),\n" +
                "    pregunta36 TEXT CHECK(pregunta36  IN ('S', 'N', NULL)),\n" +
                "    pregunta37 TEXT CHECK(pregunta37  IN ('S', 'N', NULL)),\n" +
                "    pregunta38 TEXT CHECK(pregunta38  IN ('S', 'N', NULL)),\n" +
                "    pregunta39 TEXT CHECK(pregunta39  IN ('S', 'N', NULL)),\n" +
                "    pregunta40 TEXT CHECK(pregunta40  IN ('S', 'N', NULL)),\n" +
                "    pregunta41 TEXT CHECK(pregunta41  IN ('S', 'N', NULL)),\n" +
                "    pregunta42 TEXT CHECK(pregunta42  IN ('S', 'N', NULL)),\n" +
                "    pregunta43 TEXT CHECK(pregunta43  IN ('S', 'N', NULL)),\n" +
                "    pregunta44 TEXT CHECK(pregunta44  IN ('S', 'N', NULL)),\n" +
                "    pregunta45 TEXT CHECK(pregunta45  IN ('S', 'N', NULL)),\n" +
                "    pregunta46 TEXT CHECK(pregunta46  IN ('S', 'N', NULL)),\n" +
                "    pregunta47 TEXT CHECK(pregunta47  IN ('S', 'N', NULL)),\n" +
                "    pregunta48 TEXT CHECK(pregunta48  IN ('S', 'N', NULL)),\n" +
                "    pregunta49 TEXT CHECK(pregunta49  IN ('S', 'N', NULL)),\n" +
                "    pregunta50 TEXT CHECK(pregunta50  IN ('S', 'N', NULL)),\n" +
                "    total_fallos INTEGER,\n" +
                "    FOREIGN KEY (nombre) REFERENCES alumnos (nombre) ON DELETE CASCADE ON UPDATE CASCADE,\n" +
                "    FOREIGN KEY (id_alumno) REFERENCES alumnos (id) ON DELETE CASCADE ON UPDATE CASCADE,\n" +
                "    FOREIGN KEY (grupo) REFERENCES grupos (grupo) ON DELETE CASCADE ON UPDATE CASCADE\n" +
                ");");

        BaseDeDatos.execSQL("CREATE INDEX IF NOT EXISTS idx_nombre ON alumnos(nombre);\n");
        BaseDeDatos.execSQL("CREATE TABLE IF NOT EXISTS practicas (\n" +
                "    id_alumno INTEGER PRIMARY KEY,\n" +
                "    numero INTEGER,\n" +
                "    grupo TEXT,\n" +
                "    nombre TEXT,\n" +
                "    notapractica1 REAL,\n" +
                "    notapractica2 REAL,\n" +
                "    notapractica3 REAL,\n" +
                "    notapractica4 REAL,\n" +
                "    notapractica5 REAL,\n" +
                "    notapractica6 REAL,\n" +
                "    notapractica7 REAL,\n" +
                "    notapractica8 REAL,\n" +
                "    notapractica9 REAL,\n" +
                "    notapractica10 REAL,\n" +
                "    notapractica11 REAL,\n" +
                "    notapractica12 REAL,\n" +
                "    notapractica13 REAL,\n" +
                "    notapractica14 REAL,\n" +
                "    FOREIGN KEY (id_alumno) REFERENCES alumnos (id) ON DELETE CASCADE ON UPDATE CASCADE,\n" +
                "    FOREIGN KEY (grupo) REFERENCES grupos (grupo) ON DELETE CASCADE ON UPDATE CASCADE,\n" +
                "    FOREIGN KEY (nombre) REFERENCES alumnos (nombre) ON DELETE CASCADE ON UPDATE CASCADE\n" +
                ");\n");
        BaseDeDatos.execSQL("CREATE TABLE IF NOT EXISTS negativos (\n" +
                "    id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
                "    numero INTEGER,\n" +
                "    grupo TEXT,\n" +
                "    idalumno INTEGER,\n" +
                "    nombrealumno TEXT,\n" +
                "    causa TEXT CHECK (causa IN (\n" +
                "        'para/lava/cambia antes de tiempo',\n" +
                "        'no recoge',\n" +
                "        'juega/molesta',\n" +
                "        'no trabaja',\n" +
                "        'otros'\n" +
                "    )),\n" +
                "    comentario TEXT,\n" +
                "    fechayhora TEXT,\n" +
                "    FOREIGN KEY (grupo) REFERENCES grupos (grupo) ON DELETE CASCADE ON UPDATE CASCADE,\n" +
                "    FOREIGN KEY (nombrealumno) REFERENCES alumnos (nombre) ON DELETE CASCADE ON UPDATE CASCADE,\n" +
                "    FOREIGN KEY (idalumno) REFERENCES alumnos (id) ON DELETE CASCADE ON UPDATE CASCADE\n" +
                ");\n");
        BaseDeDatos.execSQL("CREATE TABLE positivos (\n" +
                "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    numero INTEGER,\n" +
                "    grupo TEXT,\n" +
                "    idalumno INTEGER,\n" +
                "    nombrealumno TEXT,\n" +
                "    comentario TEXT,\n" +
                "    fechayhora TEXT,\n" +
                "    FOREIGN KEY (grupo) REFERENCES grupos (grupo) ON DELETE CASCADE ON UPDATE CASCADE,\n" +
                "    FOREIGN KEY (nombrealumno) REFERENCES alumnos (nombre) ON DELETE CASCADE ON UPDATE CASCADE,\n" +
                "    FOREIGN KEY (idalumno) REFERENCES alumnos (id) ON DELETE CASCADE ON UPDATE CASCADE\n" +
                ");\n");
        BaseDeDatos.execSQL("CREATE TABLE comentarios (\n" +
                "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    numero INTEGER,\n" +
                "    grupo TEXT,\n" +
                "    idalumno INTEGER,\n" +
                "    nombrealumno TEXT,\n" +
                "    comentario TEXT,\n" +
                "    fechayhora TEXT,\n" +
                "    FOREIGN KEY (grupo) REFERENCES grupos (grupo) ON DELETE CASCADE ON UPDATE CASCADE,\n" +
                "    FOREIGN KEY (nombrealumno) REFERENCES alumnos (nombre) ON DELETE CASCADE ON UPDATE CASCADE,\n" +
                "    FOREIGN KEY (idalumno) REFERENCES alumnos (id) ON DELETE CASCADE ON UPDATE CASCADE\n" +
                ");\n");
        BaseDeDatos.execSQL("CREATE TABLE faltas (\n" +
                "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    numero INTEGER,\n" +
                "    grupo TEXT,\n" +
                "    idalumno INTEGER,\n" +
                "    nombrealumno TEXT,\n" +
                "    fecha TEXT,\n" +
                "    hora TEXT,\n" +
                "    FOREIGN KEY (grupo) REFERENCES grupos (grupo) ON DELETE CASCADE ON UPDATE CASCADE,\n" +
                "    FOREIGN KEY (nombrealumno) REFERENCES alumnos (nombre) ON DELETE CASCADE ON UPDATE CASCADE,\n" +
                "    FOREIGN KEY (idalumno) REFERENCES alumnos (id) ON DELETE CASCADE ON UPDATE CASCADE\n" +
                ");\n");
        BaseDeDatos.execSQL("CREATE TRIGGER insertar_alumnos_en_examen_practico \n" +
                "\tAFTER INSERT ON alumnos\n" +
                "BEGIN\n" +
                "\tINSERT INTO examen_practico(id_alumno, numero, grupo, nombre) \n" +
                "    VALUES(NEW.id, NEW.numero, NEW.grupo, NEW.nombre);\n" +
                "END;");
        BaseDeDatos.execSQL("CREATE TRIGGER eliminar_alumnos_de_examen_practico \n" +
                "\tAFTER DELETE ON alumnos\n" +
                "BEGIN\n" +
                "\tDELETE FROM examen_practico WHERE id_alumno = OLD.id; \n" +
                "END;");
        BaseDeDatos.execSQL("CREATE TRIGGER actualizar_alumnos_de_examen_practico \n" +
                "\tAFTER UPDATE ON alumnos\n" +
                "BEGIN\n" +
                "\tUPDATE examen_practico set numero = NEW.numero WHERE id_alumno = OLD.id; \n" +
                "END;");
        BaseDeDatos.execSQL("CREATE TRIGGER insertar_alumnos_en_practicas \n" +
                "\tAFTER INSERT ON alumnos\n" +
                "BEGIN\n" +
                "\tINSERT INTO practicas(id_alumno, numero, grupo, nombre) \n" +
                "    VALUES(NEW.id, NEW.numero, NEW.grupo, NEW.nombre);\n" +
                "END;");
        BaseDeDatos.execSQL("CREATE TRIGGER eliminar_alumnos_de_practicas \n" +
                "\tAFTER DELETE ON alumnos\n" +
                "BEGIN\n" +
                "\tDELETE FROM practicas WHERE id_alumno = OLD.id; \n" +
                "END;");
        BaseDeDatos.execSQL("CREATE TRIGGER actualizar_alumnos_de_practicas \n" +
                "\tAFTER UPDATE ON alumnos\n" +
                "BEGIN\n" +
                "\tUPDATE practicas set numero = NEW.numero WHERE id_alumno = OLD.id; \n" +
                "END;");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}