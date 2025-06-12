package com.aws.s3;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;

public class DownloadFile {

    public static void main(String[] args) throws Exception{
        Path destinationPath = Paths.get("/workspace/Backend_Repo/s3_file_upload_download/my_file.txt");

        Files.createDirectories(destinationPath.getParent());

        S3Client client = S3Client.builder().region(Region.US_EAST_1).credentialsProvider(ProfileCredentialsProvider.create()).build();

        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                                            .bucket("aws-fileupload-download-bucket")
                                            .key("/S3FileManager/upload-file.txt") //file path which need to download
                                            .build();

        client.getObject(getObjectRequest, destinationPath);
        System.out.println("✅ File downloaded successfully.");
        client.close();

    }
    
}
