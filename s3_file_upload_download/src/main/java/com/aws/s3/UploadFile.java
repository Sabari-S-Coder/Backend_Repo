package com.aws.s3;

import java.nio.file.Paths;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

/**
 * Hello world!
 *
 */
public class UploadFile 
{
    public static void main( String[] args )
    {
        S3Client client = S3Client.builder().region(Region.US_EAST_1).credentialsProvider(ProfileCredentialsProvider.create()).build();

        PutObjectRequest objectRequest = PutObjectRequest.builder()
                                            .bucket("aws-fileupload-download-bucket")
                                            .key("/S3FileManager/upload-file.txt") //file path which need to upload
                                            .build();

        client.putObject(objectRequest, RequestBody.fromFile(Paths.get("/workspace/Backend_Repo/s3_file_upload_download/upload-file.txt")));
        System.out.println("✅ File uploaded successfully.");
        client.close();
            
    
    }
}
