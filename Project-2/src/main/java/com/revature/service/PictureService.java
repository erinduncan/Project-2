package com.revature.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.annotation.PostConstruct;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class PictureService{

	private AmazonS3 s3client;

    // @Value("${amazonProperties.endpointUrl}")
    private String endpointUrl = "https://s3.us-east-2.amazonaws.com";
    // @Value("${amazonProperties.bucketName}")
    private String bucketName = "raphael-bucket-user";
    // @Value("${amazonProperties.accessKey}")
    private String accessKey = "AKIAUNCGQM2XN7ZFZSMR";
    // @Value("${amazonProperties.secretKey}")
    private String secretKey = "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";
    // @Value("${amazonProperties.region}")
    private String region = "us-east-2";
    
    @PostConstruct
    private void initializeAmazon() {

        BasicAWSCredentials creds = new BasicAWSCredentials(this.accessKey, this.secretKey);
        s3client = AmazonS3ClientBuilder.standard().withRegion(this.region)
			.withCredentials(new AWSStaticCredentialsProvider(creds)).build();
    }

    public String upload(MultipartFile multipartFile) {
        String fileUrl = "";
        try {
            File file = convertMultiPartToFile(multipartFile);
            String fileName = generateFileName(multipartFile);
            fileUrl = endpointUrl + "/" + bucketName + "/" + fileName;
            uploadFileTos3bucket(fileName, file);
            file.delete();
        } catch (Exception e) {
           e.printStackTrace();
        }
        return fileUrl;
    }

    //
    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
    //generate unique name to the uploadfile
    private String generateFileName(MultipartFile multiPart) {
        return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_");
    }

    //upload files to s3
    private void uploadFileTos3bucket(String fileName, File file) {
        s3client.putObject(new PutObjectRequest(bucketName, fileName, file)
                .withCannedAcl(CannedAccessControlList.PublicRead));
    }


}