# ベースイメージとしてMavenを使用し、ビルド用のコンテナを設定
FROM maven:3.8.6-eclipse-temurin-21 as build

# 作業ディレクトリを作成
WORKDIR /app

# プロジェクトの依存関係とソースコードをコンテナにコピー
COPY pom.xml /app/
COPY src /app/src

# プロジェクトをビルド
RUN mvn clean package -DskipTests

# 実行用の軽量JDKイメージを設定
FROM eclipse-temurin:21-jdk-alpine

# 作業ディレクトリを設定
WORKDIR /app

# ビルドステージからビルド済みのjarファイルをコピー
COPY --from=build /app/target/helloworld-0.0.1-SNAPSHOT.jar /app/app.jar

# アプリケーションを実行するエントリーポイントを設定
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
