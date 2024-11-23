# ベースイメージとして、AdoptOpenJDKのJDK 21を使用
FROM eclipse-temurin:21-jdk

# 作業ディレクトリを作成
WORKDIR /app

# ローカルマシンからjarファイルをコンテナにコピー
COPY target/helloworld-0.0.1-SNAPSHOT.jar /app/app.jar

# アプリケーションを実行するエントリーポイント
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
