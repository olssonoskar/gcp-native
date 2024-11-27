# gcp-native
Spring native on GCP

Build image with the following

    ./mvnw -Pnative spring-boot:build-image -Dspring-boot.build-image.imagePlatform=linux/amd64

Native profile with Springs image builder, targeting amd64 platform for compatibility with GCP (if building on arm)

    docker tag image:tag repo-url/image:tag
    docker push <tagged image>

You can then deploy the image from artifact registry

#### TODO Cloud build and instant deploy