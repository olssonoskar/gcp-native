# Not currently working

# Build phase
FROM container-registry.oracle.com/graalvm/native-image:22 AS builder
WORKDIR /build
COPY . /build
RUN ./mvnw package -Pnative

# Run phase
FROM oraclelinux:9-slim
EXPOSE 8080
COPY --from=builder /build/target/gcp app/gcp

ENTRYPOINT ["/app/gcp"]