package com.example.appclase;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.time.LocalDate;

public class BaseDatos extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 1;
    MiAplicacion miAplicacion;
    String nombreDB;


    private final ActivityResultLauncher<String> filePickerLauncher = registerForActivityResult(
            new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri uri) {
                    if (uri != null) {
                        // El usuario ha seleccionado un archivo, ahora puedes manejarlo
                        // La URI del archivo seleccionado estará en uri
                        importDatabaseFromUri(uri);
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basedatos);

        miAplicacion = (MiAplicacion) getApplication();
        nombreDB = miAplicacion.getBaseDatosActual();
    }


    public void exportarAEspecifica(View view) throws IOException {
        String fecha = String.valueOf(LocalDate.now());

        // Verifica si se tienen los permisos y solicítalos si no
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
                return;
            }
        }

        // Obtén la ruta de la carpeta de documentos en la tarjeta SD
        File raiz = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);

        // Asegúrate de que la carpeta exista
        if (!raiz.exists()) {
            raiz.mkdirs(); // Crea la carpeta si no existe
        }

        // Define la ruta de destino en la carpeta de copias de seguridad
        File directoriocopia = new File(raiz, "copiasdeseguridad");

        // Asegúrate de que la carpeta exista
        if (!directoriocopia.exists()) {
            directoriocopia.mkdirs(); // Crea la carpeta si no existe
        }

        // Define la ruta de destino en la carpeta de copias de seguridad
        File backupDB4 = new File(directoriocopia, "backupDBappclase" + fecha + ".db");

        File data = Environment.getDataDirectory();
        String pathData = "/data/" + getPackageName() + "/databases/" + nombreDB;
        File currentDB = new File(data, pathData);

        // Resto de tu código para exportar la base de datos
        if (currentDB.exists()) {
            FileChannel src = new FileInputStream(currentDB).getChannel();
            FileChannel dst = new FileOutputStream(backupDB4).getChannel();
            dst.transferFrom(src, 0, src.size());
            src.close();
            dst.close();
            Toast.makeText(this, "Base de datos exportada a carpeta Documents/copiasdeseguridad", Toast.LENGTH_SHORT).show();
        }
    }


    private void importarDesdeFija() throws IOException {

        // Verifica si se tienen los permisos y solicítalos si no
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
                return;
            }
        }

        // Obtén la ruta de la carpeta de documentos
        File raiz = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);

        // Asegúrate de que la carpeta exista
        if (!raiz.exists()) {
            raiz.mkdirs(); // Crea la carpeta si no existe
        }

        // Define la ruta de origen en la carpeta de copias de seguridad
        File directoriocopia = new File(raiz, "copiasdeseguridad");

        // Asegúrate de que la carpeta exista
        if (!directoriocopia.exists()) {
            directoriocopia.mkdirs(); // Crea la carpeta si no existe
        }

        // Define la ruta de origen en la carpeta de copias de seguridad
        File backupDB4 = new File(directoriocopia, nombreDB);

        //ruta en destino en carpeta de la app
        File data = Environment.getDataDirectory();
        String pathData = "/data/" + getPackageName() + "/databases/" + nombreDB;
        File currentDB = new File(data, pathData);

        // Resto de tu código para exportar la base de datos
        if (backupDB4.exists()) {
            FileChannel src = new FileInputStream(backupDB4).getChannel();
            FileChannel dst = new FileOutputStream(currentDB).getChannel();
            dst.transferFrom(src, 0, src.size());

            src.close();
            dst.close();
            Toast.makeText(this, "Base de datos importada a carpeta de la app", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "No existe backupDB4", Toast.LENGTH_SHORT).show();
        }
    }

    public void importarBDAviso(View view) {
        new AlertDialog.Builder(this)
                .setTitle("Confirmación")
                .setMessage("¿Estás seguro de que quieres importar la base de datos?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Aquí es donde llamarías a tu método si el usuario confirma
                        try {
                            importarDesdeFija();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                })
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }



    public void importar(View view) {
        openFileExplorer();
    }

    private void openFileExplorer() {
        filePickerLauncher.launch("*/*"); // Puedes especificar el tipo de archivo aquí
    }

    private void importDatabaseFromUri(Uri uri) {

        MiAplicacion miAplicacion = (MiAplicacion) getApplication();
        String nombreBaseDatos = miAplicacion.getBaseDatosActual();
        // Ruta de la base de datos actual
        String rutaBaseDeDatos = getRealPathFromUri(uri);

        String fecha = String.valueOf(LocalDate.now());

        // Ruta donde se almacenará la copia
        String rutaCopiaBaseDeDatos = getDatabasePath(nombreBaseDatos).getPath();

        try {
            // Abrir la base de datos como flujo de entrada
            FileInputStream inputStream = new FileInputStream(rutaBaseDeDatos);

            // Abrir el archivo de destino como flujo de salida
            FileOutputStream outputStream = new FileOutputStream(rutaCopiaBaseDeDatos);

            // Buffer para leer y escribir datos
            byte[] buffer = new byte[1024];
            int length;

            // Leer de la base de datos y escribir en el archivo
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }

            // Cerrar flujos
            outputStream.flush();
            outputStream.close();
            inputStream.close();

            // Notificar al usuario que se ha exportado la base de datos
            Toast.makeText(this, "Base de datos importada con éxito", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error al importar la base de datos", Toast.LENGTH_SHORT).show();
        }

    }

    public String getRealPathFromUri(Uri uri) {
        String realPath;
        // Check whether the URI is a content:// URI or file:// URI
        if (uri.getScheme().equals("content")) {
            // If it's a content:// URI, try to get the real path using the MediaStore
            String[] projection = {MediaStore.Images.Media.DATA};
            Cursor cursor = null;
            try {
                cursor = getContentResolver().query(uri, projection, null, null, null);
                if (cursor != null && cursor.moveToFirst()) {
                    int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                    realPath = cursor.getString(columnIndex);
                } else {
                    realPath = null;
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        } else if (uri.getScheme().equals("file")) {
            // If it's a file:// URI, directly extract the path
            realPath = uri.getPath();
        } else {
            realPath = null;
        }
        return realPath;
    }

    private void eliminarBaseDatos() {

        Context context = this;

        boolean eliminada = context.deleteDatabase(nombreDB);

        if (eliminada) {
            // La base de datos se eliminó con éxito
            Toast.makeText(this, "SUPUESTAMENTE Base de datos eliminada correctamente", Toast.LENGTH_SHORT).show();
        } else {
            // La base de datos no se pudo eliminar
            Toast.makeText(this, "SUPUESTAMENTE No se pudo eliminar la base de datos", Toast.LENGTH_SHORT).show();
        }
    }


    public void eliminarBDAviso(View view) {
        new AlertDialog.Builder(this)
                .setTitle("Confirmación")
                .setMessage("¿Estás seguro de que quieres eliminar la base de datos?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Aquí es donde llamarías a tu método si el usuario confirma
                        eliminarBaseDatos();
                    }
                })
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    public void enviaraFirebase(View view) {

        // Inicializa Firebase
        FirebaseApp.initializeApp(this);

        // Ejemplo de autenticación anónima (puedes usar otros métodos de autenticación)
        FirebaseAuth.getInstance().signInAnonymously()
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        // Autenticación exitosa
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Manejar errores de autenticación
                    }
                });

        // Obtén una referencia al almacenamiento de Firebase
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();
        String fecha = String.valueOf(LocalDate.now());

        // Ruta en Firebase Storage donde se almacenará la base de datos
        StorageReference dbRef = storageRef.child("backupDBappclase"+fecha+".db");

        // Ruta de la base de datos local
        File data = Environment.getDataDirectory();
        String pathData = "/data/" + getPackageName() + "/databases/" + nombreDB;
        File currentDB = new File(data, pathData);

// Sube el archivo de la base de datos a Firebase Storage
        try {
            InputStream stream = new FileInputStream(currentDB);
            UploadTask uploadTask = dbRef.putStream(stream);
            uploadTask.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    // Manejar fallos
                    Log.e("UPLOAD", "Error al subir la base de datos: " + exception.getMessage());
                }
            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    // Éxito al subir la base de datos
                    Log.d("UPLOAD", "Base de datos subida exitosamente.");
                }
            });
            Toast.makeText(this, "Base de datos subida", Toast.LENGTH_SHORT).show();
        } catch (
                FileNotFoundException e) {
            Log.e("UPLOAD", "Error al acceder a la base de datos local: " + e.getMessage());
        }
    }


    public void volver(View view) {
        Intent i = new Intent(this, OpcionesGrupo.class);
        startActivity(i);

    }


}