package com.GRS.services;

import org.springframework.web.multipart.MultipartFile;

public interface FirebaseStorageService {

    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    //El BuketName es el <id_del_proyecto> + ".appspot.com"
    final String BucketName = "proyecto-grs-914c8.firebasestorage.app";

    //Esta es la ruta básica de este proyecto GRS
    final String rutaSuperiorStorage = "GRS Construcciones";

    //Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile = "firebase";
    
    //El nombre del archivo Json
    final String archivoJsonFile = "proyecto-grs-914c8-firebase-adminsdk-fbsvc-4d94a964b1"+".json";
}