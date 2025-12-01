# 1. ベースイメージ: Java 21の軽量なJDKイメージを使用します
FROM eclipse-temurin:21-jdk-alpine

# 2. JARファイルパスの指定
# MavenでビルドされるJARファイル名に合わせてください
# プロジェクト名がdb_testなら、ターゲットファイル名は通常 db_test-0.0.1-SNAPSHOT.jar です
ARG JAR_FILE=target/db_test-0.0.1-SNAPSHOT.jar

# 3. JARファイルをコンテナ内にコピー
COPY ${JAR_FILE} app.jar

# 4. 実行コマンドの設定
# コンテナ起動時にSpring Bootアプリケーション（app.jar）を実行します
ENTRYPOINT ["java", "-jar", "/app.jar"]

# 5. ポートの公開 (これはドキュメントとしてのみ。Renderは自動でマップします)
EXPOSE 8080