package com.conectavip_hp.conectavip_hp.config;

import com.conectavip_hp.conectavip_hp.ports.out.FileStoragePort;
import io.github.cdimascio.dotenv.Dotenv;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.core.sync.RequestBody;
import java.io.File;
import java.nio.file.Paths;

public class S3Config implements FileStoragePort {
    private final S3Client s3Client;
    private final String bucketName;

    public S3Config() {
        // Carrega o arquivo .env
        Dotenv dotenv = Dotenv.load();

        // Obtém as credenciais e região do arquivo .env
        String accessKeyId = dotenv.get("AWS_ACCESS_KEY_ID");
        String secretAccessKey = dotenv.get("AWS_SECRET_ACCESS_KEY");
        String region = dotenv.get("AWS_REGION");

        // Configura as credenciais e cria o cliente do S3
        AwsBasicCredentials awsCredentials = AwsBasicCredentials.create(accessKeyId, secretAccessKey);

        this.s3Client = S3Client.builder()
                .credentialsProvider(StaticCredentialsProvider.create(awsCredentials))
                .region(software.amazon.awssdk.regions.Region.of(region))
                .build();
        
        this.bucketName = "vipbucket--use1-az6--x-s3"; // Nome do seu bucket
    }

    public String uploadFile(String filePath, String keyName) {
        try {
            File file = Paths.get(filePath).toFile();
            if (!file.exists()) {
                throw new IllegalArgumentException("Arquivo não encontrado: " + filePath);
            }

            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(keyName)
                    .build();

            s3Client.putObject(putObjectRequest, RequestBody.fromFile(file));

            // Retorna a URL do objeto salvo
            return String.format("https://%s.s3.amazonaws.com/%s", bucketName, keyName);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar arquivo no S3: " + e.getMessage(), e);
        }
    }

    public void close() {
        s3Client.close();
    }
}
