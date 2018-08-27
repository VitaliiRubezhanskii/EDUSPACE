package com.vrubizha.eduspace.aws.s3;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.core.sync.ResponseTransformer;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.nio.ByteBuffer;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class AmazonS3Practice {

//    @Value("{amazon.aws.access-key-id}") private String accessKey;
//    @Value("{amazon.aws.access-key-secret}") private String secretKey;
 private final String accessKey="";
 private final String secretKey="";
 private final Region region=Region.EU_CENTRAL_1;


    // ================ Connection Establishment ======================== //

    private AwsCredentials getAwsCredentials(){
        return AwsBasicCredentials.create(accessKey,secretKey);
    }

    private S3Client getS3Client(){
       return S3Client.builder()
                .credentialsProvider(this::getAwsCredentials)
                .region(region).build();
    }
    // ================================================================== //

    // ================ Bucket  Operations ======================== //

    public void createBucket(String bucketName){
        CreateBucketRequest createBucketRequest=CreateBucketRequest
                .builder()
                .bucket(bucketName)
                .createBucketConfiguration(CreateBucketConfiguration.builder()
                                                                   .locationConstraint(region.toString())
                                                                    .build())
                .build();
        getS3Client().createBucket(createBucketRequest);
        System.out.println("New bucket created "+bucketName);
    }

    public List<String> listBucketNames(){
        return getS3Client().listBuckets().buckets()
                .stream()
                .map(Bucket::name)
                .collect(Collectors.toList());
    }

    public void deleteBucket(String bucketName) {
        DeleteBucketRequest deleteBucketRequest= DeleteBucketRequest.builder().bucket(bucketName).build();
        getS3Client().deleteBucket(deleteBucketRequest);
        System.out.println("Bucket "+bucketName+" deleted successfully");
    }

    // ================================================================== //

    // ================ Bucket Objects Operations ======================== //

    public void uploadObject(String bucketName,String key,String filePath) {
        getS3Client().putObject(PutObjectRequest
                .builder()
                .bucket(bucketName)
                .key(key)
                .build(), Paths.get(filePath));
    }

    // ---- Here multipart upload will be practiced ---- //

    public void downloadObject(String bucketName,String key,String downloadPath){
        getS3Client().getObject(GetObjectRequest
                .builder()
                .bucket(bucketName)
                .key(key)
                .build(),ResponseTransformer.toFile(Paths.get(downloadPath+"/"+key+".pdf")));
    }

    public void copyObject(String locationBucket,String locationKey,String destinationBucket,String destinationKey){
        getS3Client().copyObject(CopyObjectRequest
                .builder()
                .copySource(locationBucket+"/"+locationKey)
                .bucket(destinationBucket)
                .key(destinationKey)
                .build());
    }
    public void moveObject(String locationBucket,String locationKey,String destinationBucket,String destinationKey){
        getS3Client().copyObject(CopyObjectRequest
                .builder()
                .copySource(locationBucket+"/"+locationKey)
                .bucket(destinationBucket)
                .key(destinationKey)
                .build());
        deleteObject(locationBucket,locationKey);
    }


    public void deleteObject(String bucketName,String key){
        getS3Client().deleteObject(DeleteObjectRequest
                .builder()
                .bucket(bucketName)
                .key(key)
                .build());
    }

    public static void main(String[] args) {
        AmazonS3Practice amazonS3Practice=new AmazonS3Practice();
//        amazonS3Practice.createBucket("vitalikbucketbyjdk");
//        amazonS3Practice.uploadObject("vitalikbucketbyjdk","newfile","/home/user/Downloads/frontend1.pdf");
//        amazonS3Practice.downloadObject("vitalikbucketbyjdk","newfile","/home/user/Documents/Books");
//        amazonS3Practice.copyObject("vitalikbucketbyjdk","newfile","eduspace","copiedfile");
//        amazonS3Practice.moveObject("vitalikbucketbyjdk","newfile","eduspace","copiedfile");
        amazonS3Practice.deleteBucket("vitalikbucketbyjdk");

//        System.out.println("buckets: "+amazonS3Practice.listBucketNames());
    }

    private static ByteBuffer getRandomByteBuffer(int size) {
        byte[] b = new byte[size];
        new Random().nextBytes(b);
        return ByteBuffer.wrap(b);
    }

}
